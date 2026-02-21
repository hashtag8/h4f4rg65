package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import com.harman.hkconnect.ui.BlankActivity;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class agu {
    public static List<String> a = new ArrayList();

    public static List<String> a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf(44);
        while (iIndexOf != -1) {
            arrayList.add(str.substring(0, iIndexOf));
            str = str.substring(iIndexOf + 1);
            iIndexOf = str.indexOf(44);
        }
        arrayList.add(str);
        return arrayList;
    }

    private static List<ActivityManager.RunningTaskInfo> c(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
    }

    public static boolean a(Context context) {
        return (c(context).isEmpty() || c(context).get(0).topActivity.getPackageName().equals(context.getPackageName())) ? false : true;
    }

    public static void b(Context context) {
        Intent intent = new Intent(context, (Class<?>) BlankActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("exit", true);
        context.startActivity(intent);
    }

    @TargetApi(17)
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 17 && HarmanApplication.a().getResources().getConfiguration().locale.getLanguage().equals("iw");
    }

    public static Typeface a(Context context, int i, int i2) {
        if (i == 4) {
            switch (i2) {
                case 1:
                    return a(context, "Roboto-Bold.ttf");
                default:
                    return a(context, "Roboto-Regular.ttf");
            }
        }
        if (i == 2) {
            return a(context, "Roboto-Semibold.ttf");
        }
        if (i == 1) {
            return a(context, "Roboto-Bold.ttf");
        }
        if (i == 3) {
            return a(context, "Roboto-Italic.ttf");
        }
        if (i == 0) {
            return a(context, "Roboto-Regular.ttf");
        }
        return a(context, "Roboto-Regular.ttf");
    }

    public static Typeface a(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (Exception e) {
            mm.e(" RuntimeException: Font asset not found, file = " + str, new Object[0]);
            return null;
        }
    }
}
