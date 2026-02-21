package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ahv {
    public static boolean a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr2.length; i++) {
            try {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static boolean a(byte[] bArr, String str) {
        try {
            String[] strArrSplit = str.replace(".", "a").split("a");
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != Byte.parseByte(strArrSplit[i])) {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean a(String str, byte[] bArr) {
        try {
            String[] strArrSplit = str.split("\\.");
            int i = 0;
            while (bArr != null) {
                if (i >= bArr.length) {
                    return false;
                }
                byte b = Byte.parseByte(strArrSplit[i]);
                if (b > bArr[i]) {
                    return true;
                }
                if (b < bArr[i]) {
                    return false;
                }
                i++;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            try {
                sb.append((int) bArr[i]);
                if (i != bArr.length - 1) {
                    sb.append(".");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
