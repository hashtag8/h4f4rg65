package defpackage;

/* JADX INFO: loaded from: classes.dex */
class pl implements qb {
    private final int a;
    private final qb[] b;
    private final pm c;

    public pl(int i, qb... qbVarArr) {
        this.a = i;
        this.b = qbVarArr;
        this.c = new pm(i);
    }

    @Override // defpackage.qb
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length > this.a) {
            qb[] qbVarArr = this.b;
            int length = qbVarArr.length;
            int i = 0;
            StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
            while (i < length) {
                qb qbVar = qbVarArr[i];
                if (stackTraceElementArrA.length <= this.a) {
                    break;
                }
                i++;
                stackTraceElementArrA = qbVar.a(stackTraceElementArr);
            }
            if (stackTraceElementArrA.length > this.a) {
                stackTraceElementArrA = this.c.a(stackTraceElementArrA);
            }
            return stackTraceElementArrA;
        }
        return stackTraceElementArr;
    }
}
