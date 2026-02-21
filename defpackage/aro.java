package defpackage;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ImageView;
import com.harman.hkconnect.ui.HarmanApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class aro {
    private ArrayList<a> a;
    private int b;
    private volatile boolean c;
    private boolean d;
    private WeakReference<ImageView> e;
    private Handler f;
    private e g;
    private d h;
    private int i;
    private int j;
    private int k;

    public interface d {
        void a(int i);
    }

    public interface e {
        void a();
    }

    class a {
        private int b;
        private int c;

        a(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }
    }

    public aro(ImageView imageView) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        a(imageView);
    }

    public aro(ImageView imageView, int i) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        a(imageView);
        this.i = i;
    }

    public void a(int i) {
        this.j = i;
        this.k = this.j;
    }

    public boolean a() {
        return this.d;
    }

    public void a(ImageView imageView) {
        this.a = new ArrayList<>();
        this.e = new WeakReference<>(imageView);
        this.f = new Handler();
        if (this.d) {
            d();
        }
        this.c = false;
        this.d = false;
        this.b = -1;
    }

    public void a(int[] iArr, int i) {
        for (int i2 : iArr) {
            this.a.add(new a(i2, i));
        }
    }

    public void b(int[] iArr, int i) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            this.a.add(new a(iArr[length], i));
        }
    }

    public void b() {
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a f() {
        this.b++;
        if (this.b >= this.a.size()) {
            this.b = 0;
        }
        return this.a.get(this.b);
    }

    public void a(e eVar) {
        this.g = eVar;
    }

    public synchronized void c() {
        mm.b("CLLOG ANIMATION START " + this, new Object[0]);
        this.c = true;
        if (!this.d) {
            this.f.post(new b());
        }
    }

    public synchronized void b(int i) {
        mm.b("CLLOG ANIMATION START " + this, new Object[0]);
        this.c = true;
        if (!this.d) {
            this.f.postDelayed(new b(), i);
        }
    }

    public void d() {
        mm.b("CLLOG ANIMATION STOP NOW", new Object[0]);
        this.c = false;
    }

    public synchronized void e() {
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean g() {
        boolean z = true;
        synchronized (this) {
            if (this.j != 0) {
                if (this.k == -1) {
                    z = false;
                } else {
                    if (this.b + 1 >= this.a.size()) {
                        this.k--;
                    }
                    if (this.k != 0) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = (ImageView) aro.this.e.get();
            if (!aro.this.c || imageView == null) {
                mm.b("CLLOG ANIMATION STOPPED " + aro.this.c + " " + aro.this, new Object[0]);
                aro.this.d = false;
                if (aro.this.g != null) {
                    aro.this.g.a();
                    return;
                }
                return;
            }
            aro.this.d = true;
            if (!imageView.isShown()) {
            }
            a aVarF = aro.this.f();
            if (aro.this.g()) {
                aro.this.d();
            }
            aro.this.new c(imageView).execute(Integer.valueOf(aVarF.a()));
            aro.this.f.postDelayed(this, aVarF.b());
        }
    }

    class c extends AsyncTask<Integer, Void, Drawable> {
        private ImageView b;

        public c(ImageView imageView) {
            this.b = imageView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Integer... numArr) {
            return HarmanApplication.a().getResources().getDrawable(numArr[0].intValue());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            super.onPostExecute(drawable);
            if (drawable != null) {
                this.b.setImageDrawable(drawable);
                if (aro.this.i != -1) {
                    this.b.setColorFilter(aro.this.i);
                }
            }
            if (aro.this.h != null) {
                aro.this.h.a(aro.this.b);
            }
        }
    }
}
