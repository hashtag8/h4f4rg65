package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class brq {
    public static final String a = String.valueOf('.');
    public static final String b = String.valueOf('$');
    private static final Map<Class<?>, Class<?>> c = new HashMap();
    private static final Map<Class<?>, Class<?>> d;
    private static final Map<String, String> e;
    private static final Map<String, String> f;

    static {
        c.put(Boolean.TYPE, Boolean.class);
        c.put(Byte.TYPE, Byte.class);
        c.put(Character.TYPE, Character.class);
        c.put(Short.TYPE, Short.class);
        c.put(Integer.TYPE, Integer.class);
        c.put(Long.TYPE, Long.class);
        c.put(Double.TYPE, Double.class);
        c.put(Float.TYPE, Float.class);
        c.put(Void.TYPE, Void.TYPE);
        d = new HashMap();
        for (Class<?> cls : c.keySet()) {
            Class<?> cls2 = c.get(cls);
            if (!cls.equals(cls2)) {
                d.put(cls2, cls);
            }
        }
        e = new HashMap();
        f = new HashMap();
        a("int", "I");
        a("boolean", "Z");
        a("float", "F");
        a("long", "J");
        a("short", "S");
        a("byte", "B");
        a("double", "D");
        a("char", "C");
    }

    private static void a(String str, String str2) {
        e.put(str, str2);
        f.put(str2, str);
    }

    public static String a(Class<?> cls) {
        return cls == null ? "" : a(cls.getName());
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append("[]");
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
        }
        String str2 = f.containsKey(str) ? f.get(str) : str;
        int iLastIndexOf = str2.lastIndexOf(46);
        int iIndexOf = str2.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = str2.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb);
    }
}
