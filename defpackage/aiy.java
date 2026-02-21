package defpackage;

import android.database.Cursor;
import android.widget.AdapterView;
import android.widget.ListView;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.aif;

/* JADX INFO: loaded from: classes.dex */
public abstract class aiy<T> implements aif.a<T> {
    protected DashboardActivity c;
    protected aix d;
    protected ListView e;
    protected Cursor f;

    protected abstract AdapterView.OnItemClickListener a();

    protected abstract ajn b();

    protected abstract String c();

    protected abstract aif.b d();

    public aiy(DashboardActivity dashboardActivity, aix aixVar, ListView listView) {
        this.c = dashboardActivity;
        this.d = aixVar;
        this.e = listView;
    }

    protected void a(Cursor cursor) {
        this.f = cursor;
    }
}
