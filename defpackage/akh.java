package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class akh implements akl {

    @acn(a = "name")
    private String b;

    @acn(a = "picture")
    private String c;

    @acn(a = "id")
    private long a = -1;

    @acn(a = "data")
    private List<akg> d = new ArrayList();

    public long a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int hashCode() {
        return (int) (this.a ^ (this.a >>> 32));
    }

    public String toString() {
        return "Artist [id=" + this.a + ", name=" + this.b + ", image=" + this.c + "]";
    }
}
