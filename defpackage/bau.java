package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Station;
import defpackage.bif;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bau extends BaseAdapter {
    private List<Station> a = null;
    private Context b;
    private LayoutInflater c;
    private Drawable d;

    public bau(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(this.b);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.shoutcast_image_placeholder);
        int dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R.dimen.shoutcast_tableview_item_size);
        this.d = new bbg(Bitmap.createScaledBitmap(bitmapDecodeResource, dimensionPixelOffset, dimensionPixelOffset, false), this.b.getResources().getDimensionPixelSize(R.dimen.shoutcast_recommendation_corner_radius), 0);
    }

    public void a(List<Station> list) {
        this.a = list;
        notifyDataSetChanged();
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
            view = this.c.inflate(R.layout.shoutcast_tableview_item_layout, (ViewGroup) null);
            view.setTag(new a(view));
        }
        final a aVar = (a) view.getTag();
        Station item = getItem(i);
        aVar.c.setText(item.musicName);
        aVar.d.setText(item.currenttrack);
        bip bipVar = new bip() { // from class: bau.1
            @Override // defpackage.bip
            public void a(Bitmap bitmap, bif.d dVar) {
                if (aVar.a.getTag() == this) {
                    aVar.a.setImageDrawable(new bbg(bitmap, bau.this.b.getResources().getDimensionPixelSize(R.dimen.shoutcast_recommendation_corner_radius), 0));
                }
            }

            @Override // defpackage.bip
            public void a(Drawable drawable) {
            }

            @Override // defpackage.bip
            public void b(Drawable drawable) {
                aVar.a.setImageDrawable(bau.this.d);
            }
        };
        aVar.a.setTag(bipVar);
        bif.a(this.b).a(item.album_art).c().a(R.dimen.shoutcast_tableview_item_size, R.dimen.shoutcast_tableview_item_size).a(R.drawable.shoutcast_image_placeholder).a(bipVar);
        if (item.bitrate >= 256) {
            aVar.b.setVisibility(0);
        } else {
            aVar.b.setVisibility(8);
        }
        return view;
    }

    class a {
        public ImageView a;
        public ImageView b;
        public TextView c;
        public TextView d;

        public a(View view) {
            this.a = (ImageView) view.findViewById(R.id.iv);
            this.b = (ImageView) view.findViewById(R.id.shoutcast_tableview_hq);
            this.c = (TextView) view.findViewById(R.id.station_grid_top_label);
            this.d = (TextView) view.findViewById(R.id.shoutcast_station_gridview_bottom_label);
        }
    }
}
