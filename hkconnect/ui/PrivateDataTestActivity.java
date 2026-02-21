package com.harman.hkconnect.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.adw;
import defpackage.adx;
import defpackage.aqc;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class PrivateDataTestActivity extends aqc {
    public adx m;
    private final a n = new a(this);

    static class a extends Handler {
        private final WeakReference<PrivateDataTestActivity> a;

        public a(PrivateDataTestActivity privateDataTestActivity) {
            this.a = new WeakReference<>(privateDataTestActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() == null || message.what == 1103) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_privatedata);
    }

    public void queryCapability(View view) {
        if (this.m == null) {
        }
    }

    public void queryPrivateDataVersion(View view) {
        if (this.m != null) {
            adw.a().queryPrivateDataVersion(this.m);
        }
    }

    public void queryVersion(View view) {
        if (this.m != null) {
            adw.a().queryVersion(this.m);
        }
    }

    public void factoryRestore(View view) {
        if (this.m != null) {
            adw.a().factoryRestore(this.m);
        }
    }

    public void upgrade(View view) {
        if (this.m == null) {
        }
    }

    public void volumeRestore(View view) {
        if (this.m != null) {
            adw.a().volumeRestore(this.m);
        }
    }

    public void queryPrivateDataAll(View view) {
        if (this.m != null) {
            adw.a().queryPrivateDataAll(this.m);
        }
    }

    public void queryWifi(View view) {
        if (this.m != null) {
            adw.a().queryWifi(this.m);
        }
    }

    public void queryUniqueName(View view) {
        if (this.m != null) {
            adw.a().queryUniqueName(this.m);
        }
    }

    public void queryCurrentSource(View view) {
        if (this.m != null) {
            adw.a().queryCurrentSource(this.m);
        }
    }
}
