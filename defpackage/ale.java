package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ale extends ald {
    private ProgressDialog a;
    private Handler b = new Handler() { // from class: ale.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ale.this.d();
        }
    };
    int h = 0;
    int i = 0;
    private String[] c = null;

    abstract View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void a(boolean z) {
        if (this.a == null && !this.ae.isFinishing()) {
            this.a = new ProgressDialog(this.ae);
            this.a.setCancelable(true);
            this.a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ale.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.a.setMessage(this.ae.getString(R.string.kAndroid_Loading));
        }
        if (!this.a.isShowing()) {
            new asc(this.a).a(p());
        }
        if (z) {
            this.b.sendEmptyMessageDelayed(1, 45000L);
        }
    }

    public void c() {
        a(true);
    }

    public void d() {
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
            this.a = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater, viewGroup, bundle);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
    }

    protected void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            d();
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("error");
        if (jSONObjectOptJSONObject == null) {
            d();
        } else if (jSONObjectOptJSONObject.optInt("code") == 300) {
            d();
            Toast.makeText(this.ae, R.string.kDeezer_Error300_Str, 0).show();
            am();
        }
    }

    private void am() {
        if (this.g != null) {
            this.g.a(this.ae);
        }
        if (als.c != null) {
            als.c.clear();
        }
        new ava().a(1, this.ae).b();
        a(new Class[0]);
        an();
        MusicPlaylistManager.a().a(3);
        this.ae.p().a(1);
    }

    private void an() {
        File cacheDir = this.ae.getCacheDir();
        mm.b(cacheDir, new Object[0]);
        a(cacheDir);
        a(new File("/data/data/com.harman.hkconnect/databases"));
    }

    private void a(File file) {
        File[] fileArrListFiles;
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
            }
            file.delete();
            return;
        }
        mm.b("所删除的文件不存在！\n", new Object[0]);
    }

    protected void al() {
        d();
        Toast.makeText(this.ae, R.string.kDeezer_Error300_Str, 0).show();
        am();
    }
}
