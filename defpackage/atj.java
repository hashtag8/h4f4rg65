package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import com.harman.hkconnect.upgrade.FotaUpdateMasterActivity;
import defpackage.apx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atj extends az {
    private apx ae;
    private RecyclerView af;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_updated_devices, (ViewGroup) null);
        viewInflate.setBackgroundResource(R.drawable.central_content);
        viewInflate.findViewById(R.id.updating_warning_layout).setVisibility(4);
        viewInflate.findViewById(R.id.fragment_device_update_msg).setVisibility(4);
        this.af = (RecyclerView) viewInflate.findViewById(R.id._fragment_updateDevices_deviceList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(1);
        this.af.setLayoutManager(linearLayoutManager);
        List<adx> list = (List) l().getSerializable(FotaUpdateMasterActivity.n);
        brw.a(list, "devices", new Object[0]);
        this.ae = new apx(p(), null);
        b(list);
        this.af.setAdapter(this.ae);
        mo.a.postDelayed(new Runnable() { // from class: atj.1
            @Override // java.lang.Runnable
            public void run() {
                if (atj.this.p() != null && !atj.this.p().isFinishing() && !atj.this.p().isDestroyed()) {
                    atj.this.c();
                }
            }
        }, 3500L);
        return viewInflate;
    }

    @Override // defpackage.az, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        a(0, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
    }

    @Override // defpackage.az
    public Dialog c(Bundle bundle) {
        Dialog dialogC = super.c(bundle);
        dialogC.requestWindowFeature(1);
        dialogC.setCanceledOnTouchOutside(false);
        return dialogC;
    }

    static atj a(List<adx> list) {
        atj atjVar = new atj();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FotaUpdateMasterActivity.n, new ArrayList(list));
        atjVar.g(bundle);
        return atjVar;
    }

    public void b(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            if (adxVar.M() == null) {
                mm.b("No upgrade version for %s", adxVar);
            } else {
                apx.b bVar = new apx.b(new adx(adxVar.R(), adxVar.h()));
                bVar.a(apx.c.SUCCESS);
                arrayList.add(bVar);
            }
        }
        this.ae.a(arrayList);
    }
}
