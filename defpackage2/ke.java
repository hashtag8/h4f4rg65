package defpackage;

import defpackage.iq;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ke {
    final a a;

    interface a {
        iq.b a(int i, int i2, int i3, Object obj);

        void a(iq.b bVar);
    }

    ke(a aVar) {
        this.a = aVar;
    }

    void a(List<iq.b> list) {
        while (true) {
            int iB = b(list);
            if (iB != -1) {
                a(list, iB, iB + 1);
            } else {
                return;
            }
        }
    }

    private void a(List<iq.b> list, int i, int i2) {
        iq.b bVar = list.get(i);
        iq.b bVar2 = list.get(i2);
        switch (bVar2.a) {
            case 1:
                c(list, i, bVar, i2, bVar2);
                break;
            case 2:
                a(list, i, bVar, i2, bVar2);
                break;
            case 4:
                b(list, i, bVar, i2, bVar2);
                break;
        }
    }

    void a(List<iq.b> list, int i, iq.b bVar, int i2, iq.b bVar2) {
        boolean z;
        iq.b bVarA;
        boolean z2 = false;
        if (bVar.b < bVar.d) {
            z = bVar2.b == bVar.b && bVar2.d == bVar.d - bVar.b;
        } else if (bVar2.b == bVar.d + 1 && bVar2.d == bVar.b - bVar.d) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (bVar.d < bVar2.b) {
            bVar2.b--;
        } else if (bVar.d < bVar2.b + bVar2.d) {
            bVar2.d--;
            bVar.a = 2;
            bVar.d = 1;
            if (bVar2.d == 0) {
                list.remove(i2);
                this.a.a(bVar2);
                return;
            }
            return;
        }
        if (bVar.b <= bVar2.b) {
            bVar2.b++;
            bVarA = null;
        } else if (bVar.b < bVar2.b + bVar2.d) {
            bVarA = this.a.a(2, bVar.b + 1, (bVar2.b + bVar2.d) - bVar.b, null);
            bVar2.d = bVar.b - bVar2.b;
        } else {
            bVarA = null;
        }
        if (z) {
            list.set(i, bVar2);
            list.remove(i2);
            this.a.a(bVar);
            return;
        }
        if (z2) {
            if (bVarA != null) {
                if (bVar.b > bVarA.b) {
                    bVar.b -= bVarA.d;
                }
                if (bVar.d > bVarA.b) {
                    bVar.d -= bVarA.d;
                }
            }
            if (bVar.b > bVar2.b) {
                bVar.b -= bVar2.d;
            }
            if (bVar.d > bVar2.b) {
                bVar.d -= bVar2.d;
            }
        } else {
            if (bVarA != null) {
                if (bVar.b >= bVarA.b) {
                    bVar.b -= bVarA.d;
                }
                if (bVar.d >= bVarA.b) {
                    bVar.d -= bVarA.d;
                }
            }
            if (bVar.b >= bVar2.b) {
                bVar.b -= bVar2.d;
            }
            if (bVar.d >= bVar2.b) {
                bVar.d -= bVar2.d;
            }
        }
        list.set(i, bVar2);
        if (bVar.b != bVar.d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    private void c(List<iq.b> list, int i, iq.b bVar, int i2, iq.b bVar2) {
        int i3 = 0;
        if (bVar.d < bVar2.b) {
            i3 = -1;
        }
        if (bVar.b < bVar2.b) {
            i3++;
        }
        if (bVar2.b <= bVar.b) {
            bVar.b += bVar2.d;
        }
        if (bVar2.b <= bVar.d) {
            bVar.d += bVar2.d;
        }
        bVar2.b = i3 + bVar2.b;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void b(List<iq.b> list, int i, iq.b bVar, int i2, iq.b bVar2) {
        iq.b bVarA;
        iq.b bVarA2 = null;
        if (bVar.d < bVar2.b) {
            bVar2.b--;
            bVarA = null;
        } else if (bVar.d < bVar2.b + bVar2.d) {
            bVar2.d--;
            bVarA = this.a.a(4, bVar.b, 1, bVar2.c);
        } else {
            bVarA = null;
        }
        if (bVar.b <= bVar2.b) {
            bVar2.b++;
        } else if (bVar.b < bVar2.b + bVar2.d) {
            int i3 = (bVar2.b + bVar2.d) - bVar.b;
            bVarA2 = this.a.a(4, bVar.b + 1, i3, bVar2.c);
            bVar2.d -= i3;
        }
        list.set(i2, bVar);
        if (bVar2.d > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.a.a(bVar2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
        if (bVarA2 != null) {
            list.add(i, bVarA2);
        }
    }

    private int b(List<iq.b> list) {
        boolean z;
        boolean z2 = false;
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).a == 8) {
                if (z2) {
                    return size;
                }
                z = z2;
            } else {
                z = true;
            }
            size--;
            z2 = z;
        }
        return -1;
    }
}
