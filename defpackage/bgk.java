package defpackage;

import java.net.Proxy;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class bgk {
    static String a(bfg bfgVar, Proxy.Type type, bff bffVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bfgVar.d());
        sb.append(' ');
        if (a(bfgVar, type)) {
            sb.append(bfgVar.a());
        } else {
            sb.append(a(bfgVar.a()));
        }
        sb.append(' ');
        sb.append(a(bffVar));
        return sb.toString();
    }

    private static boolean a(bfg bfgVar, Proxy.Type type) {
        return !bfgVar.i() && type == Proxy.Type.HTTP;
    }

    public static String a(URL url) {
        String file = url.getFile();
        return file == null ? "/" : !file.startsWith("/") ? "/" + file : file;
    }

    public static String a(bff bffVar) {
        return bffVar == bff.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
    }
}
