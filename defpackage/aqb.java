package defpackage;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
public class aqb extends gk {
    protected Dialog q = null;
    protected Dialog r = null;

    @Override // defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        mm.b("Creating activity %s", this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (!ahn.a()) {
            setRequestedOrientation(1);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        new ahm(this, new a()).a(intentFilter);
        setVolumeControlStream(3);
        if ((getIntent().getFlags() & 4194304) != 0) {
            finish();
        } else {
            k();
        }
    }

    @TargetApi(17)
    private void k() {
        if (Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().locale.getLanguage().equals("iw")) {
            getWindow().getDecorView().setLayoutDirection(1);
            getWindow().getDecorView().setTextDirection(4);
        }
    }

    public void t() {
        if (this.q != null) {
            this.q.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: aqb.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    aqb.this.q = null;
                }
            });
        }
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo;
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null && (context instanceof DashboardActivity)) {
                ajk ajkVarA = ((DashboardActivity) context).q().a();
                if (ajkVarA instanceof avw) {
                    avw avwVar = (avw) ajkVarA;
                    if (networkInfo.getType() == 1) {
                        avwVar.aD();
                    } else {
                        avwVar.aB();
                    }
                }
            }
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // defpackage.ba, android.app.Activity
    public void onPause() {
        super.onPause();
        if (MusicPlaylistManager.a().v() && aff.b == 2004) {
            setVolumeControlStream(3);
        }
    }

    protected void u() {
        if (this.r == null) {
            this.r = new arw.a(this).b(getString(R.string.kAndroid_tip)).a(getString(R.string.kDeezer_Subscribe_Notice_Str)).a(getString(R.string.kDeezer_Subscribe_Str), new DialogInterface.OnClickListener() { // from class: aqb.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Uri uri = Uri.parse(als.b);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    aqb.this.startActivity(intent);
                }
            }).b(getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: aqb.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    aqb.this.q = null;
                }
            }).d(false).b();
            t();
        }
        if (!this.r.isShowing() && !isFinishing()) {
            new asc(this.r).a(null);
        }
        als.d = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                currentFocus.getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    currentFocus.clearFocus();
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void a(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(Intent.createChooser(intent, "please select a browser"));
    }
}
