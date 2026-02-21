package defpackage;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public abstract class aad<T> {
    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    interface a {
        Boolean a(String str, Boolean bool);

        Float a(String str, Float f);

        Integer a(String str, Integer num);

        Long a(String str, Long l);

        String a(String str, String str2);
    }

    protected aad(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static int a() {
        return e;
    }

    public static aad<Float> a(String str, Float f2) {
        return new aad<Float>(str, f2) { // from class: aad.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // defpackage.aad
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Float a(String str2) {
                return aad.d.a(this.a, (Float) this.b);
            }
        };
    }

    public static aad<Integer> a(String str, Integer num) {
        return new aad<Integer>(str, num) { // from class: aad.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // defpackage.aad
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(String str2) {
                return aad.d.a(this.a, (Integer) this.b);
            }
        };
    }

    public static aad<Long> a(String str, Long l) {
        return new aad<Long>(str, l) { // from class: aad.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // defpackage.aad
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(String str2) {
                return aad.d.a(this.a, (Long) this.b);
            }
        };
    }

    public static aad<String> a(String str, String str2) {
        return new aad<String>(str, str2) { // from class: aad.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // defpackage.aad
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public String a(String str3) {
                return aad.d.a(this.a, (String) this.b);
            }
        };
    }

    public static aad<Boolean> a(String str, boolean z) {
        return new aad<Boolean>(str, Boolean.valueOf(z)) { // from class: aad.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // defpackage.aad
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(String str2) {
                return aad.d.a(this.a, (Boolean) this.b);
            }
        };
    }

    public static boolean b() {
        return d != null;
    }

    protected abstract T a(String str);

    public final T c() {
        return this.g != null ? this.g : a(this.a);
    }

    public final T d() {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return c();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
