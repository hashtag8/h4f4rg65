package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ama extends amf<akk> {

    public static class a {
        public TextView a;
        public TextView b;
        public ImageView c;
        public ImageView d;
    }

    public ama(Context context, List<akk> list) {
        super(context, list);
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_explore_radio_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (TextView) view.findViewById(R.id.text2);
            aVar.c = (ImageView) view.findViewById(R.id.iv);
            aVar.d = (ImageView) view.findViewById(R.id.img2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(getItem(i).c());
        aVar.b.setVisibility(8);
        new ahw().a(aVar.c, getItem(i).a());
        aVar.c.setFocusable(false);
        return view;
    }
}
