package defpackage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.TouchDisableViewPager;
import defpackage.ajv;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anl extends amw implements anu<JSONObject> {
    private View d;
    private amu e;
    private amt f;
    private anv g;
    private TouchDisableViewPager i;
    private final int b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int c = 0;
    private ArrayList<String> h = new ArrayList<>();

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.g = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_tabbed_viewpager_layout, (ViewGroup) null);
        this.d = viewInflate.findViewById(R.id.loading);
        ((TextView) this.d.findViewById(R.id.tips)).setTextColor(-16777216);
        this.d.setVisibility(8);
        this.h.add(a(R.string.kQobuz_Albums_Str));
        this.h.add(a(R.string.kQobuz_Tracks_Str));
        a aVar = new a(s());
        this.i = (TouchDisableViewPager) viewInflate.findViewById(R.id.favourites_content);
        this.i.setAdapter(aVar);
        this.i.setOffscreenPageLimit(2);
        ((TabLayout) viewInflate.findViewById(R.id.tab_header)).setupWithViewPager(this.i);
        d();
        return viewInflate;
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        this.ae.a(this.i);
    }

    private void d() {
        this.g.a("http://www.qobuz.com/api.json/0.2/purchase/getUserPurchases?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.c, this);
        this.d.setVisibility(0);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_Purchases_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.d.setVisibility(8);
        ArrayList<QobuzMusicData> arrayListB = any.b(jSONObject);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("RESULT", arrayListB);
        ArrayList<AlbumsInfo> arrayListD = any.d(jSONObject.optJSONObject("albums"));
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("RESULT", arrayListD);
        this.f.o(bundle2);
        this.e.o(bundle);
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
        this.f.c(new Bundle());
        this.e.c(new Bundle());
    }

    @Override // defpackage.anu
    public void c() {
    }

    public class a extends bh {
        public a(be beVar) {
            super(beVar);
        }

        @Override // defpackage.ex
        public int b() {
            return 2;
        }

        @Override // defpackage.bh
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    if (anl.this.f == null) {
                        anl.this.f = new amt();
                    }
                    return anl.this.f;
                case 1:
                    if (anl.this.e == null) {
                        anl.this.e = new amu();
                    }
                    return anl.this.e;
                default:
                    return null;
            }
        }

        @Override // defpackage.ex
        public CharSequence c(int i) {
            return (CharSequence) anl.this.h.get(i);
        }
    }
}
