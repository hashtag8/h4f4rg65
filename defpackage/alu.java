package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alu extends amf<Object> {
    private String a;

    public static class a {
        public TextView a;
        public TextView b;
        public ImageView c;
        public ImageView d;
        public View e;
    }

    public alu(Context context, List<Object> list, String str) {
        super(context, list);
        this.a = null;
        this.a = str;
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof akg) {
            akg akgVar = (akg) item;
            if (view == null || view.getTag() == null) {
                view = this.d.inflate(R.layout.deezer_explore_album_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.a = (TextView) view.findViewById(R.id.text1);
                aVar2.b = (TextView) view.findViewById(R.id.text2);
                aVar2.c = (ImageView) view.findViewById(R.id.iv);
                aVar2.d = (ImageView) view.findViewById(R.id.img2);
                aVar2.e = view.findViewById(R.id.layout);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a.setText(akgVar.c());
            if (getItem(i) != null && akgVar.f() != null && !TextUtils.isEmpty(akgVar.f().b())) {
                aVar.b.setVisibility(0);
                aVar.b.setText(akgVar.f().b());
            } else {
                aVar.b.setVisibility(8);
            }
            new ahw().a(aVar.c, akgVar.e());
            aVar.c.setFocusable(false);
            if (!akgVar.h()) {
                if (akgVar.i() == null) {
                    mm.b("deezer", "grey " + akgVar.b() + akgVar.c());
                    aVar.e.setBackgroundColor(this.b.getResources().getColor(R.color.gray));
                    return view;
                }
                mm.b("deezer", "getAlternative " + akgVar.b() + akgVar.c());
                aVar.e.setBackgroundColor(Color.parseColor("#eeeeee"));
                return view;
            }
            aVar.e.setBackgroundColor(Color.parseColor("#eeeeee"));
            return view;
        }
        View viewInflate = this.d.inflate(R.layout.deezer_explore_album_title_item, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.album_title);
        if (((String) item).equalsIgnoreCase(this.b.getString(R.string.kDeezer_Albums_Str))) {
            return null;
        }
        textView.setText(a((String) item));
        return viewInflate;
    }

    private String a(String str) {
        return str.indexOf(" ") != -1 ? str : str + "S";
    }
}
