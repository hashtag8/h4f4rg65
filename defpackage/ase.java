package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
public class ase extends Dialog {
    private Runnable a;
    private boolean b;

    public ase(Context context) {
        super(context);
    }

    public ase(Context context, int i) {
        super(context, i);
    }

    public void a(Runnable runnable) {
        this.a = runnable;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Runnable runnable = new Runnable() { // from class: ase.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ase.super.dismiss();
                } catch (RuntimeException e) {
                    mm.b("Suppressing error on dismiss, has the activity finished?", e);
                }
            }
        };
        if (this.a == null) {
            mo.a.a(runnable);
        } else if (isShowing()) {
            mo.a.a(this.a);
            mo.a.post(runnable);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.b = false;
        super.onStart();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        this.b = true;
        super.cancel();
    }

    public boolean c() {
        return this.b;
    }

    public void a(final View view) {
        view.setTag(R.id.backgroundCallback, new bip() { // from class: ase.2
            @Override // defpackage.bip
            public void a(Bitmap bitmap, bif.d dVar) {
                view.setBackground(new BitmapDrawable(ase.this.getContext().getResources(), bitmap));
            }

            @Override // defpackage.bip
            public void a(Drawable drawable) {
            }

            @Override // defpackage.bip
            public void b(Drawable drawable) {
            }
        });
        new ahw().a(view, new ahq() { // from class: ase.3
            @Override // defpackage.ahq
            public void a(final View view2) {
                bif.a(ase.this.getContext()).a(R.drawable.central_content).a(new bir() { // from class: ase.3.1
                    int a;
                    int b;

                    @Override // defpackage.bir
                    public Bitmap a(Bitmap bitmap) {
                        int iRound = Math.round((ase.b(ase.this.getContext()) * bitmap.getHeight()) / (ase.b(ase.this.getContext()) + view2.getHeight()));
                        int iRound2 = Math.round((ase.c(ase.this.getContext()) * bitmap.getHeight()) / (ase.c(ase.this.getContext()) + view2.getHeight()));
                        if (ase.this.getWindow().getDecorView().getHeight() - view2.getHeight() == ase.b(ase.this.getContext())) {
                            this.a = 0;
                            this.b = bitmap.getHeight() - iRound;
                        } else if (ase.this.getWindow().getDecorView().getHeight() - view2.getHeight() == ase.c(ase.this.getContext())) {
                            this.a = iRound2;
                            this.b = bitmap.getHeight() - iRound2;
                        } else if (ase.this.getWindow().getDecorView().getHeight() - view2.getHeight() == ase.c(ase.this.getContext()) + ase.b(ase.this.getContext())) {
                            this.a = iRound2;
                            this.b = (bitmap.getHeight() - iRound2) - iRound;
                        } else {
                            return bitmap;
                        }
                        Log.d("recycle test", "height = " + this.b + " , source.getHeight() = " + bitmap.getHeight());
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, this.a, bitmap.getWidth(), this.b);
                        if (bitmapCreateBitmap != bitmap) {
                            Log.d("recycle test", "resizedBitmap != source");
                            bitmap.recycle();
                        } else {
                            Log.d("recycle test", "resizedBitmap == source");
                        }
                        return bitmapCreateBitmap;
                    }

                    @Override // defpackage.bir
                    public String a() {
                        return "2130837632 " + this.a + " " + this.b;
                    }
                }).a((bip) view2.getTag(R.id.backgroundCallback));
            }
        });
    }

    public static float b(Context context) {
        if (context.getResources().getIdentifier("navigation_bar_height", "dimen", "android") == 0) {
            return 0.0f;
        }
        return context.getResources().getDimensionPixelSize(r0);
    }

    public static float c(Context context) {
        if (context.getResources().getIdentifier("status_bar_height", "dimen", "android") == 0) {
            return 0.0f;
        }
        return context.getResources().getDimensionPixelSize(r0);
    }
}
