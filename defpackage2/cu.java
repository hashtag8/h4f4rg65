package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import defpackage.cl;
import defpackage.cq;
import defpackage.ds;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class cu implements cq.a {

    interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    cu() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        T t;
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t2 = null;
        int i3 = Integer.MAX_VALUE;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t3 = tArr[i4];
            int iAbs = (aVar.a(t3) == z ? 0 : 1) + (Math.abs(aVar.b(t3) - i2) * 2);
            if (t2 == null || i3 > iAbs) {
                i3 = iAbs;
                t = t3;
            } else {
                t = t2;
            }
            i4++;
            t2 = t;
        }
        return t2;
    }

    protected ds.b a(ds.b[] bVarArr, int i) {
        return (ds.b) a(bVarArr, i, new a<ds.b>() { // from class: cu.1
            @Override // cu.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(ds.b bVar) {
                return bVar.c();
            }

            @Override // cu.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(ds.b bVar) {
                return bVar.d();
            }
        });
    }

    protected Typeface a(Context context, InputStream inputStream) {
        Typeface typefaceCreateFromFile = null;
        File fileA = cv.a(context);
        if (fileA != null) {
            try {
                if (cv.a(fileA, inputStream)) {
                    typefaceCreateFromFile = Typeface.createFromFile(fileA.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                fileA.delete();
            }
        }
        return typefaceCreateFromFile;
    }

    @Override // cq.a
    public Typeface a(Context context, CancellationSignal cancellationSignal, ds.b[] bVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Throwable th;
        Typeface typefaceA = null;
        if (bVarArr.length >= 1) {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).a());
                try {
                    typefaceA = a(context, inputStreamOpenInputStream);
                    cv.a(inputStreamOpenInputStream);
                } catch (IOException e) {
                    cv.a(inputStreamOpenInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    cv.a(inputStreamOpenInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                inputStreamOpenInputStream = null;
            } catch (Throwable th3) {
                inputStreamOpenInputStream = null;
                th = th3;
            }
        }
        return typefaceA;
    }

    private cl.c a(cl.b bVar, int i) {
        return (cl.c) a(bVar.a(), i, new a<cl.c>() { // from class: cu.2
            @Override // cu.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(cl.c cVar) {
                return cVar.b();
            }

            @Override // cu.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(cl.c cVar) {
                return cVar.c();
            }
        });
    }

    @Override // cq.a
    public Typeface a(Context context, cl.b bVar, Resources resources, int i) {
        cl.c cVarA = a(bVar, i);
        if (cVarA == null) {
            return null;
        }
        return cq.a(context, resources, cVarA.d(), cVarA.a(), i);
    }

    @Override // cq.a
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceCreateFromFile = null;
        File fileA = cv.a(context);
        if (fileA != null) {
            try {
                if (cv.a(fileA, resources, i)) {
                    typefaceCreateFromFile = Typeface.createFromFile(fileA.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                fileA.delete();
            }
        }
        return typefaceCreateFromFile;
    }
}
