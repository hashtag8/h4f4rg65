package com.harman.hkconnect.fragment;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import defpackage.afh;
import defpackage.ahu;
import defpackage.ahw;
import defpackage.aih;
import defpackage.aqq;
import defpackage.arz;
import defpackage.asi;
import defpackage.bif;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchSongActivity extends Activity implements View.OnClickListener {
    private ListView b;
    private List<MusicData> c;
    private TextView h;
    private ImageView i;
    private aih<MusicData> d = null;
    private CatalogDataInf e = null;
    private int f = 0;
    private final int g = 100;
    AdapterView.OnItemClickListener a = new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.fragment.SearchSongActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchSongActivity.this.a((MusicData) SearchSongActivity.this.b.getAdapter().getItem(i));
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.search_song_layout);
        b();
        a();
    }

    private void a() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("CatalogData");
        if (parcelableExtra instanceof CatalogDataInf) {
            this.e = (CatalogDataInf) parcelableExtra;
            a(this.e);
            this.h.setText(this.e.j);
        }
    }

    private void b() {
        this.b = (ListView) findViewById(R.id.listview);
        this.h = (TextView) findViewById(R.id.title);
        this.i = (ImageView) findViewById(R.id.back);
        this.i.setOnClickListener(this);
        this.d = new aih<>(this, new a(), 100, R.layout.dashboard_listview_item, R.layout.harman_list_loading);
        this.b.setAdapter((ListAdapter) this.d);
        this.b.setOnItemClickListener(this.a);
    }

    private void a(CatalogDataInf catalogDataInf) {
        this.f = 0;
        this.e = catalogDataInf;
        setTitle(catalogDataInf.j);
        this.c = aqq.a(this, catalogDataInf, this.f);
        this.d.a(this.c);
        this.d.notifyDataSetChanged();
    }

    class a implements aih.a<MusicData>, View.OnClickListener {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, MusicData musicData) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                b bVar2 = SearchSongActivity.this.new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.song);
                bVar2.c = (TextView) view.findViewById(R.id.album);
                bVar2.b.setTypeface(ahu.a(SearchSongActivity.this));
                bVar2.c.setTypeface(ahu.a(SearchSongActivity.this));
                bVar2.d = (ImageView) view.findViewById(R.id.iv_more);
                view.setTag(bVar2);
                bVar = bVar2;
            }
            bVar.b.setText(musicData.musicName);
            bVar.d.setOnClickListener(this);
            bVar.d.setTag(musicData);
            if (musicData.songId == -1000) {
                bVar.c.setVisibility(8);
                bVar.a.setImageResource(R.drawable.empty_cover_art_small);
            } else {
                bVar.c.setVisibility(0);
                bVar.c.setText(musicData.artist + " - " + musicData.album);
                bVar.a.setTag(musicData.getBitmapUrl());
                new ahw().a(bVar.a, bif.a((Context) SearchSongActivity.this).a(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), musicData.songId)).a(afh.a(musicData.genre, 1)));
                bVar.d.setImageResource(R.drawable.playlist_more);
            }
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final MusicData musicData = (MusicData) view.getTag();
            if (-1000 == musicData.songId) {
                arz arzVar = new arz(SearchSongActivity.this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(SearchSongActivity.this.getString(R.string.PlayTip_PlayNow_Str));
                arrayList.add(SearchSongActivity.this.getString(R.string.PlayTip_PlayNext_Str));
                arrayList.add(SearchSongActivity.this.getString(R.string.PlayTip_AddSongToQueue_Str));
                arrayList.add(SearchSongActivity.this.getString(R.string.PlayTip_ClearAll_Str));
                arzVar.a(arrayList);
                arzVar.a(SearchSongActivity.this.getString(R.string.PlayTip_Title_Str));
                arzVar.a(new asi() { // from class: com.harman.hkconnect.fragment.SearchSongActivity.a.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                SearchSongActivity.this.a((List<MusicData>) SearchSongActivity.this.c);
                                break;
                            case 1:
                                SearchSongActivity.this.b((List<MusicData>) SearchSongActivity.this.c);
                                break;
                            case 2:
                                SearchSongActivity.this.c((List<MusicData>) SearchSongActivity.this.c);
                                break;
                            case 3:
                                SearchSongActivity.this.d((List<MusicData>) SearchSongActivity.this.c);
                                break;
                        }
                    }
                });
                arzVar.show();
                return;
            }
            arz arzVar2 = new arz(SearchSongActivity.this);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(SearchSongActivity.this.getString(R.string.PlayTip_PlayNow_Str));
            arrayList2.add(SearchSongActivity.this.getString(R.string.PlayTip_PlayNext_Str));
            arrayList2.add(SearchSongActivity.this.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList2.add(SearchSongActivity.this.getString(R.string.PlayTip_ClearAll_Str));
            arzVar2.a(arrayList2);
            arzVar2.a(SearchSongActivity.this.getString(R.string.PlayTip_Title_Str));
            arzVar2.a(new asi() { // from class: com.harman.hkconnect.fragment.SearchSongActivity.a.2
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                            SearchSongActivity.this.a(musicData);
                            break;
                        case 1:
                            SearchSongActivity.this.b(musicData);
                            break;
                        case 2:
                            SearchSongActivity.this.c(musicData);
                            break;
                        case 3:
                            SearchSongActivity.this.d(musicData);
                            break;
                    }
                }
            });
            arzVar2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MusicData> list) {
        MusicPlaylistManager.a().e(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<MusicData> list) {
        MusicPlaylistManager.a().c(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<MusicData> list) {
        MusicPlaylistManager.a().d(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<MusicData> list) {
        MusicPlaylistManager.a().g();
        MusicPlaylistManager.a().b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MusicData musicData) {
        MusicPlaylistManager.a().a(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MusicData musicData) {
        MusicPlaylistManager.a().c(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MusicData musicData) {
        MusicPlaylistManager.a().d(musicData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MusicData musicData) {
        MusicPlaylistManager.a().g();
        MusicPlaylistManager.a().b(musicData);
    }

    class b {
        public ImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
        }
    }
}
