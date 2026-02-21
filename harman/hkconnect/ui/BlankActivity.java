package com.harman.hkconnect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import defpackage.afc;
import defpackage.arw;
import defpackage.asc;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class BlankActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBooleanExtra("exit", false)) {
            finish();
            afc.a().a(HarmanApplication.a());
            MusicPlaylistManager.a().b(HarmanApplication.a());
            Process.killProcess(Process.myPid());
            return;
        }
        if (a()) {
            mm.b("can't running on X86 platform.", new Object[0]);
            b();
        } else {
            startActivityForResult(new Intent(this, (Class<?>) DashboardActivity.class), 110);
        }
    }

    private boolean a() {
        String lowerCase;
        String lowerCase2 = System.getProperty("os.arch").toLowerCase();
        if (Build.VERSION.SDK_INT >= 21) {
            lowerCase = Build.SUPPORTED_ABIS[0].toLowerCase();
        } else {
            lowerCase = Build.CPU_ABI.toLowerCase();
        }
        mm.b("cpu=%s, cpu2=%s, os.arch=%s", lowerCase, Build.CPU_ABI2, lowerCase2);
        return lowerCase.contains("x86") && lowerCase2.contains("i686");
    }

    private void b() {
        new asc(new arw.a(this).a(getResources().getString(R.string.kDontSupportX86)).a(getResources().getString(R.string.kActionSheetClose_Str), new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.BlankActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BlankActivity.this.finish();
                Process.killProcess(Process.myPid());
            }
        }).d(false).a().b()).a(null);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 110) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
