package defpackage;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.harman.commom.music.player.service.MusicService;

/* JADX INFO: loaded from: classes.dex */
public class agf extends AppWidgetProvider {
    private static agf a;

    public static synchronized agf a() {
        if (a == null) {
            a = new agf();
        }
        return a;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        a(context, iArr);
        Intent intent = new Intent("com.harman.hkconnect.android.music.ui.musicservicecommand");
        intent.putExtra("command", "appwidgetupdate");
        intent.putExtra("appWidgetIds", iArr);
        intent.addFlags(1073741824);
        context.sendBroadcast(intent);
    }

    private void a(Context context, int[] iArr) {
    }

    private boolean a(Context context) {
        return AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClass())).length > 0;
    }

    public void a(MusicService musicService, String str) {
        if (a(musicService)) {
            if ("com.harman.hkconnect.android.music.ui.metachanged".equals(str) || "com.harman.hkconnect.android.music.ui.playstatechanged".equals(str)) {
                a(musicService, (int[]) null);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void a(MusicService musicService, int[] iArr) {
    }
}
