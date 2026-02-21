package defpackage;

import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class agi<T> extends agj<agh> implements agh<T> {
    @Override // defpackage.agh
    public void a(final Object obj, final T t) {
        a((agk) new agk<agh<T>>() { // from class: agi.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.agk
            public void a(agh<T> aghVar) {
                try {
                    aghVar.a(obj, t);
                } catch (Throwable th) {
                    aghVar.a(obj, new ErrorInfo.a().a(R.id.errorCode_onSuccessFailure).a((Serializable) String.valueOf(t)).a(th).a());
                }
            }
        });
    }

    @Override // defpackage.agh
    public void a(final Object obj, final ErrorInfo errorInfo) {
        a((agk) new agk<agh<T>>() { // from class: agi.2
            @Override // defpackage.agk
            public void a(agh<T> aghVar) {
                aghVar.a(obj, errorInfo);
            }
        });
    }
}
