package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class xi implements xl {
    private final xj a;

    public xi(xj xjVar) {
        this.a = xjVar;
    }

    @Override // defpackage.xl
    public void a(zp zpVar, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            su.e("App event with no name parameter.");
        } else {
            this.a.a(str, map.get("info"));
        }
    }
}
