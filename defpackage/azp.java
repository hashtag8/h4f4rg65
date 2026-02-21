package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.azo;
import defpackage.azu;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
public class azp {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    ImageView e;
    RelativeLayout f;
    DashboardActivity g;
    azi h;
    RelativeLayout j;
    Bitmap i = null;
    private bip k = new bip() { // from class: azp.4
        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            azp.this.i = bitmap;
            azp.this.d.setImageBitmap(bitmap);
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
            azp.this.d.setImageResource(R.drawable.empty_cover_art_small);
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    };

    public void a(DashboardActivity dashboardActivity) {
        this.g = dashboardActivity;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.rdio_grid_top_label);
        this.a.setTypeface(ahu.a(this.g));
        this.b = (TextView) view.findViewById(R.id.rdio_grid_mid_label);
        this.b.setTypeface(ahu.a(this.g));
        this.c = (TextView) view.findViewById(R.id.rdio_grid_bot_label);
        this.c.setTypeface(ahu.a(this.g));
        this.d = (ImageView) view.findViewById(R.id.iv);
        this.e = (ImageView) view.findViewById(R.id.rdio_grid_play_image);
        this.f = (RelativeLayout) view.findViewById(R.id.rdio_grid_view_click);
    }

    public void a(azi aziVar) {
        try {
            this.j = (RelativeLayout) this.g.findViewById(R.id.parent);
            this.h = aziVar;
            if (aziVar instanceof azf) {
                final azf azfVar = (azf) aziVar;
                this.a.setText(azfVar.d());
                this.b.setText(azfVar.e());
                this.c.setText(this.g.getResources().getString(R.string.RdioSongs_Str) + ": " + azfVar.b());
                this.b.setMaxLines(1);
                this.c.setVisibility(0);
                this.e.setVisibility(4);
                this.f.setOnClickListener(new View.OnClickListener() { // from class: azp.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("HK_Rdio_Playlist_Title", azfVar.d());
                        bundle.putString("HK_Rdio_Playlist_User", azfVar.e());
                        bundle.putString("HK_Rdio_Source_Key", azfVar.f());
                        bundle.putString("HK_Rdio_Playlist_Track_Count", azp.this.g.getResources().getString(R.string.RdioSongs_Str) + ": " + azfVar.b());
                        bundle.putString("HK_Rdio_Playlist_Artwork", azfVar.a());
                        bundle.putStringArrayList("HK_Rdio_Playlist_Keys", azfVar.c());
                        bundle.putInt("HK_Rdio_ListVC_Type", azu.b.EListTypeAlbums.a());
                        azu azuVar = new azu();
                        azuVar.g(bundle);
                        if (ahn.a()) {
                            azp.this.g.q().a(azuVar, new arc().c(R.id.rdio_menu_container));
                        } else {
                            azp.this.g.q().a(azuVar, (arc) null);
                        }
                    }
                });
            } else if (aziVar instanceof azg) {
                final azg azgVar = (azg) aziVar;
                this.a.setText(azgVar.e());
                this.b.setText(this.g.getResources().getString(R.string.RdioAlbums_Str) + ": " + azgVar.c());
                this.c.setText(this.g.getResources().getString(R.string.RdioSongs_Str) + ": " + azgVar.b());
                this.e.setVisibility(4);
                this.b.setMaxLines(1);
                this.c.setVisibility(0);
                this.f.setOnClickListener(new View.OnClickListener() { // from class: azp.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("HK_Rdio_Album_Artist_Name", azgVar.e());
                        bundle.putString("HK_Rdio_Album_Artist_Key", azgVar.d());
                        bundle.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeAlbums.a());
                        azo azoVarD = azo.d(azo.b.EGridTypeAlbums.a());
                        azoVarD.g(bundle);
                        if (ahn.a()) {
                            azp.this.g.q().a(azoVarD, new arc().c(R.id.rdio_menu_container));
                        } else {
                            azp.this.g.q().a(azoVarD, (arc) null);
                        }
                    }
                });
            } else if (aziVar instanceof azk) {
                azk azkVar = (azk) aziVar;
                this.a.setText(azkVar.d());
                if (!azkVar.c().isEmpty()) {
                    this.b.setText(azkVar.c());
                } else {
                    this.b.setText("");
                }
                this.b.setLines(2);
                this.c.setVisibility(8);
                this.c.setText("");
                this.e.setVisibility(0);
            } else if (aziVar instanceof azj) {
                final azj azjVar = (azj) aziVar;
                this.a.setText(azjVar.f());
                this.b.setText(this.g.getResources().getString(R.string.RdioBy_Str) + ": " + azjVar.c());
                this.c.setText(this.g.getResources().getString(R.string.RdioSongs_Str) + ": " + azjVar.d());
                this.e.setVisibility(4);
                this.b.setMaxLines(1);
                this.c.setVisibility(0);
                this.f.setOnClickListener(new View.OnClickListener() { // from class: azp.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("HK_Rdio_Playlist_Title", azjVar.f());
                        bundle.putString("HK_Rdio_Playlist_User", azjVar.c());
                        bundle.putString("HK_Rdio_Source_Key", azjVar.b());
                        bundle.putString("HK_Rdio_Playlist_Track_Count", azp.this.g.getResources().getString(R.string.RdioSongs_Str) + ": " + azjVar.d());
                        bundle.putString("HK_Rdio_Playlist_Artwork", azjVar.a());
                        bundle.putStringArrayList("HK_Rdio_Playlist_Keys", azjVar.e());
                        bundle.putInt("HK_Rdio_ListVC_Type", azu.b.EListTypePlaylists.a());
                        azu azuVar = new azu();
                        azuVar.g(bundle);
                        if (ahn.a()) {
                            azp.this.g.q().a(azuVar, new arc().c(R.id.rdio_menu_container));
                        } else {
                            azp.this.g.q().a(azuVar, (arc) null);
                        }
                    }
                });
            } else if (aziVar instanceof azm) {
                azm azmVar = (azm) aziVar;
                this.a.setText(azmVar.b());
                this.b.setText(this.g.getResources().getString(R.string.RdioBy_Str) + ": " + azmVar.c());
                this.c.setText("");
                this.e.setVisibility(4);
                this.b.setMaxLines(1);
                this.c.setVisibility(0);
            }
            this.d.setImageResource(R.drawable.empty_cover_art_small);
            bif.a((Context) this.g).a(aziVar.a()).a(this.k);
        } catch (Exception e) {
            mm.e("Could not load data", e);
        }
    }
}
