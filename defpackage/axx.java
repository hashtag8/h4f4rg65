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
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class axx<T> extends BaseAdapter implements Filterable {
    public boolean a;
    protected int b;
    protected Context d;
    protected LayoutInflater e;
    protected int f;
    protected int g;
    protected a<T> h;
    protected Vector<T> c = null;
    protected int i = 0;
    protected Object j = new Object();

    @SuppressLint({"HandlerLeak"})
    Handler k = new Handler() { // from class: axx.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                List list = (List) message.obj;
                if (list != null) {
                    if (list.size() < axx.this.b) {
                        axx.this.a = false;
                    } else {
                        axx.this.a = true;
                    }
                    if (axx.this.c == null) {
                        axx.this.c = new Vector<>();
                    }
                    axx.this.c.addAll(list);
                    axx.this.i++;
                } else {
                    axx.this.a = false;
                }
                axx.this.notifyDataSetChanged();
            }
        }
    };

    public interface a<T> {
        View a(int i, View view, ViewGroup viewGroup, T t);

        void a(int i, int i2);
    }

    public axx(Context context, a<T> aVar, int i, int i2, int i3) {
        this.a = true;
        this.d = null;
        this.d = context;
        this.e = LayoutInflater.from(this.d);
        this.h = aVar;
        this.b = i;
        this.f = i2;
        this.g = i3;
        this.a = true;
    }

    public void a(List<T> list) throws Exception {
        if (list == null) {
            throw new Exception("MixRadioArtistsPageAdapter.setInitData()--->iniData =null");
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
        return this.c.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == this.c.size()) {
            View viewInflate = this.e.inflate(this.g, viewGroup, false);
            viewInflate.setTag(null);
            synchronized (this.j) {
                this.h.a(this.i, this.b);
            }
            return viewInflate;
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
        this.k.sendMessage(message);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: axx.2
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
