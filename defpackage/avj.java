package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avj extends BaseAdapter {
    private LayoutInflater a;
    private Context c;
    private List<MusicData> b = new ArrayList();
    private String[] d = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private HashMap<String, Integer> e = new HashMap<>();

    public avj(Context context, List<MusicData> list) {
        this.a = LayoutInflater.from(context);
        this.b.addAll(list);
        this.c = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b != null) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.a.inflate(R.layout.dashboard_listview_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.a = (ImageView) view.findViewById(R.id.iv);
            aVar2.b = (TextView) view.findViewById(R.id.song);
            aVar2.c = (TextView) view.findViewById(R.id.album);
            aVar2.d = (ImageView) view.findViewById(R.id.iv_more);
            int color = Color.parseColor("#000000");
            aVar2.d.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)), PorterDuff.Mode.MULTIPLY);
            aVar2.b.setTypeface(ahu.a(this.c));
            aVar2.c.setTypeface(ahu.a(this.c));
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, i);
        return view;
    }

    private void a(a aVar, int i) {
        if (this.b != null) {
            MusicData musicData = this.b.get(i);
            if (musicData != null && musicData.getObjectClass() != null) {
                if (!musicData.getObjectClass().startsWith("object.container") && musicData.getObjectClass().startsWith("object.item.audioItem")) {
                    aVar.d.setVisibility(0);
                } else {
                    aVar.d.setVisibility(8);
                }
            }
            aVar.d.setTag(musicData);
            aVar.d.setOnClickListener(new aqr(this.c) { // from class: avj.1
                @Override // defpackage.aqr
                protected void a() {
                }

                @Override // defpackage.aqr
                protected void a(int i2) {
                }
            });
            aVar.b.setText(musicData.getTitle());
            if (bru.b(musicData.artist) && bru.b(musicData.album)) {
                aVar.c.setVisibility(0);
                aVar.c.setText(musicData.artist + " - " + musicData.album);
            } else {
                aVar.c.setVisibility(8);
            }
            if (musicData.getIconUrl() != "") {
                bif.a(this.c).a(musicData.getIconUrl()).a(R.drawable.song_icon).a(aVar.a);
            } else {
                aVar.a.setImageResource(R.drawable.song_icon);
            }
        }
    }

    public void a(List<MusicData> list, boolean z) {
        if (this.b == null) {
            this.b = list;
        } else {
            if (z) {
                this.b.clear();
            }
            if (list != null) {
                this.b.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    static class a {
        ImageView a;
        TextView b;
        TextView c;
        ImageView d;

        a() {
        }
    }
}
