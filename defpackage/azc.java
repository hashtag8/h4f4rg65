package defpackage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public class azc {
    public static RdioMusicData a = null;
    public static boolean b = false;
    public static final URI c = URI.create("http://www.harmankardon.com/wireless");
    public static int d = 12;
    public static boolean e = false;
    public static String f = "";
    public static ProgressDialog g;
    public static azl h;

    public static void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void a(final azb azbVar) {
        if (g == null || !g.isShowing()) {
            final Activity activity = ain.J;
            g = new ProgressDialog(activity);
            g.setCancelable(true);
            g.setCanceledOnTouchOutside(false);
            g.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: azc.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    azbVar.cancel(true);
                    azc.a(activity, activity.getResources().getString(R.string.RdioRequestCancelled_Str));
                }
            });
            g.setMessage(activity.getString(R.string.kAndroid_Loading));
            new asc(g).a(null);
        }
    }

    public static void a() {
        if (g != null && g.isShowing()) {
            g.dismiss();
        }
    }

    public static void b() {
        Activity activity = ain.J;
        if (h == null) {
            h = new azl(activity);
        }
        if (!h.isShowing()) {
            h.a(String.format(activity.getResources().getString(R.string.RdioStationSkipMsg_Str), 6));
            h.b(activity.getResources().getString(R.string.RdioStationSkipTitle_Str));
            h.show();
        }
    }
}
