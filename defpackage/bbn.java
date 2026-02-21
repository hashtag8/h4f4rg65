package defpackage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbn {
    TextView a;
    ImageView b;
    RelativeLayout c;
    DashboardActivity d;
    bbp e;
    bbj f = new bbj();

    public void a(DashboardActivity dashboardActivity) {
        this.d = dashboardActivity;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.sc_explore_category);
        this.b = (ImageView) view.findViewById(R.id.sc_explore_genres_underline);
        this.c = (RelativeLayout) view.findViewById(R.id.sc_genre_cell_click);
    }

    public void a(JSONObject jSONObject, final int i) {
        try {
            this.e = new bbp(jSONObject, "Genres");
            if (this.e.s.get(i).equals("Music") || this.e.s.get(i).equals("Audio")) {
                this.b.setBackgroundColor(Color.parseColor("#FC551F"));
                this.b.getLayoutParams().height = ahn.a(this.d, 1.5f);
                this.a.setTextColor(Color.parseColor("#FC551F"));
                this.a.setTypeface(ahu.b(this.d));
                float f = this.d.getResources().getDisplayMetrics().density;
                if (this.e.s.get(i).equals("Music")) {
                    this.a.setPadding((int) (30.0f * f), (int) (10.0f * f), (int) (15.0f * f), (int) (f * 10.0f));
                } else {
                    this.a.setPadding((int) (30.0f * f), (int) (35.0f * f), (int) (15.0f * f), (int) (f * 10.0f));
                }
                this.a.setText(this.e.s.get(i).toUpperCase());
            } else {
                this.b.setBackgroundColor(-7829368);
                this.b.getLayoutParams().height = ahn.a(this.d, 0.5f);
                this.a.setTextColor(-7829368);
                this.a.setTypeface(ahu.a(this.d));
                float f2 = this.d.getResources().getDisplayMetrics().density;
                this.a.setPadding((int) (30.0f * f2), (int) (20.0f * f2), (int) (0.0f * f2), (int) (f2 * 20.0f));
            }
            if (!this.e.s.get(i).equals("Music") && !this.e.s.get(i).equals("Audio")) {
                this.a.setText(this.e.s.get(i));
                this.c.setOnClickListener(new View.OnClickListener() { // from class: bbn.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DashboardActivity dashboardActivity = bbn.this.d;
                        Bundle bundle = new Bundle();
                        bbn.this.f.getClass();
                        bundle.putString("HK_SoundCloud_Explore_Genre_JSON_String", bbn.this.e.s.get(i));
                        bbr bbrVar = new bbr();
                        if (ahn.a()) {
                            bbn.this.d.q().a(bbn.this.d.f(), bbrVar, bundle, R.id.soundcloud_menu_container);
                        } else {
                            bbrVar.g(bundle);
                            bbn.this.d.q().a(bbrVar, (arc) null);
                        }
                    }
                });
            }
        } catch (Exception e) {
            mm.e("Could not populate cell data", e);
        }
    }
}
