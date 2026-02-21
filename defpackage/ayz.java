package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum ayz {
    EHistoryOverview("overview"),
    EHistoryThisWeek("thisweek"),
    EHistoryLastWeek("lastweek"),
    EHistoryTwoWeek("twoweeks");

    private String e;

    public String a() {
        return this.e;
    }

    ayz(String str) {
        this.e = str;
    }
}
