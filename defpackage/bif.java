package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import defpackage.bhm;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class bif {
    static final Handler a = new Handler(Looper.getMainLooper()) { // from class: bif.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3:
                    bhm bhmVar = (bhm) message.obj;
                    if (bhmVar.j().l) {
                        bit.a("Main", "canceled", bhmVar.b.a(), "target got garbage collected");
                    }
                    bhmVar.a.c(bhmVar.d());
                    return;
                case 8:
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        bho bhoVar = (bho) list.get(i);
                        bhoVar.b.a(bhoVar);
                    }
                    return;
                case 13:
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        bhm bhmVar2 = (bhm) list2.get(i2);
                        bhmVar2.a.c(bhmVar2);
                    }
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    };
    static volatile bif b = null;
    final Context c;
    final bhu d;
    final bhp e;
    final bin f;
    final Map<Object, bhm> g;
    final Map<ImageView, bht> h;
    final ReferenceQueue<Object> i;
    final Bitmap.Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final c n;
    private final f o;
    private final b p;
    private final List<bil> q;

    public interface c {
        void a(bif bifVar, Uri uri, Exception exc);
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {
        public static final f a = new f() { // from class: bif.f.1
            @Override // bif.f
            public bij a(bij bijVar) {
                return bijVar;
            }
        };

        bij a(bij bijVar);
    }

    bif(Context context, bhu bhuVar, bhp bhpVar, c cVar, f fVar, List<bil> list, bin binVar, Bitmap.Config config, boolean z, boolean z2) {
        this.c = context;
        this.d = bhuVar;
        this.e = bhpVar;
        this.n = cVar;
        this.o = fVar;
        this.j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new bim(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new bhr(context));
        arrayList.add(new bia(context));
        arrayList.add(new bhs(context));
        arrayList.add(new bhn(context));
        arrayList.add(new bhw(context));
        arrayList.add(new bid(bhuVar.d, binVar));
        this.q = Collections.unmodifiableList(arrayList);
        this.f = binVar;
        this.g = new WeakHashMap();
        this.h = new WeakHashMap();
        this.k = z;
        this.l = z2;
        this.i = new ReferenceQueue<>();
        this.p = new b(this.i, a);
        this.p.start();
    }

    public void a(ImageView imageView) {
        c(imageView);
    }

    public void a(bip bipVar) {
        c(bipVar);
    }

    public void a(Object obj) {
        this.d.a(obj);
    }

    public void b(Object obj) {
        this.d.b(obj);
    }

    public bik a(Uri uri) {
        return new bik(this, uri, 0);
    }

    public bik a(String str) {
        if (str == null) {
            return new bik(this, null, 0);
        }
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Path must not be empty.");
        }
        return a(Uri.parse(str));
    }

    public bik a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Resource ID must not be zero.");
        }
        return new bik(this, null, i);
    }

    public bio a() {
        return this.f.e();
    }

    List<bil> b() {
        return this.q;
    }

    bij a(bij bijVar) {
        bij bijVarA = this.o.a(bijVar);
        if (bijVarA == null) {
            throw new IllegalStateException("Request transformer " + this.o.getClass().getCanonicalName() + " returned null for " + bijVar);
        }
        return bijVarA;
    }

    void a(ImageView imageView, bht bhtVar) {
        this.h.put(imageView, bhtVar);
    }

    void a(bhm bhmVar) {
        Object objD = bhmVar.d();
        if (objD != null && this.g.get(objD) != bhmVar) {
            c(objD);
            this.g.put(objD, bhmVar);
        }
        b(bhmVar);
    }

    void b(bhm bhmVar) {
        this.d.a(bhmVar);
    }

    Bitmap b(String str) {
        Bitmap bitmapA = this.e.a(str);
        if (bitmapA != null) {
            this.f.a();
        } else {
            this.f.b();
        }
        return bitmapA;
    }

    void a(bho bhoVar) {
        boolean z = true;
        bhm bhmVarI = bhoVar.i();
        List<bhm> listK = bhoVar.k();
        boolean z2 = (listK == null || listK.isEmpty()) ? false : true;
        if (bhmVarI == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = bhoVar.h().d;
            Exception excL = bhoVar.l();
            Bitmap bitmapE = bhoVar.e();
            d dVarM = bhoVar.m();
            if (bhmVarI != null) {
                a(bitmapE, dVarM, bhmVarI);
            }
            if (z2) {
                int size = listK.size();
                for (int i = 0; i < size; i++) {
                    a(bitmapE, dVarM, listK.get(i));
                }
            }
            if (this.n != null && excL != null) {
                this.n.a(this, uri, excL);
            }
        }
    }

    void c(bhm bhmVar) {
        Bitmap bitmapB = null;
        if (bib.a(bhmVar.e)) {
            bitmapB = b(bhmVar.e());
        }
        if (bitmapB != null) {
            a(bitmapB, d.MEMORY, bhmVar);
            if (this.l) {
                bit.a("Main", "completed", bhmVar.b.a(), "from " + d.MEMORY);
                return;
            }
            return;
        }
        a(bhmVar);
        if (this.l) {
            bit.a("Main", "resumed", bhmVar.b.a());
        }
    }

    private void a(Bitmap bitmap, d dVar, bhm bhmVar) {
        if (!bhmVar.f()) {
            if (!bhmVar.g()) {
                this.g.remove(bhmVar.d());
            }
            if (bitmap != null) {
                if (dVar == null) {
                    throw new AssertionError("LoadedFrom cannot be null.");
                }
                bhmVar.a(bitmap, dVar);
                if (this.l) {
                    bit.a("Main", "completed", bhmVar.b.a(), "from " + dVar);
                    return;
                }
                return;
            }
            bhmVar.a();
            if (this.l) {
                bit.a("Main", "errored", bhmVar.b.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        bit.a();
        bhm bhmVarRemove = this.g.remove(obj);
        if (bhmVarRemove != null) {
            bhmVarRemove.b();
            this.d.b(bhmVarRemove);
        }
        if (obj instanceof ImageView) {
            bht bhtVarRemove = this.h.remove((ImageView) obj);
            if (bhtVarRemove != null) {
                bhtVarRemove.a();
            }
        }
    }

    static class b extends Thread {
        private final ReferenceQueue<Object> a;
        private final Handler b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.a = referenceQueue;
            this.b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    bhm.a aVar = (bhm.a) this.a.remove(1000L);
                    Message messageObtainMessage = this.b.obtainMessage();
                    if (aVar != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = aVar.a;
                        this.b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e2) {
                    this.b.post(new Runnable() { // from class: bif.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }
    }

    public static bif a(Context context) {
        if (b == null) {
            synchronized (bif.class) {
                if (b == null) {
                    b = new a(context).a();
                }
            }
        }
        return b;
    }

    public static void a(bif bifVar) {
        synchronized (bif.class) {
            if (b != null) {
                throw new IllegalStateException("Singleton instance already exists.");
            }
            b = bifVar;
        }
    }

    public static class a {
        private final Context a;
        private bhv b;
        private ExecutorService c;
        private bhp d;
        private c e;
        private f f;
        private List<bil> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context.getApplicationContext();
        }

        public a a(bhv bhvVar) {
            if (bhvVar == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            }
            if (this.b != null) {
                throw new IllegalStateException("Downloader already set.");
            }
            this.b = bhvVar;
            return this;
        }

        public a a(bhp bhpVar) {
            if (bhpVar == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            }
            if (this.d != null) {
                throw new IllegalStateException("Memory cache already set.");
            }
            this.d = bhpVar;
            return this;
        }

        public bif a() {
            Context context = this.a;
            if (this.b == null) {
                this.b = bit.a(context);
            }
            if (this.d == null) {
                this.d = new bhy(context);
            }
            if (this.c == null) {
                this.c = new bih();
            }
            if (this.f == null) {
                this.f = f.a;
            }
            bin binVar = new bin(this.d);
            return new bif(context, new bhu(context, this.c, bif.a, this.b, this.d, binVar), this.d, this.e, this.f, this.g, binVar, this.h, this.i, this.j);
        }
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);

        final int d;

        d(int i) {
            this.d = i;
        }
    }
}
