package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import defpackage.bif;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ahr implements bip {
    private static Set<bip> a = new HashSet();
    private final bip b;

    public ahr(bip bipVar) {
        this.b = bipVar;
        a.add(this);
    }

    @Override // defpackage.bip
    public void a(Bitmap bitmap, bif.d dVar) {
        a.remove(this);
        this.b.a(bitmap, dVar);
    }

    @Override // defpackage.bip
    public void a(Drawable drawable) {
        a.remove(this);
        this.b.a(drawable);
    }

    @Override // defpackage.bip
    public void b(Drawable drawable) {
        this.b.b(drawable);
    }
}
