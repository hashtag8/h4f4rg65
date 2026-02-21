package defpackage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class ank extends amw implements View.OnClickListener {
    private static int ak = 10;
    private TextView ah;
    private TextView ai;
    private TextView aj;
    private View b;
    private RelativeLayout c;
    private TextView d;
    private TextView e;
    private TextView f;
    private DashboardActivity g;
    private TextView h;
    private TextView i;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.g = (DashboardActivity) p();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.qobuz_preferences_fragment, (ViewGroup) null);
        this.c = (RelativeLayout) this.b.findViewById(R.id.logo_out);
        this.c.setOnClickListener(this);
        this.h = (TextView) this.b.findViewById(R.id.hi_res_message);
        this.i = (TextView) this.b.findViewById(R.id.hi_res_192);
        this.i.setOnClickListener(this);
        this.ah = (TextView) this.b.findViewById(R.id.hi_res_96);
        this.ah.setOnClickListener(this);
        this.ai = (TextView) this.b.findViewById(R.id.hi_res_cd);
        this.ai.setOnClickListener(this);
        this.aj = (TextView) this.b.findViewById(R.id.hi_res_mp3);
        this.aj.setOnClickListener(this);
        this.d = (TextView) this.b.findViewById(R.id.account_name);
        this.e = (TextView) this.b.findViewById(R.id.account_post);
        this.f = (TextView) this.b.findViewById(R.id.country_id);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.b;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(bundle);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        String strTrim = aho.d("qobuz_user_info").trim();
        String str = strTrim.split("&")[1];
        String str2 = strTrim.split("&")[2] == null ? "Member Qobuz" : strTrim.split("&")[2];
        this.d.setText(str);
        this.e.setText(str2);
        if ("Member Qobuz".equals(str2)) {
            this.e.setTextColor(q().getColor(R.color.qobuz_server_font_default));
        } else {
            this.e.setTextColor(q().getColor(R.color.qobuz_server_bule));
        }
        this.f.setText(String.format(q().getString(R.string.kQobuz_UserInfo_Description_Str), strTrim.split("&")[0]));
        switch (aho.d("format_id").trim()) {
            case "27":
                a(this.i, a(R.string.kQobuz_Streaming_Hi_Res_192_Str), (String) null);
                break;
            case "7":
                a(this.ah, a(R.string.kQobuz_Streaming_Hi_Res_96_Str), (String) null);
                break;
            case "6":
                a(this.ai, a(R.string.kQobuz_Streaming_CD_Str), (String) null);
                break;
            case "5":
                a(this.aj, a(R.string.kQobuz_Streaming_MP3_Str), (String) null);
                break;
        }
        if (str2.contains("Sublime")) {
            this.i.setEnabled(true);
            this.i.setTextColor(q().getColor(R.color.qobuz_server_font_default));
            this.ah.setEnabled(true);
            this.ah.setTextColor(q().getColor(R.color.qobuz_server_font_default));
            return;
        }
        this.i.setEnabled(false);
        this.i.setTextColor(q().getColor(R.color.gray_1));
        this.ah.setEnabled(false);
        this.ah.setTextColor(q().getColor(R.color.gray_1));
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_Preferences_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logo_out /* 2131690770 */:
                new AlertDialog.Builder(this.g).setTitle(a(R.string.Warning_Str)).setMessage(a(R.string.kQobuz_Logout_Tip_Str)).setPositiveButton(a(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ank.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new ava().a(2, ank.this.g).b();
                        ank.this.a(new Class[0]);
                    }
                }).setNeutralButton(a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: ank.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).create().show();
                break;
            case R.id.hi_res_192 /* 2131690773 */:
                a(this.i, a(R.string.kQobuz_Streaming_Hi_Res_192_Str), "27");
                break;
            case R.id.hi_res_96 /* 2131690774 */:
                a(this.ah, a(R.string.kQobuz_Streaming_Hi_Res_96_Str), "7");
                break;
            case R.id.hi_res_cd /* 2131690775 */:
                a(this.ai, a(R.string.kQobuz_Streaming_CD_Str), "6");
                break;
            case R.id.hi_res_mp3 /* 2131690776 */:
                a(this.aj, a(R.string.kQobuz_Streaming_MP3_Str), "5");
                break;
        }
    }

    private void a(TextView textView, String str, String str2) {
        this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ah.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ai.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable drawable = q().getDrawable(R.drawable.check_icon);
        drawable.setBounds(0, 0, ak, ak);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.h.setText(str);
        if (str2 != null) {
            b(str2);
        }
    }

    private void b(String str) {
        aho.a("format_id", str);
    }
}
