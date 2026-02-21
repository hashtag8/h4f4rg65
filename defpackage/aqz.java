package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aqz {
    private final Activity a;
    private Dialog b;
    private boolean c;
    private TextView d;
    private TextView e;
    private ImageView f;

    public aqz(Activity activity) {
        this.a = activity;
    }

    public void a() {
        final aez aezVar = new aez() { // from class: aqz.1
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                aqz.this.b();
            }
        };
        aof.a().c().a(aezVar);
        HarmanApplication.a().registerActivityLifecycleCallbacks(new are(this.a) { // from class: aqz.2
            @Override // defpackage.are
            public void a() {
                if (aqz.this.a instanceof DashboardActivity) {
                    aof.a().c().b(aezVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aof.a().d().size() != 0) {
            boolean z = !aoz.a(aof.a().f()).isEmpty();
            if (this.c && z) {
                this.a.runOnUiThread(new Runnable() { // from class: aqz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        aqz.this.c();
                    }
                });
            } else if (this.b != null) {
                new asd(this.b).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        mm.c();
        mm.b((Object) "showRemindSetupDialog");
        if (this.b != null) {
            if (!this.b.isShowing()) {
                new asc(this.b).a(null);
                return;
            }
            return;
        }
        this.b = new Dialog(this.a, R.style.CustomDialog);
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_remindsetup, (ViewGroup) null);
        this.b.setContentView(viewInflate);
        this.b.setCanceledOnTouchOutside(false);
        this.b.setCancelable(false);
        this.d = (TextView) viewInflate.findViewById(R.id.setup_now);
        this.e = (TextView) viewInflate.findViewById(R.id.manage_rooms);
        this.e.setText(this.a.getString(R.string.kSettings_Manage_Rooms2));
        this.f = (ImageView) viewInflate.findViewById(R.id.remindsetup_close_icon);
        this.b.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: aqz.4
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 24 || i == 25) {
                    return aqz.this.a.onKeyDown(i, keyEvent);
                }
                return false;
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: aqz.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqz.this.d();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: aqz.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqz.this.d();
                aqz.this.e();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: aqz.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqz.this.d();
                aqz.this.f();
            }
        });
        new asc(this.b).a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent(this.a, (Class<?>) ProductSetupMasterActivity.class);
        intent.putExtra("SETUP_TYPE", 0);
        this.a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Intent intent = new Intent(this.a, (Class<?>) ProductSetupMasterActivity.class);
        intent.putExtra("SETUP_TYPE", 1);
        this.a.startActivity(intent);
    }

    public void a(boolean z) {
        this.c = z;
        b();
    }
}
