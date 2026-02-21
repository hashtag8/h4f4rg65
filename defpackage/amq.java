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
public class amq extends ajj implements anu<JSONObject> {
    private aih<ant> ah;
    private View c;
    private View d;
    private TextView e;
    private AnimationListView f;
    private SearchView g;
    private View h;
    private anv i;
    private final int a = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int b = 0;
    private ArrayList<AlbumsInfo> ai = new ArrayList<>();
    private int aj = -1;
    private boolean ak = false;
    private SearchView.OnQueryTextListener al = new SearchView.OnQueryTextListener() { // from class: amq.1
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                amq.this.ah.a(amq.this.a(amq.this.ai, amq.this.al()));
                amq.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                amq.this.d.setVisibility(8);
            } else {
                ArrayList<AlbumsInfo> arrayListA = amq.this.a(amq.this.ai, str);
                if (arrayListA.size() > 0) {
                    amq.this.ah.a(amq.this.a(arrayListA, amq.this.al()));
                    amq.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                    amq.this.d.setVisibility(8);
                } else {
                    amq.this.e.setText(amq.this.a(R.string.kQobuz_Filter_Empty_Str));
                    amq.this.d.findViewById(R.id.pro_bar).setVisibility(8);
                    amq.this.d.setVisibility(0);
                }
            }
            amq.this.ah.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            new Handler().postDelayed(new Runnable() { // from class: amq.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ahf.a((Activity) amq.this.ae);
                }
            }, 200L);
            return true;
        }
    };
    private ajn am = new ajn() { // from class: amq.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            amq.this.i.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + amq.this.b, amq.this);
        }
    };
    private ajo.b an = new ajo.b() { // from class: amq.3
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
    private AdapterView.OnItemClickListener ao = new AdapterView.OnItemClickListener() { // from class: amq.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (amq.this.aj != -1) {
                AlbumsInfo albumsInfo = (AlbumsInfo) ((c) view.getTag()).c.get(amq.this.aj).a.getTag();
                Bundle bundle = new Bundle();
                bundle.putParcelable("ALBUMSINFO", albumsInfo);
                amm ammVar = new amm();
                ammVar.g(bundle);
                if (!ahn.a()) {
                    amq.this.ae.q().a(ammVar, (arc) null);
                } else {
                    amq.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
                }
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
        this.i = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.qobuz_favourites_list_layout, (ViewGroup) null);
        this.f = (AnimationListView) this.c.findViewById(R.id.list_view);
        this.f.setCallback(this.an);
        this.f.setOnItemClickListener(this.ao);
        this.f.setOnItemChosenListener(this.am);
        this.d = this.c.findViewById(R.id.loading);
        this.e = (TextView) this.c.findViewById(R.id.tips);
        this.e.setTextColor(q().getColor(R.color.black));
        this.g = (SearchView) this.c.findViewById(R.id.search_view);
        this.g.setQueryHint(a(R.string.kQobuz_AlbumName_Filter_Str));
        this.h = this.c.findViewById(R.id.notice);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ah = new aih<>(this.ae, new b(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_album_item_holder, R.layout.harman_list_loading);
        this.f.setAdapter((ListAdapter) this.ah);
        this.g.setOnQueryTextListener(this.al);
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        if (this.ai.size() == 0) {
            d();
        }
    }

    public void d() {
        this.i.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&type=albums&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.b, this);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
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
                c cVar3 = amq.this.new c();
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
                if (amq.this.q().getConfiguration().orientation == 2) {
                    i2 = 4;
                } else if (amq.this.q().getConfiguration().orientation != 1) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 2;
            }
            for (int childCount = cVar.b.getChildCount() / 2; childCount < i2; childCount++) {
                a aVar = amq.this.new a();
                amq.this.p().getLayoutInflater().inflate(R.layout.qobuz_favourites_albums_item_item, cVar.b);
                aVar.a = (RelativeLayout) cVar.b.getChildAt(cVar.b.getChildCount() - 1);
                aVar.b = (ImageView) aVar.a.findViewById(R.id.iv);
                aVar.f = (ImageView) aVar.a.findViewById(R.id.hq_icon);
                aVar.c = (TextView) aVar.a.findViewById(R.id.item_title);
                aVar.d = (TextView) aVar.a.findViewById(R.id.item_art);
                aVar.e = (TextView) aVar.a.findViewById(R.id.item_genre_name);
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
                        textView3.setText(albumsInfo.i.toUpperCase());
                        textView3.setVisibility(0);
                        if (albumsInfo.j) {
                            imageView2.setVisibility(0);
                        } else {
                            imageView2.setVisibility(8);
                        }
                        new ahw().a(imageView, albumsInfo.e);
                        cVar.c.get(i4).a.setOnTouchListener(new View.OnTouchListener() { // from class: amq.b.1
                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view4, MotionEvent motionEvent) {
                                amq.this.aj = i4;
                                amq.this.ak = true;
                                return false;
                            }
                        });
                        cVar.c.get(i4).a.setTag(albumsInfo);
                        cVar.c.get(i4).a.setVisibility(0);
                    }
                    i3 = i4 + 1;
                } else {
                    view.setTag(cVar);
                    view.setOnTouchListener(new View.OnTouchListener() { // from class: amq.b.2
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view4, MotionEvent motionEvent) {
                            if (!amq.this.ak) {
                                amq.this.aj = -1;
                            }
                            amq.this.ak = false;
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
        this.ai = any.d(jSONObject.optJSONObject("albums"));
        ArrayList<ant> arrayListA = a(this.ai, al());
        if (this.b == 0) {
            this.ah.a(arrayListA);
            this.ah.notifyDataSetChanged();
        } else {
            this.ah.b(arrayListA);
        }
        this.d.setVisibility(8);
        if (arrayListA.size() == 0) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
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
        Collections.sort(arrayList3, new Comparator<Map.Entry<String, ArrayList<ant>>>() { // from class: amq.5
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

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ah.a(a(this.ai, al()));
        this.ah.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al() {
        return (ahn.a() && q().getConfiguration().orientation == 2) ? 4 : 2;
    }
}
