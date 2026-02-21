package com.harman.hkconnect.musicservice.musicserver.qobuz;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import defpackage.ahg;
import defpackage.ahn;
import defpackage.anu;
import defpackage.anv;
import defpackage.asc;
import defpackage.ava;
import defpackage.awh;
import defpackage.ld;
import defpackage.mm;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class QobuzLoginActivity extends ld implements View.OnClickListener, anu<JSONObject> {
    private TextView b;
    private TextView c;
    private Button d;
    private Button e;
    private RelativeLayout f;
    private ImageView g;
    private EditText h;
    private EditText i;
    private anv j;
    private ViewGroup n;
    private TextView p;
    private TextView q;
    private Boolean k = true;
    private ProgressDialog l = null;
    private Dialog m = null;
    private Context o = this;
    public View.OnClickListener a = new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QobuzLoginActivity.this.d();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ld, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qobuz_login_layout);
        this.f = (RelativeLayout) findViewById(R.id.title_bar);
        this.f.setBackgroundColor(getResources().getColor(R.color.qobuz_login_title));
        this.n = (RelativeLayout) findViewById(R.id.login_container);
        this.n.setLayoutParams(ahn.a(this.n.getLayoutParams(), this));
        this.p = (TextView) findViewById(R.id.logo_text_default);
        this.q = (TextView) findViewById(R.id.logo_text_multiple);
        b();
        this.g = (ImageView) findViewById(R.id.logo_view);
        this.g.setVisibility(0);
        this.g.setImageResource(R.drawable.qubuz_logo_login);
        this.e = (Button) this.f.findViewById(R.id.right_button);
        this.e.setVisibility(0);
        this.e.setTextColor(getResources().getColor(R.color.qobuz_login_cancel));
        this.e.setTextSize(16.0f);
        this.e.setText(getString(R.string.kQobuz_Cancel_Str));
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QobuzLoginActivity.this.finish();
            }
        });
        this.c = (TextView) findViewById(R.id.link_sign);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QobuzLoginActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.qobuz.com/signup")));
            }
        });
        this.d = (Button) findViewById(R.id.login);
        this.d.setOnClickListener(this.a);
        this.h = (EditText) findViewById(R.id.user_name);
        this.i = (EditText) findViewById(R.id.password);
        this.b = (TextView) findViewById(R.id.forg_pass);
        this.b.setOnClickListener(this);
        this.j = new anv(this);
        this.i.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    QobuzLoginActivity.this.d();
                    return false;
                }
                return false;
            }
        });
        a();
    }

    private void a() {
        if (!ahn.a()) {
            setRequestedOrientation(1);
            return;
        }
        int iA = ahn.a(this, 400.0f);
        ((RelativeLayout.LayoutParams) this.h.getLayoutParams()).width = iA;
        ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).width = iA;
        ((RelativeLayout.LayoutParams) this.d.getLayoutParams()).width = iA;
        ((RelativeLayout.LayoutParams) this.b.getLayoutParams()).width = iA;
    }

    private void b() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration.locale == null) {
            configuration.locale = Locale.getDefault();
        }
        String country = configuration.locale.getCountry();
        if (country == null) {
            this.p.setText("");
            this.q.setText("");
            return;
        }
        if (country.equalsIgnoreCase("fr") || country.equalsIgnoreCase("be") || country.equalsIgnoreCase("lu")) {
            this.p.setText(this.o.getString(R.string.qobuz_logo_text_fr));
            return;
        }
        if (country.equalsIgnoreCase("gb") || country.equalsIgnoreCase("ie") || country.equalsIgnoreCase("nl")) {
            this.p.setText(this.o.getString(R.string.qobuz_logo_text_en));
            return;
        }
        if (country.equalsIgnoreCase("de") || country.equalsIgnoreCase("at")) {
            this.p.setText(this.o.getString(R.string.qobuz_logo_text_dk));
            return;
        }
        if (country.equalsIgnoreCase("ch")) {
            this.p.setText(this.o.getString(R.string.qobuz_logo_text_fr));
            this.q.setText(this.o.getString(R.string.qobuz_logo_text_dk));
            this.q.setTextColor(Color.parseColor("#65676c"));
        } else {
            this.p.setText("");
            this.q.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h == null || "".equals(this.h.getText().toString().trim()) || this.i == null || "".equals(this.i.getText().toString().trim())) {
            Toast.makeText(this, "please add content", 0).show();
        } else {
            a(new String[]{this.h.getText().toString().trim(), this.i.getText().toString().trim()}, (Boolean) true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, Boolean bool) {
        if (this.l == null) {
            this.l = new ProgressDialog(this);
            this.l.setProgressStyle(0);
            this.l.setIndeterminate(false);
            this.l.setCancelable(true);
            this.l.setMessage(getString(R.string.kAndroid_Loading));
            this.l.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        String str = "http://www.qobuz.com/api.json/0.2/user/resetPassword?app_id=394304373&username=" + strArr[0] + "&email=" + strArr[1];
        if (bool.booleanValue()) {
            str = "http://www.qobuz.com/api.json/0.2/user/login?app_id=394304373&username=" + strArr[0] + "&password=" + ahg.a(strArr[1]) + "&device_manufacturer_id=" + e();
            mm.b((Object) ("qobuz login url = " + str));
        }
        this.k = bool;
        if (!this.l.isShowing() && !isFinishing()) {
            this.l.show();
        }
        this.j.a(str, this);
    }

    private String e() {
        TelephonyManager telephonyManager = (TelephonyManager) getBaseContext().getSystemService("phone");
        String str = "" + telephonyManager.getDeviceId();
        String string = new UUID(("" + Settings.Secure.getString(getContentResolver(), "android_id")).hashCode(), ((long) ("" + telephonyManager.getSimSerialNumber()).hashCode()) | (((long) str.hashCode()) << 32)).toString();
        Log.d("debug", "uuid=" + string);
        return string;
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (this.l != null && this.l.isShowing()) {
            this.l.dismiss();
            this.l = null;
        }
        if (this.k.booleanValue()) {
            try {
                new ava().a(2, this).a(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setResult(-1);
            finish();
            return;
        }
        Toast.makeText(this, getString(R.string.JukePasswordResetSuccess), 1).show();
        if (this.m != null && this.m.isShowing()) {
            this.m.dismiss();
            this.m = null;
        }
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (this.l != null && this.l.isShowing()) {
            this.l.dismiss();
            this.l = null;
        }
        if (str != null && !str.equals("")) {
            Toast.makeText(this, str, 1).show();
        } else if (awh.a(1000)) {
            Toast.makeText(this, getString(R.string.kQobuz_ResetPassword_Fail_Str), 1).show();
        } else {
            Toast.makeText(this, getString(R.string.SpeakerControlNOInternet_Str), 1).show();
        }
    }

    @Override // defpackage.anu
    public void c() {
        if (this.l != null && this.l.isShowing()) {
            this.l.dismiss();
            this.l = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.m = new Dialog(this.o);
        this.m.requestWindowFeature(1);
        this.m.setContentView(R.layout.qobuz_forget_password);
        final EditText editText = (EditText) this.m.findViewById(R.id.user_mail);
        final EditText editText2 = (EditText) this.m.findViewById(R.id.user_name);
        ((Button) this.m.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QobuzLoginActivity.this.m != null && QobuzLoginActivity.this.m.isShowing()) {
                    QobuzLoginActivity.this.m.dismiss();
                    QobuzLoginActivity.this.m = null;
                }
            }
        });
        ((Button) this.m.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.QobuzLoginActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (editText == null || "".equals(editText.getText().toString().trim()) || editText2 == null || "".equals(editText2.getText().toString().trim())) {
                    Toast.makeText(QobuzLoginActivity.this, "please add content", 0).show();
                } else if (QobuzLoginActivity.a(editText.getText().toString().trim())) {
                    QobuzLoginActivity.this.a(new String[]{editText2.getText().toString(), editText.getText().toString()}, (Boolean) false);
                } else {
                    Toast.makeText(QobuzLoginActivity.this, R.string.kQobuz_Wrong_Email_Format_Str, 0).show();
                }
            }
        });
        if (!this.m.isShowing() && !isFinishing()) {
            new asc(this.m).a(null);
        }
    }

    public static boolean a(String str) {
        try {
            return Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
        } catch (Exception e) {
            return false;
        }
    }
}
