package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
public class agx {
    private static agx a = null;
    private final bhy b = new bhy(HarmanApplication.a());
    private RenderScript c = null;

    public static synchronized agx a() {
        if (a == null) {
            a = new agx();
        }
        return a;
    }

    protected agx() {
        bfe bfeVar = new bfe();
        bfeVar.a(true);
        bif.a(new bif.a(HarmanApplication.a()).a(this.b).a(new bie(bfeVar)).a());
    }

    public void b() {
        this.b.c();
        c();
    }

    private synchronized void c() {
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized RenderScript d() {
        if (this.c == null) {
            this.c = RenderScript.create(HarmanApplication.a());
        }
        return this.c;
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
        return bitmap;
    }

    public void a(Bitmap bitmap, final float f, final float f2, final boolean z, final agw agwVar) {
        final Bitmap bitmapA = a(bitmap);
        mq.b().execute(new Runnable() { // from class: agx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, Math.round(bitmapA.getWidth() * f2), Math.round(bitmapA.getHeight() * f2), false);
                    final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                    RenderScript renderScriptD = agx.this.d();
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptD, Element.U8_4(renderScriptD));
                    Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptD, bitmapCreateScaledBitmap);
                    Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptD, bitmapCreateBitmap);
                    scriptIntrinsicBlurCreate.setRadius(f);
                    scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                    scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                    allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                    if (z) {
                        mm.b("BlurUtil ", " calling imageToBlur.recycle()..");
                        bitmapA.recycle();
                    }
                    mo.a.post(new Runnable() { // from class: agx.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            agwVar.a(bitmapCreateBitmap);
                        }
                    });
                } catch (Throwable th) {
                    mm.e("Could not blur image", th);
                    mo.a.post(new Runnable() { // from class: agx.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            agwVar.a(bitmapA);
                        }
                    });
                }
            }
        });
    }

    public void a(Bitmap bitmap, boolean z, agw agwVar) {
        a(bitmap, 20.5f, 0.4f, z, agwVar);
    }

    public void a(final ImageView imageView, final ImageView imageView2, Bitmap bitmap, final int i) {
        if (bitmap == null) {
            a(new agw() { // from class: agx.2
                @Override // defpackage.agw
                public void a(Bitmap bitmap2) {
                    agx.this.a(imageView, imageView2, bitmap2, i);
                }
            });
            return;
        }
        imageView.clearAnimation();
        imageView2.clearAnimation();
        imageView.setImageBitmap(bitmap);
        imageView2.setImageBitmap(bitmap);
    }

    public void a(ImageView imageView, ImageView imageView2, Bitmap bitmap) {
        a(imageView, imageView2, bitmap, 1000);
    }

    public void a(int i, agw agwVar) {
        String str = "blur*" + i;
        Bitmap bitmapA = this.b.a(str);
        if (bitmapA != null) {
            agwVar.a(bitmapA);
        }
        mo.a.a(new AnonymousClass3(i, str, agwVar));
    }

    /* JADX INFO: renamed from: agx$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ agw c;

        AnonymousClass3(int i, String str, agw agwVar) {
            this.a = i;
            this.b = str;
            this.c = agwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bif.a((Context) HarmanApplication.a()).a(this.a).a((bip) new ahr(new bip() { // from class: agx.3.1
                @Override // defpackage.bip
                public void a(Bitmap bitmap, bif.d dVar) {
                    agx.this.a(bitmap, false, new agw() { // from class: agx.3.1.1
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap2) {
                            agx.this.b.a(AnonymousClass3.this.b, bitmap2);
                            AnonymousClass3.this.c.a(bitmap2);
                        }
                    });
                }

                @Override // defpackage.bip
                public void a(Drawable drawable) {
                    mm.e("Could not load resource %s", HarmanApplication.a().getResources().getResourceName(AnonymousClass3.this.a));
                }

                @Override // defpackage.bip
                public void b(Drawable drawable) {
                }
            }));
        }
    }

    public void a(agw agwVar) {
        a(R.drawable.albumart_default_large, agwVar);
    }

    public void b(agw agwVar) {
        a(R.drawable.empty_no_cover_art, agwVar);
    }

    public void c(agw agwVar) {
        a(R.drawable.bluetooth_state, agwVar);
    }

    public void d(agw agwVar) {
        a(R.drawable.spotify_source_image, agwVar);
    }

    public void e(agw agwVar) {
        a(R.drawable.google_cast_big_image, agwVar);
    }

    public void f(agw agwVar) {
        a(R.drawable.airplay_big_image, agwVar);
    }

    public void g(agw agwVar) {
        a(R.drawable.a_u_x_emptystate_icon_big, agwVar);
    }

    public void h(agw agwVar) {
        a(R.drawable.opticalbig, agwVar);
    }

    public void b(final int i, final agw agwVar) {
        mo.a.a(new Runnable() { // from class: agx.4
            @Override // java.lang.Runnable
            public void run() {
                bif.a((Context) HarmanApplication.a()).a(i).a((bip) new ahr(new bip() { // from class: agx.4.1
                    @Override // defpackage.bip
                    public void a(Bitmap bitmap, bif.d dVar) {
                        agwVar.a(bitmap);
                    }

                    @Override // defpackage.bip
                    public void a(Drawable drawable) {
                        mm.e("Could not load resource %s", HarmanApplication.a().getResources().getResourceName(i));
                    }

                    @Override // defpackage.bip
                    public void b(Drawable drawable) {
                    }
                }));
            }
        });
    }

    public anz a(Context context, PlayListInfo playListInfo, ImageView imageView) {
        anz anzVar = (anz) imageView.getTag(R.id.qobuz_playlist_image_loader);
        if (anzVar != null) {
            anzVar.a();
        }
        anz anzVar2 = new anz(context, playListInfo, imageView, this.b);
        imageView.setTag(R.id.qobuz_playlist_image_loader, anzVar2);
        return anzVar2;
    }
}
