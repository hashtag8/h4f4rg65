package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.ProductSetupMasterActivity;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.RippleImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aou extends aoj implements View.OnTouchListener {
    ViewConfiguration a;
    private View ae;
    private RoomItem af;
    private int ai;
    private GridView b;
    private Context f;
    private RippleImageView g;
    private int h;
    private int i;
    private List<RoomItem> c = null;
    private a d = null;
    private int e = 0;
    private int ag = -1;
    private float ah = -1.0f;

    @Override // defpackage.aoj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            am();
        }
        an().f(8);
    }

    public void am() {
        if (this.g != null && this.g.getVisibility() != 0) {
            this.g.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.ae = layoutInflater.inflate(R.layout.set_room_layout, (ViewGroup) null);
        this.f = p();
        at();
        this.a = ViewConfiguration.get(p());
        this.ai = this.a.getScaledTouchSlop();
        int color = this.f.getResources().getColor(R.color.unselected_room_item_color);
        this.h = Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
        int color2 = this.f.getResources().getColor(android.R.color.white);
        this.i = Color.rgb(Color.red(color2), Color.green(color2), Color.blue(color2));
        return this.ae;
    }

    private void at() {
        this.b = (GridView) this.ae.findViewById(R.id.grid_view);
        if (ahn.a()) {
            this.b.getLayoutParams().width = aff.r;
        }
        this.d = new a(this.f);
        ax();
    }

    private void ax() {
        this.c = new ArrayList();
        for (int i = 1; i < ain.v.length; i++) {
            RoomItem roomItem = new RoomItem();
            roomItem.a(ahk.a());
            roomItem.a(this.f.getString(ain.v[i]));
            roomItem.b(roomItem.h());
            roomItem.b(ain.s[i]);
            roomItem.d(false);
            roomItem.d(ain.u[i]);
            roomItem.e(i);
            this.c.add(roomItem);
        }
        this.d.a(this.c);
        this.b.setAdapter((ListAdapter) this.d);
        this.b.setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!an().q()) {
            return true;
        }
        int firstVisiblePosition = this.b.getFirstVisiblePosition();
        int iPointToPosition = this.b.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.ah = motionEvent.getY();
                this.ag = iPointToPosition;
                if (this.g != null) {
                    this.g.setVisibility(0);
                }
                if (iPointToPosition == -1) {
                    this.g = null;
                    this.e = -1;
                } else {
                    this.g = (RippleImageView) this.b.getChildAt(iPointToPosition - firstVisiblePosition).findViewById(R.id.room_item_icon);
                    for (int i = 0; i < this.c.size(); i++) {
                        this.c.get(i).d(false);
                    }
                    this.c.get(iPointToPosition).d(true);
                    this.d.a(this.c);
                    this.d.notifyDataSetChanged();
                    this.e = iPointToPosition;
                }
                break;
            case 1:
                if (this.g != null) {
                    this.g.onTouchEvent(motionEvent);
                }
                if (iPointToPosition != -1 && this.ag == iPointToPosition) {
                    this.af = this.c.get(iPointToPosition);
                    ImageView imageView = new ImageView(this.f);
                    imageView.setBackgroundColor(0);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setImageResource(this.af.k());
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.g.getWidth(), this.g.getWidth());
                    int[] iArr = new int[2];
                    this.g.getLocationInWindow(iArr);
                    layoutParams.leftMargin = iArr[0];
                    layoutParams.topMargin = iArr[1] - ahn.c(this.f);
                    an().a(imageView, layoutParams);
                    final RippleImageView rippleImageView = this.g;
                    new Handler().postDelayed(new Runnable() { // from class: aou.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aou.this.g == rippleImageView) {
                                rippleImageView.setVisibility(4);
                            }
                        }
                    }, ProductSetupMasterActivity.n);
                    if (an().n() != null) {
                        this.af.a(an().n().b());
                        this.af.b(an().n().n());
                        mm.b("Edit Room:: ", an().n().v());
                        this.af.a(an().n().v());
                    }
                    an().a(this.af);
                    an().a(aoi.CHOOSE_ROOM_COLOR, (Bundle) null);
                    break;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getY() - this.ah) > this.ai) {
                    if (this.g != null) {
                        this.g.onTouchEvent(motionEvent);
                    }
                    this.ag = -1;
                }
                break;
        }
        return true;
    }

    class a extends BaseAdapter {
        private List<RoomItem> b = new ArrayList();
        private Context c;
        private LayoutInflater d;

        public a(Context context) {
            this.c = context;
            this.d = LayoutInflater.from(this.c);
        }

        public void a(List<RoomItem> list) {
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
            b bVar;
            if (view == null) {
                b bVar2 = aou.this.new b();
                view = this.d.inflate(R.layout.set_room_item, (ViewGroup) null);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a = (RippleImageView) view.findViewById(R.id.room_item_icon);
            bVar.b = (TextView) view.findViewById(R.id.room_item_name);
            bVar.a.a();
            RoomItem roomItem = this.b.get(i);
            bVar.a.setImageResource(roomItem.k());
            bVar.b.setText(roomItem.h());
            if (roomItem.g()) {
                bVar.a.setColorFilter(aou.this.i, PorterDuff.Mode.MULTIPLY);
            } else {
                bVar.a.setColorFilter(aou.this.h, PorterDuff.Mode.MULTIPLY);
            }
            return view;
        }
    }

    class b {
        RippleImageView a;
        TextView b;

        b() {
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        an().c(a(R.string.kSetupNewRoom_Navigation_Str1));
        an().g(17);
        an().l();
        if (this.af != null) {
            this.af.a(this.af.i());
        }
    }
}
