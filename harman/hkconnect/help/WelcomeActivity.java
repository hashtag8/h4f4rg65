package com.harman.hkconnect.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import com.viewpagerindicator.CirclePageIndicator;
import defpackage.ahn;
import defpackage.ain;
import defpackage.aka;
import defpackage.ba;
import defpackage.be;
import defpackage.bh;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WelcomeActivity extends ba {
    private ViewPager m;
    private ArrayList<Fragment> n;
    private CirclePageIndicator o;
    private Button p;
    private RelativeLayout r;
    private boolean q = false;
    private String s = "EULA_FRAGMENT_TAG";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ahn.a()) {
            setRequestedOrientation(1);
        }
        h();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.q = true;
            if (extras.getInt("type") == 3) {
                c(3);
            } else if (extras.getInt("type") == 1) {
                c(1);
            } else if (extras.getInt("type") == 2) {
                c(2);
            }
        } else {
            this.q = false;
            c(4);
        }
        this.m.setAdapter(new a(f()));
        this.m.a(new ViewPager.f() { // from class: com.harman.hkconnect.help.WelcomeActivity.1
            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
                if (i == WelcomeActivity.this.m.getAdapter().b() - 2) {
                    WelcomeActivity.this.o.setAlpha(1.0f - f);
                } else if (i == WelcomeActivity.this.m.getAdapter().b() - 1) {
                    WelcomeActivity.this.o.setAlpha(0.0f);
                } else {
                    WelcomeActivity.this.o.setAlpha(1.0f);
                }
            }

            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                if (i == WelcomeActivity.this.m.getAdapter().b() - 1) {
                    WelcomeActivity.this.o.setAlpha(0.0f);
                } else {
                    WelcomeActivity.this.o.setAlpha(1.0f);
                }
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
            }
        });
        this.o.setViewPager(this.m);
    }

    private void c(int i) {
        this.n = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            this.n.add(aka.c(i2, this.q, i));
        }
    }

    public void g() {
        this.r.setVisibility(8);
    }

    private void h() {
        setContentView(R.layout.viewpage_layout);
        this.m = (ViewPager) findViewById(R.id.viewpager);
        this.r = (RelativeLayout) findViewById(R.id.eula_layout_container);
        this.r.setVisibility(8);
        this.o = (CirclePageIndicator) findViewById(R.id.layout);
        this.p = (Button) findViewById(R.id.video_button);
        this.p.setVisibility(8);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.help.WelcomeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(ain.z));
                WelcomeActivity.this.startActivity(intent);
            }
        });
    }

    public class a extends bh {
        public a(be beVar) {
            super(beVar);
        }

        @Override // defpackage.bh
        public Fragment a(int i) {
            return (Fragment) WelcomeActivity.this.n.get(i);
        }

        @Override // defpackage.ex
        public int b() {
            return WelcomeActivity.this.n.size();
        }

        @Override // defpackage.ex
        public CharSequence c(int i) {
            return "";
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        if (this.r.getVisibility() == 0) {
            g();
        } else {
            finishAffinity();
        }
    }
}
