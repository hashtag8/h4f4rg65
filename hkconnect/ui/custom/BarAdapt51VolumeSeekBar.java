package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.harman.hkconnect.R;
import defpackage.adx;
import defpackage.adz;
import defpackage.ahn;
import defpackage.ain;
import defpackage.aob;
import defpackage.aof;
import defpackage.arh;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BarAdapt51VolumeSeekBar extends arh {
    public BarAdapt51VolumeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarAdapt51VolumeSeekBar(Context context) {
        super(context, null);
    }

    public BarAdapt51VolumeSeekBar(Context context, List<adx> list) {
        super(context, null);
        aob.h().a(aof.a().b().d(), this);
        a(list);
        this.m = true;
    }

    private void a(List<adx> list) {
        if (list != null && !list.isEmpty()) {
            this.i = ain.F;
            this.j = 47;
            this.c.setMax(this.j);
            this.c.setThumbOffset(ahn.a(this.g, 0.0f));
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            a(list.get(0), list.get(0).R().getRole());
            this.f.setVisibility(8);
            this.a = list.get(0).B();
            this.c.setProgress(this.a);
            this.e.setText(this.a + "");
            setMuted(list.get(0).U() != 0);
            this.p = list;
        }
    }

    private String a(adx adxVar, int i) {
        adz adzVarA = aof.a().a(adxVar);
        if (adzVarA == null) {
            return "";
        }
        if (adzVarA.d() == 4) {
            if (i == 12345678) {
                return "Bar 5.1 Master";
            }
            if (i != 5 && i != 6) {
                return "";
            }
            return "Bar 5.1 Front Left & Front Right";
        }
        if (adzVarA.d() != 2) {
            return "";
        }
        if (i == 21) {
            return "Adapt 5.1 Master";
        }
        if (i == 1 || i == 2) {
            return "Adapt 5.1 Front Left & Front Right";
        }
        if (i == 3) {
            return "Adapt 5.1 Center";
        }
        if (i == 4) {
            return "Adapt 5.1 Subwoffer";
        }
        if (i != 5 && i != 6) {
            return "";
        }
        return "Adapt 5.1 Rear Left & Rear Right";
    }

    @Override // defpackage.arh
    protected void a(SeekBar seekBar, int i, boolean z) {
        this.a = i;
        this.o.sendEmptyMessage(ain.G);
    }

    @Override // defpackage.arh
    protected void b() {
        if (this.a == this.j) {
            this.e.setText(R.string.VolumeMax_Str);
        } else {
            this.e.setText(this.a + "");
        }
        this.c.setProgress(this.a);
    }

    @Override // defpackage.arh, aob.a
    public void a(adz adzVar) {
        if (adzVar != null) {
            for (adx adxVar : adzVar.k()) {
                if (a(adxVar.P())) {
                    setVolume(adxVar.B());
                    setMuted(adxVar.U() == 0);
                }
            }
        }
    }

    private boolean a(long j) {
        if (this.p == null || this.p.isEmpty()) {
            return false;
        }
        for (adx adxVar : this.p) {
            if (adxVar != null && adxVar.P() == j) {
                return true;
            }
        }
        return false;
    }
}
