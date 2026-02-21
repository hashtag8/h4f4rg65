package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class bc {
    private final bd<?> a;

    public static final bc a(bd<?> bdVar) {
        return new bc(bdVar);
    }

    private bc(bd<?> bdVar) {
        this.a = bdVar;
    }

    public be a() {
        return this.a.i();
    }

    public Fragment a(String str) {
        return this.a.d.b(str);
    }

    public void a(Fragment fragment) {
        this.a.d.a(this.a, this.a, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.d.onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.a.d.o();
    }

    public Parcelable c() {
        return this.a.d.n();
    }

    public void a(Parcelable parcelable, bg bgVar) {
        this.a.d.a(parcelable, bgVar);
    }

    public bg d() {
        return this.a.d.l();
    }

    public void e() {
        this.a.d.p();
    }

    public void f() {
        this.a.d.q();
    }

    public void g() {
        this.a.d.r();
    }

    public void h() {
        this.a.d.s();
    }

    public void i() {
        this.a.d.t();
    }

    public void j() {
        this.a.d.u();
    }

    public void k() {
        this.a.d.v();
    }

    public void l() {
        this.a.d.x();
    }

    public void a(boolean z) {
        this.a.d.a(z);
    }

    public void b(boolean z) {
        this.a.d.b(z);
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void m() {
        this.a.d.y();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public boolean n() {
        return this.a.d.i();
    }

    public void o() {
        this.a.k();
    }

    public void c(boolean z) {
        this.a.a(z);
    }

    public void p() {
        this.a.l();
    }

    public void q() {
        this.a.m();
    }

    public eg<String, bm> r() {
        return this.a.n();
    }

    public void a(eg<String, bm> egVar) {
        this.a.a(egVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.a.b(str, fileDescriptor, printWriter, strArr);
    }
}
