package defpackage;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CommitPrefEdits"})
class pr {
    private final bod a;
    private final ot b;

    public static pr a(bod bodVar, ot otVar) {
        return new pr(bodVar, otVar);
    }

    public pr(bod bodVar, ot otVar) {
        this.a = bodVar;
        this.b = otVar;
    }

    void a(boolean z) {
        this.a.a(this.a.b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean a() {
        if (!this.a.a().contains("preferences_migration_complete")) {
            boe boeVar = new boe(this.b);
            if (!this.a.a().contains("always_send_reports_opt_in") && boeVar.a().contains("always_send_reports_opt_in")) {
                this.a.a(this.a.b().putBoolean("always_send_reports_opt_in", boeVar.a().getBoolean("always_send_reports_opt_in", false)));
            }
            this.a.a(this.a.b().putBoolean("preferences_migration_complete", true));
        }
        return this.a.a().getBoolean("always_send_reports_opt_in", false);
    }
}
