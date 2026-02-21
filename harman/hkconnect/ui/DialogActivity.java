package com.harman.hkconnect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.harman.hkconnect.R;
import defpackage.arw;
import defpackage.asc;

/* JADX INFO: loaded from: classes.dex */
public class DialogActivity extends Activity {
    private arw a = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        requestWindowFeature(1);
        super.onCreate(bundle);
        int i = getIntent().getExtras().getInt("error_type");
        if (i == 6) {
            string = getResources().getString(R.string.FCErrorMessage1_Str);
        } else if (i == -1) {
            string = getResources().getString(R.string.PlayErrorTip_Str);
        } else {
            string = getResources().getString(R.string.FCErrorMessage0_Str);
        }
        a(string, i);
    }

    public arw a(String str, int i) {
        if (this.a == null) {
            this.a = new arw.a(this).b(getString(R.string.Warning_Str)).a(str).a(getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.DialogActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    DialogActivity.this.b();
                }
            }).d(false).f(false).b();
            a();
        }
        if (!this.a.isShowing()) {
            new asc(this.a).a(null);
        }
        return this.a;
    }

    public void a() {
        if (this.a != null) {
            this.a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.harman.hkconnect.ui.DialogActivity.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    DialogActivity.this.a = null;
                    DialogActivity.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        finish();
    }
}
