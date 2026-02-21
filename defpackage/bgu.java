package defpackage;

import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface bgu extends Closeable {

    public interface a {
        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<bgw> list);

        void a(int i, long j);

        void a(int i, bgt bgtVar);

        void a(int i, bgt bgtVar, bqv bqvVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, bqu bquVar, int i2);

        void a(boolean z, bhf bhfVar);

        void a(boolean z, boolean z2, int i, int i2, List<bgw> list, bgx bgxVar);

        void b();
    }

    void a();

    boolean a(a aVar);
}
