package com.harman.hkconnect.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.PlayList;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import com.harman.hkconnect.settings.SettingsActivity;
import com.harman.hkconnect.ui.TutorialActivity;
import com.harman.hkconnect.ui.custom.ListViewForScrollView;
import com.harman.hkconnect.ui.slider.SlidingUpPanelLayout;
import defpackage.adw;
import defpackage.ady;
import defpackage.adz;
import defpackage.agu;
import defpackage.agx;
import defpackage.ahf;
import defpackage.ahi;
import defpackage.ahm;
import defpackage.ahn;
import defpackage.aho;
import defpackage.aim;
import defpackage.ain;
import defpackage.aix;
import defpackage.ajf;
import defpackage.ajo;
import defpackage.aju;
import defpackage.akq;
import defpackage.aks;
import defpackage.akv;
import defpackage.aof;
import defpackage.aqc;
import defpackage.aqe;
import defpackage.aqh;
import defpackage.aqm;
import defpackage.aqo;
import defpackage.aqs;
import defpackage.aqy;
import defpackage.aqz;
import defpackage.ara;
import defpackage.arc;
import defpackage.ard;
import defpackage.ari;
import defpackage.ars;
import defpackage.arw;
import defpackage.asd;
import defpackage.asf;
import defpackage.asn;
import defpackage.asy;
import defpackage.atb;
import defpackage.atc;
import defpackage.ate;
import defpackage.atv;
import defpackage.avb;
import defpackage.ave;
import defpackage.avf;
import defpackage.avg;
import defpackage.avv;
import defpackage.avx;
import defpackage.awc;
import defpackage.awi;
import defpackage.awk;
import defpackage.awt;
import defpackage.aya;
import defpackage.ayl;
import defpackage.bcy;
import defpackage.be;
import defpackage.bqe;
import defpackage.mh;
import defpackage.ml;
import defpackage.mm;
import defpackage.mn;
import defpackage.mo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.simonvt.menudrawer.MenuDrawer;

