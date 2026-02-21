package com.harman.hkconnect.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.viewpagerindicator.CirclePageIndicator;
import defpackage.adw;
import defpackage.ady;
import defpackage.agw;
import defpackage.agx;
import defpackage.ahn;
import defpackage.aho;
import defpackage.aoa;
import defpackage.aof;
import defpackage.aqd;
import defpackage.aqe;
import defpackage.brs;
import defpackage.ek;
import defpackage.mm;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BottomPlayer extends LinearLayout {
    public boolean a;
    ek b;
    private DashboardActivity c;
    private View d;
    private MusicPlaylistManager e;
    private ViewPager f;
    private aqd g;
    private RelativeLayout h;
    private RelativeLayout i;
    private aoa j;
    private ImageView k;
    private ImageView l;
    private Handler m;
    private CirclePageIndicator n;
    private boolean o;

    public BottomPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.o = false;
        this.c = (DashboardActivity) context;
        h();
    }

    public BottomPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.o = false;
        this.c = (DashboardActivity) context;
        h();
    }

    public BottomPlayer(Context context) {
        super(context);
        this.a = false;
        this.o = false;
        this.c = (DashboardActivity) context;
        h();
    }

    public boolean a() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (iArr[1] < ahn.a((Activity) this.c)) {
            return this.o;
        }
        this.o = false;
        return false;
    }

    public void setBottomPlayerShown(boolean z) {
        if (z) {
            c();
        }
        this.o = z;
    }

    public aqd getPagerAdapter() {
        return this.g;
    }

    public ViewPager getViewPager() {
        return this.f;
    }

    private void h() {
        this.b = new ek(this.c, new b());
        this.e = MusicPlaylistManager.a();
        this.g = new aqd(this.c.getFragmentManager());
        this.d = LayoutInflater.from(this.c).inflate(R.layout.bottom_player, this);
        this.f = (ViewPager) this.d.findViewById(R.id.bottomPlayer_viewPager);
        this.f.setVisibility(0);
        this.i = (RelativeLayout) this.d.findViewById(R.id.music_queue_container);
        this.i.setVisibility(8);
        this.i.setOnTouchListener(new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.BottomPlayer.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.h = (RelativeLayout) this.d.findViewById(R.id.expanded_player);
        this.f.setAdapter(this.g);
        this.f.setOffscreenPageLimit(12);
        this.n = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);
        this.n.setViewPager(this.f);
        this.k = (ImageView) this.d.findViewById(R.id.widget_drawer_top_alpha);
        this.l = (ImageView) this.d.findViewById(R.id.widget_drawer_top_alpha_behind);
        this.k.setImageAlpha(0);
        this.l.setImageAlpha(0);
        agx.a().a(new agw() { // from class: com.harman.hkconnect.ui.BottomPlayer.2
            @Override // defpackage.agw
            public void a(Bitmap bitmap) {
                BottomPlayer.this.k.setImageBitmap(bitmap);
            }
        });
        this.m = new Handler();
        this.f.a(new ViewPager.f() { // from class: com.harman.hkconnect.ui.BottomPlayer.3
            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
                mm.b("Test_GoogleCast_private position = %s ", Integer.valueOf(i));
            }

            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                long jNanoTime = System.nanoTime();
                ady adyVarE = BottomPlayer.this.g.e(i);
                aof.a().a(adyVarE);
                adw.a().b();
                mm.b("Yatta time taken for setting highlight group " + (System.nanoTime() - jNanoTime), new Object[0]);
                BottomPlayer.this.m.removeCallbacksAndMessages(null);
                BottomPlayer.this.m.postDelayed(BottomPlayer.this.new a(BottomPlayer.this.c), 200L);
                aqe aqeVarB = BottomPlayer.this.g.b(i);
                if (aqeVarB != null) {
                    aqeVarB.K();
                    mm.b("Yatta time taken for transition image group " + (System.currentTimeMillis() - jNanoTime), new Object[0]);
                    aqeVarB.w();
                    if (MusicPlaylistManager.a().v() && !brs.a(adyVarE, aof.a().o())) {
                        BottomPlayer.this.c.ad();
                    } else {
                        aqeVarB.j();
                        BottomPlayer.this.c.ac();
                    }
                    if (aqeVarB.B()) {
                        aqeVarB.M();
                    }
                }
                mm.b("Yatta time taken for setting volume bar group " + (System.currentTimeMillis() - jNanoTime), new Object[0]);
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
                mm.b("Test_GoogleCast_private state = %s ", Integer.valueOf(i));
            }
        });
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.BottomPlayer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BottomPlayer.this.b.a(motionEvent);
                return false;
            }
        });
    }

    public void b() {
        if (ahn.a()) {
            ahn.a aVarA = ahn.a((Context) this.c);
            boolean z = aVarA.a > aVarA.b;
            Iterator<aqe> it = this.g.d().iterator();
            while (it.hasNext()) {
                it.next().a(z);
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (BottomPlayer.this.o) {
                BottomPlayer.this.c.E();
                return false;
            }
            return false;
        }
    }

    public void c() {
        this.g.a(this.f, aof.a().e());
        j();
        i();
        e();
        if (aof.a().e().size() < 2) {
            this.n.setVisibility(4);
        } else {
            this.n.setVisibility(0);
        }
    }

    private void i() {
        Iterator<aqe> it = this.g.d().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
        a(this.c.v);
    }

    private void j() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            int iA = this.g.a(adyVarB);
            if (iA != -1 && iA != this.f.getCurrentItem()) {
                this.f.a(iA, true);
            }
            this.c.ac();
        }
    }

    public void d() {
        int currentItem = this.f.getCurrentItem();
        if (currentItem < this.g.b()) {
            aqe aqeVarB = this.g.b(currentItem);
            if (aqeVarB == null || aqeVarB.getView() == null) {
                mm.b("No view for index %s, %s", Integer.valueOf(currentItem), aqeVarB);
            } else {
                aqeVarB.a(MusicPlaylistManager.a().s());
            }
        }
    }

    public void a(boolean z) {
        int currentItem = this.f.getCurrentItem();
        if (currentItem < this.g.b()) {
            aof.a().a(this.g.e(currentItem));
            aqe aqeVarB = this.g.b(currentItem);
            if (aqeVarB == null || aqeVarB.getView() == null) {
                mm.b("No view for index %s, %s", Integer.valueOf(currentItem), aqeVarB);
                return;
            }
            if (z) {
                for (aqe aqeVar : this.g.d()) {
                    aqeVar.n();
                    aqeVar.getView().findViewById(R.id.album_fade_foreground).setBackgroundColor(DashboardActivity.m);
                    aqeVar.w();
                }
                aqeVarB.w();
                this.l.setImageAlpha(255);
                return;
            }
            for (aqe aqeVar2 : this.g.d()) {
                aqeVar2.o();
                aqeVar2.p();
                aqeVar2.getView().findViewById(R.id.album_fade_foreground).setBackgroundColor(DashboardActivity.n);
                aqeVar2.w();
            }
        }
    }

    public void a(float f, int i) {
        aqe aqeVarB = this.g.b(this.f.getCurrentItem());
        if (aqeVarB == null) {
            mm.b("No pager item created for %s", Integer.valueOf(this.f.getCurrentItem()));
            return;
        }
        aqeVarB.a(f);
        float f2 = 2.5f * f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.k.setImageAlpha((int) (f3 * 255.0f));
        this.l.setImageAlpha((int) (f3 * 255.0f));
        aqeVarB.a().setBackgroundColor(i);
    }

    public void e() {
        int iC;
        boolean z;
        mm.b("HAS SONGS " + this.e.w(), new Object[0]);
        ady adyVarB = aof.a().b();
        if (aof.a().o() != null) {
            iC = aof.a().o().d();
        } else {
            iC = aho.c("streamingGroupId");
        }
        if (adyVarB != null) {
            z = this.g.a(adyVarB) == this.f.getCurrentItem();
        } else {
            z = false;
        }
        MusicData musicDataS = this.e.s();
        for (aqe aqeVar : this.g.d()) {
            if (musicDataS != null && iC == aqeVar.b().d() && aqeVar.H()) {
                aqeVar.a(musicDataS, z);
                aqeVar.e.setVisibility(8);
            } else {
                aqeVar.r();
            }
            if (this.e.w() && aqeVar.H()) {
                aqeVar.d();
            } else if (aqeVar.B()) {
                aqeVar.d();
                aqeVar.v();
            } else if (aqeVar.C() || aqeVar.E() || aqeVar.D() || aqeVar.F() || aqeVar.G()) {
                if (this.e.w()) {
                    aqeVar.e.setVisibility(8);
                    aqeVar.f();
                } else {
                    aqeVar.e();
                    aqeVar.c();
                    aqeVar.e.setVisibility(0);
                }
            } else {
                aqeVar.c();
                aqeVar.e.setVisibility(0);
            }
        }
        if (!z) {
            agx.a().a(new agw() { // from class: com.harman.hkconnect.ui.BottomPlayer.5
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    agx.a().a(BottomPlayer.this.k, BottomPlayer.this.l, bitmap);
                }
            });
        }
    }

    public ImageView getAlbumArtAlpha() {
        return this.k;
    }

    public ImageView getAlbumArtAlphaBehind() {
        return this.l;
    }

    public void f() {
        if (this.j != null && this.j.isAdded()) {
            this.j.e();
        }
    }

    public void a(FragmentManager fragmentManager, int i) {
        if (this.i.getVisibility() != 0) {
            this.j = (aoa) fragmentManager.findFragmentByTag("MUSIC_QUEUE");
            if (this.j == null || !this.j.isVisible() || !this.j.isInLayout()) {
                if (ahn.a()) {
                }
                this.j = (aoa) fragmentManager.findFragmentByTag("MUSIC_QUEUE");
                FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                if (this.j == null) {
                    this.j = new aoa();
                    fragmentTransactionBeginTransaction.add(R.id.music_queue_container, this.j, "MUSIC_QUEUE");
                } else {
                    this.j.b();
                    fragmentTransactionBeginTransaction.show(this.j);
                    this.j.d();
                }
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                this.h.setVisibility(0);
                this.i.setVisibility(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.0f, i, 0.0f);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.ui.BottomPlayer.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        BottomPlayer.this.h.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                alphaAnimation.setFillAfter(true);
                translateAnimation.setDuration(400L);
                alphaAnimation.setDuration(200L);
                this.i.startAnimation(translateAnimation);
                this.h.startAnimation(alphaAnimation);
                this.c.P();
                this.a = true;
            }
        }
    }

    public void b(final FragmentManager fragmentManager, int i) {
        if (this.h.getVisibility() != 0) {
            this.i.setVisibility(0);
            this.h.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.0f, 0.0f, i);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.ui.BottomPlayer.7
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (fragmentManager != null) {
                        if (BottomPlayer.this.j != null) {
                            if (ahn.a()) {
                                BottomPlayer.this.j.c();
                                BottomPlayer.this.j.dismiss();
                                FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                                fragmentTransactionBeginTransaction.remove(BottomPlayer.this.j);
                                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                                BottomPlayer.this.j = null;
                            } else {
                                FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager.beginTransaction();
                                BottomPlayer.this.j.c();
                                fragmentTransactionBeginTransaction2.hide(BottomPlayer.this.j);
                                fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
                            }
                        }
                        BottomPlayer.this.i.setVisibility(8);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.harman.hkconnect.ui.BottomPlayer.8
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    BottomPlayer.this.h.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setStartOffset(200L);
            alphaAnimation.setDuration(200L);
            translateAnimation.setDuration(400L);
            this.i.startAnimation(translateAnimation);
            this.h.startAnimation(alphaAnimation);
            this.c.Q();
            this.a = false;
            aqe aqeVarB = this.g.b(this.f.getCurrentItem());
            if (aqeVarB != null) {
                aqeVarB.w();
            }
        }
    }

    public boolean g() {
        return this.a;
    }

    public int getGroupListSize() {
        ady adyVarB = aof.a().b();
        if (adyVarB == null) {
            return 0;
        }
        return adyVarB.c();
    }

    class a implements Runnable {
        Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
