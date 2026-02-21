package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.adx;
import defpackage.ahu;
import defpackage.apd;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class CustomDragSpeakerContianer extends FrameLayout {
    private Context a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private adx e;
    private RelativeLayout f;
    private a g;
    private byte h;
    private apd.b i;
    private View j;

    public enum a {
        SELECT_NOTHING,
        SELECT_BING_SPEAKER,
        SELECT_SPEAKER,
        SELECT_HIGHLIGHT,
        SELECT_HIGHLIGHT_AFTER_ANIMATION
    }

    public void setRoleType(apd.b bVar) {
        this.i = bVar;
    }

    public void setChannelType(byte b) {
        this.h = b;
    }

    public adx getRuleSpeaker() {
        return this.e;
    }

    public CustomDragSpeakerContianer(Context context) {
        super(context);
        this.g = a.SELECT_NOTHING;
        this.h = (byte) 0;
        this.a = context;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = LayoutInflater.from(context).inflate(R.layout.custom_dragspeaker_contianer_view, (ViewGroup) null);
        this.f = (RelativeLayout) this.j.findViewById(R.id.speaker_one_animation_layout);
        this.b = (ImageView) this.j.findViewById(R.id.speaker_one_drag_image_position);
        this.c = (TextView) this.j.findViewById(R.id.speaker_text);
        this.d = (ImageView) this.j.findViewById(R.id.channel_signal);
        addView(this.j);
    }

    public CustomDragSpeakerContianer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = a.SELECT_NOTHING;
        this.h = (byte) 0;
        this.a = context;
        a(context, attributeSet);
    }

    public void a() {
        if (this.g == a.SELECT_SPEAKER && this.e != null) {
            this.b.setVisibility(0);
            setBackgroundResource(R.drawable.speaker_circle_drag_bg);
            this.b.setImageResource(this.e.A());
            this.d.setImageResource(getActiveChannelSignal());
            d();
            return;
        }
        if (this.g == a.SELECT_BING_SPEAKER) {
            this.b.setVisibility(8);
            setBackgroundResource(R.drawable.speaker_circle_drag_bg);
            return;
        }
        if (this.g == a.SELECT_HIGHLIGHT) {
            this.b.setVisibility(4);
            if (this.e != null) {
                this.b.setImageResource(this.e.A());
            } else {
                this.b.setImageBitmap(null);
            }
            setBackgroundResource(R.drawable.speaker_dropped_circle_bin);
            this.d.setImageResource(getActiveChannelSignal());
            d();
            return;
        }
        if (this.g == a.SELECT_HIGHLIGHT_AFTER_ANIMATION) {
            this.b.setVisibility(0);
            clearAnimation();
            return;
        }
        c();
        setBackgroundResource(R.drawable.speaker_circle_drag_bg);
        this.b.setImageBitmap(null);
        this.b.setVisibility(8);
        this.d.setImageResource(getNotActiveChannelSignal());
    }

    private int getRoleChannelTextFor51() {
        if (this.i == apd.b.KEY_RIGHT) {
            return R.string.Select_Channel_Role_Text_R_Str;
        }
        if (this.i == apd.b.KEY_AROUND_CENTER) {
            return R.string.Select_Channel_Role_Text_C_Str;
        }
        if (this.i == apd.b.KEY_AROUND_LEFT) {
            return R.string.Select_Channel_Role_Text_Rear_L_Str;
        }
        if (this.i == apd.b.KEY_AROUND_RIGHT) {
            return R.string.Select_Channel_Role_Text_Rear_R_Str;
        }
        return R.string.Select_Channel_Role_Text_L_Str;
    }

    private int getActiveChannelSignal() {
        if (this.i == apd.b.KEY_LEFT) {
            if (this.h == 4) {
                return R.drawable.ls_icon;
            }
            return R.drawable.l_chanel_icon_active;
        }
        if (this.h == 4) {
            return R.drawable.rs_icon;
        }
        return R.drawable.r_sing_chanel_icon_active;
    }

    private int getNotActiveChannelSignal() {
        if (this.i == apd.b.KEY_LEFT) {
            if (this.h == 4) {
                return R.drawable.ls_icon_selected;
            }
            return R.drawable.l_chanel_icon_not_active;
        }
        if (this.h == 4) {
            return R.drawable.rs_icon_selected;
        }
        return R.drawable.r_sing_chanel_icon_not_active;
    }

    private void c() {
        this.c.setVisibility(0);
        if (this.h != 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(600);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(600);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            this.c.startAnimation(animationSet);
        }
    }

    private void d() {
        this.c.clearAnimation();
        this.c.setVisibility(4);
    }

    public void b() {
        if (this.h == 0 || this.h == 2) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (this.h == 2) {
            this.c.setText(getRoleChannelTextFor51());
        }
        if (this.h == 2) {
            this.c.setTypeface(ahu.b(this.a));
            if (this.i == apd.b.KEY_LEFT || this.i == apd.b.KEY_RIGHT || this.i == apd.b.KEY_AROUND_CENTER) {
                this.c.setTextAppearance(this.a, R.style.font_white_22_alpha50);
            } else {
                this.c.setTextAppearance(this.a, R.style.font_white_10_alpha50);
            }
        }
    }

    public void a(a aVar, adx adxVar) {
        if (adxVar != null) {
            this.e = adxVar;
            this.e.R().setRole(getRoleCommand());
        } else if (this.e != null) {
            this.e.R().setRole(21);
            this.e = adxVar;
        }
        this.g = aVar;
        a();
        mm.b("TEST_DRAG role type = %s , old drag status  = %s ,new drag status = %s , device = %s, devie role = %s", this.i.name(), this.g.name(), aVar.name());
    }

    public void setDragStatus(a aVar) {
        mm.b("TEST_DRAG role type = %s , old drag status  = %s ,new drag status = %s", this.i.name(), this.g.name(), aVar.name());
        this.g = aVar;
        a();
    }

    public ImageView getSpeaker_drag_image() {
        return this.b;
    }

    public RelativeLayout getSpeakerAnimationLayout() {
        return this.f;
    }

    public int getRoleCommand() {
        switch (this.i) {
            case KEY_LEFT:
                return 1;
            case KEY_RIGHT:
                return 2;
            case KEY_AROUND_CENTER:
                return 3;
            case KEY_AROUND_LEFT:
                return 5;
            case KEY_AROUND_RIGHT:
                return 6;
            default:
                return 21;
        }
    }
}
