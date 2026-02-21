package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public class bfu {
    private static final bfu a = c();

    public static bfu a() {
        return a;
    }

    public String b() {
        return "OkHttp";
    }

    public void a(String str) {
        System.out.println(str);
    }

    public void a(Socket socket) {
    }

    public void b(Socket socket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<bff> list) {
    }

    public void a(SSLSocket sSLSocket) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    private static bfu c() {
        bft bftVar;
        Method method;
        Method method2;
        Method method3;
        bft bftVar2;
        Method method4;
        bft bftVar3;
        Class<?> cls;
        Method method5;
        bft bftVar4;
        bft bftVar5;
        bft bftVar6;
        bft bftVar7;
        try {
            try {
                Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e) {
                Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            }
            bft bftVar8 = new bft(null, "setUseSessionTickets", Boolean.TYPE);
            bft bftVar9 = new bft(null, "setHostname", String.class);
            try {
                cls = Class.forName("android.net.TrafficStats");
                method5 = cls.getMethod("tagSocket", Socket.class);
            } catch (ClassNotFoundException e2) {
                method3 = null;
            } catch (NoSuchMethodException e3) {
                bftVar = null;
                method = null;
                method2 = null;
            }
            try {
                Method method6 = cls.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    bftVar7 = new bft(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                } catch (ClassNotFoundException e4) {
                    bftVar4 = null;
                } catch (NoSuchMethodException e5) {
                    bftVar = null;
                    method = method6;
                    method2 = method5;
                }
                try {
                    bftVar6 = new bft(null, "setAlpnProtocols", byte[].class);
                    bftVar5 = bftVar7;
                } catch (ClassNotFoundException e6) {
                    bftVar4 = bftVar7;
                    bftVar5 = bftVar4;
                    bftVar6 = null;
                } catch (NoSuchMethodException e7) {
                    bftVar = bftVar7;
                    method = method6;
                    method2 = method5;
                    bftVar2 = null;
                    method4 = method2;
                    bftVar3 = bftVar;
                    return new a(bftVar8, bftVar9, method4, method, bftVar3, bftVar2);
                }
                method = method6;
                bftVar3 = bftVar5;
                method4 = method5;
                bftVar2 = bftVar6;
            } catch (ClassNotFoundException e8) {
                method3 = method5;
                method = null;
                method2 = method3;
                bftVar = null;
            } catch (NoSuchMethodException e9) {
                bftVar = null;
                method = null;
                method2 = method5;
            }
            return new a(bftVar8, bftVar9, method4, method, bftVar3, bftVar2);
        } catch (ClassNotFoundException e10) {
            try {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                return new b(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException e11) {
                return new bfu();
            }
        }
    }

    static class a extends bfu {
        private final bft<Socket> a;
        private final bft<Socket> b;
        private final Method c;
        private final Method d;
        private final bft<Socket> e;
        private final bft<Socket> f;

        public a(bft<Socket> bftVar, bft<Socket> bftVar2, Method method, Method method2, bft<Socket> bftVar3, bft<Socket> bftVar4) {
            this.a = bftVar;
            this.b = bftVar2;
            this.c = method;
            this.d = method2;
            this.e = bftVar3;
            this.f = bftVar4;
        }

        @Override // defpackage.bfu
        public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (SecurityException e) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e);
                throw iOException;
            }
        }

        @Override // defpackage.bfu
        public void a(SSLSocket sSLSocket, String str, List<bff> list) {
            if (str != null) {
                this.a.b(sSLSocket, true);
                this.b.b(sSLSocket, str);
            }
            if (this.f != null && this.f.a(sSLSocket)) {
                this.f.d(sSLSocket, a(list));
            }
        }

        @Override // defpackage.bfu
        public String b(SSLSocket sSLSocket) {
            if (this.e == null || !this.e.a(sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.e.d(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, bfw.c) : null;
        }

        @Override // defpackage.bfu
        public void a(Socket socket) {
            if (this.c != null) {
                try {
                    this.c.invoke(null, socket);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }

        @Override // defpackage.bfu
        public void b(Socket socket) {
            if (this.d != null) {
                try {
                    this.d.invoke(null, socket);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }
    }

    static class b extends bfu {
        private final Method a;
        private final Method b;
        private final Method c;
        private final Class<?> d;
        private final Class<?> e;

        public b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.a = method;
            this.b = method2;
            this.c = method3;
            this.d = cls;
            this.e = cls2;
        }

        @Override // defpackage.bfu
        public void a(SSLSocket sSLSocket, String str, List<bff> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                bff bffVar = list.get(i);
                if (bffVar != bff.HTTP_1_0) {
                    arrayList.add(bffVar.toString());
                }
            }
            try {
                this.a.invoke(null, sSLSocket, Proxy.newProxyInstance(bfu.class.getClassLoader(), new Class[]{this.d, this.e}, new c(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }

        @Override // defpackage.bfu
        public void a(SSLSocket sSLSocket) {
            try {
                this.c.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.bfu
        public String b(SSLSocket sSLSocket) {
            try {
                c cVar = (c) Proxy.getInvocationHandler(this.b.invoke(null, sSLSocket));
                if (!cVar.b && cVar.c == null) {
                    bfp.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                return cVar.b ? null : cVar.c;
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError();
            }
        }
    }

    static class c implements InvocationHandler {
        private final List<String> a;
        private boolean b;
        private String c;

        public c(List<String> list) {
            this.a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = bfw.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.c = str;
                        return str;
                    }
                }
                String str2 = this.a.get(0);
                this.c = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.c = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    static byte[] a(List<bff> list) {
        bqs bqsVar = new bqs();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bff bffVar = list.get(i);
            if (bffVar != bff.HTTP_1_0) {
                bqsVar.h(bffVar.toString().length());
                bqsVar.b(bffVar.toString());
            }
        }
        return bqsVar.s();
    }
}
