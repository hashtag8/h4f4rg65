package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class arf extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
    Handler a;
    private final Context b;
    private adx c;
    private SeekBar d;
    private TextView e;
    private TextView f;
    private int g;
    private adz h;

    public arf(Context context, adx adxVar) {
        super(context);
        this.g = 0;
        this.a = new Handler() { // from class: arf.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                arf.this.a.sendEmptyMessageDelayed(1, 350L);
                Log.d("test", "i = " + arf.this.g);
                arf.this.a(arf.this.c, arf.this.g);
            }
        };
        this.b = context;
        a(adxVar);
    }

    private void a(adx adxVar) {
        if (adxVar != null) {
            this.c = adxVar;
            View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.base_volume_seekbar_layout, (ViewGroup) null);
            viewInflate.findViewById(R.id.settings_levels_layout);
            this.e = (TextView) viewInflate.findViewById(R.id.level_device_name);
            this.f = (TextView) viewInflate.findViewById(R.id.level_device_balance);
            this.d = (SeekBar) viewInflate.findViewById(R.id.levels_bar);
            this.d.setOnSeekBarChangeListener(this);
            this.d.setMax(12);
            this.e.setText(b(adxVar));
            if (this.h != null && this.h.d() == 1) {
                this.f.setText("R");
            } else {
                this.f.setText(String.valueOf(adxVar.D() - 6));
            }
            mm.b("deviceFc = " + adxVar, new Object[0]);
            this.d.setProgress(adxVar.D());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.height = (int) this.b.getResources().getDimension(R.dimen.balance_seekbar_height);
            addView(viewInflate, layoutParams);
        }
    }

    private String b(adx adxVar) {
        int role = adxVar.R().getRole();
        adz adzVarA = aof.a().a(adxVar);
        if (adzVarA == null) {
            return "";
        }
        this.h = adzVarA;
        if (adzVarA.d() == 4) {
            if (role == 12345678) {
                return "Sbar";
            }
            if (role == 4) {
                return "Sub";
            }
            if (role == 5) {
                return "Ls";
            }
            if (role != 6) {
                return "";
            }
            return "Rs";
        }
        if (adzVarA.d() == 2) {
            if (role == 21) {
                return "Adapt";
            }
            if (role == 1) {
                return "Front L";
            }
            if (role == 2) {
                return "Front R";
            }
            if (role == 3) {
                return "Center";
            }
            if (role == 4) {
                return "Sub";
            }
            if (role == 5) {
                return "Rear L";
            }
            if (role != 6) {
                return "";
            }
            return "Rear R";
        }
        if (adzVarA.d() != 1) {
            return "";
        }
        return "L";
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && this.d == seekBar) {
            this.g = i;
            if (this.h != null && this.h.d() == 1) {
                this.f.setText("R");
            } else {
                this.f.setText(String.valueOf(this.g - 6));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.a.sendEmptyMessage(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.removeMessages(1);
        this.g = seekBar.getProgress();
        Log.d("test", "progress = " + this.g);
        a(this.c, this.g);
        if (this.h != null && this.h.d() == 1) {
            this.f.setText("R");
        } else {
            this.f.setText(String.valueOf(this.g - 6));
        }
    }

    public void setMax(int i) {
        this.d.setMax(i);
    }

    public void setProgress(int i) {
        this.d.setProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(adx adxVar, int i) {
        if (adxVar != null) {
            mm.b("TEST_ROOM_SRTING", "value=" + i);
            adxVar.g((byte) i);
            mm.b("deviceFc = " + this.c, new Object[0]);
            adw.a().v(adxVar);
            mm.b("deviceFc = " + this.c, new Object[0]);
        }
    }
}
