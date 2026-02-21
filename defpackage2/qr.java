package defpackage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class qr {
    private static final a a = a.PRODUCTION;
    private static Map<a, qs> b = new HashMap();
    private static qs c;

    public enum a {
        PRODUCTION,
        PREPRODUCTION,
        DEV;

        @Override // java.lang.Enum
        public final String toString() {
            String string = super.toString();
            return string.substring(0, 1).toUpperCase(Locale.US) + string.substring(1).toLowerCase(Locale.US);
        }
    }

    static {
        c = null;
        for (a aVar : a.values()) {
            try {
                String string = aVar.toString();
                b.put(aVar, (qs) Class.forName("com.deezer.sdk.config.Config" + string).newInstance());
                String str = "Configuration " + string + " loaded successfully.";
            } catch (ClassNotFoundException e) {
                String str2 = "Class for configName: " + aVar.toString() + " not found.";
                b.put(aVar, new qq());
            } catch (IllegalAccessException e2) {
                String str3 = "Class for configName: " + aVar.toString() + " can't be instanciated.";
                b.put(aVar, new qq());
            } catch (InstantiationException e3) {
                String str4 = "Class for configName: " + aVar.toString() + " can't be instanciated.";
                b.put(aVar, new qq());
            }
        }
        c = b.get(a);
        String str5 = "Active configuration is set: " + c.a().toString();
    }

    public static qs a() {
        return c;
    }
}
