package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atr extends atm implements View.OnClickListener {
    private static String f = "STORE_STATE_ABLE_SILENT";
    private Switch a;
    private RelativeLayout b;
    private RelativeLayout c;
    private TextView d;
    private TextView e;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_software_update_setting, (ViewGroup) null);
        this.a = (Switch) viewInflate.findViewById(R.id.aotu_upgrade_device_swith);
        this.c = (RelativeLayout) viewInflate.findViewById(R.id.timezone_pickup_layout);
        this.b = (RelativeLayout) viewInflate.findViewById(R.id.aotu_update_time_layout);
        this.d = (TextView) viewInflate.findViewById(R.id.aotu_device_update_time_tv);
        this.e = (TextView) viewInflate.findViewById(R.id.timezone_pickup_value);
        this.c.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: atr.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                aho.a(atr.f, z);
                atr.this.b(z);
                atr.this.a(aof.a().f());
            }
        });
        return viewInflate;
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<adx> list) {
        if (!this.a.isChecked()) {
            b(list);
        } else if (e().l() != null) {
            mq.b().b(new Runnable() { // from class: atr.2
                @Override // java.lang.Runnable
                public void run() {
                    for (adx adxVar : list) {
                        adw.a().a(adxVar, atr.this.e().l().a());
                        adw.a().a(adxVar, atr.this.e().l().c());
                        mm.b("TEST_TIMEZONE_SILENTTIME timezone = %s , silent time = %s", atr.this.e().l().a(), Integer.valueOf(atr.this.e().l().c()[0]));
                    }
                }
            });
        }
    }

    private void b(final List<adx> list) {
        mq.b().b(new Runnable() { // from class: atr.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    adw.a().F((adx) it.next());
                }
            }
        });
    }

    private void am() {
        e().b(q().getString(R.string.FotaSilenceUpdateSettings));
        e().c(true);
        boolean zB = aho.b(f, true);
        b(zB);
        this.a.setChecked(zB);
        if (e().l() == null) {
            e().a(new atf());
        }
        mm.b("TEST_DATE initData get value %s ", e().l().b());
        this.d.setText(e().l().b());
        this.e.setText(e().l().a());
        a(aof.a().f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.b.setClickable(z);
        this.b.setBackgroundColor(z ? 0 : q().getColor(R.color.wallet_hint_foreground_holo_dark));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.timezone_pickup_layout /* 2131690204 */:
                e().a(atl.FOTA_UPDATE_PAGE_SETTING_TIMEZONE_PICKUP, null);
                break;
            case R.id.aotu_update_time_layout /* 2131690407 */:
                e().a(atl.FOTA_UPDATE_PAGE_SETTING_TIME_PICKUP, null);
                break;
        }
    }
}
