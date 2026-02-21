package com.harman.hkconnect.nowplaying;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.dslv.DragSortListView;
import defpackage.ahs;
import defpackage.aig;
import defpackage.aio;
import defpackage.aof;
import defpackage.arw;
import defpackage.asc;

/* JADX INFO: loaded from: classes.dex */
public class MyQueueLayout extends LinearLayout implements View.OnClickListener {
    private static String e = "DashboardMusicQueueFragment";
    private static MusicPlaylistManager h = MusicPlaylistManager.a();
    public boolean a;
    public boolean b;
    public boolean c;
    AbsListView.OnScrollListener d;
    private DragSortListView f;
    private aig g;
    private TextView i;
    private arw j;
    private ahs k;
    private CoordinatorLayout l;
    private float m;
    private int n;
    private DragSortListView.e o;
    private Handler p;

    public MyQueueLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = false;
        this.c = true;
        this.j = null;
        this.k = null;
        this.m = 0.0f;
        this.o = new DragSortListView.e() { // from class: com.harman.hkconnect.nowplaying.MyQueueLayout.2
            @Override // com.harman.hkconnect.dslv.DragSortListView.b
            public void a(int i, int i2) {
            }

            @Override // com.harman.hkconnect.dslv.DragSortListView.h
            public void b(int i, int i2) {
                MyQueueLayout.h.a(i, i2);
                MyQueueLayout.this.g.a(MyQueueLayout.h.i());
                MyQueueLayout.this.g.notifyDataSetChanged();
            }

            @Override // com.harman.hkconnect.dslv.DragSortListView.m
            public void a(int i) {
                if (MyQueueLayout.this.l != null) {
                    MyQueueLayout.h.a(i, MyQueueLayout.this.l);
                } else {
                    MyQueueLayout.h.d(i);
                }
                MyQueueLayout.this.g.a(MyQueueLayout.h.i());
                MyQueueLayout.this.g.notifyDataSetChanged();
            }
        };
        this.d = new AbsListView.OnScrollListener() { // from class: com.harman.hkconnect.nowplaying.MyQueueLayout.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        MyQueueLayout.this.b();
                        break;
                    case 1:
                        MyQueueLayout.this.k.a();
                        break;
                    case 2:
                        MyQueueLayout.this.k.a();
                        break;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.p = new Handler();
        e();
    }

    public void setTextViewWidth(int i) {
        this.n = i;
        if (this.g != null) {
            this.g.a(this.n);
        }
    }

    public void setCoordinatorLayout(CoordinatorLayout coordinatorLayout) {
        this.l = coordinatorLayout;
    }

    private void e() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dashboard_myqueue_fragment, this);
        this.f = (DragSortListView) viewInflate.findViewById(R.id.music_queue_lv);
        aio aioVar = new aio(this.f);
        aioVar.c(R.id.queue_item);
        aioVar.b(1);
        aioVar.b(true);
        aioVar.d(R.id.queue_item);
        aioVar.f(Color.parseColor("#55FFFFFF"));
        aioVar.a(2);
        this.f.setFloatAlpha(0.8f);
        this.f.setFloatViewManager(aioVar);
        this.f.setOnTouchListener(aioVar);
        this.f.setEmptyView(viewInflate.findViewById(R.id.add_music_tv));
        this.f.setDragSortListener(this.o);
        this.i = (TextView) viewInflate.findViewById(R.id.add_music_tv);
        h = MusicPlaylistManager.a();
        this.f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.nowplaying.MyQueueLayout.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((RelativeLayout) view.findViewById(R.id.queue_item)).setBackgroundResource(R.color.queue_nowplay_bg);
                if (aof.a().n() && MyQueueLayout.h.u() == i) {
                    if (MyQueueLayout.h.v()) {
                        MyQueueLayout.h.l();
                    } else {
                        MyQueueLayout.h.k();
                    }
                } else {
                    MyQueueLayout.h.e(i);
                }
                MyQueueLayout.this.g.notifyDataSetChanged();
            }
        });
        this.k = new ahs(getContext());
        this.f.setOnScrollListener(this.d);
        f();
        c();
    }

    public void a() {
        int iU = h.u();
        if (iU < 0) {
            iU = 0;
        }
        this.f.setSelection(iU);
    }

    public void b() {
        int firstVisiblePosition = this.f.getFirstVisiblePosition();
        int lastVisiblePosition = this.f.getLastVisiblePosition();
        if (lastVisiblePosition >= this.g.getCount()) {
            lastVisiblePosition = this.g.getCount() - 1;
        }
        this.k.a(firstVisiblePosition, lastVisiblePosition);
        this.k.b();
    }

    private void f() {
        if (h.i() != null && h.i().a() != 0) {
            this.g = new aig(getContext(), h.i(), this.n);
            this.f.setAdapter((ListAdapter) this.g);
        }
    }

    public void c() {
        if (this.f != null) {
            if (this.g == null) {
                f();
            } else {
                this.g.notifyDataSetChanged();
            }
            if (h.i() != null && h.i().a() > 0) {
                this.f.setVisibility(0);
                this.i.setVisibility(8);
            } else {
                this.f.setVisibility(8);
                this.i.setVisibility(0);
            }
        }
    }

    private arw g() {
        if (this.j == null) {
            this.j = new arw.a(getContext()).a(getContext().getString(R.string.PlayListClearAllMessage_Str)).b(getContext().getString(R.string.PlayListClearAllAlertTitle_Str)).a(getContext().getString(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.nowplaying.MyQueueLayout.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    MyQueueLayout.h.g();
                    MyQueueLayout.this.g.notifyDataSetChanged();
                }
            }).b(getContext().getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.nowplaying.MyQueueLayout.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    MyQueueLayout.this.j.dismiss();
                }
            }).d(false).b();
        }
        if (!this.j.isShowing()) {
            new asc(this.j).a(null);
        }
        return this.j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.music_queue_clear_all_layout /* 2131689989 */:
                if (h != null && h.i().a() != 0) {
                    g();
                    break;
                }
                break;
        }
    }
}
