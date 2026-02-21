package defpackage;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.settings.GoogleCastLicenseActivity;
import com.harman.hkconnect.ui.BottomPlayer;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
public abstract class aqc extends aqb {
    private DialogInterface.OnDismissListener n;
    protected Dialog t;
    protected aoc u;
    public BottomPlayer w;
    protected ate x;
    protected Dialog s = null;
    private int m = 0;
    public boolean v = false;
    private final BroadcastReceiver o = new BroadcastReceiver() { // from class: aqc.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("ACTION_MK_DEVICES_UPDATED")) {
                aqc.this.k();
                return;
            }
            if (action.equals("ACTION_MK_DEVICE_REMOVED")) {
                int intExtra = intent.getIntExtra("roomid", 0);
                aqc.this.k();
                if (aqc.this.x == null || !aqc.this.x.c()) {
                    mm.b("Firmware update show dialog", new Object[0]);
                    aqc.this.h(intExtra);
                    return;
                }
                return;
            }
            if (action.equals("ACTION_DEVICES_MANDATORY_UPGRADE")) {
                aqc.this.v();
                return;
            }
            if (action.equals("ACTION_MK_DISMISS_STREAM")) {
                aqc.this.z();
                return;
            }
            if (action.equals("ACTION_ERROR_9")) {
                aqc.this.y();
                return;
            }
            if (action.equals("ACTION_RECOVERY")) {
                aqc.this.a(intent.getLongExtra("deviceid", 0L));
            } else if (action.equals("ACTION_MK_SPEAKER_CHANGED")) {
                mm.b("have a check if has MKII speaks in the speaker list" + ain.o, new Object[0]);
                aqc.this.j(ain.o);
            }
        }
    };
    private Handler p = new Handler() { // from class: aqc.8
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                System.out.println("----Bright.Sun--C--->" + ain.E);
                ain.E = false;
            }
        }
    };

    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
    }

    @Override // defpackage.aqb, defpackage.ba, android.app.Activity
    public void onResume() {
        super.onResume();
        k();
    }

    private void l() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MK_DEVICES_UPDATED");
        intentFilter.addAction("ACTION_MK_DEVICE_REMOVED");
        intentFilter.addAction("ACTION_DEVICES_MANDATORY_UPGRADE");
        intentFilter.addAction("ACTION_RECOVERY");
        intentFilter.addAction("ACTION_ERROR_9");
        intentFilter.addAction("ACTION_MK_SPEAKER_CHANGED");
        new ahm(this, this.o).b(intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("ServiceBroadcast");
        new ahm(this, new BroadcastReceiver() { // from class: aqc.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("ServiceBroadcast".equals(intent.getAction()) && intent.getIntExtra("PlayState", 3) == 0 && als.a(MusicPlaylistManager.a().s(), aqc.this)) {
                    aqc.this.u();
                }
            }
        }).a(intentFilter2);
    }

    public void j(boolean z) {
    }

    protected void v() {
        mm.b();
    }

    public void k() {
        if (this.t != null && this.t.isShowing()) {
            adz adzVarA = aof.a().a(this.m);
            if (adzVarA == null || adzVarA.k().size() < 2) {
                h(this.m);
            }
        }
    }

    protected void a(final long j) {
        if (this.s == null) {
            this.s = new arw.a(this).b(getString(R.string.AutoLoadFailTitle_Str)).a(getString(R.string.AutoLoadFailMessage_Str)).a(getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: aqc.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    aqc.this.k();
                    afa.a.put(Long.valueOf(j), Long.valueOf(j));
                    dialogInterface.dismiss();
                    aqc.this.s = null;
                    ady adyVarO = aof.a().o();
                    if (adyVarO != null && adyVarO.n() == 1) {
                        MusicPlaylistManager.a().n();
                    }
                }
            }).d(false).a().b();
        }
        if (!this.s.isShowing() && !isFinishing()) {
            new asc(this.s).a(null);
        }
    }

    protected void h(int i) {
        adz adzVarA = aof.a().a(i);
        if (adzVarA != null) {
            if (adzVarA.d() != 1 || adzVarA.d() != 4 || adzVarA.d() != 2) {
                if (this.t == null || (!this.t.isShowing() && !isFinishing())) {
                    this.m = i;
                    View viewInflate = getLayoutInflater().inflate(R.layout.lost_stereo_speaker_dialog, (ViewGroup) null);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.id_dialog_title);
                    ady adyVarB = aof.a().b(adzVarA.x());
                    if (adyVarB != null) {
                        textView.setText(getResources().getString(R.string.kSpeakersLostConnectionTitle_Str, adyVarB.i()));
                        this.t = new arw.a(this).a(viewInflate).c(false).a(R.string.kQobuz_OK_Str, new DialogInterface.OnClickListener() { // from class: aqc.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                aqc.this.t.dismiss();
                            }
                        }).b();
                        new asc(this.t).a(null);
                    }
                }
            }
        }
    }

    protected void w() {
        if (!ain.a) {
            ain.a = true;
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_googlecast_content, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.text_link_learn_more);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.text_link_app);
            final arw arwVarB = new arw.a(this).b(getString(R.string.SettingGoogleCast_Str)).a(viewInflate).a(getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: aqc.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    mm.b();
                    dialogInterface.dismiss();
                }
            }).d(false).b();
            textView.setOnClickListener(new View.OnClickListener() { // from class: aqc.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    mm.b();
                    aqc.this.a("https://www.google.com/cast/learn/audio/");
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: aqc.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    mm.b();
                    arwVarB.dismiss();
                    aqc.this.x();
                }
            });
            if (!arwVarB.isShowing()) {
                new asc(arwVarB).a(this);
            }
        }
    }

    public void x() {
        startActivity(new Intent(this, (Class<?>) GoogleCastLicenseActivity.class));
    }

    public void y() {
        Toast.makeText(this, R.string.kSameQueue_BreakInTip_Str, 1).show();
    }

    public void z() {
    }

    public boolean A() {
        return this.u != null && this.u.isShowing();
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void B() {
        this.n = null;
    }

    @Override // defpackage.gk, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        mm.b("onKeyonKeyDown event.getAction() = " + keyEvent.getAction() + " ，keyCode = " + i, new Object[0]);
        switch (i) {
            case 24:
                if (aho.a("KEY_DISABLE_HARDWARE_VOLUME")) {
                    return true;
                }
                if (!this.v || this.w.a) {
                    k(true);
                }
                ain.E = true;
                this.p.removeMessages(1);
                aob.h().d();
                return true;
            case 25:
                if (aho.a("KEY_DISABLE_HARDWARE_VOLUME")) {
                    return true;
                }
                if (!this.v || this.w.a) {
                    k(true);
                }
                ain.E = true;
                this.p.removeMessages(1);
                aob.h().e();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        mm.b("onKeyonKeyUp event.getAction() = " + keyEvent.getAction() + " ，keyCode = " + i, new Object[0]);
        this.p.sendEmptyMessageDelayed(1, 500L);
        return super.onKeyUp(i, keyEvent);
    }

    public void k(boolean z) {
        if ((this.u == null || !this.u.isShowing()) && aof.a().b() != null && aof.a().d().size() > 0) {
            if (this.u == null) {
                this.u = new aoc(this, R.style.BottomPlayerDialogTheme);
            }
            this.u.a(z);
            this.u.setOnDismissListener(this.n);
            new asc(this.u).a(null);
        }
    }
}
