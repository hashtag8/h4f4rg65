package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import defpackage.aro;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class apg extends aoj {
    aro a;
    private ImageView b;
    private boolean c = false;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_retry_wifi, (ViewGroup) null);
        this.b = (ImageView) viewInflate.findViewById(R.id.retryWifi_tutorialImage);
        this.a = new aro(this.b);
        a(l().getBoolean("SHOW_NEXT_BUTTON", true));
        return viewInflate;
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
        this.a.d();
        this.a.a((aro.e) null);
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().c(a(R.string.kRoomSetupTutorialResetSpeaker_Str));
        am();
    }

    @Override // defpackage.aoj
    public void e() {
        an().h(true);
        an().a(aoi.WIFI_SETUP_LIST, l());
    }

    private void am() {
        this.a.a(arj.e, 66);
        this.a.a(1);
        this.a.a(new aro.e() { // from class: apg.1
            @Override // aro.e
            public void a() {
                apg.this.a.d();
                apg.this.a.b();
                apg.this.a.a(1);
                if (apg.this.c) {
                    apg.this.a.a(arj.e, 66);
                    apg.this.a.b(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                    apg.this.c = false;
                } else {
                    apg.this.a.b(arj.e, 66);
                    apg.this.a.b(5000);
                    apg.this.c = true;
                }
            }
        });
        this.a.b(2000);
    }
}
