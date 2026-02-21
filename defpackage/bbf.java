package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
public class bbf {
    private View b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private Context h;
    private LinearLayout i;
    private ProgressBar j;
    private TextView k;
    private Bitmap l;
    private TextView m;
    private int n = 0;
    Handler a = new Handler();

    public bbf(LayoutInflater layoutInflater, Context context) {
        this.h = context;
        this.b = layoutInflater.inflate(R.layout.shoutcast_station_header, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.iv);
        this.e = (TextView) this.b.findViewById(R.id.station_name_textview);
        this.d = (ImageView) this.b.findViewById(R.id.station_hq_icon);
        this.f = (TextView) this.b.findViewById(R.id.station_genre_textview);
        this.g = (TextView) this.b.findViewById(R.id.station_ct_textview);
        this.j = (ProgressBar) this.b.findViewById(R.id.loading_spinner);
        this.k = (TextView) this.b.findViewById(R.id.no_recommedation_textview);
        this.i = (LinearLayout) this.b.findViewById(R.id.station_listen_now);
        this.m = (TextView) this.b.findViewById(R.id.listennow_textview);
    }

    public View a(String str, String str2, String str3, String str4, int i) {
        this.e.setText(str);
        this.f.setText(str2);
        if (str3 == null) {
            str3 = "No description provided";
        }
        this.g.setText(str3);
        if (i > 256) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        bif.a(this.h).a(str4).a(R.drawable.shoutcast_logo).a(this.c);
        a(str4);
        return this.b;
    }

    public void a(int i) {
        this.j.setVisibility(8);
        if (i <= 0) {
            this.k.setVisibility(0);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    private void a(final String str) {
        if (str != null) {
            bif.a(this.h).a(str).a(R.drawable.shoutcast_image_placeholder).a(new bip() { // from class: bbf.1
                @Override // defpackage.bip
                public void a(Bitmap bitmap, bif.d dVar) {
                    bbf.this.c.setImageBitmap(bitmap);
                    bbf.this.l = bitmap;
                    try {
                        bbf.this.b(str);
                    } catch (Exception e) {
                    }
                }

                @Override // defpackage.bip
                public void a(Drawable drawable) {
                }

                @Override // defpackage.bip
                public void b(Drawable drawable) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        bip bipVar = new bip() { // from class: bbf.2
            @Override // defpackage.bip
            public void a(Bitmap bitmap, bif.d dVar) {
                bbf.this.c.setImageBitmap(bitmap);
            }

            @Override // defpackage.bip
            public void a(Drawable drawable) {
                bbf.this.c.setImageBitmap(bbf.this.l);
            }

            @Override // defpackage.bip
            public void b(Drawable drawable) {
            }
        };
        String[] strArrSplit = str.split("\\.");
        strArrSplit[strArrSplit.length - 2] = "s500";
        String strA = bru.a(strArrSplit, ".");
        mm.b("WALI = " + strA, new Object[0]);
        bif.a(this.h).a(strA).a(bipVar);
    }
}
