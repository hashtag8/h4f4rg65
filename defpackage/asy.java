package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
public class asy {
    private final String a = "APP_SKIP_VERSION_CODE";
    private ba b;
    private arw c;

    public asy(ba baVar) {
        this.b = baVar;
    }

    public void a() {
        if (atb.a != null) {
            int iC = aho.c("APP_SKIP_VERSION_CODE");
            float fA = ahv.a(this.b);
            mm.b("TEST_APP_VERSION", "server= " + atb.a.b + ",App=" + fA + ",skipv=" + iC);
            if (atb.a.b > fA && atb.a.b != iC) {
                mo.a.postDelayed(new Runnable() { // from class: asy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (asy.this.c == null || !asy.this.c.isShowing()) {
                            if (atb.a.c) {
                                asy.this.c = asy.this.d();
                            } else {
                                asy.this.c = asy.this.b();
                            }
                            mm.b("TEST_APP_VERSION", "isShowing= 1");
                            new asc(asy.this.c).a(null);
                        }
                    }
                }, 1000L);
            }
        }
    }

    public arw b() {
        return new arw.a(this.b).b(this.b.getString(R.string.AppUpgradeTitle_Str)).b(false).a(this.b.getString(R.string.kApp_upgrade_now_str), new DialogInterface.OnClickListener() { // from class: asy.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                asy.this.e();
            }
        }).d(false).f(false).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public arw d() {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.optional_upgrade_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.id_dialog_cancelbtn);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.id_dialog_okbtn);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.id_dialog_skipbtn);
        textView.setText(R.string.Cancel_Str);
        textView2.setText(R.string.AppUpgrade_UpgradeNow_Str);
        textView3.setText(R.string.AppUpgrade_SkipThisVersion_Str);
        final arw arwVarB = new arw.a(this.b).b(this.b.getString(R.string.AppUpgradeTitle_Str)).a(viewInflate).e(false).d(false).f(false).b();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: asy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                asy.this.e();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: asy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                arwVarB.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: asy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                arwVarB.dismiss();
                aho.a("APP_SKIP_VERSION_CODE", atb.a.b);
            }
        });
        return arwVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(atb.a.d));
        this.b.startActivity(intent);
    }

    public arw c() {
        return this.c;
    }
}
