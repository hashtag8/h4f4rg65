package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationViewPager;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import com.harman.hkconnect.ui.custom.ViewPagerPointLayout;
import defpackage.ajo;
import defpackage.bdh;
import defpackage.bif;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bed extends bdu {
    private ViewPagerPointLayout ak;
    private AnimationViewPager al;
    private a ar;
    private int as;
    int aj = 0;
    private ajn at = new ajn() { // from class: bed.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            bde bdeVar = (bde) obj;
            if (bdeVar.c.compareTo("PLAYLIST") == 0) {
                bdh.a().a(bdh.a.PlaylistMetaData, bed.this, bdeVar.b, "play");
            } else if (bdeVar.c.compareTo("ARTIST") == 0) {
                bdh.a().a(bdh.a.ArtistMetaData, bed.this, bdeVar.b, "play");
            } else if (bdeVar.c.compareTo("ALBUM") == 0) {
                bdh.a().a(bdh.a.AlbumMetaData, bed.this, bdeVar.b, "play");
            }
        }
    };

    @Override // defpackage.bdu, defpackage.bdn
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.as = q().getInteger(R.integer.Tidal_grid_columns);
        this.a = layoutInflater.inflate(R.layout.tidal_whatsnew, (ViewGroup) null);
        this.ah = layoutInflater;
        super.c(layoutInflater, viewGroup, bundle);
        ((TextView) this.a.findViewById(R.id.more_playlists)).setOnClickListener(new View.OnClickListener() { // from class: bed.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bee beeVar = new bee();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("current_screen", 0);
                beeVar.g(bundle2);
                if (!ahn.a()) {
                    bed.this.ae.q().a(beeVar, (arc) null);
                } else {
                    bed.this.ae.q().a(beeVar, new arc().c(R.id.menu_container));
                }
            }
        });
        ((TextView) this.a.findViewById(R.id.more_albums)).setOnClickListener(new View.OnClickListener() { // from class: bed.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bec becVar = new bec();
                if (!ahn.a()) {
                    bed.this.ae.q().a(becVar, (arc) null);
                } else {
                    bed.this.ae.q().a(becVar, new arc().c(R.id.menu_container));
                }
            }
        });
        ((TextView) this.a.findViewById(R.id.more_tracks)).setOnClickListener(new View.OnClickListener() { // from class: bed.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bef befVar = new bef();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("current_screen", 0);
                befVar.g(bundle2);
                if (!ahn.a()) {
                    bed.this.ae.q().a(befVar, (arc) null);
                } else {
                    bed.this.ae.q().a(befVar, new arc().c(R.id.menu_container));
                }
            }
        });
        this.ak = (ViewPagerPointLayout) this.a.findViewById(R.id.point_layout);
        this.al = (AnimationViewPager) this.a.findViewById(R.id.view_pager);
        this.al.a(this.h, true, new ajo.b() { // from class: bed.5
            @Override // ajo.b
            public View a(ViewGroup viewGroup2, MotionEvent motionEvent) {
                return viewGroup2.getChildAt(((int) motionEvent.getX()) / (viewGroup2.getWidth() / bed.this.as));
            }

            @Override // ajo.b
            public Object a(View view, ViewGroup viewGroup2, MotionEvent motionEvent) {
                return ((AnimationViewPager.a) bed.this.al.getAdapter()).b((((int) motionEvent.getX()) / (viewGroup2.getWidth() / bed.this.as)) + (bed.this.al.getCurrentItem() * bed.this.as));
            }
        });
        this.al.setOnItemChosenListener(this.at);
        this.al.setOnPageChangeListener(new ViewPager.f() { // from class: bed.6
            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                int iB = bed.this.al.getAdapter().b();
                if (i == 0) {
                    bed.this.al.a(iB - 2, false);
                } else if (i == iB - 1) {
                    bed.this.al.a(1, false);
                } else {
                    bed.this.ak.setSelectedPostion(i - 1);
                }
                mm.b("POINT", "set point layout to " + i);
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
            }
        });
        if (this.ar != null) {
            this.al.setAdapter(this.ar);
        }
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        b(q().getString(R.string.TidalWhatsNew));
        return this.a;
    }

    @Override // defpackage.bdu
    bdh.a ao() {
        return bdh.a.WhatsNewAlbums;
    }

    @Override // defpackage.bdu
    bdh.a ap() {
        return bdh.a.WhatsNewPlaylists;
    }

    @Override // defpackage.bdu
    bdh.a aq() {
        return bdh.a.WhatsNewTracks;
    }

    @Override // defpackage.bdn, defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        d();
        bdh.a().a(bdh.a.WhatsNewPlaylists, this, "new", "playlists");
        bdh.a().a(bdh.a.WhatsNewAlbums, this, "new", "albums");
        bdh.a().a(bdh.a.WhatsNewTracks, this, "new", "tracks", 0, 15);
        bdh.a().a(bdh.a.Promotional, this, "", "", 0, 50);
    }

    @Override // defpackage.bdn
    public void c() {
        this.aj = 0;
    }

    @Override // defpackage.bdu, bdi.b
    public void a(bdh.a aVar, JSONObject jSONObject, String str) {
        super.a(aVar, jSONObject, str);
        if (aVar == bdh.a.Promotional) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    bde bdeVar = new bde();
                    bdeVar.d = bru.a(jSONObject2.getString("shortHeader"));
                    bdeVar.e = bru.a(jSONObject2.getString("shortSubHeader"));
                    bdeVar.c = bru.a(jSONObject2.getString("type"));
                    bdeVar.b = bru.a(jSONObject2.getString("artifactId"));
                    bdeVar.a = bru.a(jSONObject2.getString("imageURL"));
                    if (bdeVar.b.contains("-") && bdeVar.c.compareTo("ALBUM") == 0) {
                        bdeVar.c = "PLAYLIST";
                    } else if (bdeVar.c.compareTo("PLAYLIST") == 0 && !bdeVar.b.contains("-")) {
                        bdeVar.c = "ALBUM";
                    }
                    if (bdeVar.c.compareTo("PLAYLIST") == 0 || bdeVar.c.compareTo("ARTIST") == 0 || bdeVar.c.compareTo("ALBUM") == 0) {
                        arrayList.add(bdeVar);
                    }
                }
                if (this.ar == null) {
                    this.ar = new a(this.ae, arrayList);
                    this.al.setAdapter(this.ar);
                }
                if (this.aj == 0) {
                    this.ak.setSize(this.ar.b() - 2);
                    this.al.a(1, false);
                    this.aj = this.ar.b() - 2;
                    if (this.aj == 1) {
                        this.ak.setVisibility(4);
                    }
                } else {
                    this.ak.setSelectedPostion(this.al.getCurrentItem());
                }
                mm.b("POINT", "set point layout size to " + this.ar.b());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class a extends ex implements AnimationViewPager.a {
        private List<bde> b;
        private List<View> c = new ArrayList();
        private Context d;

        public a(Context context, List<bde> list) {
            this.d = context;
            int size = list.size() + 4;
            this.b = new ArrayList();
            this.b.add(0, new bde());
            this.b.add(1, new bde());
            for (int i = 0; i < list.size(); i++) {
                this.b.add(i + 2, list.get(i));
            }
            this.b.add(0, list.get(list.size() - 2));
            this.b.add(1, list.get(list.size() - 1));
            this.b.remove(2);
            this.b.remove(2);
            this.b.add(size - 2, list.get(0));
            this.b.add(size - 1, list.get(1));
            mm.b("MyViewPagerAdapter", "created new view pager adapter");
        }

        @Override // defpackage.ex
        public int b() {
            if (this.b == null) {
                return 0;
            }
            return this.b.size() / bed.this.as;
        }

        @Override // defpackage.ex
        public Object a(ViewGroup viewGroup, int i) {
            mm.b("View", "asked for " + i);
            int i2 = i * bed.this.as;
            View viewInflate = bed.this.ah.inflate(R.layout.tidal_promotions, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.content);
            linearLayout.setWeightSum(1.0f);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                if (i4 >= bed.this.as) {
                    break;
                }
                View viewInflate2 = bed.this.ah.inflate(R.layout.tidal_promotions_item, (ViewGroup) null);
                final bde bdeVar = this.b.get(i5);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.tv);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.tv_a);
                final StoredBitmapImageView storedBitmapImageView = (StoredBitmapImageView) viewInflate2.findViewById(R.id.iv);
                textView.setText(bdeVar.d);
                textView.setTypeface(bcw.a(bed.this.ae));
                textView2.setText(bdeVar.e);
                textView2.setTypeface(bcw.b(bed.this.ae));
                new ahw().a(storedBitmapImageView, new ahq() { // from class: bed.a.1
                    @Override // defpackage.ahq
                    public void a(View view) {
                        bif.a((Context) bed.this.ae).a(bdeVar.a).b(view.getWidth(), view.getHeight()).e().c().a((bip) new ahr(new bip() { // from class: bed.a.1.1
                            @Override // defpackage.bip
                            public void a(Bitmap bitmap, bif.d dVar) {
                                storedBitmapImageView.setImageBitmap(bitmap);
                                storedBitmapImageView.setStoredBitmap(bitmap);
                                storedBitmapImageView.invalidate();
                            }

                            @Override // defpackage.bip
                            public void a(Drawable drawable) {
                            }

                            @Override // defpackage.bip
                            public void b(Drawable drawable) {
                            }
                        }));
                    }
                });
                viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: bed.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bdeVar.c.compareTo("PLAYLIST") == 0) {
                            bdh.a().a(bdh.a.PlaylistMetaData, bed.this, bdeVar.b, "");
                        } else if (bdeVar.c.compareTo("ARTIST") == 0) {
                            bdh.a().a(bdh.a.ArtistMetaData, bed.this, bdeVar.b, "");
                        } else if (bdeVar.c.compareTo("ALBUM") == 0) {
                            bdh.a().a(bdh.a.AlbumMetaData, bed.this, bdeVar.b, "");
                        }
                    }
                });
                mm.b("PROMOTIONS", "Adding " + i + " " + i4 + " " + i5);
                viewInflate2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f / bed.this.as));
                linearLayout.addView(viewInflate2);
                i2 = i5 + 1;
                i3 = i4 + 1;
            }
            while (this.c.size() <= i) {
                this.c.add(null);
            }
            this.c.set(i, viewInflate);
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // defpackage.ex
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // defpackage.ex
        public boolean a(View view, Object obj) {
            return view == obj;
        }

        @Override // com.harman.hkconnect.ui.custom.AnimationViewPager.a
        public View a(int i) {
            return this.c.get(i);
        }

        @Override // com.harman.hkconnect.ui.custom.AnimationViewPager.a
        public Object b(int i) {
            return this.b.get(i);
        }
    }
}
