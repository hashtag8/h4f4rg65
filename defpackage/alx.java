package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alx extends amf<aki> {
    private int a;

    public static class a {
        public TextView a;
    }

    public alx(Context context, List<aki> list) {
        super(context, list);
        this.a = 0;
    }

    public void a(int i) {
        this.a = i;
        notifyDataSetChanged();
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_explore_genre_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(getItem(i).b());
        if (i == this.a) {
            aVar.a.setTextColor(Color.parseColor("#0c79b9"));
            aVar.a.setBackgroundColor(Color.parseColor("#CCEBFF"));
        } else {
            aVar.a.setTextColor(Color.parseColor("#000000"));
            aVar.a.setBackgroundColor(Color.parseColor("#eeeeee"));
        }
        return view;
    }
}
