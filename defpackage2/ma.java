package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ma {
    protected static final Comparator<byte[]> a = new Comparator<byte[]>() { // from class: ma.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> b = new LinkedList();
    private List<byte[]> c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public ma(int i) {
        this.e = i;
    }

    public synchronized byte[] a(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.c.size()) {
                bArr = this.c.get(i3);
                if (bArr.length < i) {
                    i2 = i3 + 1;
                } else {
                    this.d -= bArr.length;
                    this.c.remove(i3);
                    this.b.remove(bArr);
                    break;
                }
            } else {
                bArr = new byte[i];
                break;
            }
        }
        return bArr;
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.e) {
                this.b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.c, bArr, a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.c.add(iBinarySearch, bArr);
                this.d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.d > this.e) {
            byte[] bArrRemove = this.b.remove(0);
            this.c.remove(bArrRemove);
            this.d -= bArrRemove.length;
        }
    }
}
