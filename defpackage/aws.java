package defpackage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aws extends LinearLayout {
    private static int e = 32;
    private Context a;
    private TextView b;
    private ScrollView c;
    private a d;
    private List<TextView> f;
    private View.OnClickListener g;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public void setOnJukeListener(a aVar) {
        this.d = aVar;
    }

    public aws(Context context) {
        super(context);
        this.f = new ArrayList();
        this.g = new View.OnClickListener() { // from class: aws.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aws.this.b.setTextColor(aws.this.getResources().getColor(R.color.juke_text));
                aws.this.b.setBackgroundColor(aws.this.getResources().getColor(R.color.juke_bg));
                aws.this.b.getCompoundDrawables()[0].setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
                aws.this.b = (TextView) view;
                aws.this.b.setTextColor(aws.this.getResources().getColor(R.color.juke_text_highlight));
                aws.this.b.setBackgroundColor(aws.this.getResources().getColor(R.color.juke_highlight));
                aws.this.b.getCompoundDrawables()[0].setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
                if (aws.this.d != null) {
                    switch (view.getId()) {
                        case R.id.discover /* 2131689958 */:
                            awp.a = 0;
                            aws.this.d.e();
                            break;
                        case R.id.playlists /* 2131689959 */:
                            awp.a = 1;
                            aws.this.d.d();
                            break;
                        case R.id.charts /* 2131689960 */:
                            awp.a = 2;
                            aws.this.d.a();
                            break;
                        case R.id.juke_fm /* 2131689961 */:
                            awp.a = 3;
                            aws.this.d.b();
                            break;
                        case R.id.genres /* 2131689962 */:
                            awp.a = 4;
                            aws.this.d.c();
                            break;
                        case R.id.my_playlists /* 2131689963 */:
                            awp.a = 5;
                            aws.this.d.f();
                            break;
                        case R.id.my_music /* 2131689964 */:
                            awp.a = 6;
                            aws.this.d.g();
                            break;
                        case R.id.log_out /* 2131689965 */:
                            awp.a = 7;
                            aws.this.d.h();
                            break;
                    }
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.dashboard_juke_right, this);
        this.c = (ScrollView) findViewById(R.id.menu_scroller);
        TextView textView = (TextView) findViewById(R.id.discover);
        textView.setOnClickListener(this.g);
        TextView textView2 = (TextView) findViewById(R.id.charts);
        textView2.setOnClickListener(this.g);
        TextView textView3 = (TextView) findViewById(R.id.playlists);
        textView3.setOnClickListener(this.g);
        TextView textView4 = (TextView) findViewById(R.id.juke_fm);
        textView4.setOnClickListener(this.g);
        TextView textView5 = (TextView) findViewById(R.id.genres);
        textView5.setOnClickListener(this.g);
        TextView textView6 = (TextView) findViewById(R.id.my_playlists);
        textView6.setOnClickListener(this.g);
        TextView textView7 = (TextView) findViewById(R.id.my_music);
        textView7.setOnClickListener(this.g);
        TextView textView8 = (TextView) findViewById(R.id.log_out);
        textView8.setOnClickListener(this.g);
        this.f.clear();
        this.f.add(textView);
        this.f.add(textView3);
        this.f.add(textView2);
        this.f.add(textView4);
        this.f.add(textView5);
        this.f.add(textView6);
        this.f.add(textView7);
        this.f.add(textView8);
        b();
        this.b = textView;
        this.b.setTextColor(getResources().getColor(R.color.juke_text_highlight));
        this.b.setBackgroundColor(getResources().getColor(R.color.juke_highlight));
        this.b.getCompoundDrawables()[0].setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
    }

    private void b() {
        for (TextView textView : this.f) {
            textView.setTextColor(getResources().getColor(R.color.juke_text));
            textView.setBackgroundColor(getResources().getColor(R.color.juke_bg));
            textView.getCompoundDrawables()[0].setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        }
    }

    public void a() {
        this.b.setTextColor(getResources().getColor(R.color.juke_text));
        this.b.setBackgroundColor(getResources().getColor(R.color.juke_bg));
        this.b.getCompoundDrawables()[0].setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        this.b = this.f.get(0);
        this.b.setTextColor(getResources().getColor(R.color.juke_text_highlight));
        this.b.setBackgroundColor(getResources().getColor(R.color.juke_highlight));
        this.b.getCompoundDrawables()[0].setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
        this.c.scrollTo(0, 0);
    }

    public void setSelected(int i) {
        mm.b("SELECTED", "index = " + i + " " + this.f.size());
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            TextView textView = this.f.get(i2);
            if (i2 == i) {
                textView.setTextColor(getResources().getColor(R.color.juke_text_highlight));
                textView.setBackgroundColor(getResources().getColor(R.color.juke_highlight));
                textView.getCompoundDrawables()[0].setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
            } else {
                textView.setTextColor(getResources().getColor(R.color.juke_text));
                textView.setBackgroundColor(getResources().getColor(R.color.juke_bg));
                textView.getCompoundDrawables()[0].setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            }
        }
    }
}
