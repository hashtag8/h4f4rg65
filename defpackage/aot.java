package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.custom.ClearEditText;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aot extends aoj implements AdapterView.OnItemClickListener {
    private TextView a;
    private GridView b;
    private Context c;
    private List<Integer> d = null;
    private a e = null;
    private int f = -1;
    private ImageView g;
    private ClearEditText h;
    private View i;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.i = layoutInflater.inflate(R.layout.set_color_layout, (ViewGroup) null);
        this.c = p();
        ax();
        return this.i;
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().c(a(R.string.kSetupNewRoom_Navigation_SelectRoomColor_Str));
        an().b(a(R.string.Next_Str));
        this.g.setColorFilter(this.h.getCurrentTextColor());
    }

    private void at() {
        RoomItem roomItemN = an().n();
        if (roomItemN != null) {
            this.g.setImageResource(an().n().k());
            this.h.setText(roomItemN.h());
            if (ar() == aoi.ROOM_MANAGEMENT && an().m() != null) {
                an().b(a(R.string.Done_Str));
            }
            am();
        }
    }

    public void am() {
        this.g.setVisibility(4);
        int iP = an().p();
        this.g.setColorFilter(Color.rgb(Color.red(iP), Color.green(iP), Color.blue(iP)), PorterDuff.Mode.MULTIPLY);
        this.h.setTextColor(-1);
        this.f = -1;
        this.e.notifyDataSetChanged();
    }

    private void ax() {
        this.a = (TextView) this.i.findViewById(R.id.message);
        this.a.setText(a(R.string.kSetupNewRoom_selectColor_Str1));
        this.g = (ImageView) this.i.findViewById(R.id.room_icon);
        this.g.setVisibility(4);
        an().a(this.g);
        this.h = (ClearEditText) this.i.findViewById(R.id.room_name);
        ake akeVar = new ake(an(), false);
        this.h.setOnEditorActionListener(akeVar);
        this.h.setOnFocusChangeListener(akeVar);
        this.b = (GridView) this.i.findViewById(R.id.grid_view);
        this.e = new a(this.c);
        ay();
        at();
    }

    private void ay() {
        this.d = new ArrayList();
        for (int i = 1; i < ain.y.length; i++) {
            this.d.add(Integer.valueOf(ain.y[i]));
        }
        this.e.a(this.d);
        this.b.setAdapter((ListAdapter) this.e);
        this.b.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != this.f) {
            int i2 = this.f;
            this.f = i;
            int iIntValue = this.d.get(i).intValue();
            an().e(iIntValue);
            if (i2 == -1) {
                arl.a(this.g, -1, iIntValue);
                arl.a(this.h, -1, iIntValue);
            } else {
                arl.a(this.g, this.d.get(i2).intValue(), iIntValue);
                arl.a(this.h, this.d.get(i2).intValue(), iIntValue);
            }
            this.e.notifyDataSetChanged();
            a(true);
            an().c(true);
        }
    }

    @Override // defpackage.aoj
    public void e() {
        RoomItem roomItemN = an().n();
        roomItemN.c(this.f + 1);
        if (ar() == aoi.ROOM_MANAGEMENT && an().m() != null) {
            ady adyVarO = aof.a().o();
            if (adyVarO != null && adyVarO.f().contains(an().m())) {
                mm.b("stop playback", new Object[0]);
                HarmanApplication.a().sendBroadcast(new Intent("EditRoomPauseUi"));
            }
            ain.p = 0;
            roomItemN.a(an().m().d());
            roomItemN.a(an().m().k());
            roomItemN.a(an().m().h().P());
            roomItemN.y();
            aof.a().p();
            an().e(-1);
            an().a(as(), aoi.ROOM_MANAGEMENT_ITEM, false);
            return;
        }
        an().a(aoi.CHOOSE_CHANNEL_TYPE, (Bundle) null);
    }

    class a extends BaseAdapter {
        private List<Integer> b = new ArrayList();
        private Context c;
        private LayoutInflater d;

        public a(Context context) {
            this.c = context;
            this.d = LayoutInflater.from(this.c);
        }

        public void a(List<Integer> list) {
            this.b.clear();
            this.b.addAll(list);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0040a c0040a;
            if (view == null) {
                view = this.d.inflate(R.layout.set_color_item, (ViewGroup) null);
                C0040a c0040a2 = new C0040a();
                c0040a2.a = (ImageView) view.findViewById(R.id.room_item_icon_alpha);
                c0040a2.b = (ImageView) view.findViewById(R.id.room_item_icon);
                c0040a2.c = (ImageView) view.findViewById(R.id.check_mark);
                view.setTag(c0040a2);
                c0040a = c0040a2;
            } else {
                c0040a = (C0040a) view.getTag();
            }
            Integer num = this.b.get(i);
            int iRgb = Color.rgb(Color.red(num.intValue()), Color.green(num.intValue()), Color.blue(num.intValue()));
            c0040a.b.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
            c0040a.a.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
            c0040a.c.setColorFilter(Color.rgb(Color.red(-1), Color.green(-1), Color.blue(-1)));
            if (aot.this.f == i) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setFillAfter(true);
                c0040a.b.startAnimation(scaleAnimation);
                c0040a.c.setVisibility(0);
            } else {
                c0040a.b.clearAnimation();
                c0040a.c.setVisibility(8);
            }
            return view;
        }

        /* JADX INFO: renamed from: aot$a$a, reason: collision with other inner class name */
        public class C0040a {
            public ImageView a;
            public ImageView b;
            public ImageView c;

            public C0040a() {
            }
        }
    }
}
