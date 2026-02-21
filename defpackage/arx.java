package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.OpenSourceLicenceActivity;
import defpackage.aro;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class arx extends ase {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private final aez b;
    private ImageView c;
    private aro d;

    public arx(Context context) {
        super(context, R.style.Dialog_Fullscreen);
        this.b = new aez() { // from class: arx.1
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                arx.this.d();
            }
        };
        b();
    }

    private void b() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        View viewInflate = layoutInflater.inflate(R.layout.dialog_search, (ViewGroup) null);
        this.c = (ImageView) viewInflate.findViewById(R.id.circle_spinner);
        a(viewInflate);
        setContentView(viewInflate);
        ((TextView) viewInflate.findViewById(R.id.app_version)).setText(ahv.b(getContext()));
        ((TextView) viewInflate.findViewById(R.id.link_to_licence)).setOnClickListener(new View.OnClickListener() { // from class: arx.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                arx.this.getContext().startActivity(new Intent(arx.this.getContext(), (Class<?>) OpenSourceLicenceActivity.class));
            }
        });
        this.d = new aro(this.c, getContext().getResources().getColor(R.color.blue_bg));
        this.d.a(arj.a, 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!aof.a().d().isEmpty()) {
            mo.a.a(new Runnable() { // from class: arx.3
                @Override // java.lang.Runnable
                public void run() {
                    arx.this.a();
                }
            });
        }
    }

    public void a() {
        if (this.c.getVisibility() == 0) {
            this.c.clearAnimation();
            this.c.setVisibility(8);
            aro aroVar = new aro((ImageView) findViewById(R.id.complete_search_checkmark));
            aroVar.a(arj.b, 33);
            aroVar.a(1);
            aroVar.a(new aro.e() { // from class: arx.4
                @Override // aro.e
                public void a() {
                    new asd(arx.this).a();
                }
            });
            aroVar.c();
        }
    }

    @Override // defpackage.ase, android.app.Dialog
    protected void onStart() {
        super.onStart();
        aof.a().c().a(this.b);
        this.c.animate().rotation(800.0f).setDuration(10000L).start();
        this.d.c();
        d();
        mq.c().schedule(new Runnable() { // from class: arx.5
            @Override // java.lang.Runnable
            public void run() {
                new asd(arx.this).a();
            }
        }, 10L, a);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        aof.a().c().b(this.b);
        this.c.clearAnimation();
        this.d.d();
    }
}
