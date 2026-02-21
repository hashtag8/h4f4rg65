package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avv extends ajj implements avx {
    private static awj f;
    private String a;
    private awk b;
    public List<MusicData> c;
    private int d;
    private String e;
    private ask g;
    private boolean h;

    public int an() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public String ao() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public static awj ap() {
        return f;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        DashboardActivity dashboardActivity = (DashboardActivity) p();
        if (dashboardActivity.n() == null) {
            this.b = new awk(dashboardActivity, this);
            dashboardActivity.a(this.b);
        }
    }

    public void a(bjl bjlVar, String str, String str2, ArrayList<bjn> arrayList, boolean z) {
        avn avnVar = new avn();
        avnVar.c(str);
        Bundle bundle = new Bundle();
        bundle.putSerializable("action", bjlVar);
        bundle.putString("id", str);
        bundle.putString("name", str2);
        bundle.putSerializable("devicelist", arrayList);
        if (z) {
            this.ae.q().a(avnVar, bundle, 8);
        } else {
            avnVar.g(bundle);
            this.ae.q().a(avnVar, (arc) null);
        }
    }

    public void a(List<bjp> list, String str, ArrayList<bjn> arrayList, bjq bjqVar) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putSerializable("devicelist", arrayList);
        bundle.putSerializable("items", (ArrayList) list);
        bundle.putSerializable("service", bjqVar);
        this.ae.q().b(new awb(), bundle, 8);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return aq().g(R.string.SettingShoutCast_Str).c();
    }

    protected ajv.a aq() {
        return new ajv.a().d(R.color.black).e(q().getColor(R.color.white)).c(true).k(R.drawable.local_search_icon).a(new MenuItem.OnMenuItemClickListener() { // from class: avv.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                return true;
            }
        });
    }

    public void a(final AdapterView<?> adapterView, final int i) {
        this.ae.a(new Runnable() { // from class: avv.2
            @Override // java.lang.Runnable
            public void run() {
                if (i <= adapterView.getAdapter().getCount()) {
                    avv.this.e(i);
                }
            }
        });
    }

    public void e(int i) {
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().a(this.c, i);
        this.ae.U();
    }

    public String ax() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        a((avx) this);
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        if (this.h) {
            this.h = false;
            awe.a(null, 0, this.ae);
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        ((DashboardActivity) p()).a((avx) null);
    }

    @Override // defpackage.avx
    public void ay() {
        avw.b = false;
        awi awiVarO = ((DashboardActivity) p()).o();
        if (awiVarO != null && awiVarO.a) {
            awiVarO.a();
        }
        if (this.ae.q().a() instanceof avw) {
            ((avw) this).d();
        }
    }

    protected void a(avx avxVar) {
        ((DashboardActivity) p()).a((avx) this);
    }

    public boolean az() {
        if (p() == null) {
            return false;
        }
        awi awiVarO = ((DashboardActivity) p()).o();
        if (awiVarO == null || !awiVarO.a) {
            return false;
        }
        awiVarO.a();
        return true;
    }

    public void a(Dialog dialog, Context context) {
        if (dialog != null && !dialog.isShowing() && context != null) {
            dialog.show();
        }
    }

    public void b(Dialog dialog, Context context) {
        if (dialog != null && dialog.isShowing() && context != null) {
            dialog.dismiss();
        }
    }

    public void b(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("MyPref", 0).edit();
            editorEdit.putString("DEVICE_UDN", str);
            editorEdit.commit();
        }
    }

    public String b(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("MyPref", 0).getString("DEVICE_UDN", "DEVICE_NOT_FOUND");
    }

    public Dialog c(Context context) {
        Dialog dialog = new Dialog(context, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_loader);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().gravity = 17;
        return dialog;
    }

    public void a(final Context context, String str, String str2, final boolean z) {
        if (context != null) {
            new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: avv.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    avw.d = 0;
                    if (z) {
                        awe.a("MAIN", 0, context);
                    }
                    if (avv.this instanceof avw) {
                        avw avwVar = (avw) avv.this;
                        avw.a = false;
                        avwVar.aD();
                    }
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (!(this instanceof avw) && this.g == null) {
            this.g = new ask(this.ae, new asj() { // from class: avv.4
                @Override // defpackage.asj
                public void a(String str) {
                    if (!avv.this.y()) {
                        avv.this.h = true;
                    } else {
                        awe.a(null, 0, avv.this.ae);
                    }
                }
            });
            this.g.a();
        }
    }

    @Override // defpackage.ajj
    public void e() {
        super.e();
        if (this.g != null) {
            this.g.b();
        }
    }
}
