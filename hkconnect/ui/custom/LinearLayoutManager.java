package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import defpackage.fb;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends android.support.v7.widget.LinearLayoutManager {
    private static boolean a = true;
    private static Field b = null;
    private final int[] c;
    private final RecyclerView d;
    private int e;
    private boolean f;
    private int g;
    private final Rect h;

    public LinearLayoutManager(Context context) {
        super(context);
        this.c = new int[2];
        this.e = 100;
        this.g = 0;
        this.h = new Rect();
        this.d = null;
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.c = new int[2];
        this.e = 100;
        this.g = 0;
        this.h = new Rect();
        this.d = null;
    }

    public LinearLayoutManager(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.c = new int[2];
        this.e = 100;
        this.g = 0;
        this.h = new Rect();
        this.d = recyclerView;
        this.g = fb.a(recyclerView);
    }

    public LinearLayoutManager(RecyclerView recyclerView, int i, boolean z) {
        super(recyclerView.getContext(), i, z);
        this.c = new int[2];
        this.e = 100;
        this.g = 0;
        this.h = new Rect();
        this.d = recyclerView;
        this.g = fb.a(recyclerView);
    }

    public static int K() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2) {
        int i3;
        int i4;
        int iMin;
        int iA;
        int i5;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = mode != 0;
        boolean z2 = mode2 != 0;
        boolean z3 = mode == 1073741824;
        boolean z4 = mode2 == 1073741824;
        int iK = K();
        if (z3 && z4) {
            super.a(oVar, sVar, i, i2);
            return;
        }
        boolean z5 = f() == 1;
        a(size, size2, z5);
        int i6 = 0;
        int i7 = 0;
        oVar.a();
        int iE = sVar.e();
        int iE2 = E();
        int i8 = 0;
        while (true) {
            if (i8 >= iE2) {
                i3 = i7;
                i4 = i6;
                break;
            }
            if (z5) {
                if (!this.f) {
                    if (i8 < iE) {
                        a(oVar, i8, size, iK, this.c);
                    } else {
                        a(i8);
                    }
                }
                i5 = this.c[1] + i7;
                i4 = i8 == 0 ? this.c[0] : i6;
                if (z2 && i5 >= size2) {
                    i3 = i5;
                    break;
                } else {
                    i8++;
                    i7 = i5;
                    i6 = i4;
                }
            } else {
                if (!this.f) {
                    if (i8 < iE) {
                        a(oVar, i8, iK, size2, this.c);
                    } else {
                        a(i8);
                    }
                }
                i4 = i6 + this.c[0];
                i5 = i8 == 0 ? this.c[1] : i7;
                if (z && i4 >= size) {
                    i3 = i5;
                    break;
                } else {
                    i8++;
                    i7 = i5;
                    i6 = i4;
                }
            }
        }
        if (z3) {
            iMin = size;
        } else {
            int iZ = z() + B() + i4;
            iMin = z ? Math.min(iZ, size) : iZ;
        }
        if (z4) {
            iA = size2;
        } else {
            iA = A() + C() + i3;
            if (z2) {
                iA = Math.min(iA, size2);
            }
        }
        f(iMin, iA);
        if (this.d != null && this.g == 1) {
            fb.b(this.d, (z5 && (!z2 || iA < size2)) || (!z5 && (!z || iMin < size)) ? 2 : 0);
        }
    }

    private void a(int i) {
    }

    private void a(int i, int i2, boolean z) {
        if (this.c[0] == 0 && this.c[1] == 0) {
            if (z) {
                this.c[0] = i;
                this.c[1] = this.e;
            } else {
                this.c[0] = this.e;
                this.c[1] = i2;
            }
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void b(int i) {
        if (this.c != null && f() != i) {
            this.c[0] = 0;
            this.c[1] = 0;
        }
        super.b(i);
    }

    private void a(RecyclerView.o oVar, int i, int i2, int i3, int[] iArr) {
        try {
            View viewC = oVar.c(i);
            RecyclerView.i iVar = (RecyclerView.i) viewC.getLayoutParams();
            int iZ = z() + B();
            int iA = A() + C();
            int i4 = iVar.leftMargin + iVar.rightMargin;
            int i5 = iVar.topMargin + iVar.bottomMargin;
            b(iVar);
            b(viewC, this.h);
            viewC.measure(a(i2, iZ + i4 + o(viewC) + n(viewC), iVar.width, d()), a(i3, iA + i5 + l(viewC) + m(viewC), iVar.height, e()));
            iArr[0] = f(viewC) + iVar.leftMargin + iVar.rightMargin;
            iArr[1] = g(viewC) + iVar.bottomMargin + iVar.topMargin;
            b(iVar);
            oVar.a(viewC);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private static void b(RecyclerView.i iVar) {
        if (a) {
            try {
                if (b == null) {
                    b = RecyclerView.i.class.getDeclaredField("e");
                    b.setAccessible(true);
                }
                b.set(iVar, true);
            } catch (IllegalAccessException e) {
                L();
            } catch (NoSuchFieldException e2) {
                L();
            }
        }
    }

    private static void L() {
        a = false;
    }
}
