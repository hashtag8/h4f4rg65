package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aob;
import java.util.List;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public abstract class arh extends LinearLayout implements SeekBar.OnSeekBarChangeListener, aob.a {
    public static int n = -1;
    protected int a;
    protected ImageView b;
    protected SeekBar c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    protected Context g;
    protected Timer h;
    protected int i;
    protected int j;
    protected LinearLayout k;
    protected int l;
    public boolean m;
    protected Handler o;
    public List<adx> p;
    private boolean q;
    private int r;
    private boolean s;
    private long t;

    protected abstract void a(SeekBar seekBar, int i, boolean z);

    protected abstract void b();

    @Override // aob.a
    public void a(adz adzVar) {
        if (adzVar != null && adzVar.s() == this.l) {
            setVolume(adzVar.t());
            setMuted(adzVar.r());
        }
    }

    protected void a() {
    }

    protected void b(adz adzVar) {
    }

    public int getVolumeMax() {
        return this.j;
    }

    public void setVolumeIcon(int i) {
        this.b.setImageResource(i);
    }

    public arh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.i = ain.F;
        this.q = false;
        this.l = -1;
        this.m = false;
        this.o = new Handler() { // from class: arh.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == ain.G) {
                    arh.this.b();
                }
            }
        };
        this.t = 0L;
        this.g = context;
        a(attributeSet);
    }

    public arh(Context context) {
        this(context, null);
    }

    public void setMuted(final boolean z) {
        mm.b();
        System.out.println("======setMuted muted = " + z);
        mo.a.a(new Runnable() { // from class: arh.2
            @Override // java.lang.Runnable
            public void run() {
                arh.this.q = z;
                if (z || arh.this.a <= 0) {
                    arh.this.q = true;
                    arh.this.b.setAlpha(0.5f);
                    arh.this.b.setColorFilter(arh.this.r);
                    arh.this.b.setImageResource(R.drawable.volume_mute_icon);
                    return;
                }
                arh.this.q = false;
                arh.this.b.setAlpha(1.0f);
                arh.this.b.setColorFilter(arh.this.r);
                arh.this.b.setImageResource(R.drawable.volume_no_mute_icon);
            }
        });
    }

    private void a(AttributeSet attributeSet) {
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.base_seekbar_layout, (ViewGroup) null);
        this.b = (ImageView) viewInflate.findViewById(R.id.volume_popup_icon);
        this.r = getResources().getColor(R.color.cool_gray);
        this.b.setColorFilter(this.r);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: arh.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - arh.this.t >= 500) {
                    arh.this.t = SystemClock.elapsedRealtime();
                    arh.this.q = !arh.this.q;
                    arh.this.s = arh.this.q;
                    arh.this.setMuted(arh.this.q);
                    aob.h().b(arh.this.l, arh.this.q);
                }
            }
        });
        this.f = (TextView) viewInflate.findViewById(R.id.seekbar_room_name);
        this.c = (SeekBar) viewInflate.findViewById(R.id.volume_popup_seekbar);
        this.d = (TextView) viewInflate.findViewById(R.id.volume_popup_name);
        this.e = (TextView) viewInflate.findViewById(R.id.volume_popup_value);
        this.k = (LinearLayout) viewInflate.findViewById(R.id.view_volume_layout);
        this.c.setOnSeekBarChangeListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.height = (int) this.g.getResources().getDimension(R.dimen.volume_item_height_size);
        addView(viewInflate, layoutParams);
    }

    public void setVolume(int i) {
        if (i <= this.j && i >= 0) {
            this.a = i;
            this.o.sendEmptyMessage(ain.G);
        }
    }

    public void setNameVisible(int i) {
        this.f.setVisibility(i);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && ain.E) {
            this.q = i <= 0;
            if (this.q != this.s) {
                this.s = this.q;
                if (this.q) {
                    this.b.setAlpha(0.5f);
                    this.b.setColorFilter(this.r);
                    this.b.setImageResource(R.drawable.volume_mute_icon);
                } else {
                    this.b.setAlpha(1.0f);
                    this.b.setColorFilter(this.r);
                    this.b.setImageResource(R.drawable.volume_no_mute_icon);
                }
            }
            a(seekBar, i, z);
            aob.h().a(this.l, i);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        ain.E = true;
        aob.h().c();
        mm.b("volume setting test", "set volume for master device ==== StartTracking ", Integer.valueOf(c()));
    }

    private int c() {
        return (int) Math.round((((double) this.a) / 47.0d) * 100.0d);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        mm.b("volume setting test", "set volume for master device ==== StopTracking ", Integer.valueOf(c()));
        this.s = seekBar.getProgress() <= 0;
        mq.b().a(new Runnable() { // from class: arh.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ain.E = false;
            }
        });
    }

    public int getVolume() {
        return this.a;
    }
}
