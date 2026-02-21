package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class avk extends BaseAdapter {
    public ArrayList<bjn> a;
    private LayoutInflater b;
    private Context c;

    public avk(Context context, ArrayList<bjn> arrayList) {
        this.b = LayoutInflater.from(context);
        this.a = arrayList;
        this.c = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a != null) {
            return this.a.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(ArrayList<bjn> arrayList) {
        this.a = arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.b.inflate(R.layout.server_gridview_item, (ViewGroup) null);
            aVar = new a();
            aVar.b = (TextView) view.findViewById(R.id.tv2);
            aVar.c = (TextView) view.findViewById(R.id.manufacturerName);
            aVar.a = (ImageView) view.findViewById(R.id.iv2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.a != null) {
            bjn bjnVar = this.a.get(i);
            aVar.b.setVisibility(0);
            aVar.b.setText(bjnVar.a());
            aVar.c.setText(bjnVar.d());
            try {
                bif.a(this.c).a(bjnVar.h()).a(R.drawable.server_bluestate_icon).b(150, 150).e().a(aVar.a);
            } catch (Exception e) {
                bkx.a(Log.getStackTraceString(e));
                aVar.a.setImageResource(R.drawable.empty_no_cover_art);
            }
        }
        return view;
    }

    static class a {
        ImageView a;
        TextView b;
        TextView c;

        a() {
        }
    }
}
