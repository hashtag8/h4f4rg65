package defpackage;

import defpackage.bfa;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class bfi {
    private final bfg a;
    private final bff b;
    private final int c;
    private final String d;
    private final bez e;
    private final bfa f;
    private final bfj g;
    private bfi h;
    private bfi i;
    private final bfi j;
    private volatile bep k;

    private bfi(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    public bfg a() {
        return this.a;
    }

    public bff b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public bez e() {
        return this.e;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String strA = this.f.a(str);
        return strA != null ? strA : str2;
    }

    public bfa f() {
        return this.f;
    }

    public bfj g() {
        return this.g;
    }

    public a h() {
        return new a();
    }

    public bfi i() {
        return this.h;
    }

    public bfi j() {
        return this.i;
    }

    public List<bes> k() {
        String str;
        if (this.c == 401) {
            str = "WWW-Authenticate";
        } else if (this.c == 407) {
            str = "Proxy-Authenticate";
        } else {
            return Collections.emptyList();
        }
        return bgh.b(f(), str);
    }

    public bep l() {
        bep bepVar = this.k;
        if (bepVar != null) {
            return bepVar;
        }
        bep bepVarA = bep.a(this.f);
        this.k = bepVarA;
        return bepVarA;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.c() + '}';
    }

    public static class a {
        private bfg a;
        private bff b;
        private int c;
        private String d;
        private bez e;
        private bfa.a f;
        private bfj g;
        private bfi h;
        private bfi i;
        private bfi j;

        public a() {
            this.c = -1;
            this.f = new bfa.a();
        }

        private a(bfi bfiVar) {
            this.c = -1;
            this.a = bfiVar.a;
            this.b = bfiVar.b;
            this.c = bfiVar.c;
            this.d = bfiVar.d;
            this.e = bfiVar.e;
            this.f = bfiVar.f.b();
            this.g = bfiVar.g;
            this.h = bfiVar.h;
            this.i = bfiVar.i;
            this.j = bfiVar.j;
        }

        public a a(bfg bfgVar) {
            this.a = bfgVar;
            return this;
        }

        public a a(bff bffVar) {
            this.b = bffVar;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(bez bezVar) {
            this.e = bezVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(bfa bfaVar) {
            this.f = bfaVar.b();
            return this;
        }

        public a a(bfj bfjVar) {
            this.g = bfjVar;
            return this;
        }

        public a a(bfi bfiVar) {
            if (bfiVar != null) {
                a("networkResponse", bfiVar);
            }
            this.h = bfiVar;
            return this;
        }

        public a b(bfi bfiVar) {
            if (bfiVar != null) {
                a("cacheResponse", bfiVar);
            }
            this.i = bfiVar;
            return this;
        }

        private void a(String str, bfi bfiVar) {
            if (bfiVar.g == null) {
                if (bfiVar.h == null) {
                    if (bfiVar.i == null) {
                        if (bfiVar.j != null) {
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        return;
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a c(bfi bfiVar) {
            if (bfiVar != null) {
                d(bfiVar);
            }
            this.j = bfiVar;
            return this;
        }

        private void d(bfi bfiVar) {
            if (bfiVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public bfi a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            return new bfi(this);
        }
    }
}
