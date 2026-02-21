package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: classes.dex */
public class fo {
    private static final c a;
    private final AccessibilityRecord b;

    static class c {
        c() {
        }

        public void a(AccessibilityRecord accessibilityRecord, int i) {
        }

        public void b(AccessibilityRecord accessibilityRecord, int i) {
        }
    }

    static class a extends c {
        a() {
        }

        @Override // fo.c
        public void a(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        @Override // fo.c
        public void b(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        a.a(accessibilityRecord, i);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        a.b(accessibilityRecord, i);
    }

    @Deprecated
    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            fo foVar = (fo) obj;
            return this.b == null ? foVar.b == null : this.b.equals(foVar.b);
        }
        return false;
    }
}
