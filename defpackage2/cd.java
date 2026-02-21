package defpackage;

import android.os.Bundle;
import defpackage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class cd {
    static Bundle a(cc.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", aVar.a());
        bundle.putCharSequence("label", aVar.b());
        bundle.putCharSequenceArray("choices", aVar.c());
        bundle.putBoolean("allowFreeFormInput", aVar.e());
        bundle.putBundle("extras", aVar.f());
        Set<String> setD = aVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    static Bundle[] a(cc.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            bundleArr[i] = a(aVarArr[i]);
        }
        return bundleArr;
    }
}
