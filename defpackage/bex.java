package defpackage;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class bex {
    public static String a(String str, String str2) {
        try {
            return "Basic " + bqv.a((str + ":" + str2).getBytes("ISO-8859-1")).b();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
