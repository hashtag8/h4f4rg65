package defpackage;

import defpackage.bfa;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class bfg {
    private final bfb a;
    private final String b;
    private final bfa c;
    private final bfh d;
    private final Object e;
    private volatile URL f;
    private volatile URI g;
    private volatile bep h;

    private bfg(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public URL a() {
        URL url = this.f;
        if (url != null) {
            return url;
        }
        URL urlA = this.a.a();
        this.f = urlA;
        return urlA;
    }

    public URI b() throws IOException {
        try {
            URI uri = this.g;
            if (uri != null) {
                return uri;
            }
            URI uriB = this.a.b();
            this.g = uriB;
            return uriB;
        } catch (IllegalStateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String c() {
        return this.a.toString();
    }

    public String d() {
        return this.b;
    }

    public bfa e() {
        return this.c;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public List<String> b(String str) {
        return this.c.c(str);
    }

    public bfh f() {
        return this.d;
    }

    public a g() {
        return new a();
    }

    public bep h() {
        bep bepVar = this.h;
        if (bepVar != null) {
            return bepVar;
        }
        bep bepVarA = bep.a(this.c);
        this.h = bepVarA;
        return bepVarA;
    }

    public boolean i() {
        return this.a.c();
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tag=" + (this.e != this ? this.e : null) + '}';
    }

    public static class a {
        private bfb a;
        private String b;
        private bfa.a c;
        private bfh d;
        private Object e;

        public a() {
            this.b = "GET";
            this.c = new bfa.a();
        }

        private a(bfg bfgVar) {
            this.a = bfgVar.a;
            this.b = bfgVar.b;
            this.d = bfgVar.d;
            this.e = bfgVar.e;
            this.c = bfgVar.c.b();
        }

        public a a(bfb bfbVar) {
            if (bfbVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.a = bfbVar;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            bfb bfbVarC = bfb.c(str);
            if (bfbVarC == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return a(bfbVarC);
        }

        public a a(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url == null");
            }
            bfb bfbVarA = bfb.a(url);
            if (bfbVarA == null) {
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            return a(bfbVarA);
        }

        public a a(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a b(String str) {
            this.c.b(str);
            return this;
        }

        public a a(bfa bfaVar) {
            this.c = bfaVar.b();
            return this;
        }

        public a a(bep bepVar) {
            String string = bepVar.toString();
            return string.isEmpty() ? b("Cache-Control") : a("Cache-Control", string);
        }

        public a a(String str, bfh bfhVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (bfhVar != null && !bgf.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (bfhVar == null && bgf.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.b = str;
            this.d = bfhVar;
            return this;
        }

        public bfg a() {
            if (this.a == null) {
                throw new IllegalStateException("url == null");
            }
            return new bfg(this);
        }
    }
}
