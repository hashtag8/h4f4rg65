package com.harman.hkconnect.settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.RippleTextView;
import defpackage.adz;
import defpackage.ahn;
import defpackage.aho;
import defpackage.ahu;
import defpackage.akb;
import defpackage.akc;
import defpackage.akd;
import defpackage.akf;
import defpackage.aoi;
import defpackage.aoj;
import defpackage.aok;
import defpackage.aot;
import defpackage.aou;
import defpackage.aov;
import defpackage.aow;
import defpackage.aox;
import defpackage.apa;
import defpackage.apb;
import defpackage.apc;
import defpackage.apd;
import defpackage.apf;
import defpackage.apg;
import defpackage.aph;
import defpackage.api;
import defpackage.apj;
import defpackage.apk;
import defpackage.apl;
import defpackage.apm;
import defpackage.apn;
import defpackage.apo;
import defpackage.app;
import defpackage.aps;
import defpackage.apu;
import defpackage.apw;
import defpackage.apy;
import defpackage.apz;
import defpackage.aqa;
import defpackage.aqc;
import defpackage.aqo;
import defpackage.aqy;
import defpackage.arc;
import defpackage.ml;
import defpackage.mm;
import defpackage.mo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProductSetupMasterActivity extends aqc implements aoj.b, api.a {
    public static final int m = HarmanApplication.a().getResources().getInteger(R.integer.fragmentTransition_duration);
    public static final int n = m / 2;
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private TextView D;
    private RippleTextView E;
    private RippleTextView F;
    private RelativeLayout G;
    private RelativeLayout I;
    private aqy J;
    private aoi K;
    private aok P;
    private RoomItem R;
    private adz S;
    private int T;
    private int U;
    private aoj W;
    private boolean Y;
    public long o;
    apw p;
    private ImageView z;
    private int y = -1;
    private int H = -1;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private boolean O = true;
    private Map<aoi, String> Q = new HashMap();
    private boolean V = false;
    private aoi X = null;
    private LinearLayout Z = null;
    private View.OnClickListener aa = new View.OnClickListener() { // from class: com.harman.hkconnect.settings.ProductSetupMasterActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ProductSetupMasterActivity.this.q() || view.getId() == R.id.right_button) {
                mm.c("fix anr mOnClickListener enter", new Object[0]);
                aoj aojVar = (aoj) ProductSetupMasterActivity.this.J.a();
                switch (view.getId()) {
                    case R.id.go_back /* 2131689713 */:
                        ProductSetupMasterActivity.this.onBackPressed();
                        break;
                    case R.id.right_button /* 2131689715 */:
                        ProductSetupMasterActivity.this.O = false;
                        if (aojVar != null) {
                            aojVar.d();
                        }
                        ProductSetupMasterActivity.this.finish();
                        break;
                    case R.id.product_setup_next /* 2131689717 */:
                        if (aojVar != null) {
                            aojVar.e();
                        }
                        break;
                    case R.id.troubleshoot_button /* 2131689718 */:
                        if (aojVar != null) {
                            aojVar.al();
                        }
                        if (ProductSetupMasterActivity.this.N != 1) {
                            if (ProductSetupMasterActivity.this.N == 2) {
                                ProductSetupMasterActivity.d(ProductSetupMasterActivity.this);
                            }
                        } else {
                            ProductSetupMasterActivity.c(ProductSetupMasterActivity.this);
                        }
                        break;
                }
                mm.c("fix anr mOnClickListener exit", new Object[0]);
            }
        }
    };

    static /* synthetic */ int c(ProductSetupMasterActivity productSetupMasterActivity) {
        int i = productSetupMasterActivity.L;
        productSetupMasterActivity.L = i + 1;
        return i;
    }

    static /* synthetic */ int d(ProductSetupMasterActivity productSetupMasterActivity) {
        int i = productSetupMasterActivity.M;
        productSetupMasterActivity.M = i + 1;
        return i;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        l(this.O);
    }

    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        mm.c("fix anr onCreate enter", new Object[0]);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.product_setup_master_activity);
        if (!ahn.a()) {
            setRequestedOrientation(1);
        }
        this.J = new aqy(f(), R.id.setup_container);
        this.p = new apw(this, R.anim.fragment_slide_in_from_right, R.anim.fragment_slide_out_to_left);
        C();
        mm.c("fix anr onCreate exit", new Object[0]);
    }

    private void C() {
        mm.c("fix anr initViews enter", new Object[0]);
        this.y = -1;
        Bundle extras = getIntent().getExtras();
        this.D = (TextView) findViewById(R.id.product_setup_title);
        if (extras.getInt("SETUP_TYPE") == 0) {
            this.K = aoi.CHOOSE_ROOM_TYPE;
            c(getString(R.string.kSetupNewRoom_Navigation_Str));
        } else if (extras.getInt("SETUP_TYPE") == 1) {
            this.K = aoi.ROOM_MANAGEMENT;
            c(getString(R.string.kSetupRoomManagement_Title_Str));
        }
        this.W = a(this.K);
        Bundle bundle = new Bundle();
        bundle.putSerializable(aoj.a.FIRST_PAGE.name(), this.K);
        bundle.putSerializable(aoj.a.PAGE_TYPE.name(), this.K);
        this.W.g(bundle);
        this.Q.put(this.K, this.J.a(this.W, 0, (arc) null));
        this.o = System.currentTimeMillis();
        this.E = (RippleTextView) findViewById(R.id.product_setup_next);
        this.E.setVisibility(4);
        this.G = (RelativeLayout) findViewById(R.id.setup_bottom_control_layout);
        this.G.setVisibility(0);
        this.F = (RippleTextView) findViewById(R.id.troubleshoot_button);
        this.F.setVisibility(4);
        this.F.setOnClickListener(this.aa);
        this.B = (ImageView) findViewById(R.id.right_button);
        this.B.setVisibility(0);
        this.C = (ImageView) findViewById(R.id.go_back);
        this.E.setOnClickListener(this.aa);
        this.C.setOnClickListener(this.aa);
        this.B.setOnClickListener(this.aa);
        this.I = (RelativeLayout) findViewById(R.id.main_layout);
        this.Z = (LinearLayout) findViewById(R.id.top_navigation_bar);
        this.P = new aok(this);
        b(getString(R.string.Next_Str));
        mm.c("fix anr initViews exit", new Object[0]);
    }

    @Override // aoj.b
    public void b(boolean z) {
        mm.c("fix anr fadeTroubleshootText enter", new Object[0]);
        if (z) {
            this.F.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            this.F.startAnimation(alphaAnimation);
        } else {
            this.F.setVisibility(4);
        }
        mm.c("fix anr fadeTroubleshootText exit", new Object[0]);
    }

    private void l(boolean z) {
        String str = "Null";
        mm.c("fix anr setupAndTroubleShootAnalytics enter", new Object[0]);
        if (this.y == 0) {
            str = "Wifi";
        } else if (this.y == 1) {
            str = "WPS";
        }
        String str2 = "Null";
        if (this.N == 1) {
            str2 = "Mono";
        } else if (this.N == 2) {
            str2 = "Stereo2.0";
        } else if (this.N == 3) {
            str2 = "Soundbar 3.1";
        } else if (this.N == 4) {
            str2 = "Soundbar 5.1";
        } else if (this.N == 5) {
            str2 = "Home Theater 5.1";
        } else if (this.N == 6) {
            str2 = "Home Theater 2.1";
        }
        if (z) {
            aqo.f().b(str2, str, Math.round((System.currentTimeMillis() - this.o) / 1000));
        } else {
            aqo.f().a(str2, str, Math.round((System.currentTimeMillis() - this.o) / 1000));
        }
        if (this.L > 0) {
            aqo.f().a("Mono", this.L);
        }
        if (this.M > 0) {
            aqo.f().a("Stereo2.0", this.M);
        }
        mm.c("fix anr setupAndTroubleShootAnalytics exit", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final View view2) {
        if (view != null && view2 != null) {
            mm.c("fix anr flyRoom enter", new Object[0]);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            this.T = iArr2[0] - iArr[0];
            this.U = iArr2[1] - iArr[1];
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.T, 0.0f, this.U);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.settings.ProductSetupMasterActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    view.setVisibility(0);
                    view2.setVisibility(4);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(4);
                    view2.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            translateAnimation.setDuration(m);
            view.startAnimation(translateAnimation);
            mm.c("fix anr flyRoom exit", new Object[0]);
        }
    }

    private void D() {
        mo.a.postDelayed(new Runnable() { // from class: com.harman.hkconnect.settings.ProductSetupMasterActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ProductSetupMasterActivity.this.a(ProductSetupMasterActivity.this.z, ProductSetupMasterActivity.this.A);
            }
        }, 100L);
    }

    @Override // api.a
    public void c(int i) {
        this.N = i;
    }

    @Override // aoj.b
    public void a(aoi aoiVar, Bundle bundle) {
        if (q() && !isFinishing() && aoiVar != this.X) {
            mm.c("fix anr nextPage enter", new Object[0]);
            if (aoiVar == aoi.SETUP_FAIL) {
                this.P.a();
            } else {
                this.P.b();
            }
            this.W = a(aoiVar);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSerializable(aoj.a.PAGE_TYPE.name(), aoiVar);
            bundle.putSerializable(aoj.a.FIRST_PAGE.name(), this.K);
            this.W.g(bundle);
            arc arcVarG = new arc().d(R.anim.fragment_slide_in_from_right).g(R.anim.fragment_slide_out_to_right);
            if (aoiVar == aoi.CHOOSE_ROOM_COLOR) {
                arcVarG.e(R.anim.fragment_fade_out).f(R.anim.fragment_fade_in);
                D();
            } else {
                arcVarG.e(R.anim.fragment_slide_out_to_left).f(R.anim.fragment_slide_in_from_left);
            }
            this.Q.put(aoiVar, this.J.a(this.W, arcVarG));
            this.X = aoiVar;
            mm.c("fix anr nextPage exit", new Object[0]);
        }
    }

    private aoj a(aoi aoiVar) {
        switch (aoiVar) {
            case CHOOSE_ROOM_TYPE:
                return new aou();
            case CHOOSE_ROOM_COLOR:
                return new aot();
            case CHOOSE_CHANNEL_TYPE:
                return new api();
            case CHOOSE_SOUNDBAR_CHANNEL_TYPE:
                return new apj();
            case CHANNEL_SETUP_TUTORIAL:
                return new apa();
            case CONNECTING_TO_SPEAKER:
                return new apc();
            case SETUP_ROOM_RESULT:
                return new apo();
            case SETUP_FAIL:
                return new apl();
            case ONLINE_PROGRESS:
                return new apf();
            case WIFI_SETUP_LIST:
                return new apz();
            case SHOW_ERROR_MESSAGE:
                return new app();
            case RETRY_WIFI_SETUP:
                return new apg();
            case WPS_ETHERNET:
                return new aqa();
            case SETUP_MULTICHANNEL_TUTORIAL:
                return new apn();
            case DRAG_SPEAKERS_FOR_CHANNEL:
                return new apd();
            case NETWORK_CHECK:
                return new apb();
            case ROOM_MANAGEMENT:
                return new akc();
            case ROOM_MANAGEMENT_ITEM:
                return new akb();
            case SETUP_CHANNEL_MASTER:
                return new apk();
            case ROOM_SETTING:
                return new akd();
            case SOURCE_SETUP:
                return new akf();
            case UPDATE_DEVICES:
                return new apy();
            case STEREO_INTRO:
                return new apu();
            case ADAPT_51_Intro:
                return new aov();
            case CHOOSE_ADAPT_CHANNEL_TYPE:
                return new aph();
            case ADAPT_CONNECT_WIFI:
                return new aow();
            case BAR_BAN_2_4G:
                return new aox();
            case ADAPT_BAN_2_4G:
                return new aox();
            case SETUP_MULTICHANNEL_5G_ISSUE:
                return new apm();
            case SOURCE_SETUP_EXPLANATION:
                return new aps();
            default:
                throw new AssertionError("Uknown ProductSetupPageType " + aoiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc
    public void k() {
        this.W.ap();
    }

    @Override // aoj.b
    public void c(boolean z) {
        mm.c("fix anr slideUpNextButton enter" + z, new Object[0]);
        if (z) {
            if (this.E.getVisibility() != 0) {
                this.E.invalidate();
                this.G.animate().translationY(ahn.a(this, -60.0f)).setDuration(200L).setStartDelay(50L);
                this.E.invalidate();
                this.E.setVisibility(0);
            }
        } else if (this.E.getVisibility() == 0) {
            this.G.animate().translationY(0.0f).setDuration(200L).start();
            this.E.setVisibility(4);
        }
        mm.c("fix anr slideUpNextButton exit", new Object[0]);
    }

    @Override // aoj.b
    public void b(String str) {
        this.E.setText(str);
    }

    @Override // aoj.b
    public void c(String str) {
        this.D.setText(str);
    }

    @Override // aoj.b
    public void d(boolean z) {
        this.Z.setVisibility(z ? 0 : 4);
    }

    @Override // aoj.b
    public void l() {
        this.D.setTypeface(ahu.a(this));
    }

    @Override // aoj.b
    public void e(boolean z) {
        this.C.setVisibility(z ? 0 : 4);
    }

    @Override // aoj.b
    public void f(boolean z) {
        this.B.setVisibility(z ? 0 : 4);
    }

    @Override // aoj.b
    public void g(boolean z) {
        this.G.setVisibility(z ? 8 : 0);
    }

    @Override // aoj.b
    public adz m() {
        return this.S;
    }

    @Override // aoj.b
    public void a(adz adzVar) {
        this.S = adzVar;
    }

    @Override // aoj.b
    public void a(RoomItem roomItem) {
        this.R = roomItem;
    }

    @Override // aoj.b
    public RoomItem n() {
        return this.R;
    }

    @Override // aoj.b
    public int o() {
        return this.y;
    }

    @Override // aoj.b
    public void d(int i) {
        this.y = i;
    }

    @Override // aoj.b
    public int p() {
        return this.H;
    }

    @Override // aoj.b
    public void e(int i) {
        this.H = i;
    }

    @Override // aoj.b
    public void a(aoi aoiVar, aoi aoiVar2, boolean z) {
        mm.c("fix anr goBackPrevious enter", new Object[0]);
        String str = this.Q.get(aoiVar2);
        if (str == null) {
            new ml().a("No fragment on stack " + aoiVar2);
        }
        this.p.a(aoiVar, aoiVar2, z);
        f().b(str, 0);
        this.X = null;
        mm.c("fix anr goBackPrevious exit", new Object[0]);
    }

    @Override // aoj.b
    public void d(String str) {
        this.F.setText(str);
    }

    @Override // aoj.b
    public void f(int i) {
        this.F.setVisibility(i);
    }

    @Override // aoj.b
    public void a(ImageView imageView, RelativeLayout.LayoutParams layoutParams) {
        this.z = imageView;
        this.z.setVisibility(4);
        this.I.addView(this.z, layoutParams);
        this.z.setBackgroundColor(16711680);
    }

    @Override // aoj.b
    public void a(ImageView imageView) {
        this.A = imageView;
    }

    @Override // aoj.b
    public void g(int i) {
        this.D.setGravity(17);
    }

    @Override // aoj.b
    public void a(Animation animation, aoi aoiVar, boolean z) {
        this.p.a(animation, aoiVar, z);
    }

    @Override // aoj.b
    public void b(Animation animation, aoi aoiVar, boolean z) {
        this.p.b(animation, aoiVar, z);
    }

    @Override // aoj.b
    public Animation a(aoi aoiVar, boolean z) {
        return this.p.a(aoiVar, z);
    }

    @Override // aoj.b
    public boolean q() {
        return !this.p.a();
    }

    @Override // aoj.b
    public boolean r() {
        return this.V;
    }

    @Override // aoj.b
    public void h(boolean z) {
        this.V = z;
    }

    @Override // aoj.b
    public void i(boolean z) {
        this.Y = z;
    }

    @Override // aoj.b
    public boolean s() {
        return this.Y;
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        this.X = null;
        if (this.C.getVisibility() == 0) {
            if (f().e() <= 1) {
                finish();
            } else if (!this.J.a(this)) {
                super.onBackPressed();
            }
        }
    }

    @Override // defpackage.gk, defpackage.ba, android.app.Activity
    public void onDestroy() {
        this.P.b();
        super.onDestroy();
    }

    @Override // defpackage.gk, defpackage.ba, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!aho.d("LANGUAGE").equals(configuration.locale.getLanguage())) {
            E();
        }
    }

    private void E() {
        Intent intent = new Intent(this, (Class<?>) SettingsActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    @Override // defpackage.ba, android.app.Activity, at.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.W != null) {
            this.W.a(i, strArr, iArr);
        }
    }
}
