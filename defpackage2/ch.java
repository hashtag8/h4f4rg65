package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ch implements Iterable<Intent> {
    private static final c a;
    private final ArrayList<Intent> b = new ArrayList<>();
    private final Context c;

    public interface a {
        Intent a_();
    }

    static class c {
        c() {
        }
    }

    static class b extends c {
        b() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new c();
        }
    }

    private ch(Context context) {
        this.c = context;
    }

    public static ch a(Context context) {
        return new ch(context);
    }

    public ch a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ch a(Activity activity) {
        Intent intentA_ = null;
        if (activity instanceof a) {
            intentA_ = ((a) activity).a_();
        }
        Intent intentA = intentA_ == null ? bo.a(activity) : intentA_;
        if (intentA != null) {
            ComponentName component = intentA.getComponent();
            if (component == null) {
                component = intentA.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(intentA);
        }
        return this;
    }

    public ch a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent intentA = bo.a(this.c, componentName);
            while (intentA != null) {
                this.b.add(size, intentA);
                intentA = bo.a(this.c, intentA.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!ci.a(this.c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.c.startActivity(intent);
        }
    }
}
