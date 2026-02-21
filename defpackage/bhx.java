package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
class bhx extends bhm<ImageView> {
    bhq m;

    bhx(bif bifVar, ImageView imageView, bij bijVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, bhq bhqVar, boolean z) {
        super(bifVar, imageView, bijVar, i, i2, i3, drawable, str, obj, z);
        this.m = bhqVar;
    }

    @Override // defpackage.bhm
    public void a(Bitmap bitmap, bif.d dVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            big.a(imageView, this.a.c, bitmap, dVar, this.d, this.a.k);
            if (this.m != null) {
                this.m.a();
            }
        }
    }

    @Override // defpackage.bhm
    public void a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.m != null) {
                this.m.b();
            }
        }
    }

    @Override // defpackage.bhm
    void b() {
        super.b();
        if (this.m != null) {
            this.m = null;
        }
    }
}
