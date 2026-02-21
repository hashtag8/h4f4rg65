package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.bif;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ahw {
    public static boolean a = false;
    public static boolean b = true;

    public void a(View view, ahq ahqVar) {
        view.setTag(R.id.viewFitter_for, ahqVar);
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0) {
            ahqVar.a(view);
        } else {
            final WeakReference weakReference = new WeakReference(view);
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ahw.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    View view2 = (View) weakReference.get();
                    if (view2 != null) {
                        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            int width2 = view2.getWidth();
                            int height2 = view2.getHeight();
                            if (width2 > 0 && height2 > 0) {
                                viewTreeObserver.removeOnPreDrawListener(this);
                                ahq ahqVar2 = (ahq) view2.getTag(R.id.viewFitter_for);
                                if (ahqVar2 != null) {
                                    ahqVar2.a(view2);
                                    view2.setTag(R.id.viewFitter_for, null);
                                }
                            }
                        }
                    }
                    return true;
                }
            });
        }
    }

    public void a(final ImageView imageView, final bik bikVar) {
        a(imageView, new ahq() { // from class: ahw.2
            @Override // defpackage.ahq
            public void a(View view) {
                if (imageView.getScaleType() == ImageView.ScaleType.CENTER_CROP) {
                    bikVar.c();
                } else if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                    bikVar.d();
                }
                bikVar.b(view.getWidth(), view.getHeight()).e().a(imageView);
            }
        });
    }

    public void a(final ImageView imageView, final bik bikVar, final agw agwVar) {
        a(imageView, new ahq() { // from class: ahw.3
            @Override // defpackage.ahq
            public void a(View view) {
                bip bipVar = new bip() { // from class: ahw.3.1
                    @Override // defpackage.bip
                    public void a(Bitmap bitmap, bif.d dVar) {
                        imageView.setImageBitmap(bitmap);
                        agwVar.a(bitmap);
                    }

                    @Override // defpackage.bip
                    public void a(Drawable drawable) {
                    }

                    @Override // defpackage.bip
                    public void b(Drawable drawable) {
                    }
                };
                imageView.setTag(R.id.viewFitter_target, bipVar);
                if (imageView.getScaleType() == ImageView.ScaleType.CENTER_CROP) {
                    bikVar.c();
                } else if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                    bikVar.d();
                }
                bikVar.b(view.getWidth(), view.getHeight()).e().a(bipVar);
            }
        });
    }

    public void a(ImageView imageView, String str) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!TextUtils.isEmpty(str)) {
            a(imageView, bif.a((Context) HarmanApplication.a()).a(str).a(R.drawable.empty_cover_art_small));
        }
    }

    public void a(ImageView imageView, long j, int i, boolean z, int i2) {
        Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), j);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bik bikVarA = bif.a((Context) HarmanApplication.a()).a(uriWithAppendedId).a(i);
        if (i2 != -1) {
            bikVarA.b(i2);
        }
        if (z) {
            a(imageView, bikVarA);
        } else {
            bikVarA.a(imageView);
        }
    }

    public void a(ImageView imageView, long j, int i, boolean z) {
        a(imageView, j, i, z, -1);
    }
}
