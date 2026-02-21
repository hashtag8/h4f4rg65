package defpackage;

import com.harman.commom.music.player.service.MusicData;

/* JADX INFO: loaded from: classes.dex */
public abstract class aqo {
    public static boolean a = true;

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(int i, MusicData musicData);

    public abstract void a(String str);

    public abstract void a(String str, int i);

    public abstract void a(String str, String str2);

    public abstract void a(String str, String str2, int i);

    public abstract void b();

    public abstract void b(int i);

    public abstract void b(String str, String str2, int i);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public static aqo f() {
        return a ? new aql() : new aqv();
    }
}
