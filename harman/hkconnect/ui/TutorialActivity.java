package com.harman.hkconnect.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import defpackage.ahn;
import defpackage.aqo;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class TutorialActivity extends Activity {
    private a b;
    private RelativeLayout c;
    private ImageView d;
    private int e;
    private int f;
    boolean a = false;
    private View.OnClickListener g = new View.OnClickListener() { // from class: com.harman.hkconnect.ui.TutorialActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TutorialActivity.this.b.ordinal() == a.values().length - 1) {
                TutorialActivity.this.finish();
                return;
            }
            a aVar = null;
            if (TutorialActivity.this.a) {
                if (TutorialActivity.this.b != a.FULL_CONTROL_BOTTOM_PLAYER && TutorialActivity.this.b != a.LINK_ROOMS_BUTTON && TutorialActivity.this.b != a.PARTY_MODE) {
                    aVar = a.values()[TutorialActivity.this.b.ordinal() + 1];
                }
            } else {
                aVar = a.values()[TutorialActivity.this.b.ordinal() + 1];
            }
            if (aVar != null) {
                Intent intent = new Intent(TutorialActivity.this, (Class<?>) TutorialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("PAGE_TYPE", aVar);
                bundle.putBoolean("FIRST_TIME", TutorialActivity.this.a);
                intent.putExtras(bundle);
                TutorialActivity.this.startActivity(intent);
                TutorialActivity.this.finish();
                return;
            }
            TutorialActivity.this.finish();
        }
    };

    public enum a {
        WHERE_TO_PLAY,
        MUSIC_SERVICES,
        BROWSE_MUSIC,
        PRESS_AND_HOLD,
        FULL_CONTROL_BOTTOM_PLAYER,
        SWITCH_ROOMS,
        LINK_ROOMS_BUTTON,
        LINK_ROOMS,
        PARTY_MODE
    }

    private void a(final boolean z) {
        View viewInflate;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        if (this.b == a.FULL_CONTROL_BOTTOM_PLAYER) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_full_control_bottom_player, (ViewGroup) null);
        } else if (this.b == a.MUSIC_SERVICES) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_music_services, (ViewGroup) null);
        } else if (this.b == a.PRESS_AND_HOLD) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_press_and_hold, (ViewGroup) null);
        } else if (this.b == a.SWITCH_ROOMS) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_switch_rooms, (ViewGroup) null);
        } else if (this.b == a.LINK_ROOMS_BUTTON) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_link_rooms_button, (ViewGroup) null);
        } else if (this.b == a.LINK_ROOMS) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_link_rooms, (ViewGroup) null);
        } else if (this.b == a.PARTY_MODE) {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_party_mode, (ViewGroup) null);
        } else {
            viewInflate = layoutInflaterFrom.inflate(R.layout.tutorial_browse_music, (ViewGroup) null);
        }
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.tutorial_background_image);
        final LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.tutorial_popup_layout);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.harman.hkconnect.ui.TutorialActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i;
                int i2;
                if (!z || TutorialActivity.this.e != imageView.getMeasuredWidth() || TutorialActivity.this.f != imageView.getMeasuredHeight()) {
                    imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = imageView.getMeasuredHeight();
                    int measuredWidth = imageView.getMeasuredWidth();
                    int intrinsicHeight = imageView.getDrawable().getIntrinsicHeight();
                    int intrinsicWidth = imageView.getDrawable().getIntrinsicWidth();
                    if (measuredHeight * intrinsicWidth <= measuredWidth * intrinsicHeight) {
                        i2 = (intrinsicWidth * measuredHeight) / intrinsicHeight;
                        i = measuredHeight;
                    } else {
                        i = (intrinsicHeight * measuredWidth) / intrinsicWidth;
                        i2 = measuredWidth;
                    }
                    mm.b("CLLOG GETTING HEIGHT w:" + i2 + " h:" + i + " iw:" + measuredWidth + " ih:" + measuredHeight, new Object[0]);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i);
                    layoutParams.addRule(13);
                    linearLayout.setLayoutParams(layoutParams);
                    TutorialActivity.this.e = measuredWidth;
                    TutorialActivity.this.f = measuredHeight;
                }
            }
        });
        this.c.addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        this.c.setOnClickListener(this.g);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ahn.a()) {
            setRequestedOrientation(1);
        }
        Bundle extras = getIntent().getExtras();
        a aVar = (a) extras.getSerializable("PAGE_TYPE");
        if (aVar == null) {
            aVar = a.MUSIC_SERVICES;
        }
        this.a = extras.getBoolean("FIRST_TIME", false);
        if (!this.a && aVar == a.MUSIC_SERVICES) {
            aqo.f().b();
        }
        this.b = aVar;
        setContentView(R.layout.tutorial_activity_layout);
        this.c = (RelativeLayout) findViewById(R.id.tutorial_content);
        this.d = (ImageView) findViewById(R.id.tutorial_close_icon);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.ui.TutorialActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TutorialActivity.this.finish();
            }
        });
        if (this.a) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        this.e = -1;
        this.f = -1;
        a(false);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.c.removeAllViews();
        a(true);
    }
}
