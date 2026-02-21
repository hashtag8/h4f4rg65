package defpackage;

import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class bru {
    private static final Pattern a = Pattern.compile("\\s+");

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean b(CharSequence charSequence) {
        return !a(charSequence);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == null ? charSequence2 == null : charSequence.equals(charSequence2);
    }

    public static boolean a(CharSequence charSequence, char... cArr) {
        if (a(charSequence) || bro.a(cArr)) {
            return false;
        }
        int length = charSequence.length();
        int length2 = cArr.length;
        int i = length - 1;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == cCharAt) {
                    if (!Character.isHighSurrogate(cCharAt) || i4 == i2) {
                        return true;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(CharSequence charSequence, char... cArr) {
        if (charSequence == null || cArr == null) {
            return true;
        }
        int length = charSequence.length();
        int i = length - 1;
        int length2 = cArr.length;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == cCharAt) {
                    if (!Character.isHighSurrogate(cCharAt) || i4 == i2) {
                        return false;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return a(objArr, str, 0, objArr.length);
    }

    public static String a(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(str);
            }
            if (objArr[i4] != null) {
                sb.append(objArr[i4]);
            }
        }
        return sb.toString();
    }

    public static String a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return brs.a(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String a(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return a(iterable.iterator(), str);
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, -1);
    }

    public static String a(String str, String str2, String str3, int i) {
        int iIndexOf;
        int i2 = 64;
        if (!a((CharSequence) str) && !a((CharSequence) str2) && str3 != null && i != 0 && (iIndexOf = str.indexOf(str2, 0)) != -1) {
            int length = str2.length();
            int length2 = str3.length() - length;
            if (length2 < 0) {
                length2 = 0;
            }
            if (i < 0) {
                i2 = 16;
            } else if (i <= 64) {
                i2 = i;
            }
            StringBuilder sb = new StringBuilder((i2 * length2) + str.length());
            int i3 = 0;
            while (iIndexOf != -1) {
                sb.append(str.substring(i3, iIndexOf)).append(str3);
                i3 = iIndexOf + length;
                i--;
                if (i == 0) {
                    break;
                }
                iIndexOf = str.indexOf(str2, i3);
            }
            sb.append(str.substring(i3));
            return sb.toString();
        }
        return str;
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i != 1 && length != 0) {
            if (length == 1 && i <= 8192) {
                return a(str.charAt(0), i);
            }
            int i2 = length * i;
            switch (length) {
                case 1:
                    break;
                case 2:
                    char cCharAt = str.charAt(0);
                    char cCharAt2 = str.charAt(1);
                    char[] cArr = new char[i2];
                    for (int i3 = (i * 2) - 2; i3 >= 0; i3 = (i3 - 1) - 1) {
                        cArr[i3] = cCharAt;
                        cArr[i3 + 1] = cCharAt2;
                    }
                    break;
                default:
                    StringBuilder sb = new StringBuilder(i2);
                    for (int i4 = 0; i4 < i; i4++) {
                        sb.append(str);
                    }
                    break;
            }
            return str;
        }
        return str;
    }

    public static String a(char c, int i) {
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    public static String a(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length > 0) {
            if (length > 8192) {
                return a(str, i, String.valueOf(c));
            }
            return a(c, length).concat(str);
        }
        return str;
    }

    public static String a(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (a((CharSequence) str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 > 0) {
            if (length == 1 && length2 <= 8192) {
                return a(str, i, str2.charAt(0));
            }
            if (length2 == length) {
                return str2.concat(str);
            }
            if (length2 < length) {
                return str2.substring(0, length2).concat(str);
            }
            char[] cArr = new char[length2];
            char[] charArray = str2.toCharArray();
            for (int i2 = 0; i2 < length2; i2++) {
                cArr[i2] = charArray[i2 % length];
            }
            return new String(cArr).concat(str);
        }
        return str;
    }

    public static int b(CharSequence charSequence, CharSequence charSequence2) {
        int length = 0;
        if (a(charSequence) || a(charSequence2)) {
            return 0;
        }
        int i = 0;
        while (true) {
            int iA = brp.a(charSequence, charSequence2, length);
            if (iA != -1) {
                i++;
                length = iA + charSequence2.length();
            } else {
                return i;
            }
        }
    }

    public static String b(String str, int i) {
        return a(str, 0, i);
    }

    public static String a(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        }
        if (str.length() > i2) {
            if (i > str.length()) {
                i = str.length();
            }
            if (str.length() - i < i2 - 3) {
                i = str.length() - (i2 - 3);
            }
            if (i <= 4) {
                return str.substring(0, i2 - 3) + "...";
            }
            if (i2 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            }
            if ((i + i2) - 3 < str.length()) {
                return "..." + b(str.substring(i), i2 - 3);
            }
            return "..." + str.substring(str.length() - (i2 - 3));
        }
        return str;
    }
}
