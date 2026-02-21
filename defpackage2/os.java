package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import defpackage.bmf;
import defpackage.bml;
import defpackage.oq;
import defpackage.oz;
import defpackage.pi;
import defpackage.px;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class os {
    static final FilenameFilter a = new d("BeginSession") { // from class: os.1
        @Override // os.d, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };
    static final FilenameFilter b = new FilenameFilter() { // from class: os.10
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    };
    static final FileFilter c = new FileFilter() { // from class: os.17
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };
    static final Comparator<File> d = new Comparator<File>() { // from class: os.18
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final Comparator<File> e = new Comparator<File>() { // from class: os.19
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    private static final Pattern f = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> g = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] h = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger i = new AtomicInteger(0);
    private final ot j;
    private final or k;
    private final bnw l;
    private final bml m;
    private final pr n;
    private final bob o;
    private final oi p;
    private final g q;
    private final pi r;
    private final px.c s;
    private final px.b t;
    private final pe u;
    private final qb v;
    private final String w;
    private final oj x;
    private final nh y;
    private oz z;

    interface b {
        void a(oo ooVar);
    }

    interface e {
        void a(FileOutputStream fileOutputStream);
    }

    static class d implements FilenameFilter {
        private final String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && !str.endsWith(".cls_temp");
        }
    }

    static class l implements FilenameFilter {
        private final String a;

        public l(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (str.equals(new StringBuilder().append(this.a).append(".cls").toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    static class a implements FilenameFilter {
        private a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !os.b.accept(file, str) && os.f.matcher(str).matches();
        }
    }

    static class f implements FilenameFilter {
        f() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return on.a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    os(ot otVar, or orVar, bnw bnwVar, bml bmlVar, pr prVar, bob bobVar, oi oiVar, qd qdVar, oj ojVar, nh nhVar) {
        this.j = otVar;
        this.k = orVar;
        this.l = bnwVar;
        this.m = bmlVar;
        this.n = prVar;
        this.o = bobVar;
        this.p = oiVar;
        this.w = qdVar.a();
        this.x = ojVar;
        this.y = nhVar;
        Context contextR = otVar.r();
        this.q = new g(bobVar);
        this.r = new pi(contextR, this.q);
        this.s = new i();
        this.t = new j();
        this.u = new pe(contextR);
        this.v = new pl(1024, new pv(10));
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        a();
        this.z = new oz(new oz.a() { // from class: os.20
            @Override // oz.a
            public void a(oz.b bVar, Thread thread, Throwable th, boolean z2) {
                os.this.a(bVar, thread, th, z2);
            }
        }, new c(), z, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.z);
    }

    synchronized void a(final oz.b bVar, final Thread thread, final Throwable th, final boolean z) {
        blh.h().a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.u.c();
        final Date date = new Date();
        this.k.a(new Callable<Void>() { // from class: os.21
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Throwable {
                bor borVar;
                bou bouVar;
                os.this.j.o();
                os.this.a(date, thread, th);
                boy boyVarA = bVar.a();
                if (boyVarA != null) {
                    bouVar = boyVarA.b;
                    borVar = boyVarA.d;
                } else {
                    borVar = null;
                    bouVar = null;
                }
                if ((borVar == null || borVar.e) || z) {
                    os.this.a(date.getTime());
                }
                os.this.b(bouVar);
                os.this.o();
                if (bouVar != null) {
                    os.this.a(bouVar.g);
                }
                if (!os.this.b(boyVarA)) {
                    os.this.c(boyVarA);
                }
                return null;
            }
        });
    }

    void a(float f2, boy boyVar) {
        if (boyVar == null) {
            blh.h().d("CrashlyticsCore", "Could not send reports. Settings are not available.");
        } else {
            new px(this.p.a, b(boyVar.a.d, boyVar.a.e), this.s, this.t).a(f2, b(boyVar) ? new h(this.j, this.n, boyVar.c) : new px.a());
        }
    }

    void a(final long j2, final String str) {
        this.k.b(new Callable<Void>() { // from class: os.22
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                if (!os.this.f()) {
                    os.this.r.a(j2, str);
                    return null;
                }
                return null;
            }
        });
    }

    void a() {
        this.k.b(new Callable<Void>() { // from class: os.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Throwable {
                os.this.o();
                return null;
            }
        });
    }

    private String m() {
        File[] fileArrP = p();
        if (fileArrP.length > 0) {
            return a(fileArrP[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        File[] fileArrP = p();
        if (fileArrP.length > 1) {
            return a(fileArrP[1]);
        }
        return null;
    }

    static String a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean a(final bou bouVar) {
        return ((Boolean) this.k.a(new Callable<Boolean>() { // from class: os.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Throwable {
                if (os.this.f()) {
                    blh.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                blh.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
                os.this.a(bouVar, true);
                blh.h().a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() throws Throwable {
        Date date = new Date();
        String string = new om(this.m).toString();
        blh.h().a("CrashlyticsCore", "Opening a new session with ID " + string);
        a(string, date);
        c(string);
        d(string);
        e(string);
        this.r.a(string);
    }

    void b(bou bouVar) throws Throwable {
        a(bouVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bou bouVar, boolean z) throws Throwable {
        int i2 = z ? 1 : 0;
        b(i2 + 8);
        File[] fileArrP = p();
        if (fileArrP.length <= i2) {
            blh.h().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        f(a(fileArrP[i2]));
        if (bouVar == null) {
            blh.h().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            a(fileArrP, i2, bouVar.c);
        }
    }

    private void a(File[] fileArr, int i2, int i3) throws Throwable {
        blh.h().a("CrashlyticsCore", "Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String strA = a(file);
            blh.h().a("CrashlyticsCore", "Closing session: " + strA);
            a(file, strA, i3);
            i2++;
        }
    }

    private void a(on onVar) {
        if (onVar != null) {
            try {
                onVar.a();
            } catch (IOException e2) {
                blh.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                b(file2);
            }
        }
        file.delete();
    }

    private void a(String str) {
        for (File file : b(str)) {
            file.delete();
        }
    }

    private File[] b(String str) {
        return a(new l(str));
    }

    File[] b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, a(h(), b));
        Collections.addAll(linkedList, a(i(), b));
        Collections.addAll(linkedList, a(g(), b));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] c() {
        return a(c);
    }

    File[] d() {
        return a(a);
    }

    private File[] p() {
        File[] fileArrD = d();
        Arrays.sort(fileArrD, d);
        return fileArrD;
    }

    private File[] a(FileFilter fileFilter) {
        return b(g().listFiles(fileFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] a(FilenameFilter filenameFilter) {
        return a(g(), filenameFilter);
    }

    private File[] a(File file, FilenameFilter filenameFilter) {
        return b(file.listFiles(filenameFilter));
    }

    private File[] c(File file) {
        return b(file.listFiles());
    }

    private File[] b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void a(String str, int i2) {
        qf.a(g(), new d(str + "SessionEvent"), i2, e);
    }

    void a(int i2) {
        int iA = i2 - qf.a(h(), i2, e);
        qf.a(g(), b, iA - qf.a(i(), iA, e), e);
    }

    private void b(int i2) {
        HashSet hashSet = new HashSet();
        File[] fileArrP = p();
        int iMin = Math.min(i2, fileArrP.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            hashSet.add(a(fileArrP[i3]));
        }
        this.r.a(hashSet);
        a(a(new a()), hashSet);
    }

    private void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f.matcher(name);
            if (!matcher.matches()) {
                blh.h().a("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                blh.h().a("CrashlyticsCore", "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    private File[] a(String str, File[] fileArr, int i2) {
        if (fileArr.length > i2) {
            blh.h().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
            a(str, i2);
            return a(new d(str + "SessionEvent"));
        }
        return fileArr;
    }

    void e() {
        this.k.a(new Runnable() { // from class: os.4
            @Override // java.lang.Runnable
            public void run() {
                os.this.a(os.this.a(new f()));
            }
        });
    }

    void a(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            blh.h().a("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(a(file));
        }
        if (!hashSet.isEmpty()) {
            File fileJ = j();
            if (!fileJ.exists()) {
                fileJ.mkdir();
            }
            for (File file2 : a(new FilenameFilter() { // from class: os.5
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                blh.h().a("CrashlyticsCore", "Moving session file: " + file2);
                if (!file2.renameTo(new File(fileJ, file2.getName()))) {
                    blh.h().a("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
            }
            q();
        }
    }

    private void q() {
        File fileJ = j();
        if (fileJ.exists()) {
            File[] fileArrA = a(fileJ, new f());
            Arrays.sort(fileArrA, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < fileArrA.length && hashSet.size() < 4; i2++) {
                hashSet.add(a(fileArrA[i2]));
            }
            a(c(fileJ), hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, File file, String str) throws Throwable {
        byte[] bArrB = po.b(file);
        byte[] bArrC = po.c(file);
        byte[] bArrA = po.a(file, context);
        if (bArrB == null || bArrB.length == 0) {
            blh.h().d("CrashlyticsCore", "No minidump data found in directory " + file);
            return;
        }
        c(str, "<native-crash: minidump>");
        byte[] bArrA2 = a(str, "BeginSession.json");
        byte[] bArrA3 = a(str, "SessionApp.json");
        byte[] bArrA4 = a(str, "SessionDevice.json");
        byte[] bArrA5 = a(str, "SessionOS.json");
        byte[] bArrA6 = po.a(new pk(g()).b(str));
        pi piVar = new pi(this.j.r(), this.q, str);
        byte[] bArrB2 = piVar.b();
        piVar.c();
        byte[] bArrA7 = po.a(new pk(g()).c(str));
        File file2 = new File(this.o.a(), str);
        if (!file2.mkdir()) {
            blh.h().a("CrashlyticsCore", "Couldn't create native sessions directory");
            return;
        }
        a(bArrB, new File(file2, "minidump"));
        a(bArrC, new File(file2, "metadata"));
        a(bArrA, new File(file2, "binaryImages"));
        a(bArrA2, new File(file2, "session"));
        a(bArrA3, new File(file2, "app"));
        a(bArrA4, new File(file2, "device"));
        a(bArrA5, new File(file2, "os"));
        a(bArrA6, new File(file2, "user"));
        a(bArrB2, new File(file2, "logs"));
        a(bArrA7, new File(file2, "keys"));
    }

    boolean a(final ow owVar) {
        if (owVar == null) {
            return true;
        }
        return ((Boolean) this.k.a(new Callable<Boolean>() { // from class: os.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Throwable {
                File fileFirst;
                TreeSet<File> treeSet = owVar.a;
                String strN = os.this.n();
                if (strN != null && !treeSet.isEmpty() && (fileFirst = treeSet.first()) != null) {
                    os.this.a(os.this.j.r(), fileFirst, strN);
                }
                os.this.a(treeSet);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void a(byte[] bArr, File file) throws Throwable {
        if (bArr != null && bArr.length > 0) {
            b(bArr, file);
        }
    }

    private void b(byte[] bArr, File file) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bme.a(gZIPOutputStream);
            } catch (Throwable th) {
                th = th;
                bme.a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public void a(Date date, Thread thread, Throwable th) throws Throwable {
        ?? r2;
        oo ooVarA = null;
        try {
            String strM = m();
            if (strM == null) {
                blh.h().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                bme.a((Flushable) null, "Failed to flush to session begin file.");
                bme.a((Closeable) null, "Failed to close fatal exception file output stream.");
            } else {
                c(strM, th.getClass().getName());
                on onVar = new on(g(), strM + "SessionCrash");
                try {
                    ooVarA = oo.a(onVar);
                    a(ooVarA, date, thread, th, "crash", true);
                    bme.a(ooVarA, "Failed to flush to session begin file.");
                    bme.a((Closeable) onVar, "Failed to close fatal exception file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    r2 = onVar;
                    try {
                        blh.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        bme.a(ooVarA, "Failed to flush to session begin file.");
                        bme.a((Closeable) r2, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        th = th2;
                        bme.a(ooVarA, "Failed to flush to session begin file.");
                        bme.a((Closeable) r2, "Failed to close fatal exception file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r2 = onVar;
                    bme.a(ooVarA, "Failed to flush to session begin file.");
                    bme.a((Closeable) r2, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            r2 = ooVarA;
        } catch (Throwable th4) {
            th = th4;
            r2 = ooVarA;
        }
    }

    private void a(String str, String str2, b bVar) throws Throwable {
        on onVar;
        oo ooVarA = null;
        try {
            onVar = new on(g(), str + str2);
        } catch (Throwable th) {
            th = th;
            onVar = null;
        }
        try {
            ooVarA = oo.a(onVar);
            bVar.a(ooVarA);
            bme.a(ooVarA, "Failed to flush to session " + str2 + " file.");
            bme.a((Closeable) onVar, "Failed to close session " + str2 + " file.");
        } catch (Throwable th2) {
            th = th2;
            bme.a(ooVarA, "Failed to flush to session " + str2 + " file.");
            bme.a((Closeable) onVar, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }

    private void a(String str, String str2, e eVar) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(g(), str + str2));
            try {
                eVar.a(fileOutputStream);
                bme.a((Closeable) fileOutputStream, "Failed to close " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                bme.a((Closeable) fileOutputStream, "Failed to close " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private byte[] a(String str, String str2) {
        return po.a(new File(g(), str + str2));
    }

    private void a(final String str, Date date) throws Throwable {
        final String str2 = String.format(Locale.US, "Crashlytics Android SDK/%s", this.j.a());
        final long time = date.getTime() / 1000;
        a(str, "BeginSession", new b() { // from class: os.7
            @Override // os.b
            public void a(oo ooVar) {
                py.a(ooVar, str, str2, time);
            }
        });
        a(str, "BeginSession.json", new e() { // from class: os.8
            @Override // os.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: os.8.1
                    {
                        put("session_id", str);
                        put("generator", str2);
                        put("started_at_seconds", Long.valueOf(time));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void c(String str) throws Throwable {
        final String strC = this.m.c();
        final String str2 = this.p.e;
        final String str3 = this.p.f;
        final String strB = this.m.b();
        final int iA = bmh.a(this.p.c).a();
        a(str, "SessionApp", new b() { // from class: os.9
            @Override // os.b
            public void a(oo ooVar) {
                py.a(ooVar, strC, os.this.p.a, str2, str3, strB, iA, os.this.w);
            }
        });
        a(str, "SessionApp.json", new e() { // from class: os.11
            @Override // os.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: os.11.1
                    {
                        put("app_identifier", strC);
                        put("api_key", os.this.p.a);
                        put("version_code", str2);
                        put("version_name", str3);
                        put("install_uuid", strB);
                        put("delivery_mechanism", Integer.valueOf(iA));
                        put("unity_version", TextUtils.isEmpty(os.this.w) ? "" : os.this.w);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void d(String str) throws Throwable {
        final boolean zG = bme.g(this.j.r());
        a(str, "SessionOS", new b() { // from class: os.12
            @Override // os.b
            public void a(oo ooVar) {
                py.a(ooVar, Build.VERSION.RELEASE, Build.VERSION.CODENAME, zG);
            }
        });
        a(str, "SessionOS.json", new e() { // from class: os.13
            @Override // os.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: os.13.1
                    {
                        put("version", Build.VERSION.RELEASE);
                        put("build_version", Build.VERSION.CODENAME);
                        put("is_rooted", Boolean.valueOf(zG));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void e(String str) throws Throwable {
        Context contextR = this.j.r();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        final int iA = bme.a();
        final int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        final long jB = bme.b();
        final long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        final boolean zF = bme.f(contextR);
        final Map<bml.a, String> mapH = this.m.h();
        final int iH = bme.h(contextR);
        a(str, "SessionDevice", new b() { // from class: os.14
            @Override // os.b
            public void a(oo ooVar) {
                py.a(ooVar, iA, Build.MODEL, iAvailableProcessors, jB, blockCount, zF, (Map<bml.a, String>) mapH, iH, Build.MANUFACTURER, Build.PRODUCT);
            }
        });
        a(str, "SessionDevice.json", new e() { // from class: os.15
            @Override // os.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: os.15.1
                    {
                        put("arch", Integer.valueOf(iA));
                        put("build_model", Build.MODEL);
                        put("available_processors", Integer.valueOf(iAvailableProcessors));
                        put("total_ram", Long.valueOf(jB));
                        put("disk_space", Long.valueOf(blockCount));
                        put("is_emulator", Boolean.valueOf(zF));
                        put("ids", mapH);
                        put("state", Integer.valueOf(iH));
                        put("build_manufacturer", Build.MANUFACTURER);
                        put("build_product", Build.PRODUCT);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void f(String str) throws Throwable {
        final qe qeVarG = g(str);
        a(str, "SessionUser", new b() { // from class: os.16
            @Override // os.b
            public void a(oo ooVar) {
                py.a(ooVar, qeVarG.b, qeVarG.c, qeVarG.d);
            }
        });
    }

    private void a(oo ooVar, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map<String, String> treeMap;
        qc qcVar = new qc(th, this.v);
        Context contextR = this.j.r();
        long time = date.getTime() / 1000;
        Float fC = bme.c(contextR);
        int iA = bme.a(contextR, this.u.b());
        boolean zD = bme.d(contextR);
        int i2 = contextR.getResources().getConfiguration().orientation;
        long jB = bme.b() - bme.b(contextR);
        long jC = bme.c(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoA = bme.a(contextR.getPackageName(), contextR);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = qcVar.c;
        String str2 = this.p.b;
        String strC = this.m.c();
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i3 = 0;
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            while (true) {
                int i4 = i3;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Thread, StackTraceElement[]> next = it.next();
                threadArr[i4] = next.getKey();
                linkedList.add(this.v.a(next.getValue()));
                i3 = i4 + 1;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (!bme.a(contextR, "com.crashlytics.CollectCustomKeys", true)) {
            treeMap = new TreeMap<>();
        } else {
            Map<String, String> mapG = this.j.g();
            treeMap = (mapG == null || mapG.size() <= 1) ? mapG : new TreeMap<>(mapG);
        }
        py.a(ooVar, time, str, qcVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.r, runningAppProcessInfoA, i2, strC, str2, fC, iA, zD, jB, jC);
    }

    private void a(File file, String str, int i2) throws Throwable {
        blh.h().a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] fileArrA = a(new d(str + "SessionCrash"));
        boolean z = fileArrA != null && fileArrA.length > 0;
        blh.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] fileArrA2 = a(new d(str + "SessionEvent"));
        boolean z2 = fileArrA2 != null && fileArrA2.length > 0;
        blh.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            a(file, str, a(str, fileArrA2, i2), z ? fileArrA[0] : null);
        } else {
            blh.h().a("CrashlyticsCore", "No events present for session ID " + str);
        }
        blh.h().a("CrashlyticsCore", "Removing session part files for ID " + str);
        a(str);
    }

    private void a(File file, String str, File[] fileArr, File file2) throws Throwable {
        on onVar;
        oo ooVarA = null;
        boolean z = file2 != null;
        File fileH = z ? h() : i();
        if (!fileH.exists()) {
            fileH.mkdirs();
        }
        try {
            onVar = new on(fileH, str);
        } catch (Exception e2) {
            e = e2;
            onVar = null;
        } catch (Throwable th) {
            th = th;
            onVar = null;
            bme.a(ooVarA, "Error flushing session file stream");
            bme.a((Closeable) onVar, "Failed to close CLS file");
            throw th;
        }
        try {
            try {
                ooVarA = oo.a(onVar);
                blh.h().a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                a(ooVarA, file);
                ooVarA.a(4, new Date().getTime() / 1000);
                ooVarA.a(5, z);
                ooVarA.a(11, 1);
                ooVarA.b(12, 3);
                a(ooVarA, str);
                a(ooVarA, fileArr, str);
                if (z) {
                    a(ooVarA, file2);
                }
                bme.a(ooVarA, "Error flushing session file stream");
                bme.a((Closeable) onVar, "Failed to close CLS file");
            } catch (Throwable th2) {
                th = th2;
                bme.a(ooVarA, "Error flushing session file stream");
                bme.a((Closeable) onVar, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            blh.h().e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
            bme.a(ooVarA, "Error flushing session file stream");
            a(onVar);
        }
    }

    private static void a(oo ooVar, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, bme.a);
        for (File file : fileArr) {
            try {
                blh.h().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                a(ooVar, file);
            } catch (Exception e2) {
                blh.h().e("CrashlyticsCore", "Error writting non-fatal to session.", e2);
            }
        }
    }

    private void a(oo ooVar, String str) throws Throwable {
        for (String str2 : h) {
            File[] fileArrA = a(new d(str + str2 + ".cls"));
            if (fileArrA.length == 0) {
                blh.h().e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                blh.h().a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                a(ooVar, fileArrA[0]);
            }
        }
    }

    private static void a(oo ooVar, File file) throws Throwable {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            blh.h().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            a(fileInputStream, ooVar, (int) file.length());
            bme.a((Closeable) fileInputStream, "Failed to close file input stream.");
        } catch (Throwable th2) {
            th = th2;
            bme.a((Closeable) fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    private static void a(InputStream inputStream, oo ooVar, int i2) throws IOException {
        int i3;
        byte[] bArr = new byte[i2];
        int i4 = 0;
        while (i4 < bArr.length && (i3 = inputStream.read(bArr, i4, bArr.length - i4)) >= 0) {
            i4 += i3;
        }
        ooVar.a(bArr);
    }

    private qe g(String str) {
        return f() ? new qe(this.j.h(), this.j.j(), this.j.i()) : new pk(g()).a(str);
    }

    boolean f() {
        return this.z != null && this.z.a();
    }

    File g() {
        return this.o.a();
    }

    File h() {
        return new File(g(), "fatal-sessions");
    }

    File i() {
        return new File(g(), "nonfatal-sessions");
    }

    File j() {
        return new File(g(), "invalidClsFiles");
    }

    void a(boy boyVar) {
        if (boyVar.d.e && this.x.a()) {
            blh.h().a("CrashlyticsCore", "Registered Firebase Analytics event listener");
        }
    }

    void k() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(boy boyVar) {
        return (boyVar == null || !boyVar.d.a || this.n.a()) ? false : true;
    }

    private pb b(String str, String str2) {
        String strB = bme.b(this.j.r(), "com.crashlytics.ApiEndpoint");
        return new op(new pd(this.j, strB, str, this.l), new pn(this.j, strB, str2, this.l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boy boyVar) {
        if (boyVar == null) {
            blh.h().d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context contextR = this.j.r();
        px pxVar = new px(this.p.a, b(boyVar.a.d, boyVar.a.e), this.s, this.t);
        for (File file : b()) {
            this.k.a(new k(contextR, new pz(file, g), pxVar));
        }
    }

    private static void c(String str, String str2) {
        mu muVar = (mu) blh.a(mu.class);
        if (muVar == null) {
            blh.h().a("CrashlyticsCore", "Answers is not available");
        } else {
            muVar.a(new bmf.a(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (r()) {
            blh.h().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.y != null) {
            blh.h().a("CrashlyticsCore", "Logging Crashlytics event to Firebase");
            Bundle bundle = new Bundle();
            bundle.putInt("_r", 1);
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", j2);
            this.y.a("clx", "_ae", bundle);
            return;
        }
        blh.h().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }

    private boolean r() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    final class j implements px.b {
        private j() {
        }

        @Override // px.b
        public boolean a() {
            return os.this.f();
        }
    }

    final class i implements px.c {
        private i() {
        }

        @Override // px.c
        public File[] a() {
            return os.this.b();
        }

        @Override // px.c
        public File[] b() {
            return os.this.j().listFiles();
        }

        @Override // px.c
        public File[] c() {
            return os.this.c();
        }
    }

    static final class h implements px.d {
        private final bln a;
        private final pr b;
        private final bot c;

        public h(bln blnVar, pr prVar, bot botVar) {
            this.a = blnVar;
            this.b = prVar;
            this.c = botVar;
        }

        @Override // px.d
        public boolean a() {
            Activity activityB = this.a.s().b();
            if (activityB == null || activityB.isFinishing()) {
                return true;
            }
            final oq oqVarA = oq.a(activityB, this.c, new oq.a() { // from class: os.h.1
                @Override // oq.a
                public void a(boolean z) {
                    h.this.b.a(z);
                }
            });
            activityB.runOnUiThread(new Runnable() { // from class: os.h.2
                @Override // java.lang.Runnable
                public void run() {
                    oqVarA.a();
                }
            });
            blh.h().a("CrashlyticsCore", "Waiting for user opt-in.");
            oqVarA.b();
            return oqVarA.c();
        }
    }

    static final class k implements Runnable {
        private final Context a;
        private final pw b;
        private final px c;

        public k(Context context, pw pwVar, px pxVar) {
            this.a = context;
            this.b = pwVar;
            this.c = pxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bme.n(this.a)) {
                blh.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.c.a(this.b);
            }
        }
    }

    static final class g implements pi.a {
        private final bob a;

        public g(bob bobVar) {
            this.a = bobVar;
        }

        @Override // pi.a
        public File a() {
            File file = new File(this.a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    static final class c implements oz.b {
        private c() {
        }

        @Override // oz.b
        public boy a() {
            return bov.a().b();
        }
    }
}
