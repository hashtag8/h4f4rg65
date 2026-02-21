package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ev {
    private final ViewGroup a;
    private int b;

    public ev(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        this.b = 0;
    }
}
