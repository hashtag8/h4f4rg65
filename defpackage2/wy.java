package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@yx
public class wy {
    private final Collection<ww> a = new ArrayList();
    private final Collection<wx<String>> b = new ArrayList();
    private final Collection<wx<String>> c = new ArrayList();

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<wx<String>> it = this.b.iterator();
        while (it.hasNext()) {
            String strC = it.next().c();
            if (strC != null) {
                arrayList.add(strC);
            }
        }
        return arrayList;
    }

    public void a(ww wwVar) {
        this.a.add(wwVar);
    }

    public void a(wx<String> wxVar) {
        this.b.add(wxVar);
    }

    public void b(wx<String> wxVar) {
        this.c.add(wxVar);
    }
}
