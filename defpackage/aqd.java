package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import defpackage.aqe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class aqd extends aqk {
    private Map<ady, aqe> a;
    private List<ady> b;

    public aqd(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new HashMap();
        this.b = new ArrayList();
    }

    public void a(ViewPager viewPager, List<ady> list) {
        if (this.b.equals(list)) {
            mm.b("Groups have not changed, not calling notifyDataSetChanged", new Object[0]);
            return;
        }
        ady adyVarB = aof.a().b();
        this.b = list;
        c();
        int iA = a(adyVarB);
        mm.b("notifyDataSetChanged, position changed from %s to %s", adyVarB, Integer.valueOf(iA));
        if (iA != -1) {
            viewPager.setCurrentItem(iA);
        }
    }

    @Override // defpackage.aqk
    public Fragment a(int i) {
        aqe aqeVar = new aqe();
        Bundle bundle = new Bundle();
        bundle.putSerializable(aqe.a.LINKED_GROUP.name(), this.b.get(i));
        aqeVar.setArguments(bundle);
        return aqeVar;
    }

    public aqe b(int i) {
        if (i >= this.b.size()) {
            return null;
        }
        return this.a.get(this.b.get(i));
    }

    public Collection<aqe> d() {
        ArrayList arrayList = new ArrayList();
        for (aqe aqeVar : this.a.values()) {
            if (aqeVar.getView() != null) {
                arrayList.add(aqeVar);
            } else {
                mm.b("getInstantiatedItems was called before the fragment transactions were committed for " + aqeVar, new Object[0]);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int a(ady adyVar) {
        return this.b.indexOf(adyVar);
    }

    public ady e(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // defpackage.ex
    public int a(Object obj) {
        int iIndexOf = this.b.indexOf(((aqe) obj).b());
        if (iIndexOf == -1) {
            return -2;
        }
        return iIndexOf;
    }

    @Override // defpackage.aqk, defpackage.ex
    public Object a(ViewGroup viewGroup, int i) {
        aqe aqeVar = (aqe) super.a(viewGroup, i);
        ady adyVar = (ady) aqeVar.getArguments().getSerializable(aqe.a.LINKED_GROUP.name());
        mm.b("Creating new item for %s %s", Integer.valueOf(i), adyVar);
        this.a.put(adyVar, aqeVar);
        return aqeVar;
    }

    @Override // defpackage.aqk, defpackage.ex
    public void a(ViewGroup viewGroup, int i, Object obj) {
        super.a(viewGroup, i, obj);
        this.a.remove(((aqe) obj).b());
    }

    @Override // defpackage.ex
    public int b() {
        return this.b.size();
    }
}
