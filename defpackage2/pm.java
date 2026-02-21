package defpackage;

/* JADX INFO: loaded from: classes.dex */
class pm implements qb {
    private final int a;

    public pm(int i) {
        this.a = i;
    }

    @Override // defpackage.qb
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length > this.a) {
            int i = this.a / 2;
            int i2 = this.a - i;
            StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[this.a];
            System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i2);
            System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, stackTraceElementArr2, i2, i);
            return stackTraceElementArr2;
        }
        return stackTraceElementArr;
    }
}
