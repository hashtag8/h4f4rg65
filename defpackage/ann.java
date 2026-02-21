package defpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ann {
    public static String a(long j) {
        return (j / 3600000) + "h" + ((j % 3600000) / 60000) + "m";
    }

    public static String b(long j) {
        return new SimpleDateFormat("mm:ss", new Locale("en", "US")).format(new Date(j));
    }

    public static String a(String str, String str2) {
        return new SimpleDateFormat(str2, new Locale("en", "US")).format(new Date(Long.valueOf(str).longValue() * 1000));
    }
}
