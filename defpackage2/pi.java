package defpackage;

import android.content.Context;
import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class pi {
    private static final b a = new b();
    private final Context b;
    private final a c;
    private pg d;

    public interface a {
        File a();
    }

    pi(Context context, a aVar) {
        this(context, aVar, null);
    }

    pi(Context context, a aVar, String str) {
        this.b = context;
        this.c = aVar;
        this.d = a;
        a(str);
    }

    final void a(String str) {
        this.d.c();
        this.d = a;
        if (str != null) {
            if (!bme.a(this.b, "com.crashlytics.CollectCustomLogs", true)) {
                blh.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                a(b(str), 65536);
            }
        }
    }

    void a(long j, String str) {
        this.d.a(j, str);
    }

    ol a() {
        return this.d.a();
    }

    byte[] b() {
        return this.d.b();
    }

    void c() {
        this.d.d();
    }

    void a(Set<String> set) {
        File[] fileArrListFiles = this.c.a().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!set.contains(a(file))) {
                    file.delete();
                }
            }
        }
    }

    void a(File file, int i) {
        this.d = new pu(file, i);
    }

    private File b(String str) {
        return new File(this.c.a(), "crashlytics-userlog-" + str + ".temp");
    }

    private String a(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".temp");
        return iLastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), iLastIndexOf);
    }

    static final class b implements pg {
        private b() {
        }

        @Override // defpackage.pg
        public void a(long j, String str) {
        }

        @Override // defpackage.pg
        public ol a() {
            return null;
        }

        @Override // defpackage.pg
        public byte[] b() {
            return null;
        }

        @Override // defpackage.pg
        public void c() {
        }

        @Override // defpackage.pg
        public void d() {
        }
    }
}
