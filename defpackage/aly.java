package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aly extends amf<akj> {

    public static class a {
        public TextView a;
        public TextView b;
        public ImageView c;
        public ImageView d;
    }

    public aly(Context context, List<akj> list, qi qiVar) {
        super(context, list);
        this.f = qiVar;
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_playlist_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (TextView) view.findViewById(R.id.text2);
            aVar.c = (ImageView) view.findViewById(R.id.iv);
            aVar.d = (ImageView) view.findViewById(R.id.img2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(getItem(i).f());
        if (getItem(i) == null || TextUtils.isEmpty(getItem(i).c())) {
            aVar.b.setVisibility(8);
        } else {
            aVar.b.setText(getItem(i).c() + R.string.kDeezer_tracks_Str);
            aVar.b.setVisibility(0);
        }
        new ahw().a(aVar.c, getItem(i).d());
        aVar.d.setVisibility(0);
        aVar.d.setOnClickListener(new View.OnClickListener() { // from class: aly.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                als.a(aly.this.b, new asi() { // from class: aly.1.1
                    @Override // defpackage.asi
                    public void a(int i2) {
                        if (aof.a().l()) {
                            Toast.makeText(aly.this.b, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                            return;
                        }
                        akj item = aly.this.getItem(i);
                        if (item != null) {
                            aly.this.a(item, i2);
                        }
                    }
                });
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(akj akjVar, final int i) {
        if (!ahh.e(this.b)) {
            Toast.makeText(this.b, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            agv.a(true).a("https://api.deezer.com/playlist/" + akjVar.e() + "/tracks?limit=100&index=0&access_token=" + this.f.b(), new aum() { // from class: aly.2
                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        List listA = new qv(akm.class).a(jSONObject.toString());
                        ArrayList arrayList = new ArrayList();
                        if (listA != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < listA.size()) {
                                    MusicData musicDataA = als.a((akm) listA.get(i4));
                                    musicDataA.queue_source = 1;
                                    arrayList.add(musicDataA);
                                    i3 = i4 + 1;
                                } else {
                                    als.b(arrayList, i);
                                    return;
                                }
                            }
                        }
                    }
                }

                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        if (jSONObject.optInt("code") == 300) {
                            Toast.makeText(aly.this.b, R.string.kDeezer_Error300_Str, 0).show();
                        }
                        new ErrorInfo.a().a(th).a(jSONObject.toString()).a();
                    }
                }
            });
        }
    }
}
