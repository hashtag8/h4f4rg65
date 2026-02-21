package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class aho {
    public static String a = "firecast";

    private static SharedPreferences.Editor a(Context context) {
        return context.getSharedPreferences(a, 0).edit();
    }

    public static void a(String str, boolean z) {
        SharedPreferences.Editor editorA = a(HarmanApplication.a());
        editorA.putBoolean(str, z);
        editorA.apply();
    }

    public static void a(String str, int i) {
        SharedPreferences.Editor editorA = a(HarmanApplication.a());
        editorA.putInt(str, i);
        editorA.apply();
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor editorA = a(HarmanApplication.a());
        editorA.putString(str, str2);
        editorA.apply();
    }

    public static boolean a(String str) {
        return HarmanApplication.a().getSharedPreferences(a, 0).getBoolean(str, false);
    }

    public static boolean b(String str, boolean z) {
        return HarmanApplication.a().getSharedPreferences(a, 0).getBoolean(str, z);
    }

    public static float b(String str) {
        return HarmanApplication.a().getSharedPreferences(a, 0).getFloat(str, 0.0f);
    }

    public static int c(String str) {
        return b(str, 0);
    }

    public static int b(String str, int i) {
        return HarmanApplication.a().getSharedPreferences(a, 0).getInt(str, i);
    }

    public static String d(String str) {
        return HarmanApplication.a().getSharedPreferences(a, 0).getString(str, "");
    }

    public static void e(String str) {
        SharedPreferences.Editor editorEdit = HarmanApplication.a().getSharedPreferences(a, 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }
}
