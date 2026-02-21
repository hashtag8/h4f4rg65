package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import defpackage.aih;
import defpackage.ajv;
import defpackage.ayf;
import defpackage.ayg;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class ayr extends ayi implements ayg.a, ayg.b, ayg.d {
    private View ah;
    private GridView ai;
    private Button aj;
    ArrayList<aye> f;
    TextView g;
    int h = 0;
    aih<aye> i;

    @Override // defpackage.ayi
    boolean al() {
        return false;
    }

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ah = layoutInflater.inflate(R.layout.fragment_nokia_taste_genres, (ViewGroup) null);
        this.ah.findViewById(R.id.group_mix_header).setOnClickListener(new View.OnClickListener() { // from class: ayr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aho.b("mixradio_ftu", false) || aho.b("mixradio_harman_ftu", false)) {
                    ayr.this.ae.getFragmentManager().popBackStackImmediate();
                }
            }
        });
        this.g = (TextView) this.ah.findViewById(R.id.mixradio_genre_count);
        this.ai = (GridView) this.ah.findViewById(R.id.group_listview);
        this.ai.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ayr.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                aye ayeVar = ayr.this.f.get(i);
                if (ayeVar.d) {
                    ayeVar.d = false;
                    ayr.this.f.set(i, ayeVar);
                    ayr ayrVar = ayr.this;
                    ayrVar.h--;
                    ayr.this.an();
                    ((TextView) view.findViewById(R.id.tv)).setTextColor(ayr.this.ae.getResources().getColor(R.color.white));
                    return;
                }
                ayeVar.d = true;
                ayr.this.f.set(i, ayeVar);
                ((TextView) view.findViewById(R.id.tv)).setTextColor(ayr.this.ae.getResources().getColor(R.color.nokia_pink));
                final ImageView imageView = (ImageView) view.findViewById(R.id.fav_icon);
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(ayr.this.ae, R.anim.heart_fade);
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ayr.2.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        imageView.clearAnimation();
                        imageView.setVisibility(4);
                        ayr.this.i.notifyDataSetChanged();
                    }
                });
                imageView.startAnimation(animationLoadAnimation);
                ayr.this.h++;
                ayr.this.an();
            }
        });
        this.aj = (Button) this.ah.findViewById(R.id.taste_genre_next_button);
        this.aj.setOnClickListener(new View.OnClickListener() { // from class: ayr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < ayr.this.f.size()) {
                        if (ayr.this.f.get(i2).d) {
                            jSONArray.put(ayr.this.f.get(i2).b);
                        }
                        i = i2 + 1;
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("genres", jSONArray.toString());
                        ayq ayqVar = new ayq();
                        ayqVar.g(bundle2);
                        ayr.this.ae.q().a(ayqVar, (arc) null);
                        return;
                    }
                }
            }
        });
        return this.ah;
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(q().getColor(R.color.nokia_pink)).g(R.string.MixRadioFTUTitleWhatInto).c();
    }

    public void an() {
        this.g.setText(this.ae.getString(R.string.MixRadioGenresSelected1, new Object[]{Integer.valueOf(this.h)}));
        if (this.h == 0) {
            this.aj.setEnabled(false);
            this.aj.setTextColor(q().getColor(R.color.nokia_small_text));
        } else {
            this.aj.setEnabled(true);
            this.aj.setTextColor(q().getColor(R.color.white));
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.i = new aih<>(this.ae, new a(), 100, R.layout.nokia_genre_listview_item, R.layout.nokia_gridview_item_empty);
        c(l());
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.f == null) {
            this.h = 0;
            c();
            try {
                PackageInfo packageInfo = this.ae.getPackageManager().getPackageInfo(this.ae.getPackageName(), 0);
                ayf.a().a(packageInfo.packageName, packageInfo.versionName, this.ae, this);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            ayf.a().a(ayf.a.TasteGenre, this);
        } else {
            ao();
        }
        b(p().getResources().getConfiguration());
        an();
    }

    private void b(Configuration configuration) {
        this.ai.setNumColumns(configuration.orientation != 1 ? 2 : 1);
    }

    @Override // defpackage.ayi, android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
    }

    @Override // ayg.a
    public void a(boolean z) {
    }

    private void ao() {
        this.i.a(this.f);
        this.i.notifyDataSetChanged();
        this.ai.setAdapter((ListAdapter) this.i);
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[Catch: Exception -> 0x0064, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0064, blocks: (B:15:0x0053, B:17:0x0059, B:21:0x006d), top: B:26:0x0053 }] */
    @Override // ayg.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(ayf.a r7, org.json.JSONObject r8, java.lang.String r9) {
        /*
            r6 = this;
            r1 = 0
            ayf$a r0 = ayf.a.TasteGenre
            if (r7 != r0) goto L4f
            java.util.ArrayList<aye> r0 = r6.f     // Catch: java.lang.Exception -> L50
            if (r0 != 0) goto L10
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L50
            r0.<init>()     // Catch: java.lang.Exception -> L50
            r6.f = r0     // Catch: java.lang.Exception -> L50
        L10:
            java.util.ArrayList<aye> r0 = r6.f     // Catch: java.lang.Exception -> L50
            java.util.ArrayList<aye> r2 = r6.f     // Catch: java.lang.Exception -> L50
            r0.removeAll(r2)     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = "items"
            org.json.JSONArray r2 = r8.getJSONArray(r0)     // Catch: java.lang.Exception -> L50
            r0 = r1
        L1e:
            int r3 = r2.length()     // Catch: java.lang.Exception -> L50
            if (r0 >= r3) goto L4c
            org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch: java.lang.Exception -> L50
            aye r4 = new aye     // Catch: java.lang.Exception -> L50
            r4.<init>()     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = "name"
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L50
            r4.a = r5     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = "id"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Exception -> L50
            r4.b = r3     // Catch: java.lang.Exception -> L50
            java.lang.String r3 = ""
            r4.c = r3     // Catch: java.lang.Exception -> L50
            r3 = 0
            r4.d = r3     // Catch: java.lang.Exception -> L50
            java.util.ArrayList<aye> r3 = r6.f     // Catch: java.lang.Exception -> L50
            r3.add(r4)     // Catch: java.lang.Exception -> L50
            int r0 = r0 + 1
            goto L1e
        L4c:
            r6.ao()     // Catch: java.lang.Exception -> L50
        L4f:
            return
        L50:
            r0 = move-exception
            if (r0 == 0) goto L6d
            java.lang.String r2 = r0.getMessage()     // Catch: java.lang.Exception -> L64
            if (r2 == 0) goto L6d
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Exception -> L64
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L64
            defpackage.mm.e(r0, r2)     // Catch: java.lang.Exception -> L64
            goto L4f
        L64:
            r0 = move-exception
            java.lang.String r0 = "catch throw"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            defpackage.mm.e(r0, r1)
            goto L4f
        L6d:
            java.lang.String r0 = "invalid error message"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L64
            defpackage.mm.e(r0, r2)     // Catch: java.lang.Exception -> L64
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ayr.a(ayf$a, org.json.JSONObject, java.lang.String):void");
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        if (bVar == ayf.b.Suceeded && musicData != null) {
            d();
            MusicPlaylistManager.a().b(musicData);
        }
    }

    class a implements aih.a<aye> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, aye ayeVar) {
            C0093a c0093a = (C0093a) view.getTag();
            if (c0093a == null) {
                C0093a c0093a2 = new C0093a();
                c0093a2.a = (TextView) view.findViewById(R.id.tv);
                c0093a2.b = (ImageView) view.findViewById(R.id.fav_icon);
                view.setTag(c0093a2);
                c0093a = c0093a2;
            }
            c0093a.a.setText(ayeVar.a);
            c0093a.b.clearAnimation();
            c0093a.b.setVisibility(4);
            if (ayeVar.d) {
                c0093a.b.setVisibility(4);
                c0093a.a.setTextColor(ayr.this.ae.getResources().getColor(R.color.nokia_pink));
            } else {
                c0093a.b.setVisibility(4);
                c0093a.a.setTextColor(ayr.this.ae.getResources().getColor(R.color.white));
            }
            return view;
        }

        /* JADX INFO: renamed from: ayr$a$a, reason: collision with other inner class name */
        class C0093a {
            public TextView a;
            public ImageView b;

            C0093a() {
            }
        }
    }
}
