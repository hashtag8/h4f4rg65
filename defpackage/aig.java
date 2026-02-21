package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.PlayList;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.nokia.NokiaMusicData;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class aig extends BaseAdapter {
    private Context a;
    private PlayList b;
    private LayoutInflater c;
    private HashMap<String, SoftReference<Bitmap>> d = new HashMap<>();
    private int e;

    public static class a {
        public ImageView a;
        public ImageView b;
        public TextView c;
        public TextView d;
        public RelativeLayout e;
        public LinearLayout f;
        public LinearLayout g;
    }

    public aig(Context context, PlayList playList, int i) {
        this.a = context;
        this.b = playList;
        this.c = LayoutInflater.from(this.a);
        this.e = i;
        playList.a(new PlayList.a() { // from class: aig.1
            @Override // com.harman.commom.music.player.service.PlayList.a
            public void a() {
                aig.this.notifyDataSetChanged();
            }
        });
    }

    public void a(int i) {
        this.e = i;
        notifyDataSetChanged();
    }

    public void a(PlayList playList) {
        this.b = playList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        MusicData musicDataB;
        Bitmap bitmap;
        if (view == null) {
            view = this.c.inflate(R.layout.music_queue_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.e = (RelativeLayout) view.findViewById(R.id.queue_item);
            aVar2.a = (ImageView) view.findViewById(R.id.music_queue_item_image);
            aVar2.b = (ImageView) view.findViewById(R.id.music_queue_item_image_status);
            aVar2.f = (LinearLayout) view.findViewById(R.id.queue_item_text_container);
            aVar2.g = (LinearLayout) view.findViewById(R.id.queue_image_and_text);
            aVar2.c = (TextView) view.findViewById(R.id.music_queue_music_name);
            aVar2.d = (TextView) view.findViewById(R.id.music_queue_music_alb_art);
            aVar2.c.setTypeface(ahu.a(this.a));
            aVar2.d.setTypeface(ahu.a(this.a));
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ((TextView) aVar.g.findViewById(R.id.music_queue_music_name)).setMaxWidth(this.e);
        ((TextView) aVar.g.findViewById(R.id.music_queue_music_alb_art)).setMaxWidth(this.e);
        ((TextView) aVar.g.findViewById(R.id.music_queue_music_name)).setWidth(this.e);
        ((TextView) aVar.g.findViewById(R.id.music_queue_music_alb_art)).setWidth(this.e);
        if (this.b != null && !this.b.d() && i < this.b.a() && (musicDataB = this.b.b(i)) != null) {
            aVar.c.setText(musicDataB.musicName);
            aVar.d.setText(musicDataB.artist + " - " + musicDataB.album);
            aVar.a.setTag(musicDataB.getBitmapUrl());
            if ((!TextUtils.isEmpty(musicDataB.album_art) && musicDataB.album_art.toLowerCase().contains(HttpHost.DEFAULT_SCHEME_NAME)) || (musicDataB instanceof NokiaMusicData)) {
                new ahw().a(aVar.a, musicDataB.album_art);
            } else if (this.d.containsKey(musicDataB.getBitmapUrl()) && (bitmap = this.d.get(musicDataB.getBitmapUrl()).get()) != null) {
                aVar.a.setImageBitmap(bitmap);
            } else {
                new ahw().a(aVar.a, musicDataB.album_id, R.drawable.empty_cover_art_small, ahw.a);
            }
            if (musicDataB.type != 1 && aof.a().l()) {
                view.setAlpha(0.5f);
                view.setOnClickListener(new View.OnClickListener() { // from class: aig.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                    }
                });
            } else {
                view.setAlpha(1.0f);
            }
        }
        if (MusicPlaylistManager.a().u() == i) {
            mm.b("MusicQueueAdapter", "currentpos=" + MusicPlaylistManager.a().u() + ",position=" + i);
            aVar.e.setBackgroundColor(1308622847);
            aVar.b.setVisibility(0);
            aVar.c.setTextAppearance(this.a, R.style.font_white_18);
            aVar.d.setTextAppearance(this.a, R.style.font_white_14);
            if (MusicPlaylistManager.a().v()) {
                aVar.b.setImageResource(R.drawable.white_pause_icon);
            } else {
                aVar.b.setImageResource(R.drawable.white_play_icon);
            }
            if (!aof.a().n()) {
                aVar.b.setImageResource(R.drawable.white_play_icon);
            }
        } else {
            aVar.c.setTextAppearance(this.a, R.style.font_white_18_alpha70);
            aVar.d.setTextAppearance(this.a, R.style.font_white_14_alpha70);
            aVar.e.setBackgroundColor(this.a.getResources().getColor(R.color.transparent));
            aVar.b.setVisibility(4);
        }
        view.scrollTo(0, 0);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.a();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MusicData getItem(int i) {
        return this.b.b(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
