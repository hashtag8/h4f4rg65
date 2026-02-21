package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.support.v8.renderscript.Allocation;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public class fk {
    static final i a;
    public int b = -1;
    private final AccessibilityNodeInfo c;

    public static class j {
        final Object a;

        public static j a(int i, int i2, boolean z, int i3) {
            return new j(fk.a.a(i, i2, z, i3));
        }

        j(Object obj) {
            this.a = obj;
        }
    }

    public static class k {
        final Object a;

        public static k a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new k(fk.a.a(i, i2, i3, i4, z, z2));
        }

        k(Object obj) {
            this.a = obj;
        }
    }

    static class i {
        i() {
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }
    }

    static class a extends i {
        a() {
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }

        @Override // fk.i
        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }
    }

    static class d extends c {
        d() {
        }

        @Override // fk.i
        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
        }

        @Override // fk.i
        public Object a(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
        }

        @Override // fk.i
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        @Override // fk.i
        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
        }
    }

    static class e extends d {
        e() {
        }

        @Override // fk.d, fk.i
        public Object a(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
        }

        @Override // fk.d, fk.i
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }
    }

    static class f extends e {
        f() {
        }
    }

    static class g extends f {
        g() {
        }
    }

    static class h extends g {
        h() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            a = new g();
            return;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            a = new f();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new e();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new i();
        }
    }

    private fk(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.c = accessibilityNodeInfo;
    }

    public static fk a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new fk(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.c;
    }

    public int b() {
        return this.c.getActions();
    }

    public void a(int i2) {
        this.c.addAction(i2);
    }

    public void a(Rect rect) {
        this.c.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.c.getBoundsInScreen(rect);
    }

    public boolean c() {
        return this.c.isCheckable();
    }

    public void a(boolean z) {
        this.c.setCheckable(z);
    }

    public boolean d() {
        return this.c.isChecked();
    }

    public void b(boolean z) {
        this.c.setChecked(z);
    }

    public boolean e() {
        return this.c.isFocusable();
    }

    public boolean f() {
        return this.c.isFocused();
    }

    public boolean g() {
        return this.c.isSelected();
    }

    public boolean h() {
        return this.c.isClickable();
    }

    public boolean i() {
        return this.c.isLongClickable();
    }

    public boolean j() {
        return this.c.isEnabled();
    }

    public boolean k() {
        return this.c.isPassword();
    }

    public boolean l() {
        return this.c.isScrollable();
    }

    public void c(boolean z) {
        this.c.setScrollable(z);
    }

    public CharSequence m() {
        return this.c.getPackageName();
    }

    public CharSequence n() {
        return this.c.getClassName();
    }

    public void a(CharSequence charSequence) {
        this.c.setClassName(charSequence);
    }

    public CharSequence o() {
        return this.c.getText();
    }

    public CharSequence p() {
        return this.c.getContentDescription();
    }

    public String q() {
        return a.a(this.c);
    }

    public void a(Object obj) {
        a.a(this.c, ((j) obj).a);
    }

    public void b(Object obj) {
        a.b(this.c, ((k) obj).a);
    }

    public int hashCode() {
        if (this.c == null) {
            return 0;
        }
        return this.c.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            fk fkVar = (fk) obj;
            return this.c == null ? fkVar.c == null : this.c.equals(fkVar.c);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(m());
        sb.append("; className: ").append(n());
        sb.append("; text: ").append(o());
        sb.append("; contentDescription: ").append(p());
        sb.append("; viewId: ").append(q());
        sb.append("; checkable: ").append(c());
        sb.append("; checked: ").append(d());
        sb.append("; focusable: ").append(e());
        sb.append("; focused: ").append(f());
        sb.append("; selected: ").append(g());
        sb.append("; clickable: ").append(h());
        sb.append("; longClickable: ").append(i());
        sb.append("; enabled: ").append(j());
        sb.append("; password: ").append(k());
        sb.append("; scrollable: " + l());
        sb.append("; [");
        int iB = b();
        while (iB != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iB);
            iB &= iNumberOfTrailingZeros ^ (-1);
            sb.append(b(iNumberOfTrailingZeros));
            if (iB != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String b(int i2) {
        switch (i2) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case Allocation.USAGE_SHARED /* 128 */:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
