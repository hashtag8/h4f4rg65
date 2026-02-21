package defpackage;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class bnk<T> {
    protected final Context a;
    protected final bnj<T> b;
    protected final bmg c;
    protected final bnl d;
    protected volatile long e;
    protected final List<bnm> f = new CopyOnWriteArrayList();
    private final int g;

    protected abstract String a();

    public bnk(Context context, bnj<T> bnjVar, bmg bmgVar, bnl bnlVar, int i) {
        this.a = context.getApplicationContext();
        this.b = bnjVar;
        this.d = bnlVar;
        this.c = bmgVar;
        this.e = this.c.a();
        this.g = i;
    }

    public void a(T t) {
        byte[] bArrA = this.b.a(t);
        a(bArrA.length);
        this.d.a(bArrA);
    }

    public void a(bnm bnmVar) {
        if (bnmVar != null) {
            this.f.add(bnmVar);
        }
    }

    public boolean d() {
        boolean z = true;
        String strA = null;
        if (this.d.b()) {
            z = false;
        } else {
            strA = a();
            this.d.a(strA);
            bme.a(this.a, 4, "Fabric", String.format(Locale.US, "generated new file %s", strA));
            this.e = this.c.a();
        }
        b(strA);
        return z;
    }

    private void a(int i) {
        if (!this.d.a(i, c())) {
            bme.a(this.a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.d.a()), Integer.valueOf(i), Integer.valueOf(c())));
            d();
        }
    }

    protected int b() {
        return this.g;
    }

    protected int c() {
        return 8000;
    }

    private void b(String str) {
        Iterator<bnm> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(str);
            } catch (Exception e) {
                bme.a(this.a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> e() {
        return this.d.a(1);
    }

    public void a(List<File> list) {
        this.d.a(list);
    }

    public void f() {
        this.d.a(this.d.c());
        this.d.d();
    }

    public void g() {
        List<File> listC = this.d.c();
        int iB = b();
        if (listC.size() > iB) {
            int size = listC.size() - iB;
            bme.a(this.a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(listC.size()), Integer.valueOf(iB), Integer.valueOf(size)));
            TreeSet treeSet = new TreeSet(new Comparator<a>() { // from class: bnk.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(a aVar, a aVar2) {
                    return (int) (aVar.b - aVar2.b);
                }
            });
            for (File file : listC) {
                treeSet.add(new a(file, a(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.d.a(arrayList);
        }
    }

    public long a(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(strArrSplit[2]).longValue();
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    static class a {
        final File a;
        final long b;

        public a(File file, long j) {
            this.a = file;
            this.b = j;
        }
    }
}
