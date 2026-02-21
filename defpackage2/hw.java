package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.ha;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class hw implements dc {
    private static final int[] d = {1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ContextMenu.ContextMenuInfo q;
    private hy y;
    private boolean z;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<hy> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<id>> x = new CopyOnWriteArrayList<>();
    private ArrayList<hy> j = new ArrayList<>();
    private ArrayList<hy> k = new ArrayList<>();
    private boolean l = true;
    private ArrayList<hy> m = new ArrayList<>();
    private ArrayList<hy> n = new ArrayList<>();
    private boolean o = true;

    public interface a {
        void a(hw hwVar);

        boolean a(hw hwVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(hy hyVar);
    }

    public hw(Context context) {
        this.e = context;
        this.f = context.getResources();
        e(true);
    }

    public hw a(int i) {
        this.p = i;
        return this;
    }

    public void a(id idVar) {
        a(idVar, this.e);
    }

    public void a(id idVar, Context context) {
        this.x.add(new WeakReference<>(idVar));
        idVar.a(context, this);
        this.o = true;
    }

    public void b(id idVar) {
        for (WeakReference<id> weakReference : this.x) {
            id idVar2 = weakReference.get();
            if (idVar2 == null || idVar2 == idVar) {
                this.x.remove(weakReference);
            }
        }
    }

    private void d(boolean z) {
        if (!this.x.isEmpty()) {
            g();
            for (WeakReference<id> weakReference : this.x) {
                id idVar = weakReference.get();
                if (idVar == null) {
                    this.x.remove(weakReference);
                } else {
                    idVar.b(z);
                }
            }
            h();
        }
    }

    private boolean a(ij ijVar, id idVar) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean zA = idVar != null ? idVar.a(ijVar) : false;
        Iterator<WeakReference<id>> it = this.x.iterator();
        while (true) {
            boolean zA2 = zA;
            if (!it.hasNext()) {
                return zA2;
            }
            WeakReference<id> next = it.next();
            id idVar2 = next.get();
            if (idVar2 == null) {
                this.x.remove(next);
            } else if (!zA2) {
                zA2 = idVar2.a(ijVar);
            }
            zA = zA2;
        }
    }

    public void a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray<? extends Parcelable> sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray<? extends Parcelable> sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ij) item.getSubMenu()).a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void b(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ij) item.getSubMenu()).b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (menuItemFindItem = findItem(i2)) != null) {
                menuItemFindItem.expandActionView();
            }
        }
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iF = f(i3);
        hy hyVarA = a(i, i2, i3, iF, charSequence, this.p);
        if (this.q != null) {
            hyVarA.a(this.q);
        }
        this.j.add(a(this.j, iF), hyVarA);
        b(true);
        return hyVarA;
    }

    private hy a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new hy(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        hy hyVar = (hy) a(i, i2, i3, charSequence);
        ij ijVar = new ij(this.e, this, hyVar);
        hyVar.a(ijVar);
        return ijVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iC = c(i);
        if (iC >= 0) {
            int size = this.j.size() - iC;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.j.get(iC).getGroupId() != i) {
                    break;
                }
                a(iC, false);
                i2 = i3;
            }
            b(true);
        }
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.y != null) {
            d(this.y);
        }
        this.j.clear();
        b(true);
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        g();
        for (int i = 0; i < size; i++) {
            hy hyVar = this.j.get(i);
            if (hyVar.getGroupId() == groupId && hyVar.g() && hyVar.isCheckable()) {
                hyVar.b(hyVar == menuItem);
            }
        }
        h();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            hy hyVar = this.j.get(i2);
            if (hyVar.getGroupId() == i) {
                hyVar.a(z2);
                hyVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            hy hyVar = this.j.get(i2);
            i2++;
            z2 = (hyVar.getGroupId() == i && hyVar.c(z)) ? true : z2;
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            hy hyVar = this.j.get(i2);
            if (hyVar.getGroupId() == i) {
                hyVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            hy hyVar = this.j.get(i2);
            if (hyVar.getItemId() != i) {
                if (hyVar.hasSubMenu() && (menuItemFindItem = hyVar.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return hyVar;
            }
        }
        return null;
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.j.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.j.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    private static int f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (d[i2] << 16) | (65535 & i);
    }

    boolean b() {
        return this.g;
    }

    private void e(boolean z) {
        this.h = z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(ha.b.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    public boolean c() {
        return this.h;
    }

    Resources d() {
        return this.f;
    }

    public Context e() {
        return this.e;
    }

    boolean a(hw hwVar, MenuItem menuItem) {
        return this.i != null && this.i.a(hwVar, menuItem);
    }

    public void f() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    private static int a(ArrayList<hy> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        hy hyVarA = a(i, keyEvent);
        boolean zA = false;
        if (hyVarA != null) {
            zA = a(hyVarA, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return zA;
    }

    void a(List<hy> list, int i, KeyEvent keyEvent) {
        boolean zB = b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                hy hyVar = this.j.get(i2);
                if (hyVar.hasSubMenu()) {
                    ((hw) hyVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = zB ? hyVar.getAlphabeticShortcut() : hyVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zB ? hyVar.getAlphabeticModifiers() : hyVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zB && alphabeticShortcut == '\b' && i == 67)) && hyVar.isEnabled())) {
                    list.add(hyVar);
                }
            }
        }
    }

    hy a(int i, KeyEvent keyEvent) {
        ArrayList<hy> arrayList = this.w;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zB = b();
        for (int i2 = 0; i2 < size; i2++) {
            hy hyVar = arrayList.get(i2);
            char alphabeticShortcut = zB ? hyVar.getAlphabeticShortcut() : hyVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hyVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hyVar;
            }
            if (zB && alphabeticShortcut == '\b' && i == 67) {
                return hyVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (id) null, i);
    }

    public boolean a(MenuItem menuItem, id idVar, int i) {
        hy hyVar = (hy) menuItem;
        if (hyVar == null || !hyVar.isEnabled()) {
            return false;
        }
        boolean zB = hyVar.b();
        ej ejVarA = hyVar.a();
        boolean z = ejVarA != null && ejVarA.e();
        if (hyVar.n()) {
            boolean zExpandActionView = hyVar.expandActionView() | zB;
            if (zExpandActionView) {
                a(true);
                return zExpandActionView;
            }
            return zExpandActionView;
        }
        if (hyVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                a(false);
            }
            if (!hyVar.hasSubMenu()) {
                hyVar.a(new ij(e(), this, hyVar));
            }
            ij ijVar = (ij) hyVar.getSubMenu();
            if (z) {
                ejVarA.a(ijVar);
            }
            boolean zA = a(ijVar, idVar) | zB;
            if (!zA) {
                a(true);
                return zA;
            }
            return zA;
        }
        if ((i & 1) == 0) {
            a(true);
        }
        return zB;
    }

    public final void a(boolean z) {
        if (!this.v) {
            this.v = true;
            for (WeakReference<id> weakReference : this.x) {
                id idVar = weakReference.get();
                if (idVar == null) {
                    this.x.remove(weakReference);
                } else {
                    idVar.a(this, z);
                }
            }
            this.v = false;
        }
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    public void b(boolean z) {
        if (!this.r) {
            if (z) {
                this.l = true;
                this.o = true;
            }
            d(z);
            return;
        }
        this.s = true;
        if (z) {
            this.t = true;
        }
    }

    public void g() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    void a(hy hyVar) {
        this.l = true;
        b(true);
    }

    void b(hy hyVar) {
        this.o = true;
        b(true);
    }

    public ArrayList<hy> i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            hy hyVar = this.j.get(i);
            if (hyVar.isVisible()) {
                this.k.add(hyVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void j() {
        boolean zB;
        ArrayList<hy> arrayListI = i();
        if (this.o) {
            boolean z = false;
            for (WeakReference<id> weakReference : this.x) {
                id idVar = weakReference.get();
                if (idVar == null) {
                    this.x.remove(weakReference);
                    zB = z;
                } else {
                    zB = idVar.b() | z;
                }
                z = zB;
            }
            if (z) {
                this.m.clear();
                this.n.clear();
                int size = arrayListI.size();
                for (int i = 0; i < size; i++) {
                    hy hyVar = arrayListI.get(i);
                    if (hyVar.j()) {
                        this.m.add(hyVar);
                    } else {
                        this.n.add(hyVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList<hy> k() {
        j();
        return this.m;
    }

    public ArrayList<hy> l() {
        j();
        return this.n;
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesD = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = resourcesD.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = ci.a(e(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    protected hw a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected hw d(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    protected hw a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected hw e(int i) {
        a(0, null, i, null, null);
        return this;
    }

    protected hw a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public hw p() {
        return this;
    }

    boolean q() {
        return this.u;
    }

    public boolean c(hy hyVar) {
        boolean zA = false;
        if (!this.x.isEmpty()) {
            g();
            Iterator<WeakReference<id>> it = this.x.iterator();
            while (true) {
                boolean z = zA;
                if (!it.hasNext()) {
                    zA = z;
                    break;
                }
                WeakReference<id> next = it.next();
                id idVar = next.get();
                if (idVar == null) {
                    this.x.remove(next);
                    zA = z;
                } else {
                    zA = idVar.a(this, hyVar);
                    if (zA) {
                        break;
                    }
                }
            }
            h();
            if (zA) {
                this.y = hyVar;
            }
        }
        return zA;
    }

    public boolean d(hy hyVar) {
        boolean zB = false;
        if (!this.x.isEmpty() && this.y == hyVar) {
            g();
            Iterator<WeakReference<id>> it = this.x.iterator();
            while (true) {
                boolean z = zB;
                if (!it.hasNext()) {
                    zB = z;
                    break;
                }
                WeakReference<id> next = it.next();
                id idVar = next.get();
                if (idVar == null) {
                    this.x.remove(next);
                    zB = z;
                } else {
                    zB = idVar.b(this, hyVar);
                    if (zB) {
                        break;
                    }
                }
            }
            h();
            if (zB) {
                this.y = null;
            }
        }
        return zB;
    }

    public hy r() {
        return this.y;
    }

    public void c(boolean z) {
        this.z = z;
    }
}
