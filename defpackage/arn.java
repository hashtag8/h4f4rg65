package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class arn extends FrameLayout {
    boolean a;
    private Context b;
    private a c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ArrayList<TextView> h;
    private View.OnClickListener i;

    public interface a {
        void a(View view);

        void b(View view);

        void c(View view);

        void d(View view);

        void e(View view);

        void f(View view);
    }

    public void setOnQobuzListner(a aVar) {
        this.c = aVar;
    }

    public arn(Context context) {
        super(context);
        this.h = new ArrayList<>();
        this.i = new View.OnClickListener() { // from class: arn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (arn.this.c != null) {
                    switch (view.getId()) {
                        case R.id.playlists /* 2131689959 */:
                            arn.this.c.d(view);
                            arn.this.a((TextView) view);
                            break;
                        case R.id.discoveries /* 2131690006 */:
                            arn.this.c.f(view);
                            arn.this.a((TextView) view);
                            break;
                        case R.id.favourites /* 2131690007 */:
                            arn.this.c.e(view);
                            arn.this.a((TextView) view);
                            break;
                        case R.id.purchases /* 2131690008 */:
                            arn.this.c.b(view);
                            arn.this.a((TextView) view);
                            break;
                        case R.id.preferences /* 2131690009 */:
                            arn.this.c.c(view);
                            arn.this.a((TextView) view);
                            break;
                    }
                }
            }
        };
        a(context);
    }

    public TextView getLastPressed() {
        return this.g;
    }

    public void setLastPressed(TextView textView) {
        this.g = textView;
    }

    private void a(Context context) {
        this.h.clear();
        this.b = context;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LayoutInflater.from(context).inflate(R.layout.dashboard_qobuz_right, this);
        this.f = (TextView) findViewById(R.id.discoveries);
        this.f.setOnClickListener(this.i);
        TextView textView = (TextView) findViewById(R.id.preferences);
        textView.setOnClickListener(this.i);
        this.e = (TextView) findViewById(R.id.playlists);
        this.e.setOnClickListener(this.i);
        TextView textView2 = (TextView) findViewById(R.id.favourites);
        textView2.setOnClickListener(this.i);
        TextView textView3 = (TextView) findViewById(R.id.purchases);
        textView3.setOnClickListener(this.i);
        this.d = (TextView) findViewById(R.id.account_name);
        a();
        this.h.add(this.f);
        this.h.add(textView);
        this.h.add(textView2);
        this.h.add(textView3);
        this.h.add(this.e);
        this.g = this.f;
        this.a = !ahn.a();
        if (this.a) {
            Iterator<TextView> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().setBackgroundResource(R.drawable.qobuz_textview_selector);
            }
        } else {
            Iterator<TextView> it2 = this.h.iterator();
            while (it2.hasNext()) {
                it2.next().setBackgroundColor(Color.parseColor("#d6d6d6"));
            }
        }
    }

    public void a(TextView textView) {
        if (!this.a && this.g != textView) {
            textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.g.setBackgroundColor(Color.parseColor("#d6d6d6"));
            this.g = textView;
        }
    }

    public void a() {
        this.d.setText(aho.d("qobuz_user_info").trim().split("&")[1]);
    }

    public boolean b() {
        if (!this.g.equals(this.f)) {
            return false;
        }
        this.f.setBackgroundColor(Color.parseColor("#FFFFFF"));
        return true;
    }
}
