package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.OpenSourceLicenceActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class asa extends ase {
    private final Activity a;
    private aey b;
    private asg c;
    private are d;
    private ask e;

    public asa(Activity activity) {
        super(activity, R.style.Dialog_Fullscreen);
        this.a = activity;
        this.e = new ask(activity, new asj() { // from class: asa.1
            @Override // defpackage.asj
            public void a(String str) {
                mm.b("Wifi changed to %s", str);
                if (str != null) {
                    new asd(asa.this).a();
                    asa.this.b();
                }
            }
        });
        a();
    }

    private void a() {
        View viewInflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.dialog_no_rooms, (ViewGroup) null);
        a(viewInflate);
        addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        TextView textView = (TextView) viewInflate.findViewById(R.id.setup_speaker_tv);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.no_rooms_found);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.cannot_see_room);
        ((TextView) viewInflate.findViewById(R.id.open_source_licence)).setOnClickListener(new View.OnClickListener() { // from class: asa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                asa.this.getContext().startActivity(new Intent(asa.this.getContext(), (Class<?>) OpenSourceLicenceActivity.class));
            }
        });
        this.b = new aez() { // from class: asa.3
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                asa.this.d();
            }
        };
        textView2.setText(this.a.getString(R.string.kSetupSearching_Content_Str));
        textView.setOnClickListener(new View.OnClickListener() { // from class: asa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(asa.this.a, (Class<?>) ProductSetupMasterActivity.class);
                intent.putExtra("SETUP_TYPE", 0);
                asa.this.a.startActivity(intent);
                asa.this.e.b();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: asa.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                asa.this.e();
            }
        });
    }

    @Override // defpackage.ase, android.app.Dialog
    protected void onStart() {
        super.onStart();
        aof.a().c().a(this.b);
        d();
        this.d = new are(this.a) { // from class: asa.6
            @Override // defpackage.are
            public void b() {
                aof.a().c().a(asa.this.b);
                asa.this.d();
            }

            @Override // defpackage.are
            public void c() {
                aof.a().c().b(asa.this.b);
            }
        };
        HarmanApplication.a().registerActivityLifecycleCallbacks(this.d);
        this.e.a();
    }

    @Override // defpackage.ase, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.e.b();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        aof.a().c().b(this.b);
        HarmanApplication.a().unregisterActivityLifecycleCallbacks(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            new asd(this.c).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!aof.a().d().isEmpty()) {
            if (this.c != null && this.c.isShowing()) {
                new asd(this.c).a();
            }
            new asd(this).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c = new asg(this.a);
        this.c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: asa.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!asa.this.c.c()) {
                    new asd(asa.this).a();
                }
            }
        });
        new asc(this.c).a(null);
    }
}
