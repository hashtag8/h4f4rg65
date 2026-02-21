package defpackage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.azo;
import defpackage.azu;

/* JADX INFO: loaded from: classes.dex */
public class azv {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    DashboardActivity e;
    RelativeLayout f;
    azi g;

    public void a(DashboardActivity dashboardActivity) {
        this.e = dashboardActivity;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.rdio_playlist_user);
        this.a.setTypeface(ahu.a(this.e));
        this.b = (TextView) view.findViewById(R.id.rdio_playlist_title);
        this.b.setTypeface(ahu.a(this.e));
        this.c = (TextView) view.findViewById(R.id.rdio_playlist_track_count);
        this.c.setTypeface(ahu.a(this.e));
        this.d = (ImageView) view.findViewById(R.id.iv);
        this.f = (RelativeLayout) view.findViewById(R.id.rdio_playlist_layout_click);
    }

    public void a(final azi aziVar) {
        try {
            this.g = aziVar;
            if (aziVar instanceof azf) {
                azf azfVar = (azf) aziVar;
                this.a.setText(azfVar.e());
                this.b.setText(azfVar.d());
                this.c.setText(this.e.getResources().getString(R.string.RdioSongs_Str) + ": " + azfVar.b());
            } else if (aziVar instanceof azg) {
                azg azgVar = (azg) aziVar;
                this.a.setText("");
                this.a.setVisibility(8);
                this.c.setGravity(48);
                this.b.setGravity(80);
                this.b.setText(azgVar.e());
                this.c.setText(this.e.getResources().getString(R.string.RdioAlbums_Str) + ": " + azgVar.c());
            } else if (aziVar instanceof azj) {
                azj azjVar = (azj) aziVar;
                this.a.setText(azjVar.c());
                this.b.setText(azjVar.f());
                this.c.setText(this.e.getResources().getString(R.string.RdioSongs_Str) + ": " + azjVar.d());
            }
            new ahw().a(this.d, this.g.a());
            this.f.setOnClickListener(new View.OnClickListener() { // from class: azv.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ajk ajkVar;
                    Bundle bundle = new Bundle();
                    bundle.putString("HK_Rdio_Playlist_Title", azv.this.b.getText().toString());
                    if (aziVar instanceof azf) {
                        azf azfVar2 = (azf) aziVar;
                        azu azuVar = new azu();
                        bundle.putString("HK_Rdio_Album_Artist_Key", azfVar2.f());
                        bundle.putString("HK_Rdio_Playlist_Title", azfVar2.d());
                        bundle.putString("HK_Rdio_Playlist_User", azfVar2.e());
                        bundle.putString("HK_Rdio_Playlist_Track_Count", "Songs: " + azfVar2.b());
                        bundle.putString("HK_Rdio_Playlist_Artwork", azfVar2.a());
                        bundle.putStringArrayList("HK_Rdio_Playlist_Keys", azfVar2.c());
                        bundle.putInt("HK_Rdio_ListVC_Type", azu.b.EListTypeAlbums.a());
                        ajkVar = azuVar;
                    } else if (aziVar instanceof azg) {
                        azg azgVar2 = (azg) aziVar;
                        azo azoVarD = azo.d(azo.b.EGridTypeAlbums.a());
                        bundle.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeAlbums.a());
                        bundle.putString("HK_Rdio_Album_Artist_Key", azgVar2.d());
                        bundle.putString("HK_Rdio_Album_Artist_Name", azgVar2.e());
                        ajkVar = azoVarD;
                    } else if (aziVar instanceof azj) {
                        azj azjVar2 = (azj) aziVar;
                        azu azuVar2 = new azu();
                        bundle.putString("HK_Rdio_Album_Artist_Key", azjVar2.b());
                        bundle.putString("HK_Rdio_Playlist_Title", azjVar2.f());
                        bundle.putString("HK_Rdio_Playlist_User", azjVar2.c());
                        bundle.putString("HK_Rdio_Playlist_Track_Count", "Songs: " + azjVar2.d());
                        bundle.putString("HK_Rdio_Playlist_Artwork", azjVar2.a());
                        bundle.putStringArrayList("HK_Rdio_Playlist_Keys", azjVar2.e());
                        bundle.putInt("HK_Rdio_ListVC_Type", azu.b.EListTypePlaylists.a());
                        ajkVar = azuVar2;
                    } else {
                        ajkVar = null;
                    }
                    if (ajkVar != null) {
                        ajkVar.g(bundle);
                        if (ahn.a()) {
                            azv.this.e.q().a(ajkVar, new arc().c(R.id.rdio_menu_container));
                        } else {
                            azv.this.e.q().a(ajkVar, (arc) null);
                        }
                    }
                }
            });
        } catch (Exception e) {
        }
    }
}
