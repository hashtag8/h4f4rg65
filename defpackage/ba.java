package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import defpackage.at;
import defpackage.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ba extends ax implements at.a, at.b {
    boolean e;
    boolean f;
    boolean i;
    boolean j;
    int k;
    eh<String> l;
    final Handler c = new Handler() { // from class: ba.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (ba.this.g) {
                        ba.this.a(false);
                    }
                    break;
                case 2:
                    ba.this.e_();
                    ba.this.d.n();
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    };
    final bc d = bc.a(new a());
    boolean g = true;
    boolean h = true;

    @Override // defpackage.aw, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // defpackage.aw, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // defpackage.ax, android.app.Activity
    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // defpackage.aw, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // defpackage.ax, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static final class b {
        Object a;
        bg b;
        eg<String, bm> c;

        b() {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.d.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String strA = this.l.a(i4);
            this.l.c(i4);
            if (strA == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentA = this.d.a(strA);
            if (fragmentA == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strA);
                return;
            } else {
                fragmentA.a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        be beVarA = this.d.a();
        boolean zG = beVarA.g();
        if (!zG || Build.VERSION.SDK_INT > 25) {
            if (zG || !beVarA.d()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.a(configuration);
    }

    @Override // defpackage.cg, defpackage.e
    public d d_() {
        return super.d_();
    }

    @Override // defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.d.a((Fragment) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.d.a(bVar.c);
        }
        if (bundle != null) {
            this.d.a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new eh<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.l.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new eh<>();
            this.k = 0;
        }
        this.d.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.d.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // defpackage.aw
    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.d.l();
        this.d.p();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.d.a(menuItem);
            case 6:
                return this.d.b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.d.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            e_();
        }
        this.d.i();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.d.b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.n();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        e_();
        this.d.n();
    }

    protected void e_() {
        this.d.h();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.d.a(menu);
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.g) {
            a(true);
        }
        Object objC = c();
        bg bgVarD = this.d.d();
        eg<String, bm> egVarR = this.d.r();
        if (bgVarD == null && egVarR == null && objC == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = objC;
        bVar.b = bgVarD;
        bVar.c = egVarR;
        return bVar;
    }

    @Override // defpackage.cg, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a(f(), d.b.CREATED);
        Parcelable parcelableC = this.d.c();
        if (parcelableC != null) {
            bundle.putParcelable("android:support:fragments", parcelableC);
        }
        if (this.l.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.l.b()];
            String[] strArr = new String[this.l.b()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.l.b()) {
                    iArr[i2] = this.l.d(i2);
                    strArr[i2] = this.l.e(i2);
                    i = i2 + 1;
                } else {
                    bundle.putIntArray("android:support:request_indicies", iArr);
                    bundle.putStringArray("android:support:request_fragment_who", strArr);
                    return;
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.o();
        this.d.g();
        this.d.q();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.g = true;
        a(f(), d.b.CREATED);
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public Object c() {
        return null;
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.e);
        printWriter.print("mResumed=");
        printWriter.print(this.f);
        printWriter.print(" mStopped=");
        printWriter.print(this.g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.h);
        this.d.a(str2, fileDescriptor, printWriter, strArr);
        this.d.a().a(str, fileDescriptor, printWriter, strArr);
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            e();
            return;
        }
        if (z) {
            this.d.o();
            this.d.c(true);
        }
    }

    void e() {
        this.d.c(this.i);
        this.d.k();
    }

    public void a(Fragment fragment) {
    }

    public be f() {
        return this.d.a();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.b && i != -1) {
            b(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // at.b
    public final void a(int i) {
        if (!this.j && i != -1) {
            b(i);
        }
    }

    @Override // android.app.Activity, at.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strA = this.l.a(i3);
            this.l.c(i3);
            if (strA == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentA = this.d.a(strA);
            if (fragmentA == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strA);
            } else {
                fragmentA.a(i & 65535, strArr, iArr);
            }
        }
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.b = true;
        try {
            if (i == -1) {
                at.a(this, intent, -1, bundle);
            } else {
                b(i);
                at.a(this, intent, ((b(fragment) + 1) << 16) + (65535 & i), bundle);
                this.b = false;
            }
        } finally {
            this.b = false;
        }
    }

    private int b(Fragment fragment) {
        if (this.l.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.l.f(this.k) >= 0) {
            this.k = (this.k + 1) % 65534;
        }
        int i = this.k;
        this.l.b(i, fragment.o);
        this.k = (this.k + 1) % 65534;
        return i;
    }

    void a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            at.a(this, strArr, i);
            return;
        }
        b(i);
        try {
            this.j = true;
            at.a(this, strArr, ((b(fragment) + 1) << 16) + (65535 & i));
        } finally {
            this.j = false;
        }
    }

    class a extends bd<ba> {
        public a() {
            super(ba.this);
        }

        @Override // defpackage.bd
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            ba.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // defpackage.bd
        public boolean a(Fragment fragment) {
            return !ba.this.isFinishing();
        }

        @Override // defpackage.bd
        public LayoutInflater b() {
            return ba.this.getLayoutInflater().cloneInContext(ba.this);
        }

        @Override // defpackage.bd
        public void c() {
            ba.this.d();
        }

        @Override // defpackage.bd
        public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            ba.this.a(fragment, intent, i, bundle);
        }

        @Override // defpackage.bd
        public void a(Fragment fragment, String[] strArr, int i) {
            ba.this.a(fragment, strArr, i);
        }

        @Override // defpackage.bd
        public boolean d() {
            return ba.this.getWindow() != null;
        }

        @Override // defpackage.bd
        public int e() {
            Window window = ba.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // defpackage.bd
        public void b(Fragment fragment) {
            ba.this.a(fragment);
        }

        @Override // defpackage.bd, defpackage.bb
        public View a(int i) {
            return ba.this.findViewById(i);
        }

        @Override // defpackage.bd, defpackage.bb
        public boolean a() {
            Window window = ba.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    private static void a(be beVar, d.b bVar) {
        for (Fragment fragment : beVar.f()) {
            if (fragment != null) {
                fragment.ad.a(bVar);
                a(fragment.s(), bVar);
            }
        }
    }
}
