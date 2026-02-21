package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class aug implements aut {
    private String a;
    private Handler b;
    private boolean c;
    private URI d;
    private Header[] e;
    private Looper f;

    public abstract void a(int i, Header[] headerArr, byte[] bArr);

    public abstract void a(int i, Header[] headerArr, byte[] bArr, Throwable th);

    @Override // defpackage.aut
    public void a(URI uri) {
        this.d = uri;
    }

    @Override // defpackage.aut
    public void a(Header[] headerArr) {
        this.e = headerArr;
    }

    static class a extends Handler {
        private final aug a;

        a(aug augVar, Looper looper) {
            super(looper);
            this.a = augVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    @Override // defpackage.aut
    public boolean d() {
        return this.c;
    }

    @Override // defpackage.aut
    public void a(boolean z) {
        if (!z && this.f == null) {
            z = true;
            Log.w("AsyncHttpResponseHandler", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (!z && this.b == null) {
            this.b = new a(this, this.f);
        } else if (z && this.b != null) {
            this.b = null;
        }
        this.c = z;
    }

    public void a(String str) {
        this.a = str;
    }

    public String e() {
        return this.a == null ? HTTP.UTF_8 : this.a;
    }

    public aug() {
        this(null);
    }

    public aug(Looper looper) {
        this.a = HTTP.UTF_8;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f = looper == null ? Looper.myLooper() : looper;
        a(false);
    }

    public void a(int i, int i2) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Double.valueOf(i2 > 0 ? ((((double) i) * 1.0d) / ((double) i2)) * 100.0d : -1.0d);
        Log.v("AsyncHttpResponseHandler", String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void a() {
    }

    public void b() {
    }

    @Override // defpackage.aut
    public void a(aut autVar, HttpResponse httpResponse) {
    }

    @Override // defpackage.aut
    public void b(aut autVar, HttpResponse httpResponse) {
    }

    public void a(int i) {
        Log.d("AsyncHttpResponseHandler", String.format("Request retry no. %d", Integer.valueOf(i)));
    }

    public void c() {
        Log.d("AsyncHttpResponseHandler", "Request got cancelled");
    }

    @Override // defpackage.aut
    public final void b(int i, int i2) {
        b(a(4, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void b(int i, Header[] headerArr, byte[] bArr) {
        b(a(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    @Override // defpackage.aut
    public final void b(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        b(a(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    @Override // defpackage.aut
    public final void f() {
        b(a(2, (Object) null));
    }

    @Override // defpackage.aut
    public final void g() {
        b(a(3, (Object) null));
    }

    @Override // defpackage.aut
    public final void b(int i) {
        b(a(5, new Object[]{Integer.valueOf(i)}));
    }

    @Override // defpackage.aut
    public final void h() {
        b(a(6, (Object) null));
    }

    protected void a(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 3) {
                    a(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                } else {
                    Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                }
                break;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2 != null && objArr2.length >= 4) {
                    a(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                } else {
                    Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                }
                break;
            case 2:
                a();
                break;
            case 3:
                b();
                break;
            case 4:
                Object[] objArr3 = (Object[]) message.obj;
                if (objArr3 != null && objArr3.length >= 2) {
                    try {
                        a(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
                    } catch (Throwable th) {
                        Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", th);
                        return;
                    }
                } else {
                    Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                }
                break;
            case 5:
                Object[] objArr4 = (Object[]) message.obj;
                if (objArr4 != null && objArr4.length == 1) {
                    a(((Integer) objArr4[0]).intValue());
                } else {
                    Log.e("AsyncHttpResponseHandler", "RETRY_MESSAGE didn't get enough params");
                }
                break;
            case 6:
                c();
                break;
        }
    }

    protected void b(Message message) {
        if (d() || this.b == null) {
            a(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            aud.a(this.b != null, "handler should not be null!");
            this.b.sendMessage(message);
        }
    }

    protected void a(Runnable runnable) {
        if (runnable != null) {
            if (d() || this.b == null) {
                runnable.run();
            } else {
                aud.a(this.b != null, "handler should not be null!");
                this.b.post(runnable);
            }
        }
    }

    protected Message a(int i, Object obj) {
        return Message.obtain(this.b, i, obj);
    }

    @Override // defpackage.aut
    public void a(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] bArrA = a(httpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (statusLine.getStatusCode() >= 300) {
                    b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), bArrA, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), bArrA);
                }
            }
        }
    }

    byte[] a(HttpEntity httpEntity) throws IOException {
        InputStream content;
        int i = 0;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength > 0 ? (int) contentLength : 4096);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = i;
                    int i3 = content.read(bArr);
                    if (i3 == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i = i2 + i3;
                    byteArrayBuffer.append(bArr, 0, i3);
                    b(i, (int) (contentLength <= 0 ? 1L : contentLength));
                }
                aue.a(content);
                aue.a(httpEntity);
                return byteArrayBuffer.toByteArray();
            } catch (Throwable th) {
                aue.a(content);
                aue.a(httpEntity);
                throw th;
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }
}
