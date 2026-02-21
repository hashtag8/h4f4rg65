package defpackage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.DashboardActivity;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class apo extends aoj {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private View f;
    private LinearLayout g;
    private View h;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater.inflate(R.layout.fragment_setup_room_result, (ViewGroup) null);
        this.d = (TextView) this.h.findViewById(R.id.room_name);
        this.a = (TextView) this.h.findViewById(R.id.play_music_now);
        this.b = (TextView) this.h.findViewById(R.id.setup_new_room);
        this.e = (ImageView) this.h.findViewById(R.id.success_room_icon);
        this.c = (TextView) this.h.findViewById(R.id.setup_success_text);
        this.f = this.h.findViewById(R.id.ripple_effect_view);
        this.g = (LinearLayout) this.h.findViewById(R.id.complete_setup_options_layout);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: apo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                apo.this.n(false);
            }
        });
        if (aoz.a(aof.a().f()).size() > 0) {
            this.a.setVisibility(8);
            this.b.setText(q().getString(R.string.kSettings_SetupNewRoom));
        } else {
            this.b.setText(q().getString(R.string.kSettings_SetupNewRoom));
        }
        this.b.setOnClickListener(new View.OnClickListener() { // from class: apo.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                apo.this.at();
            }
        });
        b(false);
        c(false);
        l(true);
        an().c("");
        return this.h;
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        RoomItem roomItemN = an().n();
        if (roomItemN != null) {
            adz adzVarA = aof.a().a(roomItemN.f());
            if (adzVarA != null) {
                aof.a().a(adzVarA);
            }
            int i = ain.y[roomItemN.j()];
            int iRgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
            this.e.setImageResource(roomItemN.k());
            this.d.setText(roomItemN.h());
            this.d.setTextColor(iRgb);
            this.e.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
        }
    }

    @Override // defpackage.aoj
    public void aq() {
        am();
    }

    public void am() {
        agt.a(this.f, R.drawable.circle_shape, HttpStatus.SC_BAD_REQUEST, ain.y[an().n().j()], 1.2f);
        this.e.setVisibility(0);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        this.g.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        scaleAnimation2.setInterpolator(new OvershootInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600L);
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.0f, ahn.a(p(), 20.0f), 0.0f);
        translateAnimation.setStartOffset(200L);
        translateAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setStartOffset(200L);
        alphaAnimation2.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.setInterpolator(new DecelerateInterpolator());
        this.g.startAnimation(animationSet);
        this.e.startAnimation(scaleAnimation);
        this.c.startAnimation(scaleAnimation2);
        this.d.startAnimation(alphaAnimation);
    }

    public void n(boolean z) {
        if (p() != null && !p().isFinishing()) {
            Intent intent = new Intent(p(), (Class<?>) DashboardActivity.class);
            intent.putExtra("menustate", true);
            intent.addFlags(67108864);
            if (z) {
                intent.putExtra("GO_TO_MIXRADIO", true);
            } else {
                intent.putExtra("GO_TO_MIXRADIO", false);
            }
            intent.putExtra("SETUP_SUCCESS", true);
            a(intent);
            p().finish();
        }
    }

    public void at() {
        p().finish();
        Intent intent = new Intent(p(), (Class<?>) ProductSetupMasterActivity.class);
        intent.putExtra("SETUP_TYPE", 0);
        a(intent);
        p().finish();
    }
}
