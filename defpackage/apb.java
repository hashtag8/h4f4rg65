package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apb extends aoj {
    public BroadcastReceiver a = new BroadcastReceiver() { // from class: apb.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                mm.b("网络状态改变", new Object[0]);
                if (((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && apb.this.am()) {
                    new CountDownTimer(15000L, 1000L) { // from class: apb.1.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            apb.this.an().c(true);
                        }
                    }.start();
                }
            }
        }
    };
    private ahx b;
    private IntentFilter c;
    private View d;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(R.layout.fragment_network_check, (ViewGroup) null);
        this.b = ahx.a();
        return this.d;
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        this.c = new IntentFilter();
        this.c.addAction("android.net.wifi.STATE_CHANGE");
        p().registerReceiver(this.a, this.c);
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
        p().unregisterReceiver(this.a);
    }

    @Override // defpackage.aoj
    public void e() {
        List<adx> listA = aoz.a(aof.a().f());
        if (aoz.a(apz.a, listA)) {
            if (an().n().u().b(listA)) {
                a(listA);
                return;
            } else {
                d(0);
                return;
            }
        }
        an().a(aoi.SETUP_FAIL, (Bundle) null);
    }

    private void d(int i) {
        Toast.makeText(p(), "Not enough speakers", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean am() {
        String strD = aho.d("CurrentSSID");
        return (TextUtils.isEmpty(strD) || this.b == null || TextUtils.isEmpty(this.b.b()) || !this.b.b().replace("\"", "").trim().equals(strD)) ? false : true;
    }

    public void a(List<adx> list) {
        if (an().n().u().a(list)) {
            an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
            return;
        }
        an().n().a(list);
        an().n().w();
        an().a(aoi.SETUP_ROOM_RESULT, (Bundle) null);
    }
}
