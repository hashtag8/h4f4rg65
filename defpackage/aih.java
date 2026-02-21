package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class aih<T> extends BaseAdapter implements SectionIndexer {
    public boolean a;
    protected int b;
    protected Vector<T> c;
    protected HashMap<String, Integer> d;
    protected Context e;
    protected LayoutInflater f;
    protected int g;
    protected int h;
    protected a<T> i;
    protected int j;
    protected final Object k;
    private String[] l;
    private int m;
    private int n;
    private boolean o;

    @SuppressLint({"HandlerLeak"})
    private Handler p;

    public interface a<T> {
        View a(int i, View view, ViewGroup viewGroup, T t);

        void a(int i, int i2);
    }

    public aih(Context context, a<T> aVar, int i, int i2, int i3, int i4) {
        this.a = true;
        this.c = null;
        this.d = new HashMap<>();
        this.e = null;
        this.j = 0;
        this.k = new Object();
        this.l = new String[]{"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.m = 0;
        this.n = R.color.black;
        this.o = false;
        this.p = new Handler() { // from class: aih.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    Collection<? extends T> collection = (Collection) message.obj;
                    if (aih.this.c != null && aih.this.m >= aih.this.c.size()) {
                        if (collection != null) {
                            if (!aih.this.o) {
                                aih.this.a = collection.size() >= aih.this.b;
                            } else {
                                aih.this.a = false;
                            }
                            if (aih.this.c != null) {
                                aih.this.c.addAll(collection);
                                aih.this.j++;
                            } else {
                                return;
                            }
                        } else {
                            aih.this.a = false;
                        }
                        aih.this.notifyDataSetChanged();
                    }
                }
            }
        };
        this.e = context;
        this.f = LayoutInflater.from(this.e);
        this.i = aVar;
        this.b = i;
        this.g = i2;
        this.h = i3;
        this.a = true;
        this.n = i4;
        this.o = false;
    }

    public aih(Context context, a<T> aVar, int i, int i2, int i3) {
        this(context, aVar, i, i2, i3, R.color.black);
    }

    public void a(Collection<T> collection) {
        if (collection == null) {
            new ml().a("NextPageAdapter cannot be handed null initData!");
            collection = new ArrayList<>();
        }
        this.c = new Vector<>();
        this.c.addAll(collection);
        if (!this.c.isEmpty() && (this.c.get(0) instanceof CatalogDataInf)) {
            for (int i = 0; i < this.c.size(); i++) {
                String upperCase = ((CatalogDataInf) this.c.get(i)).j.substring(0, 1).toUpperCase();
                if (!this.d.containsKey(upperCase)) {
                    this.d.put(upperCase, Integer.valueOf(i));
                }
            }
        }
        this.j++;
        if (!this.o) {
            this.a = collection.size() >= this.b;
        } else {
            this.a = false;
        }
    }

    public void a(boolean z) {
        this.o = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c != null) {
            return this.a ? this.c.size() + 1 : this.c.size();
        }
        return 0;
    }

    public void a() {
        this.j = 0;
        c();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    public List<T> b() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        if (this.c != null && i == this.c.size()) {
            View viewInflate = this.f.inflate(this.h, viewGroup, false);
            viewInflate.setTag(null);
            if ((viewGroup instanceof GridView) && viewInflate.findViewById(R.id.loading_spinner_holder) != null) {
                viewInflate.setLayoutParams(new AbsListView.LayoutParams(viewGroup.getWidth(), -1));
                new ahw().a(viewInflate, new ahq() { // from class: aih.1
                    @Override // defpackage.ahq
                    public void a(View view2) {
                        int width = viewGroup.getWidth();
                        view2.findViewById(R.id.loading_spinner_holder).setX(((width / 2) - view2.getLeft()) - (r1.getWidth() / 2));
                    }
                });
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.tips);
            if (textView != null) {
                textView.setTextColor(this.e.getResources().getColor(this.n));
            }
            synchronized (this.k) {
                this.i.a(this.j, this.b);
            }
            this.m = i;
            return viewInflate;
        }
        if (view == null || view.getTag() == null) {
            view = this.f.inflate(this.g, viewGroup, false);
        }
        if (this.c != null) {
            return this.i.a(i, view, viewGroup, this.c.get(i));
        }
        return view;
    }

    public void b(Collection<T> collection) {
        Message message = new Message();
        message.obj = collection;
        message.what = 11;
        this.p.sendMessage(message);
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.l;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        while (i >= 0) {
            if (!this.d.containsKey(this.l[i])) {
                i--;
            } else {
                return this.d.get(this.l[i]).intValue();
            }
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    public void c() {
        if (this.c != null) {
            this.c.clear();
        }
        notifyDataSetChanged();
    }
}
