package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alz extends BaseAdapter {
    private List<akj> a;
    private List<akj> b;
    private LayoutInflater c;
    private Context d;
    private View.OnClickListener e;

    public static class a {
        public TextView a;
        public TextView b;
        public ImageView c;
        public ImageView d;
    }

    public alz(List<akj> list, List<akj> list2, Context context, View.OnClickListener onClickListener) {
        this.a = list;
        this.b = list2;
        this.c = LayoutInflater.from(context);
        this.d = context;
        this.e = onClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (i == 0 || i == 2 || i == this.a.size() + 2) {
            View viewInflate = this.c.inflate(R.layout.deezer_playlist_item_seperate, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.playlist_tv)).setText((String) getItem(i));
            return viewInflate;
        }
        if ((i >= this.a.size() + 2 || i < 3) && i <= this.a.size() + 1 && i != 1) {
            return null;
        }
        if (view == null || view.getTag() == null) {
            view = this.c.inflate(R.layout.deezer_playlist_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.text1);
            aVar.b = (TextView) view.findViewById(R.id.text2);
            aVar.c = (ImageView) view.findViewById(R.id.iv);
            aVar.d = (ImageView) view.findViewById(R.id.img2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        akj akjVar = (akj) getItem(i);
        aVar.a.setText(akjVar.f());
        if (i == 1) {
            aVar.b.setVisibility(8);
        } else {
            aVar.b.setText(akjVar.c() + " " + this.d.getResources().getString(R.string.kDeezer_tracks_Str));
        }
        new ahw().a(aVar.c, akjVar.d());
        aVar.d.setVisibility(0);
        aVar.d.setOnClickListener(this.e);
        aVar.d.setTag(akjVar);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size() + 2 + 1 + this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i == 0) {
            return this.d.getString(R.string.kDeezer_Favorite_tracks_LovedTracks_Str);
        }
        if (i == 1) {
            return this.a.get(i - 1);
        }
        if (i == 2) {
            return this.d.getString(R.string.kDeezer_My_Playlists_Str);
        }
        if (i <= this.a.size() + 1 && i >= 3) {
            return this.a.get(i - 2);
        }
        if (i == this.a.size() + 2) {
            return this.d.getString(R.string.kDeezer_Friends_Playlists_Str);
        }
        if (i > this.a.size() + 2) {
            return this.b.get(((i - 2) - this.a.size()) - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
