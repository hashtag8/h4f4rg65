package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import com.musicservice.rdio.RdioLoginActivity;
import defpackage.arw;
import defpackage.azo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class azr extends azs {
    protected static String b;
    public static azr c;
    protected BaseAdapter a;
    private TextView ar;
    private RelativeLayout as;
    private Button at;
    private LayoutInflater au;
    private ArrayList<String> av;
    private arw aw;

    class a extends BaseAdapter {
        public a(Context context) {
            azr.this.au = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return azr.this.av.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = azr.this.au.inflate(R.layout.rdio_options_cell, (ViewGroup) null);
                bVar = new b();
                bVar.a = (TextView) view.findViewById(R.id.rdio_options_text);
                bVar.a.setTypeface(ahu.a(azr.this.ae));
                bVar.b = (ImageView) view.findViewById(R.id.rdio_options_button);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a.setText((CharSequence) azr.this.av.get(i));
            bVar.b.setOnClickListener(new View.OnClickListener() { // from class: azr.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!ahh.e(azr.this.ae)) {
                        azc.a(azr.this.ae, azr.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                        return;
                    }
                    if (!azs.ak && azr.this.at.getText().equals(azr.this.q().getString(R.string.RdioLogin_Str))) {
                        azr.this.a(new Intent(azr.this.p(), (Class<?>) RdioLoginActivity.class), i);
                        return;
                    }
                    if (i == 0) {
                        azr.this.ae.q().a(new azz(), (arc) null);
                        return;
                    }
                    if (i == 1) {
                        azo azoVarD = azo.d(azo.b.EGridTypeReleases.a());
                        Bundle bundle = new Bundle();
                        bundle.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeReleases.a());
                        azoVarD.g(bundle);
                        azr.this.ae.q().a(azoVarD, (arc) null);
                        return;
                    }
                    if (i == 2) {
                        azr.this.ae.q().a(new ayv(), (arc) null);
                    }
                }
            });
            return view;
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        if (i == 0) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                this.ae.q().a(new azz(), (arc) null);
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 1) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                azo azoVarD = azo.d(azo.b.EGridTypeReleases.a());
                Bundle bundle = new Bundle();
                bundle.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeReleases.a());
                azoVarD.g(bundle);
                this.ae.q().a(azoVarD, (arc) null);
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 2) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                this.ae.q().a(new ayv(), (arc) null);
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 4) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                azo azoVarD2 = azo.d(azo.b.EGridTypeFavourites.a());
                Bundle bundle2 = new Bundle();
                bundle2.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeFavourites.a());
                azoVarD2.g(bundle2);
                this.ae.q().a(azoVarD2, (arc) null);
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 5) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                azo azoVarD3 = azo.d(azo.b.EGridTypePlaylists.a());
                Bundle bundle3 = new Bundle();
                bundle3.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypePlaylists.a());
                azoVarD3.g(bundle3);
                this.ae.q().a(azoVarD3, (arc) null);
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
                return;
            }
            return;
        }
        if (i == 10) {
            p();
            if (i2 == -1) {
                mm.b("\n" + i, new Object[0]);
                c();
                return;
            }
            p();
            if (i2 == 0) {
                a(true);
                azc.a(this.ae, q().getString(R.string.RdioFailedLogin_Str));
                mm.b("\n" + i, new Object[0]);
            }
        }
    }

    protected void c() {
        this.at.setText(q().getString(R.string.RdioLogout_Str));
        b = an();
        this.ar.setText(b);
        this.as.setVisibility(0);
        ak = true;
        al.a(al());
        al.a(am());
        d();
    }

    protected void a(boolean z) {
        this.at.setText(q().getString(R.string.RdioLogin_Str));
        this.as.setVisibility(8);
        if (z) {
            ao();
        }
        ak = false;
        a(new Class[0]);
    }

    static class b {
        TextView a;
        ImageView b;

        b() {
        }
    }

    public void d() {
        Set<String> set;
        SharedPreferences sharedPreferences = p().getApplicationContext().getSharedPreferences("", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Set<String> setKeySet = all.keySet();
        long time = new Date().getTime();
        for (String str : setKeySet) {
            if (str.startsWith("RdioStation") && (all.get(str) instanceof Set) && (set = (Set) all.get(str)) != null) {
                long jLongValue = 0;
                for (String str2 : set) {
                    if (str2.startsWith("date=")) {
                        jLongValue = Long.valueOf(str2.replace("date=", "")).longValue();
                    }
                }
                if (time - jLongValue > 3600000) {
                    editorEdit.remove(str);
                }
            }
        }
        editorEdit.apply();
    }

    public String al() {
        return p().getApplicationContext().getSharedPreferences("", 0).getString("HK_Rdio_User_Key", null);
    }

    public Boolean am() {
        return Boolean.valueOf(p().getApplicationContext().getSharedPreferences("", 0).getBoolean("HK_Rdio_User_Sub", false));
    }

    public String an() {
        return p().getApplicationContext().getSharedPreferences("", 0).getString("HK_Rdio_Username_Tag", "");
    }

    public static void ao() {
        SharedPreferences.Editor editorEdit = HarmanApplication.a().getSharedPreferences("", 0).edit();
        editorEdit.putString("HK_Rdio_Token_Tag", null);
        editorEdit.apply();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        ayt.a(this.ae).a();
        View viewInflate = layoutInflater.inflate(R.layout.rdio_home_layout, (ViewGroup) null);
        viewInflate.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 20);
        this.av.clear();
        this.av.add(q().getString(R.string.RdioTrending_Str));
        this.av.add(q().getString(R.string.RdioNewReleases_Str));
        this.av.add(q().getString(R.string.RdioBrowse_Str));
        TextView textView = (TextView) viewInflate.findViewById(R.id.rdio_home_favourites);
        textView.setTypeface(ahu.a(this.ae));
        textView.setOnClickListener(new View.OnClickListener() { // from class: azr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!azs.ak && azr.this.at.getText().equals(azr.this.q().getString(R.string.RdioLogin_Str))) {
                    azr.this.a(new Intent(azr.this.p(), (Class<?>) RdioLoginActivity.class), 4);
                    return;
                }
                azo azoVarD = azo.d(azo.b.EGridTypeFavourites.a());
                Bundle bundle2 = new Bundle();
                bundle2.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeFavourites.a());
                azoVarD.g(bundle2);
                azr.this.ae.q().a(azoVarD, (arc) null);
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.rdio_home_playlists);
        textView2.setTypeface(ahu.a(this.ae));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: azr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!azs.ak && azr.this.at.getText().equals(azr.this.q().getString(R.string.RdioLogin_Str))) {
                    azr.this.a(new Intent(azr.this.p(), (Class<?>) RdioLoginActivity.class), 5);
                    return;
                }
                azo azoVarD = azo.d(azo.b.EGridTypePlaylists.a());
                Bundle bundle2 = new Bundle();
                bundle2.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypePlaylists.a());
                azoVarD.g(bundle2);
                azr.this.ae.q().a(azoVarD, (arc) null);
            }
        });
        this.ar = (TextView) viewInflate.findViewById(R.id.rdio_username);
        this.ar.setTypeface(ahu.a(this.ae));
        this.as = (RelativeLayout) viewInflate.findViewById(R.id.rdio_username_layout);
        this.at = (Button) viewInflate.findViewById(R.id.rdio_logout_button);
        this.at.setTypeface(ahu.a(this.ae));
        this.at.setOnClickListener(new View.OnClickListener() { // from class: azr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!azs.ak || !azr.this.at.getText().equals(azr.this.q().getString(R.string.RdioLogout_Str))) {
                    if (ahh.e(azr.this.ae)) {
                        azr.this.a(new Intent(azr.this.p(), (Class<?>) RdioLoginActivity.class), 10);
                        return;
                    }
                    return;
                }
                if (azr.this.aw == null) {
                    azr.this.aw = new arw.a(azr.this.ae).a(azr.this.a(R.string.SoundCloudLogoutText_Str)).b(azr.this.a(R.string.kDeezerSettingAccountLogout_Str)).a(azr.this.a(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: azr.3.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new ava().a(4, azr.this.ae).b();
                            azr.this.a(true);
                            dialogInterface.cancel();
                        }
                    }).b(azr.this.a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: azr.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            azr.this.aw.dismiss();
                        }
                    }).d(false).b();
                }
                if (!azr.this.aw.isShowing() && !azr.this.ae.isFinishing()) {
                    new asc(azr.this.aw).a(azr.this.p());
                }
            }
        });
        ListView listView = (ListView) viewInflate.findViewById(R.id.rdio_songs_list_view);
        this.a = new a(this.ae);
        listView.setAdapter((ListAdapter) this.a);
        return viewInflate;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        c();
    }
}
