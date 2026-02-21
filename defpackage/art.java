package defpackage;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class art {
    public static String a(long j) {
        return String.format(Locale.ENGLISH, "%01d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j))));
    }
}
