package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aov extends aoj {
    RelativeLayout a;
    private ahx b;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (RelativeLayout) layoutInflater.inflate(R.layout.adapt_51_introduction_layout, viewGroup, false);
        this.b = ahx.a();
        return this.a;
    }

    @Override // defpackage.aoj
    public void b() {
        an().e(true);
        an().c(a(R.string.kSetupStereoIntroOverview_Str));
        an().c(true);
        an().b(a(R.string.Start_Str));
        this.a.requestLayout();
    }

    @Override // defpackage.aoj
    public void c() {
        an().b(a(R.string.Next_Str));
    }

    @Override // defpackage.aoj
    public void e() {
        an().a(aoi.CHANNEL_SETUP_TUTORIAL, l());
    }

    @Override // defpackage.aoj
    public aoi as() {
        return aoi.ADAPT_51_Intro;
    }
}
