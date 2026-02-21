package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import defpackage.alt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aqx extends amf<afr> {
    public aqx(Context context, List<afr> list) {
        super(context, list);
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        alt.a aVar;
        afr item = getItem(i);
        if (item instanceof afs) {
            View viewInflate = this.d.inflate(R.layout.search_result_title_item, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.title)).setText(((afs) item).a());
            return viewInflate;
        }
        if (!(item instanceof CatalogDataInf) && !(item instanceof MusicData)) {
            return null;
        }
        if (view == null || view.getTag() == null) {
            view = this.d.inflate(R.layout.search_result_content_item, (ViewGroup) null);
            alt.a aVar2 = new alt.a();
            aVar2.a = (TextView) view.findViewById(R.id.text1);
            aVar2.b = (TextView) view.findViewById(R.id.text2);
            aVar2.c = (ImageView) view.findViewById(R.id.img1);
            aVar2.d = (ImageView) view.findViewById(R.id.img2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (alt.a) view.getTag();
        }
        bif.a(this.b).a(item.getPictureUri()).a(R.drawable.empty_cover_art_small).a(aVar.c);
        if (item instanceof ArtistData) {
            aVar.a.setText(((ArtistData) item).j);
            aVar.b.setVisibility(8);
            aVar.d.setVisibility(8);
            return view;
        }
        if (item instanceof AlbumData) {
            AlbumData albumData = (AlbumData) item;
            aVar.a.setText(albumData.j);
            aVar.b.setVisibility(0);
            aVar.b.setText(albumData.m);
            aVar.d.setVisibility(8);
            return view;
        }
        if (item instanceof MusicData) {
            final MusicData musicData = (MusicData) item;
            aVar.a.setText(musicData.musicName);
            aVar.b.setVisibility(0);
            aVar.b.setText(musicData.artist + " - " + musicData.album);
            aVar.d.setVisibility(0);
            aVar.d.setOnClickListener(new View.OnClickListener() { // from class: aqx.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    arz arzVar = new arz(aqx.this.b);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aqx.this.b.getString(R.string.PlayTip_PlayNow_Str));
                    arrayList.add(aqx.this.b.getString(R.string.PlayTip_PlayNext_Str));
                    arrayList.add(aqx.this.b.getString(R.string.PlayTip_AddSongToQueue_Str));
                    arrayList.add(aqx.this.b.getString(R.string.PlayTip_ClearAll_Str));
                    arzVar.a(arrayList);
                    arzVar.a(aqx.this.b.getString(R.string.PlayTip_Title_Str));
                    arzVar.a(new asi() { // from class: aqx.1.1
                        @Override // defpackage.asi
                        public void a(int i2) {
                            switch (i2) {
                                case 0:
                                    aqx.this.a(musicData);
                                    break;
                                case 1:
                                    aqx.this.b(musicData);
                                    break;
                                case 2:
                                    aqx.this.c(musicData);
                                    break;
                                case 3:
                                    aqx.this.d(musicData);
                                    break;
                            }
                        }
                    });
                    arzVar.show();
                }
            });
            return view;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MusicData musicData) {
        MusicPlaylistManager.a().a(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MusicData musicData) {
        MusicPlaylistManager.a().c(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MusicData musicData) {
        MusicPlaylistManager.a().d(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MusicData musicData) {
        MusicPlaylistManager.a().g();
        MusicPlaylistManager.a().b(musicData);
    }
}
