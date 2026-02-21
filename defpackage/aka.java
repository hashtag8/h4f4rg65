package defpackage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aka extends Fragment {
    ImageView a;
    private int[] ae = {R.string.kWelcomeScreenTitle1_Str, R.string.kWelcomeScreenTitle2_Str, R.string.kWelcomeScreenTitle3_Str, R.string.kWelcomeScreenTitle4_Str, R.string.DarshboardTutorialPage5_Text_Str};
    private int[] af = {R.string.kWelcomeScreenDescription1_Str, R.string.kWelcomeScreenDescription2_Str, R.string.kWelcomeScreenDescription3_Str, R.string.kWelcomeScreenDescription4_Str, R.string.DarshboardTutorialPage5_Detail_Str};
    private int[] ag = {R.string.DarshboardTutorialPage6_Text_Str, R.string.DarshboardTutorialPage7_Text_Str, R.string.DarshboardTutorialPage8_Text_Str};
    private int[] ah = {R.drawable.welcome_1, R.drawable.welcome_2, R.drawable.welcome_3, R.drawable.welcome_4};
    private int[] ai = {R.drawable.welcome_1_tablet_port, R.drawable.welcome_2_tablet_port, R.drawable.welcome_3_tablet_port, R.drawable.welcome_4_tablet_port};
    private int[] aj = {R.drawable.welcome_tablet_landscape_1, R.drawable.welcome_tablet_landscape_2, R.drawable.welcome_tablet_landscape_3, R.drawable.welcome_tablet_landscape_4};
    private int[] ak = {R.drawable.tutorial_choose_channel_6, R.drawable.tutorial_check_signal_7, R.drawable.tutorial_choose_master_8};
    private int[] al = {R.drawable.tutorial_check_signal_portrait_pad_6, R.drawable.tutorial_check_signal_portrait_pad_7, R.drawable.tutorial_check_signal_portrait_pad_8};
    private int[] am = {R.drawable.tutorial_check_signal_landscape_pad_6, R.drawable.tutorial_check_signal_landscape_pad_7, R.drawable.tutorial_check_signal_landscape_pad_8};
    private boolean an = false;
    private int ao;
    private int b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private LinearLayout g;
    private LinearLayout h;
    private ImageView i;

    public static aka c(int i, boolean z, int i2) {
        aka akaVar = new aka();
        Bundle bundle = new Bundle();
        bundle.putInt("rid", i);
        bundle.putInt("pagecount", i2);
        bundle.putBoolean("judge", z);
        akaVar.g(bundle);
        return akaVar;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.b = l().getInt("rid");
        this.ao = l().getInt("pagecount");
        this.an = l().getBoolean("judge");
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.viewpage_item, (ViewGroup) null);
        this.a = (ImageView) viewInflate.findViewById(R.id.imageview);
        this.i = (ImageView) viewInflate.findViewById(R.id.harman_logo);
        this.h = (LinearLayout) viewInflate.findViewById(R.id.tutorial_title_layout);
        this.g = (LinearLayout) viewInflate.findViewById(R.id.tutorial_bottom_layout);
        this.c = (TextView) viewInflate.findViewById(R.id.tutorial_title);
        this.f = (TextView) viewInflate.findViewById(R.id.tutorial_start_button);
        this.d = (TextView) viewInflate.findViewById(R.id.tutorial_description);
        this.e = (TextView) viewInflate.findViewById(R.id.tutorial_bottom_description);
        if (this.an) {
            this.h.setVisibility(8);
            this.g.setVisibility(0);
            if (this.ao == 1) {
                this.e.setText(this.ag[2]);
            } else {
                this.e.setText(this.ag[this.b]);
            }
        } else {
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            if (this.b == 0) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            if (this.b == this.ao - 1) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.f.setOnClickListener(new ahl(this) { // from class: aka.1
                @Override // defpackage.ahl
                public void a(View view) {
                    aim.e();
                    aka.this.p().finish();
                }
            });
            this.c.setText(this.ae[this.b]);
            this.d.setText(this.af[this.b]);
        }
        b();
        return viewInflate;
    }

    private void b() {
        try {
            if (this.an) {
                if (this.ao == 1) {
                    if (ahn.a()) {
                        if (q().getConfiguration().orientation == 2) {
                            this.a.setImageResource(this.am[2]);
                        } else if (q().getConfiguration().orientation == 1) {
                            this.a.setImageResource(this.al[2]);
                        }
                    } else {
                        this.a.setImageResource(this.ak[2]);
                    }
                } else if (ahn.a()) {
                    if (q().getConfiguration().orientation == 2) {
                        this.a.setImageResource(this.am[this.b]);
                    } else if (q().getConfiguration().orientation == 1) {
                        this.a.setImageResource(this.al[this.b]);
                    }
                } else {
                    this.a.setImageResource(this.ak[this.b]);
                }
            } else if (ahn.a()) {
                if (q().getConfiguration().orientation == 2) {
                    this.a.setImageResource(this.aj[this.b]);
                } else if (q().getConfiguration().orientation == 1) {
                    this.a.setImageResource(this.ai[this.b]);
                }
            } else {
                this.a.setImageResource(this.ah[this.b]);
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
        c();
    }

    private void c() {
        int[] iArr = {android.R.attr.layout_gravity};
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = p().obtainStyledAttributes(R.style.tutorial_title_msg_text_StartButton, iArr);
        layoutParams.gravity = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        ((ViewGroup.MarginLayoutParams) this.i.getLayoutParams()).bottomMargin = q().getDimensionPixelSize(R.dimen.viewpageItem_harmanLogo_marginBottom);
        this.c.setText(this.ae[this.b]);
    }
}
