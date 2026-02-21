package defpackage;

import defpackage.bfa;
import defpackage.bfi;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bgp implements bgr {
    private static final List<bqv> a = bfw.a(bqv.a("connection"), bqv.a("host"), bqv.a("keep-alive"), bqv.a("proxy-connection"), bqv.a("transfer-encoding"));
    private static final List<bqv> b = bfw.a(bqv.a("connection"), bqv.a("host"), bqv.a("keep-alive"), bqv.a("proxy-connection"), bqv.a("te"), bqv.a("transfer-encoding"), bqv.a("encoding"), bqv.a("upgrade"));
    private final bge c;
    private final bhh d;
    private bhi e;

    public bgp(bge bgeVar, bhh bhhVar) {
        this.c = bgeVar;
        this.d = bhhVar;
    }

    @Override // defpackage.bgr
    public brh a(bfg bfgVar, long j) {
        return this.e.g();
    }

    @Override // defpackage.bgr
    public void a(bfg bfgVar) {
        if (this.e == null) {
            this.c.b();
            this.e = this.d.a(a(bfgVar, this.d.a(), bgk.a(this.c.f().l())), this.c.c(), true);
            this.e.e().a(this.c.a.b(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // defpackage.bgr
    public void a(bgl bglVar) {
        bglVar.a(this.e.g());
    }

    @Override // defpackage.bgr
    public void a() {
        this.e.g().close();
    }

    @Override // defpackage.bgr
    public bfi.a b() {
        return a(this.e.d(), this.d.a());
    }

    public static List<bgw> a(bfg bfgVar, bff bffVar, String str) {
        bfa bfaVarE = bfgVar.e();
        ArrayList arrayList = new ArrayList(bfaVarE.a() + 10);
        arrayList.add(new bgw(bgw.b, bfgVar.d()));
        arrayList.add(new bgw(bgw.c, bgk.a(bfgVar.a())));
        String strA = bge.a(bfgVar.a());
        if (bff.SPDY_3 == bffVar) {
            arrayList.add(new bgw(bgw.g, str));
            arrayList.add(new bgw(bgw.f, strA));
        } else if (bff.HTTP_2 == bffVar) {
            arrayList.add(new bgw(bgw.e, strA));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new bgw(bgw.d, bfgVar.a().getProtocol()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int iA = bfaVarE.a();
        for (int i = 0; i < iA; i++) {
            bqv bqvVarA = bqv.a(bfaVarE.a(i).toLowerCase(Locale.US));
            String strB = bfaVarE.b(i);
            if (!a(bffVar, bqvVarA) && !bqvVarA.equals(bgw.b) && !bqvVarA.equals(bgw.c) && !bqvVarA.equals(bgw.d) && !bqvVarA.equals(bgw.e) && !bqvVarA.equals(bgw.f) && !bqvVarA.equals(bgw.g)) {
                if (!linkedHashSet.add(bqvVarA)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        if (!((bgw) arrayList.get(i2)).h.equals(bqvVarA)) {
                            i2++;
                        } else {
                            arrayList.set(i2, new bgw(bqvVarA, a(((bgw) arrayList.get(i2)).i.a(), strB)));
                            break;
                        }
                    }
                } else {
                    arrayList.add(new bgw(bqvVarA, strB));
                }
            }
        }
        return arrayList;
    }

    private static String a(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static bfi.a a(List<bgw> list, bff bffVar) throws ProtocolException {
        String str = null;
        String str2 = "HTTP/1.1";
        bfa.a aVar = new bfa.a();
        aVar.c(bgh.d, bffVar.toString());
        int size = list.size();
        int i = 0;
        while (i < size) {
            bqv bqvVar = list.get(i).h;
            String strA = list.get(i).i.a();
            String str3 = str2;
            int i2 = 0;
            while (i2 < strA.length()) {
                int iIndexOf = strA.indexOf(0, i2);
                if (iIndexOf == -1) {
                    iIndexOf = strA.length();
                }
                String strSubstring = strA.substring(i2, iIndexOf);
                if (!bqvVar.equals(bgw.a)) {
                    if (bqvVar.equals(bgw.g)) {
                        str3 = strSubstring;
                        strSubstring = str;
                    } else {
                        if (!a(bffVar, bqvVar)) {
                            aVar.a(bqvVar.a(), strSubstring);
                        }
                        strSubstring = str;
                    }
                }
                str = strSubstring;
                i2 = iIndexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        bgq bgqVarA = bgq.a(str2 + " " + str);
        return new bfi.a().a(bffVar).a(bgqVarA.b).a(bgqVarA.c).a(aVar.a());
    }

    @Override // defpackage.bgr
    public bfj a(bfi bfiVar) {
        return new bgi(bfiVar.f(), brc.a(this.e.f()));
    }

    @Override // defpackage.bgr
    public void c() {
    }

    @Override // defpackage.bgr
    public boolean d() {
        return true;
    }

    private static boolean a(bff bffVar, bqv bqvVar) {
        if (bffVar == bff.SPDY_3) {
            return a.contains(bqvVar);
        }
        if (bffVar == bff.HTTP_2) {
            return b.contains(bqvVar);
        }
        throw new AssertionError(bffVar);
    }
}
