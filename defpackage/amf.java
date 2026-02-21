package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class amf<T> extends BaseAdapter {
    protected Context b;
    protected List<T> c;
    protected LayoutInflater d;
    protected int e = -1;
    protected qi f;

    public amf(Context context, List<T> list) {
        this.b = context;
        this.c = list;
        this.d = LayoutInflater.from(context);
    }

    public void a(List<T> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.isEmpty()) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        if (this.c == null || this.c.isEmpty() || i >= this.c.size() || i < 0) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
