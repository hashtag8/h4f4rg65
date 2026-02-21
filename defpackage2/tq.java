package defpackage;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tq {
    private final Map<String, String> a;
    private final List<Command> b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final String g;

    public tq(uc ucVar, Map<String, String> map, long j, boolean z) {
        this(ucVar, map, j, z, 0L, 0, null);
    }

    public tq(uc ucVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(ucVar, map, j, z, j2, i, null);
    }

    public tq(uc ucVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String strA;
        String strA2;
        vq.a(ucVar);
        vq.a(map);
        this.d = j;
        this.f = z;
        this.c = j2;
        this.e = i;
        this.b = list != null ? list : Collections.EMPTY_LIST;
        this.g = a(list);
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (a(entry.getKey()) && (strA2 = a(ucVar, entry.getKey())) != null) {
                map2.put(strA2, b(ucVar, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!a(entry2.getKey()) && (strA = a(ucVar, entry2.getKey())) != null) {
                map2.put(strA, b(ucVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            tz.a(map2, "_v", this.g);
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.a = Collections.unmodifiableMap(map2);
    }

    private String a(String str, String str2) {
        vq.a(str);
        vq.b(!str.startsWith("&"), "Short param name required");
        String str3 = this.a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String a(List<Command> list) {
        String strB;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.a())) {
                    strB = command.b();
                    break;
                }
            }
            strB = null;
        } else {
            strB = null;
        }
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return strB;
    }

    private static String a(uc ucVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        if (string.startsWith("&")) {
            string = string.substring(1);
        }
        int length = string.length();
        if (length > 256) {
            string = string.substring(0, 256);
            ucVar.c("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public static tq a(uc ucVar, tq tqVar, Map<String, String> map) {
        return new tq(ucVar, map, tqVar.d(), tqVar.f(), tqVar.c(), tqVar.a(), tqVar.e());
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String b(uc ucVar, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, 8192);
        ucVar.c("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    public int a() {
        return this.e;
    }

    public Map<String, String> b() {
        return this.a;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public List<Command> e() {
        return this.b;
    }

    public boolean f() {
        return this.f;
    }

    public long g() {
        return tz.a(a("_s", "0"));
    }

    public String h() {
        return a("_m", "");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.d);
        if (this.c != 0) {
            stringBuffer.append(", dbId=").append(this.c);
        }
        if (this.e != 0) {
            stringBuffer.append(", appUID=").append(this.e);
        }
        ArrayList<String> arrayList = new ArrayList(this.a.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.a.get(str));
        }
        return stringBuffer.toString();
    }
}
