package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: classes.dex */
public class ei {
    private static final b a;
    private static final View.AccessibilityDelegate c;
    final View.AccessibilityDelegate b = a.a(this);

    static class b {
        b() {
        }

        public View.AccessibilityDelegate a(final ei eiVar) {
            return new View.AccessibilityDelegate() { // from class: ei.b.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return eiVar.c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.a(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    eiVar.a(view, fk.a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return eiVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    eiVar.a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.b(view, accessibilityEvent);
                }
            };
        }

        public fl a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class a extends b {
        a() {
        }

        @Override // ei.b
        public View.AccessibilityDelegate a(final ei eiVar) {
            return new View.AccessibilityDelegate() { // from class: ei.a.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return eiVar.c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.a(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    eiVar.a(view, fk.a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return eiVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    eiVar.a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    eiVar.b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    fl flVarA = eiVar.a(view);
                    if (flVarA != null) {
                        return (AccessibilityNodeProvider) flVarA.a();
                    }
                    return null;
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return eiVar.a(view, i, bundle);
                }
            };
        }

        @Override // ei.b
        public fl a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new fl(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // ei.b
        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new b();
        }
        c = new View.AccessibilityDelegate();
    }

    View.AccessibilityDelegate a() {
        return this.b;
    }

    public void a(View view, int i) {
        c.sendAccessibilityEvent(view, i);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean c(View view, AccessibilityEvent accessibilityEvent) {
        return c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, fk fkVar) {
        c.onInitializeAccessibilityNodeInfo(view, fkVar.a());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public fl a(View view) {
        return a.a(c, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return a.a(c, view, i, bundle);
    }
}
