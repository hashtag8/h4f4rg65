package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.harman.hkconnect.R;
import defpackage.ahn;
import defpackage.aru;

/* JADX INFO: loaded from: classes.dex */
public class AppPlayerTotalVolumeSeekbar extends aru {
    public AppPlayerTotalVolumeSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AppPlayerTotalVolumeSeekbar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.c.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_drawable_volume));
        this.c.setThumb(context.getResources().getDrawable(R.drawable.volume_bar_handle));
        this.c.setThumbOffset(0);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        this.c.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.setMargins(0, ahn.a(this.g, 5.0f), 0, ahn.a(this.g, 5.0f));
        this.k.setLayoutParams(layoutParams2);
    }
}
