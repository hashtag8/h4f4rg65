package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class mr extends bln<Void> implements blo {
    public final mu a;
    public final oa b;
    public final ot c;
    public final Collection<? extends bln> d;

    public mr() {
        this(new mu(), new oa(), new ot());
    }

    mr(mu muVar, oa oaVar, ot otVar) {
        this.a = muVar;
        this.b = oaVar;
        this.c = otVar;
        this.d = Collections.unmodifiableCollection(Arrays.asList(muVar, oaVar, otVar));
    }

    @Override // defpackage.bln
    public String a() {
        return "2.9.1.23";
    }

    @Override // defpackage.bln
    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override // defpackage.blo
    public Collection<? extends bln> c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bln
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void f() {
        return null;
    }

    public static mr e() {
        return (mr) blh.a(mr.class);
    }

    public static void a(int i, String str, String str2) {
        g();
        e().c.a(i, str, str2);
    }

    private static void g() {
        if (e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