/* JADX INFO: loaded from: classes.dex */
public class DashboardActivity extends aqc implements GestureDetector.OnGestureListener, aqe.b {
    public static int m;
    public static int n;
    private aju A;
    private aqz B;
    private LinearLayout C;
    private LinearLayout D;
    private View E;
    private LinearLayout F;
    private ListViewForScrollView G;
    private TextView H;
    private TextView I;
    private ListViewForScrollView J;
    private ListViewForScrollView K;
    private LinearLayout L;
    private TextView M;
    private aqs N;
    private int O;
    private avx Q;
    private awi R;
    private awk S;
    private aqh T;
    private TouchDisableViewPager U;
    private c V;
    private b W;
    private atv Z;
    private ajo aC;
    private MenuDrawer aa;
    private ari<SlidingUpPanelLayout> ab;
    private DragOverlayGrid ac;
    private LinkOverlayGrid ad;
    private OrientationEventListener ag;
    private aqy ai;
    private LinearLayout aj;
    private asy al;
    private ListViewForScrollView am;
    private int ao;
    private ajf as;
    private final String z = DashboardActivity.class.getName();
    private volatile boolean P = true;
    private ArrayList<BroadcastReceiver> X = new ArrayList<>();
    private aqs Y = null;
    private boolean ae = false;
    private boolean af = false;
    private avf ah = new avf(this);
    private asf ak = null;
    private boolean an = false;
    private boolean ap = false;
    private boolean aq = false;
    private boolean ar = false;
    private BroadcastReceiver at = new BroadcastReceiver() { // from class: com.harman.hkconnect.ui.DashboardActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!DashboardActivity.this.an) {
                DashboardActivity.this.aq = true;
                if (DashboardActivity.this.ao == intent.getIntExtra("Service", -1)) {
                    DashboardActivity.this.ar = true;
                    return;
                }
                return;
            }
            DashboardActivity.this.w.f();
        }
    };
    private boolean au = false;
    private List<Object> av = new ArrayList();
    private List<Object> aw = new ArrayList();
    private List<Object> ax = new ArrayList();
    private List<Integer> ay = new ArrayList();
    protected List<aqm> o = new ArrayList();
    public List<aqm> p = new ArrayList();
    private int az = 0;
    private long aA = 0;
    private boolean aB = true;
    private ara aD = null;
    private ara aE = null;
    private BroadcastReceiver aF = new BroadcastReceiver() { // from class: com.harman.hkconnect.ui.DashboardActivity.15
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "com.harman.hkconnect.android.music.ui.metachanged":
                    mm.b("PLAYLIST", "META_CHANGED");
                    DashboardActivity.this.Z();
                    DashboardActivity.this.U();
                    break;
                case "com.harman.hkconnect.android.music.ui.playstatechanged":
                    mm.b("PLAYLIST", "PLAYSTATE_CHANGED");
                    DashboardActivity.this.Z();
                    DashboardActivity.this.U();
                    break;
                case "CHANGEVOLUME":
                    DashboardActivity.this.startActivity(new Intent("com.harman.android.music.HK_CONNECT").addFlags(4194304));
                    DashboardActivity.this.k(true);
                    break;
            }
        }
    };
    private BroadcastReceiver aG = new BroadcastReceiver() { // from class: com.harman.hkconnect.ui.DashboardActivity.16
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            mm.b("Receive broadcast action=" + intent.getAction(), new Object[0]);
            switch (intent.getAction()) {
                case "ServiceBroadcast":
                    aqe aqeVarB = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB != null) {
                        aqeVarB.j();
                        break;
                    }
                    break;
                case "EditRoomPauseUi":
                    aqe aqeVarB2 = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB2 != null) {
                        aqeVarB2.l();
                        break;
                    }
                    break;
                case "UpdateRepeatShuffleUIServiceBoardcast":
                    aqe aqeVarB3 = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB3 != null && aqeVarB3.d != null) {
                        aqeVarB3.d.b();
                        break;
                    }
                    break;
                case "updateUI":
                    aqe aqeVarB4 = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB4 != null) {
                        if (aqeVarB4.B()) {
                            aqeVarB4.u();
                        } else {
                            aqeVarB4.L();
                            if (!aqeVarB4.H()) {
                                DashboardActivity.this.a(aqeVarB4);
                            } else if (MusicPlaylistManager.a().x()) {
                                aqeVarB4.J();
                            }
                        }
                        break;
                    }
                    break;
                case "updateSpotifyTime":
                    aqe aqeVarB5 = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB5 != null && aqeVarB5.B()) {
                        aqeVarB5.t();
                        break;
                    }
                    break;
                case "SpotifySubscriptionResponse":
                    mm.b("SpotifySubscribe DashboardActivity Receiver.. ", new Object[0]);
                    aqe aqeVarB6 = DashboardActivity.this.w.getPagerAdapter().b(DashboardActivity.this.w.getViewPager().getCurrentItem());
                    if (aqeVarB6 != null) {
                        aqeVarB6.a(intent.getExtras() != null ? intent.getIntExtra("SubscribeResult", 2) : 2);
                        break;
                    }
                    break;
            }
        }
    };
    boolean y = false;

    public interface b {
        boolean a(int i, KeyEvent keyEvent);
    }

    public interface c {
        boolean a(MotionEvent motionEvent);
    }

    public aju l() {
        return this.A;
    }

    public boolean m() {
        return this.P;
    }

    public void b(boolean z) {
        this.P = z;
    }

    public awk n() {
        return this.S;
    }

    public void a(awk awkVar) {
        this.S = awkVar;
    }

    public awi o() {
        return this.R;
    }

    public void a(TouchDisableViewPager touchDisableViewPager) {
        this.U = touchDisableViewPager;
    }

    public avf p() {
        return this.ah;
    }

    public aqy q() {
        return this.ai;
    }

    public void a(int i, int i2) {
        this.ac.b(i, i2);
    }

    public adz r() {
        return this.ac.getItemByIndex();
    }

    private void ai() {
        asn.a.a(getBaseContext());
        aim.a().a(new atc() { // from class: com.harman.hkconnect.ui.DashboardActivity.11
            @Override // defpackage.atc
            public void o() {
                if (DashboardActivity.this.Y != null) {
                    DashboardActivity.this.Y.notifyDataSetChanged();
                }
                if (DashboardActivity.this.au) {
                    DashboardActivity.this.al.a();
                }
            }

            @Override // defpackage.atc
            public void p() {
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        this.A.b();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.A.a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    public MenuDrawer s() {
        return this.aa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        aho.a("KEY_SHOW_DLNA", false);
        Resources resources = getResources();
        String packageName = getPackageName();
        mh mhVar = new mh(resources.getIdentifier("notification_custom_builder", "layout", packageName), resources.getIdentifier("notification_icon", "id", packageName), resources.getIdentifier("notification_title", "id", packageName), resources.getIdentifier("notification_text", "id", packageName));
        mhVar.c(16);
        mhVar.d(2);
        mhVar.a(resources.getIdentifier("ic_launcher", "drawable", packageName));
        mhVar.b(getApplicationInfo().icon);
        mhVar.a(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6").toString());
        String country = getResources().getConfiguration().locale.getCountry();
        if (!agu.a.contains(country)) {
            agu.a(country);
        }
        am();
        ai();
        ard ardVar = new ard(this, false);
        ardVar.a(false);
        ardVar.a();
        this.al = new asy(this);
        this.B = new aqz(this);
        this.B.a(false);
        this.B.a();
        new ahm(this, this.at).a(new IntentFilter("com.harman.hkconnect.ui.queueShouldClearOnLogOutAction"));
        AnonymousClass20 anonymousClass20 = new AnonymousClass20(ardVar);
        boolean z = (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().getBoolean("SETUP_SUCCESS")) ? false : true;
        if (!MusicPlaylistManager.a().v() && !z) {
            this.ak = new asf(this, new a());
            this.ak.a(anonymousClass20);
            this.ak.show();
        }
        this.ao = aho.c("MOST_RECENT_SERVICE");
        this.A = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.A.a(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.21
            @Override // java.lang.Runnable
            public void run() {
                if (!ajo.c) {
                    DashboardActivity.this.P = false;
                    DashboardActivity.this.s().m();
                }
            }
        });
        al();
        d(ain.o);
        if (aim.b()) {
            aho.a("MOST_RECENT_SERVICE", 100);
            this.ao = 100;
        }
        ain.H = aho.b("SHARE_KEY_IS_NOT_FIRST_PARTY", true);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.locale == null) {
            configuration.locale = Locale.getDefault();
        }
        aho.a("LANGUAGE", configuration.locale.getLanguage());
        this.Z = atv.a();
        this.Z.a(mo.a);
        if (ain.h) {
            this.Z.b();
        }
        this.w = (BottomPlayer) findViewById(R.id.widget_drawer_top);
        this.ag = new OrientationEventListener(this) { // from class: com.harman.hkconnect.ui.DashboardActivity.22
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
            }
        };
        this.ab = new ari<>((SlidingUpPanelLayout) findViewById(R.id.sliding_layout));
        ((SlidingUpPanelLayout) this.ab.a()).setBottomPlayer(this.w);
        ((SlidingUpPanelLayout) this.ab.a()).setPanelSlideListener(new SlidingUpPanelLayout.e() { // from class: com.harman.hkconnect.ui.DashboardActivity.23
            @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.e, com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
            public void a(View view, float f) {
                Point point = new Point();
                DashboardActivity.this.getWindowManager().getDefaultDisplay().getSize(point);
                int i = point.y;
                int collapsedTop = i - ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).getCollapsedTop();
                int panelTop = (i - ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).getPanelTop()) - collapsedTop;
                if (DashboardActivity.this.w.a()) {
                    DashboardActivity.this.w.a(f, ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).a(a((float) (((double) ((i - collapsedTop) - panelTop)) / ((double) (i - collapsedTop))))));
                }
            }

            @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.e, com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
            public void a(View view) {
                DashboardActivity.this.M();
                DashboardActivity.this.v = false;
                if (!DashboardActivity.this.w.a()) {
                    DashboardActivity.this.at();
                } else {
                    DashboardActivity.this.w.a(DashboardActivity.this.v);
                }
            }

            @Override // com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.e, com.harman.hkconnect.ui.slider.SlidingUpPanelLayout.c
            public void b(View view) {
                DashboardActivity.this.L();
                DashboardActivity.this.v = true;
                DashboardActivity.this.w.a(DashboardActivity.this.v);
                aqo.f().e();
                if (aim.c) {
                    mm.b();
                    aim.g();
                    DashboardActivity.this.a(TutorialActivity.a.SWITCH_ROOMS);
                }
                adw.a().b();
            }

            private float a(float f) {
                if (f < 0.0f) {
                    return 0.0f;
                }
                if (f > 1.0f) {
                    return 1.0f;
                }
                return f;
            }
        });
        m = ((SlidingUpPanelLayout) this.ab.a()).a(0.0f);
        n = ((SlidingUpPanelLayout) this.ab.a()).a(1.0f);
        this.aa.setOnDrawerStateChangeListener(new MenuDrawer.a() { // from class: com.harman.hkconnect.ui.DashboardActivity.24
            @Override // net.simonvt.menudrawer.MenuDrawer.a
            public void a(int i, int i2) {
                if (i == 0 && i2 == 2) {
                    DashboardActivity.this.P = false;
                } else if (i == 1 && i2 == 0) {
                    DashboardActivity.this.P = true;
                    ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).setHasSpeakers(DashboardActivity.this.w.a());
                }
                if (DashboardActivity.this.T != null && DashboardActivity.this.T.v()) {
                    DashboardActivity.this.T.as();
                }
                ahf.a(this);
            }

            @Override // net.simonvt.menudrawer.MenuDrawer.a
            public void a(float f, int i) {
            }
        });
        if (Build.VERSION.SDK_INT <= 19) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("overscroll_glow", "drawable", "android"));
            int color = getResources().getColor(R.color.edge);
            int iRgb = Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
            drawable.setColorFilter(iRgb, PorterDuff.Mode.SRC_IN);
            getResources().getDrawable(getResources().getIdentifier("overscroll_edge", "drawable", "android")).setColorFilter(iRgb, PorterDuff.Mode.SRC_IN);
        }
        new ars(this).a(this);
        this.aj = (LinearLayout) findViewById(R.id.umano_drawer_blocker);
        this.aj.setVisibility(0);
        this.am = (ListViewForScrollView) findViewById(R.id.chromecast_listview);
        if (this.ao != 100) {
            this.ah.b(this.ao);
        }
        if (this.ak == null) {
            anonymousClass20.run();
        }
    }

    /* JADX INFO: renamed from: com.harman.hkconnect.ui.DashboardActivity$20, reason: invalid class name */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ ard a;

        AnonymousClass20(ard ardVar) {
            this.a = ardVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(true);
            DashboardActivity.this.B.a(true);
            if (!DashboardActivity.this.au && atb.a != null) {
                DashboardActivity.this.al.a();
            }
            DashboardActivity.this.au = true;
            DashboardActivity.this.aa.setVisibility(0);
            DashboardActivity.this.k();
            if (!DashboardActivity.this.an) {
                DashboardActivity.this.ap = true;
            } else {
                DashboardActivity.this.k();
            }
            mo.a.postDelayed(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.20.1
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivity.this.ak();
                    if (aim.c()) {
                        DashboardActivity.this.H();
                        aim.f();
                    }
                    DashboardActivity.this.ak = null;
                    mo.a.post(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.20.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!DashboardActivity.this.isFinishing()) {
                                mm.b("Setting background of %s to null", DashboardActivity.this.getWindow().getDecorView());
                                DashboardActivity.this.getWindow().getDecorView().setBackground(null);
                                DashboardActivity.this.aa.getContentContainer().setBackground(null);
                            }
                        }
                    });
                }
            }, 200L);
        }
    }

    private void aj() {
        if (ain.o && !aho.a("KEY_ALREADY_POPUP_GOOGLECAST")) {
            w();
            aho.a("KEY_ALREADY_POPUP_GOOGLECAST", true);
        }
    }

    public ajf C() {
        if (this.as == null) {
            this.as = new ajf();
        }
        return this.as;
    }

    public class a {
        public a() {
        }

        public void a() {
            DashboardActivity.this.ak();
            if (!DashboardActivity.this.au && atb.a != null) {
                DashboardActivity.this.al.a();
            }
            DashboardActivity.this.au = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        if (this.x == null) {
            this.x = new ate(this, this.al);
            this.x.a();
            mm.b("TEST_DEVICE_FOTA_CHANGE start monitor init", new Object[0]);
        }
    }

    public aqs D() {
        return this.Y;
    }

    private void al() {
        this.ai = new aqy(f(), R.id.middle_panel);
        f().a(new be.c() { // from class: com.harman.hkconnect.ui.DashboardActivity.25
            @Override // be.c
            public void a() {
                aho.a("MOST_RECENT_SERVICE", DashboardActivity.this.ai.e() == null ? 100 : DashboardActivity.this.ai.e().intValue());
            }
        });
        this.ac = (DragOverlayGrid) findViewById(R.id.drag_overlay_grid_layout);
        this.ad = (LinkOverlayGrid) findViewById(R.id.link_overlay_grid_layout);
        this.T = new aqh();
        this.ai.a(this.T, (Bundle) null, 100);
        ((TextView) findViewById(R.id.empty_bottomplayer_setup)).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, (Class<?>) ProductSetupMasterActivity.class);
                intent.putExtra("SETUP_TYPE", 0);
                DashboardActivity.this.startActivity(intent);
            }
        });
    }

    public void E() {
        if (!this.v) {
            this.v = true;
            ((SlidingUpPanelLayout) this.ab.a()).setPanelState(SlidingUpPanelLayout.d.EXPANDED);
            if (this.w != null) {
                this.w.d();
            }
        }
    }

    private void am() {
        getWindow().setFlags(16777216, 16777216);
        this.aa = MenuDrawer.a(this, MenuDrawer.c.BEHIND, bqe.START, 0);
        this.aa.setContentView(R.layout.dashboard);
        this.aa.setMenuView(R.layout.settings_menulist);
        this.aa.setVisibility(8);
    }

    private List<aqm> an() {
        this.o.clear();
        aqm aqmVar = new aqm();
        aqmVar.a(R.drawable.pandora_small_icon);
        aqmVar.a(getResources().getString(R.string.Pandora));
        aqmVar.b("com.pandora.android");
        this.o.add(aqmVar);
        aqm aqmVar2 = new aqm();
        aqmVar2.a(R.drawable.tunein_small_icon);
        aqmVar2.a(getResources().getString(R.string.Tunein));
        aqmVar2.b("tunein.player");
        this.o.add(aqmVar2);
        aqm aqmVar3 = new aqm();
        aqmVar3.a(R.drawable.deezer_small_icon);
        aqmVar3.a(getResources().getString(R.string.kDeezer_Str));
        aqmVar3.b("deezer.android.app");
        this.o.add(aqmVar3);
        aqm aqmVar4 = new aqm();
        aqmVar4.a(R.drawable.iheart_small_icon);
        aqmVar4.a(getResources().getString(R.string.iHeartRadio));
        aqmVar4.b("com.clearchannel.iheartradio.controller");
        this.o.add(aqmVar4);
        aqm aqmVar5 = new aqm();
        aqmVar5.a(R.drawable.google_music_small_icon);
        aqmVar5.a(getResources().getString(R.string.Google_Play_Music));
        aqmVar5.b("com.google.android.music");
        this.o.add(aqmVar5);
        aqm aqmVar6 = new aqm();
        aqmVar6.a(R.drawable.rhapsody_small_icon);
        aqmVar6.a(getResources().getString(R.string.Rhapsody));
        aqmVar6.b("com.rhapsody");
        this.o.add(aqmVar6);
        aqm aqmVar7 = new aqm();
        aqmVar7.a(R.drawable.n_p_r_one_small_icon);
        aqmVar7.a(getResources().getString(R.string.NPR_one));
        aqmVar7.b("org.npr.one");
        this.o.add(aqmVar7);
        return this.o;
    }

    private List<aqm> ao() {
        this.p.clear();
        aqm aqmVar = new aqm();
        aqmVar.a(R.drawable.spotify_small_icon);
        aqmVar.a(getResources().getString(R.string.Spotify));
        aqmVar.b("com.spotify.music");
        this.p.add(aqmVar);
        return this.p;
    }

    private void c(boolean z) {
        this.ah.b();
        this.av.clear();
        this.aw.clear();
        this.ax.clear();
        if (z) {
            this.av.addAll(an());
            this.av.add(getResources().getString(R.string.SettingMoreApps_Str));
            this.ax.addAll(ao());
            this.ax.add(getResources().getString(R.string.kMoreInformation));
            a(this.ay, false);
            this.aw.addAll(this.ah.a());
            return;
        }
        a(this.ay, true);
        this.aw.addAll(this.ah.a());
    }

    private boolean a(List<Integer> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (Integer num : list) {
                if (num != null && num.intValue() == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(List<Integer> list, boolean z) {
        ArrayList<ave> arrayListL = aim.a().l();
        ArrayList arrayList = new ArrayList();
        aks aksVar = new aks(this);
        aksVar.a(aim.a().j());
        arrayList.add(aksVar);
        for (int i = 0; i < arrayListL.size(); i++) {
            ave aveVar = arrayListL.get(i);
            if (aveVar.d() == 0 && (!a(list, aveVar.d()) || z)) {
                aya ayaVar = new aya(this);
                ayaVar.a(aveVar);
                arrayList.add(ayaVar);
            } else if (aveVar.d() == 1 && (!a(list, aveVar.d()) || z)) {
                akq akqVar = new akq(this);
                akqVar.a(aveVar);
                arrayList.add(akqVar);
            } else if (aveVar.d() == 2 && (!a(list, aveVar.d()) || z)) {
                akv akvVar = new akv(this);
                akvVar.a(aveVar);
                arrayList.add(akvVar);
            } else if (aveVar.d() == 5 && (!a(list, aveVar.d()) || z)) {
                bcy bcyVar = new bcy(this);
                bcyVar.a(aveVar);
                arrayList.add(bcyVar);
            } else if (aveVar.d() == 6 && (!a(list, aveVar.d()) || z)) {
                new awt(this).a(aveVar);
            } else if (aveVar.d() == 7 && (!a(list, aveVar.d()) || z)) {
                avg avgVar = new avg(this);
                avgVar.a(aveVar);
                arrayList.add(avgVar);
            } else if (aveVar.d() == 8 && (!a(list, aveVar.d()) || z)) {
                awc awcVar = new awc(this);
                awcVar.a(aveVar);
                if (aho.b("KEY_SHOW_DLNA", false)) {
                    arrayList.add(awcVar);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.ah.a((avb) arrayList.get(i2));
        }
    }

    @Override // defpackage.aqc
    public void j(boolean z) {
        super.j(z);
        d(ain.o);
    }

    public void a(final aqm aqmVar) {
        arw arwVarB = new arw.a(this).a(getString(R.string.SettingOpenInstallGoogleCastApp_Str, new Object[]{aqmVar.d()})).a(getString(R.string.SettingOpenApp_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent launchIntentForPackage = DashboardActivity.this.getPackageManager().getLaunchIntentForPackage(aqmVar.c());
                if (launchIntentForPackage != null) {
                    DashboardActivity.this.startActivity(launchIntentForPackage);
                }
            }
        }).b(getString(R.string.Cancel_Str), null).d(false).b();
        if (!isFinishing()) {
            arwVarB.show();
        }
    }

    public void b(final aqm aqmVar) {
        String string = getString(R.string.SettingOpenNotInstallGoogleCastApp_Str, new Object[]{aqmVar.d(), aqmVar.d()});
        if (string != null && aqmVar.d().equalsIgnoreCase(getString(R.string.Spotify)) && string.indexOf("app to start Casting") != -1) {
            string = string.replaceFirst("Casting", "listening");
            mm.c("Change Spotify message to: %s", string);
        }
        arw arwVarB = new arw.a(this).a(string).a(getString(R.string.SettingOpenApp_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + aqmVar.c());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                DashboardActivity.this.startActivity(intent);
            }
        }).b(getString(R.string.Cancel_Str), null).d(false).b();
        if (!isFinishing()) {
            arwVarB.show();
        }
    }

    private void d(boolean z) {
        c(z);
        this.E = findViewById(R.id.dash_board_left_drag_intergated_googlecast);
        this.C = (LinearLayout) this.E.findViewById(R.id.intergated_sources_ll);
        this.D = (LinearLayout) this.E.findViewById(R.id.google_cast_ll);
        this.L = (LinearLayout) this.E.findViewById(R.id.spotify_connect_ll);
        this.J = (ListViewForScrollView) this.E.findViewById(R.id.music_servers_mk1_listview3);
        this.H = (TextView) this.E.findViewById(R.id.dash_board_left_drag_intergated_tv);
        this.I = (TextView) this.E.findViewById(R.id.dash_board_left_drag_googlecast_tv);
        this.M = (TextView) this.E.findViewById(R.id.dash_board_left_drag_spotify_connect_tv);
        this.am = (ListViewForScrollView) findViewById(R.id.intergated_listview);
        this.G = (ListViewForScrollView) findViewById(R.id.chromecast_listview);
        this.K = (ListViewForScrollView) findViewById(R.id.spotify_listview);
        if ((this.F == null || this.F == this.D || this.F == this.L) && z) {
            this.Y = new aqs(this, this.av);
            this.G.setAdapter((ListAdapter) this.Y);
            this.N = new aqs(this, this.ax);
            this.K.setAdapter((ListAdapter) this.N);
            this.H.setSelected(false);
            this.M.setSelected(true);
            this.I.setSelected(true);
        } else {
            this.Y = new aqs(this, this.aw);
            this.am.setAdapter((ListAdapter) this.Y);
            this.H.setSelected(true);
            this.I.setSelected(false);
            this.M.setSelected(false);
        }
        if (!z) {
            this.Y = new aqs(this, this.aw);
            this.J.setAdapter((ListAdapter) this.Y);
            this.J.setVisibility(0);
            this.Y.notifyDataSetChanged();
            this.D.setVisibility(8);
            this.C.setVisibility(8);
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
            this.D.setVisibility(0);
            this.C.setVisibility(0);
            this.J.setVisibility(8);
            this.Y = new aqs(this, this.av);
            this.Y.notifyDataSetChanged();
            this.N = new aqs(this, this.ax);
            this.N.notifyDataSetChanged();
        }
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DashboardActivity.this.H.isSelected()) {
                    DashboardActivity.this.as();
                } else {
                    DashboardActivity.this.aq();
                    DashboardActivity.this.ar();
                }
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DashboardActivity.this.I.isSelected()) {
                    DashboardActivity.this.aq();
                    DashboardActivity.this.ar();
                } else {
                    DashboardActivity.this.as();
                }
            }
        });
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DashboardActivity.this.M.isSelected()) {
                    DashboardActivity.this.aq();
                    DashboardActivity.this.ar();
                } else {
                    DashboardActivity.this.as();
                }
            }
        });
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object item = adapterView.getAdapter().getItem(i);
                if (item instanceof avb) {
                    avb avbVar = (avb) item;
                    String strG = avbVar.h().g();
                    DashboardActivity.this.O = -1;
                    if ((!strG.equalsIgnoreCase("deezer") && !strG.equalsIgnoreCase("qobuz")) || ahi.b()) {
                        DashboardActivity.this.ah.a(avbVar.f());
                        DashboardActivity.this.Y.notifyDataSetChanged();
                        DashboardActivity.this.aa.n();
                    } else {
                        ahi.a(1000);
                        DashboardActivity.this.O = avbVar.f();
                    }
                    aqo.f().a(avbVar.h().g());
                    return;
                }
                if (item instanceof aqm) {
                    aqm aqmVar = (aqm) item;
                    if (aqmVar.b()) {
                        if (!aho.a(aqmVar.c())) {
                            DashboardActivity.this.a(aqmVar);
                            aho.a(aqmVar.c(), true);
                            return;
                        } else {
                            Intent launchIntentForPackage = DashboardActivity.this.getPackageManager().getLaunchIntentForPackage(aqmVar.c());
                            if (launchIntentForPackage != null) {
                                DashboardActivity.this.startActivity(launchIntentForPackage);
                                return;
                            }
                            return;
                        }
                    }
                    DashboardActivity.this.b(aqmVar);
                    aho.a(aqmVar.c(), true);
                }
            }
        };
        this.G.setOnItemClickListener(onItemClickListener);
        this.am.setOnItemClickListener(onItemClickListener);
        this.K.setOnItemClickListener(onItemClickListener);
        this.J.setOnItemClickListener(onItemClickListener);
        f().a(new be.c() { // from class: com.harman.hkconnect.ui.DashboardActivity.8
            @Override // be.c
            public void a() {
                DashboardActivity.this.Y.notifyDataSetChanged();
            }
        });
        findViewById(R.id.left_menu_settings).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DashboardActivity.this.ap()) {
                    DashboardActivity.this.startActivity(new Intent(DashboardActivity.this, (Class<?>) SettingsActivity.class));
                    aqo.f().d();
                    return;
                }
                if (DashboardActivity.this.aA > 0) {
                    long jUptimeMillis = SystemClock.uptimeMillis() - DashboardActivity.this.aA;
                    System.out.println("------Bright---------->" + jUptimeMillis);
                    if (jUptimeMillis >= 300) {
                        DashboardActivity.this.az = 0;
                        DashboardActivity.this.aA = 0L;
                        return;
                    }
                    DashboardActivity.this.az++;
                    if (DashboardActivity.this.az > 10) {
                        DashboardActivity.this.az = 0;
                        DashboardActivity.this.aA = 0L;
                        DashboardActivity.this.startActivity(new Intent(DashboardActivity.this, (Class<?>) SettingsActivity.class));
                        aqo.f().d();
                    }
                    DashboardActivity.this.aA = SystemClock.uptimeMillis();
                    return;
                }
                DashboardActivity.this.aA = SystemClock.uptimeMillis();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ap() {
        return aho.b("KEY_ENTER_DEMO_MODE", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        this.D.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_select_button));
        this.I.setTextColor(-1);
        this.C.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.H.setTextColor(-7829368);
        this.L.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.M.setTextColor(-1);
        this.am.setVisibility(8);
        this.Y = new aqs(this, this.av);
        this.G.setVisibility(0);
        this.G.setAdapter((ListAdapter) this.Y);
        this.Y.notifyDataSetChanged();
        this.F = this.D;
        this.H.setSelected(false);
        this.M.setSelected(true);
        this.I.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar() {
        this.L.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_select_button));
        this.M.setTextColor(-1);
        this.D.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.I.setTextColor(-1);
        this.C.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.H.setTextColor(-7829368);
        this.am.setVisibility(8);
        this.N = new aqs(this, this.ax);
        this.K.setVisibility(0);
        this.K.setAdapter((ListAdapter) this.N);
        this.N.notifyDataSetChanged();
        this.F = this.L;
        this.M.setSelected(true);
        this.H.setSelected(false);
        this.I.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        this.C.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_select_button));
        this.H.setTextColor(-1);
        this.L.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.M.setTextColor(-7829368);
        this.D.setBackground(getResources().getDrawable(R.drawable.google_cast_or_intergate_unselect_button));
        this.I.setTextColor(-7829368);
        this.G.setVisibility(8);
        this.K.setVisibility(8);
        this.Y = new aqs(this, this.aw);
        this.am.setVisibility(0);
        this.am.setAdapter((ListAdapter) this.Y);
        this.Y.notifyDataSetChanged();
        this.F = this.C;
        this.H.setSelected(true);
        this.I.setSelected(false);
        this.M.setSelected(false);
    }

    public boolean F() {
        return this.ac.c();
    }

    public Point b(int i, int i2) {
        return this.ac.a(i, i2);
    }

    public void G() {
        this.aC = null;
        this.ac.b();
    }

    public void a(ajo ajoVar) {
        this.aC = ajoVar;
        this.ac.a();
    }

    public void a(boolean z, byte b2) {
        this.ad.a(z, b2);
        if (aim.d) {
            aim.h();
            a(TutorialActivity.a.LINK_ROOMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TutorialActivity.a aVar) {
        mm.b();
        Intent intent = new Intent(this, (Class<?>) TutorialActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("PAGE_TYPE", aVar);
        bundle.putBoolean("FIRST_TIME", true);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void H() {
        Intent intent = new Intent(this, (Class<?>) TutorialActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("PAGE_TYPE", TutorialActivity.a.MUSIC_SERVICES);
        bundle.putBoolean("FIRST_TIME", true);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1006);
    }

    public void I() {
        this.ad.e();
    }

    public void J() {
        ((SlidingUpPanelLayout) this.ab.a()).b();
    }

    public void K() {
        aks aksVar = new aks(this);
        aksVar.a(aim.a().j());
        this.ah.a(aksVar.f());
        this.Y.notifyDataSetChanged();
    }

    public void L() {
        this.aa.setTouchMode(0);
    }

    public void M() {
        this.aa.setTouchMode(1);
    }

    public void N() {
        this.U.setCanSwipe(false);
    }

    public void O() {
        this.U.setCanSwipe(true);
    }

    public void P() {
        ((SlidingUpPanelLayout) this.ab.a()).setTouchEnabled(false);
    }

    public void Q() {
        ((SlidingUpPanelLayout) this.ab.a()).setTouchEnabled(true);
    }

    public boolean R() {
        return this.v;
    }

    public void S() {
        try {
            this.ai.b();
        } catch (IllegalStateException e) {
            try {
                new ml().a("Illegal state, try post instead", e);
                new Handler().post(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.10
                    @Override // java.lang.Runnable
                    public void run() {
                        DashboardActivity.this.ai.b();
                    }
                });
            } catch (Exception e2) {
                new ml().a("Could not Post popToRoot", e);
            }
        }
        aa();
        mo.a.postDelayed(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.12
            @Override // java.lang.Runnable
            public void run() {
                DashboardActivity.this.getWindow().getDecorView().postInvalidate();
            }
        }, 100L);
    }

    public void T() {
        S();
    }

    public void a(Class<?>... clsArr) {
        b(clsArr);
        S();
    }

    private void b(Class<?>... clsArr) {
        if (clsArr != null && clsArr.length != 0) {
            PlayList playListI = MusicPlaylistManager.a().i();
            int i = 0;
            boolean zD = false;
            while (i < playListI.a()) {
                MusicData musicDataB = playListI.b(i);
                int length = clsArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Class<?> cls = clsArr[i2];
                        if (musicDataB == null || !cls.isAssignableFrom(musicDataB.getClass())) {
                            i2++;
                        } else {
                            zD = playListI.d(i);
                            i--;
                            break;
                        }
                    }
                }
                i++;
            }
            if (playListI.a() == 0 && MusicPlaylistManager.a().v()) {
                aof.a().j();
            }
            if (MusicPlaylistManager.a().v() && zD) {
                MusicPlaylistManager.a().e(playListI.f());
            }
        }
    }

    public void U() {
        this.w.f();
    }

    public void V() {
        this.w.e();
        W();
    }

    public void W() {
        this.w.b(getFragmentManager(), ahn.a((Activity) this));
    }

    public void a(Runnable runnable) {
        if (this.aD != null) {
            this.aD.b();
        }
        if (aof.a().d().size() > 0) {
            this.aD = new ara(this, this.w, runnable);
            this.aD.a();
        } else {
            b((Runnable) null);
        }
    }

    public void b(Runnable runnable) {
        if (this.aE != null) {
            this.aE.b();
        }
        this.aE = new ara(this, this.aj, runnable);
        this.aE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (this.w != null && this.w.a()) {
            this.w.setBottomPlayerShown(false);
            this.ab.a(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    if (!DashboardActivity.this.ae) {
                        ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).b();
                        DashboardActivity.this.w.clearAnimation();
                        DashboardActivity.this.w.animate().translationY(DashboardActivity.this.getResources().getDimensionPixelSize(R.dimen.bottom_player_height)).setStartDelay(300L).setDuration(300L).setListener(new Animator.AnimatorListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.13.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                DashboardActivity.this.ae = true;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                DashboardActivity.this.ae = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }
                        }).start();
                    }
                }
            });
        }
    }

    private void au() {
        if (this.w != null && !this.w.a()) {
            this.w.setBottomPlayerShown(true);
            if (this.w.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
            if (!this.af) {
                this.w.clearAnimation();
                this.w.animate().translationY(0.0f).setDuration(300L).setListener(new Animator.AnimatorListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.14
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        DashboardActivity.this.af = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        DashboardActivity.this.af = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aqe aqeVar) {
        if (aqeVar.a.w()) {
            aqeVar.f();
        } else {
            aqeVar.e();
        }
        if (aqeVar.E()) {
            aqeVar.s();
        }
    }

    public void X() {
        Iterator<aqe> it = this.w.getPagerAdapter().d().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public void Y() {
        this.w.getPagerAdapter().b(this.w.getViewPager().getCurrentItem()).h();
    }

    public void Z() {
        this.w.e();
    }

    public void aa() {
    }

    public void ab() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ba, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("CHANGEVOLUME", false);
        boolean booleanExtra2 = intent.getBooleanExtra("SETUP_SUCCESS", false);
        boolean booleanExtra3 = intent.getBooleanExtra("GO_TO_MIXRADIO", false);
        if (booleanExtra2 && booleanExtra3) {
            q().a(new ayl(), 0, (arc) null);
            if (this.aa != null) {
                this.aa.n();
            }
        }
        if (booleanExtra) {
            if (this.u != null && this.u.isShowing()) {
                this.u.dismiss();
            }
            if (((SlidingUpPanelLayout) this.ab.a()).getPanelState() != SlidingUpPanelLayout.d.EXPANDED || (this.w.getGroupListSize() > 1 && ((SlidingUpPanelLayout) this.ab.a()).getPanelState() == SlidingUpPanelLayout.d.EXPANDED)) {
                k(true);
            }
        }
        if (intent.getBooleanExtra("menustate", false)) {
            this.aa.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.ba, android.app.Activity
    public void onResume() {
        mn.a();
        ain.J = this;
        super.onResume();
        this.w.a(this.v);
        if (this.ap) {
            this.ap = false;
            k();
            if (this.ao != 100) {
                this.ah.b(this.ao);
            }
        }
        if (this.aq) {
            this.aq = false;
            this.w.f();
        }
        this.an = true;
        d(ain.o);
        this.ag.enable();
        ain.m = false;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.playstatechanged");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.metachanged");
        intentFilter.addAction("CHANGEVOLUME");
        new ahm(this, this.aF).b(new IntentFilter(intentFilter));
        k();
        if (!av() || this.ar) {
            S();
            this.ar = false;
        }
        if (this.x != null) {
            this.x.a();
            mm.b("TEST_DEVICE_FOTA_CHANGE start monitor -- onresume", new Object[0]);
        }
        adw.a().b();
        if (ap()) {
            findViewById(R.id.settings_icon).setAlpha(0.45f);
            findViewById(R.id.settings_text).setAlpha(0.45f);
        } else {
            findViewById(R.id.settings_icon).setAlpha(1.0f);
            findViewById(R.id.settings_text).setAlpha(1.0f);
        }
    }

    public void ac() {
        if (!this.y) {
            this.y = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ServiceBroadcast");
            intentFilter.addAction("UpdateRepeatShuffleUIServiceBoardcast");
            intentFilter.addAction("updateSpotifyAlbumPicture");
            intentFilter.addAction("updateSpotifyTime");
            intentFilter.addAction("updateUI");
            intentFilter.addAction("EditRoomPauseUi");
            intentFilter.addAction("SpotifySubscriptionResponse");
            registerReceiver(this.aG, intentFilter);
        }
    }

    public void ad() {
        try {
            if (this.y) {
                this.y = false;
                unregisterReceiver(this.aG);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private boolean av() {
        if (this.ao == 100) {
            return true;
        }
        ArrayList<ave> arrayListL = aim.a().l();
        if (arrayListL != null) {
            Iterator<ave> it = arrayListL.iterator();
            while (it.hasNext()) {
                if (it.next().d() == this.ao) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.ba, android.app.Activity
    public void onPause() {
        this.an = false;
        aw();
        if (this.ag != null) {
            this.ag.disable();
        }
        if (this.x != null) {
            this.x.b();
        }
        if (this.aC != null) {
            this.aC.c();
        }
        super.onPause();
        this.B.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void k() {
        super.k();
        mm.b("isBottomPlayerShown() ? " + this.w.a() + ", getRoomList().isEmpty() " + aof.a().d().isEmpty(), new Object[0]);
        if (aof.a().d().isEmpty()) {
            if (this.w.a()) {
                at();
                ((SlidingUpPanelLayout) this.ab.a()).setHasSpeakers(false);
                mo.a.postDelayed(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.17
                    @Override // java.lang.Runnable
                    public void run() {
                        DashboardActivity.this.ab.a(new Runnable() { // from class: com.harman.hkconnect.ui.DashboardActivity.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).b();
                                ((SlidingUpPanelLayout) DashboardActivity.this.ab.a()).getSlideableView().setVisibility(4);
                            }
                        });
                    }
                }, 100L);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setDuration(1000L);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.18
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DashboardActivity.this.aj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                valueAnimatorOfFloat.start();
            }
            this.aj.setVisibility(0);
            this.w.invalidate();
        } else {
            if (!this.w.a()) {
                au();
                ((SlidingUpPanelLayout) this.ab.a()).setHasSpeakers(true);
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat2.setDuration(1000L);
                final View slideableView = ((SlidingUpPanelLayout) this.ab.a()).getSlideableView();
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.harman.hkconnect.ui.DashboardActivity.19
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (slideableView != null) {
                            slideableView.setVisibility(0);
                            slideableView.setAlpha(fFloatValue);
                        }
                    }
                });
                valueAnimatorOfFloat2.start();
            }
            this.aj.setVisibility(8);
            this.w.invalidate();
        }
        ady adyVarB = aof.a().b();
        if (adyVarB != null && adyVarB.f().size() > 0) {
            if (this.ac != null) {
                this.ac.d();
            }
            if (this.ad != null) {
                this.ad.a();
            }
        }
        if (this.A != null) {
            MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
            if (musicPlaylistManagerA.v() && musicPlaylistManagerA.s() != null && musicPlaylistManagerA.s().path != null) {
                b(musicPlaylistManagerA.s().path.toLowerCase());
            }
            if (this.w != null) {
                this.w.c();
            }
        }
    }

    private void b(String str) {
        ady adyVarB = aof.a().b();
        if (adyVarB != null && adyVarB.n() <= 2) {
            if (c(str) && !ain.i && !MusicPlaylistManager.a().v()) {
                ain.i = true;
                aof.a().j();
                return;
            }
            return;
        }
        if (c(str)) {
            if (ain.i) {
                ain.i = false;
                Toast.makeText(this, R.string.kAutoSwitchLosslessTip_Str, 1).show();
                MusicPlaylistManager.a().p();
                return;
            }
            return;
        }
        if (ain.i) {
            ain.i = false;
            MusicPlaylistManager.a().p();
        }
    }

    private boolean c(String str) {
        return str.endsWith(".wav") || str.endsWith(".flac") || str.endsWith(".alac");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void z() {
        Toast.makeText(this, R.string.CurrentStreamingGroupDisconnectMessage_Str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void y() {
        super.y();
        W();
        if (this.u != null && this.u.isShowing()) {
            new asd(this.u).a();
        }
    }

    @Override // defpackage.aqb, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.V != null && ain.k) {
            this.V.a(motionEvent);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (RuntimeException e) {
            new ml().a("Could not use touch event " + motionEvent, e);
            return false;
        }
    }

    public void a(c cVar) {
        this.V = cVar;
    }

    public void ae() {
        this.V = null;
    }

    @Override // defpackage.aqc, defpackage.gk, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.aa != null && this.aa.a()) {
            this.aa.n();
            return true;
        }
        if (i == 4 && this.v) {
            if (this.w.g()) {
                this.w.b(getFragmentManager(), ahn.a((Activity) this));
            } else if (this.ad.getVisibility() == 0) {
                I();
            } else {
                ((SlidingUpPanelLayout) this.ab.a()).b();
            }
            return true;
        }
        if (i == 4 && this.W != null) {
            if (!this.W.a(i, keyEvent)) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                startActivity(intent);
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void a(b bVar) {
        this.W = bVar;
    }

    public void af() {
        this.W = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.gk, defpackage.ba, android.app.Activity
    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.X.size()) {
                try {
                    unregisterReceiver(this.X.get(i2));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            } else {
                ad();
                aho.a("streamingGroupId", -1);
                super.onDestroy();
                setResult(-1);
                return;
            }
        }
    }

    private void aw() {
        Integer numE = this.ai.e();
        this.ao = numE == null ? 100 : numE.intValue();
    }

    @Override // defpackage.gk, defpackage.ba, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!aho.d("LANGUAGE").equals(configuration.locale.getLanguage())) {
            ax();
        }
        this.w.b();
    }

    private void ax() {
        Intent intent = new Intent(this, (Class<?>) DashboardActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void ag() {
        if (f().e() != 0) {
            f().c();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void ah() {
        this.w.a(getFragmentManager(), ahn.a((Activity) this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ba, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ah.a(i, i2, intent);
        if (this.ak != null) {
            this.ak.a(i);
        }
        if (i == 1006) {
            aj();
        }
        mm.b("TESTMENU", "requestCode=" + i);
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        mm.b(this.z, "inside Dashboard Activity onback");
        if (l() != null && l().e() && (this.ai.a() instanceof aix) && !(q().a() instanceof avv)) {
            this.T.aq();
        }
        if (this.aC != null) {
            this.aC.c();
        }
        if (!this.ai.a(this)) {
            super.onBackPressed();
        }
        if (this.Q != null) {
            this.Q.ay();
        }
        if (l() != null && l().a().x() != null) {
            l().a().x().a();
        }
    }

    public void a(avx avxVar) {
        this.Q = avxVar;
    }

    @Override // aqe.b
    public ImageView a() {
        return this.w.getAlbumArtAlpha();
    }

    @Override // aqe.b
    public ImageView b() {
        return this.w.getAlbumArtAlphaBehind();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        mn.a();
        mm.b("onTrimMemory %s", Integer.valueOf(i));
        agx.a().b();
        mn.a();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.au) {
            this.B.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void x() {
        s().m();
    }

    @Override // defpackage.ba, android.app.Activity, at.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000 && ahi.b() && this.O > 0) {
            this.Y.notifyDataSetChanged();
            this.aa.n();
            this.ah.a(this.O);
        }
    }
}
