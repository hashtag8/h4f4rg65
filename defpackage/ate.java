package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.harman.hkconnect.upgrade.FotaUpdateMasterActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ate {
    private aey a;
    private boolean b;
    private boolean c = false;
    private ba d;
    private atj e;

    public ate(ba baVar, final asy asyVar) {
        this.d = baVar;
        this.a = new aez() { // from class: ate.1
            @Override // defpackage.aez, defpackage.aey
            public void a(final List<adx> list) {
                mo.a.a(new Runnable() { // from class: ate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mm.b("TEST_DEVICE_FOTA_CHANGE reason for return, has unset room device = % , don`t allow to pop = % , is open upgrede = % ,start = %s", Boolean.valueOf(aoz.g(list)), Boolean.valueOf(ain.b), true, Boolean.valueOf(ate.this.b));
                        if (!aoz.g(list) && ain.b && ate.this.b) {
                            if (asyVar == null || asyVar.c() == null || !asyVar.c().isShowing()) {
                                if (!ate.this.c(list)) {
                                    ate.this.a(ate.this.a(list));
                                    return;
                                }
                                return;
                            }
                            mm.b();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c(List<adx> list) {
        boolean z = true;
        synchronized (this) {
            List<adx> listB = b(list);
            if (listB.size() != 0) {
                mm.b("TEST_DEVICE_FOTA_CHANGE showSuccessMessage success speakes = %s", Integer.valueOf(listB.size()));
                if (this.e == null || !this.e.z()) {
                    d(listB);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public ArrayList<adx> a(List<adx> list) {
        ArrayList<adx> arrayList = new ArrayList<>();
        for (adx adxVar : list) {
            mm.e("TEST_DEVICE_FOTA_CHANGE update way = " + aof.a().b(adxVar) + " d = " + adxVar, new Object[0]);
            if (aof.a().b(adxVar) != 0 && aof.a().b(adxVar) > 0) {
                arrayList.add(adxVar);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        mm.e("FOTA UPGRADE device list contains speakers to be upgraded", new Object[0]);
        Collections.sort(arrayList, new atd());
        return arrayList;
    }

    public List<adx> b(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            String strD = aho.d(String.valueOf(adxVar.P()));
            if (!TextUtils.isEmpty(strD) && ahv.a(adxVar.n(), strD)) {
                mm.e("TEST_DEVICE_FOTA_CHANGE get time out speaker uuid = %s , version = %s", Long.valueOf(adxVar.P()), strD);
                arrayList.add(adxVar);
                aho.e(String.valueOf(adxVar.P()));
            }
        }
        return arrayList;
    }

    private void d(List<adx> list) {
        bj bjVarA = this.d.f().a();
        Fragment fragmentA = this.d.f().a("dialog");
        if (fragmentA != null) {
            bjVarA.a(fragmentA);
        }
        this.e = atj.a(list);
        bjVarA.a(this.e, "dialog");
        if (this.d != null && !this.d.isFinishing() && !this.d.isDestroyed()) {
            bjVarA.e();
        }
    }

    public void a() {
        if (!this.b) {
            this.b = true;
            aof.a().c().a(this.a);
            mm.b("TEST_DEVICE_FOTA_CHANGE start monitor", new Object[0]);
        }
    }

    public void b() {
        this.b = false;
        aof.a().c().b(this.a);
        mm.b("TEST_DEVICE_FOTA_CHANGE stop monitor", new Object[0]);
    }

    public synchronized void a(ArrayList<adx> arrayList) {
        if (arrayList != null) {
            if (!arrayList.isEmpty() && this.b) {
                this.b = false;
                b();
                mm.b("TEST_DEVICE_FOTA_CHANGE startFotaUpdateActivitycurrent deviceFcs size = %s", Integer.valueOf(arrayList.size()));
                Intent intent = new Intent(this.d, (Class<?>) FotaUpdateMasterActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(FotaUpdateMasterActivity.n, new ArrayList(arrayList));
                bundle.putInt(FotaUpdateMasterActivity.m, 0);
                intent.putExtras(bundle);
                this.d.startActivity(intent);
                this.c = true;
            }
        }
    }

    public boolean c() {
        return this.c;
    }
}
