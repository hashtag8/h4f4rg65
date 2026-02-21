package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class amn extends ajj {
    private View a;
    private String b;
    private String c;
    private TextView d;
    private ImageView e;
    private Bitmap f;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.artist_info_fragment, (ViewGroup) null);
        this.d = (TextView) this.a.findViewById(R.id.information);
        this.e = (ImageView) this.a.findViewById(R.id.blur_readmore_background);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.a;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.d.setText(this.c);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.b = bundle.getString("TITLE");
        this.c = bundle.getString("CONTENT");
        this.f = (Bitmap) bundle.getParcelable("BLURBACKGROUND");
        if (this.f != null) {
            this.e.setImageBitmap(this.f);
            this.e.setBackground(new BitmapDrawable(this.f));
            this.d.setTextColor(-1);
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.b).e(q().getColor(R.color.white)).a(-9128246).c();
    }
}
