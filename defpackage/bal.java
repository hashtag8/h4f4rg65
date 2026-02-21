package defpackage;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Genre;
import com.musicservice.shoutcast.model.Station;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class bal extends ajj {
    public int a = 2;

    @Override // defpackage.ajj
    public ajv b() {
        return c().g(R.string.SettingShoutCast_Str).a().c();
    }

    protected ajv.a c() {
        return new ajv.a().d(R.color.shoutcast_theme_color).e(q().getColor(R.color.white)).i(R.drawable.hamberger_white_icon).c(true).a(new MenuItem.OnMenuItemClickListener() { // from class: bal.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                bal.this.an();
                return true;
            }
        });
    }

    protected void d() {
        Bundle bundle = new Bundle();
        bundle.putString("subgenre_name", a(R.string.kShoutCastTop25_Str));
        bar barVar = new bar();
        barVar.g(bundle);
        this.ae.q().a(barVar, (arc) null);
    }

    protected void a(Genre genre) {
        Bundle bundle = new Bundle();
        bundle.putString("genre_name", genre.getName());
        bundle.putString("genre_id", String.valueOf(genre.getId()));
        bam bamVar = new bam();
        bamVar.g(bundle);
        this.ae.q().a(bamVar, (arc) null);
    }

    protected void b(Genre genre) {
        Bundle bundle = new Bundle();
        bundle.putString("subgenre_name", "" + genre.getId());
        bundle.putString("subgenre", "" + genre.getName());
        baq baqVar = new baq();
        baqVar.g(bundle);
        this.ae.q().a(baqVar, (arc) null);
    }

    protected void a(Station station) {
        bap bapVar = new bap();
        Bundle bundle = new Bundle();
        bundle.putParcelable("station", station);
        bapVar.g(bundle);
        this.ae.q().a(bapVar, (arc) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.ae.q().b(new bao(), null);
    }

    protected int al() {
        if (!ahn.a()) {
            return this.a;
        }
        this.a = 4;
        return this.a;
    }

    protected String am() {
        ba baVarP = p();
        p();
        return ((TelephonyManager) baVarP.getSystemService("phone")).getSimCountryIso();
    }
}
