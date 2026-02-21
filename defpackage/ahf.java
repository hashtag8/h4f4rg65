package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public class ahf {
    public static void a(Context context) {
        b(context).toggleSoftInput(0, 2);
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManagerB = b(activity);
        if (activity.getCurrentFocus() != null) {
            inputMethodManagerB.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static InputMethodManager b(Context context) {
        return (InputMethodManager) context.getSystemService("input_method");
    }
}
