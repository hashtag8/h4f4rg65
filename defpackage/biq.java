package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
final class biq extends bhm<bip> {
    biq(bif bifVar, bip bipVar, bij bijVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(bifVar, bipVar, bijVar, i, i2, i3, drawable, str, obj, false);
    }

    @Override // defpackage.bhm
    void a(Bitmap bitmap, bif.d dVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        bip bipVarD = d();
        if (bipVarD != null) {
            bipVarD.a(bitmap, dVar);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    @Override // defpackage.bhm
    void a() {
        bip bipVarD = d();
        if (bipVarD != null) {
            if (this.g != 0) {
                bipVarD.a(this.a.c.getResources().getDrawable(this.g));
            } else {
                bipVarD.a(this.h);
            }
        }
    }
}
