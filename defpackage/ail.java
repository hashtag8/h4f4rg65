package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ail extends BaseAdapter {
    private Context a;
    private List<String> b;
    private List<Integer> c;
    private LayoutInflater d;
    private String e = "";

    public static class a {
        public ImageView a;
        public TextView b;
    }

    public ail(Context context, List<String> list, List<Integer> list2) {
        this.a = context;
        this.b = list;
        this.c = list2;
        this.d = LayoutInflater.from(this.a);
    }

    public void a(String str) {
        this.e = str;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.fragment_productlist_networkitem, (ViewGroup) null);
            aVar = new a();
            aVar.a = (ImageView) view.findViewById(R.id.network_signal_icon);
            aVar.b = (TextView) view.findViewById(R.id.network_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i < this.b.size()) {
            aVar.b.setText(this.b.get(i));
            aVar.a.setImageResource(b(this.c.get(i).intValue()));
        } else {
            aVar.b.setText(R.string.wifisetup_other_dialog_other);
        }
        return view;
    }

    public int b(int i) {
        if (i < -90) {
            return R.drawable.setupspeaker_wifisignal5;
        }
        if (i < -70 && i >= -90) {
            return R.drawable.setupspeaker_wifisignal4;
        }
        if (i < -50 && i >= -70) {
            return R.drawable.setupspeaker_wifisignal3;
        }
        if (i < -30 && i >= -50) {
            return R.drawable.setupspeaker_wifisignal2;
        }
        return R.drawable.setupspeaker_wifisignal1;
    }
}
