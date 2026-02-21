package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alv extends amf<akh> {

    public static class a {
        public TextView a;
        public ImageView b;
    }

    public alv(Context context, List<akh> list) {
        super(context, list);
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_artist_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (ImageView) view.findViewById(R.id.iv);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(getItem(i).b());
        bif.a(this.b).a(getItem(i).c()).a(R.drawable.default_artist).a(aVar.b);
        aVar.b.setFocusable(false);
        return view;
    }
}
