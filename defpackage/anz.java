package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import defpackage.bif;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class anz {
    private bhy b;
    private Context c;
    private agw d;
    private PlayListInfo e;
    private String h;
    private ImageView i;
    private agz k;
    private final float[][] a = {new float[]{0.0f, 0.0f, 1.0f, 1.0f}, new float[]{0.14999998f, 0.14999998f, 1.0f, 1.0f}, new float[]{0.0f, 0.27999997f, 0.72f, 1.0f}, new float[]{0.39999998f, 0.39999998f, 1.0f, 1.0f}};
    private int j = R.drawable.empty_cover_art_small;
    private Boolean l = false;
    private List<bip> f = new ArrayList();
    private List<Bitmap> g = new ArrayList();

    public anz(Context context, PlayListInfo playListInfo, ImageView imageView, bhy bhyVar) {
        this.c = context;
        this.b = bhyVar;
        this.e = playListInfo;
        while (this.g.size() < this.e.h.size()) {
            this.g.add(null);
        }
        this.h = Arrays.toString(playListInfo.h.toArray());
        this.i = imageView;
        this.k = new agz(this.e.h.size(), new Runnable() { // from class: anz.1
            @Override // java.lang.Runnable
            public void run() {
                mq.b().a(new Runnable() { // from class: anz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        anz.this.c();
                    }
                });
            }
        }, null);
    }

    public synchronized void a() {
        this.l = true;
        Iterator<bip> it = this.f.iterator();
        while (it.hasNext()) {
            bif.a(this.c).a(it.next());
        }
        this.g.clear();
    }

    public anz a(agw agwVar) {
        this.d = agwVar;
        return this;
    }

    public anz a(int i) {
        this.j = i;
        return this;
    }

    public void b() {
        if (this.j != -1) {
            this.i.setImageDrawable(this.c.getResources().getDrawable(this.j));
        }
        Bitmap bitmapA = this.b.a(this.h);
        if (bitmapA != null) {
            if (this.d != null) {
                this.d.a(bitmapA);
            }
            this.i.setImageBitmap(bitmapA);
        }
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 < this.e.h.size()) {
                this.f.add(new ahr(new bip() { // from class: anz.2
                    @Override // defpackage.bip
                    public void a(Bitmap bitmap, bif.d dVar) {
                        if (!anz.this.l.booleanValue()) {
                            anz.this.g.set(i2, bitmap);
                            anz.this.k.a();
                        }
                    }

                    @Override // defpackage.bip
                    public void a(Drawable drawable) {
                    }

                    @Override // defpackage.bip
                    public void b(Drawable drawable) {
                    }
                }));
                bif.a(this.c).a(this.e.h.get(i2)).a(this.f.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public synchronized void c() {
        synchronized (this) {
            if (!this.l.booleanValue()) {
                final Bitmap bitmapCopy = this.g.get(this.g.size() - 1).copy(Bitmap.Config.ARGB_8888, true);
                Canvas canvas = new Canvas(bitmapCopy);
                int height = bitmapCopy.getHeight();
                int width = bitmapCopy.getWidth();
                Rect rect = new Rect(0, 0, width, height);
                Paint paint = new Paint();
                paint.setShadowLayer(20.0f, 0.0f, 0.0f, -65536);
                for (int i = 1; i < this.g.size(); i++) {
                    canvas.drawBitmap(this.g.get((this.g.size() - 1) - i), rect, new RectF(width * this.a[i][0], height * this.a[i][1], width * this.a[i][2], height * this.a[i][3]), paint);
                }
                this.g.clear();
                this.b.a(this.h, bitmapCopy);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: anz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (anz.this.d != null) {
                            anz.this.d.a(bitmapCopy);
                        }
                        anz.this.i.setImageBitmap(bitmapCopy);
                    }
                });
            }
        }
    }
}
