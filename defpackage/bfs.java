package defpackage;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes.dex */
public interface bfs {
    public static final bfs a = new bfs() { // from class: bfs.1
        @Override // defpackage.bfs
        public InetAddress[] a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("host == null");
            }
            return InetAddress.getAllByName(str);
        }
    };

    InetAddress[] a(String str);
}
