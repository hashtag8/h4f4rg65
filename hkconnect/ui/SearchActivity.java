package com.harman.hkconnect.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.fragment.SearchSongActivity;
import defpackage.afn;
import defpackage.afr;
import defpackage.afs;
import defpackage.ahf;
import defpackage.aqc;
import defpackage.aqq;
import defpackage.aqx;
import defpackage.asc;
import defpackage.mm;
import defpackage.mq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class SearchActivity extends aqc {
    private EditText A;
    private ProgressDialog C;
    private SearchView o;
    private ListView p;
    private BaseAdapter y = null;
    private List<afr> z = new ArrayList();
    private String B = null;
    AdapterView.OnItemClickListener m = new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.ui.SearchActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            afr afrVar = (afr) adapterView.getItemAtPosition(i);
            if (afrVar instanceof ArtistData) {
                Intent intent = new Intent(SearchActivity.this, (Class<?>) SearchSongActivity.class);
                intent.putExtra("CatalogData", (ArtistData) afrVar);
                SearchActivity.this.startActivity(intent);
            } else if (afrVar instanceof AlbumData) {
                Intent intent2 = new Intent(SearchActivity.this, (Class<?>) SearchSongActivity.class);
                intent2.putExtra("CatalogData", (AlbumData) afrVar);
                SearchActivity.this.startActivity(intent2);
            } else if (afrVar instanceof MusicData) {
                SearchActivity.this.a((MusicData) afrVar);
            } else {
                if (afrVar instanceof afs) {
                }
            }
        }
    };
    SearchView.OnQueryTextListener n = new SearchView.OnQueryTextListener() { // from class: com.harman.hkconnect.ui.SearchActivity.4
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(final String str) {
            if (!TextUtils.isEmpty(str)) {
                mm.b("onQueryTextSubmit  " + str, new Object[0]);
                SearchActivity.this.l();
                mq.b().execute(new Runnable() { // from class: com.harman.hkconnect.ui.SearchActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchActivity.this.z = aqq.a(SearchActivity.this, str);
                        SearchActivity.this.D.sendEmptyMessage(0);
                    }
                });
            }
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            mm.b("onQueryTextChange  " + str, new Object[0]);
            return false;
        }
    };
    private final a D = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_search);
        this.A = (EditText) findViewById(R.id.searchEditText);
        this.A.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.harman.hkconnect.ui.SearchActivity.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                SearchActivity.this.B = SearchActivity.this.A.getText().toString();
                if (TextUtils.isEmpty(SearchActivity.this.B)) {
                    return false;
                }
                mm.b("onQueryTextSubmit  " + SearchActivity.this.B, new Object[0]);
                SearchActivity.this.B = SearchActivity.this.B.replaceAll("'", "~^*@");
                mm.b("onQueryTextSubmit after " + SearchActivity.this.B, new Object[0]);
                SearchActivity.this.l();
                mq.b().execute(new Runnable() { // from class: com.harman.hkconnect.ui.SearchActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchActivity.this.z = afn.g().a(SearchActivity.this.B);
                        SearchActivity.this.D.sendEmptyMessage(0);
                    }
                });
                return true;
            }
        });
        this.o = (SearchView) findViewById(R.id.search);
        this.p = (ListView) findViewById(R.id.tracks_listview);
        this.p.setEmptyView(findViewById(R.id.tracks_empty));
        this.o.setOnQueryTextListener(this.n);
        this.p.setOnItemClickListener(this.m);
        new Timer().schedule(new TimerTask() { // from class: com.harman.hkconnect.ui.SearchActivity.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ahf.a((Context) SearchActivity.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MusicData musicData) {
        MusicPlaylistManager.a().a(musicData);
    }

    public void b(boolean z) {
        if (this.C == null && !isFinishing()) {
            this.C = new ProgressDialog(this);
            this.C.setCancelable(false);
            this.C.setMessage(getString(R.string.kAndroid_Loading));
        }
        if (!this.C.isShowing()) {
            new asc(this.C).a(null);
        }
    }

    public void l() {
        b(true);
    }

    static class a extends Handler {
        private final WeakReference<SearchActivity> a;

        public a(SearchActivity searchActivity) {
            this.a = new WeakReference<>(searchActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SearchActivity searchActivity = this.a.get();
            if (searchActivity != null) {
                searchActivity.y = new aqx(searchActivity, searchActivity.z);
                searchActivity.p.setAdapter((ListAdapter) searchActivity.y);
                ahf.a((Activity) searchActivity);
                searchActivity.m();
            }
        }
    }

    public void m() {
        if (this.C != null && this.C.isShowing()) {
            this.C.dismiss();
            this.C = null;
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    public void goBack(View view) {
        this.A.getText().toString();
    }

    @Override // defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        setResult(-1);
        finish();
    }
}
