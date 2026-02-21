package defpackage;

import android.support.v8.renderscript.Allocation;
import java.util.BitSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class bsu {
    private static final byte[] a = bss.a;
    private static final BitSet b = b("=_?");
    private static final BitSet c = b("=_?\"#$%&'(),.:;<>@[\\]^`{|}~");
    private static final BitSet d = b("()<>@,;:\\\"/[]?=");
    private static final BitSet e = b("()<>@.,;:\\\"[]");

    private static BitSet b(String str) {
        BitSet bitSet = new BitSet(Allocation.USAGE_SHARED);
        for (char c2 = '!'; c2 < 127; c2 = (char) (c2 + 1)) {
            if (str.indexOf(c2) == -1) {
                bitSet.set(c2);
            }
        }
        return bitSet;
    }

    public static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        return a(str2) ? lowerCase + "=" + str2 : lowerCase + "=" + c(str2);
    }

    public static boolean a(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!d.get(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String c(String str) {
        return "\"" + str.replaceAll("[\\\\\"]", "\\\\$0") + "\"";
    }
}
