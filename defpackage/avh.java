package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avh extends BaseAdapter implements Filterable {
    private Context d;
    private MusicData e;
    private TextView h;
    private avn i;
    protected HashMap<String, Integer> a = new HashMap<>();
    private List<MusicData> b = new ArrayList();
    private List<bjp> c = new ArrayList();
    private List<MusicData> f = new ArrayList();
    private String[] g = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private List<MusicData> j = new ArrayList();

    public avh(List<bjp> list, Context context, List<MusicData> list2, TextView textView, avn avnVar) {
        this.i = avnVar;
        this.h = textView;
        this.c.addAll(list);
        this.f.addAll(list2);
        this.b.addAll(list2);
        this.d = context;
        this.e = new MusicData();
        this.e.type = 9;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        return this.f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f == null) {
            return null;
        }
        return this.f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.d);
        if (view == null) {
            aVar = new a();
            view = layoutInflaterFrom.inflate(R.layout.browsw_server_item, (ViewGroup) null);
            aVar.b = (TextView) view.findViewById(R.id.folder_title);
            aVar.c = (TextView) view.findViewById(R.id.extrainfo);
            aVar.a = (ImageView) view.findViewById(R.id.folder_icon);
            aVar.d = (ImageView) view.findViewById(R.id.imageView_moreId);
            int color = Color.parseColor("#000000");
            aVar.d.setColorFilter(Color.rgb(Color.red(color), Color.green(color), Color.blue(color)), PorterDuff.Mode.MULTIPLY);
            aVar.e = view.findViewById(R.id.leftViewId);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(this.f.get(i), i, aVar);
        return view;
    }

    private void a(MusicData musicData, int i, a aVar) {
        if (musicData.getObjectClass().startsWith("object.container")) {
            aVar.d.setVisibility(8);
            aVar.a.setImageResource(R.drawable.folder_icon);
        } else if (musicData.getObjectClass().startsWith("object.item.audioItem")) {
            aVar.d.setVisibility(0);
            aVar.a.setImageResource(R.drawable.song_icon);
        } else if ((musicData.path == null || !musicData.path.contains(".jpg")) && musicData.path == null) {
            aVar.d.setVisibility(8);
        } else {
            aVar.d.setVisibility(8);
        }
        aVar.d.setTag(musicData);
        aVar.d.setOnClickListener(new aqr(this.d) { // from class: avh.1
            @Override // defpackage.aqr
            protected void a() {
            }

            @Override // defpackage.aqr
            protected void a(int i2) {
            }
        });
        aVar.b.setText(musicData.getTitle());
        if (musicData.getIconUrl() != "") {
            bif.a(this.d).a(musicData.getIconUrl()).a(R.drawable.song_icon).a(aVar.a);
        }
        if (musicData.getChildCount() != null && musicData.getChildCount() != "-1" && musicData.getChildCount().trim().length() > 0 && musicData.getChildCount().trim() != "") {
            aVar.c.setVisibility(0);
            aVar.c.setText(musicData.getChildCount() + " files");
        } else if (musicData.getArtist() != null && musicData.getArtist().trim() != "" && musicData.getArtist().trim().length() > 0) {
            aVar.c.setVisibility(0);
            aVar.c.setText(musicData.getArtist());
        } else {
            aVar.c.setVisibility(8);
            aVar.c.setText("");
        }
    }

    public void a(List<bjp> list, List<MusicData> list2, boolean z) {
        if (this.c == null) {
            this.c = list;
        } else {
            if (z) {
                this.c.clear();
            }
            this.c.addAll(list);
        }
        if (list2 == null) {
            this.f = list2;
        } else {
            if (z) {
                this.f.clear();
                this.b.clear();
            }
            this.f.addAll(list2);
            this.b.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public List<MusicData> a() {
        return this.j;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: avh.2
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence != null) {
                    if (avh.this.b != null && avh.this.b.size() > 0) {
                        for (MusicData musicData : avh.this.b) {
                            if (musicData.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                arrayList.add(musicData);
                            }
                        }
                    }
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ArrayList arrayList = (ArrayList) filterResults.values;
                if (arrayList != null && arrayList.size() >= 0) {
                    avh.this.j = arrayList;
                    avh.this.f.clear();
                    avh.this.f.addAll(arrayList);
                    if (avh.this.f.size() == 0) {
                        avh.this.h.setVisibility(0);
                    } else {
                        avh.this.h.setVisibility(8);
                    }
                }
                avh.this.notifyDataSetChanged();
            }
        };
    }

    static class a {
        ImageView a;
        TextView b;
        TextView c;
        ImageView d;
        View e;

        a() {
        }
    }
}
