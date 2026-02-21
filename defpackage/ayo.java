package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioMusicData;
import com.musicservice.mixradio.model.MixRadioTrackData;
import defpackage.ajv;
import defpackage.arw;
import defpackage.ayf;
import defpackage.ayg;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayo extends ayi implements ayg.a, ayg.b, ayg.d {
    private Handler aN;
    HashSet<String> ak;
    private ImageView ao;
    private Button ap;
    private arw aq;
    View f;
    View g;
    LayoutInflater h;
    public static int i = 6;
    public static int ah = 6;
    private static int ar = 40;
    private static int as = 80;
    private static int at = 15;
    private static int au = 6;
    private static int av = 1;
    private static int aw = 2;
    private static int ax = 3;
    private static int az = 1;
    private static int aA = 2;
    private static int aB = 3;
    private static int aC = 4;
    private static int aD = 5;
    private static int aE = 6;
    private static int aF = 7;
    private static int aG = 8;
    private static int aH = 9;
    String ai = "MixRadio User";
    private d[][] ay = (d[][]) Array.newInstance((Class<?>) d.class, i, ah);
    private boolean aI = false;
    HashSet<b> aj = new HashSet<>();
    private ArrayList<a> aJ = new ArrayList<>();
    private ArrayList<c> aK = new ArrayList<>();
    private d[][] aL = (d[][]) Array.newInstance((Class<?>) d.class, i, ah);
    Random al = new Random();
    private MenuItem.OnMenuItemClickListener aM = new MenuItem.OnMenuItemClickListener() { // from class: ayo.3
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (ayo.this.aq == null) {
                ayo.this.aq = new arw.a(ayo.this.ae).a(ayo.this.ae.getString(R.string.MixradioLogoutBody, new Object[]{ayo.this.ai})).a(ayo.this.ae.getString(R.string.MixRadioSignOut), new DialogInterface.OnClickListener() { // from class: ayo.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        new ava().a(0, ayo.this.ae).b();
                        ayo.this.ae.a(MixRadioAdvertData.class, MixRadioMusicData.class, MixRadioTrackData.class);
                        Toast.makeText(ayo.this.ae, ayo.this.ae.getString(R.string.MixRadioLogoutSucceedTip), 1).show();
                        aho.a("mixradio_refresh", "");
                    }
                }).b(ayo.this.ae.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: ayo.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        ayo.this.aq.dismiss();
                    }
                }).d(false).b();
            }
            if (!ayo.this.aq.isShowing()) {
                new asc(ayo.this.aq).a(ayo.this.p());
            }
            return true;
        }
    };
    Runnable am = new Runnable() { // from class: ayo.4
        @Override // java.lang.Runnable
        public void run() {
            ayo.this.an();
            ayo.this.aN.postDelayed(ayo.this.am, 4000L);
        }
    };
    Runnable an = new Runnable() { // from class: ayo.5
        @Override // java.lang.Runnable
        public void run() {
            ayo.this.ao();
            ayo.this.aN.postDelayed(ayo.this.an, 1000L);
        }
    };

    public static class a {
        int a;
        int b;
        d c;
    }

    public static class c {
        String a;
        String b;
    }

    public static class d {
        c a;
        int b;
        boolean c;
    }

    static class b {
        int a;
        int b;

        private b() {
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.aN = new Handler();
        this.ak = new HashSet<>();
    }

    @Override // defpackage.ayi
    boolean al() {
        return true;
    }

    @Override // defpackage.ayi
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater;
        this.f = layoutInflater.inflate(R.layout.fragment_nokia_my_mix, (ViewGroup) null);
        this.ai = aho.d("mixradio_username");
        this.g = layoutInflater.inflate(R.layout.mixradio_my_mix, (ViewGroup) null);
        this.ao = (ImageView) this.f.findViewById(R.id.my_mix_button);
        this.ao.setOnClickListener(new View.OnClickListener() { // from class: ayo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aof.a().l()) {
                    Toast.makeText(ayo.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                ayo.this.c();
                ayo.this.a = ayo.this.ao;
                ayf.a().a(ayo.this.ae, ayo.this);
            }
        });
        this.ap = (Button) this.f.findViewById(R.id.my_mix_edit_button);
        this.ap.setOnClickListener(new View.OnClickListener() { // from class: ayo.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayo.this.ae.q().a(new ayr(), (arc) null);
            }
        });
        return this.f;
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        axz.a = 0;
        super.c(bundle);
        aA();
        this.aJ = new ArrayList<>();
        this.aK = new ArrayList<>();
        this.ak = new HashSet<>();
        this.aL = (d[][]) Array.newInstance((Class<?>) d.class, i, ah);
        this.aj = new HashSet<>();
        this.aI = false;
        try {
            PackageInfo packageInfo = this.ae.getPackageManager().getPackageInfo(this.ae.getPackageName(), 0);
            ayf.a().a(packageInfo.packageName, packageInfo.versionName, this.ae, this);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.ajj
    public void e() {
        super.e();
        aA();
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (this.aK != null && this.aK.size() > 0) {
            az();
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            ayf.a().a(ayf.a.Availability, this);
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(this.aM);
        aVar.i(R.drawable.hamberger_white_icon);
        aVar.c(true);
        aVar.k(R.drawable.mixradio_settings2x);
        return aVar.a(q().getColor(R.color.nokia_pink)).h(R.drawable.mixradio_nav_logo2x).c();
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        d();
        if (bVar == ayf.b.FailedInvalidPlayer) {
            if (this.ae != null) {
                Toast.makeText(this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            }
        } else {
            if (bVar == ayf.b.SkipLimitReached) {
                String strReplaceAll = this.ae.getString(R.string.MixRadioSkipLimitTip_Str).replaceAll("%d", "" + ayf.a().f);
                if (this.ae != null) {
                    Toast.makeText(this.ae, strReplaceAll, 0).show();
                    return;
                }
                return;
            }
            if (bVar == ayf.b.FailedNetworkError) {
                if (this.ae != null) {
                    Toast.makeText(this.ae, R.string.MixRadioTimeOut_Str, 1).show();
                    return;
                }
                return;
            }
            a(musicData);
        }
    }

    @Override // ayg.a
    public void a(boolean z) {
        if (z) {
            ayf.a().a(ayf.a.FeaturedMixes, this);
            ayf.a().c(this);
            ayf.a().b(this);
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        if (aVar == ayf.a.Favourite) {
            this.aK = new ArrayList<>();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    c cVar = new c();
                    if (jSONArray.getJSONObject(i2).getJSONObject("subject").getJSONObject("category").getString("id").compareTo("Artist") == 0) {
                        cVar.a = jSONArray.getJSONObject(i2).getJSONObject("subject").getString("id");
                        if (jSONArray.getJSONObject(i2).getJSONObject("subject").has("thumbnails")) {
                            cVar.b = ayg.a(ayg.c.ArtistImage_Random, "" + cVar.a).replace("http://", "https://");
                            this.aK.add(cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aA();
            az();
            return;
        }
        if (aVar == ayf.a.Availability) {
            SharedPreferences sharedPreferences = this.ae.getSharedPreferences("MixRadio", 0);
            String string = "";
            if (sharedPreferences.getString("mixradio_auth", "").compareTo("") != 0) {
                string = sharedPreferences.getString("mixradio_auth", "");
            }
            ayf.a().a(this, string);
            return;
        }
        if (aVar == ayf.a.Me) {
            mm.b("Me", jSONObject.toString());
            this.ai = jSONObject.optString("name");
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        if (aVar != ayf.a.Favourite && aVar != ayf.a.Me) {
            Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
        }
        mm.e(str + " " + aVar, new Object[0]);
    }

    public void an() {
        if (this.al.nextInt(100) >= at) {
            aq();
        } else {
            ap();
        }
    }

    public void ao() {
        if (this.aJ.size() != 0) {
            a aVar = this.aJ.get(0);
            int i2 = (aVar.a * i) + aVar.b;
            d dVar = aVar.c;
            ImageView imageView = (ImageView) this.f.findViewById(this.ae.getResources().getIdentifier("iv" + aVar.a + "" + aVar.b, "id", this.ae.getPackageName()));
            if (imageView == null) {
                mm.e("Tried to fetch " + aVar.a + " " + aVar.b, new Object[0]);
                this.aJ.remove(aVar);
                return;
            }
            imageView.setVisibility(0);
            ((ImageView) this.f.findViewById(this.ae.getResources().getIdentifier("iv" + aVar.a + "" + aVar.b + "_alt", "id", this.ae.getPackageName()))).setVisibility(8);
            this.ak.contains("iv" + aVar.a + "" + aVar.b);
            if (dVar.a.b != null) {
                if (dVar.b != aH) {
                    bif.a((Context) this.ae).a(ayg.a(ayg.c.ArtistImage_Large, "" + dVar.a.a).replace("http://", "https://")).b(this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width) * 2, this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width) * 2).c().e().a((bir) new axy(dVar.b)).a(imageView);
                } else {
                    bif.a((Context) this.ae).a(dVar.a.b).b(this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width), this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width)).c().e().a(imageView);
                }
            } else {
                if (imageView == null) {
                    this.aJ.remove(aVar);
                    return;
                }
                bif.a((Context) this.ae).a(R.drawable.mixradio_flip_blank).b(this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width), this.ae.getResources().getDimensionPixelOffset(R.dimen.mixradio_artist_mix_width)).e().c().a(imageView);
            }
            this.aJ.remove(aVar);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void D() {
        super.D();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ap() {
        d dVar;
        int iNextInt = this.al.nextInt(i * ah);
        int i2 = iNextInt % i;
        int i3 = iNextInt / ah;
        b bVar = new b();
        bVar.a = i3;
        bVar.b = i2;
        if (((i3 != aw && i3 != ax) || (i2 != aw && i2 != ax)) && a(bVar, this.al) && (dVar = this.aL[i3][i2]) != null) {
            d dVar2 = new d();
            dVar2.a = new c();
            dVar2.c = false;
            HashSet hashSet = new HashSet();
            a aVar = new a();
            aVar.a = i3;
            aVar.b = i2;
            aVar.c = dVar2;
            hashSet.add(aVar);
            if (dVar.c) {
                if (dVar.b == az) {
                    a aVar2 = new a();
                    aVar2.a = i3 + 1;
                    aVar2.b = i2;
                    aVar2.c = dVar2;
                    hashSet.add(aVar2);
                    a aVar3 = new a();
                    aVar3.a = i3;
                    aVar3.b = i2 + 1;
                    aVar3.c = dVar2;
                    hashSet.add(aVar3);
                    a aVar4 = new a();
                    aVar4.a = i3 + 1;
                    aVar4.b = i2 + 1;
                    aVar3.c = dVar2;
                    hashSet.add(aVar3);
                } else if (dVar.b == aB) {
                    a aVar5 = new a();
                    aVar5.a = i3 + 1;
                    aVar5.b = i2;
                    aVar5.c = dVar2;
                    hashSet.add(aVar5);
                    a aVar6 = new a();
                    aVar6.a = i3 + 1;
                    aVar6.b = i2 - 1;
                    aVar6.c = dVar2;
                    hashSet.add(aVar6);
                    a aVar7 = new a();
                    aVar7.a = i3;
                    aVar7.b = i2 - 1;
                    aVar7.c = dVar2;
                    hashSet.add(aVar7);
                } else if (dVar.b == aA) {
                    a aVar8 = new a();
                    aVar8.a = i3 - 1;
                    aVar8.b = i2;
                    aVar8.c = dVar2;
                    hashSet.add(aVar8);
                    a aVar9 = new a();
                    aVar9.a = i3 - 1;
                    aVar9.b = i2 + 1;
                    aVar9.c = dVar2;
                    hashSet.add(aVar9);
                    a aVar10 = new a();
                    aVar10.a = i3;
                    aVar10.b = i2 + 1;
                    aVar10.c = dVar2;
                    hashSet.add(aVar10);
                } else if (dVar.b == aC) {
                    a aVar11 = new a();
                    aVar11.a = i3 - 1;
                    aVar11.b = i2;
                    aVar11.c = dVar2;
                    hashSet.add(aVar11);
                    a aVar12 = new a();
                    aVar12.a = i3 - 1;
                    aVar12.b = i2 - 1;
                    aVar12.c = dVar2;
                    hashSet.add(aVar12);
                    a aVar13 = new a();
                    aVar13.a = i3;
                    aVar13.b = i2 - 1;
                    aVar13.c = dVar2;
                    hashSet.add(aVar13);
                }
            }
            if (i2 == 0) {
                a aVar14 = new a();
                aVar14.a = i3;
                aVar14.b = i2 + 1;
                aVar14.c = dVar2;
                hashSet.add(aVar14);
            } else if (i2 == ah) {
                a aVar15 = new a();
                aVar15.a = i3;
                aVar15.b = i2 - 1;
                aVar15.c = dVar2;
                hashSet.add(aVar15);
            }
            if (i3 == 0) {
                ArrayList arrayList = new ArrayList(hashSet);
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    a aVar16 = new a();
                    aVar16.a = ((a) arrayList.get(i4)).a + 1;
                    aVar16.b = ((a) arrayList.get(i4)).b;
                    aVar16.c = dVar2;
                    hashSet.add(aVar16);
                }
            } else if (i3 == i) {
                ArrayList arrayList2 = new ArrayList(hashSet);
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    a aVar17 = new a();
                    aVar17.a = ((a) arrayList2.get(i5)).a - 1;
                    aVar17.b = ((a) arrayList2.get(i5)).b;
                    aVar17.c = dVar2;
                    hashSet.add(aVar17);
                }
            }
            ArrayList arrayList3 = new ArrayList(hashSet);
            for (int i6 = 0; i6 < arrayList3.size(); i6++) {
                this.aJ.add(arrayList3.get(i6));
            }
        }
    }

    public void aq() {
        int i2;
        boolean zB;
        int i3;
        boolean zAy = ay();
        int iNextInt = zAy ? this.al.nextInt(i - 1) : this.al.nextInt(i);
        int iNextInt2 = zAy ? this.al.nextInt(ah - 1) : this.al.nextInt(ah);
        if ((iNextInt == aw || iNextInt == ax) && (iNextInt2 == aw || iNextInt2 == ax)) {
            int i4 = aw;
            i2 = i4;
            zB = true;
            i3 = i4;
        } else if (zAy) {
            b bVar = new b();
            bVar.a = iNextInt;
            bVar.b = iNextInt2;
            zB = b(bVar, new HashSet<>());
            i2 = iNextInt;
            i3 = iNextInt2;
        } else {
            zB = zAy;
            i2 = iNextInt;
            i3 = iNextInt2;
        }
        b bVar2 = new b();
        bVar2.a = i2;
        bVar2.b = i3;
        c cVar = new c();
        if (this.aK.size() != 0) {
            cVar = (zB || !a(bVar2, this.al)) ? this.aK.get(this.al.nextInt(this.aK.size())) : new c();
        }
        if (cVar != null) {
            this.aJ.addAll(a(i2, i3, cVar, zB));
        }
    }

    public void ax() {
        b bVar;
        if (!this.aI) {
            this.aI = true;
            ArrayList<c> arrayList = this.aK;
            Collections.shuffle(arrayList);
            if (arrayList.size() != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    for (int i3 = 0; i3 < ah; i3++) {
                        b bVar2 = new b();
                        bVar2.a = i2;
                        bVar2.b = i3;
                        this.aj.add(bVar2);
                    }
                }
                this.aJ.addAll(a(2, 2, arrayList.get(0), true));
                this.aj = a(this.aj, 2, 2, true);
                for (int i4 = 1; i4 < arrayList.size(); i4++) {
                    boolean zAy = ay();
                    b bVarA = a(this.al, this.aj);
                    if (!a(bVarA, this.al)) {
                        bVar = bVarA;
                    } else if (!a(bVarA, this.aj)) {
                        bVar = (b) this.aj.toArray()[this.al.nextInt(this.aj.size())];
                    } else {
                        return;
                    }
                    boolean z = zAy && b(bVar, this.aj);
                    this.aJ.addAll(a(bVar.a, bVar.b, arrayList.get(i4), z));
                    this.aj = a(this.aj, bVar.a, bVar.b, z);
                }
            }
        }
    }

    public b a(Random random, HashSet<b> hashSet) {
        return (b) hashSet.toArray()[random.nextInt(hashSet.size())];
    }

    public boolean a(b bVar, HashSet<b> hashSet) {
        this.aJ.addAll(a(bVar.a, bVar.b, new c(), false));
        return a(hashSet, bVar.a, bVar.b, false).isEmpty();
    }

    public boolean a(b bVar, Random random) {
        if ((bVar.a == 0 || bVar.a == 5 || bVar.b == 0 || bVar.b == 5) && random.nextInt(100) > ar) {
            return true;
        }
        return (bVar.a == 1 || bVar.a == 4 || bVar.b == 1 || bVar.b == 4) && random.nextInt(100) > as;
    }

    public boolean b(b bVar, HashSet<b> hashSet) {
        return (bVar.a % 2) + (bVar.b % 2) == 0;
    }

    public boolean ay() {
        return this.al.nextInt(10) >= au;
    }

    public HashSet<b> a(HashSet<b> hashSet, int i2, int i3, boolean z) {
        if (z) {
            b bVar = new b();
            bVar.a = i2;
            bVar.b = i3;
            hashSet.remove(bVar);
            b bVar2 = new b();
            bVar2.a = i2 + 1;
            bVar2.b = i3;
            hashSet.remove(bVar2);
            b bVar3 = new b();
            bVar3.a = i2;
            bVar3.b = i3 + 1;
            hashSet.remove(bVar3);
            b bVar4 = new b();
            bVar4.a = i2 + 1;
            bVar4.b = i3 + 1;
            hashSet.remove(bVar4);
        } else {
            b bVar5 = new b();
            bVar5.a = i2;
            bVar5.b = i3;
            hashSet.remove(bVar5);
        }
        return hashSet;
    }

    public ArrayList<a> a(int i2, int i3, c cVar, boolean z) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (z) {
            d dVar = new d();
            dVar.a = cVar;
            dVar.b = az;
            dVar.c = true;
            this.aL[i2][i3] = dVar;
            d dVar2 = new d();
            dVar2.a = cVar;
            dVar2.b = aB;
            dVar2.c = true;
            this.aL[i2 + 1][i3] = dVar2;
            d dVar3 = new d();
            dVar3.a = cVar;
            dVar3.b = aA;
            dVar3.c = true;
            this.aL[i2][i3 + 1] = dVar3;
            d dVar4 = new d();
            dVar4.a = cVar;
            dVar4.b = aC;
            dVar4.c = true;
            this.aL[i2 + 1][i3 + 1] = dVar4;
            a aVar = new a();
            aVar.a = i2;
            aVar.b = i3;
            aVar.c = this.aL[i2][i3];
            arrayList.add(aVar);
            a aVar2 = new a();
            aVar2.a = i2 + 1;
            aVar2.b = i3;
            aVar2.c = this.aL[i2 + 1][i3];
            arrayList.add(aVar2);
            a aVar3 = new a();
            aVar3.a = i2;
            aVar3.b = i3 + 1;
            aVar3.c = this.aL[i2][i3 + 1];
            arrayList.add(aVar3);
            a aVar4 = new a();
            aVar4.a = i2 + 1;
            aVar4.b = i3 + 1;
            aVar4.c = this.aL[i2 + 1][i3 + 1];
            arrayList.add(aVar4);
        } else {
            d dVar5 = new d();
            dVar5.a = cVar;
            dVar5.b = aH;
            dVar5.c = false;
            this.aL[i2][i3] = dVar5;
            a aVar5 = new a();
            aVar5.a = i2;
            aVar5.b = i3;
            aVar5.c = this.aL[i2][i3];
            arrayList.add(aVar5);
        }
        return arrayList;
    }

    void az() {
        ax();
        this.am.run();
        this.an.run();
    }

    void aA() {
        this.aN.removeCallbacks(this.am);
        this.aN.removeCallbacks(this.an);
    }
}
