package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class bbv {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    DashboardActivity e;
    JSONArray f;
    RelativeLayout g;
    bbj h = new bbj();
    bbp i;

    public void a(DashboardActivity dashboardActivity) {
        this.e = dashboardActivity;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.sc_playlist_user);
        this.a.setTypeface(ahu.a(this.e));
        this.b = (TextView) view.findViewById(R.id.sc_playlist_title);
        this.b.setTypeface(ahu.a(this.e));
        this.c = (TextView) view.findViewById(R.id.sc_playlist_track_count);
        this.c.setTypeface(ahu.a(this.e));
        this.d = (ImageView) view.findViewById(R.id.iv);
        this.g = (RelativeLayout) view.findViewById(R.id.sc_playlist_layout_click);
    }

    public void a(bbp bbpVar) {
        try {
            this.i = bbpVar;
            this.a.setText(this.i.o);
            this.c.setText(this.e.getResources().getString(R.string.SoundCloudTracks_Str) + ": " + this.i.l);
            this.b.setText(this.i.m);
            this.f = this.i.k;
            new ahw().a(this.d, this.i.n);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: bbv.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ahf.a((Activity) bbv.this.e);
                    DashboardActivity dashboardActivity = bbv.this.e;
                    Bundle bundle = new Bundle();
                    try {
                        if (bbv.this.f != null && bbv.this.f.length() != 0 && bbv.this.f.getJSONObject(0).has("streamable")) {
                            bbv.this.h.getClass();
                            bundle.putString("HK_SoundCloud_Likes_JSON_String", bbv.this.i.k.toString());
                            bbv.this.h.getClass();
                            bundle.putString("HK_SoundCloud_Likes_Title_JSON_String", bbv.this.i.m);
                        } else {
                            bbv.this.h.getClass();
                            bundle.putString("HK_SoundCloud_Likes_JSON_String", bbv.this.i.q);
                            bbv.this.h.getClass();
                            bundle.putString("HK_SoundCloud_Likes_Title_JSON_String", bbv.this.i.m);
                        }
                        bbv.this.h.getClass();
                        bundle.putString("HK_SoundCloud_Playlist_Count", bbv.this.i.l);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    bbq bbqVar = new bbq();
                    if (ahn.a()) {
                        bbv.this.e.q().a(bbv.this.e.f(), bbqVar, (Bundle) null, R.id.soundcloud_menu_container);
                    } else {
                        bbv.this.e.q().a(bbqVar, (arc) null);
                    }
                    if (ahn.a()) {
                        bbv.this.e.q().a(bbv.this.e.f(), bbqVar, (Bundle) null, R.id.soundcloud_menu_container);
                    } else {
                        bbqVar.g(bundle);
                        bbv.this.e.q().a(bbqVar, (arc) null);
                    }
                }
            });
        } catch (Exception e) {
        }
    }
}
