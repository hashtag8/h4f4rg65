package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import defpackage.ajo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amp extends ajj implements anu<JSONObject> {
    private anv ah;
    private aih<ant> ai;
    private View c;
    private View d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private AnimationListView h;
    private SearchView i;
    private final int a = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int b = 0;
    private ArrayList<AlbumsInfo> aj = new ArrayList<>();
    private String ak = "";
    private int al = -1;
    private boolean am = false;
    private View.OnClickListener an = new ahl(this) { // from class: amp.1
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.back /* 2131690262 */:
                    amp.this.ae.ag();
                    break;
            }
        }
    };
    private SearchView.OnQueryTextListener ao = new SearchView.OnQueryTextListener() { // from class: amp.2
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                amp.this.ai.a(amp.this.a(amp.this.aj, amp.this.d()));
                amp.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                amp.this.d.setVisibility(8);
            } else {
                ArrayList<AlbumsInfo> arrayListA = amp.this.a(amp.this.aj, str);
                if (arrayListA.size() > 0) {
                    amp.this.ai.a(amp.this.a(arrayListA, amp.this.d()));
                    amp.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                    amp.this.d.setVisibility(8);
                } else {
                    amp.this.e.setText(amp.this.a(R.string.kQobuz_Filter_Empty_Str));
                    amp.this.d.findViewById(R.id.pro_bar).setVisibility(8);
                    amp.this.d.setVisibility(0);
                }
            }
            amp.this.ai.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            new Handler().postDelayed(new Runnable() { // from class: amp.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ahf.a((Activity) amp.this.ae);
                }
            }, 200L);
            return true;
        }
    };
    private ajn ap = new ajn() { // from class: amp.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            amp.this.ah.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + amp.this.b, amp.this);
        }
    };
    private ajo.b aq = new ajo.b() { // from class: amp.4
        @Override // ajo.b
        public View a(ViewGroup viewGroup, MotionEvent motionEvent) {
            LinearLayout linearLayout = ((c) viewGroup.getTag()).b;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt.getVisibility() != 0) {
                    return null;
                }
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (new Rect(i2, i3, childAt.getWidth() + i2, childAt.getHeight() + i3).contains(Math.round(motionEvent.getRawX()), Math.round(motionEvent.getRawY()))) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // ajo.b
        public Object a(View view, ViewGroup viewGroup, MotionEvent motionEvent) {
            return view.getTag();
        }
    };
    private AdapterView.OnItemClickListener ar = new AdapterView.OnItemClickListener() { // from class: amp.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (amp.this.al != -1) {
                AlbumsInfo albumsInfo = (AlbumsInfo) ((c) view.getTag()).c.get(amp.this.al).a.getTag();
                Bundle bundle = new Bundle();
                bundle.putParcelable("ALBUMSINFO", albumsInfo);
                if ("DISCOG".equals(amp.this.ak)) {
                    bundle.putString("FLAG", "DISCOG");
                }
                bundle.putBoolean("ADD", true);
                amm ammVar = new amm();
                ammVar.g(bundle);
                if (!ahn.a()) {
                    amp.this.ae.q().a(ammVar, (arc) null);
                } else {
                    amp.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
                }
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
        this.ah = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.common_albums_list_layout, (ViewGroup) null);
        this.h = (AnimationListView) this.c.findViewById(R.id.list_view);
        this.h.setCallback(this.aq);
        this.h.setOnItemClickListener(this.ar);
        this.h.setOnItemChosenListener(this.ap);
        this.d = this.c.findViewById(R.id.loading);
        this.e = (TextView) this.c.findViewById(R.id.tips);
        this.e.setTextColor(q().getColor(R.color.black));
        this.f = (TextView) this.c.findViewById(R.id.title);
        this.f.setTypeface(ahu.b(this.ae));
        this.g = (ImageView) this.c.findViewById(R.id.back);
        this.g.setColorFilter(q().getColor(R.color.black));
        this.g.setOnClickListener(this.an);
        this.i = (SearchView) this.c.findViewById(R.id.search_view);
        this.i.setQueryHint(a(R.string.kQobuz_AlbumName_Filter_Str));
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ai = new aih<>(this.ae, new b(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_album_item_holder, R.layout.harman_list_loading);
        this.h.setAdapter((ListAdapter) this.ai);
        this.i.setOnQueryTextListener(this.ao);
    }

    @SuppressLint({"DefaultLocale"})
    public ArrayList<AlbumsInfo> a(ArrayList<AlbumsInfo> arrayList, String str) {
        ArrayList<AlbumsInfo> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AlbumsInfo albumsInfo = arrayList.get(i);
            if (!TextUtils.isEmpty(albumsInfo.b) && albumsInfo.b.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(albumsInfo);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        String string = bundle.getString("TITLE");
        if (string != null && !"".equals(string.trim())) {
            this.f.setText(string);
            this.f.setTextColor(q().getColor(R.color.black));
        }
        String string2 = bundle.getString("ID");
        String str = "http://www.qobuz.com/api.json/0.2/collection/getAlbums?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&artist_id=" + string2 + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.b;
        this.ak = bundle.getString("FLAG") == null ? "" : bundle.getString("FLAG");
        this.ah.a("DISCOG".equals(this.ak) ? "http://www.qobuz.com/api.json/0.2/artist/get?app_id=394304373&artist_id=" + string2 + "&extra=albums&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.b : str, this);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    class b implements aih.a<ant> {
        b() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, ant antVar) {
            c cVar;
            int i2;
            c cVar2 = (c) view.getTag();
            if (cVar2 == null) {
                c cVar3 = amp.this.new c();
                cVar3.a = (TextView) view.findViewById(R.id.alphabet);
                cVar3.b = (LinearLayout) view.findViewById(R.id.items_holder);
                View view2 = new View(view.getContext());
                view2.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
                cVar3.b.addView(view2);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            if (ahn.a()) {
                if (amp.this.q().getConfiguration().orientation == 2) {
                    i2 = 5;
                } else if (amp.this.q().getConfiguration().orientation != 1) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 2;
            }
            for (int childCount = cVar.b.getChildCount() / 2; childCount < i2; childCount++) {
                a aVar = amp.this.new a();
                amp.this.p().getLayoutInflater().inflate(R.layout.qobuz_favourites_albums_item, cVar.b);
                aVar.a = (RelativeLayout) cVar.b.getChildAt(cVar.b.getChildCount() - 1);
                aVar.b = (ImageView) aVar.a.findViewById(R.id.iv);
                aVar.f = (ImageView) aVar.a.findViewById(R.id.hq_icon);
                aVar.c = (TextView) aVar.a.findViewById(R.id.item_title);
                aVar.d = (TextView) aVar.a.findViewById(R.id.item_art);
                aVar.e = (TextView) aVar.a.findViewById(R.id.item_year);
                aVar.a.setVisibility(4);
                cVar.c.add(aVar);
                View view3 = new View(view.getContext());
                view3.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
                cVar.b.addView(view3);
            }
            while (cVar.b.getChildCount() / 2 > i2) {
                cVar.b.removeViewAt(cVar.b.getChildCount() - 1);
                cVar.b.removeViewAt(cVar.b.getChildCount() - 1);
            }
            if (antVar.b) {
                cVar.a.setVisibility(0);
                cVar.a.setText(antVar.a);
            } else {
                cVar.a.setVisibility(8);
            }
            int i3 = 0;
            while (true) {
                final int i4 = i3;
                if (i4 < cVar.c.size()) {
                    if (i4 >= antVar.c.size()) {
                        cVar.c.get(i4).a.setVisibility(4);
                    } else {
                        AlbumsInfo albumsInfo = antVar.c.get(i4);
                        TextView textView = cVar.c.get(i4).c;
                        TextView textView2 = cVar.c.get(i4).d;
                        TextView textView3 = cVar.c.get(i4).e;
                        ImageView imageView = cVar.c.get(i4).b;
                        ImageView imageView2 = cVar.c.get(i4).f;
                        textView.setText(albumsInfo.b);
                        textView2.setText(albumsInfo.c);
                        if (0 == albumsInfo.d) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setText(ann.a(String.valueOf(albumsInfo.d), "dd/MM/yyyy"));
                            textView3.setVisibility(0);
                        }
                        if (albumsInfo.j) {
                            imageView2.setVisibility(0);
                        } else {
                            imageView2.setVisibility(8);
                        }
                        new ahw().a(imageView, albumsInfo.e);
                        cVar.c.get(i4).a.setOnTouchListener(new View.OnTouchListener() { // from class: amp.b.1
                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view4, MotionEvent motionEvent) {
                                amp.this.al = i4;
                                amp.this.am = true;
                                return false;
                            }
                        });
                        cVar.c.get(i4).a.setTag(albumsInfo);
                        cVar.c.get(i4).a.setVisibility(0);
                    }
                    i3 = i4 + 1;
                } else {
                    view.setTag(cVar);
                    view.setOnTouchListener(new View.OnTouchListener() { // from class: amp.b.2
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view4, MotionEvent motionEvent) {
                            if (!amp.this.am) {
                                amp.this.al = -1;
                            }
                            amp.this.am = false;
                            return false;
                        }
                    });
                    return view;
                }
            }
        }
    }

    class c {
        public TextView a;
        public LinearLayout b;
        public ArrayList<a> c = new ArrayList<>();

        c() {
        }
    }

    class a {
        public RelativeLayout a;
        public ImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;

        a() {
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        if ("DISCOG".equals(this.ak)) {
            jSONObject = jSONObject.optJSONObject("albums");
        }
        this.aj = any.d(jSONObject);
        ArrayList<ant> arrayListA = a(this.aj, d());
        if (this.b == 0) {
            this.ai.a(arrayListA);
            this.ai.notifyDataSetChanged();
        } else {
            this.ai.b(arrayListA);
        }
        this.d.setVisibility(8);
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
        this.d.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.d.setVisibility(8);
    }

    public ArrayList<ant> a(ArrayList<AlbumsInfo> arrayList, int i) {
        String[] stringArray = this.ae.getResources().getStringArray(R.array.alphabet_list);
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            AlbumsInfo albumsInfo = arrayList.get(i2);
            String strA = albumsInfo.a(Arrays.asList(stringArray));
            ArrayList<ant> arrayList2 = (ArrayList) map.get(strA);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                map.put(strA, arrayList2);
            }
            a(arrayList2, albumsInfo, strA, i);
        }
        ArrayList arrayList3 = new ArrayList(map.entrySet());
        Collections.sort(arrayList3, new Comparator<Map.Entry<String, ArrayList<ant>>>() { // from class: amp.6
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Map.Entry<String, ArrayList<ant>> entry, Map.Entry<String, ArrayList<ant>> entry2) {
                return entry.getKey().toString().compareTo(entry2.getKey());
            }
        });
        ArrayList<ant> arrayList4 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
            ArrayList arrayList5 = (ArrayList) ((Map.Entry) arrayList3.get(i3)).getValue();
            for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                arrayList4.add((ant) arrayList5.get(i4));
            }
        }
        return arrayList4;
    }

    private void a(ArrayList<ant> arrayList, AlbumsInfo albumsInfo, String str, int i) {
        if (arrayList.size() > 0) {
            ant antVar = arrayList.get(arrayList.size() - 1);
            if (antVar.c.size() < i) {
                antVar.c.add(albumsInfo);
                return;
            } else {
                if (antVar.c.size() >= i) {
                    ant antVar2 = new ant();
                    antVar2.a = str;
                    antVar2.c.add(albumsInfo);
                    arrayList.add(antVar2);
                    return;
                }
                return;
            }
        }
        ant antVar3 = new ant();
        antVar3.b = true;
        antVar3.a = str;
        antVar3.c.add(albumsInfo);
        arrayList.add(antVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        return (ahn.a() && q().getConfiguration().orientation == 2) ? 4 : 2;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ai.a(a(this.aj, d()));
        this.ai.notifyDataSetChanged();
    }
}
