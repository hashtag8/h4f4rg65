package defpackage;

import android.app.RemoteInput;
import defpackage.cc;

/* JADX INFO: loaded from: classes.dex */
class cb {
    static RemoteInput[] a(cc.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            cc.a aVar = aVarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(aVar.a()).setLabel(aVar.b()).setChoices(aVar.c()).setAllowFreeFormInput(aVar.e()).addExtras(aVar.f()).build();
        }
        return remoteInputArr;
    }
}
