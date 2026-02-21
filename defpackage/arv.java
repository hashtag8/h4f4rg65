package defpackage;

import android.content.Context;
import android.widget.SeekBar;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class arv extends arh {
    public arv(Context context, adz adzVar, boolean z) {
        super(context, null);
        aob.h().a(z ? arh.n : adzVar.s(), this);
        this.l = adzVar.s();
        b(adzVar);
    }

    @Override // defpackage.arh
    protected void b(adz adzVar) {
        if (adzVar != null) {
            this.i = ain.F;
            this.j = 47;
            this.c.setMax(this.j);
            this.c.setThumbOffset(ahn.a(this.g, 0.0f));
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            this.f.setText(adzVar.l());
            this.a = adzVar.t();
            this.c.setProgress(this.a);
            this.e.setText(this.a + "");
            setMuted(adzVar.r());
        }
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
}
