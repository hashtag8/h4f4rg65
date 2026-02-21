package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class aic<T> extends BaseAdapter implements Filterable {
    public static boolean k = false;
    public static boolean l = true;
    public boolean a;
    protected int b;
    protected Vector<T> c;
    protected Context d;
    protected LayoutInflater e;
    protected int f;
    protected int g;
    protected a<T> h;
    protected int i;
    protected Object j;

    @SuppressLint({"HandlerLeak"})
    Handler m;
    private int n;
    private View o;
    private boolean p;

    public interface a<T> {
        View a(int i, View view, ViewGroup viewGroup, T t);

        void a(int i, int i2);
    }

    public aic(Context context, a<T> aVar, int i, int i2, int i3, boolean z) {
        this.a = true;
        this.c = null;
        this.d = null;
        this.i = 0;
        this.j = new Object();
        this.o = null;
        this.p = true;
        this.m = new Handler() { // from class: aic.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    List list = (List) message.obj;
                    if (aic.this.n >= aic.this.c.size()) {
                        if (list != null) {
                            if (list.size() < aic.this.b) {
                                aic.this.a = false;
                            } else {
                                aic.this.a = true;
                            }
                            aic.this.c.addAll(list);
                            aic.this.i++;
                        } else {
                            aic.this.a = false;
                        }
                        aic.this.notifyDataSetChanged();
                    }
                }
            }
        };
        this.d = context;
        this.e = LayoutInflater.from(this.d);
        this.h = aVar;
        this.b = i;
        this.f = i2;
        this.g = i3;
        this.a = true;
        this.o = this.e.inflate(this.g, (ViewGroup) null);
        this.p = z;
    }

    public aic(Context context, a<T> aVar, int i, int i2, int i3) {
        this(context, aVar, i, i2, i3, true);
    }

    public void a(List<T> list) {
        if (list == null) {
            new ml().a("BRIGHTPageAdapter.setInitData()--->initData =null");
            list = new ArrayList<>();
        }
        this.c = new Vector<>();
        this.c.addAll(list);
        this.i++;
        if (list.size() < this.b) {
            this.a = false;
        } else {
            this.a = true;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        if (this.a && this.p) {
            return this.c.size() + 1;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    public void a() {
        this.a = false;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == this.c.size()) {
            View view2 = this.o;
            view2.setTag(null);
            synchronized (this.j) {
                this.h.a(this.i, this.b);
            }
            this.n = i;
            return view2;
        }
        if (view == null || view.getTag() == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        return this.h.a(i, view, viewGroup, this.c.get(i));
    }

    public void b(List<T> list) {
        Message message = new Message();
        message.obj = list;
        message.what = 11;
        this.m.sendMessage(message);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: aic.2
            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                return null;
            }
        };
    }
}
