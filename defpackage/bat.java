package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.musicservice.shoutcast.model.Genre;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bat extends BaseAdapter {
    private List<Genre> a = null;
    private Context b;
    private LayoutInflater c;

    public bat(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(this.b);
    }

    public void a(List<Genre> list) {
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
            view = this.c.inflate(R.layout.shoutcast_subgenre_listviewitem, (ViewGroup) null);
            view.setTag(new a(view));
        }
        ((a) view.getTag()).a.setText(getItem(i).getName());
        return view;
    }

    class a {
        public TextView a;

        public a(View view) {
            this.a = (TextView) view.findViewById(R.id.listitem_textview);
        }
    }
}
