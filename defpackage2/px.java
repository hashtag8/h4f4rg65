package defpackage;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class px {
    static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final short[] b = {10, 20, 30, 60, 120, 300};
    private final Object c = new Object();
    private final pb d;
    private final String e;
    private final c f;
    private final b g;
    private Thread h;

    interface b {
        boolean a();
    }

    interface c {
        File[] a();

        File[] b();

        File[] c();
    }

    interface d {
        boolean a();
    }

    static final class a implements d {
        a() {
        }

        @Override // px.d
        public boolean a() {
            return true;
        }
    }

    public px(String str, pb pbVar, c cVar, b bVar) {
        if (pbVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.d = pbVar;
        this.e = str;
        this.f = cVar;
        this.g = bVar;
    }

    public synchronized void a(float f, d dVar) {
        if (this.h != null) {
            blh.h().a("CrashlyticsCore", "Report upload has already been started.");
        } else {
            this.h = new Thread(new e(f, dVar), "Crashlytics Report Uploader");
            this.h.start();
        }
    }

    boolean a(pw pwVar) {
        boolean zA;
        boolean z = false;
        synchronized (this.c) {
            try {
                zA = this.d.a(new pa(this.e, pwVar));
                blh.h().c("CrashlyticsCore", "Crashlytics report upload " + (zA ? "complete: " : "FAILED: ") + pwVar.b());
            } catch (Exception e2) {
                blh.h().e("CrashlyticsCore", "Error occurred sending report " + pwVar, e2);
            }
            if (zA) {
                pwVar.f();
                z = true;
            }
        }
        return z;
    }

    List<pw> a() {
        File[] fileArrA;
        File[] fileArrB;
        File[] fileArrC;
        blh.h().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.c) {
            fileArrA = this.f.a();
            fileArrB = this.f.b();
            fileArrC = this.f.c();
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrA != null) {
            for (File file : fileArrA) {
                blh.h().a("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new pz(file));
            }
        }
        HashMap map = new HashMap();
        if (fileArrB != null) {
            for (File file2 : fileArrB) {
                String strA = os.a(file2);
                if (!map.containsKey(strA)) {
                    map.put(strA, new LinkedList());
                }
                ((List) map.get(strA)).add(file2);
            }
        }
        for (String str : map.keySet()) {
            blh.h().a("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) map.get(str);
            linkedList.add(new ph(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (fileArrC != null) {
            for (File file3 : fileArrC) {
                linkedList.add(new pp(file3));
            }
        }
        if (linkedList.isEmpty()) {
            blh.h().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    class e extends bmd {
        private final float b;
        private final d c;

        e(float f, d dVar) {
            this.b = f;
            this.c = dVar;
        }

        @Override // defpackage.bmd
        public void a() {
            try {
                b();
            } catch (Exception e) {
                blh.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            px.this.h = null;
        }

        private void b() {
            blh.h().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
            if (this.b > 0.0f) {
                try {
                    Thread.sleep((long) (this.b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<pw> listA = px.this.a();
            if (!px.this.g.a()) {
                if (!listA.isEmpty() && !this.c.a()) {
                    blh.h().a("CrashlyticsCore", "User declined to send. Removing " + listA.size() + " Report(s).");
                    Iterator<pw> it = listA.iterator();
                    while (it.hasNext()) {
                        it.next().f();
                    }
                    return;
                }
                List<pw> list = listA;
                int i = 0;
                while (!list.isEmpty() && !px.this.g.a()) {
                    blh.h().a("CrashlyticsCore", "Attempting to send " + list.size() + " report(s)");
                    Iterator<pw> it2 = list.iterator();
                    while (it2.hasNext()) {
                        px.this.a(it2.next());
                    }
                    List<pw> listA2 = px.this.a();
                    if (listA2.isEmpty()) {
                        list = listA2;
                    } else {
                        int i2 = i + 1;
                        long j = px.b[Math.min(i, px.b.length - 1)];
                        blh.h().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                            list = listA2;
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            }
        }
    }
}
