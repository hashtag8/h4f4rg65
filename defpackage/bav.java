package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Station;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bav extends BaseAdapter {
    private Context b;
    private LayoutInflater c;
    private List<Station> a = null;
    private boolean d = false;

    public bav(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(this.b);
    }

    public void a(List<Station> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Station getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.c.inflate(R.layout.shoutcast_stationlistview_item_layout, (ViewGroup) null);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        final Station item = getItem(i);
        aVar.b.setText(item.musicName);
        if (this.d) {
            aVar.d.setVisibility(0);
            aVar.d.setText("" + (i + 1));
        } else {
            aVar.d.setVisibility(8);
        }
        new ahw().a(aVar.a, new ahq() { // from class: bav.1
            @Override // defpackage.ahq
            public void a(View view2) {
                bif.a(bav.this.b).a(item.album_art).a(R.drawable.shoutcast_logo).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
            }
        });
        aVar.c.setVisibility(8);
        return view;
    }

    class a {
        ImageView a;
        TextView b;
        ImageView c;
        TextView d;

        public a(View view) {
            this.a = (ImageView) view.findViewById(R.id.iv);
            this.b = (TextView) view.findViewById(R.id.listitem_textview);
            this.c = (ImageView) view.findViewById(R.id.listitem_imageview_hq);
            this.d = (TextView) view.findViewById(R.id.station_number);
        }
    }
}
