package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class fy {
    static final b a;

    interface b {
        ColorStateList a(ImageView imageView);

        void a(ImageView imageView, ColorStateList colorStateList);

        void a(ImageView imageView, PorterDuff.Mode mode);

        PorterDuff.Mode b(ImageView imageView);
    }

    static class a implements b {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fy.b
        public ColorStateList a(ImageView imageView) {
            if (imageView instanceof gg) {
                return ((gg) imageView).getSupportImageTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fy.b
        public void a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof gg) {
                ((gg) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fy.b
        public void a(ImageView imageView, PorterDuff.Mode mode) {
            if (imageView instanceof gg) {
                ((gg) imageView).setSupportImageTintMode(mode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fy.b
        public PorterDuff.Mode b(ImageView imageView) {
            if (imageView instanceof gg) {
                return ((gg) imageView).getSupportImageTintMode();
            }
            return null;
        }
    }

    static class c extends a {
        c() {
        }

        @Override // fy.a, fy.b
        public ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @Override // fy.a, fy.b
        public void a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @Override // fy.a, fy.b
        public void a(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @Override // fy.a, fy.b
        public PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            a = new c();
        } else {
            a = new a();
        }
    }

    public static ColorStateList a(ImageView imageView) {
        return a.a(imageView);
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        a.a(imageView, colorStateList);
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        return a.b(imageView);
    }

    public static void a(ImageView imageView, PorterDuff.Mode mode) {
        a.a(imageView, mode);
    }
}
