package defpackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.settings.management.curstomerview.DragSortListView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class aor extends LinearLayout implements View.OnClickListener {
    private DragSortListView a;
    private aoq b;
    private aon c;
    private a d;
    private int e;

    public interface a {
        void a(aor aorVar, aon aonVar, int i);
    }

    public int getPosition() {
        return this.e;
    }

    public void setPosition(int i) {
        this.e = i;
    }

    public aor(aon aonVar, DragSortListView dragSortListView) {
        super(aonVar.a());
        this.a = dragSortListView;
        this.c = aonVar;
        Iterator<aop> it = aonVar.b().iterator();
        int i = 0;
        while (it.hasNext()) {
            a(it.next(), i);
            i++;
        }
    }

    private void a(aop aopVar, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(aopVar.f(), -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(i);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(aopVar.e());
        linearLayout.setOnClickListener(this);
        addView(linearLayout);
        if (aopVar.d() != null) {
            linearLayout.addView(a(aopVar));
        }
        if (!TextUtils.isEmpty(aopVar.c())) {
            linearLayout.addView(b(aopVar));
        }
    }

    private ImageView a(aop aopVar) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(aopVar.d());
        return imageView;
    }

    private TextView b(aop aopVar) {
        TextView textView = new TextView(getContext());
        textView.setTypeface(ahu.a(getContext()));
        textView.setText(aopVar.c());
        textView.setGravity(17);
        textView.setTextSize(aopVar.b());
        textView.setTextColor(aopVar.a());
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d != null && this.b.b()) {
            this.d.a(this, this.c, view.getId());
        }
    }

    public a getOnSwipeItemClickListener() {
        return this.d;
    }

    public void setOnSwipeItemClickListener(a aVar) {
        this.d = aVar;
    }

    public void setLayout(aoq aoqVar) {
        this.b = aoqVar;
    }
}
