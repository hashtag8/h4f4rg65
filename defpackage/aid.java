package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class aid<T> extends BaseAdapter {
    protected Vector<T> a = null;
    protected Context b;
    protected LayoutInflater c;
    protected int d;
    protected a<T> e;

    public interface a<T> {
        View a(int i, View view, ViewGroup viewGroup, T t);
    }

    public aid(Context context, a<T> aVar, int i) {
        this.b = null;
        this.b = context;
        this.c = LayoutInflater.from(this.b);
        this.e = aVar;
        this.d = i;
    }

    public void a(List<T> list) throws Exception {
        if (list == null) {
            throw new Exception("CommonAdapter.setInitData()--->iniData =null");
        }
        this.a = new Vector<>();
        this.a.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = this.c.inflate(this.d, viewGroup, false);
        }
        return this.e.a(i, view, viewGroup, this.a.get(i));
    }
}
