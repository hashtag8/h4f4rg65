package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.RippleTextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class akc extends aoj implements View.OnTouchListener {
    protected TextView a;
    private int af;
    private aey ag;
    protected TextView b;
    protected Context c;
    public RippleTextView d;
    ViewConfiguration e;
    private ListView f;
    private a g = null;
    private int h = -1;
    private float i = -1.0f;
    private int ae = 0;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.manage_room_selection_fragment, (ViewGroup) null);
        this.b = (TextView) viewInflate.findViewById(R.id.no_rooms_textview);
        this.f = (ListView) viewInflate.findViewById(R.id.manage_room_list);
        this.f.setEmptyView(this.b);
        this.a = (TextView) viewInflate.findViewById(R.id.message_text);
        this.c = p();
        this.e = ViewConfiguration.get(this.c);
        this.af = this.e.getScaledTouchSlop();
        this.g = new a(this.c);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setOnTouchListener(this);
        this.ag = new aez() { // from class: akc.1
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                akc.this.am();
            }
        };
        return viewInflate;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!an().q()) {
            return true;
        }
        int firstVisiblePosition = this.f.getFirstVisiblePosition();
        int iPointToPosition = this.f.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.i = motionEvent.getY();
                this.h = iPointToPosition;
                if (iPointToPosition == -1) {
                    this.d = null;
                    this.ae = -1;
                    return true;
                }
                this.d = (RippleTextView) this.f.getChildAt(iPointToPosition - firstVisiblePosition).findViewById(R.id.room_item_cell);
                this.ae = iPointToPosition;
                break;
                break;
            case 1:
                if (this.d != null) {
                    this.d.onTouchEvent(motionEvent);
                }
                if (iPointToPosition == -1 || this.h != iPointToPosition) {
                    return false;
                }
                adz adzVar = (adz) this.g.b.get(iPointToPosition);
                mm.b(" Room Details----- ", adzVar.k());
                RoomItem roomItemN = an().n();
                RoomItem roomItem = roomItemN == null ? new RoomItem() : roomItemN;
                roomItem.a(adzVar);
                roomItem.a(adzVar.k().get(0));
                an().a(roomItem);
                an().a(adzVar);
                an().n().a(adzVar.k());
                an().n().b(adzVar.h());
                mm.b("main device name = ", adzVar.h().x(), adzVar.h().z());
                an().a(aoi.ROOM_MANAGEMENT_ITEM, (Bundle) null);
                break;
            case 2:
                if (Math.abs(motionEvent.getY() - this.i) > this.af) {
                    if (this.d != null) {
                        this.d.onTouchEvent(motionEvent);
                    }
                    this.h = -1;
                }
                break;
        }
        return false;
    }

    @Override // defpackage.aoj
    public void b() {
        super.b();
        aof.a().c().a(this.ag);
        am();
    }

    @Override // defpackage.aoj
    protected void c() {
        super.c();
        aof.a().c().b(this.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        mo.a.a(new Runnable() { // from class: akc.2
            @Override // java.lang.Runnable
            public void run() {
                if (akc.this.g != null) {
                    akc.this.g.a();
                    akc.this.g.notifyDataSetChanged();
                }
            }
        });
    }

    class a extends BaseAdapter {
        private List<adz> b;
        private Context c;
        private LayoutInflater d;

        public a(Context context) {
            this.b = new ArrayList();
            this.c = context;
            this.b = aof.a().d();
            this.d = LayoutInflater.from(this.c);
        }

        public void a() {
            this.b = aof.a().d();
            mm.b("87550 Adapter Updating data=%s", this.b);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.b.isEmpty()) {
                akc.this.a.setVisibility(4);
            } else {
                akc.this.a.setVisibility(0);
            }
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
            b bVar;
            if (view == null) {
                bVar = akc.this.new b();
                view = this.d.inflate(R.layout.manage_room_selection_item, (ViewGroup) null);
                bVar.a = (ImageView) view.findViewById(R.id.room_item_cell_icon);
                bVar.b = (TextView) view.findViewById(R.id.room_item_cell_name);
                bVar.c = (TextView) view.findViewById(R.id.room_item_cell_type);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            adz adzVar = this.b.get(i);
            bVar.a.setImageResource(adzVar.m());
            int iQ = adzVar.q();
            bVar.a.setColorFilter(Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ)), PorterDuff.Mode.MULTIPLY);
            bVar.b.setText(adzVar.l());
            bVar.c.setText(adzVar.v());
            return view;
        }
    }

    class b {
        ImageView a;
        TextView b;
        TextView c;

        b() {
        }
    }
}
