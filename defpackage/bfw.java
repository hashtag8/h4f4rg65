package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class bfw {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final Charset c = Charset.forName(HTTP.UTF_8);

    public static int a(URI uri) {
        return a(uri.getScheme(), uri.getPort());
    }

    public static int a(URL url) {
        return a(url.getProtocol(), url.getPort());
    }

    private static int a(String str, int i) {
        return i != -1 ? i : a(str);
    }

    public static int a(String str) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Closeable closeable, Closeable closeable2) throws IOException {
        Throwable th = null;
        try {
            closeable.close();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            closeable2.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        if (th == null) {
            return;
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new AssertionError(th);
        }
        throw ((Error) th);
    }

    public static boolean a(bri briVar, int i, TimeUnit timeUnit) {
        try {
            return b(briVar, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean b(bri briVar, int i, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jD = briVar.a().h_() ? briVar.a().d() - jNanoTime : Long.MAX_VALUE;
        briVar.a().a(Math.min(jD, timeUnit.toNanos(i)) + jNanoTime);
        try {
            bqs bqsVar = new bqs();
            while (briVar.a(bqsVar, 2048L) != -1) {
                bqsVar.t();
            }
            if (jD == Long.MAX_VALUE) {
                briVar.a().f();
            } else {
                briVar.a().a(jD + jNanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (jD == Long.MAX_VALUE) {
                briVar.a().f();
            } else {
                briVar.a().a(jD + jNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jD == Long.MAX_VALUE) {
                briVar.a().f();
            } else {
                briVar.a().a(jD + jNanoTime);
            }
            throw th;
        }
    }

    public static String b(String str) {
        try {
            return bqv.a(MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8))).d();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static bqv a(bqv bqvVar) {
        try {
            return bqv.a(MessageDigest.getInstance("SHA-1").digest(bqvVar.g()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: bfw.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List listA = a((Object[]) tArr, (Object[]) tArr2);
        return (T[]) listA.toArray((Object[]) Array.newInstance((Class<?>) cls, listA.size()));
    }

    private static <T> List<T> a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    T t2 = tArr2[i];
                    if (!t.equals(t2)) {
                        i++;
                    } else {
                        arrayList.add(t2);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }
}
