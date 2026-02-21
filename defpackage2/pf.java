package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class pf {
    private final Context a;
    private final bot b;

    public pf(Context context, bot botVar) {
        this.a = context;
        this.b = botVar;
    }

    public String a() {
        return a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
    }

    public String b() {
        return a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
    }

    public String c() {
        return a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
    }

    public String d() {
        return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
    }

    public String e() {
        return a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
    }

    private String a(String str, String str2) {
        return b(bme.b(this.a, str), str2);
    }

    private String b(String str, String str2) {
        return a(str) ? str2 : str;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
