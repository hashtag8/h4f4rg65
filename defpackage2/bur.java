package defpackage;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class bur {
    public static bup a(String str) {
        return a(buq.a, str);
    }

    public static bup a(Charset charset, String str) {
        ByteBuffer byteBufferEncode = charset.encode(CharBuffer.wrap(str));
        buo buoVar = new buo(byteBufferEncode.remaining());
        buoVar.a(byteBufferEncode.array(), byteBufferEncode.position(), byteBufferEncode.remaining());
        return buoVar;
    }

    public static String a(bup bupVar) {
        return a(buq.a, bupVar, 0, bupVar.b());
    }

    public static String a(Charset charset, bup bupVar, int i, int i2) {
        if (bupVar instanceof buo) {
            return a(charset, ((buo) bupVar).c(), i, i2);
        }
        return a(charset, bupVar.a(), i, i2);
    }

    private static String a(Charset charset, byte[] bArr, int i, int i2) {
        return charset.decode(ByteBuffer.wrap(bArr, i, i2)).toString();
    }
}
