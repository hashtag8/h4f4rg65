package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.musicservice.juke.model.JukeMusicRadio;
import defpackage.aih;
import defpackage.ajv;
import defpackage.axd;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class axu extends axk implements ajn, axd.a, axd.b {
    private View a;
    private AnimationGridView ak;
    private ProgressDialog am;
    private aih<JukeMusicRadio> b;
    private ArrayList<JukeMusicRadio> aj = new ArrayList<>();
    private final int al = 50;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b7, code lost:
    
        r0 = r6.aj.get(r3);
     */
    @Override // axd.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r7, org.json.JSONObject r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.axu.a(java.lang.String, org.json.JSONObject, java.lang.String):void");
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
        al();
        Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
    }

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        mm.b("URLs", "" + z);
        if (z) {
            axc.a().a("catalog:radios", this, "", "", 0, 50);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.juke_grid_animation, (ViewGroup) null);
        this.ak = (AnimationGridView) this.a.findViewById(R.id.group_gridview);
        this.am = new ProgressDialog(this.ae, 4);
        this.am.setCanceledOnTouchOutside(false);
        this.am.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: axu.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                axu.this.ae.onBackPressed();
            }
        });
        this.b = new aih<>(this.ae, new a(), 50, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        this.b.a(this.aj);
        this.ak.setNeedAddFooter(false);
        this.ak.setAdapter((ListAdapter) this.b);
        return this.a;
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.ak.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.ak.setAdapter((ListAdapter) this.b);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        if (z()) {
            awp.a = 4;
        }
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        d();
        this.aj.clear();
        this.b.a(this.aj);
        this.b.notifyDataSetChanged();
        this.ak.setOnItemChosenListener(this);
        this.ak.setOnScrollListener(new awv(this.ae));
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeRadios).c();
    }

    @Override // defpackage.ajn
    public void a(View view, int i, Object obj) {
        if (aof.a().l() && !ain.j) {
            Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        this.am.setMessage(a(R.string.kAndroid_Loading));
        new asc(this.am).a(p());
        axc.a().a(((JukeMusicRadio) obj).b, "catalog:radio", this, "" + obj, "", -1, -1);
    }

    class a implements aih.a<JukeMusicRadio> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, JukeMusicRadio jukeMusicRadio) {
            C0085a c0085a;
            C0085a c0085a2 = (C0085a) view.getTag();
            if (c0085a2 == null) {
                c0085a = new C0085a();
                c0085a.a = (ImageView) view.findViewById(R.id.iv);
                c0085a.b = (TextView) view.findViewById(R.id.tv);
                view.setTag(c0085a);
            } else {
                c0085a = c0085a2;
            }
            c0085a.b.setText(jukeMusicRadio.a);
            c0085a.a.setVisibility(0);
            bif.a((Context) axu.this.ae).a(jukeMusicRadio.b.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0085a.a);
            return view;
        }

        /* JADX INFO: renamed from: axu$a$a, reason: collision with other inner class name */
        class C0085a {
            public ImageView a;
            public TextView b;

            C0085a() {
            }
        }
    }
}
