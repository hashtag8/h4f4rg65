package defpackage;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class aqu extends RecyclerView.a<b> {
    ArrayList<String> a;
    LayoutInflater b;
    int c = 0;
    a d;

    public interface a {
        void a(View view, int i);
    }

    public aqu(ArrayList<String> arrayList, LayoutInflater layoutInflater) {
        this.a = arrayList;
        this.b = layoutInflater;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(ViewGroup viewGroup, int i) {
        View viewInflate = this.b.inflate(R.layout.navigation_text_view, viewGroup, false);
        b bVar = new b(viewInflate);
        bVar.n = (TextView) viewInflate.findViewById(R.id.navigation_item);
        bVar.o = (TextView) viewInflate.findViewById(R.id.invisible_navigation_item);
        return bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public void a(b bVar, int i) {
        String str = this.a.get(i);
        if (str != null) {
            String upperCase = str.toUpperCase();
            bVar.n.setText(upperCase);
            bVar.o.setText(upperCase);
            if (this.c == i) {
                bVar.n.setTextColor(Color.parseColor("#000000"));
                bVar.n.setTypeface(ahu.b(HarmanApplication.a()));
            } else {
                bVar.n.setTextColor(Color.parseColor("#9A9A9A"));
                bVar.n.setTypeface(ahu.a(HarmanApplication.a()));
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public int a() {
        return this.a.size();
    }

    public void f(int i) {
        this.c = i;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public class b extends RecyclerView.v implements View.OnClickListener {
        public TextView n;
        public TextView o;

        public b(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aqu.this.d != null) {
                aqu.this.d.a(view, d());
            }
        }
    }
}
