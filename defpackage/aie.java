package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class aie extends aik {
    public aie(Context context, int i, int i2, ajm ajmVar) {
        super(context, i, i2, ajmVar);
    }

    @Override // defpackage.aik, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Iterator<String> it = this.a.keySet().iterator();
        final int i2 = 0;
        while (it.hasNext()) {
            aif aifVar = (aif) this.a.get(it.next());
            int count = aifVar.getCount() + 1;
            if (i == 0) {
                String item = this.b.getItem(i2);
                ViewGroup viewGroup2 = (ViewGroup) this.b.getView(i2, view, viewGroup);
                TextView textView = (TextView) viewGroup2.findViewById(R.id.search_more);
                LinearLayout linearLayout = (LinearLayout) viewGroup2.findViewById(R.id.search_more_click_area);
                if (aifVar.getCount() == 0 || item.equals("")) {
                    viewGroup2.setVisibility(8);
                    viewGroup2.getLayoutParams().height = 1;
                    return viewGroup2;
                }
                int iA = aifVar.a() - aifVar.getCount();
                if (iA > 0) {
                    textView.setText(iA + " " + this.c.getString(R.string.TidalMore));
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                viewGroup2.setVisibility(0);
                viewGroup2.getLayoutParams().height = ahn.a(HarmanApplication.a(), 40.0f);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: aie.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aie.this.a() != null) {
                            aie.this.a().e(i2);
                        }
                    }
                });
                return viewGroup2;
            }
            if (i < count) {
                return aifVar.getView(i - 1, view, viewGroup);
            }
            i -= count;
            i2++;
        }
        return null;
    }
}
