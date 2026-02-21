package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
public class ahy {
    private final Context a;
    private int b = R.string.generalError;
    private int c = R.string.generalError;

    protected ahy(Context context) {
        this.a = context;
    }

    public void a(ErrorInfo errorInfo, String str) {
        if (this.a == null) {
            mm.b("Activity closed before we could show toast for %s", errorInfo);
        } else {
            new asc(new arw.a(this.a).b(str).a(errorInfo.c()).a(this.a.getResources().getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ahy.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).d(false).a().b()).a(null);
        }
    }

    public void a(ErrorInfo errorInfo) {
        if (this.a == null) {
            mm.b("Activity closed before we could show toast for %s", errorInfo);
        } else {
            Toast.makeText(this.a, b(errorInfo), 0).show();
        }
    }

    public String b(ErrorInfo errorInfo) {
        int i;
        if (this.a == null) {
            mm.b("Activity closed before we could make text for %s", errorInfo);
            return "";
        }
        ErrorInfo errorInfoE = errorInfo.e();
        if (bru.a((CharSequence) errorInfoE.c())) {
            if (errorInfoE.a(R.id.errorCode_noConnection)) {
                i = R.string.noConnectionError;
            } else if (errorInfoE.a(R.id.errorCode_noData)) {
                i = this.b;
            } else {
                i = this.c;
            }
            return this.a.getResources().getString(i);
        }
        return errorInfoE.c();
    }

    public static class a {
        private ahy a;

        public a(Context context) {
            this.a = new ahy(context);
        }

        public a a(int i) {
            this.a.b = i;
            return this;
        }

        public a b(int i) {
            this.a.c = i;
            return this;
        }

        public ahy a() {
            return this.a;
        }
    }
}
