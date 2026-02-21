package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aky extends qh {
    private ProgressDialog a;
    private Context b;
    private boolean c;

    public aky(Context context, qi qiVar, qn qnVar) {
        super(qiVar, qnVar);
        this.c = true;
        this.b = context;
        this.a = new ProgressDialog(context);
        this.a.setCancelable(true);
        this.a.setCanceledOnTouchOutside(false);
        this.a.setOnCancelListener(new a());
    }

    public aky(Context context, qi qiVar, qn qnVar, boolean z) {
        this(context, qiVar, qnVar);
        this.c = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (this.c) {
            this.a.setMessage(this.b.getString(R.string.kAndroid_Loading));
            new asc(this.a).a(null);
        }
        super.onPreExecute();
    }

    @Override // defpackage.qh, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        try {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        } catch (IllegalArgumentException e) {
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        try {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        } catch (IllegalArgumentException e) {
        }
        super.onCancelled();
    }

    class a implements DialogInterface.OnCancelListener {
        private a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            aky.this.cancel(true);
        }
    }
}
