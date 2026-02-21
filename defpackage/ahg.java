package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class ahg {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest b;

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileChannel fileChannel = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream2.getChannel();
                try {
                    b.update(channel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    String strB = b(b.digest());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th2) {
                        }
                    }
                    return strB;
                } catch (Throwable th3) {
                    fileInputStream = fileInputStream2;
                    th = th3;
                    fileChannel = channel;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                            throw th;
                        } catch (Throwable th5) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        b.update(bArr);
        return b(b.digest());
    }

    private static String b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char c = a[(b2 & 240) >> 4];
        char c2 = a[b2 & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static String b(File file) {
        try {
            return a(file);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
