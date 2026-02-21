package defpackage;

import defpackage.bfa;
import defpackage.bfg;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class bgh {
    private static final Comparator<String> e = new Comparator<String>() { // from class: bgh.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    static final String a = bfu.a().b();
    public static final String b = a + "-Sent-Millis";
    public static final String c = a + "-Received-Millis";
    public static final String d = a + "-Selected-Protocol";

    public static long a(bfg bfgVar) {
        return a(bfgVar.e());
    }

    public static long a(bfi bfiVar) {
        return a(bfiVar.f());
    }

    public static long a(bfa bfaVar) {
        return b(bfaVar.a(HTTP.CONTENT_LEN));
    }

    private static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            return -1L;
        }
    }

    public static Map<String, List<String>> a(bfa bfaVar, String str) {
        TreeMap treeMap = new TreeMap(e);
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = bfaVar.a(i);
            String strB = bfaVar.b(i);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(strA);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(strB);
            treeMap.put(strA, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static void a(bfg.a aVar, Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                if (!entry.getValue().isEmpty()) {
                    aVar.b(key, a(entry.getValue()));
                }
            }
        }
    }

    private static String a(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static boolean a(bfi bfiVar, bfa bfaVar, bfg bfgVar) {
        for (String str : d(bfiVar)) {
            if (!bfw.a(bfaVar.c(str), bfgVar.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(bfi bfiVar) {
        return b(bfiVar.f());
    }

    public static boolean b(bfa bfaVar) {
        return c(bfaVar).contains("*");
    }

    private static Set<String> d(bfi bfiVar) {
        return c(bfiVar.f());
    }

    public static Set<String> c(bfa bfaVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            if ("Vary".equalsIgnoreCase(bfaVar.a(i))) {
                String strB = bfaVar.b(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                String[] strArrSplit = strB.split(",");
                for (String str : strArrSplit) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static bfa c(bfi bfiVar) {
        return a(bfiVar.i().a().e(), bfiVar.f());
    }

    public static bfa a(bfa bfaVar, bfa bfaVar2) {
        Set<String> setC = c(bfaVar2);
        if (setC.isEmpty()) {
            return new bfa.a().a();
        }
        bfa.a aVar = new bfa.a();
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = bfaVar.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, bfaVar.b(i));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HTTP.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List<bes> b(bfa bfaVar, String str) {
        ArrayList arrayList = new ArrayList();
        int iA = bfaVar.a();
        for (int i = 0; i < iA; i++) {
            if (str.equalsIgnoreCase(bfaVar.a(i))) {
                String strB = bfaVar.b(i);
                int iA2 = 0;
                while (iA2 < strB.length()) {
                    int iA3 = bgb.a(strB, iA2, " ");
                    String strTrim = strB.substring(iA2, iA3).trim();
                    int iA4 = bgb.a(strB, iA3);
                    if (strB.regionMatches(true, iA4, "realm=\"", 0, "realm=\"".length())) {
                        int length = "realm=\"".length() + iA4;
                        int iA5 = bgb.a(strB, length, "\"");
                        String strSubstring = strB.substring(length, iA5);
                        iA2 = bgb.a(strB, bgb.a(strB, iA5 + 1, ",") + 1);
                        arrayList.add(new bes(strTrim, strSubstring));
                    }
                }
            }
        }
        return arrayList;
    }

    public static bfg a(ben benVar, bfi bfiVar, Proxy proxy) {
        return bfiVar.c() == 407 ? benVar.b(proxy, bfiVar) : benVar.a(proxy, bfiVar);
    }
}
