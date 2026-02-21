package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.musicservice.dlna.customviews.LoadMoreListView;
import com.stc.upnp.services.DlnaService;
import defpackage.age;
import defpackage.aqw;
import defpackage.avi;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class avq extends awb implements aqw.a, avi.a {
    private View a;
    private avi aA;
    private avj aB;
    private String aF;
    private ImageView ah;
    private TextView ai;
    private TextView aj;
    private View ak;
    private AnimationGridView al;
    private LoadMoreListView am;
    private View an;
    private View ao;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private Dialog ax;
    private int ay;
    protected afj b;
    private boolean ap = false;
    private boolean aw = true;
    private boolean az = false;
    private AdapterView.OnItemClickListener aC = new AdapterView.OnItemClickListener() { // from class: avq.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (avv.ap() != null) {
                avv.ap().a();
            }
            MusicData musicData = (MusicData) adapterView.getItemAtPosition(i);
            avq.this.aJ().a(musicData.getContainerID(), musicData);
        }
    };
    private AdapterView.OnItemClickListener aD = new AdapterView.OnItemClickListener() { // from class: avq.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!avq.this.az()) {
                avq.this.a((MusicData) adapterView.getItemAtPosition(i), i, adapterView);
            }
        }
    };
    private View.OnClickListener aE = new View.OnClickListener() { // from class: avq.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back /* 2131690262 */:
                    avq.this.l(true);
                    break;
            }
        }
    };

    @Override // aqw.a
    public void a(boolean z) {
        this.aw = z;
    }

    public void al() {
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.av = 0;
        if (this.aB != null) {
            this.aB.a((List<MusicData>) null, true);
        }
        if (this.aA != null) {
            this.aA.a();
        }
    }

    public void a(String str, boolean z, Bundle bundle) {
        al();
        a(str, false, z, bundle);
    }

    public void a(String str, boolean z, boolean z2, Bundle bundle) {
        String str2;
        String string;
        String str3;
        this.c = null;
        this.az = true;
        if (z2) {
            if (this.ay == 0) {
                str3 = DlnaService.a + " and " + (DlnaService.f + "\"" + str + "\"");
            } else {
                str3 = DlnaService.f + "\"" + str + "\"";
            }
            string = l().getString("conatinerid");
            str2 = str3;
        } else {
            String[] strArrB = b(str, z2, bundle);
            str2 = strArrB[0];
            string = strArrB[1];
        }
        if (string.equalsIgnoreCase("true")) {
            a(str2, true, "0", null, this.av, false);
        } else if (string.equalsIgnoreCase("false")) {
            a(str2, true, "0", null, this.au, false);
        } else {
            a(str2, true, string, null, this.au, false);
        }
    }

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.b = afj.a(2001);
        this.au = 0;
        this.av = 0;
        this.ax = c(p());
        if (this.ax != null) {
            this.ax.setCancelable(true);
        }
        a((String) null, false);
    }

    public void a(String str, boolean z) {
        switch (c()) {
            case 0:
                a(DlnaService.d, d(), "0", null, this.av, z);
                break;
            case 1:
                a(DlnaService.e, d(), "0", null, this.au, z);
                break;
            case 2:
                a(DlnaService.b, d(), "0", null, this.av, z);
                break;
            case 3:
                a(DlnaService.c, d(), "0", null, this.av, z);
                break;
            case 4:
                a(DlnaService.a, d(), "0", null, this.av, z);
                break;
            case 5:
                a(str, z, false, (Bundle) null);
                break;
            case 6:
                c(true);
                break;
        }
    }

    public void c(boolean z) {
        if (!z) {
            al();
        }
        Bundle bundleL = l();
        a(DlnaService.e, d(), bundleL.getString("conatinerid"), (MusicData) bundleL.getParcelable("musicdata"), this.au, false);
    }

    public String[] b(String str, boolean z, Bundle bundle) {
        String str2;
        String str3 = null;
        if (bundle == null) {
            bundle = l();
        }
        String string = bundle.getString("filter");
        if (str == null) {
            str = bundle.getString("search");
        }
        if (bundle.containsKey("conatinerid")) {
            String string2 = bundle.getString("conatinerid");
            if (!string2.equalsIgnoreCase("0")) {
                return new String[]{DlnaService.f + "\"" + str + "\"", string2};
            }
        }
        if (z) {
            string = "TAG_ALBUM";
        }
        if (string.equalsIgnoreCase("TAG_SONG")) {
            str3 = DlnaService.e;
            str2 = "false";
        } else if (string.equalsIgnoreCase("TAG_PLAYLIST")) {
            str3 = DlnaService.d;
            str2 = "true";
        } else if (string.equalsIgnoreCase("TAG_ALBUM")) {
            str3 = DlnaService.a;
            str2 = "true";
        } else if (string.equalsIgnoreCase("TAG_ARTIST")) {
            str3 = DlnaService.b;
            str2 = "true";
        } else if (string.equalsIgnoreCase("TAG_GENRE")) {
            str3 = DlnaService.c;
            str2 = "true";
        } else {
            str2 = null;
        }
        return new String[]{str3 + " and " + (DlnaService.f + "\"" + str + "\""), str2};
    }

    public void a(String str, final boolean z, final String str2, final MusicData musicData, int i, final boolean z2) {
        bjl bjlVarF;
        this.aF = str;
        if (this.ax != null && !z2) {
            a(this.ax, this.ae);
        }
        Bundle bundleL = l();
        if (bundleL != null) {
            bjq bjqVar = (bjq) bundleL.getSerializable("service");
            if (z) {
                bjlVarF = bjqVar.f("Search");
            } else {
                bjlVarF = bjqVar.f("Browse");
            }
            if (bjlVarF != null) {
                bky.a(str2, bjlVarF, new bjb() { // from class: avq.4
                    @Override // defpackage.bjb
                    public void a(List<bjp> list, int i2, int i3) {
                        if (avq.this.p() != null) {
                            if (avq.this.ax != null) {
                                avq.this.b(avq.this.ax, avq.this.ae);
                            }
                            avq.this.am.c();
                            if (list != null) {
                                if (list.size() != 0 && (i2 != 0 || i3 != 0)) {
                                    if (avq.this.aF != null) {
                                        if (avq.this.aF.equalsIgnoreCase(DlnaService.e) || avq.this.aF.contains(DlnaService.e)) {
                                            avq.this.aq = i3;
                                            avq.this.ar += i2;
                                        } else if (avq.this.az) {
                                            avq.this.aq = i3;
                                            avq.this.ar += i2;
                                        } else {
                                            avq.this.as = i3;
                                            avq.this.at += i2;
                                        }
                                        if (i2 == 0) {
                                            avq.this.m(z2);
                                            return;
                                        }
                                    }
                                    List<MusicData> listA = awe.a(list);
                                    if (avq.this.c == null) {
                                        avq.this.c = listA;
                                    } else {
                                        avq.this.c.addAll(listA);
                                    }
                                    if (listA != null && listA.size() > 0) {
                                        if (listA.get(0).getObjectClass().startsWith("object.container")) {
                                            avq.this.ay = 0;
                                        } else if (listA.get(0).getObjectClass().startsWith("object.item.audioItem")) {
                                            avq.this.ay = 1;
                                        }
                                    }
                                    if (listA.size() > 0) {
                                        avq.this.a(avq.this.aF, listA, z, musicData, str2);
                                        return;
                                    }
                                    return;
                                }
                                avq.this.m(z2);
                                return;
                            }
                            avq.this.m(z2);
                        }
                    }

                    @Override // defpackage.bjb
                    public void a(String str3) {
                        if (avq.this.ax != null) {
                            avq.this.b(avq.this.ax, avq.this.ae);
                        }
                        if (str3.contains("invalid search criteria")) {
                            avq.this.m(false);
                            return;
                        }
                        avq.this.a((Context) avq.this.p(), "Connection Error", "Server connection failed", true);
                        avq.this.m(z2);
                        Toast.makeText(avq.this.ae, str3, 0).show();
                    }
                }, i, 100, this.aF, z);
            }
        }
    }

    public void l(boolean z) {
        this.aj.setVisibility(8);
        if (z) {
            this.ao.setVisibility(0);
            this.al.setVisibility(0);
            this.an.setVisibility(8);
        } else {
            this.ao.setVisibility(8);
            this.am.setVisibility(0);
            this.an.setVisibility(0);
        }
    }

    public void a(List<MusicData> list) {
        mm.b("Showing list view %s", list);
        l(false);
        if (this.aB == null) {
            this.aB = new avj(p(), list);
            this.aB.a(list, true);
            this.am.setAdapter((ListAdapter) this.aB);
            this.am.setFastScrollEnabled(true);
            this.am.setIndexScrollerListener(this);
            return;
        }
        this.aB.a(list, false);
        this.aB.notifyDataSetChanged();
    }

    public void am() {
    }

    public void m(boolean z) {
        if (!z) {
            this.am.setVisibility(8);
            this.al.setVisibility(8);
            this.aj.setVisibility(0);
        }
    }

    public void a(String str, List<MusicData> list, boolean z, MusicData musicData, String str2) {
        mm.b("Showing data %s, arguments %s", list, l());
        if (!z) {
            a(list);
            am();
            return;
        }
        if (!str.equalsIgnoreCase(DlnaService.e) && !str.contains(DlnaService.e) && str2.equalsIgnoreCase("0")) {
            l(true);
            if (this.aA == null) {
                this.aA = new avi(p(), list, this, this.al);
                this.aA.a(this.at, this.as);
                this.al.setAdapter((ListAdapter) this.aA);
                return;
            } else {
                this.aA.a(this.at, this.as);
                this.aA.a(list);
                this.aA.notifyDataSetChanged();
                return;
            }
        }
        a(list);
    }

    public void a(MusicData musicData, int i, AdapterView<?> adapterView) {
        if (musicData != null) {
            if (musicData.getObjectClass().startsWith("object.container")) {
                aJ().a(musicData.getContainerID(), musicData);
            } else if (musicData.getObjectClass().startsWith("object.item.audioItem")) {
                a(adapterView, i);
            }
        }
    }

    @Override // avi.a
    public void a() {
        if (this.at < this.as - 1) {
            this.av = this.at + 1;
            a((String) null, true);
        }
    }

    @Override // defpackage.awb, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.search_playlist, (ViewGroup) null);
        if (this instanceof avm) {
            b(l().getString("name"));
            d(-1);
        } else if (aJ() != null && !(this instanceof avr)) {
            aJ().a_(this);
        }
        this.a = layoutInflater.inflate(R.layout.list_control_head, (ViewGroup) null);
        this.ao = this.ak.findViewById(R.id.search_gridview_layout);
        this.al = (AnimationGridView) this.ak.findViewById(R.id.search_gridview);
        aK();
        this.al.setOnItemClickListener(this.aC);
        this.al.setOnItemChosenListener(new ajn() { // from class: avq.5
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (aof.a().l() && !ain.j) {
                    Toast.makeText(avq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                MusicData musicData = (MusicData) obj;
                if (musicData != null) {
                    avq.this.new a("", musicData).a(0, 100, new age.a() { // from class: avq.5.1
                        @Override // age.a
                        public void a(int i2, List<MusicData> list, JSONObject jSONObject) {
                            MusicPlaylistManager.a().h();
                            MusicPlaylistManager.a().b(list);
                        }

                        @Override // age.a
                        public void a(ErrorInfo errorInfo) {
                            avq.this.d(errorInfo.toString());
                        }
                    });
                }
            }
        });
        this.ah = (ImageView) this.a.findViewById(R.id.back);
        this.ah.setOnClickListener(this.aE);
        this.ai = (TextView) this.a.findViewById(R.id.title);
        this.ai.setTypeface(ahu.a(this.ae));
        this.aj = (TextView) this.ak.findViewById(R.id.tips1);
        this.aj.setTypeface(ahu.a(this.ae));
        this.am = (LoadMoreListView) this.ak.findViewById(R.id.search_listview);
        this.am.setBackgroundColor((int) (1.671168E7d + (Math.random() * 16.0d)));
        this.am.setOnItemClickListener(this.aD);
        this.am.setOnItemChosenListener(new ajn() { // from class: avq.6
            @Override // defpackage.ajn
            public void a(View view, int i, Object obj) {
                if (!avq.this.az()) {
                    avq.this.a((MusicData) obj, i, (AnimationListView) view);
                }
            }
        });
        this.am.setOnLoadMoreListener(new LoadMoreListView.a() { // from class: avq.7
            @Override // com.musicservice.dlna.customviews.LoadMoreListView.a
            public void a() {
                String string;
                if (avq.this.ar >= avq.this.aq - 1) {
                    awe.a(avq.this.am);
                    return;
                }
                avq.this.au = avq.this.ar + 1;
                Bundle bundleL = avq.this.l();
                if (avq.this.c() == 6) {
                    string = bundleL.getString("conatinerid");
                } else {
                    string = "0";
                }
                avq.this.a(avq.this.aF, true, string, null, avq.this.au, true);
            }
        });
        this.an = this.ak.findViewById(R.id.search_listview_layout);
        this.ak.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.ak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.am.setFastScrollEnabled(true);
        this.am.setIndexScrollerListener(this);
    }

    protected int c() {
        return 0;
    }

    protected boolean d() {
        return false;
    }

    @Override // defpackage.awb, defpackage.ajk
    public String av() {
        return l() != null ? l().getString("server_name") + "_" + super.av() : super.av();
    }

    public class a extends age {
        private final MusicData b;

        public a(String str, MusicData musicData) {
            super(str);
            this.b = musicData;
        }

        @Override // defpackage.age
        protected void b(final int i, int i2, final age.a aVar) {
            bjl bjlVarF;
            String str = DlnaService.e;
            boolean zD = avq.this.d();
            String containerID = this.b.getContainerID();
            int i3 = avq.this.av;
            avq.this.aF = str;
            if (avq.this.ax != null) {
                avq.this.a(avq.this.ax, avq.this.ae);
            }
            Bundle bundleL = avq.this.l();
            if (bundleL != null) {
                bjq bjqVar = (bjq) bundleL.getSerializable("service");
                if (zD) {
                    bjlVarF = bjqVar.f("Search");
                } else {
                    bjlVarF = bjqVar.f("Browse");
                }
                if (bjlVarF != null) {
                    bky.a(containerID, bjlVarF, new bjb() { // from class: avq.a.1
                        @Override // defpackage.bjb
                        public void a(List<bjp> list, int i4, int i5) {
                            if (avq.this.p() != null) {
                                if (avq.this.ax != null) {
                                    avq.this.b(avq.this.ax, avq.this.ae);
                                }
                                avq.this.am.c();
                                if (list != null) {
                                    if (list.size() == 0 || (i4 == 0 && i5 == 0)) {
                                        avq.this.m(false);
                                        return;
                                    }
                                    List<MusicData> listA = awe.a(list);
                                    for (int i6 = 0; i6 < avq.this.c.size(); i6++) {
                                        a.this.d().put(Integer.valueOf(i + i6), avq.this.c.get(i6));
                                    }
                                    aVar.a(i, listA, null);
                                    return;
                                }
                                avq.this.m(false);
                            }
                        }

                        @Override // defpackage.bjb
                        public void a(String str2) {
                            if (avq.this.ax != null) {
                                avq.this.b(avq.this.ax, avq.this.ae);
                            }
                            if (str2.contains("invalid search criteria")) {
                                avq.this.m(false);
                                return;
                            }
                            avq.this.a((Context) avq.this.p(), "Connection Error", "Server connection failed", true);
                            avq.this.m(false);
                            Toast.makeText(avq.this.ae, str2, 0).show();
                        }
                    }, i3, 100, avq.this.aF, zD);
                }
            }
        }
    }

    private void aK() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ae.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int iA = awe.a(q().getInteger(R.integer.dlna_grid_column_width), this.ae);
        int i2 = i / iA;
        this.al.setNumColumns(i2);
        int i3 = (i - (iA * i2)) / (i2 + 1);
        int iA2 = awe.a(10, this.ae);
        int iA3 = awe.a(60, this.ae);
        this.al.setHorizontalSpacing(i3);
        this.al.setPadding(i3, iA2, i3, iA3);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aK();
    }
}
