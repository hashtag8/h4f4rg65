package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avi extends BaseAdapter {
    private LayoutInflater a;
    private List<MusicData> b;
    private Context c;
    private boolean d;
    private a e;
    private Object f = new Object();
    private GridView g;

    public interface a {
        void a();
    }

    public avi(Context context, List<MusicData> list, a aVar, GridView gridView) {
        this.d = true;
        this.a = LayoutInflater.from(context);
        this.b = list;
        this.g = gridView;
        this.c = context;
        this.d = true;
        this.e = aVar;
    }

    public void a(int i, int i2) {
        if (i < i2 - 1) {
            this.d = true;
        } else {
            this.d = false;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.d ? this.b.size() + 1 : this.b.size();
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
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (i == this.b.size()) {
            view = this.a.inflate(R.layout.harman_album_list_loadin, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            view.setTag(null);
            synchronized (this.f) {
                this.e.a();
            }
        } else {
            if (view == null || view.getTag() == null) {
                view = this.a.inflate(R.layout.dashboard_gridview_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.tv);
                bVar2.c = (TextView) view.findViewById(R.id.art);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            a(i, bVar);
        }
        return view;
    }

    public void a(int i, b bVar) {
        if (this.b != null) {
            MusicData musicData = this.b.get(i);
            bVar.b.setTypeface(ahu.a(this.c));
            bVar.c.setTypeface(ahu.a(this.c));
            bVar.b.setText(musicData.getTitle());
            bVar.c.setText(musicData.artist + " - " + musicData.album);
            if (musicData.getIconUrl() != "") {
                bif.a(this.c).a(musicData.getIconUrl()).a(R.drawable.empty_no_cover_art).a(bVar.a);
            }
        }
    }

    public void a(List<MusicData> list) {
        if (list != null) {
            if (this.b == null) {
                this.b = list;
            } else {
                this.b.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.clear();
            notifyDataSetChanged();
        }
    }

    static class b {
        ImageView a;
        TextView b;
        TextView c;

        b() {
        }
    }
}
