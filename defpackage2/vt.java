package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vt {
    public static aad<Boolean> a = aad.a("gms:common:stats:debug", false);
    public static aad<Integer> b = aad.a("gms:common:stats:max_num_of_events", (Integer) 100);

    public static final class a {
        public static aad<Integer> a = aad.a("gms:common:stats:connections:level", Integer.valueOf(vu.a));
        public static aad<String> b = aad.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static aad<String> c = aad.a("gms:common:stats:connections:ignored_calling_services", "");
        public static aad<String> d = aad.a("gms:common:stats:connections:ignored_target_processes", "");
        public static aad<String> e = aad.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static aad<Long> f = aad.a("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }
}
