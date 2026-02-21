package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alt extends amf<akg> {
    private String a;

    public static class a {
        public TextView a;
        public TextView b;
        public ImageView c;
        public ImageView d;
        public View e;
    }

    public alt(Context context, List<akg> list, String str, qi qiVar) {
        super(context, list);
        this.a = null;
        this.a = str;
        this.f = qiVar;
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_explore_album_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (TextView) view.findViewById(R.id.text2);
            aVar.c = (ImageView) view.findViewById(R.id.iv);
            aVar.d = (ImageView) view.findViewById(R.id.img2);
            aVar.e = view.findViewById(R.id.layout);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(getItem(i).c());
        if (getItem(i) != null && getItem(i).f() != null && !TextUtils.isEmpty(getItem(i).f().b())) {
            aVar.b.setVisibility(0);
            aVar.b.setText(getItem(i).f().b());
        } else {
            aVar.b.setVisibility(8);
        }
        aVar.d.setVisibility(0);
        aVar.d.setOnClickListener(new View.OnClickListener() { // from class: alt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                als.a(alt.this.b, new asi() { // from class: alt.1.1
                    @Override // defpackage.asi
                    public void a(int i2) {
                        if (aof.a().l()) {
                            Toast.makeText(alt.this.b, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                            return;
                        }
                        akg item = alt.this.getItem(i);
                        if (item != null) {
                            alt.this.a(item, i2);
                        }
                    }
                });
            }
        });
        new ahw().a(aVar.c, getItem(i).e());
        if (!getItem(i).h()) {
            if (getItem(i).i() == null) {
                mm.b("deezer", "grey " + getItem(i).b() + getItem(i).c());
                aVar.e.setBackgroundColor(this.b.getResources().getColor(R.color.gray));
            } else {
                mm.b("deezer", "getAlternative " + getItem(i).b() + getItem(i).c());
                aVar.e.setBackgroundColor(Color.parseColor("#eeeeee"));
            }
        } else {
            aVar.e.setBackgroundColor(Color.parseColor("#eeeeee"));
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final akg akgVar, final int i) {
        if (!ahh.e(this.b)) {
            Toast.makeText(this.b, R.string.WifiNotReachableTip_Str, 0).show();
        } else if (this.f != null) {
            new aky(this.b, this.f, new qn() { // from class: alt.2
                @Override // defpackage.qn
                public void a(String str, Object obj) {
                    List<akm> listA = new qv(akm.class).a(str);
                    ArrayList arrayList = new ArrayList();
                    for (akm akmVar : listA) {
                        akmVar.a(akgVar);
                        arrayList.add(als.a(akmVar));
                    }
                    als.b(arrayList, i);
                }

                @Override // defpackage.qn
                public void a(IOException iOException, Object obj) {
                    mm.e(iOException, new Object[0]);
                }

                @Override // defpackage.qn
                public void a(MalformedURLException malformedURLException, Object obj) {
                    mm.e(malformedURLException, new Object[0]);
                }

                @Override // defpackage.qn
                public void a(qm qmVar, Object obj) {
                    mm.e(qmVar, new Object[0]);
                    Toast.makeText(alt.this.b, R.string.kDeezer_Error300_Str, 0).show();
                }

                @Override // defpackage.qn
                public void a(qk qkVar, Object obj) {
                }
            }, false).execute(new ql("album/" + akgVar.b() + "/tracks"));
        }
    }
}
