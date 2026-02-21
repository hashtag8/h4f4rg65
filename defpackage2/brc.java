package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class brc {
    private static final Logger a = Logger.getLogger(brc.class.getName());

    private brc() {
    }

    public static bqu a(bri briVar) {
        if (briVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        return new bre(briVar);
    }

    public static bqt a(brh brhVar) {
        if (brhVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        return new brd(brhVar);
    }

    public static brh a(OutputStream outputStream) {
        return a(outputStream, new brj());
    }

    private static brh a(final OutputStream outputStream, final brj brjVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (brjVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new brh() { // from class: brc.1
            @Override // defpackage.brh
            public void a_(bqs bqsVar, long j) throws IOException {
                brk.a(bqsVar.b, 0L, j);
                while (j > 0) {
                    brjVar.g();
                    brf brfVar = bqsVar.a;
                    int iMin = (int) Math.min(j, brfVar.c - brfVar.b);
                    outputStream.write(brfVar.a, brfVar.b, iMin);
                    brfVar.b += iMin;
                    j -= (long) iMin;
                    bqsVar.b -= (long) iMin;
                    if (brfVar.b == brfVar.c) {
                        bqsVar.a = brfVar.a();
                        brg.a(brfVar);
                    }
                }
            }

            @Override // defpackage.brh, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // defpackage.brh
            public brj a() {
                return brjVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static brh a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        bqq bqqVarC = c(socket);
        return bqqVarC.a(a(socket.getOutputStream(), bqqVarC));
    }

    public static bri a(InputStream inputStream) {
        return a(inputStream, new brj());
    }

    private static bri a(final InputStream inputStream, final brj brjVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (brjVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new bri() { // from class: brc.2
            @Override // defpackage.bri
            public long a(bqs bqsVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                brjVar.g();
                brf brfVarE = bqsVar.e(1);
                int i = inputStream.read(brfVarE.a, brfVarE.c, (int) Math.min(j, 2048 - brfVarE.c));
                if (i == -1) {
                    return -1L;
                }
                brfVarE.c += i;
                bqsVar.b += (long) i;
                return i;
            }

            @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // defpackage.bri
            public brj a() {
                return brjVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static bri a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static brh b(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static brh c(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }

    public static bri b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        bqq bqqVarC = c(socket);
        return bqqVarC.a(a(socket.getInputStream(), bqqVarC));
    }

    private static bqq c(final Socket socket) {
        return new bqq() { // from class: brc.3
            @Override // defpackage.bqq
            protected void a() {
                try {
                    socket.close();
                } catch (Exception e) {
                    brc.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                }
            }
        };
    }
}
