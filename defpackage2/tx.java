package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class tx extends ud {
    private SharedPreferences a;
    private long b;
    private long c;
    private final a d;

    public final class a {
        private final String b;
        private final long c;

        private a(String str, long j) {
            vq.a(str);
            vq.b(j > 0);
            this.b = str;
            this.c = j;
        }

        private void c() {
            long jA = tx.this.n().a();
            SharedPreferences.Editor editorEdit = tx.this.a.edit();
            editorEdit.remove(g());
            editorEdit.remove(b());
            editorEdit.putLong(f(), jA);
            editorEdit.commit();
        }

        private long d() {
            long jE = e();
            if (jE == 0) {
                return 0L;
            }
            return Math.abs(jE - tx.this.n().a());
        }

        private long e() {
            return tx.this.a.getLong(f(), 0L);
        }

        private String f() {
            return this.b + ":start";
        }

        private String g() {
            return this.b + ":count";
        }

        public Pair<String, Long> a() {
            long jD = d();
            if (jD < this.c) {
                return null;
            }
            if (jD > this.c * 2) {
                c();
                return null;
            }
            String string = tx.this.a.getString(b(), null);
            long j = tx.this.a.getLong(g(), 0L);
            c();
            if (string == null || j <= 0) {
                return null;
            }
            return new Pair<>(string, Long.valueOf(j));
        }

        public void a(String str) {
            if (e() == 0) {
                c();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = tx.this.a.getLong(g(), 0L);
                if (j <= 0) {
                    SharedPreferences.Editor editorEdit = tx.this.a.edit();
                    editorEdit.putString(b(), str);
                    editorEdit.putLong(g(), 1L);
                    editorEdit.apply();
                    return;
                }
                boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
                SharedPreferences.Editor editorEdit2 = tx.this.a.edit();
                if (z) {
                    editorEdit2.putString(b(), str);
                }
                editorEdit2.putLong(g(), j + 1);
                editorEdit2.apply();
            }
        }

        protected String b() {
            return this.b + ":value";
        }
    }

    protected tx(uf ufVar) {
        super(ufVar);
        this.c = -1L;
        this.d = new a("monitoring", q().G());
    }

    @Override // defpackage.ud
    protected void a() {
        this.a = o().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public void a(String str) {
        m();
        D();
        SharedPreferences.Editor editorEdit = this.a.edit();
        if (TextUtils.isEmpty(str)) {
            editorEdit.remove("installation_campaign");
        } else {
            editorEdit.putString("installation_campaign", str);
        }
        if (editorEdit.commit()) {
            return;
        }
        e("Failed to commit campaign data");
    }

    public long b() {
        m();
        D();
        if (this.b == 0) {
            long j = this.a.getLong("first_run", 0L);
            if (j != 0) {
                this.b = j;
            } else {
                long jA = n().a();
                SharedPreferences.Editor editorEdit = this.a.edit();
                editorEdit.putLong("first_run", jA);
                if (!editorEdit.commit()) {
                    e("Failed to commit first run time");
                }
                this.b = jA;
            }
        }
        return this.b;
    }

    public ty c() {
        return new ty(n(), b());
    }

    public long d() {
        m();
        D();
        if (this.c == -1) {
            this.c = this.a.getLong("last_dispatch", 0L);
        }
        return this.c;
    }

    public void e() {
        m();
        D();
        long jA = n().a();
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putLong("last_dispatch", jA);
        editorEdit.apply();
        this.c = jA;
    }

    public String f() {
        m();
        D();
        String string = this.a.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public a g() {
        return this.d;
    }
}
