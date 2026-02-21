package defpackage;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@yx
public abstract class wx<T> implements ww {
    private final String a;
    private final T b;

    private wx(String str, T t) {
        this.a = str;
        this.b = t;
        sy.h().a(this);
    }

    public static wx<String> a(String str) {
        wx<String> wxVarA = a(str, (String) null);
        sy.h().a(wxVarA);
        return wxVarA;
    }

    public static wx<Integer> a(String str, int i) {
        return new wx<Integer>(str, Integer.valueOf(i)) { // from class: wx.2
            @Override // defpackage.wx
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(a(), b().intValue()));
            }
        };
    }

    public static wx<Long> a(String str, long j) {
        return new wx<Long>(str, Long.valueOf(j)) { // from class: wx.3
            @Override // defpackage.wx
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(a(), b().longValue()));
            }
        };
    }

    public static wx<Boolean> a(String str, Boolean bool) {
        return new wx<Boolean>(str, bool) { // from class: wx.1
            @Override // defpackage.wx
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(a(), b().booleanValue()));
            }
        };
    }

    public static wx<String> a(String str, String str2) {
        return new wx<String>(str, str2) { // from class: wx.4
            @Override // defpackage.wx
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public String a(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(a(), b());
            }
        };
    }

    public static wx<String> b(String str) {
        wx<String> wxVarA = a(str, (String) null);
        sy.h().b(wxVarA);
        return wxVarA;
    }

    protected abstract T a(SharedPreferences sharedPreferences);

    public String a() {
        return this.a;
    }

    public T b() {
        return this.b;
    }

    public T c() {
        return (T) sy.i().a(this);
    }
}
