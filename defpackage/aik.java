package defpackage;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class aik extends BaseAdapter {
    public final ArrayAdapter<String> b;
    public Context c;
    private ajm d;
    public final Map<String, Adapter> a = new LinkedHashMap();
    private DataSetObserver e = new DataSetObserver() { // from class: aik.2
        @Override // android.database.DataSetObserver
        public void onChanged() {
            aik.this.notifyDataSetChanged();
        }
    };

    public aik(Context context, int i) {
        this.c = context;
        this.b = new ArrayAdapter<>(context, i);
    }

    public aik(Context context, int i, int i2, ajm ajmVar) {
        this.c = context;
        this.b = new ArrayAdapter<>(context, i, i2);
        this.d = ajmVar;
    }

    public void a(String str, Adapter adapter) {
        this.b.add(str);
        this.a.put(str, adapter);
        adapter.registerDataSetObserver(this.e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        for (String str : this.a.keySet()) {
            Adapter adapter = this.a.get(str);
            int count = adapter.getCount() + 1;
            if (i == 0) {
                return str;
            }
            if (i < count) {
                return adapter.getItem(i - 1);
            }
            i -= count;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int count = 0;
        Iterator<Adapter> it = this.a.values().iterator();
        while (true) {
            int i = count;
            if (it.hasNext()) {
                count = it.next().getCount() + 1 + i;
            } else {
                return i;
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int viewTypeCount = 1;
        Iterator<Adapter> it = this.a.values().iterator();
        while (true) {
            int i = viewTypeCount;
            if (it.hasNext()) {
                viewTypeCount = it.next().getViewTypeCount() + i;
            } else {
                return i;
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int viewTypeCount = 1;
        Iterator<String> it = this.a.keySet().iterator();
        while (true) {
            int i2 = viewTypeCount;
            if (it.hasNext()) {
                Adapter adapter = this.a.get(it.next());
                int count = adapter.getCount() + 1;
                if (i == 0) {
                    return 0;
                }
                if (i < count) {
                    return adapter.getItemViewType(i - 1) + i2;
                }
                i -= count;
                viewTypeCount = adapter.getViewTypeCount() + i2;
            } else {
                return -1;
            }
        }
    }

    public int a(int i) {
        Iterator<String> it = this.a.keySet().iterator();
        while (it.hasNext()) {
            int count = this.a.get(it.next()).getCount() + 1;
            if (i == 0) {
                return 0;
            }
            if (i < count) {
                return i - 1;
            }
            i -= count;
        }
        return -1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) != 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return getCount() == 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Iterator<String> it = this.a.keySet().iterator();
        final int i2 = 0;
        while (it.hasNext()) {
            Adapter adapter = this.a.get(it.next());
            int count = adapter.getCount() + 1;
            if (i == 0) {
                String item = this.b.getItem(i2);
                View view2 = this.b.getView(i2, view, viewGroup);
                if (adapter.getCount() == 0 || item.equals("")) {
                    view2.setVisibility(8);
                    view2.getLayoutParams().height = 1;
                } else {
                    view2.setVisibility(0);
                    view2.getLayoutParams().height = ahn.a(HarmanApplication.a(), 40.0f);
                    view2.setOnClickListener(new View.OnClickListener() { // from class: aik.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            if (aik.this.d != null) {
                                aik.this.d.e(i2);
                            }
                        }
                    });
                }
                return view2;
            }
            if (i < count) {
                return adapter.getView(i - 1, view, viewGroup);
            }
            i -= count;
            i2++;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public ajm a() {
        return this.d;
    }
}
