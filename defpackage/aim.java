package defpackage;

import android.content.Context;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aim implements atc {
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = true;
    public static float g = 0.0f;
    private static aim l;
    private List<ave> h = new ArrayList();
    private ave i;
    private asx j;
    private atc k;

    protected aim() {
    }

    public static synchronized aim a() {
        if (l == null) {
            l = new aim();
            l.a(HarmanApplication.a());
        }
        return l;
    }

    private void a(Context context) {
        this.j = new asx();
        this.j.b = ahv.a(context);
        this.j.a = ahv.b(context);
        b(context);
    }

    private void b(Context context) {
        List<ave> listA;
        try {
            b = aho.b("IS_FIRST_INSTALL", true);
            c = aho.b("IS_FIRST_OPEN_PLAYER", true);
            d = aho.b("IS_FIRST_OPEN_LINK_ROOM", true);
            e = aho.b("IS_FIRST_SETUP_MULTICHANNEL_STEREO_PRODUCT", true);
            f = aho.b("IS_FIRST_SETUP_MULTICHANNEL_SOUNDBAR_51_PRODUCT", true);
            g = aho.b("EULA_VERSION_AGREEMENT");
            String strD = aho.d("configData");
            if (bru.a((CharSequence) strD)) {
                listA = null;
            } else {
                try {
                    listA = a(context, strD);
                } catch (RuntimeException e2) {
                    mm.b("Saved config data not valid " + bru.b(strD, 2000), e2);
                    listA = null;
                }
            }
            List<ave> listA2 = a(context, new JSONObject(ahc.a(context, "config.data")).getString("musicService"));
            if (listA != null) {
                listA2 = a(listA, listA2);
            }
            this.h = listA2;
            d();
            for (ave aveVar : this.h) {
                if (aveVar.d() == 100) {
                    this.i = aveVar;
                }
            }
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    private List<ave> a(List<ave> list, List<ave> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<ave> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().d()));
        }
        Iterator<ave> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(it2.next().d()));
        }
        Iterator<ave> it3 = list.iterator();
        while (it3.hasNext()) {
            if (!arrayList2.contains(Integer.valueOf(it3.next().d()))) {
                it3.remove();
            }
        }
        for (ave aveVar : list2) {
            if (!arrayList.contains(Integer.valueOf(aveVar.d()))) {
                list.add(aveVar);
            }
        }
        return list;
    }

    public static boolean b() {
        return aho.b("IS_FIRST_WELCOME", true);
    }

    public static boolean c() {
        return aho.b("IS_FIRST_OPEN_DASHBOARD", true);
    }

    public void a(atc atcVar) {
        this.k = atcVar;
        atb.a(this);
    }

    public void d() {
        aho.a("IS_FIRST_INSTALL", false);
        aho.a("configData", new abw().a(this.h));
    }

    public static void e() {
        aho.a("IS_FIRST_WELCOME", false);
    }

    public static void f() {
        aho.a("IS_FIRST_OPEN_DASHBOARD", false);
    }

    public static void g() {
        c = false;
        aho.a("IS_FIRST_OPEN_PLAYER", false);
    }

    public static void h() {
        d = false;
        aho.a("IS_FIRST_OPEN_LINK_ROOM", false);
    }

    public static void i() {
    }

    private List<ave> a(Context context, String str) {
        List<ave> list = (List) new abw().a(str, new adp<ArrayList<ave>>() { // from class: aim.1
        }.b());
        for (ave aveVar : list) {
            brw.a(aveVar.e() != 0);
            brw.a(aveVar.g());
        }
        brw.a(list.isEmpty() ? false : true);
        return list;
    }

    private List<asz> b(Context context, String str) {
        List<asz> list = (List) new abw().a(str, new adp<ArrayList<asz>>() { // from class: aim.2
        }.b());
        for (asz aszVar : list) {
            atb.b.put(aszVar.b(), aszVar);
            mm.b("TEST_LOACAL_UPGRADE", aszVar.toString());
        }
        brw.a(!list.isEmpty());
        return list;
    }

    public ave j() {
        return this.i;
    }

    public ArrayList<ave> k() {
        ArrayList<ave> arrayList = new ArrayList<>();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < this.h.size()) {
                ave aveVar = this.h.get(i2);
                if (aveVar.b() && aveVar.h()) {
                    arrayList.add(aveVar);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public ArrayList<ave> l() {
        ArrayList<ave> arrayListK = k();
        Collections.sort(arrayListK, new a());
        return arrayListK;
    }

    public ArrayList<ave> m() {
        ArrayList<ave> arrayList = new ArrayList<>();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < this.h.size()) {
                ave aveVar = this.h.get(i2);
                if (!aveVar.b() && aveVar.h()) {
                    arrayList.add(aveVar);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public ArrayList<ave> n() {
        ArrayList<ave> arrayListM = m();
        Collections.sort(arrayListM, new a());
        return arrayListM;
    }

    @Override // defpackage.atc
    public void o() {
        a = true;
        for (ave aveVar : this.h) {
            if (atb.c.contains(Integer.valueOf(aveVar.d()))) {
                aveVar.b(false);
            }
        }
        d();
        this.k.o();
    }

    @Override // defpackage.atc
    public void p() {
        if (atb.b.size() == 0) {
            try {
                b(HarmanApplication.a(), new JSONObject(ahc.a(HarmanApplication.a(), "config.data")).getString("device"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    class a implements Comparator<ave> {
        private a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ave aveVar, ave aveVar2) {
            return Integer.valueOf(aveVar.f()).compareTo(Integer.valueOf(aveVar2.f()));
        }
    }
}
