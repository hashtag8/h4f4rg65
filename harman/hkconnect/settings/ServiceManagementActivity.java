package com.harman.hkconnect.settings;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.management.curstomerview.DragSortListView;
import defpackage.afu;
import defpackage.ahn;
import defpackage.aho;
import defpackage.aim;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aol;
import defpackage.aon;
import defpackage.aoo;
import defpackage.aop;
import defpackage.aos;
import defpackage.aqc;
import defpackage.aqo;
import defpackage.ava;
import defpackage.ave;
import defpackage.mm;
import defpackage.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManagementActivity extends aqc implements View.OnClickListener {
    private aju y;
    private DragSortListView m = null;
    private List<aos> n = null;
    private a o = null;
    private int p = 0;
    private DragSortListView.l z = new DragSortListView.l() { // from class: com.harman.hkconnect.settings.ServiceManagementActivity.3
        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.l
        public void a(int i, aon aonVar, int i2) {
            final aos item = ServiceManagementActivity.this.o.getItem(i);
            switch (i2) {
                case 0:
                    item.b.a(false);
                    ServiceManagementActivity.this.o.b();
                    mq.b().a(new Runnable() { // from class: com.harman.hkconnect.settings.ServiceManagementActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            new ava().a(item.b.d(), ServiceManagementActivity.this).b();
                            mm.b("takes time for logOut %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            aqo.f().a("Removed", item.b.g());
                            mm.b("takes time for Removed %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
                        }
                    });
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_service_management);
        m();
        if (!ahn.a()) {
            setRequestedOrientation(1);
        }
        this.m = (DragSortListView) findViewById(R.id.music_service_list);
        l();
        this.o = new a(this, this.n);
        this.m.setDropListener(this.o);
        this.p = R.id.drag_area;
        b bVar = new b(this.m, this.o);
        this.m.setFloatViewManager(bVar);
        this.m.setOnTouchListener(bVar);
        this.m.setAdapter((ListAdapter) this.o);
        this.m.setMenuCreator(new aoo() { // from class: com.harman.hkconnect.settings.ServiceManagementActivity.1
            @Override // defpackage.aoo
            public void a(aon aonVar) {
                aop aopVar = new aop(ServiceManagementActivity.this.getApplicationContext());
                aopVar.d(R.drawable.service_remove_bg);
                aopVar.e(ServiceManagementActivity.this.c(100));
                aopVar.c(R.string.Remove_Str);
                aopVar.a(15);
                aopVar.b(-1291845633);
                aonVar.a(aopVar);
            }
        });
        this.m.setOnMenuItemClickListener(this.z);
        this.m.setOnSwipeListener(new DragSortListView.m() { // from class: com.harman.hkconnect.settings.ServiceManagementActivity.2
            @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.m
            public void a(int i) {
            }

            @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.m
            public void b(int i) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void l() {
        this.n = new ArrayList();
        ArrayList<ave> arrayListL = aim.a().l();
        for (int i = -1; i < arrayListL.size(); i++) {
            aos aosVar = new aos();
            if (i == -1) {
                aosVar.a = true;
                aosVar.b.a(getString(R.string.kSettings_SelectedServices));
                aosVar.b.a(false);
            } else {
                aosVar.a = false;
                aosVar.b = arrayListL.get(i);
            }
            if (aosVar.b.d() == 8) {
                if (aho.b("KEY_SHOW_DLNA", false)) {
                    this.n.add(aosVar);
                }
            } else if (aosVar.b.d() == 6) {
                mm.b((Object) "this is juke service");
            } else {
                this.n.add(aosVar);
            }
        }
        ArrayList<ave> arrayListN = aim.a().n();
        for (int i2 = -1; i2 < arrayListN.size(); i2++) {
            aos aosVar2 = new aos();
            if (i2 == -1) {
                aosVar2.a = true;
                aosVar2.b.a(getString(R.string.kSettings_AvailableMusicServices));
                aosVar2.b.a(false);
            } else {
                aosVar2.a = false;
                aosVar2.b = arrayListN.get(i2);
            }
            if (aosVar2.b.d() == 8) {
                if (aho.b("KEY_SHOW_DLNA", false)) {
                    this.n.add(aosVar2);
                }
            } else if (aosVar2.b.d() == 6) {
                mm.b((Object) "this is juke service");
            } else {
                this.n.add(aosVar2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void m() {
        this.y = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.music_service_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.y.a(true);
        this.y.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_musicServiceManage_Str).j(R.color.opaque_white).c());
    }

    class b extends aol {
        DragSortListView a;
        private int c;
        private Integer[] d;
        private a e;
        private int f;

        public b(DragSortListView dragSortListView, a aVar) {
            super(dragSortListView, ServiceManagementActivity.this.p, 0, 0);
            this.f = -1;
            b(false);
            this.a = dragSortListView;
            this.e = aVar;
            this.d = aVar.a();
        }

        @Override // defpackage.aol
        public int a(MotionEvent motionEvent) {
            int iC = super.c(motionEvent);
            this.d = this.e.a();
            for (int i = 0; i < this.d.length; i++) {
                if (iC == this.d[i].intValue()) {
                    return -1;
                }
            }
            if (this.e.getItem(iC).b.b()) {
                return iC;
            }
            return -1;
        }

        @Override // defpackage.aom, com.harman.hkconnect.settings.management.curstomerview.DragSortListView.i
        public View a(int i) {
            this.c = i;
            return this.e.getView(i, null, this.a);
        }

        @Override // defpackage.aol, defpackage.aom, com.harman.hkconnect.settings.management.curstomerview.DragSortListView.i
        public void a(View view, Point point, Point point2) {
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            int dividerHeight = this.a.getDividerHeight();
            if (this.f == -1) {
                this.f = view.getHeight();
            }
            this.d = this.e.a();
            for (int i = 0; i < this.d.length; i++) {
                View childAt = this.a.getChildAt(this.d[i].intValue() - firstVisiblePosition);
                if (point2.x > this.a.getWidth() / 2) {
                }
                if (childAt != null) {
                    if (this.c > this.d[i].intValue()) {
                        int bottom = childAt.getBottom() + dividerHeight;
                        if (point.y < bottom) {
                            point.y = bottom;
                        }
                    } else {
                        int top = (childAt.getTop() - dividerHeight) - view.getHeight();
                        if (point.y > top) {
                            point.y = top;
                        }
                    }
                }
            }
        }

        @Override // defpackage.aom, com.harman.hkconnect.settings.management.curstomerview.DragSortListView.i
        public void a(View view) {
        }

        @Override // defpackage.aol, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            int iC = super.c(motionEvent);
            this.d = this.e.a();
            for (int i = 0; i < this.d.length; i++) {
                if (iC == this.d[i].intValue()) {
                    return true;
                }
            }
            aos item = this.e.getItem(iC);
            if (!item.b.b()) {
                if (a(motionEvent, R.id.drag_area) != -1) {
                    aqo.f().a("Added", item.b.g());
                    item.b.a(true);
                    this.e.b();
                }
                return true;
            }
            return super.onDown(motionEvent);
        }
    }

    public class a extends BaseAdapter implements DragSortListView.h {
        private List<aos> b;
        private HashMap<Integer, aos> c = new HashMap<>();
        private Integer[] d;
        private LayoutInflater e;

        public a(Context context, List<aos> list) {
            this.e = (LayoutInflater) context.getSystemService("layout_inflater");
            this.b = list;
            this.d = a(list);
        }

        private Integer[] a(List<aos> list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).a) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            return (Integer[]) arrayList.toArray(new Integer[0]);
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.h
        public void a_(int i, int i2) {
            if (i != i2) {
                aos aosVar = this.b.get(i);
                this.b.remove(aosVar);
                this.b.add(i2, aosVar);
                notifyDataSetChanged();
                mq.b().a(new Runnable() { // from class: com.harman.hkconnect.settings.ServiceManagementActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c();
                    }
                });
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            for (int i2 = 0; i2 < this.d.length; i2++) {
                if (i == this.d[i2].intValue()) {
                    return false;
                }
            }
            return true;
        }

        public Integer[] a() {
            return this.d;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.d.length;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public aos getItem(int i) {
            if (-1 == i) {
                i = 0;
            }
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.b.get(i).a ? 0 : 1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0138a c0138a;
            b bVar;
            b bVar2 = null;
            c0138a = null;
            C0138a c0138a2 = null;
            bVar2 = null;
            int itemViewType = getItemViewType(i);
            if (view == null || ((itemViewType == 1 && (view.getTag() instanceof C0138a)) || (itemViewType == 0 && (view.getTag() instanceof b)))) {
                switch (itemViewType) {
                    case 0:
                        C0138a c0138a3 = new C0138a();
                        view = this.e.inflate(R.layout.service_management_title, (ViewGroup) null);
                        c0138a3.a = (TextView) view.findViewById(R.id.title);
                        view.setTag(c0138a3);
                        c0138a = c0138a3;
                        break;
                    case 1:
                        b bVar3 = new b();
                        view = this.e.inflate(R.layout.service_management_item, (ViewGroup) null);
                        bVar3.a = (ImageView) view.findViewById(R.id.iv);
                        bVar3.b = (TextView) view.findViewById(R.id.title);
                        bVar3.c = (TextView) view.findViewById(R.id.subtitle);
                        bVar3.c.setVisibility(8);
                        bVar3.d = (ImageView) view.findViewById(R.id.drag_area);
                        view.setTag(bVar3);
                        c0138a = null;
                        bVar2 = bVar3;
                        break;
                    default:
                        c0138a = null;
                        break;
                }
                bVar = bVar2;
                c0138a2 = c0138a;
            } else {
                switch (itemViewType) {
                    case 0:
                        bVar = null;
                        c0138a2 = (C0138a) view.getTag();
                        break;
                    case 1:
                        bVar = (b) view.getTag();
                        break;
                    default:
                        bVar = null;
                        break;
                }
            }
            aos aosVar = this.b.get(i);
            if (aosVar != null) {
                switch (itemViewType) {
                    case 0:
                        if (aosVar.b.g().equals(ServiceManagementActivity.this.getString(R.string.kSettings_AvailableMusicServices)) && aim.a().m().isEmpty()) {
                            view.setVisibility(8);
                            view.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
                        } else {
                            view.setVisibility(0);
                            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                            c0138a2.a.setText(aosVar.b.g());
                        }
                        break;
                    case 1:
                        bVar.b.setText(aosVar.b.g());
                        bVar.a.setImageResource(aosVar.b.c());
                        bVar.c.setText(aosVar.b.a());
                        bVar.d.setImageResource(aosVar.a());
                        bVar.d.setTag(aosVar);
                        if (aosVar.a() == R.drawable.dashboard_navigation_leftpanel_icon) {
                        }
                        bVar.d.setVisibility(0);
                        break;
                }
            }
            return view;
        }

        public void b() {
            String strG;
            int size = this.b.size();
            String str = null;
            int i = 0;
            while (i < size) {
                aos aosVar = this.b.get(i);
                if (aosVar.a) {
                    strG = aosVar.b.g();
                } else {
                    if (str.equals(ServiceManagementActivity.this.getString(R.string.kSettings_SelectedServices))) {
                        if (!aosVar.b.b()) {
                            this.b.add(this.b.remove(i));
                            this.d = a(this.b);
                            strG = str;
                        }
                    } else if (str.equals(ServiceManagementActivity.this.getString(R.string.kSettings_AvailableMusicServices)) && aosVar.b.b()) {
                        this.b.add(this.d[this.d.length - 1].intValue(), this.b.remove(i));
                        this.d = a(this.b);
                    }
                    strG = str;
                }
                i++;
                str = strG;
            }
            ServiceManagementActivity.this.o.notifyDataSetChanged();
            c();
        }

        public class b {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.harman.hkconnect.settings.ServiceManagementActivity$a$a, reason: collision with other inner class name */
        public class C0138a {
            public TextView a;

            public C0138a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int i = 0;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a) {
                    i++;
                } else {
                    this.b.get(i2).b.a(i2 - i);
                }
            }
            int iB = MusicPlaylistManager.a().b();
            if (MusicPlaylistManager.a().v() && iB != 1) {
                Iterator<ave> it = aim.a().m().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (iB == MusicData.getTypeFromHCConstantValue(it.next().d())) {
                            afu.a().a(true);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            aim.a().d();
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
