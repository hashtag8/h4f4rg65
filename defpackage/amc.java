package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amc extends amf<akm> {
    private boolean a;
    private ProgressDialog g;
    private Handler h;

    public static class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public ImageView e;
        public ImageView f;
        public View g;
    }

    public amc(Context context, List<akm> list) {
        super(context, list);
        this.a = false;
        this.h = new Handler() { // from class: amc.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                amc.this.a();
            }
        };
        if (als.c == null || als.c.isEmpty()) {
            b();
        }
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_explore_track_with_image_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (TextView) view.findViewById(R.id.text2);
            aVar.c = (TextView) view.findViewById(R.id.text21);
            aVar.e = (ImageView) view.findViewById(R.id.img2);
            aVar.d = (ImageView) view.findViewById(R.id.img1);
            aVar.f = (ImageView) view.findViewById(R.id.iv);
            aVar.g = view.findViewById(R.id.layout);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (getItem(i).f()) {
            aVar.g.setBackgroundColor(Color.parseColor("#eeeeee"));
        } else {
            aVar.g.setBackgroundColor(this.b.getResources().getColor(R.color.gray));
        }
        aVar.a.setText(getItem(i).b());
        aVar.b.setText(getItem(i).d().b());
        aVar.c.setText(a(i + 1));
        new ahw().a(aVar.f, getItem(i).e().d());
        aVar.e.setOnClickListener(new View.OnClickListener() { // from class: amc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (amc.this.getItem(i).f()) {
                    amc.this.a(amc.this.getItem(i), amc.this.a(amc.this.getItem(i), als.c));
                } else {
                    Toast.makeText(amc.this.b, R.string.kDeezer_No_Available_Str, 1).show();
                }
            }
        });
        aVar.e.setVisibility(0);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(akm akmVar, List<akm> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (akm akmVar2 : list) {
            if (akmVar2 != null && akmVar2.a() == akmVar.a()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final akm akmVar, final boolean z) {
        arz arzVar = new arz(this.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b.getString(R.string.PlayTip_PlayNow_Str));
        arrayList.add(this.b.getString(R.string.PlayTip_PlayNext_Str));
        arrayList.add(this.b.getString(R.string.PlayTip_AddSongToQueue_Str));
        arrayList.add(this.b.getString(R.string.PlayTip_ClearAll_Str));
        if (z) {
            arrayList.add(this.b.getString(R.string.kDeezer_Delete_from_your_Deezer_library));
        } else {
            arrayList.add(this.b.getString(R.string.kDeezer_Add_to_your_Deezer_library));
        }
        arzVar.a(arrayList);
        arzVar.a(this.b.getString(R.string.PlayTip_Title_Str));
        arzVar.a(new asi() { // from class: amc.2
            @Override // defpackage.asi
            public void a(int i) {
                if (aof.a().l()) {
                    Toast.makeText(amc.this.b, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                }
                MusicData musicDataA = als.a(akmVar);
                switch (i) {
                    case 0:
                        MusicPlaylistManager.a().a(musicDataA);
                        break;
                    case 1:
                        MusicPlaylistManager.a().c(musicDataA);
                        break;
                    case 2:
                        MusicPlaylistManager.a().d(musicDataA);
                        break;
                    case 3:
                        MusicPlaylistManager.a().g();
                        MusicPlaylistManager.a().b(musicDataA);
                        break;
                    case 4:
                        if (z) {
                            amc.this.b(akmVar);
                        } else {
                            amc.this.a(akmVar);
                        }
                        break;
                }
            }
        });
        arzVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final akm akmVar) {
        if (!ahh.e(this.b)) {
            Toast.makeText(this.b, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("track_id", akmVar.a() + "");
        ausVar.a("access_token", aho.d("access_token"));
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/tracks", new Object[0]);
        if (als.c == null) {
            als.c = new ArrayList();
        }
        als.c.add(akmVar);
        aueVarA.b(this.b, "https://api.deezer.com/user/me/tracks", ausVar, new aux() { // from class: amc.3
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                if (als.c == null) {
                    als.c = new ArrayList();
                }
                als.c.remove(akmVar);
                Toast.makeText(amc.this.b, R.string.UnableAddAlbumLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                amc.this.b.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final akm akmVar) {
        if (!ahh.e(this.b)) {
            Toast.makeText(this.b, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        aus ausVar = new aus();
        ausVar.a("track_id", akmVar.a() + "");
        ausVar.a("access_token", aho.d("access_token"));
        aue aueVarA = agv.a(true);
        mm.b("https://api.deezer.com/user/me/tracks", new Object[0]);
        if (als.c != null && !als.c.isEmpty()) {
            als.c.remove(akmVar);
        }
        if (this.a && this.c != null && !this.c.isEmpty()) {
            this.c.remove(akmVar);
            notifyDataSetChanged();
        }
        aueVarA.a(this.b, "https://api.deezer.com/user/me/tracks", (Header[]) null, ausVar, new aux() { // from class: amc.4
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {", new Object[0]);
                if (als.c != null && !als.c.isEmpty()) {
                    als.c.add(akmVar);
                }
                if (amc.this.a && amc.this.c != null && !amc.this.c.isEmpty()) {
                    amc.this.c.add(akmVar);
                    amc.this.notifyDataSetChanged();
                }
                Toast.makeText(amc.this.b, R.string.UnableRemoveAlbumsLibrary, 0).show();
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.b("onSuccess() statusCode = " + i + ", String = " + str, new Object[0]);
                amc.this.b.sendStickyBroadcast(new Intent(alk.e));
            }
        });
    }

    private String a(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    private void b() {
        String str = "https://api.deezer.com/user/me/tracks?limit=2147483647&access_token=" + aho.d("access_token");
        aue aueVarA = agv.a(true);
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: amc.5
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                    als.c = new qv(akm.class).a(jSONObject.toString());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                als.c = null;
            }
        });
    }

    public void a() {
        if (this.g != null && this.g.isShowing()) {
            this.g.dismiss();
            this.g = null;
        }
    }
}
