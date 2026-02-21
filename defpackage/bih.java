package defpackage;

import android.net.NetworkInfo;
import defpackage.bif;
import defpackage.bit;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class bih extends ThreadPoolExecutor {
    bih() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new bit.e());
    }

    void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
        }
        switch (networkInfo.getType()) {
            case 0:
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        a(1);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                        a(2);
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        a(3);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        a(3);
                        break;
                }
                break;
            case 1:
            case 6:
            case 9:
                a(4);
                break;
            default:
                a(3);
                break;
        }
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((bho) runnable);
        execute(aVar);
        return aVar;
    }

    static final class a extends FutureTask<bho> implements Comparable<a> {
        private final bho a;

        public a(bho bhoVar) {
            super(bhoVar, null);
            this.a = bhoVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            bif.e eVarN = this.a.n();
            bif.e eVarN2 = aVar.a.n();
            return eVarN == eVarN2 ? this.a.a - aVar.a.a : eVarN2.ordinal() - eVarN.ordinal();
        }
    }
}
