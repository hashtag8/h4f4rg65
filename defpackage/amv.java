package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class amv extends amw {
    private AlbumsInfo ah;
    private View ai;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ai = layoutInflater.inflate(R.layout.album_info_fragment, (ViewGroup) null);
        this.b = (TextView) this.ai.findViewById(R.id.artist);
        this.c = (TextView) this.ai.findViewById(R.id.album);
        this.d = (TextView) this.ai.findViewById(R.id.hi_res);
        this.e = (TextView) this.ai.findViewById(R.id.tech_specs);
        this.f = (TextView) this.ai.findViewById(R.id.release_date);
        this.g = (TextView) this.ai.findViewById(R.id.label);
        this.h = (TextView) this.ai.findViewById(R.id.genre);
        this.i = (TextView) this.ai.findViewById(R.id.content);
        return this.ai;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ah = (AlbumsInfo) bundle.getParcelable("AlbumsInfo");
        if (this.ah != null) {
            this.b.setText(this.ah.c);
            this.c.setText(this.ah.b);
            if (this.ah.j) {
                this.d.setVisibility(0);
                this.d.setText(this.ae.getString(R.string.hi_res));
            } else if (this.ah.m.startsWith("16")) {
                this.d.setVisibility(0);
                this.d.setText(this.ae.getString(R.string.CD));
            } else {
                this.d.setVisibility(8);
            }
            this.e.setText(this.ah.m);
            this.f.setText(this.ae.getResources().getString(R.string.kQobuz_NewRelease_Str) + " " + ann.a(String.valueOf(this.ah.d), "MMM d, yyyy"));
            if (this.ah.l.compareTo("") == 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(this.ah.l);
            }
            this.h.setText(this.ah.i);
            this.i.setText(this.ah.n);
        }
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.c.getText().toString()).e(q().getColor(R.color.white)).a(-9128246).c();
    }
}
