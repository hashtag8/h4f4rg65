package defpackage;

import android.app.Activity;
import java.lang.ref.WeakReference;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anv {
    static final /* synthetic */ boolean a;
    private WeakReference<ajk> b;
    private WeakReference<Activity> c;
    private aue d = agv.a(true);

    static {
        a = !anv.class.desiredAssertionStatus();
    }

    public anv(ajk ajkVar) {
        this.b = new WeakReference<>(ajkVar);
    }

    public anv(Activity activity) {
        this.c = new WeakReference<>(activity);
    }

    public void a(String str, final anu<JSONObject> anuVar) {
        this.d.a(str, new aum() { // from class: anv.1
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                super.a(i, headerArr, jSONObject);
                if (anv.this.a()) {
                    mm.b("Fragment has finished, not notifying onSuccess %s", anv.this.b.get());
                } else {
                    anuVar.a(jSONObject);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                String strOptString;
                Exception e;
                super.a(i, headerArr, th, jSONObject);
                try {
                    strOptString = jSONObject.optString("message");
                    try {
                        if ("".equals(strOptString)) {
                            strOptString = jSONObject.optString("status");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    strOptString = null;
                    e = e3;
                }
                if (anv.this.a()) {
                    mm.b("Fragment has finished, not notifying onFailure %s %s", strOptString, anv.this.b.get());
                } else {
                    anuVar.b(strOptString);
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str2, Throwable th) {
                super.a(i, headerArr, str2, th);
                if (anv.this.a()) {
                    mm.b("Fragment has finished, not notifying onFailure %s %s", Integer.valueOf(i), anv.this.b.get(), th);
                } else {
                    anuVar.b(str2);
                }
            }

            @Override // defpackage.aug
            public void b() {
                super.b();
                if (anv.this.a()) {
                    mm.b("Fragment has finished, not notifying onFinish %s", anv.this.b.get());
                } else {
                    anuVar.c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (this.b != null) {
            ajk ajkVar = this.b.get();
            return ajkVar == null || ajkVar.aw();
        }
        if (!a && this.c == null) {
            throw new AssertionError("impossible, either is set in constructor");
        }
        Activity activity = this.c.get();
        return activity == null || activity.isFinishing();
    }
}
