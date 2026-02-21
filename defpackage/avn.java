package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.dlna.customviews.LoadMoreListView;
import defpackage.aqw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avn extends avl implements ajt, aqw.a {
    static boolean b = false;
    private int ah;
    private TextView ai;
    private boolean aj;
    private String ak;
    private String al;
    private int am;
    private EditText ao;
    private LoadMoreListView ap;
    private bbe aq;
    private avh e;
    private bjl f;
    private int g;
    private int h;
    private int d = 1;
    private boolean i = true;
    private bjb an = new bjb() { // from class: avn.1
        @Override // defpackage.bjb
        public void a(List<bjp> list, int i, int i2) {
            if (avn.this.p() != null) {
                avn.this.g = i2;
                if (!list.isEmpty() || (avn.this.e != null && avn.this.e.getCount() != 0)) {
                    avn.this.ai.setVisibility(4);
                } else {
                    avn.this.ai.setText(avn.this.p().getResources().getString(R.string.DLNA_NoAudioContentFound));
                    avn.this.ai.setVisibility(0);
                }
                avn.this.h += i;
                avn.this.ap.setMax(avn.this.g);
                avn.this.ap.setTotalItems(avn.this.h);
                List<MusicData> listA = awe.a(list);
                if (avn.this.c != null || avn.this.a(listA) == null) {
                    if (avn.this.a(listA) != null) {
                        avn.this.c.addAll(avn.this.a(listA));
                    }
                } else {
                    avn.this.c = avn.this.a(listA);
                }
                if (avn.this.e != null) {
                    avn.this.e.a(list, listA, false);
                    avn.this.ap.setFastScrollEnabled(true);
                    avn.this.ap.setIndexScrollerListener(avn.this);
                    avn.this.e.notifyDataSetChanged();
                    avn.this.ap.c();
                } else {
                    avn.this.e = new avh(list, avn.this.p(), listA, avn.this.ai, avn.this);
                    avn.this.e.a(list, listA, true);
                    avn.this.ap.setAdapter((ListAdapter) avn.this.e);
                    avn.this.ap.setFastScrollEnabled(true);
                    avn.this.ap.setIndexScrollerListener(avn.this);
                    avn.this.ap.c();
                }
                avn.this.c();
                if (avn.this.ak != null) {
                    avn.this.e.getFilter().filter(avn.this.ak);
                }
                if (i2 < 100 && i < i2 && avn.this.h < i2) {
                    bky.a(avn.this.al, avn.this.f, avn.this.an, avn.this.e.getCount(), 100);
                }
                if (i2 > 100 && i < i2 && avn.this.e.getCount() == 0) {
                    avn.this.am = avn.this.am + 100 + 1;
                    bky.a(avn.this.al, avn.this.f, avn.this.an, avn.this.am, 100);
                }
            }
        }

        @Override // defpackage.bjb
        public void a(String str) {
            if (avn.this.p() != null) {
                avn.this.c();
                avn.this.aq.a(avn.this.al());
                avn.this.a((Context) avn.this.p(), "Connection Error", "Server connection failed", true);
                Toast.makeText(avn.this.p(), "" + str, 0).show();
            }
        }
    };
    private TextWatcher ar = new TextWatcher() { // from class: avn.2
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (avn.this.e != null) {
                if (avn.this.e != null) {
                    avn.this.aj = true;
                }
                avn.this.ak = editable.toString();
                avn.this.e.getFilter().filter(editable.toString());
            }
        }
    };
    private AdapterView.OnItemClickListener as = new AdapterView.OnItemClickListener() { // from class: avn.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            avn.this.b(adapterView, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public List<MusicData> a(List<MusicData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MusicData musicData = list.get(i);
            if (musicData.getObjectClass().startsWith("object.item.audioItem") && musicData.getDurations() != null && !musicData.getDurations().equalsIgnoreCase("null") && musicData.getDurations().length() != 0 && !musicData.getDurations().equalsIgnoreCase("")) {
                arrayList.add(musicData);
            }
        }
        return arrayList;
    }

    public void c() {
        if (this.aq != null) {
            this.aq.a(al());
        }
    }

    @Override // aqw.a
    public void a(boolean z) {
        this.i = z;
    }

    @Override // defpackage.avv, defpackage.ajj
    public ajv b() {
        return aq().a(ao()).a(q().getColor(R.color.black)).c(false).e(q().getColor(R.color.white)).a(this).f(this.ae.getResources().getColor(R.color.white)).c();
    }

    @Override // defpackage.avv, defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        ahf.a((Activity) p());
    }

    public void d() {
        this.ao.addTextChangedListener(this.ar);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.browse, (ViewGroup) null);
        this.ap = (LoadMoreListView) viewInflate.findViewById(R.id.browse_listViewID);
        this.ao = (EditText) viewInflate.findViewById(R.id.searchEditText);
        this.ai = (TextView) viewInflate.findViewById(R.id.noresultstextId);
        this.aq = new bbe(viewInflate, this.ap);
        this.aq.a();
        b(l().getString("name"));
        this.ao.setFocusable(false);
        ((Button) viewInflate.findViewById(R.id.go_back)).setOnClickListener(new View.OnClickListener() { // from class: avn.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                avn.this.goBack();
            }
        });
        this.ao.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: avn.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ahf.a((Activity) avn.this.p());
                return false;
            }
        });
        this.ap.setOnItemClickListener(this.as);
        d();
        am();
        return viewInflate;
    }

    protected boolean al() {
        return false;
    }

    public void goBack() {
        this.ao.setText("");
        this.ak = null;
        this.aj = false;
        ahf.a((Activity) p());
    }

    public void am() {
        this.ao.setOnTouchListener(new View.OnTouchListener() { // from class: avn.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                avn.this.ao.setFocusable(true);
                avn.this.ao.setFocusableInTouchMode(true);
                return false;
            }
        });
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        Bundle bundleL = l();
        this.f = (bjl) bundleL.getSerializable("action");
        if (this.f != null) {
            this.al = bundleL.getString("id");
            bky.a(this.al, this.f, this.an, this.ah, 100);
            this.ap.setOnLoadMoreListener(new LoadMoreListView.a() { // from class: avn.7
                @Override // com.musicservice.dlna.customviews.LoadMoreListView.a
                public void a() {
                    if (avn.this.h >= avn.this.g) {
                        avn.this.ap.c();
                        return;
                    }
                    avn.this.ah = avn.this.h;
                    bky.a(avn.this.al, avn.this.f, avn.this.an, avn.this.ah, 100);
                }
            });
            this.ap.setFastScrollEnabled(true);
            this.ap.setIndexScrollerListener(this);
        }
    }

    @Override // defpackage.ajk
    public String av() {
        return l() != null ? l().getString("name") + "_" + super.av() : super.av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdapterView<?> adapterView, int i) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        ahf.a((Activity) p());
        if (itemAtPosition instanceof MusicData) {
            MusicData musicData = (MusicData) itemAtPosition;
            if (musicData.getObjectClass().startsWith("object.container")) {
                a(this.f, musicData.getContainerID(), musicData.getTitle(), null, false);
                return;
            }
            if (musicData.getObjectClass().startsWith("object.item.audioItem") && musicData.getDurations() != null && !musicData.getDurations().equalsIgnoreCase("null") && musicData.getDurations().length() != 0 && !musicData.getDurations().equalsIgnoreCase("")) {
                if (this.ak != null && a(this.e.a()) != null) {
                    this.c = null;
                    this.c = a(this.e.a());
                }
                if (!az()) {
                    a(adapterView, a(musicData));
                }
            }
        }
    }

    private int a(MusicData musicData) {
        int size = this.c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.c.get(i2) == musicData) {
                i = i2;
            }
        }
        return i;
    }

    @Override // defpackage.ajt
    public void a(View view) {
        if (((DashboardActivity) p()).n() != null) {
            ((DashboardActivity) p()).n().a(this, view, p());
        }
    }

    @Override // defpackage.ajt
    public void a(TextView textView) {
        if (p() != null) {
            ((DashboardActivity) p()).n().a(textView, this, -100);
        }
    }
}
