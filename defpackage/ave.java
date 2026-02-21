package defpackage;

import android.content.res.Resources;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ave {

    @acn(a = "id")
    private int a;

    @acn(a = "iconForSettingRid")
    private String b;

    @acn(a = "iconForSetting")
    private int c;

    @acn(a = "nameRid")
    private String d;

    @acn(a = "name")
    private String e;

    @acn(a = "detailRid")
    private String f;

    @acn(a = "detail")
    private String g;

    @acn(a = "isSelected")
    private boolean h;

    @acn(a = "orderIndex")
    private int i;

    @acn(a = "isShow")
    private boolean j;

    public String a() {
        if (!bru.a((CharSequence) this.f)) {
            try {
                Resources resources = HarmanApplication.a().getResources();
                this.g = resources.getString(resources.getIdentifier(this.f, "string", "com.harman.hkconnect"));
            } catch (Exception e) {
                throw new RuntimeException("Invalid resource name string " + this.f);
            }
        }
        return this.g;
    }

    public boolean b() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public int c() {
        if (!bru.a((CharSequence) this.b)) {
            this.c = a("drawable", this.b);
        }
        return this.c;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return c();
    }

    public int f() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public String g() {
        if (!bru.a((CharSequence) this.d)) {
            try {
                Resources resources = HarmanApplication.a().getResources();
                this.e = resources.getString(resources.getIdentifier(this.d, "string", "com.harman.hkconnect"));
            } catch (Exception e) {
                throw new RuntimeException("Invalid resource name string " + this.d);
            }
        }
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    private int a(String str, String str2) {
        try {
            return HarmanApplication.a().getResources().getIdentifier(str2, str, "com.harman.hkconnect");
        } catch (Exception e) {
            throw new RuntimeException("Invalid resource name " + str + " " + str2, e);
        }
    }

    public String toString() {
        return bsc.b(this, new ahp());
    }

    public boolean h() {
        if (this.a != 101 || ain.e) {
            return this.j;
        }
        return false;
    }

    public void b(boolean z) {
        this.j = z;
    }
}
