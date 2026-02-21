package defpackage;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import defpackage.qx;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class ye extends yh {
    private final Map<String, String> a;
    private final Context b;

    public ye(zp zpVar, Map<String, String> map) {
        super(zpVar, "storePicture");
        this.a = map;
        this.b = zpVar.c();
    }

    DownloadManager.Request a(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        sy.e().a(request);
        return request;
    }

    String a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void a() {
        if (this.b == null) {
            b("Activity context is not available");
            return;
        }
        if (!sy.c().c(this.b).c()) {
            b("Feature is not supported by the device.");
            return;
        }
        final String str = this.a.get("iurl");
        if (TextUtils.isEmpty(str)) {
            b("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            b("Invalid image url: " + str);
            return;
        }
        final String strA = a(str);
        if (!sy.c().b(strA)) {
            b("Image type not recognized: " + strA);
            return;
        }
        AlertDialog.Builder builderB = sy.c().b(this.b);
        builderB.setTitle(sy.f().a(qx.b.store_picture_title, "Save image"));
        builderB.setMessage(sy.f().a(qx.b.store_picture_message, "Allow Ad to store image in Picture gallery?"));
        builderB.setPositiveButton(sy.f().a(qx.b.accept, "Accept"), new DialogInterface.OnClickListener() { // from class: ye.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ((DownloadManager) ye.this.b.getSystemService("download")).enqueue(ye.this.a(str, strA));
                } catch (IllegalStateException e) {
                    ye.this.b("Could not store picture.");
                }
            }
        });
        builderB.setNegativeButton(sy.f().a(qx.b.decline, "Decline"), new DialogInterface.OnClickListener() { // from class: ye.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ye.this.b("User canceled the download.");
            }
        });
        builderB.create().show();
    }
}
