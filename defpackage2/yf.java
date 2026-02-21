package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yf {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public static final class a {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;

        public a a(boolean z) {
            this.a = z;
            return this;
        }

        public yf a() {
            return new yf(this);
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }

        public a c(boolean z) {
            this.c = z;
            return this;
        }

        public a d(boolean z) {
            this.d = z;
            return this;
        }

        public a e(boolean z) {
            this.e = z;
            return this;
        }
    }

    private yf(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (JSONException e) {
            su.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
