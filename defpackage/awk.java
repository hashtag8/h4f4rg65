package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.stc.upnp.services.DlnaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class awk implements bja {
    private static int p = 1;
    public TextView a;
    private Context b;
    private ArrayList<bjn> c;
    private ListView d;
    private avv e;
    private awa f;
    private int g;
    private LayoutInflater h;
    private Handler i;
    private PopupWindow j;
    private a l;
    private Dialog m;
    private avv o;
    private boolean k = false;
    private boolean n = false;

    public awk(Context context, avv avvVar) {
        this.o = avvVar;
        this.b = context;
        bkj.a().a(this);
        this.h = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = bkj.a().c();
        this.f = (avw) this.o;
        a();
    }

    public void a(avv avvVar) {
        this.e = avvVar;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(TextView textView) {
        this.a = textView;
    }

    public void a(TextView textView, avv avvVar, int i) {
        if (textView != null) {
            a(textView);
        }
        if (avvVar == null) {
            avvVar = this.e;
        } else {
            a(avvVar);
        }
        if (i == -200) {
            i = this.g;
        } else {
            a(i);
        }
        if (i == -100) {
            if (avvVar.ax() != null && avvVar.ax().equalsIgnoreCase("0")) {
                c();
                return;
            } else {
                this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
        }
        if (i == 0) {
            c();
        } else {
            this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void a(avv avvVar, View view, Activity activity) {
        if (avvVar.ax() != null && avvVar.ax().equalsIgnoreCase("0")) {
            ((DashboardActivity) activity).n().a(view);
        }
    }

    public void a(ArrayList<bjn> arrayList) {
        synchronized (this.c) {
            this.c.clear();
            this.c.addAll(arrayList);
            this.k = true;
            a((TextView) null, (avv) null, -200);
            if (this.l != null) {
                this.l.clear();
                f();
                this.l.addAll(this.c);
                this.l.notifyDataSetChanged();
            }
        }
    }

    private void f() {
        bjn bjnVar = new bjn();
        bjnVar.m("Search for new servers...");
        synchronized (this.c) {
            if (this.c != null && this.c.size() > 0) {
                this.c.add(0, bjnVar);
            }
        }
    }

    public void a() {
        this.m = a(this.b);
        this.j = new PopupWindow(this.b);
        this.i = new Handler();
        b();
    }

    public void b() {
        this.d = new ListView(this.b);
        this.d.setDivider(new ColorDrawable(this.b.getResources().getColor(R.color.trans_white)));
        this.d.setDividerHeight(1);
        this.d.setCacheColorHint(0);
        this.d.setBackgroundColor(Color.parseColor("#343434"));
        this.d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: awk.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final bjn bjnVar = (bjn) adapterView.getItemAtPosition(i);
                if (i == 0) {
                    awk.this.n = true;
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressViewId);
                    if (progressBar != null) {
                        progressBar.setVisibility(0);
                        if (awk.this.f != null) {
                            awk.this.f.a(true, System.currentTimeMillis());
                        }
                        awk.this.a(20000L, progressBar);
                    }
                    awe.c(awk.this.b);
                    return;
                }
                if (bkj.a().e() == null || !bkj.a().e().c().equalsIgnoreCase(bjnVar.c())) {
                    awk.this.j.dismiss();
                    awk.this.a(awk.this.m, awk.this.b);
                    ArrayList<bjq> arrayListF = bjnVar.f();
                    for (int i2 = 0; i2 < arrayListF.size(); i2++) {
                        if (arrayListF.get(i2).a().contains("urn:schemas-upnp-org:service:ContentDirectory")) {
                            final bjq bjqVar = arrayListF.get(i2);
                            final bjl bjlVarF = bjqVar.f("Search");
                            if (bjlVarF == null) {
                                awk.this.b(awk.this.m, awk.this.b);
                                awk.this.a(bjqVar, bjnVar);
                                return;
                            }
                            bky.a("0", bjlVarF, new bjb() { // from class: awk.1.1
                                @Override // defpackage.bjb
                                public void a(List<bjp> list, int i3, int i4) {
                                    awk.this.b(awk.this.m, awk.this.b);
                                    if (list != null) {
                                        if (list.size() == 0) {
                                            awk.this.a(bjqVar, bjnVar);
                                        } else {
                                            awk.this.a(list, bjlVarF, bjnVar, bjqVar);
                                        }
                                    }
                                }

                                @Override // defpackage.bjb
                                public void a(String str) {
                                    awk.this.b(awk.this.m, awk.this.b);
                                    if (awk.this.j != null && awk.this.j.isShowing()) {
                                        awk.this.j.dismiss();
                                    }
                                    awk.this.a(awk.this.b, "Error in accessing content", "Connection error | Server connection failed", false);
                                    if (awk.this.b != null) {
                                        Toast.makeText(awk.this.b, awk.this.b.getResources().getString(R.string.DLNA_DMSUnavailableTitle), 0).show();
                                    }
                                }
                            }, 0, 100, DlnaService.e, true);
                        }
                    }
                    return;
                }
                awk.this.j.dismiss();
                Toast.makeText(awk.this.b, "Server already selected", 0).show();
            }
        });
    }

    public void a(bjq bjqVar, bjn bjnVar) {
        bkj.a().d(bjnVar);
        this.o.b(this.b, bjnVar.c());
        this.o.a(bjqVar.f("Browse"), "0", bjnVar.a(), this.c, true);
    }

    public void a(List<bjp> list, bjl bjlVar, bjn bjnVar, bjq bjqVar) {
        bkj.a().d(bjnVar);
        this.o.b(this.b, bjnVar.c());
        this.o.a(list, bjnVar.a(), this.c, bjqVar);
    }

    public PopupWindow a(View view) {
        ArrayList<bjn> arrayListC = bkj.a().c();
        if (this.d.getAdapter() == null) {
            this.l = new a(this.b, android.R.layout.simple_list_item_1, arrayListC);
            this.d.setAdapter((ListAdapter) this.l);
        }
        a(arrayListC);
        if (aho.c("deviceNumber") < this.c.size()) {
            aho.a("deviceNumber", this.c.size());
        }
        this.j.setFocusable(true);
        int[] iArrB = awe.b(this.b);
        this.j.setWidth(iArrB[0]);
        final int i = iArrB[1] / 3;
        this.j.setHeight(-2);
        new ahw().a(this.d, new ahq() { // from class: awk.2
            @Override // defpackage.ahq
            public void a(View view2) {
                if (view2.getMeasuredHeight() > i) {
                    view2.getLayoutParams().height = i;
                }
            }
        });
        this.j.setContentView(this.d);
        this.j.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: awk.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                awk.this.d();
            }
        });
        this.j.showAsDropDown(view, 0, 18);
        this.k = false;
        d();
        return this.j;
    }

    public void c() {
        if (this.o != null && (this.o instanceof avw)) {
            avw avwVar = (avw) this.o;
            if (avwVar.c() != null) {
                awg awgVarC = avwVar.c();
                if (awgVarC != null && awgVarC.d()) {
                    this.k = true;
                } else {
                    this.k = false;
                }
            }
        }
        d();
    }

    public void a(long j, final ProgressBar progressBar) {
        this.i.postDelayed(new Runnable() { // from class: awk.4
            @Override // java.lang.Runnable
            public void run() {
                if (awk.this.f != null) {
                    awk.this.f.a(false, 0L);
                }
                awk.this.k = false;
                awk.this.n = false;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                awk.this.d();
            }
        }, j);
    }

    public void d() {
        int i;
        if (this.a != null) {
            if (this.j.isShowing()) {
                i = R.drawable.drop_down_icon_up;
            } else {
                i = R.drawable.drop_down_icon_down;
            }
            if (this.b != null && (((DashboardActivity) this.b).q().a() instanceof avw)) {
                this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
        }
    }

    @Override // defpackage.bja
    public void a(bjn bjnVar) {
        int i;
        if (this.b != null) {
            if (this.j != null && this.j.isShowing()) {
                i = R.drawable.drop_down_with_notification_up;
            } else {
                i = R.drawable.drop_down_with_notification;
            }
            a(bkj.a().c());
            if (this.a != null && !(((DashboardActivity) this.b).q().a() instanceof avw)) {
                if (this.a.getText().toString().equals(bkj.a().e().a()) && aho.c("deviceNumber") < this.c.size()) {
                    aho.a("deviceNumber", this.c.size());
                    this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
                }
                this.a.invalidate();
            }
        }
    }

    @Override // defpackage.bja
    public void b(bjn bjnVar) {
        a(bkj.a().c());
        aho.a("deviceNumber", this.c.size());
        if (this.b != null && this.a != null && !(((DashboardActivity) this.b).q().a() instanceof avw)) {
            if (bkj.a().e() != null && bkj.a().e().c().equals(bjnVar.c())) {
                if (avv.ap() != null) {
                    avv.ap().a();
                }
                bkx.a("ServerGone Details " + new Date().toString() + "Server name " + bjnVar.a());
                new AlertDialog.Builder(this.b).setTitle("DMS Unavailable").setMessage(bjnVar.a() + " DMS has gone away.Please connect your server to network and try again").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: awk.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        avw.a = false;
                        awe.a("MAIN", 0, awk.this.b);
                        awk.this.e();
                        dialogInterface.dismiss();
                    }
                }).show();
                return;
            }
            Toast.makeText(this.b, "Device Removed " + bjnVar.a(), 0).show();
        }
    }

    public void e() {
        if (this.j != null && this.j.isShowing()) {
            this.j.dismiss();
        }
    }

    class a extends ArrayAdapter<bjn> {
        public a(Context context, int i, List<bjn> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            if (awk.this.c == null || awk.this.c.size() <= 0) {
                return 0;
            }
            return awk.this.c.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = awk.this.h.inflate(R.layout.server_popup_view_item, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.itemTextView);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressViewId);
            textView.setText(((bjn) awk.this.c.get(i)).a());
            textView.setTag(Integer.valueOf(i));
            if (i == 0 && awk.this.n) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
            if (bkj.a().e() != null && textView.getText().equals(bkj.a().e().a())) {
                textView.setTextColor(awk.this.b.getResources().getColor(R.color.selected_server_color));
                Drawable drawable = getContext().getResources().getDrawable(R.drawable.circle_shape_colored);
                drawable.setBounds(10, 10, 30, 30);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else {
                textView.setTextColor(-1);
                textView.setCompoundDrawables(null, null, null, null);
            }
            return view;
        }
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

    public Dialog a(Context context) {
        Dialog dialog = new Dialog(context, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_loader);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().gravity = 17;
        return dialog;
    }

    public void a(final Context context, String str, String str2, final boolean z) {
        if (context != null) {
            new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: awk.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        awe.a("MAIN", 0, context);
                    }
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }
}
