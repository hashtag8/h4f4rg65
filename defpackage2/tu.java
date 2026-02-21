package defpackage;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tu extends ud {
    private static String a = "3";
    private static String b = "01VDIWEA?";
    private static tu c;

    public tu(uf ufVar) {
        super(ufVar);
    }

    public static tu b() {
        return c;
    }

    protected String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long(((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) l).longValue()) < 100) {
            return String.valueOf(l);
        }
        String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
        String strValueOf = String.valueOf(Math.abs(((Long) l).longValue()));
        return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
    }

    @Override // defpackage.ud
    protected void a() {
        synchronized (tu.class) {
            c = this;
        }
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        String strA = uy.c.a();
        if (Log.isLoggable(strA, i)) {
            Log.println(i, strA, c(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            b(i, str, obj, obj2, obj3);
        }
    }

    public void a(Map<String, String> map, String str) {
        String string;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            string = sb.toString();
        } else {
            string = "no hit data";
        }
        d("Discarding hit. " + str, string);
    }

    public void a(tq tqVar, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        d("Discarding hit. " + str, tqVar != null ? tqVar.toString() : "no hit data");
    }

    public synchronized void b(int i, String str, Object obj, Object obj2, Object obj3) {
        synchronized (this) {
            vq.a(str);
            int i2 = i >= 0 ? i : 0;
            String strSubstring = a + b.charAt(i2 >= b.length() ? b.length() - 1 : i2) + (q().b() ? q().a() ? 'P' : 'C' : q().a() ? 'p' : 'c') + ue.a + ":" + c(str, a(obj), a(obj2), a(obj3));
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
            tx txVarN = k().n();
            if (txVarN != null) {
                txVarN.g().a(strSubstring);
            }
        }
    }
}
