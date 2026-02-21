package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ahe {
    public static void a(final ContentResolver contentResolver, final Uri uri, final agw agwVar) {
        mq.b().execute(new Runnable() { // from class: ahe.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                    inputStreamOpenInputStream.close();
                    mo.a.post(new Runnable() { // from class: ahe.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            agwVar.a(bitmapDecodeStream);
                        }
                    });
                } catch (Throwable th) {
                    mo.a.post(new Runnable() { // from class: ahe.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            agwVar.a(null);
                        }
                    });
                }
            }
        });
    }

    public static Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        view.clearFocus();
        view.setPressed(false);
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        float alpha = view.getAlpha();
        view.setAlpha(1.0f);
        if (drawingCacheBackgroundColor != 0) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        view.setAlpha(alpha);
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    public static View a(Context context, View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        Bitmap bitmapCreateBitmap = null;
        view.setDrawingCacheEnabled(true);
        if (view != null && view.getDrawingCache() != null) {
            bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache());
        }
        view.setDrawingCacheEnabled(false);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(new BitmapDrawable(bitmapCreateBitmap));
        imageView.setLayoutParams(new AbsListView.LayoutParams(width, height));
        return imageView;
    }

    public static void a(ImageView imageView) {
        imageView.setColorFilter(Color.rgb(Color.red(11776947), Color.green(11776947), Color.blue(11776947)), PorterDuff.Mode.MULTIPLY);
    }
}
