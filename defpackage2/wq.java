package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public abstract class wq {
    private static MessageDigest b = null;
    protected Object a = new Object();

    protected MessageDigest a() {
        MessageDigest messageDigest;
        synchronized (this.a) {
            if (b != null) {
                messageDigest = b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = b;
            }
        }
        return messageDigest;
    }

    abstract byte[] a(String str);
}
