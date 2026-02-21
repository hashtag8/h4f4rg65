package defpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class afe {
    private Socket a;
    private OutputStream b;
    private InputStream c;

    public void a(String str) {
        c();
        try {
            mm.a((Object) ("---jake---socket connect start  " + Thread.currentThread().getId()));
            this.a = new Socket();
            this.a.setKeepAlive(false);
            this.a.setSoTimeout(600000);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(str), 10026);
            if (this.a != null) {
                this.a.connect(inetSocketAddress, 15000);
                this.b = new BufferedOutputStream(this.a.getOutputStream());
                this.c = new BufferedInputStream(this.a.getInputStream());
                mm.a((Object) ("---jake---socket connect connectting " + Thread.currentThread().getId()));
            }
            mm.a((Object) ("---jake---socket connect end " + Thread.currentThread().getId()));
        } catch (IOException e) {
            mm.a((Object) ("---jake---socket connect exception " + e.toString()));
            throw new RuntimeException("Could not connect to " + str + ":10026", e);
        }
    }

    public boolean a() {
        return (this.b == null || this.c == null) ? false : true;
    }

    public void a(byte[] bArr) throws Exception {
        mm.a((Object) ("---socket---write -------- " + Thread.currentThread().getId()));
        try {
            if (this.b != null && bArr != null && bArr.length > 0) {
                mm.a((Object) ("---socket---write begin " + Thread.currentThread().getId()));
                mm.b(bArr);
                this.b.write(bArr);
                this.b.flush();
                mm.a((Object) ("---socket---write end " + new String(bArr) + "  " + Thread.currentThread().getId()));
            }
        } catch (Exception e) {
            mm.a((Object) ("---socket---write failed " + e.toString() + "  " + Thread.currentThread().getId()));
            throw e;
        }
    }

    public synchronized byte[] b() {
        byte[] bArr;
        mm.a((Object) ("---socket---input --------start " + Thread.currentThread().getId()));
        bArr = null;
        if (this.c != null) {
            byte[] bArr2 = new byte[1024];
            int i = this.c.read(bArr2);
            if (i == -1) {
                throw new IOException();
            }
            bArr = new byte[i];
            System.arraycopy(bArr2, 0, bArr, 0, i);
            mm.a((Object) ("---socket---input --------reading =  " + bArr.length + "   " + Thread.currentThread().getId()));
        }
        mm.a((Object) ("---socket---input --------end =     " + Thread.currentThread().getId()));
        return bArr;
    }

    public void c() {
        d();
    }

    private void d() {
        mm.a((Object) ("---socket---close start " + Thread.currentThread().getId()));
        try {
            if (this.b != null) {
                this.b.close();
                this.b = null;
                mm.a((Object) ("---socket---close end " + Thread.currentThread().getId()));
            }
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
            if (this.a != null) {
                this.a.close();
                this.a = null;
            }
        } catch (Exception e) {
            mm.a((Object) ("---socket---close Exception " + e.toString() + Thread.currentThread().getId()));
        }
    }
}
