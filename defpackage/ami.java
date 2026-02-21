package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class ami {
    static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str, String str2, String str3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HTTP.UTF_8), str3);
            Mac mac = Mac.getInstance(str3);
            mac.init(secretKeySpec);
            byte[] bArrDoFinal = mac.doFinal(str.getBytes(HTTP.ASCII));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDoFinal) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (InvalidKeyException e2) {
            return null;
        } catch (NoSuchAlgorithmException e3) {
            return null;
        }
    }
}
