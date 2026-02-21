package defpackage;

import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class aaj {
    public static boolean a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (aal.a() && ((resources.getConfiguration().screenLayout & 15) > 3)) || b(resources);
    }

    private static boolean b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return aal.b() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }
}
