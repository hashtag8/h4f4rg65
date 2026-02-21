package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class asn {
    public static final asn a = new asn();

    private asn() {
    }

    public final void a(Context context) {
        bpj.b(context, "context");
        mm.c("eula init", new Object[0]);
        if (aho.d("EULA_HKController").length() == 0) {
            aho.a("EULA_HKController", "1.0.0");
            mm.c("init local EULA version 1.0.0", new Object[0]);
        }
        if (aho.d("PrivacyPolicy").length() == 0) {
            aho.a("PrivacyPolicy", "1.0.0");
            mm.c("init local policy version 1.0.0", new Object[0]);
        }
        ast.a.a(context, aso.a.a(), (ass) null);
    }

    public final void a(ba baVar, asm asmVar) {
        bpj.b(baVar, "context");
        bpj.b(asmVar, "listener");
        Fragment fragmentA = baVar.f().a(asq.ae);
        if (!(fragmentA instanceof asq)) {
            fragmentA = null;
        }
        asq asqVar = (asq) fragmentA;
        if (asqVar == null || asqVar.d() == null) {
            Fragment fragmentA2 = baVar.f().a(asr.ae);
            if (!(fragmentA2 instanceof asr)) {
                fragmentA2 = null;
            }
            asr asrVar = (asr) fragmentA2;
            if (asrVar == null || asrVar.d() == null) {
                asr asrVar2 = new asr();
                asrVar2.a(baVar.f(), asr.ae);
                asrVar2.a(asmVar);
            }
        }
    }

    public static final class a implements ass {
        final /* synthetic */ ba a;

        a(ba baVar) {
            this.a = baVar;
        }

        @Override // defpackage.ass
        public void a(List<asp> list) {
            bpj.b(list, "list");
            for (asp aspVar : list) {
                if (bpo.a(aspVar.a(), "EULA_HKController", true)) {
                    asn.a.a(this.a, R.string.kEULA_Str, aspVar.d());
                }
            }
        }
    }

    public final void a(ba baVar) {
        bpj.b(baVar, "context");
        if (b((Context) baVar)) {
            ast.a.a(baVar, aso.a.a(), new a(baVar));
        } else {
            a(baVar, R.string.kEULA_Str, "EULA_HKController_Android.txt");
        }
    }

    public static final class b implements ass {
        final /* synthetic */ ba a;

        b(ba baVar) {
            this.a = baVar;
        }

        @Override // defpackage.ass
        public void a(List<asp> list) {
            bpj.b(list, "list");
            for (asp aspVar : list) {
                if (bpo.a(aspVar.a(), "PrivacyPolicy", true)) {
                    asn.a.a(this.a, R.string.kSettings_Privacy_Statement, aspVar.d());
                }
            }
        }
    }

    public final void b(ba baVar) {
        bpj.b(baVar, "context");
        if (b((Context) baVar)) {
            ast.a.a(baVar, aso.a.a(), new b(baVar));
        } else {
            a(baVar, R.string.kSettings_Privacy_Statement, "PrivacyPolicy.txt");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ba baVar, int i, String str) {
        Fragment fragmentA = baVar.f().a(asq.ae);
        if (fragmentA == null || ((asq) fragmentA).d() == null) {
            asq asqVar = new asq();
            asqVar.d(i);
            asqVar.b(str);
            asqVar.a(baVar.f(), asq.ae);
        }
    }

    private final boolean b(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new bpe("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
