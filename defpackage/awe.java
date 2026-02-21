package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.widget.ListView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.dlna.customviews.LoadMoreListView;
import com.stc.upnp.services.DlnaService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class awe {
    public static boolean a = false;

    public static void a(String str, int i, Context context) {
        ((ba) context).f().a("MAIN", 0);
    }

    public static void a(ListView listView) {
        if (listView instanceof LoadMoreListView) {
            ((LoadMoreListView) listView).c();
        }
    }

    public static void a(Context context) {
        if (context instanceof DashboardActivity) {
            DashboardActivity dashboardActivity = (DashboardActivity) context;
            avf avfVarP = dashboardActivity.p();
            avfVarP.a(avfVarP.a().get(0).f());
            dashboardActivity.D().notifyDataSetChanged();
        }
    }

    public static void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static int[] b(Context context) {
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        return new int[]{defaultDisplay.getWidth(), defaultDisplay.getHeight()};
    }

    public static int a(int i, Context context) {
        return Math.round((context.getResources().getDisplayMetrics().xdpi / 160.0f) * i);
    }

    public static long a(String str) {
        if (str == null) {
            return 0L;
        }
        if (!str.contains(".")) {
            str = str + ".000";
        }
        if (str.length() == 11) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss.SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (Exception e) {
                return b(str);
            }
        }
        return b(str);
    }

    private static long b(String str) {
        long j = 0;
        String[] strArrSplit = str.substring(0, str.indexOf(46)).split(":");
        if (strArrSplit != null) {
            try {
                if (strArrSplit.length == 3) {
                    j = ((0 + ((long) (Integer.parseInt(strArrSplit[0]) * 60 * 60)) + ((long) (Integer.parseInt(strArrSplit[1]) * 60)) + ((long) Integer.parseInt(strArrSplit[2]))) * 1000) + ((long) Integer.parseInt(str.substring(str.indexOf(46) + 1, str.length())));
                } else if (strArrSplit.length == 2) {
                    j = ((0 + ((long) (Integer.parseInt(strArrSplit[0]) * 60)) + ((long) Integer.parseInt(strArrSplit[1]))) * 1000) + ((long) Integer.parseInt(str.substring(str.indexOf(46) + 1, str.length())));
                } else if (strArrSplit.length == 1) {
                    j = ((0 + ((long) Integer.parseInt(strArrSplit[0]))) * 1000) + ((long) Integer.parseInt(str.substring(str.indexOf(46) + 1, str.length())));
                }
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static List<MusicData> a(List<bjp> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                bjp bjpVar = list.get(i2);
                MusicData musicData = new MusicData(bjpVar.c(), bjpVar.a(), bjpVar.b(), bjpVar.f(), bjpVar.d());
                musicData.setChildCount(bjpVar.i());
                musicData.setContainerID(bjpVar.h());
                musicData.path = bjpVar.e();
                musicData.musicName = bjpVar.a();
                musicData.type = 1;
                musicData.setObjectClass(bjpVar.d());
                musicData.setDuration(bjpVar.g());
                musicData.duration = a(bjpVar.g());
                musicData.setIconUrl(bjpVar.j());
                musicData.album_art = bjpVar.j();
                arrayList.add(musicData);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static void c(Context context) {
        context.startService(new Intent(context, (Class<?>) DlnaService.class));
    }
}
