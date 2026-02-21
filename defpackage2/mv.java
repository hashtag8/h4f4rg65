package defpackage;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class mv {
    final Map<String, Object> a;

    public String toString() {
        return new JSONObject(this.a).toString();
    }
}
