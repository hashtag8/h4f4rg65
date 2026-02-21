package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Genre;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bas extends BaseAdapter {
    private List<Genre> a = null;
    private Context b;
    private LayoutInflater c;

    public bas(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(this.b);
    }

    public void a(List<Genre> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    private int b(int i) {
        if (ahn.a()) {
            if (i % 8 == 1 || i % 8 == 3 || i % 8 == 4 || i % 8 == 6) {
                return this.b.getResources().getColor(R.color.Shoutcast_griditem_color2);
            }
            return this.b.getResources().getColor(R.color.Shoutcast_griditem_color1);
        }
        if (i % 4 == 1 || i % 4 == 2) {
            return this.b.getResources().getColor(R.color.Shoutcast_griditem_color2);
        }
        return this.b.getResources().getColor(R.color.Shoutcast_griditem_color1);
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
    public Genre getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.c.inflate(R.layout.shoutcast_home_listview_item, (ViewGroup) null);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        aVar.b.setText(getItem(i).getName());
        aVar.a.setBackgroundColor(b(i));
        return view;
    }

    class a {
        public RelativeLayout a;
        public TextView b;

        public a(View view) {
            this.a = (RelativeLayout) view.findViewById(R.id.item_layout);
            this.b = (TextView) view.findViewById(R.id.listitem_textview);
        }
    }
}
