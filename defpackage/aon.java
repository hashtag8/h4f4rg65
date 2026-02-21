package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aon {
    private Context a;
    private List<aop> b = new ArrayList();
    private int c;

    public aon(Context context) {
        this.a = context;
    }

    public Context a() {
        return this.a;
    }

    public void a(aop aopVar) {
        this.b.add(aopVar);
    }

    public List<aop> b() {
        return this.b;
    }

    public void a(int i) {
        this.c = i;
    }
}
