package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import defpackage.ajk;
import defpackage.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class aqy {
    private int c;
    private be d;
    private String b = null;
    private List<aqj> e = new ArrayList();
    private final List<aqj> f = new LinkedList();
    private int g = 0;
    private final ajk.a a = new ajk.a() { // from class: aqy.1
        @Override // ajk.a
        public void a(ajk ajkVar, boolean z) {
            aqy.this.e.remove(aqy.this.a(aqy.this.e, ajkVar));
        }

        @Override // ajk.a
        public void a(ajk ajkVar) {
            aqy.this.e.remove(aqy.this.a(aqy.this.e, ajkVar));
            aqy.this.f.remove(aqy.this.a(aqy.this.f, ajkVar));
            ajkVar.b(this);
        }
    };

    public aqy(be beVar, int i) {
        this.c = i;
        this.d = beVar;
    }

    public aqj a(List<aqj> list, ajk ajkVar) {
        for (aqj aqjVar : list) {
            if (aqjVar.a() == ajkVar) {
                return aqjVar;
            }
        }
        return null;
    }

    public String a(ajk ajkVar, int i, arc arcVar) {
        be beVarA = arcVar != null ? arcVar.a(this.d) : this.d;
        int iB = arcVar != null ? arcVar.b(this.c) : this.c;
        if (arcVar != null && arcVar.a() != null && arcVar.a().intValue() != i) {
            throw new IllegalArgumentException("Ignoring params.getMusicServiceId " + arcVar);
        }
        if (this.b != null) {
            beVarA.b(this.b, 0);
        }
        bj bjVarA = beVarA.a();
        a(bjVarA, arcVar);
        a(bjVarA, iB, ajkVar);
        a(ajkVar, beVarA, "MAIN", bjVarA.a(iB, ajkVar, ajkVar.av()).a("MAIN").e(), iB, Integer.valueOf(i), true);
        return "MAIN";
    }

    public String a(ajk ajkVar, arc arcVar) {
        be beVarA = arcVar != null ? arcVar.a(this.d) : this.d;
        int iB = arcVar != null ? arcVar.b(this.c) : this.c;
        bj bjVarA = beVarA.a();
        a(bjVarA, arcVar);
        a(bjVarA, iB, ajkVar);
        String str = "CHILD_" + ajkVar.av();
        a(ajkVar, beVarA, str, bjVarA.a(iB, ajkVar, ajkVar.av()).a(str).e(), iB, null, true);
        return str;
    }

    public void b(ajk ajkVar, arc arcVar) {
        this.d.b("CHILD_" + ajkVar.av(), 1);
        a(ajkVar, arcVar);
    }

    public String a(be beVar, ajk ajkVar, Bundle bundle, int i) {
        return a(ajkVar, true, new arc().b(beVar).a(bundle).c(i), false);
    }

    public String a(be beVar, ajk ajkVar, Bundle bundle, int i, boolean z) {
        return a(ajkVar, true, new arc().b(beVar).a(bundle).c(i), z);
    }

    public String a(ajk ajkVar, Bundle bundle, int i) {
        return a(ajkVar, false, new arc().a(bundle).a(i), false);
    }

    public String b(ajk ajkVar, Bundle bundle, int i) {
        return a(ajkVar, false, new arc().a(bundle).a(i), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(defpackage.ajk r12, boolean r13, defpackage.arc r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aqy.a(ajk, boolean, arc, boolean):java.lang.String");
    }

    public String c(ajk ajkVar, arc arcVar) {
        String strB;
        be beVarA = arcVar != null ? arcVar.a(this.d) : this.d;
        int iB = arcVar != null ? arcVar.b(this.c) : this.c;
        Integer numA = arcVar != null ? arcVar.a() : null;
        mm.b("Replacing top fragment with ", ajkVar);
        bj bjVarA = beVarA.a();
        a(bjVarA, arcVar);
        aqj aqjVarG = g();
        a(bjVarA, iB, ajkVar);
        bjVarA.a(iB, ajkVar, ajkVar.av());
        if (aqjVarG == null) {
            strB = ajkVar.av();
        } else {
            strB = aqjVarG.b();
        }
        bjVarA.a(strB);
        a(ajkVar, beVarA, strB, bjVarA.e(), iB, numA, false);
        if (aqjVarG != null) {
            return aqjVarG.b();
        }
        return null;
    }

    private void a(bj bjVar, arc arcVar) {
        if (arcVar != null) {
            bjVar.a(arcVar.c(), arcVar.d(), arcVar.e(), arcVar.f());
        }
    }

    private void a(ajk ajkVar, be beVar, String str, int i, int i2, Integer num, boolean z) {
        if (this.b == null) {
            if (str == null) {
                throw new IllegalStateException("First fragment added must have a backstack tag");
            }
            this.b = str;
        }
        if (num == null) {
            aqj aqjVarG = g();
            if (aqjVarG == null) {
                new ml().a("Child fragment added without a main or root fragment, fragments: " + bru.b(String.valueOf(this.f), 1000), new IllegalStateException());
                num = 100;
            } else {
                num = Integer.valueOf(aqjVarG.d());
            }
        }
        aqj aqjVar = new aqj(ajkVar, beVar, str, i, num.intValue(), i2, z);
        this.f.add(aqjVar);
        this.e.add(aqjVar);
        ajkVar.a(this.a);
    }

    private void a(bj bjVar, int i, ajk ajkVar) {
        Iterator<aqj> it = this.f.iterator();
        while (it.hasNext()) {
            aqj next = it.next();
            if (!next.f()) {
                it.remove();
            } else {
                ajk ajkVarA = next.a();
                if (!a(ajkVarA, ajkVar) && ajkVarA != null && next.g() == i && (ajkVarA.z() || !ajkVarA.A())) {
                    if (!ajkVarA.aw()) {
                        bjVar.b(ajkVarA);
                    }
                }
            }
        }
    }

    private String f() {
        aqj aqjVarG = g();
        if (aqjVarG == null) {
            return null;
        }
        return aqjVarG.b();
    }

    private aqj g() {
        a(this.e);
        a(this.f);
        if (!this.e.isEmpty()) {
            return this.e.get(this.e.size() - 1);
        }
        for (int iE = this.d.e() - 1; iE >= 0; iE--) {
            aqj aqjVarA = a(this.d.a(iE));
            if (aqjVarA != null) {
                return aqjVarA;
            }
        }
        return null;
    }

    private void a(List<aqj> list) {
        Iterator<aqj> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a() == null) {
                it.remove();
            }
        }
    }

    public ajk a() {
        aqj aqjVarG = g();
        if (aqjVarG == null) {
            return null;
        }
        return aqjVarG.a();
    }

    private aqj a(be.a aVar) {
        ListIterator<aqj> listIterator = this.f.listIterator(this.f.size());
        while (listIterator.hasPrevious()) {
            aqj aqjVarPrevious = listIterator.previous();
            if (brs.a((Object) Integer.valueOf(aqjVarPrevious.c()), (Object) Integer.valueOf(aVar.a())) && brs.a((Object) aqjVarPrevious.b(), (Object) aVar.i())) {
                return aqjVarPrevious;
            }
        }
        return null;
    }

    public boolean a(Activity activity) {
        this.e = new ArrayList();
        aqj aqjVarG = g();
        if (aqjVarG == null || aqjVarG.b() == null) {
            return false;
        }
        String strB = aqjVarG.b();
        ArrayList<be> arrayList = new ArrayList();
        ListIterator<aqj> listIterator = this.f.listIterator(this.f.size());
        while (listIterator.hasPrevious()) {
            be beVarH = listIterator.previous().h();
            if (beVarH != null && !arrayList.contains(beVarH)) {
                arrayList.add(beVarH);
            }
        }
        for (be beVar : arrayList) {
            int iE = beVar.e();
            if (beVar != null && iE > 0 && strB.equals(beVar.a(iE - 1).i())) {
                if (beVar.equals(this.d) && this.b.equals(strB)) {
                    activity.finish();
                } else {
                    beVar.a(strB, 1);
                }
            }
        }
        return true;
    }

    public void b() {
        a(this.b);
    }

    public void c() {
        a("MAIN");
    }

    private void a(String str) {
        ListIterator<aqj> listIterator = this.f.listIterator(this.f.size());
        while (listIterator.hasPrevious()) {
            aqj aqjVarPrevious = listIterator.previous();
            if (str.equals(aqjVarPrevious.b())) {
                break;
            }
            this.e.remove(aqjVarPrevious);
            listIterator.remove();
        }
        this.d.a(str, 0);
    }

    public boolean d() {
        Iterator<aqj> it = this.e.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        for (aqj aqjVar : this.f) {
            ajk ajkVarA = aqjVar.a();
            if (ajkVarA != null && (ajkVarA.z() || !ajkVarA.A())) {
                if (!ajkVarA.aw() && a(aqjVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(aqj aqjVar) {
        return (aqjVar == null || aqjVar.b() == null || brs.a((Object) aqjVar.b(), (Object) this.b) || (!aqjVar.b().startsWith("CHILD_") && (!aqjVar.b().startsWith("TABS_") || aqjVar.e()))) ? false : true;
    }

    private boolean a(Fragment fragment) {
        return (fragment == null || fragment.w()) ? false : true;
    }

    public Integer e() {
        aqj aqjVarG = g();
        if (aqjVarG == null) {
            return null;
        }
        return Integer.valueOf(aqjVarG.d());
    }

    private String h() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.d.e(); i++) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append("[ " + this.d.a(i).i() + ", " + this.d.a(i).a() + "]");
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder("[");
            for (aqj aqjVar : this.f) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                if (this.e.contains(aqjVar)) {
                    sb.append("*" + aqjVar + "*");
                } else {
                    sb.append(aqjVar);
                }
            }
            sb.append("]");
            return new bsc(this, new ahp()).a("fragments", sb).a("actualBackStack", h()).toString();
        } catch (RuntimeException e) {
            return super.toString();
        }
    }

    private boolean a(ajk ajkVar, ajk ajkVar2) {
        return (ajkVar == null || ajkVar.u() == null || ajkVar.u() == ajkVar2.u() || !(ajkVar2 instanceof awb) || ajkVar.u() == ((awb) ajkVar2).aJ()) ? false : true;
    }
}
