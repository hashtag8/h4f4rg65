package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.bbi;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbm extends bbt implements bbi.a {
    protected BaseAdapter a;
    private LayoutInflater aq;
    private int as;
    private int at;
    SharedPreferences b;
    private View d;
    private bbj c = new bbj();
    private ArrayList<JSONObject> e = new ArrayList<>();
    private bbo ar = new bbo();

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        bbi bbiVar = new bbi();
        bbiVar.a(this.ae);
        bbiVar.a(this);
        bbiVar.execute("/explore/categories");
        this.d = layoutInflater.inflate(R.layout.soundcloud_explore_genres_layout, (ViewGroup) null);
        this.ah = (AnimationListView) this.d.findViewById(R.id.sc_explore_genres_listview);
        if (ahn.a()) {
            this.ah.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.a = new a(this.ae);
        this.ah.setAdapter((ListAdapter) this.a);
        return this.d;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
    }

    @Override // bbi.a
    public void a(boolean z, String str) {
        if (z) {
            this.e = this.ar.a(str);
            try {
                this.at = this.e.get(0).getJSONArray("music").length();
                this.as = this.e.get(0).getJSONArray("audio").length() + this.at;
            } catch (Exception e) {
            }
            this.a.notifyDataSetChanged();
        } else {
            this.c.a(this.ae, this.ae.getResources().getString(R.string.SoundCloudNoResult_Str));
        }
        this.ah.setEmptyView(this.d.findViewById(R.id.soundcloud_empty_list_view));
        this.c.a();
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bbm.this.aq = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return bbm.this.as;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            bbn bbnVar;
            View view2;
            if (view == null) {
                View viewInflate = bbm.this.aq.inflate(R.layout.soundcloud_genres_cell, (ViewGroup) null);
                bbn bbnVar2 = new bbn();
                bbnVar2.a(bbm.this.ae);
                bbnVar2.a(viewInflate);
                viewInflate.setTag(bbnVar2);
                bbnVar = bbnVar2;
                view2 = viewInflate;
            } else {
                bbnVar = (bbn) view.getTag();
                view2 = view;
            }
            bbnVar.a((JSONObject) bbm.this.e.get(0), i);
            return view2;
        }
    }
}
