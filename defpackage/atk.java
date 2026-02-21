package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atk extends atm {
    private aez a;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_fota_updated_lower_battery, (ViewGroup) null);
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        e().b(a(R.string.FotaUpdateSpeaker_Str));
        e().b(false);
        al();
    }

    private void al() {
        mq.a("CHECKING_OMNI50_ACSTATES").a(new Runnable() { // from class: atk.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                while (i < 10) {
                    int i2 = i + 1;
                    try {
                        Thread.sleep(1000L);
                        if (i2 > 5 && atk.this.a(aof.a().f()) == 1) {
                            atk.this.e().a(atl.FOTA_UPDATE_PAGE_SETTING, null);
                            return;
                        }
                        if (i2 == 10) {
                            mo.a.a(new Runnable() { // from class: atk.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (atk.this.a(aof.a().f()) != 2) {
                                        atk.this.am();
                                    } else {
                                        atk.this.e().b(true);
                                    }
                                }
                            });
                        }
                        mm.b("TEST_DEVICE_FOTA_CHANGE checkingOmni50HasAcOn  count =  %s", Integer.valueOf(i2));
                        i = i2;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        mo.a.a(new Runnable() { // from class: atk.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                atk.this.e().b(true);
                            }
                        });
                        i = i2;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        this.a = new aez() { // from class: atk.2
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                if (atk.this.a(list) == 1) {
                    atk.this.e().a(atl.FOTA_UPDATE_PAGE_SETTING, null);
                }
            }
        };
        aof.a().c().a(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(List<adx> list) {
        int i = 2;
        Iterator<adx> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                adx next = it.next();
                if (next.q() == 6 && aof.a().b(next) != 0 && next.h() != null) {
                    if (next.h().e == 1 || (next.h().e == 0 && next.h().d >= 20)) {
                        i2 = 1;
                    }
                    if (next.h().e == 0 && next.h().d < 20) {
                        i2 = 0;
                    }
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
        aof.a().c().b(this.a);
    }

    @Override // defpackage.atm
    public void d() {
        e().a(atl.FOTA_UPDATE_PAGE_SETTING, null);
    }
}
