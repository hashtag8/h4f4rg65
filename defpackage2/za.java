package defpackage;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@yx
public class za {
    private final String b;
    private final zb c;
    private Context k;
    private VersionInfoParcel l;
    private String u;
    private final Object a = new Object();
    private BigInteger d = BigInteger.ONE;
    private final HashSet<Object> e = new HashSet<>();
    private final HashMap<String, Object> f = new HashMap<>();
    private boolean g = false;
    private boolean h = true;
    private int i = 0;
    private boolean j = false;
    private xd m = null;
    private boolean n = true;
    private wo o = null;
    private wp p = null;
    private wn q = null;
    private final LinkedList<Thread> r = new LinkedList<>();
    private final yw s = null;
    private Boolean t = null;

    public za(zf zfVar) {
        this.b = zfVar.b();
        this.c = new zb(this.b);
    }

    public String a() {
        String str;
        synchronized (this.a) {
            str = this.u;
        }
        return str;
    }

    public String a(int i, String str) {
        Resources resources = this.l.e ? this.k.getResources() : GooglePlayServicesUtil.getRemoteResource(this.k);
        return resources == null ? str : resources.getString(i);
    }

    public void a(Boolean bool) {
        synchronized (this.a) {
            this.t = bool;
        }
    }

    public void a(Throwable th, boolean z) {
        new yw(this.k, this.l, null, null).a(th, z);
    }

    public Boolean b() {
        Boolean bool;
        synchronized (this.a) {
            bool = this.t;
        }
        return bool;
    }
}
