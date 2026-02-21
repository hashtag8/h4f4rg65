package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class apc extends aoj {
    private aro a;
    private RelativeLayout b;
    private ImageView c;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_connecting_to_speaker, viewGroup, false);
        this.c = (ImageView) this.b.findViewById(R.id.circle_spinner);
        this.a = new aro(this.c, p().getResources().getColor(R.color.blue_bg));
        this.a.a(arj.d, 33);
        this.c.animate().rotation(300.0f).setDuration(1000L).start();
        this.a.c();
        mq.c().schedule(new Runnable() { // from class: apc.1
            @Override // java.lang.Runnable
            public void run() {
                if ((apc.this.an().n().e() == 2 || apc.this.an().n().e() == 4 || apc.this.an().n().e() == 5 || apc.this.an().n().e() == 3) && apc.this.an().n().n() != null && apc.this.an().n().n().q() != 3) {
                    apc.this.an().a(aoi.SOURCE_SETUP, (Bundle) null);
                } else {
                    apc.this.an().a(aoi.SETUP_ROOM_RESULT, (Bundle) null);
                }
                apc.this.a.d();
            }
        }, 10L, TimeUnit.SECONDS);
        return this.b;
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(false);
        an().c(false);
        a(false);
        this.b.requestLayout();
        an().d(false);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        an().d(true);
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.CONNECTING_TO_SPEAKER;
    }
}
