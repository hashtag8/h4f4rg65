package defpackage;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes.dex */
public class qh extends AsyncTask<ql, Void, String> {
    private qi a;
    private qn b;
    private Object c;
    private IOException d;
    private MalformedURLException e;
    private qk f;
    private qm g;

    public qh(qi qiVar, qn qnVar) {
        this.a = qiVar;
        this.b = qnVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(ql... qlVarArr) {
        if (qlVarArr == null || qlVarArr.length != 1 || qlVarArr[0] == null) {
            throw new IllegalArgumentException("AsyncDeezerTask executes one and only one request, and doesn't support null requests.");
        }
        this.c = qlVarArr[0].d();
        try {
            return this.a.a(qlVarArr[0]);
        } catch (MalformedURLException e) {
            this.e = e;
            return null;
        } catch (IOException e2) {
            this.d = e2;
            return null;
        } catch (qm e3) {
            this.g = e3;
            return null;
        } catch (qk e4) {
            this.f = e4;
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (this.d != null) {
            this.b.a(this.d, this.c);
            return;
        }
        if (this.e != null) {
            this.b.a(this.e, this.c);
            return;
        }
        if (this.g != null) {
            this.b.a(this.g, this.c);
        } else if (this.f != null) {
            this.b.a(this.f, this.c);
        } else {
            this.b.a(str, this.c);
        }
    }
}
