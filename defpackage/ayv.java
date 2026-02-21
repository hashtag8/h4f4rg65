package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.azb;
import defpackage.azo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ayv extends azs implements azb.a {
    protected BaseAdapter a;
    private TextView ar;
    private List<azh> as = Collections.emptyList();
    private LayoutInflater b;
    private ListView c;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rdio_browse_layout, (ViewGroup) null);
        viewInflate.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.ar = (TextView) viewInflate.findViewById(R.id.rdio_empty_list_view);
        this.ar.setText("");
        this.ar.setTypeface(ahu.a(this.ae));
        this.a = new a(this.ae);
        this.c = (AnimationListView) viewInflate.findViewById(R.id.rdio_browse_list);
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ayv.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                azh azhVar = (azh) ayv.this.as.get(i);
                azo azoVarD = azo.d(azo.b.EGridTypeBrowse.a());
                Bundle bundle2 = new Bundle();
                bundle2.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeBrowse.a());
                bundle2.putString("HK_Rdio_Browse_Url", azhVar.d());
                bundle2.putString("HK_Rdio_Browse_Name", azhVar.c());
                azoVarD.g(bundle2);
                if (!ahn.a()) {
                    ayv.this.ae.q().a(azoVarD, (arc) null);
                } else {
                    ayv.this.ae.q().a(azoVarD, new arc().c(R.id.rdio_menu_container));
                }
            }
        });
        this.c.setAdapter((ListAdapter) this.a);
        c();
        return viewInflate;
    }

    @Override // defpackage.azs, azb.a
    public void a(boolean z, String str) {
        mm.b("success %s, response %s", Boolean.valueOf(z), str);
        if (z) {
            try {
                this.as = ayw.b(ayw.c(str).getJSONArray("items"));
                this.a.notifyDataSetChanged();
            } catch (Exception e) {
                mm.e("Cannot load music", e);
            }
        }
        this.ar.setText(this.ae.getResources().getString(R.string.RdioNoResults_Str));
        this.c.setEmptyView(this.ar);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        c();
    }

    private void c() {
        ayw.c().a(ayw.c().f(), this);
    }

    class a extends BaseAdapter {
        public a(Context context) {
            ayv.this.b = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ayv.this.as.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ayv.this.as.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View viewInflate = view;
            if (view == null) {
                viewInflate = ayv.this.b.inflate(R.layout.rdio_browse_cell, (ViewGroup) null);
            }
            b bVar2 = (b) viewInflate.getTag();
            if (bVar2 == null) {
                b bVar3 = new b();
                bVar3.a(viewInflate);
                viewInflate.setTag(bVar3);
                bVar = bVar3;
            } else {
                bVar = bVar2;
            }
            try {
                bVar.a((azi) ayv.this.as.get(i));
            } catch (Exception e) {
            }
            return viewInflate;
        }
    }

    class b {
        TextView a;
        TextView b;
        TextView c;
        azh d;

        private b() {
        }

        public void a(View view) {
            this.a = (TextView) view.findViewById(R.id.rdio_browse_cell_title);
            this.a.setTypeface(ahu.a(ayv.this.ae));
            this.b = (TextView) view.findViewById(R.id.rdio_browse_cell_artists);
            this.b.setTypeface(ahu.a(ayv.this.ae));
            this.c = (TextView) view.findViewById(R.id.rdio_browse_cell_station_count);
            this.c.setTypeface(ahu.a(ayv.this.ae));
        }

        public void a(azi aziVar) {
            if (aziVar instanceof azh) {
                azh azhVar = (azh) aziVar;
                this.d = azhVar;
                this.a.setText(azhVar.c());
                this.b.setText(azhVar.e());
                this.c.setText("Stations: " + azhVar.b());
            }
        }
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        return aq().g(R.string.RdioBrowse_Str).c();
    }
}
