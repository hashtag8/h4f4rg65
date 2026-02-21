package defpackage;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class ahc {
    public static final String a = Environment.getExternalStorageDirectory() + "/";
    public static final String b = null;

    public static String a(Context context, String str) {
        String str2;
        Exception e;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            str2 = "";
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    str2 = str2 + line;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            str2 = "";
            e = e3;
        }
        return str2;
    }
}
