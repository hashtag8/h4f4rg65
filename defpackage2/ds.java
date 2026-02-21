package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.widget.TextView;
import defpackage.dt;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ds {
    private static final ea<String, Typeface> a = new ea<>(16);
    private static final dt b = new dt("fonts", 10, 10000);
    private static final Object c = new Object();
    private static final eg<String, ArrayList<dt.a<Typeface>>> d = new eg<>();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() { // from class: ds.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static Typeface b(Context context, dr drVar, int i) {
        try {
            a aVarA = a(context, (CancellationSignal) null, drVar);
            if (aVarA.a() == 0) {
                return cq.a(context, null, aVarA.b(), i);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static Typeface a(final Context context, final dr drVar, final TextView textView, int i, int i2, final int i3) {
        Typeface typeface;
        final String str = drVar.f() + "-" + i3;
        Typeface typefaceA = a.a(str);
        if (typefaceA == null) {
            boolean z = i == 0;
            if (z && i2 == -1) {
                return b(context, drVar, i3);
            }
            Callable<Typeface> callable = new Callable<Typeface>() { // from class: ds.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Typeface call() {
                    Typeface typefaceB = ds.b(context, drVar, i3);
                    if (typefaceB != null) {
                        ds.a.a(str, typefaceB);
                    }
                    return typefaceB;
                }
            };
            if (z) {
                try {
                    return (Typeface) b.a(callable, i2);
                } catch (InterruptedException e2) {
                    return null;
                }
            }
            final WeakReference weakReference = new WeakReference(textView);
            dt.a<Typeface> aVar = new dt.a<Typeface>() { // from class: ds.2
                @Override // dt.a
                public void a(Typeface typeface2) {
                    if (((TextView) weakReference.get()) != null) {
                        textView.setTypeface(typeface2, i3);
                    }
                }
            };
            synchronized (c) {
                if (d.containsKey(str)) {
                    d.get(str).add(aVar);
                    typeface = null;
                } else {
                    ArrayList<dt.a<Typeface>> arrayList = new ArrayList<>();
                    arrayList.add(aVar);
                    d.put(str, arrayList);
                    b.a(callable, new dt.a<Typeface>() { // from class: ds.3
                        @Override // dt.a
                        public void a(Typeface typeface2) {
                            ArrayList arrayList2;
                            synchronized (ds.c) {
                                arrayList2 = (ArrayList) ds.d.get(str);
                                ds.d.remove(str);
                            }
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 < arrayList2.size()) {
                                    ((dt.a) arrayList2.get(i5)).a(typeface2);
                                    i4 = i5 + 1;
                                } else {
                                    return;
                                }
                            }
                        }
                    });
                    typeface = null;
                }
            }
            return typeface;
        }
        return typefaceA;
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) ef.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    public static class a {
        private final int a;
        private final b[] b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri uriA = bVar.a();
                if (!map.containsKey(uriA)) {
                    map.put(uriA, cv.a(context, cancellationSignal, uriA));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, dr drVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoA = a(context.getPackageManager(), drVar, context.getResources());
        if (providerInfoA == null) {
            return new a(1, null);
        }
        return new a(0, a(context, drVar, providerInfoA.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, dr drVar, Resources resources) throws PackageManager.NameNotFoundException {
        int i = 0;
        String strA = drVar.a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strA, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strA);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(drVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strA + ", but package was not " + drVar.b());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, e);
        List<List<byte[]>> listA2 = a(drVar, resources);
        while (true) {
            int i2 = i;
            if (i2 < listA2.size()) {
                ArrayList arrayList = new ArrayList(listA2.get(i2));
                Collections.sort(arrayList, e);
                if (a(listA, arrayList)) {
                    return providerInfoResolveContentProvider;
                }
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    private static List<List<byte[]>> a(dr drVar, Resources resources) {
        if (drVar.d() != null) {
            return drVar.d();
        }
        return cl.a(resources, drVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static ds.b[] a(android.content.Context r18, defpackage.dr r19, java.lang.String r20, android.os.CancellationSignal r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ds.a(android.content.Context, dr, java.lang.String, android.os.CancellationSignal):ds$b[]");
    }
}
