package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.SpotifyMoreInfoActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aqs extends amf<Object> {
    protected DashboardActivity a;
    private final Context g;

    public aqs(Context context, List<Object> list) {
        super(context, list);
        this.g = context;
        this.a = (DashboardActivity) context;
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof String) {
            TextView textView = new TextView(this.g);
            textView.setTypeface(ahu.a(this.b));
            textView.setText((String) item);
            textView.setTextAppearance(this.g, R.style.font_gray_14);
            int iA = ahn.a(this.g, 15.0f);
            textView.setPadding(iA, iA, iA, iA);
            textView.setOnClickListener(new View.OnClickListener() { // from class: aqs.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!aqs.this.g.getResources().getString(R.string.SettingMoreApps_Str).equalsIgnoreCase("" + ((Object) ((TextView) view2).getText()))) {
                        aqs.this.g.startActivity(new Intent(aqs.this.g, (Class<?>) SpotifyMoreInfoActivity.class));
                        return;
                    }
                    Uri uri = Uri.parse("https://www.google.com/cast/apps/#?speakers");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    aqs.this.g.startActivity(intent);
                }
            });
            return textView;
        }
        if (item instanceof aqm) {
            View viewInflate = this.d.inflate(R.layout.music_googlecast_item, (ViewGroup) null);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.name);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.smartphone);
            aqm aqmVar = (aqm) item;
            textView2.setText(aqmVar.d());
            imageView.setImageResource(aqmVar.a());
            imageView2.setVisibility(aqmVar.b() ? 0 : 4);
            return viewInflate;
        }
        if (!(item instanceof avb)) {
            return null;
        }
        if (view == null || view.getTag() == null) {
            view = this.d.inflate(R.layout.music_source_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.a = (TextView) view.findViewById(R.id.name);
            aVar2.c = view.findViewById(R.id.selected_side_view);
            aVar2.b = (ImageView) view.findViewById(R.id.icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        avb avbVar = (avb) item;
        ave aveVarH = avbVar.h();
        aVar.a.setText(aveVarH.g());
        aVar.b.setImageResource(aveVarH.e());
        if (brs.a((Object) Integer.valueOf(avbVar.f()), (Object) this.a.q().e())) {
            aVar.c.setVisibility(0);
            aVar.a.setTextAppearance(this.a, R.style.font_white_18_alpha80_bold);
            return view;
        }
        aVar.c.setVisibility(4);
        aVar.a.setTextAppearance(this.b, R.style.font_white_16_alpha50);
        return view;
    }

    static class a {
        TextView a;
        ImageView b;
        View c;

        a() {
        }
    }
}
