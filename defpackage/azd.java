package defpackage;

import android.content.SharedPreferences;
import com.musicservice.rdio.RdioDataTypes.RdioStationMusicData;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class azd {
    public static azd a;
    protected RdioStationMusicData b = new RdioStationMusicData();
    private boolean c = false;
    private long d = 0;
    private int e = 0;

    public static azd a() {
        if (a == null) {
            a = new azd();
        }
        return a;
    }

    public String b() {
        return this.b.f();
    }

    public void a(String str) {
        this.b.a(str);
    }

    public void a(RdioStationMusicData rdioStationMusicData) {
        this.b = rdioStationMusicData;
    }

    public RdioStationMusicData c() {
        return this.b;
    }

    public void d() {
        long time = new Date().getTime();
        HashSet<String> hashSet = new HashSet<>();
        if (f() > 6 && !ayw.c().b().booleanValue()) {
            a(true);
        }
        if (f() == 0) {
            a(time);
        } else {
            time = g();
        }
        a(f() + 1);
        hashSet.add("date=" + String.valueOf(time));
        hashSet.add(String.valueOf(f()));
        a("RdioStation" + ayw.c().a() + b(), hashSet);
    }

    public void a(String str, HashSet<String> hashSet) {
        SharedPreferences.Editor editorEdit = ain.J.getSharedPreferences("", 0).edit();
        editorEdit.putStringSet(str, hashSet);
        editorEdit.apply();
    }

    public void e() {
        Set<String> stringSet = ain.J.getSharedPreferences("", 0).getStringSet("RdioStation" + ayw.c().a() + b(), null);
        if (stringSet != null) {
            long jLongValue = 0;
            int iIntValue = 0;
            for (String str : stringSet) {
                if (str.startsWith("date=")) {
                    jLongValue = Long.valueOf(str.replace("date=", "")).longValue();
                } else {
                    iIntValue = Integer.valueOf(str).intValue();
                }
                iIntValue = iIntValue;
                jLongValue = jLongValue;
            }
            if (new Date().getTime() - jLongValue > 3600000) {
                a(0);
                return;
            } else {
                a(iIntValue);
                return;
            }
        }
        a(0);
    }

    public int f() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
        if (i >= 7 && !ayw.c().b().booleanValue()) {
            a(true);
        } else {
            a(false);
        }
    }

    public long g() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public boolean h() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
