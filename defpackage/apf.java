package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class apf extends aoj {
    private List<ImageView> a = new ArrayList();
    private List<TextView> b = new ArrayList();
    private List<ImageView> c = new ArrayList();
    private View d;
    private TextView e;
    private List<adx> f;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        if (an().n().e() == 2) {
            this.d = layoutInflater.inflate(R.layout.fragment_adapt_51, (ViewGroup) null);
        } else if (an().n().e() == 4) {
            this.d = layoutInflater.inflate(R.layout.fragment_bar_51, (ViewGroup) null);
        } else {
            this.d = layoutInflater.inflate(R.layout.fragment_wps_progess, (ViewGroup) null);
        }
        ax();
        this.e = (TextView) this.d.findViewById(R.id.i_dont_have_more_products);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: apf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                apf.this.l().putByte("previousSelectedChannel", apf.this.an().n().e());
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("is_from_room_management", true);
                apf.this.an().a(aoi.CHOOSE_CHANNEL_TYPE, bundle2);
            }
        });
        return this.d;
    }

    private void at() {
        this.d.findViewById(R.id.progress_indicator_layout).setVisibility(8);
    }

    private void a(List<adx> list) {
        mm.b("=============devices= " + list, new Object[0]);
        if (an().n().e() == 1 || an().n().e() == 4 || an().n().e() == 2) {
            List<adx> listB = aoz.b(list);
            mm.b("=============fitDevices= " + listB, new Object[0]);
            this.f = b(listB);
            if (this.f != null) {
                mm.b("=============supportLists= " + this.f, new Object[0]);
                c(this.f);
            }
        }
    }

    private void ax() {
        if (an().n().e() == 2) {
            this.a.add((ImageView) this.d.findViewById(R.id.step1_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step2_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step3_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step4_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step5_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step6_selecte));
            this.b.add((TextView) this.d.findViewById(R.id.step1_name));
            this.c.add((ImageView) this.d.findViewById(R.id.step1_line));
            this.c.add((ImageView) this.d.findViewById(R.id.step2_line));
            this.c.add((ImageView) this.d.findViewById(R.id.step3_line));
            this.c.add((ImageView) this.d.findViewById(R.id.step4_line));
            this.c.add((ImageView) this.d.findViewById(R.id.step5_line));
            ay();
            return;
        }
        if (an().n().e() == 4) {
            this.a.add((ImageView) this.d.findViewById(R.id.step1_selecte));
            this.a.add((ImageView) this.d.findViewById(R.id.step2_selecte));
            this.b.add((TextView) this.d.findViewById(R.id.step1_name));
            this.b.add((TextView) this.d.findViewById(R.id.step2_name));
            this.b.add((TextView) this.d.findViewById(R.id.step0_name));
            this.c.add((ImageView) this.d.findViewById(R.id.step1_line));
            this.c.add((ImageView) this.d.findViewById(R.id.step2_line));
            if (l().getBoolean("AdaptBarFirstTimeSetup")) {
                ay();
                return;
            }
            return;
        }
        this.a.add((ImageView) this.d.findViewById(R.id.step1_selecte));
        this.a.add((ImageView) this.d.findViewById(R.id.step2_selecte));
        this.b.add((TextView) this.d.findViewById(R.id.step1_name));
        this.b.add((TextView) this.d.findViewById(R.id.step2_name));
        this.c.add((ImageView) this.d.findViewById(R.id.step1_line));
        this.c.add((ImageView) this.d.findViewById(R.id.step2_line));
    }

    private void ay() {
        aro aroVar = new aro((ImageView) this.d.findViewById(R.id.adapt_bar_selecte));
        aroVar.a(arj.b, 33);
        aroVar.a(1);
        aroVar.c();
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        am();
        if (Boolean.valueOf(l().getBoolean("AdaptBarFirstTimeSetup")).booleanValue()) {
            at();
            n(false);
        } else {
            n(true);
            a(aof.a().f());
        }
        an().c(a(R.string.SetupSpeakers_Str));
        a(true);
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
    }

    private void n(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
    }

    public void am() {
        aA();
        if (an().n() != null) {
            if (l().getByte("previousSelectedChannel") > 0) {
                an().n().a(l().getByte("previousSelectedChannel"));
            }
            if (an().n().e() == 2) {
                az();
            }
        }
    }

    private void az() {
        this.b.get(0).setVisibility(0);
    }

    private void aA() {
        if (an().n().e() == 2 || an().n().e() == 5) {
            this.b.get(0).setText(q().getString(R.string.kAdaptReady));
        } else if (an().n().e() == 4 || an().n().e() == 3) {
            this.b.get(2).setText(q().getString(R.string.kOmniBarReady));
        } else {
            this.b.get(0).setText("");
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).setSelected(false);
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).setSelected(false);
        }
    }

    private List<adx> b(List<adx> list) {
        List<adx> arrayList = new ArrayList<>();
        if (an().n().e() == 1) {
            HashMap<Byte, List<adx>> mapE = ((apv) an().n().u()).e(list);
            Iterator<Map.Entry<Byte, List<adx>>> it = mapE.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                byte bByteValue = it.next().getKey().byteValue();
                if (mapE.get(Byte.valueOf(bByteValue)).size() >= 2) {
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                    break;
                }
                arrayList.addAll(mapE.get(Byte.valueOf(bByteValue)));
            }
            if (!aoz.d(list)) {
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
            }
        } else if (an().n().e() == 4) {
            HashMap<Byte, List<adx>> mapE2 = ((apr) an().n().u()).e(list);
            Iterator<Map.Entry<Byte, List<adx>>> it2 = mapE2.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                byte bByteValue2 = it2.next().getKey().byteValue();
                List<adx> list2 = mapE2.get(Byte.valueOf(bByteValue2));
                if (bByteValue2 != 4 && bByteValue2 != 5 && bByteValue2 != 6) {
                    list2 = arrayList;
                } else if (list2.size() >= 2) {
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                    break;
                }
                arrayList = list2;
            }
            if (!aoz.d(list)) {
                l().putBoolean("setup 51bar+", false);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
            }
        } else if (an().n().e() == 2) {
            HashMap<Byte, List<adx>> mapE3 = ((ape) an().n().u()).e(list);
            Iterator<Map.Entry<Byte, List<adx>>> it3 = mapE3.entrySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                byte bByteValue3 = it3.next().getKey().byteValue();
                List<adx> list3 = mapE3.get(Byte.valueOf(bByteValue3));
                if (bByteValue3 != 4 && bByteValue3 != 5 && bByteValue3 != 6) {
                    list3 = arrayList;
                } else if (list3.size() >= 5) {
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                    break;
                }
                arrayList = list3;
            }
            if (!aoz.d(list)) {
                l().putBoolean("setup 51adapt+", false);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
            }
        }
        return arrayList;
    }

    private void c(List<adx> list) {
        if (list.size() > 0) {
            if (an().n().e() == 4) {
                this.b.get(2).setVisibility(8);
                this.d.findViewById(R.id.adapt_bar_selecte).setVisibility(4);
            }
            this.a.get(0).setSelected(true);
            an().b(String.format(q().getString(R.string.kRoomSetupTutorialSetNextProduct_Str), a(list.get(0))));
            if (an().n().e() == 2) {
                this.e.setText("I don’t have more products");
            } else {
                this.e.setText(a(R.string.kRoomSetupTutorialHaveNotMoreProduct_Str, list.get(0).x()));
            }
            a(true);
            if (an().n().e() == 2) {
                String str = String.format(q().getString(R.string.kRoomSetupMasterReady_Str), list.get(0).x() + " #" + list.size());
                if (this.b.get(0).getVisibility() == 0) {
                    this.b.get(0).setText(str);
                }
            } else if (an().n().e() == 1 || an().n().e() == 4) {
                String string = q().getString(R.string.kFirst_Omni_Str);
                String string2 = q().getString(R.string.kSecond_Omni_Str);
                String strA = a(list, string);
                String strA2 = a(list, string2);
                this.b.get(0).setText(strA);
                this.b.get(1).setText(strA2);
            }
        }
        if (an().n().e() == 2) {
            for (int i = 1; i <= list.size() && i < 6; i++) {
                this.a.get(i).setSelected(true);
            }
            return;
        }
        for (int i2 = 1; i2 < list.size() && i2 < 2; i2++) {
            this.a.get(i2).setSelected(true);
        }
    }

    private String a(List<adx> list, String str) {
        String str2;
        if (list.get(0).x().contains("10+")) {
            str2 = "10+";
        } else if (list.get(0).x().contains("20+")) {
            str2 = "20+";
        } else if (list.get(0).x().contains("50+")) {
            str2 = "50+";
        } else if (list.get(0).x().contains("10")) {
            str2 = "10";
        } else if (list.get(0).x().contains("20")) {
            str2 = "20";
        } else if (!list.get(0).x().contains("50")) {
            str2 = "";
        } else {
            str2 = "50";
        }
        return String.format(str, str2);
    }

    public String a(adx adxVar) {
        switch (adxVar.q()) {
            case 1:
                return "Omni 10";
            case 2:
                return "Omni 20";
            case 3:
            default:
                return "Omni speaker";
            case 4:
                return "Omni 10+";
            case 5:
                return "Omni 20+";
            case 6:
                return "Omni 50+";
        }
    }

    @Override // defpackage.aoj
    public void e() {
        if (an().n().e() == 2 || an().n().e() == 4) {
            if (l().getBoolean("AdaptBarFirstTimeSetup", true)) {
                an().i(true);
                l().putBoolean("setup 51adapt+", false);
                l().putBoolean("setup 51bar+", false);
                l().putBoolean("isShowingAdaptBarReady", false);
                l().putBoolean("AdaptBarFirstTimeSetup", false);
                an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
                return;
            }
            if (an().n().u().b(aoz.a(aof.a().f()))) {
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                return;
            }
            l().putBoolean("isShowingAdaptBarReady", false);
            l().putBoolean("AdaptBarFirstTimeSetup", false);
            an().a(aoi.WIFI_SETUP_LIST, l());
            return;
        }
        an().a(aoi.WIFI_SETUP_LIST, l());
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        if (an() != null && an().n() != null && an().s()) {
            an().c(false);
            an().n().b((adx) null);
        }
        l().putByte("previousSelectedChannel", (byte) -1);
    }
}
