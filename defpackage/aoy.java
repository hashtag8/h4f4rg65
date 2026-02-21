package defpackage;

import android.content.res.Resources;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class aoy {
    protected Resources a;
    protected List<Byte> b = new ArrayList();
    protected List<String> c = new ArrayList();

    public abstract String a(SortedSet<String> sortedSet, List<adx> list);

    public abstract void a();

    public abstract void a(RoomItem roomItem);

    public abstract boolean a(List<adx> list);

    public abstract String b();

    public abstract void b(RoomItem roomItem);

    public abstract boolean b(List<adx> list);

    public aoy() {
        a();
    }

    public void c(List<adx> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!this.b.contains(Byte.valueOf(list.get(i2).q()))) {
                    list.remove(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public int d(List<adx> list) {
        int i = 0;
        Iterator<adx> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = this.b.contains(Byte.valueOf(it.next().q())) ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }
}
