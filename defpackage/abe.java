package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class abe extends aas<abe> {
    private String a;
    private int b;
    private int c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;

    public abe() {
        this(false);
    }

    public abe(boolean z) {
        this(z, a());
    }

    public abe(boolean z, int i) {
        vq.a(i);
        this.b = i;
        this.g = z;
    }

    static int a() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        int mostSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L);
        if (mostSignificantBits != 0) {
            return mostSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    private void e() {
        if (this.h) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public void a(int i) {
        e();
        this.b = i;
    }

    @Override // defpackage.aas
    public void a(abe abeVar) {
        if (!TextUtils.isEmpty(this.a)) {
            abeVar.a(this.a);
        }
        if (this.b != 0) {
            abeVar.a(this.b);
        }
        if (this.c != 0) {
            abeVar.b(this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            abeVar.b(this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
            abeVar.c(this.e);
        }
        if (this.f) {
            abeVar.b(this.f);
        }
        if (this.g) {
            abeVar.a(this.g);
        }
    }

    public void a(String str) {
        e();
        this.a = str;
    }

    public void a(boolean z) {
        e();
        this.g = z;
    }

    public String b() {
        return this.a;
    }

    public void b(int i) {
        e();
        this.c = i;
    }

    public void b(String str) {
        e();
        this.d = str;
    }

    public void b(boolean z) {
        e();
        this.f = z;
    }

    public int c() {
        return this.b;
    }

    public void c(String str) {
        e();
        if (TextUtils.isEmpty(str)) {
            this.e = null;
        } else {
            this.e = str;
        }
    }

    public String d() {
        return this.e;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("screenName", this.a);
        map.put("interstitial", Boolean.valueOf(this.f));
        map.put("automatic", Boolean.valueOf(this.g));
        map.put("screenId", Integer.valueOf(this.b));
        map.put("referrerScreenId", Integer.valueOf(this.c));
        map.put("referrerScreenName", this.d);
        map.put("referrerUri", this.e);
        return a((Object) map);
    }
}
