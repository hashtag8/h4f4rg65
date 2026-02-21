package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.harman.hkconnect.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aru extends arh {
    int q;

    public aru(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            this.q = adyVarB.d();
        }
        this.l = -1;
        a();
    }

    public aru(Context context) {
        this(context, null);
    }

    public void setBackingGroup(ady adyVar) {
        if (adyVar != null) {
            this.q = adyVar.d();
            mm.e("TotalVolumeSeekBar Total VolumeSeekbar :::: ", this);
            aob.h().a(this.q, this);
            aob.h().a(adyVar);
            a((adz) null);
        }
    }

    @Override // defpackage.arh, aob.a
    public void a(adz adzVar) {
        if (this.h == null) {
            ady adyVarB = this.q > 0 ? aof.a().b(this.q) : aof.a().b();
            mm.b("Notify Volume change for Group:: %s %d", adyVarB, Integer.valueOf(this.q));
            if (adyVarB != null && adyVarB.d() == this.q) {
                List<adz> listF = adyVarB.f();
                boolean z = true;
                int iT = 0;
                for (adz adzVar2 : listF) {
                    iT += adzVar2.t();
                    z = z && c(adzVar2);
                }
                this.a = iT / listF.size();
                setMuted(z);
                b();
            }
        }
    }

    private boolean c(adz adzVar) {
        if (adzVar == null) {
            mm.e("room is null", new Object[0]);
        }
        if (adzVar.d() == 2 || adzVar.d() == 4) {
            Iterator<adx> it = adzVar.k().iterator();
            while (it.hasNext()) {
                if (it.next().U() == 1) {
                    return true;
                }
            }
            return false;
        }
        return adzVar.r();
    }

    @Override // defpackage.arh
    protected void a() {
        this.i = ain.F;
        this.j = 47;
        this.c.setMax(this.j);
        this.c.setThumbOffset(ahn.a(this.g, 0.0f));
        this.d.setVisibility(8);
        this.f.setText(this.g.getResources().getString(R.string.VolumePopupMasterVolume_Str));
        a((adz) null);
    }

    @Override // defpackage.arh
    protected void a(SeekBar seekBar, int i, boolean z) {
        this.a = i;
        b();
    }

    @Override // defpackage.arh
    protected void b() {
        if (this.a == this.j) {
            this.e.setText(R.string.VolumeMax_Str);
        } else {
            this.e.setText(this.a + "");
        }
        this.c.setProgress(this.a);
        mm.b("Setting volume of " + this + " to " + this.a, new Object[0]);
    }
}
