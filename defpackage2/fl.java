package defpackage;

import android.os.Build;
import android.os.Bundle;
import defpackage.fm;
import defpackage.fn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fl {
    private static final a a;
    private final Object b;

    interface a {
        Object a(fl flVar);
    }

    static class d implements a {
        d() {
        }

        @Override // fl.a
        public Object a(fl flVar) {
            return null;
        }
    }

    static class b extends d {
        b() {
        }

        @Override // fl.d, fl.a
        public Object a(final fl flVar) {
            return fm.a(new fm.a() { // from class: fl.b.1
                @Override // fm.a
                public boolean a(int i, int i2, Bundle bundle) {
                    return flVar.a(i, i2, bundle);
                }

                @Override // fm.a
                public List<Object> a(String str, int i) {
                    List<fk> listA = flVar.a(str, i);
                    if (listA == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = listA.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listA.get(i2).a());
                    }
                    return arrayList;
                }

                @Override // fm.a
                public Object a(int i) {
                    fk fkVarA = flVar.a(i);
                    if (fkVarA == null) {
                        return null;
                    }
                    return fkVarA.a();
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        @Override // fl.d, fl.a
        public Object a(final fl flVar) {
            return fn.a(new fn.a() { // from class: fl.c.1
                @Override // fn.a
                public boolean a(int i, int i2, Bundle bundle) {
                    return flVar.a(i, i2, bundle);
                }

                @Override // fn.a
                public List<Object> a(String str, int i) {
                    List<fk> listA = flVar.a(str, i);
                    if (listA == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = listA.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listA.get(i2).a());
                    }
                    return arrayList;
                }

                @Override // fn.a
                public Object a(int i) {
                    fk fkVarA = flVar.a(i);
                    if (fkVarA == null) {
                        return null;
                    }
                    return fkVarA.a();
                }

                @Override // fn.a
                public Object b(int i) {
                    fk fkVarB = flVar.b(i);
                    if (fkVarB == null) {
                        return null;
                    }
                    return fkVarB.a();
                }
            });
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new c();
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new d();
        }
    }

    public fl() {
        this.b = a.a(this);
    }

    public fl(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public fk a(int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<fk> a(String str, int i) {
        return null;
    }

    public fk b(int i) {
        return null;
    }
}
