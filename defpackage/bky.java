package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bky {
    public static boolean a(String str) {
        try {
            new URL(str);
            return false;
        } catch (MalformedURLException e) {
            return true;
        }
    }

    public static String b(String str) {
        int iLastIndexOf;
        if (str != null && (iLastIndexOf = str.lastIndexOf(46)) != -1 && str.substring(iLastIndexOf, str.length()).indexOf(63) != -1) {
            return str.substring(0, str.indexOf(63));
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x029f A[PHI: r8
  0x029f: PHI (r8v3 java.lang.String) = (r8v2 java.lang.String), (r8v4 java.lang.String) binds: [B:76:0x01de, B:89:0x0234] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<defpackage.bjp> a(defpackage.bjm r17) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bky.a(bjm):java.util.List");
    }

    public static void a(final String str, final bjl bjlVar, final bjb bjbVar, final int i, final int i2) {
        new Thread(new Runnable() { // from class: bky.1
            @Override // java.lang.Runnable
            public void run() {
                bjlVar.b("ObjectID").d(str);
                bjlVar.b("BrowseFlag").d("BrowseDirectChildren");
                bjlVar.b("Filter").d("*");
                bjlVar.b("StartingIndex").d("" + i);
                bjlVar.b("RequestedCount").d("" + i2);
                bjlVar.b("SortCriteria").d("+dc:title");
                final String strD = bjlVar.d();
                if (strD != null && strD.equals("")) {
                    final List<bjp> listA = bky.a(bjlVar.b("Result"));
                    if (listA == null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bjbVar != null) {
                                    bjbVar.a(new ArrayList(), 0, 0);
                                }
                            }
                        });
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                int i3 = Integer.parseInt(bjlVar.b("TotalMatches").c());
                                int i4 = Integer.parseInt(bjlVar.b("NumberReturned").c());
                                if (bjbVar != null) {
                                    bjbVar.a(listA, i4, i3);
                                }
                            }
                        });
                        return;
                    }
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (strD != null) {
                            bjbVar.a(strD);
                        } else {
                            bjbVar.a("Unknown Error");
                        }
                    }
                });
            }
        }).start();
    }

    public static void a(final String str, final bjl bjlVar, final bjb bjbVar, final int i, final int i2, final String str2, final boolean z) {
        new Thread(new Runnable() { // from class: bky.2
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    bjlVar.b("ContainerID").d(str);
                    bjlVar.b("SearchCriteria").d(str2);
                    bjlVar.b("Filter").d("*");
                    bjlVar.b("RequestedCount").d("" + i2);
                    bjlVar.b("StartingIndex").d("" + i);
                    bjlVar.b("SortCriteria").d("+dc:title");
                } else {
                    bjlVar.b("ObjectID").d(str);
                    bjlVar.b("BrowseFlag").d("BrowseDirectChildren");
                    bjlVar.b("Filter").d("*");
                    bjlVar.b("StartingIndex").d("" + i);
                    bjlVar.b("RequestedCount").d("" + i2);
                    bjlVar.b("SortCriteria").d("+dc:title");
                }
                final String strD = bjlVar.d();
                if (strD != null && strD.equals("")) {
                    final List<bjp> listA = bky.a(bjlVar.b("Result"));
                    if (listA == null) {
                        if (bjbVar != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bjbVar.a(new ArrayList(), 0, 0);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int i3 = Integer.parseInt(bjlVar.b("TotalMatches").c());
                            int i4 = Integer.parseInt(bjlVar.b("NumberReturned").c());
                            if (bjbVar != null) {
                                if (i3 == 0 && i4 == i2) {
                                    i3 = i + i2 + 10;
                                }
                                bjbVar.a(listA, i4, i3);
                            }
                        }
                    });
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bky.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (strD != null) {
                            bjbVar.a(strD);
                        } else {
                            bjbVar.a("Unknown Error");
                        }
                    }
                });
            }
        }).start();
    }
}
