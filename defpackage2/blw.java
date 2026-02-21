package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public abstract class blw {
    private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final bln a;
    private final String c;
    private final bnw d;
    private final bnu e;
    private final String f;

    public blw(bln blnVar, String str, String str2, bnw bnwVar, bnu bnuVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (bnwVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.a = blnVar;
        this.f = str;
        this.c = a(str2);
        this.d = bnwVar;
        this.e = bnuVar;
    }

    protected String a() {
        return this.c;
    }

    protected bnv b() {
        return a(Collections.emptyMap());
    }

    protected bnv a(Map<String, String> map) {
        return this.d.a(this.e, a(), map).a(false).a(10000).a(HTTP.USER_AGENT, "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String a(String str) {
        if (!bme.d(this.f)) {
            return b.matcher(str).replaceFirst(this.f);
        }
        return str;
    }
}
