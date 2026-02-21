package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioMusicData;
import com.musicservice.mixradio.model.MixRadioTrackData;
import defpackage.aih;
import defpackage.ajv;
import defpackage.arw;
import defpackage.ayf;
import defpackage.ayg;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayn extends ayi implements ayg.a, ayg.b, ayg.d {
    ArrayList<ayc> ah;
    ArrayList<ayc> ai;
    private ListView aj;
    private arw ak;
    private Button al;
    private Button am;
    private LayoutInflater an;
    private aih<ayc> ao;
    View f;
    HashMap<String, Integer> h;
    HashMap<String, Integer> i;
    String g = "MixRadio User";
    private boolean ap = true;
    private MenuItem.OnMenuItemClickListener aq = new MenuItem.OnMenuItemClickListener() { // from class: ayn.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (ayn.this.ak == null) {
                ayn.this.ak = new arw.a(ayn.this.ae).a(ayn.this.ae.getString(R.string.MixradioLogoutBody, new Object[]{ayn.this.g})).a(ayn.this.ae.getString(R.string.MixRadioSignOut), new DialogInterface.OnClickListener() { // from class: ayn.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new ava().a(0, ayn.this.ae).b();
                        ayn.this.ae.a(MixRadioAdvertData.class, MixRadioMusicData.class, MixRadioTrackData.class);
                        Toast.makeText(ayn.this.ae, ayn.this.ae.getString(R.string.MixRadioLogoutSucceedTip), 1).show();
                        aho.a("mixradio_refresh", "");
                    }
                }).b(ayn.this.ae.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: ayn.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ayn.this.ak.dismiss();
                    }
                }).d(false).b();
            }
            if (!ayn.this.ak.isShowing()) {
                new asc(ayn.this.ak).a(ayn.this.p());
            }
            return true;
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(this.aq);
        aVar.i(R.drawable.hamberger_white_icon);
        aVar.c(true);
        aVar.k(R.drawable.mixradio_settings2x);
        return aVar.a(q().getColor(R.color.nokia_pink)).h(R.drawable.mixradio_nav_logo2x).c();
    }

    @Override // defpackage.ayi
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(R.layout.fragment_nokia_mix, (ViewGroup) null);
        this.an = layoutInflater;
        this.g = aho.d("mixradio_username");
        this.aj = (ListView) this.f.findViewById(R.id.results_listview);
        this.ap = true;
        this.al = (Button) this.f.findViewById(R.id.category_button);
        this.al.setOnClickListener(new View.OnClickListener() { // from class: ayn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayn.this.an();
            }
        });
        this.am = (Button) this.f.findViewById(R.id.genre_button);
        this.am.setOnClickListener(new View.OnClickListener() { // from class: ayn.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayn.this.ao();
            }
        });
        try {
            PackageInfo packageInfo = this.ae.getPackageManager().getPackageInfo(this.ae.getPackageName(), 0);
            ayf.a().a(packageInfo.packageName, packageInfo.versionName, this.ae, this);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.ap = true;
        this.al.setSelected(true);
        this.am.setSelected(false);
        if (this.ai != null) {
            this.ai.clear();
        }
        c();
        ayf.a().a(ayf.a.MixGroupsByCategory, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        this.ap = false;
        this.al.setSelected(false);
        this.am.setSelected(true);
        if (this.ah != null) {
            this.ah.clear();
        }
        c();
        ayf.a().a(ayf.a.MixGroupsByGenre, this);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.ah = new ArrayList<>();
        this.ai = new ArrayList<>();
        this.ao = new aih<>(this.ae, new a(), 100, R.layout.nokia_mixview_item, R.layout.harman_list_loading);
        c(l());
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        axz.a = 1;
        super.c(bundle);
        this.aj.setAdapter((ListAdapter) this.ao);
        if (this.ap) {
            an();
        } else {
            ao();
        }
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        d();
        if (bVar == ayf.b.FailedInvalidPlayer) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        if (bVar == ayf.b.SkipLimitReached) {
            Toast.makeText(p(), this.ae.getString(R.string.MixRadioSkipLimitTip_Str).replaceAll("%d", "" + ayf.a().f), 0).show();
        } else if (bVar == ayf.b.FailedNetworkError) {
            Toast.makeText(p(), R.string.MixRadioTimeOut_Str, 1).show();
        } else {
            a(musicData);
        }
    }

    @Override // defpackage.ayi
    boolean al() {
        return true;
    }

    @Override // ayg.a
    public void a(boolean z) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        int i = 0;
        if (aVar == ayf.a.MixesInGroup) {
            try {
                mm.b("ITEMS", jSONObject.toString());
                JSONArray jSONArray = jSONObject.getJSONArray("radiostations");
                ayc aycVar = new ayc();
                aycVar.a = jSONObject.getString("name");
                aycVar.t = jSONObject.getString("id");
                aycVar.b = new ArrayList<>();
                aycVar.d = new ArrayList<>();
                aycVar.c = new ArrayList<>();
                aycVar.u = new ArrayList<>();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(1);
                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(2);
                JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(3);
                JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(4);
                if (jSONObjectOptJSONObject != null) {
                    aycVar.o = jSONObjectOptJSONObject.optString("id");
                    aycVar.e = jSONObjectOptJSONObject.optString("name");
                    JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject6 != null) {
                        aycVar.j = jSONObjectOptJSONObject6.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject2 != null) {
                    aycVar.p = jSONObjectOptJSONObject2.optString("id");
                    aycVar.f = jSONObjectOptJSONObject2.optString("name");
                    JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject2.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject7 != null) {
                        aycVar.k = jSONObjectOptJSONObject7.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject3 != null) {
                    aycVar.q = jSONObjectOptJSONObject3.optString("id");
                    aycVar.g = jSONObjectOptJSONObject3.optString("name");
                    JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject3.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject8 != null) {
                        aycVar.l = jSONObjectOptJSONObject8.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject4 != null) {
                    aycVar.r = jSONObjectOptJSONObject4.optString("id");
                    aycVar.h = jSONObjectOptJSONObject4.optString("name");
                    JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject4.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject9 != null) {
                        aycVar.m = jSONObjectOptJSONObject9.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject5 != null) {
                    aycVar.s = jSONObjectOptJSONObject5.optString("id");
                    aycVar.i = jSONObjectOptJSONObject5.optString("name");
                    JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject5.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject10 != null) {
                        aycVar.n = jSONObjectOptJSONObject10.optString("200x200");
                    }
                }
                if (this.am.isSelected()) {
                    if (this.ah != null && this.i != null && this.i.containsKey(aycVar.t) && this.i.get(aycVar.t).intValue() < this.ah.size()) {
                        this.ah.set(this.i.get(aycVar.t).intValue(), aycVar);
                    }
                } else if (this.ai != null && this.h != null && this.h.containsKey(aycVar.t) && this.h.get(aycVar.t).intValue() < this.ai.size()) {
                    this.ai.set(this.h.get(aycVar.t).intValue(), aycVar);
                }
            } catch (Exception e) {
                new ml().a("Cannot parse " + jSONObject, e);
            }
            if (this.am.isSelected()) {
                this.ao.a(this.ah);
            } else {
                this.ao.a(this.ai);
            }
            this.ao.notifyDataSetChanged();
            return;
        }
        if (aVar == ayf.a.CatArtists) {
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                ayc aycVar2 = new ayc();
                aycVar2.a = str;
                aycVar2.t = jSONObject.getString("id");
                JSONObject jSONObjectOptJSONObject11 = jSONArray2.optJSONObject(0);
                JSONObject jSONObjectOptJSONObject12 = jSONArray2.optJSONObject(1);
                JSONObject jSONObjectOptJSONObject13 = jSONArray2.optJSONObject(2);
                JSONObject jSONObjectOptJSONObject14 = jSONArray2.optJSONObject(3);
                JSONObject jSONObjectOptJSONObject15 = jSONArray2.optJSONObject(4);
                if (jSONObjectOptJSONObject11 != null) {
                    aycVar2.o = jSONObjectOptJSONObject11.optString("id");
                    aycVar2.e = jSONObjectOptJSONObject11.optString("name");
                    JSONObject jSONObjectOptJSONObject16 = jSONObjectOptJSONObject11.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject16 != null) {
                        aycVar2.j = jSONObjectOptJSONObject16.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject12 != null) {
                    aycVar2.p = jSONObjectOptJSONObject12.optString("id");
                    aycVar2.f = jSONObjectOptJSONObject12.optString("name");
                    JSONObject jSONObjectOptJSONObject17 = jSONObjectOptJSONObject12.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject17 != null) {
                        aycVar2.k = jSONObjectOptJSONObject17.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject13 != null) {
                    aycVar2.q = jSONObjectOptJSONObject13.optString("id");
                    aycVar2.g = jSONObjectOptJSONObject13.optString("name");
                    JSONObject jSONObjectOptJSONObject18 = jSONObjectOptJSONObject13.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject18 != null) {
                        aycVar2.l = jSONObjectOptJSONObject18.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject14 != null) {
                    aycVar2.r = jSONObjectOptJSONObject14.optString("id");
                    aycVar2.h = jSONObjectOptJSONObject14.optString("name");
                    JSONObject jSONObjectOptJSONObject19 = jSONObjectOptJSONObject14.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject19 != null) {
                        aycVar2.m = jSONObjectOptJSONObject19.optString("200x200");
                    }
                }
                if (jSONObjectOptJSONObject15 != null) {
                    aycVar2.s = jSONObjectOptJSONObject15.optString("id");
                    aycVar2.i = jSONObjectOptJSONObject15.optString("name");
                    JSONObject jSONObjectOptJSONObject20 = jSONObjectOptJSONObject15.optJSONObject("thumbnails");
                    if (jSONObjectOptJSONObject20 != null) {
                        aycVar2.n = jSONObjectOptJSONObject20.optString("200x200");
                    }
                }
                if (this.am.isSelected()) {
                    if (this.i.get(aycVar2.t).intValue() < this.ah.size()) {
                        this.ah.set(this.i.get(aycVar2.t).intValue(), aycVar2);
                    }
                } else if (this.h.get(aycVar2.t).intValue() < this.ai.size()) {
                    this.ai.set(this.h.get(aycVar2.t).intValue(), aycVar2);
                }
            } catch (Exception e2) {
                new ml().a("Cannot parse " + jSONObject, e2);
            }
            this.ao.a(this.ai);
            this.ao.notifyDataSetChanged();
            return;
        }
        if (aVar == ayf.a.MixGroupsByGenre) {
            try {
                this.ah.clear();
                JSONArray jSONArray3 = jSONObject.getJSONArray("items");
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                    aye ayeVar = new aye();
                    ayeVar.a = jSONObject2.getString("name");
                    ayeVar.b = jSONObject2.getString("id");
                    ayeVar.c = "";
                    ayc aycVar3 = new ayc();
                    aycVar3.a = ayeVar.a;
                    this.ah.add(aycVar3);
                    this.i.put(ayeVar.b, Integer.valueOf(this.ah.size() - 1));
                    ayf.a().a(ayf.a.MixesInGroup, this, ayeVar.b);
                    i++;
                }
                this.ao.a(this.ah);
                this.ao.notifyDataSetChanged();
                d();
                this.aj.setSelection(0);
                return;
            } catch (JSONException e3) {
                new ml().a("Cannot parse " + jSONObject, e3);
                return;
            }
        }
        if (aVar == ayf.a.MixGroupsByCategory) {
            try {
                this.ai.clear();
                JSONArray jSONArray4 = jSONObject.getJSONArray("items");
                while (i < jSONArray4.length()) {
                    JSONObject jSONObject3 = jSONArray4.getJSONObject(i);
                    aye ayeVar2 = new aye();
                    ayeVar2.a = jSONObject3.getString("name");
                    ayeVar2.b = jSONObject3.getString("id");
                    ayeVar2.c = jSONObject3.getString("type");
                    ayc aycVar4 = new ayc();
                    aycVar4.a = ayeVar2.a;
                    this.ai.add(aycVar4);
                    this.h.put(ayeVar2.b, Integer.valueOf(this.ai.size() - 1));
                    ayf.a().a(ayf.a.MixesInGroup, this, ayeVar2.b);
                    i++;
                }
                this.ao.a(this.ai);
                this.ao.notifyDataSetChanged();
                d();
                this.aj.setSelection(0);
            } catch (JSONException e4) {
                new ml().a("Cannot parse " + jSONObject, e4);
            }
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
    }

    class a implements aih.a<ayc> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, final ayc aycVar) {
            C0090a c0090a = (C0090a) view.getTag();
            if (c0090a == null) {
                C0090a c0090a2 = new C0090a();
                c0090a2.a = (TextView) view.findViewById(R.id.tv1);
                c0090a2.b = (TextView) view.findViewById(R.id.tv2);
                c0090a2.c = (TextView) view.findViewById(R.id.tv3);
                if (ahn.a()) {
                    c0090a2.d = (TextView) view.findViewById(R.id.tv4);
                    c0090a2.e = (TextView) view.findViewById(R.id.tv5);
                }
                c0090a2.k = (TextView) view.findViewById(R.id.group_title);
                c0090a2.f = (ImageView) view.findViewById(R.id.iv1);
                c0090a2.g = (ImageView) view.findViewById(R.id.iv2);
                c0090a2.h = (ImageView) view.findViewById(R.id.iv3);
                if (ahn.a()) {
                    c0090a2.i = (ImageView) view.findViewById(R.id.iv4);
                    c0090a2.j = (ImageView) view.findViewById(R.id.iv5);
                }
                c0090a2.l = (TextView) view.findViewById(R.id.seeall_title);
                c0090a2.m = (LinearLayout) view.findViewById(R.id.tv1_holder);
                c0090a2.n = (LinearLayout) view.findViewById(R.id.tv2_holder);
                c0090a2.o = (LinearLayout) view.findViewById(R.id.tv3_holder);
                if (ahn.a()) {
                    c0090a2.p = (LinearLayout) view.findViewById(R.id.tv4_holder);
                    c0090a2.q = (LinearLayout) view.findViewById(R.id.tv5_holder);
                }
                view.setTag(c0090a2);
                c0090a = c0090a2;
            }
            c0090a.k.setText(aycVar.a);
            if (aycVar.e != null) {
                c0090a.a.setText(aycVar.e);
                c0090a.b.setText(aycVar.f);
                c0090a.c.setText(aycVar.g);
                if (ahn.a()) {
                    c0090a.d.setText(aycVar.h);
                    c0090a.e.setText(aycVar.i);
                }
                new ahw().a(c0090a.f, new ahq() { // from class: ayn.a.1
                    @Override // defpackage.ahq
                    public void a(View view2) {
                        bif.a((Context) ayn.this.ae).a(aycVar.j).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                    }
                });
                new ahw().a(c0090a.g, new ahq() { // from class: ayn.a.4
                    @Override // defpackage.ahq
                    public void a(View view2) {
                        bif.a((Context) ayn.this.ae).a(aycVar.k).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                    }
                });
                new ahw().a(c0090a.h, new ahq() { // from class: ayn.a.5
                    @Override // defpackage.ahq
                    public void a(View view2) {
                        bif.a((Context) ayn.this.ae).a(aycVar.l).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                    }
                });
                if (ahn.a()) {
                    new ahw().a(c0090a.i, new ahq() { // from class: ayn.a.6
                        @Override // defpackage.ahq
                        public void a(View view2) {
                            bif.a((Context) ayn.this.ae).a(aycVar.m).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                        }
                    });
                    new ahw().a(c0090a.j, new ahq() { // from class: ayn.a.7
                        @Override // defpackage.ahq
                        public void a(View view2) {
                            bif.a((Context) ayn.this.ae).a(aycVar.n).b(view2.getWidth(), view2.getHeight()).e().c().a((ImageView) view2);
                        }
                    });
                }
                if (aycVar.o != null) {
                    c0090a.f.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            a.this.a(aycVar.o);
                        }
                    });
                } else {
                    c0090a.f.setOnClickListener(null);
                }
                if (aycVar.p != null) {
                    c0090a.g.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            a.this.a(aycVar.p);
                        }
                    });
                } else {
                    c0090a.g.setOnClickListener(null);
                }
                if (aycVar.q != null) {
                    c0090a.h.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.10
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            a.this.a(aycVar.q);
                        }
                    });
                } else {
                    c0090a.h.setOnClickListener(null);
                }
                if (ahn.a()) {
                    if (aycVar.r != null) {
                        c0090a.i.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.11
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                a.this.a(aycVar.r);
                            }
                        });
                    } else {
                        c0090a.i.setOnClickListener(null);
                    }
                    if (aycVar.s != null) {
                        c0090a.j.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                a.this.a(aycVar.s);
                            }
                        });
                    } else {
                        c0090a.j.setOnClickListener(null);
                    }
                }
                if (aycVar.p == null) {
                    c0090a.l.setVisibility(4);
                } else {
                    c0090a.l.setVisibility(0);
                }
                c0090a.l.setOnClickListener(new View.OnClickListener() { // from class: ayn.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", aycVar.t);
                        bundle.putString("name", aycVar.a);
                        aym aymVar = new aym();
                        aymVar.g(bundle);
                        ayn.this.ae.q().a(aymVar, (arc) null);
                    }
                });
                if (aycVar.o == null) {
                    c0090a.m.setVisibility(4);
                } else {
                    c0090a.m.setVisibility(0);
                }
                if (aycVar.p == null) {
                    c0090a.n.setVisibility(4);
                } else {
                    c0090a.n.setVisibility(0);
                }
                if (aycVar.q == null) {
                    c0090a.o.setVisibility(4);
                } else {
                    c0090a.o.setVisibility(0);
                }
                if (ahn.a()) {
                    if (aycVar.r == null) {
                        c0090a.p.setVisibility(4);
                    } else {
                        c0090a.p.setVisibility(0);
                    }
                    if (aycVar.s == null) {
                        c0090a.q.setVisibility(4);
                    } else {
                        c0090a.q.setVisibility(0);
                    }
                }
            }
            return view;
        }

        public void a(String str) {
            if (aof.a().l()) {
                Toast.makeText(ayn.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                ayn.this.c();
                ayf.a().a(ayn.this.ae, ayn.this, str);
            }
        }

        /* JADX INFO: renamed from: ayn$a$a, reason: collision with other inner class name */
        public class C0090a {
            public TextView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public ImageView f;
            public ImageView g;
            public ImageView h;
            public ImageView i;
            public ImageView j;
            public TextView k;
            public TextView l;
            public LinearLayout m;
            public LinearLayout n;
            public LinearLayout o;
            public LinearLayout p;
            public LinearLayout q;

            public C0090a() {
            }
        }
    }
}
