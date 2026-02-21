package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.upgrade.FotaUpdateMasterActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atn extends atm {
    private RelativeLayout a;
    private RelativeLayout b;
    private TextView c;
    private TextView d;
    private List<adx> e;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_fota_updated_setting, (ViewGroup) null);
        this.b = (RelativeLayout) viewInflate.findViewById(R.id.timezone_pickup_layout);
        this.a = (RelativeLayout) viewInflate.findViewById(R.id.time_pickup_layout);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: atn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                atn.this.e().a(atl.FOTA_UPDATE_PAGE_SETTING_TIMEZONE_PICKUP, null);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: atn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                atn.this.e().a(atl.FOTA_UPDATE_PAGE_SETTING_TIME_PICKUP, null);
            }
        });
        this.c = (TextView) viewInflate.findViewById(R.id.timezone_pickup_value);
        this.d = (TextView) viewInflate.findViewById(R.id.time_pickup_value);
        return viewInflate;
    }

    private void al() {
        e().b(a(R.string.FotaSilenceUpdateSettings));
        if (e().l() == null) {
            e().a(new atf());
            am();
        }
        this.d.setText(e().l().b());
        this.c.setText(e().l().a());
        mm.b("TEST_DEVICE_FOTA_CHANGE FotaTimeZoneBean  timeZoneValue = %s , time_value = %s", 0, this.d.getText().toString());
        if (!TextUtils.isEmpty(this.d.getText().toString()) && !TextUtils.isEmpty(this.c.getText().toString())) {
            a(true);
            e().b(true);
        }
    }

    private void am() {
        for (adx adxVar : this.e) {
            if (adxVar.h() != null && adxVar.h().f != -1) {
                e().l().a(aht.a(adxVar.h().f));
                return;
            }
        }
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        this.e = (List) l().getSerializable(FotaUpdateMasterActivity.n);
        al();
    }

    @Override // defpackage.atm
    public void d() {
        an();
        e().a(atl.FOTA_UPDATE_PAGE_PROCESS, null);
    }

    private void an() {
        if (e().l() != null && this.e != null) {
            mq.b().b(new Runnable() { // from class: atn.3
                @Override // java.lang.Runnable
                public void run() {
                    for (adx adxVar : atn.this.e) {
                        adw.a().a(adxVar, atn.this.e().l().a());
                        adw.a().a(adxVar, atn.this.e().l().c());
                        mm.b("TEST_TIMEZONE_SILENTTIME timezone = %s , silent time = %s", atn.this.e().l().a(), atn.this.e().l().c());
                    }
                }
            });
        }
    }
}
