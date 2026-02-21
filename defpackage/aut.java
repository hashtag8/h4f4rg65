package defpackage;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public interface aut {
    void a(aut autVar, HttpResponse httpResponse);

    void a(URI uri);

    void a(HttpResponse httpResponse);

    void a(boolean z);

    void a(Header[] headerArr);

    void b(int i);

    void b(int i, int i2);

    void b(int i, Header[] headerArr, byte[] bArr, Throwable th);

    void b(aut autVar, HttpResponse httpResponse);

    boolean d();

    void f();

    void g();

    void h();
}
