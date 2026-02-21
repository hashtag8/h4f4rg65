package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.CircularProgressButton;
import com.harman.hkconnect.ui.slider.SlidingTabLayout;
import defpackage.aro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aqa extends aoj {
    AnimatorSet a;
    private TextView ae;
    private TextView af;
    private List<LinearLayout> ag;
    private RelativeLayout ah;
    private CircularProgressButton ai;
    private ImageView aj;
    private ImageView ak;
    private ImageView al;
    private ImageView am;
    private View an;
    private View ao;
    private View ap;
    private aey aq;
    private b ar;
    private List<adx> as;
    private Runnable at = new Runnable() { // from class: aqa.8
        @Override // java.lang.Runnable
        public void run() {
            mm.b("Wps Animation Ended adding new Listener", new Object[0]);
            aof.a().c().a(aqa.this.aq);
        }
    };
    ObjectAnimator b;
    ObjectAnimator c;
    private a d;
    private ViewPager e;
    private SlidingTabLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;

    enum b {
        WAITING_FOR_SPEAKERS,
        FOUND_SPEAKERS
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.ap = layoutInflater.inflate(R.layout.fragment_wps_ethernet, (ViewGroup) null);
        this.ar = b.WAITING_FOR_SPEAKERS;
        am();
        return this.ap;
    }

    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.as = new ArrayList();
        List list = (List) l().getSerializable("lastDevice");
        if (list != null && !list.isEmpty()) {
            this.as.addAll(list);
        }
    }

    private void am() {
        ax();
        this.aq = new aez() { // from class: aqa.1
            @Override // defpackage.aez, defpackage.aey
            public void a(final List<adx> list) {
                mo.a.a(new Runnable() { // from class: aqa.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mm.b(list + "------", new Object[0]);
                        ArrayList arrayList = new ArrayList();
                        mm.b(aqa.this.as + "------", new Object[0]);
                        if (aqa.this.as == null) {
                            arrayList.addAll(list);
                        } else {
                            for (adx adxVar : list) {
                                if (aqa.this.as != null && !aqa.this.as.contains(adxVar)) {
                                    arrayList.add(adxVar);
                                }
                            }
                            mm.b(arrayList + "newDevices-----", new Object[0]);
                        }
                        mm.b("------empty" + (!arrayList.isEmpty()) + "---" + arrayList, new Object[0]);
                        if (!arrayList.isEmpty()) {
                            aqa.this.a(arrayList);
                        }
                        aqa.this.as = list;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(list.size());
                        objArr[1] = Integer.valueOf(aqa.this.as != null ? aqa.this.as.size() : 0);
                        mm.b("onDevicesChanged devices=%d, lastDevices=%d", objArr);
                    }
                });
            }
        };
    }

    private byte at() {
        if (an().n().e() == 4 || an().n().e() == 3) {
            return (byte) 8;
        }
        if (an().n().e() != 2 && an().n().e() != 5) {
            return (byte) 0;
        }
        return (byte) 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<adx> list) {
        final List<adx> listA;
        adx adxVar;
        if (this.ar == b.WAITING_FOR_SPEAKERS) {
            if (an().n().e() == 5) {
                listA = aoz.j(list);
            } else if (an().n().e() == 3) {
                listA = aoz.b(list, at());
            } else {
                listA = aoz.a(list);
            }
            if (!listA.isEmpty()) {
                this.ar = b.FOUND_SPEAKERS;
                if (an().n().e() == 1) {
                    if (ar() == aoi.ROOM_MANAGEMENT) {
                        final adx adxVar2 = null;
                        List<adx> listV = an().n().v();
                        if (listV != null && !listV.isEmpty() && (adxVar = listV.get(0)) != null) {
                            for (adx adxVar3 : listA) {
                                if (adxVar3 == null || adxVar3.R().getMkType() != adxVar.R().getMkType()) {
                                    adxVar3 = adxVar2;
                                }
                                adxVar2 = adxVar3;
                            }
                            if (adxVar2 != null) {
                                mm.b("WPS Found Matching Speaker----------", new Object[0]);
                                a(listA, new aro.e() { // from class: aqa.2
                                    @Override // aro.e
                                    public void a() {
                                        aqa.this.an().n().v().add(adxVar2);
                                        aqa.this.an().a(aoi.SETUP_CHANNEL_MASTER, (Bundle) null);
                                    }
                                });
                                return;
                            } else {
                                this.ar = b.WAITING_FOR_SPEAKERS;
                                mm.b("WPS Error Non Matching Speakers----------", new Object[0]);
                                return;
                            }
                        }
                        return;
                    }
                    final List<adx> listH = aoz.h(aof.a().f());
                    if (listH != null && listH.size() > 0) {
                        if (listH.size() == 1) {
                            mm.e("Device list size = 1", new Object[0]);
                            this.ar = b.WAITING_FOR_SPEAKERS;
                            a(listA, new aro.e() { // from class: aqa.3
                                @Override // aro.e
                                public void a() {
                                    Bundle bundleL = aqa.this.l();
                                    bundleL.putSerializable("lastDevice", (Serializable) listH);
                                    aqa.this.an().a(aoi.ONLINE_PROGRESS, bundleL);
                                }
                            });
                            return;
                        } else if (an().n().u().b(listH)) {
                            this.ar = b.FOUND_SPEAKERS;
                            a(listH, new aro.e() { // from class: aqa.4
                                @Override // aro.e
                                public void a() {
                                    aqa.this.b((List<adx>) listH);
                                }
                            });
                            return;
                        } else {
                            this.ar = b.WAITING_FOR_SPEAKERS;
                            return;
                        }
                    }
                    return;
                }
                if (an().n().u().b(listA) || an().n().e() == 5 || an().n().e() == 3) {
                    a(listA, new aro.e() { // from class: aqa.5
                        @Override // aro.e
                        public void a() {
                            aqa.this.b((List<adx>) listA);
                        }
                    });
                } else if (an().n().e() == 4 || an().n().e() == 2) {
                    a(listA, new aro.e() { // from class: aqa.6
                        @Override // aro.e
                        public void a() {
                            Bundle bundleL = aqa.this.l();
                            bundleL.putSerializable("lastDevice", (Serializable) listA);
                            aqa.this.an().a(aoi.ONLINE_PROGRESS, bundleL);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<adx> list) {
        if (an().n().u().b(list) || an().n().e() == 5) {
            if (an().n().e() == 5 || an().n().e() == 3) {
                for (adx adxVar : list) {
                    if (adxVar.I() || adxVar.H()) {
                        an().n().b(adxVar);
                    }
                }
                an().n().w();
                an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                return;
            }
            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
            return;
        }
        an().n().a(list);
        an().n().w();
        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
    }

    private void ax() {
        this.ag = new ArrayList();
        this.g = (LinearLayout) LayoutInflater.from(p()).inflate(R.layout.fragment_wps, (ViewGroup) null);
        this.h = (LinearLayout) LayoutInflater.from(p()).inflate(R.layout.fragment_ethernet, (ViewGroup) null);
        this.ah = (RelativeLayout) this.g.findViewById(R.id.slash_circle_layout);
        this.ai = (CircularProgressButton) this.g.findViewById(R.id.slash_circle);
        this.ai.setVisibility(0);
        this.aj = (ImageView) this.h.findViewById(R.id.wifi_ethernet_guide_flash);
        this.ak = (ImageView) this.g.findViewById(R.id.wps_step1);
        this.al = (ImageView) this.g.findViewById(R.id.wps_step2);
        this.an = this.g.findViewById(R.id.vertical_line1);
        this.ao = this.g.findViewById(R.id.vertical_line2);
        this.i = (TextView) this.g.findViewById(R.id.text_step1);
        this.ae = (TextView) this.g.findViewById(R.id.text_step2);
        this.af = (TextView) this.g.findViewById(R.id.text_step3);
        this.am = (ImageView) this.g.findViewById(R.id.check_icon_anim);
        this.am.setVisibility(8);
        this.ag.add(this.g);
        this.ag.add(this.h);
        this.e = (ViewPager) this.ap.findViewById(R.id.viewpager);
        this.d = new a();
        this.e.setAdapter(this.d);
        this.f = (SlidingTabLayout) this.ap.findViewById(R.id.sliding_tabs);
        this.f.a(R.layout.slide_tab_item, R.id.slide_tab_tv);
        this.f.setViewPager(this.e);
        this.f.setSelectedIndicatorColors(q().getColor(R.color.settings_blue));
        this.f.setDividerColors(0);
    }

    private void ay() {
        this.ai.setVisibility(0);
        if (this.a == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.an, "alpha", 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ao, "alpha", 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.i, "alpha", 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ae, "alpha", 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.af, "alpha", 0.2f, 1.0f);
            objectAnimatorOfFloat5.setStartDelay(600L);
            objectAnimatorOfFloat5.setDuration(300L);
            objectAnimatorOfFloat5.addListener(new Animator.AnimatorListener() { // from class: aqa.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    mm.b("Wps Animation Ended :: isHidden(): " + aqa.this.A(), new Object[0]);
                    if (!aqa.this.A()) {
                        mo.a.postDelayed(aqa.this.at, 300L);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    mm.b("Wps Animation cancelled", new Object[0]);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(300L);
            animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat4);
            this.b = ObjectAnimator.ofFloat(this.ak, "alpha", 1.0f, 0.2f, 1.0f);
            this.b.setDuration(750L);
            this.c = ObjectAnimator.ofFloat(this.al, "alpha", 1.0f, 0.2f, 1.0f);
            this.c.setDuration(750L);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playSequentially(this.b, animatorSet, this.c, animatorSet2);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ai, "alpha", 1.0f, 0.2f, 1.0f);
            objectAnimatorOfFloat6.setDuration(700L);
            objectAnimatorOfFloat6.setRepeatMode(2);
            objectAnimatorOfFloat6.setRepeatCount(-1);
            this.a = new AnimatorSet();
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.playTogether(objectAnimatorOfFloat6, objectAnimatorOfFloat5);
            this.a.playSequentially(animatorSet3, animatorSet4);
        }
        this.a.setStartDelay(600L);
        this.a.start();
    }

    @Override // defpackage.aoj
    public void c() {
        super.c();
        mm.b("Wps Fragment Hidden :: isRunning(): " + this.a.isRunning(), new Object[0]);
        if (this.a.isRunning()) {
            this.a.end();
        }
        mo.a.removeCallbacks(this.at);
        aof.a().c().b(this.aq);
    }

    public void a(List<adx> list, aro.e eVar) {
        this.ai.clearAnimation();
        this.ai.setVisibility(8);
        this.am.setVisibility(0);
        aro aroVar = new aro(this.am);
        aroVar.a(1);
        aroVar.a(arj.c, 33);
        aroVar.a(eVar);
        aroVar.c();
    }

    private void az() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.aj, "alpha", 1.0f, 0.2f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.start();
    }

    class a extends ex {
        private a() {
        }

        @Override // defpackage.ex
        public int b() {
            return ain.g ? 2 : 1;
        }

        @Override // defpackage.ex
        public boolean a(View view, Object obj) {
            return obj == view;
        }

        @Override // defpackage.ex
        public Object a(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) aqa.this.ag.get(i));
            return aqa.this.ag.get(i);
        }

        @Override // defpackage.ex
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // defpackage.ex
        public CharSequence c(int i) {
            return i == 0 ? aqa.this.a(R.string.SpeakerSetupWPSSetup_Str) : aqa.this.a(R.string.kRoomSetupEthernetTitle_Str);
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        aA();
        az();
        ay();
    }

    private void aA() {
        this.an.setAlpha(0.2f);
        this.ao.setAlpha(0.2f);
        this.i.setAlpha(0.2f);
        this.ae.setAlpha(0.2f);
        this.af.setAlpha(0.2f);
        this.af.setAlpha(0.2f);
        this.ak.setAlpha(0.2f);
        this.al.setAlpha(0.2f);
        this.ai.setAlpha(0.2f);
        this.ah.setBackgroundResource(R.drawable.ring_shape_colored);
        this.ai.setVisibility(0);
        this.am.setVisibility(8);
        this.ar = b.WAITING_FOR_SPEAKERS;
    }
}
