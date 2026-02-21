package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.arw;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alp extends ale {
    private static List<Object> f = null;
    View.OnClickListener a = new ahl(this) { // from class: alp.1
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.logout /* 2131690017 */:
                    alp.this.ao();
                    break;
            }
        }
    };
    private qn ah = new a();
    private arw ai = null;
    private View b;
    private View c;
    private TextView d;
    private TextView e;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.fragment_deezer_settings_account, (ViewGroup) null);
        this.c = this.b.findViewById(R.id.logout);
        this.d = (TextView) this.b.findViewById(R.id.username);
        this.e = (TextView) this.b.findViewById(R.id.subscription);
        this.c.setOnClickListener(this.a);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.b;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        String strD = aho.d("user_name");
        String strD2 = aho.d("user_status");
        if (TextUtils.isEmpty(strD)) {
            an();
        } else {
            this.d.setText(strD);
            this.e.setText(b(strD2));
        }
        super.c(bundle);
    }

    protected void am() {
        if (this.g != null) {
            this.g.a(this.ae);
        }
        if (als.c != null) {
            als.c.clear();
        }
        new ava().a(1, this.ae).b();
        a(new Class[0]);
    }

    private void an() {
        new aky(this.ae, this.g, this.ah).execute(new ql("user/me"));
    }

    class a implements qn {
        private a() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                akn aknVar = (akn) new qu(akn.class).a(str);
                if (aknVar != null && !TextUtils.isEmpty(aknVar.c())) {
                    alp.this.d.setText(aknVar.c());
                    aho.a("user_name", aknVar.c());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.b())) {
                    aho.a("user_picture", aknVar.b());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.a())) {
                    aho.a("user_id", aknVar.a());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.d())) {
                    alp.this.e.setText(alp.this.b(aknVar.d()));
                    aho.a("user_status", aknVar.d());
                }
            } catch (IllegalStateException e) {
            }
        }

        @Override // defpackage.qn
        public void a(IOException iOException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(MalformedURLException malformedURLException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qm qmVar, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String strA = a(R.string.kDeezer_Gratuit_Str);
        if ("0".equals(str)) {
            return a(R.string.kDeezer_Gratuit_Str);
        }
        if ("1".equals(str)) {
            return a(R.string.kDeezer_Deezer_Premium_Str);
        }
        if ("2".equals(str)) {
            return a(R.string.kDeezer_Deezer_Premium_Add_Str);
        }
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public arw ao() {
        if (this.ai == null) {
            this.ai = new arw.a(this.ae).a(a(R.string.kDeezerManager_LogoutTip_Str)).b(a(R.string.kDeezerSettingAccountLogout_Str)).a(a(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: alp.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    alp.this.am();
                }
            }).b(a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: alp.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    alp.this.ai.dismiss();
                }
            }).d(false).b();
        }
        if (!this.ai.isShowing() && !this.ae.isFinishing()) {
            new asc(this.ai).a(p());
        }
        return this.ai;
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(-13487558).a(q().getString(R.string.kDeezerNav_Settings_Str)).c();
    }
}
