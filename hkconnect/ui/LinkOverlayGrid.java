package com.harman.hkconnect.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.adw;
import defpackage.adx;
import defpackage.ady;
import defpackage.adz;
import defpackage.aey;
import defpackage.aez;
import defpackage.agt;
import defpackage.ahj;
import defpackage.ahn;
import defpackage.aho;
import defpackage.ahu;
import defpackage.aof;
import defpackage.aqn;
import defpackage.aqo;
import defpackage.arb;
import defpackage.arw;
import defpackage.asc;
import defpackage.mm;
import defpackage.mo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class LinkOverlayGrid extends RelativeLayout {
    private Dialog A;
    private View.OnClickListener B;
    private View.OnTouchListener C;
    private adz D;
    private View.OnClickListener E;
    aey a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private LayoutInflater f;
    private Context g;
    private LinearLayout h;
    private LinearLayout i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private AlphaAnimation m;
    private AlphaAnimation n;
    private ArrayList<adz> o;
    private boolean p;
    private boolean q;
    private boolean r;
    private List<adz> s;
    private Set<adz> t;
    private ahj u;
    private ImageView v;
    private byte w;
    private Runnable x;
    private boolean y;
    private String z;

    public LinkOverlayGrid(Context context) {
        super(context);
        this.b = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_background_size);
        this.c = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_animation_size);
        this.d = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_background_size);
        this.e = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_animation_size);
        this.o = new ArrayList<>();
        this.q = false;
        this.r = false;
        this.s = Collections.emptyList();
        this.t = Collections.emptySet();
        this.w = (byte) 32;
        this.x = new Runnable() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = LinkOverlayGrid.this.t.iterator();
                while (it.hasNext()) {
                    ((adz) it.next()).a(false);
                }
                if (LinkOverlayGrid.this.l != null) {
                    LinkOverlayGrid.this.l.setText(R.string.WhereToPlayMusic_Str);
                }
                LinkOverlayGrid.this.g();
            }
        };
        this.y = false;
        this.B = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.8
            public ady a;
            int b = 0;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LinkOverlayGrid.this.p) {
                    LinkOverlayGrid.this.l();
                    LinkOverlayGrid.this.p = false;
                    LinkOverlayGrid.this.g();
                    LinkOverlayGrid.this.t = new HashSet(LinkOverlayGrid.this.o);
                    aof.a().j();
                } else if (LinkOverlayGrid.this.j()) {
                    LinkOverlayGrid.this.k();
                    mo.a.removeCallbacks(LinkOverlayGrid.this.x);
                    mo.a.postDelayed(LinkOverlayGrid.this.x, 5000L);
                    LinkOverlayGrid.this.l.setText(R.string.Linking_Str);
                    this.a = aof.a().b();
                    LinkOverlayGrid.this.o = new ArrayList(LinkOverlayGrid.this.t);
                    List<ady> listE = aof.a().e();
                    ArrayList arrayList = new ArrayList();
                    Iterator<ady> it = listE.iterator();
                    while (it.hasNext()) {
                        List<adz> listG = it.next().g();
                        for (adz adzVar : listG) {
                            if (!this.a.x().N() && adzVar.h().N() && (adzVar.f() == 3 || adzVar.f() == 2)) {
                                if (adzVar.h().y()) {
                                    listG.remove(adzVar);
                                }
                            }
                        }
                        Iterator<adz> it2 = listG.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next());
                        }
                    }
                    LinkOverlayGrid.this.t = new HashSet(arrayList);
                    LinkOverlayGrid.this.p = true;
                    LinkOverlayGrid.this.g();
                    Iterator it3 = LinkOverlayGrid.this.s.iterator();
                    while (it3.hasNext()) {
                        if (((adz) it3.next()).B()) {
                            this.b++;
                        }
                    }
                    if ((this.a.m() == 34 && this.b != 0) && !aho.b("NEVER_REMIND_ME_AGAIN", false)) {
                        LinkOverlayGrid.this.a((byte) 34, true);
                        return;
                    } else if (!aho.b("NEVER_REMIND_ME_AGAIN", false) && arb.a((Set<adz>) LinkOverlayGrid.this.t)) {
                        LinkOverlayGrid.this.a((byte) 32, true);
                    }
                }
                aof.a().a(LinkOverlayGrid.this.getSourceGroup(), LinkOverlayGrid.this.t);
            }
        };
        this.C = new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.a = new aez() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.10
            @Override // defpackage.aez, defpackage.aey
            public void a(long j) {
                adz adzVarA;
                adx adxVarA = aof.a().a(j);
                if (adxVarA != null && (adzVarA = aof.a().a(adxVarA.s())) != null) {
                    adzVarA.a(false);
                }
                Iterator it = LinkOverlayGrid.this.t.iterator();
                while (it.hasNext()) {
                    if (((adz) it.next()).a()) {
                        return;
                    }
                }
                mo.a.a(new Runnable() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinkOverlayGrid.this.o();
                    }
                });
            }
        };
        this.D = null;
        this.E = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinkOverlayGrid.this.D = ((aqn) view.getTag()).a;
                mm.b("CLLOG LinkingLocked check " + LinkOverlayGrid.this.D.a(), new Object[0]);
                if (!LinkOverlayGrid.this.n()) {
                    if (LinkOverlayGrid.this.t.contains(LinkOverlayGrid.this.D)) {
                        if (LinkOverlayGrid.this.t.size() != 1 && LinkOverlayGrid.this.D != null) {
                            byte bF = LinkOverlayGrid.this.D.f();
                            if ((bF == 33 || bF == 34 || bF == 2 || bF == 3) && LinkOverlayGrid.this.D.u()) {
                                LinkOverlayGrid.this.a((byte) 33, true);
                                return;
                            } else {
                                LinkOverlayGrid.this.D.b();
                                LinkOverlayGrid.this.t.remove(LinkOverlayGrid.this.D);
                            }
                        } else {
                            return;
                        }
                    } else if (LinkOverlayGrid.this.b(LinkOverlayGrid.this.D)) {
                        if (LinkOverlayGrid.this.t.size() == 1) {
                            Iterator it = LinkOverlayGrid.this.t.iterator();
                            while (it.hasNext()) {
                                if (!LinkOverlayGrid.this.b((adz) it.next())) {
                                    return;
                                }
                            }
                        }
                        ady adyVarB = aof.a().b();
                        mm.b("CLLOG CURRENTGROUP " + adyVarB, new Object[0]);
                        if (adyVarB != null) {
                            mm.b("CLLOG CURRENTGROUP IS STREAMING " + adyVarB.k() + " IS ACTIVE " + adyVarB.l(), new Object[0]);
                        }
                        LinkOverlayGrid.this.D.a(true);
                        mo.a.removeCallbacks(LinkOverlayGrid.this.x);
                        mo.a.postDelayed(LinkOverlayGrid.this.x, 5000L);
                        LinkOverlayGrid.this.l.setText(R.string.Linking_Str);
                        LinkOverlayGrid.this.t.add(LinkOverlayGrid.this.D);
                        boolean zB = aho.b("NEVER_REMIND_ME_AGAIN", false);
                        if (arb.a((Set<adz>) LinkOverlayGrid.this.t)) {
                            if (zB) {
                                LinkOverlayGrid.this.a(true);
                            } else {
                                LinkOverlayGrid.this.a((byte) 32, true);
                            }
                        }
                    } else {
                        return;
                    }
                    LinkOverlayGrid.this.a(LinkOverlayGrid.this.D);
                    LinkOverlayGrid.this.g();
                    aof.a().a(aof.a().b(), LinkOverlayGrid.this.t);
                }
            }
        };
        this.g = context;
        i();
    }

    public LinkOverlayGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_background_size);
        this.c = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_animation_size);
        this.d = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_background_size);
        this.e = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_animation_size);
        this.o = new ArrayList<>();
        this.q = false;
        this.r = false;
        this.s = Collections.emptyList();
        this.t = Collections.emptySet();
        this.w = (byte) 32;
        this.x = new Runnable() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = LinkOverlayGrid.this.t.iterator();
                while (it.hasNext()) {
                    ((adz) it.next()).a(false);
                }
                if (LinkOverlayGrid.this.l != null) {
                    LinkOverlayGrid.this.l.setText(R.string.WhereToPlayMusic_Str);
                }
                LinkOverlayGrid.this.g();
            }
        };
        this.y = false;
        this.B = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.8
            public ady a;
            int b = 0;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LinkOverlayGrid.this.p) {
                    LinkOverlayGrid.this.l();
                    LinkOverlayGrid.this.p = false;
                    LinkOverlayGrid.this.g();
                    LinkOverlayGrid.this.t = new HashSet(LinkOverlayGrid.this.o);
                    aof.a().j();
                } else if (LinkOverlayGrid.this.j()) {
                    LinkOverlayGrid.this.k();
                    mo.a.removeCallbacks(LinkOverlayGrid.this.x);
                    mo.a.postDelayed(LinkOverlayGrid.this.x, 5000L);
                    LinkOverlayGrid.this.l.setText(R.string.Linking_Str);
                    this.a = aof.a().b();
                    LinkOverlayGrid.this.o = new ArrayList(LinkOverlayGrid.this.t);
                    List<ady> listE = aof.a().e();
                    ArrayList arrayList = new ArrayList();
                    Iterator<ady> it = listE.iterator();
                    while (it.hasNext()) {
                        List<adz> listG = it.next().g();
                        for (adz adzVar : listG) {
                            if (!this.a.x().N() && adzVar.h().N() && (adzVar.f() == 3 || adzVar.f() == 2)) {
                                if (adzVar.h().y()) {
                                    listG.remove(adzVar);
                                }
                            }
                        }
                        Iterator<adz> it2 = listG.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next());
                        }
                    }
                    LinkOverlayGrid.this.t = new HashSet(arrayList);
                    LinkOverlayGrid.this.p = true;
                    LinkOverlayGrid.this.g();
                    Iterator it3 = LinkOverlayGrid.this.s.iterator();
                    while (it3.hasNext()) {
                        if (((adz) it3.next()).B()) {
                            this.b++;
                        }
                    }
                    if ((this.a.m() == 34 && this.b != 0) && !aho.b("NEVER_REMIND_ME_AGAIN", false)) {
                        LinkOverlayGrid.this.a((byte) 34, true);
                        return;
                    } else if (!aho.b("NEVER_REMIND_ME_AGAIN", false) && arb.a((Set<adz>) LinkOverlayGrid.this.t)) {
                        LinkOverlayGrid.this.a((byte) 32, true);
                    }
                }
                aof.a().a(LinkOverlayGrid.this.getSourceGroup(), LinkOverlayGrid.this.t);
            }
        };
        this.C = new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.a = new aez() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.10
            @Override // defpackage.aez, defpackage.aey
            public void a(long j) {
                adz adzVarA;
                adx adxVarA = aof.a().a(j);
                if (adxVarA != null && (adzVarA = aof.a().a(adxVarA.s())) != null) {
                    adzVarA.a(false);
                }
                Iterator it = LinkOverlayGrid.this.t.iterator();
                while (it.hasNext()) {
                    if (((adz) it.next()).a()) {
                        return;
                    }
                }
                mo.a.a(new Runnable() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinkOverlayGrid.this.o();
                    }
                });
            }
        };
        this.D = null;
        this.E = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinkOverlayGrid.this.D = ((aqn) view.getTag()).a;
                mm.b("CLLOG LinkingLocked check " + LinkOverlayGrid.this.D.a(), new Object[0]);
                if (!LinkOverlayGrid.this.n()) {
                    if (LinkOverlayGrid.this.t.contains(LinkOverlayGrid.this.D)) {
                        if (LinkOverlayGrid.this.t.size() != 1 && LinkOverlayGrid.this.D != null) {
                            byte bF = LinkOverlayGrid.this.D.f();
                            if ((bF == 33 || bF == 34 || bF == 2 || bF == 3) && LinkOverlayGrid.this.D.u()) {
                                LinkOverlayGrid.this.a((byte) 33, true);
                                return;
                            } else {
                                LinkOverlayGrid.this.D.b();
                                LinkOverlayGrid.this.t.remove(LinkOverlayGrid.this.D);
                            }
                        } else {
                            return;
                        }
                    } else if (LinkOverlayGrid.this.b(LinkOverlayGrid.this.D)) {
                        if (LinkOverlayGrid.this.t.size() == 1) {
                            Iterator it = LinkOverlayGrid.this.t.iterator();
                            while (it.hasNext()) {
                                if (!LinkOverlayGrid.this.b((adz) it.next())) {
                                    return;
                                }
                            }
                        }
                        ady adyVarB = aof.a().b();
                        mm.b("CLLOG CURRENTGROUP " + adyVarB, new Object[0]);
                        if (adyVarB != null) {
                            mm.b("CLLOG CURRENTGROUP IS STREAMING " + adyVarB.k() + " IS ACTIVE " + adyVarB.l(), new Object[0]);
                        }
                        LinkOverlayGrid.this.D.a(true);
                        mo.a.removeCallbacks(LinkOverlayGrid.this.x);
                        mo.a.postDelayed(LinkOverlayGrid.this.x, 5000L);
                        LinkOverlayGrid.this.l.setText(R.string.Linking_Str);
                        LinkOverlayGrid.this.t.add(LinkOverlayGrid.this.D);
                        boolean zB = aho.b("NEVER_REMIND_ME_AGAIN", false);
                        if (arb.a((Set<adz>) LinkOverlayGrid.this.t)) {
                            if (zB) {
                                LinkOverlayGrid.this.a(true);
                            } else {
                                LinkOverlayGrid.this.a((byte) 32, true);
                            }
                        }
                    } else {
                        return;
                    }
                    LinkOverlayGrid.this.a(LinkOverlayGrid.this.D);
                    LinkOverlayGrid.this.g();
                    aof.a().a(aof.a().b(), LinkOverlayGrid.this.t);
                }
            }
        };
        this.g = context;
        i();
    }

    public void a() {
        List<adz> listD = aof.a().d();
        HashSet hashSet = new HashSet();
        ady adyVarB = aof.a().b();
        if (adyVarB != null && adyVarB.f() != null) {
            Iterator<adz> it = adyVarB.f().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        o();
        a(listD, hashSet);
        this.s = Collections.unmodifiableList(new ArrayList(listD));
        this.t = new HashSet(hashSet);
        g();
        c();
        h();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        for (int i = 0; i < f(); i++) {
            if (this.h.getChildCount() <= i) {
                this.h.addView(a(i, (View) null));
            } else {
                a(i, this.h.getChildAt(i));
            }
        }
        while (f() < this.h.getChildCount()) {
            this.h.removeViewAt(this.h.getChildCount() - 1);
        }
    }

    private void h() {
        if (this.s.size() <= this.t.size()) {
            Iterator<adz> it = this.o.iterator();
            while (it.hasNext()) {
                if (!this.t.contains(it.next())) {
                    it.remove();
                }
            }
        }
    }

    private void i() {
        this.f = LayoutInflater.from(this.g);
        View viewInflate = this.f.inflate(R.layout.link_overlay_grid, this);
        this.i = (LinearLayout) viewInflate.findViewById(R.id.overlay_grid_layout_touch_area);
        this.l = (TextView) viewInflate.findViewById(R.id.linkgrid_textview);
        this.i.setOnTouchListener(this.C);
        this.u = new ahj();
        this.h = (LinearLayout) viewInflate.findViewById(R.id.rooms_holder);
        this.j = (RelativeLayout) viewInflate.findViewById(R.id.partymode_layout);
        this.k = (TextView) viewInflate.findViewById(R.id.partymode_activated_bg);
        this.v = (ImageView) viewInflate.findViewById(R.id.speaker_number_limitation);
        TextView textView = (TextView) viewInflate.findViewById(R.id.linkgrid_donebutton);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinkOverlayGrid.this.a((byte) 32, true);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqo.f().b(LinkOverlayGrid.this.t.size());
                LinkOverlayGrid.this.e();
            }
        });
        this.j.setOnClickListener(this.B);
        this.m = new AlphaAnimation(1.0f, 0.0f);
        this.m.setDuration(350L);
        this.m.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LinkOverlayGrid.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.n = new AlphaAnimation(0.0f, 1.0f);
        this.n.setDuration(350L);
        this.n.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        c();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final byte b, boolean z) {
        TextView textView;
        int i;
        TextView textView2;
        int i2;
        int i3;
        TextView textView3;
        if (this.A == null || !this.A.isShowing()) {
            View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.speaker_limitation_dialog, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.unlink_separator);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.id_dialog_message);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.unlink);
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.ok);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.never_remind_me_again);
            textView7.setText(R.string.kSignNoticeViewNeverRemindButtonTitle_Str);
            textView5.setText(R.string.UnLink_Str);
            switch (b) {
                case 33:
                    viewInflate = LayoutInflater.from(this.g).inflate(R.layout.speaker_spotify_dialog, (ViewGroup) null);
                    TextView textView8 = (TextView) viewInflate.findViewById(R.id.id_dialog_message);
                    TextView textView9 = (TextView) viewInflate.findViewById(R.id.unlink);
                    TextView textView10 = (TextView) viewInflate.findViewById(R.id.ok);
                    this.y = true;
                    textView9.setText(R.string.kSignNoticeViewUnlinkLocalSource_Unlink_Str);
                    this.z = getResources().getString(R.string.kSignNoticeViewUnlinkLocalSource_Message_Str);
                    this.z = String.format(this.z, this.D.l());
                    textView = textView10;
                    i = R.string.kSignNoticeViewUnlinkLocalSource_Stay_Str;
                    textView2 = textView8;
                    i2 = R.string.kSignNoticeViewMessage_Str;
                    i3 = R.string.kSignNoticeViewTitle_Str;
                    textView3 = textView9;
                    break;
                case 34:
                    textView5.setVisibility(8);
                    this.y = true;
                    textView = textView6;
                    i = R.string.OK_Str;
                    textView2 = textView4;
                    i2 = R.string.kLinkGoogleCastWithGen1SignNoticeViewMessage_Str;
                    i3 = R.string.kLinkGoogleCastWithGen1SignNoticeViewTitle_Str;
                    textView3 = textView5;
                    break;
                default:
                    if (z) {
                        textView5.setVisibility(8);
                        viewFindViewById.setVisibility(8);
                    }
                    this.y = true;
                    textView = textView6;
                    i = R.string.OK_Str;
                    textView2 = textView4;
                    i2 = R.string.kSignNoticeViewMessage_Str;
                    i3 = R.string.kSignNoticeViewTitle_Str;
                    textView3 = textView5;
                    break;
            }
            textView.setText(i);
            if (b == 32 || this.D != null) {
                if (b != 32 && !this.D.g()) {
                    textView2.setText(this.z);
                    this.A = new arw.a(this.g).a(R.drawable.exclamation_missing_speaker, this.y).c(false).a(viewInflate).e(false).d(false).f(false).b();
                } else {
                    textView2.setText(i2);
                    this.A = new arw.a(this.g).a(R.drawable.exclamation_missing_speaker, this.y).b(this.g.getString(i3)).a(viewInflate).e(false).d(false).f(false).b();
                }
                this.y = false;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.LinkOverlayGrid.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.ok /* 2131689702 */:
                                LinkOverlayGrid.this.A.dismiss();
                                break;
                            case R.id.unlink /* 2131691022 */:
                                LinkOverlayGrid.this.a(false, LinkOverlayGrid.this.getSourceGroup().m());
                                LinkOverlayGrid.this.A.dismiss();
                                break;
                            case R.id.never_remind_me_again /* 2131691025 */:
                                LinkOverlayGrid.this.A.dismiss();
                                aho.a(b == 34 ? "NEVER_REMIND_ME_AGAIN_GOOGLECAST" : "NEVER_REMIND_ME_AGAIN", true);
                                LinkOverlayGrid.this.b();
                                break;
                        }
                    }
                };
                textView.setOnClickListener(onClickListener);
                textView3.setOnClickListener(onClickListener);
                textView7.setOnClickListener(onClickListener);
                new asc(this.A).a(null);
            }
        }
    }

    public void b() {
        ady adyVarB = aof.a().b();
        if (!(adyVarB != null && (adyVarB.k() || MusicPlaylistManager.a().v()))) {
            a(false);
            return;
        }
        if (!aho.b("NEVER_REMIND_ME_AGAIN", false) && arb.a(this.t)) {
            a(true);
            if (!aho.b("IS_MATCHED_CONDITION_MAX_LIMITATION", false)) {
                aho.a("IS_MATCHED_CONDITION_MAX_LIMITATION", true);
                a((byte) 32, false);
                return;
            }
            return;
        }
        if (!aho.b("NEVER_REMIND_ME_AGAIN_GOOGLECAST", false) && adyVarB != null && adyVarB.m() == 34) {
            Iterator<adz> it = aof.a().d().iterator();
            while (it.hasNext()) {
                Iterator<adx> it2 = it.next().k().iterator();
                while (it2.hasNext()) {
                    if (it2.next().E()) {
                        a(true);
                        return;
                    }
                }
            }
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(adz adzVar) {
        if (this.t.size() == this.s.size()) {
            this.p = true;
            k();
            this.o.clear();
            for (adz adzVar2 : this.s) {
                if (adzVar.c() != adzVar2.c()) {
                    this.o.add(adzVar2);
                }
            }
            return;
        }
        if (this.p) {
            this.p = false;
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return this.w != 34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(adz adzVar) {
        ady adyVarB = aof.a().b();
        if (adyVarB == null) {
            return false;
        }
        adx adxVarX = adyVarB.x();
        if (adxVarX != null) {
            this.w = adxVarX.S();
        }
        if (adxVarX != null && adxVarX.R() != null && adxVarX.R().getMkRoomId() == adzVar.s()) {
            if (!c(adzVar)) {
                return true;
            }
            adw.a().g(adzVar.e());
            if (adzVar.f() == 4) {
                return adzVar.i().Z();
            }
            if (adzVar.f() == 3) {
                return adzVar.i().Y();
            }
            if (adzVar.f() == 16) {
                return false;
            }
        } else {
            if (adzVar.f() != 32 && adzVar.u()) {
                return false;
            }
            if ((this.w == 34 || this.w == 33) && adzVar.B()) {
                return false;
            }
            if (adxVarX != null && adxVarX.N() && (adzVar.f() == 34 || adzVar.f() == 33)) {
                return false;
            }
            if (c(adzVar)) {
                adw.a().g(adzVar.e());
                if (adzVar.f() == 4) {
                    return adzVar.i().Z();
                }
                if (adzVar.f() == 3) {
                    return adzVar.i().Y();
                }
                if (adzVar.f() == 16) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean c(adz adzVar) {
        for (adx adxVar : adzVar.k()) {
            if (adxVar.I() || adxVar.H()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ady getSourceGroup() {
        return aof.a().b();
    }

    private adz a(List<adz> list) {
        for (adz adzVar : list) {
            if (adzVar.f() != 32) {
                return adzVar;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.k.setBackgroundResource(R.drawable.product_setup_button_solid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.k.setBackgroundResource(R.drawable.product_setup_button_stroke);
    }

    public void a(boolean z, byte b) {
        this.q = true;
        this.r = true;
        this.w = b;
        List<adz> listD = aof.a().d();
        HashSet hashSet = new HashSet();
        ady adyVarB = aof.a().b();
        if (adyVarB != null && adyVarB.f() != null) {
            Iterator<adz> it = adyVarB.f().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        a(listD, hashSet);
        this.s = Collections.unmodifiableList(new ArrayList(listD));
        this.t = new HashSet(hashSet);
        g();
        setVisibility(0);
        startAnimation(this.n);
        c();
        b();
        aof.a().c().a(this.a);
    }

    private synchronized void a(List<adz> list, Set<adz> set) {
        this.o.clear();
        if (list.size() == 0) {
            mm.a((Object) "fixlink");
        } else if (list.size() == set.size() && !list.isEmpty()) {
            mm.a((Object) ("fixlink " + list.size()));
            this.o.add(a(list));
        } else {
            this.o.addAll(set);
        }
    }

    public void c() {
        d();
        if (this.s.size() <= 1 || m()) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        if (this.t.size() == this.s.size()) {
            this.p = true;
            k();
        } else {
            this.p = false;
            l();
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
    }

    private boolean m() {
        List<ady> listE = aof.a().e();
        if (listE != null && !listE.isEmpty()) {
            for (ady adyVar : listE) {
                if (adyVar != null && adyVar.m() == 34) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        ((RelativeLayout.LayoutParams) this.k.getLayoutParams()).setMargins(ahn.a(this.g, 20.0f), 0, 0, 0);
    }

    public void e() {
        aof.a().c().b(this.a);
        Iterator<adz> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().a(false);
            o();
        }
        if (this.r) {
            startAnimation(this.m);
            this.q = false;
            this.r = false;
        }
    }

    private void a(RelativeLayout relativeLayout, int i, int i2, RelativeLayout relativeLayout2) {
        aqn aqnVar = (aqn) relativeLayout2.getTag();
        if (aqnVar.b != i || aqnVar.c != i2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            Resources resources = getResources();
            if (i2 == 1) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (i2 == 2) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_two_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_two_speakers), 0);
            } else if (i2 == 3) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_three_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_three_speakers), 0);
            } else if (i2 == 4) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_four_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_four_speakers), 0);
            } else if (i2 == 5) {
                if (i == 1) {
                    layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_first_row), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_first_row), 0);
                } else {
                    layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_second_row), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_second_row), 0);
                }
            } else {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_full_grid), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_full_grid), 0);
            }
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                a(relativeLayout);
            } else {
                b(relativeLayout);
            }
        }
    }

    private void a(RelativeLayout relativeLayout) {
        aqn aqnVar = (aqn) relativeLayout.getTag();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aqnVar.d.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aqnVar.e.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aqnVar.f.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aqnVar.g.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) aqnVar.h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) aqnVar.i.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) aqnVar.l.getLayoutParams();
        int i = this.b;
        layoutParams.height = i;
        layoutParams.width = i;
        int i2 = this.c;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        int i3 = this.c;
        layoutParams3.height = i3;
        layoutParams3.width = i3;
        int i4 = this.c;
        layoutParams4.height = i4;
        layoutParams4.width = i4;
        int i5 = this.b;
        layoutParams5.height = i5;
        layoutParams5.width = i5;
        int i6 = this.c;
        layoutParams6.height = i6;
        layoutParams6.width = i6;
        int i7 = this.b;
        layoutParams7.height = i7;
        layoutParams7.width = i7;
    }

    private void b(RelativeLayout relativeLayout) {
        aqn aqnVar = (aqn) relativeLayout.getTag();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aqnVar.d.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aqnVar.e.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aqnVar.f.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aqnVar.g.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) aqnVar.h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) aqnVar.i.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) aqnVar.l.getLayoutParams();
        int i = this.d;
        layoutParams.height = i;
        layoutParams.width = i;
        int i2 = this.e;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        int i3 = this.e;
        layoutParams3.height = i3;
        layoutParams3.width = i3;
        int i4 = this.e;
        layoutParams4.height = i4;
        layoutParams4.width = i4;
        int i5 = this.d;
        layoutParams5.height = i5;
        layoutParams5.width = i5;
        int i6 = this.e;
        layoutParams6.height = i6;
        layoutParams6.width = i6;
        int i7 = this.d;
        layoutParams7.height = i7;
        layoutParams7.width = i7;
    }

    private void a(RelativeLayout relativeLayout, int i) {
        adz adzVar;
        if (this.s != null && !this.s.isEmpty() && i < this.s.size() && (adzVar = this.s.get(i)) != null) {
            aqn aqnVar = (aqn) relativeLayout.getTag();
            aqnVar.e.clearAnimation();
            aqnVar.k.setText(adzVar.l());
            aqnVar.m.setImageResource(adzVar.m());
            int iQ = adzVar.q();
            int iRgb = Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ));
            aqnVar.m.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
            aqnVar.l.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
            aqnVar.k.setTextColor(iRgb);
            if (this.t.contains(adzVar) && adzVar.f() != 32 && adzVar.u()) {
                aqnVar.n.setVisibility(0);
            } else {
                aqnVar.n.setVisibility(4);
            }
        }
    }

    public int f() {
        int size = this.s.size();
        if (size == 0) {
            return 0;
        }
        return ((size - 1) / 3) + 1;
    }

    private int a(int i, int i2, int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2 || i3 == 3) {
            return i2 - 1;
        }
        if (i3 == 4) {
            return ((i - 1) * 2) + (i2 - 1);
        }
        if (i3 == 5) {
            if (i == 1) {
                return i2 - 1;
            }
            return i2 + 2;
        }
        return ((i - 1) * 3) + (i2 - 1);
    }

    private int a(int i, int i2) {
        if (1 <= i2 && i2 <= 3) {
            return i2;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 5) {
            return i != 1 ? 2 : 3;
        }
        if (i2 == 6 || i <= (i2 - 1) / 3 || i2 % 3 == 0) {
            return 3;
        }
        return i2 % 3;
    }

    public View a(int i, View view) {
        LinearLayout linearLayout;
        boolean z;
        if (view == null) {
            linearLayout = new LinearLayout(this.g);
            linearLayout.setGravity(17);
        } else {
            linearLayout = (LinearLayout) view;
        }
        int childCount = linearLayout.getChildCount();
        int size = this.s.size();
        int i2 = i + 1;
        int iA = a(i2, size);
        if (childCount < iA) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= iA - childCount) {
                    break;
                }
                View viewInflate = this.f.inflate(R.layout.overlay_grid_item, (ViewGroup) null);
                aqn aqnVar = new aqn();
                aqnVar.b = -1;
                aqnVar.c = -1;
                aqnVar.a = null;
                aqnVar.d = viewInflate.findViewById(R.id.animation_layout_container);
                aqnVar.e = viewInflate.findViewById(R.id.animation_background);
                aqnVar.f = viewInflate.findViewById(R.id.animation_smallCircle);
                aqnVar.g = viewInflate.findViewById(R.id.animation_bigCircle);
                aqnVar.h = viewInflate.findViewById(R.id.ripple_effect_layout);
                aqnVar.i = viewInflate.findViewById(R.id.ripple_effect_view);
                aqnVar.j = viewInflate.findViewById(R.id.overlay_grid_item_border);
                aqnVar.k = (TypefaceTextView) viewInflate.findViewById(R.id.overlay_icon_text);
                aqnVar.m = (ImageView) viewInflate.findViewById(R.id.overlay_icon_id);
                aqnVar.l = (ImageView) viewInflate.findViewById(R.id.overlay_grid_item_border);
                aqnVar.n = (ImageView) viewInflate.findViewById(R.id.source);
                viewInflate.setOnClickListener(this.E);
                viewInflate.setTag(aqnVar);
                linearLayout.addView(viewInflate);
                i3 = i4 + 1;
            }
        } else if (childCount > iA) {
            for (int i5 = 0; i5 < childCount - iA; i5++) {
                linearLayout.removeViewAt(0);
            }
        }
        ady adyVarB = aof.a().b();
        adyVarB.x();
        boolean zB = aho.b("IS_MATCHED_CONDITION_GOOGLECAST", false);
        boolean z2 = adyVarB != null && adyVarB.m() == 34;
        for (int i6 = 0; i6 < iA; i6++) {
            RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(i6);
            int iA2 = a(i2, i6 + 1, size);
            mm.b("Returning %s position %s/%s for row %s col %s", this.s.get(iA2), Integer.valueOf(iA2), Integer.valueOf(size), Integer.valueOf(i2), Integer.valueOf(i6 + 1));
            a(relativeLayout, i2, size, relativeLayout);
            a(relativeLayout, iA2);
            adz adzVar = this.s.get(iA2);
            aqn aqnVar2 = (aqn) relativeLayout.getTag();
            aqnVar2.b = i2;
            aqnVar2.c = size;
            aqnVar2.a = adzVar;
            Iterator<adx> it = adzVar.k().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().E()) {
                    z = z2;
                    break;
                }
            }
            if (this.t.contains(adzVar)) {
                if ((z && zB) || !b(adzVar)) {
                    relativeLayout.setClickable(true);
                    setGrayOut(relativeLayout);
                } else {
                    if (this.q) {
                        this.q = false;
                    }
                    setNotGrayOut(linearLayout);
                    setNotGrayOut(relativeLayout);
                    relativeLayout.setClickable(true);
                }
                a(relativeLayout, adzVar);
            } else if (b(adzVar)) {
                a((View) relativeLayout);
                setNotGrayOut(relativeLayout);
                relativeLayout.setClickable(true);
            } else {
                a((View) relativeLayout);
                if (!z || zB) {
                    setGrayOut(relativeLayout);
                    relativeLayout.setClickable(true);
                }
            }
        }
        return linearLayout;
    }

    private void setGrayOut(View view) {
        view.setAlpha(0.3f);
    }

    private void setNotGrayOut(View view) {
        view.setAlpha(1.0f);
    }

    private void a(ViewGroup viewGroup, adz adzVar) {
        aqn aqnVar = (aqn) viewGroup.getTag();
        aqnVar.l.setVisibility(0);
        b(viewGroup, adzVar);
        if (this.t.contains(adzVar)) {
            agt.a(aqnVar.i, R.drawable.circle_shape, HttpStatus.SC_BAD_REQUEST, adzVar.q(), 1.2f, null);
        }
    }

    private void a(View view) {
        aqn aqnVar = (aqn) view.getTag();
        aqnVar.e.clearAnimation();
        aqnVar.e.setVisibility(8);
        aqnVar.f.clearAnimation();
        aqnVar.f.setVisibility(8);
        aqnVar.g.clearAnimation();
        aqnVar.l.setVisibility(4);
        aqnVar.k.setTypeface(ahu.a(this.g));
    }

    private void b(ViewGroup viewGroup, adz adzVar) {
        aqn aqnVar = (aqn) viewGroup.getTag();
        aqnVar.e.setVisibility(0);
        aqnVar.g.setVisibility(0);
        aqnVar.f.setVisibility(0);
        int iQ = adzVar.q();
        int iRgb = Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ));
        aqnVar.l.setVisibility(0);
        this.u.a(viewGroup, aqnVar.g, aqnVar.e, aqnVar.f, aqnVar.k, iRgb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        Iterator<adz> it = this.t.iterator();
        while (it.hasNext()) {
            if (it.next().a()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.l != null) {
            if (this.s != null && this.s.size() == 1) {
                this.l.setText(R.string.NeedMoreRooms_Str);
            } else if (n()) {
                this.l.setText(R.string.Linking_Str);
            } else {
                this.l.setText(R.string.WhereToPlayMusic_Str);
            }
        }
    }
}
