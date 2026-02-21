package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class aap implements aaw {
    private static final Uri a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        a = builder.build();
    }

    @Override // defpackage.aaw
    public Uri a() {
        return a;
    }

    @Override // defpackage.aaw
    public void a(aaq aaqVar) {
        ArrayList arrayList = new ArrayList(aaqVar.b());
        Collections.sort(arrayList, new Comparator<aas>() { // from class: aap.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(aas aasVar, aas aasVar2) {
                return aasVar.getClass().getCanonicalName().compareTo(aasVar2.getClass().getCanonicalName());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String string = ((aas) it.next()).toString();
            if (!TextUtils.isEmpty(string)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(string);
            }
        }
        this.b.println(sb.toString());
    }
}
