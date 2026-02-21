package defpackage;

import defpackage.uq;

/* JADX INFO: loaded from: classes.dex */
public class uz extends uq<tp> {

    static class a implements uq.a<tp> {
        private final uf a;
        private final tp b = new tp();

        public a(uf ufVar) {
            this.a = ufVar;
        }

        @Override // uq.a
        public void a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.b.d = i;
            } else {
                this.a.f().d("Int xml configuration name not recognized", str);
            }
        }

        @Override // uq.a
        public void a(String str, String str2) {
        }

        @Override // uq.a
        public void a(String str, boolean z) {
            if (!"ga_dryRun".equals(str)) {
                this.a.f().d("Bool xml configuration name not recognized", str);
            } else {
                this.b.e = z ? 1 : 0;
            }
        }

        @Override // uq.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public tp a() {
            return this.b;
        }

        @Override // uq.a
        public void b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.b.a = str2;
                return;
            }
            if ("ga_appVersion".equals(str)) {
                this.b.b = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.b.c = str2;
            } else {
                this.a.f().d("String xml configuration name not recognized", str);
            }
        }
    }

    public uz(uf ufVar) {
        super(ufVar, new a(ufVar));
    }
}
