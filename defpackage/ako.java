package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class ako extends ajj {
    public DashboardActivity a;
    private View b;
    private LinearLayout c;

    public abstract View c();

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.a = (DashboardActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.base_menu_fragment, (ViewGroup) null);
        this.c = (LinearLayout) this.b.findViewById(R.id.left_menu);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        b(c());
        return this.b;
    }

    public void b(View view) {
        this.c.removeAllViews();
        this.c.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }
}
