package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bcx extends LinearLayout {
    private Context a;
    private TextView b;
    private List<TextView> c;
    private a d;
    private View.OnClickListener e;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public void setOnTidalListener(a aVar) {
        this.d = aVar;
    }

    public bcx(Context context) {
        super(context);
        this.c = new ArrayList();
        this.e = new View.OnClickListener() { // from class: bcx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bcx.this.b.setBackgroundColor(bcx.this.getResources().getColor(R.color.tidal_alt_bg));
                bcx.this.b = (TextView) view;
                bcx.this.b.setBackgroundColor(bcx.this.getResources().getColor(R.color.tidal_bg));
                if (bcx.this.d != null) {
                    switch (view.getId()) {
                        case R.id.playlists /* 2131689959 */:
                            bcw.a = 1;
                            bcx.this.setSelected(bcw.a);
                            bcx.this.d.c();
                            break;
                        case R.id.genres /* 2131689962 */:
                            bcw.a = 2;
                            bcx.this.setSelected(bcw.a);
                            bcx.this.d.b();
                            break;
                        case R.id.my_music /* 2131689964 */:
                            bcw.a = 3;
                            bcx.this.setSelected(bcw.a);
                            bcx.this.d.d();
                            break;
                        case R.id.whatsnew /* 2131690016 */:
                            bcw.a = 0;
                            bcx.this.setSelected(bcw.a);
                            bcx.this.d.a();
                            break;
                        case R.id.logout /* 2131690017 */:
                            bcw.a = 4;
                            bcx.this.setSelected(bcw.a);
                            bcx.this.d.e();
                            break;
                    }
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.dashboard_tidal_right, this);
        TextView textView = (TextView) findViewById(R.id.whatsnew);
        textView.setOnClickListener(this.e);
        TextView textView2 = (TextView) findViewById(R.id.playlists);
        textView2.setOnClickListener(this.e);
        TextView textView3 = (TextView) findViewById(R.id.genres);
        textView3.setOnClickListener(this.e);
        TextView textView4 = (TextView) findViewById(R.id.my_music);
        textView4.setOnClickListener(this.e);
        TextView textView5 = (TextView) findViewById(R.id.logout);
        textView5.setOnClickListener(this.e);
        this.c.clear();
        this.c.add(textView);
        this.c.add(textView2);
        this.c.add(textView3);
        this.c.add(textView4);
        this.c.add(textView5);
        this.b = textView;
        this.b.setBackgroundColor(getResources().getColor(R.color.tidal_bg));
    }

    public void setSelected(int i) {
        int i2 = 0;
        mm.b("SELECTED", "index = " + i + " " + this.c.size());
        while (true) {
            int i3 = i2;
            if (i3 < this.c.size()) {
                TextView textView = this.c.get(i3);
                if (i3 == i) {
                    textView.setBackgroundColor(getResources().getColor(R.color.tidal_bg));
                } else {
                    textView.setBackgroundColor(getResources().getColor(R.color.tidal_alt_bg));
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void a() {
        this.b.setBackgroundColor(getResources().getColor(R.color.tidal_alt_bg));
        this.b = this.c.get(1);
        this.b.setBackgroundColor(getResources().getColor(R.color.tidal_bg));
    }
}
