package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class aqr implements View.OnClickListener {
    private Context a;

    protected abstract void a();

    protected abstract void a(int i);

    public aqr(Context context) {
        this.a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a();
        Object tag = view.getTag();
        if (tag instanceof MusicData) {
            final MusicData musicData = (MusicData) tag;
            arz arzVar = new arz(this.a);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.a.getString(R.string.PlayTip_PlayNow_Str).toUpperCase());
            arrayList.add(this.a.getString(R.string.PlayTip_PlayNext_Str).toUpperCase());
            arrayList.add(this.a.getString(R.string.PlayTip_AddSongToQueue_Str).toUpperCase());
            arrayList.add(this.a.getString(R.string.PlayTip_ClearAll_Str).toUpperCase());
            arzVar.a(arrayList);
            arzVar.a(this.a.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: aqr.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                            MusicPlaylistManager.a().a(musicData);
                            break;
                        case 1:
                            MusicPlaylistManager.a().c(musicData);
                            break;
                        case 2:
                            MusicPlaylistManager.a().d(musicData);
                            break;
                        case 3:
                            MusicPlaylistManager.a().g();
                            MusicPlaylistManager.a().b(musicData);
                            break;
                    }
                }
            });
            arzVar.show();
            return;
        }
        if (tag instanceof Cursor) {
            final Cursor cursor = (Cursor) tag;
            arz arzVar2 = new arz(this.a);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.a.getString(R.string.PlayTip_PlayNow_Str).toUpperCase());
            arrayList2.add(this.a.getString(R.string.PlayTip_PlayNext_Str).toUpperCase());
            arrayList2.add(this.a.getString(R.string.PlayTip_AddSongToQueue_Str).toUpperCase());
            arrayList2.add(this.a.getString(R.string.PlayTip_ClearAll_Str).toUpperCase());
            arzVar2.a(arrayList2);
            arzVar2.a(this.a.getString(R.string.PlayTip_Title_Str));
            arzVar2.a(new asi() { // from class: aqr.2
                @Override // defpackage.asi
                public void a(int i) {
                    if (aof.a().d().size() > 0) {
                        switch (i) {
                            case 0:
                                new aqg(1, cursor).execute(new String[0]);
                                break;
                            case 1:
                                new aqg(2, cursor).execute(new String[0]);
                                break;
                            case 2:
                                new aqg(3, cursor).execute(new String[0]);
                                break;
                            case 3:
                                new aqg(4, cursor).execute(new String[0]);
                                break;
                        }
                    }
                }
            });
            arzVar2.show();
            return;
        }
        arz arzVar3 = new arz(this.a);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(this.a.getString(R.string.PlayTip_PlayNow_Str).toUpperCase());
        arrayList3.add(this.a.getString(R.string.PlayTip_PlayNext_Str).toUpperCase());
        arrayList3.add(this.a.getString(R.string.PlayTip_AddSongToQueue_Str).toUpperCase());
        arrayList3.add(this.a.getString(R.string.PlayTip_ClearAll_Str).toUpperCase());
        arzVar3.a(arrayList3);
        arzVar3.a(this.a.getString(R.string.PlayTip_Title_Str));
        arzVar3.a(new asi() { // from class: aqr.3
            @Override // defpackage.asi
            public void a(int i) {
                switch (i) {
                    case 0:
                        aqr.this.a(1);
                        break;
                    case 1:
                        aqr.this.a(2);
                        break;
                    case 2:
                        aqr.this.a(3);
                        break;
                    case 3:
                        aqr.this.a(4);
                        break;
                }
            }
        });
        arzVar3.show();
    }
}
