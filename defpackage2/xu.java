package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xu {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat b = new DecimalFormat("#,###");
    private zp c;
    private File d;
    private boolean e;

    public xu(zp zpVar) {
        this.c = zpVar;
        File cacheDir = zpVar.getContext().getCacheDir();
        if (cacheDir == null) {
            su.e("Context.getCacheDir() returned null");
            return;
        }
        this.d = new File(cacheDir, "admobVideoStreams");
        if (!this.d.isDirectory() && !this.d.mkdirs()) {
            su.e("Could not create preload cache directory at " + this.d.getAbsolutePath());
            this.d = null;
        } else {
            if (this.d.setReadable(true, false) && this.d.setExecutable(true, false)) {
                return;
            }
            su.e("Could not set cache file permissions at " + this.d.getAbsolutePath());
            this.d = null;
        }
    }

    private File a(File file) {
        return new File(this.d, file.getName() + ".done");
    }

    private void a(final String str, final File file) {
        st.a.post(new Runnable() { // from class: xu.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheCanceled");
                map.put("src", str);
                if (file != null) {
                    map.put("cachedSrc", file.getAbsolutePath());
                }
                xu.this.c.a("onPrecacheEvent", map);
            }
        });
    }

    private void a(final String str, final File file, final int i) {
        st.a.post(new Runnable() { // from class: xu.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheComplete");
                map.put("src", str);
                map.put("cachedSrc", file.getAbsolutePath());
                map.put("totalBytes", Integer.toString(i));
                xu.this.c.a("onPrecacheEvent", map);
            }
        });
    }

    private void a(final String str, final File file, final int i, final int i2) {
        st.a.post(new Runnable() { // from class: xu.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheProgress");
                map.put("src", str);
                map.put("cachedSrc", file.getAbsolutePath());
                map.put("bytesLoaded", Integer.toString(i));
                map.put("totalBytes", Integer.toString(i2));
                xu.this.c.a("onPrecacheEvent", map);
            }
        });
    }

    private String b(String str) {
        return rj.a().a(str);
    }

    private static void b(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public void a() {
        this.e = true;
    }

    public boolean a(String str) {
        FileOutputStream fileOutputStream;
        boolean z;
        int responseCode;
        if (this.d == null) {
            a(str, null);
            return false;
        }
        while (b() > xb.m.c().intValue()) {
            if (!c()) {
                su.e("Unable to expire stream cache");
                a(str, null);
                return false;
            }
        }
        File file = new File(this.d, b(str));
        File fileA = a(file);
        if (file.isFile() && fileA.isFile()) {
            int length = (int) file.length();
            su.a("Stream cache hit at " + str);
            a(str, file, length);
            return true;
        }
        String str2 = this.d.getAbsolutePath() + str;
        synchronized (a) {
            if (a.contains(str2)) {
                su.e("Stream cache already in progress at " + str);
                a(str, file);
                z = false;
            } else {
                a.add(str2);
                try {
                    URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                    int iIntValue = xb.q.c().intValue();
                    uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                    uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                    if ((uRLConnectionOpenConnection instanceof HttpURLConnection) && (responseCode = ((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode()) >= 400) {
                        throw new IOException("HTTP status code " + responseCode + " at " + str);
                    }
                    int contentLength = uRLConnectionOpenConnection.getContentLength();
                    if (contentLength < 0) {
                        su.e("Stream cache aborted, missing content-length header at " + str);
                        a(str, file);
                        a.remove(str2);
                        z = false;
                    } else {
                        String str3 = b.format(contentLength);
                        int iIntValue2 = xb.n.c().intValue();
                        if (contentLength > iIntValue2) {
                            su.e("Content length " + str3 + " exceeds limit at " + str);
                            a(str, file);
                            a.remove(str2);
                            z = false;
                        } else {
                            su.a("Caching " + str3 + " bytes from " + str);
                            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(uRLConnectionOpenConnection.getInputStream());
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                FileChannel channel = fileOutputStream.getChannel();
                                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                                aah aahVarG = sy.g();
                                long jA = aahVarG.a();
                                zk zkVar = new zk(xb.p.c().longValue());
                                long jLongValue = xb.o.c().longValue();
                                int i = 0;
                                while (true) {
                                    int i2 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                    if (i2 >= 0) {
                                        i += i2;
                                        if (i > iIntValue2) {
                                            throw new IOException("stream cache file size limit exceeded");
                                        }
                                        byteBufferAllocate.flip();
                                        while (channel.write(byteBufferAllocate) > 0) {
                                        }
                                        byteBufferAllocate.clear();
                                        if (aahVarG.a() - jA > 1000 * jLongValue) {
                                            throw new IOException("stream cache time limit exceeded");
                                        }
                                        if (this.e) {
                                            throw new IOException("abort requested");
                                        }
                                        if (zkVar.a()) {
                                            a(str, file, i, contentLength);
                                        }
                                    } else {
                                        fileOutputStream.close();
                                        if (su.a(3)) {
                                            su.a("Preloaded " + b.format(i) + " bytes from " + str);
                                        }
                                        file.setReadable(true, false);
                                        b(fileA);
                                        a(str, file, i);
                                        a.remove(str2);
                                        z = true;
                                    }
                                }
                            } catch (IOException e) {
                                e = e;
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                } catch (NullPointerException e3) {
                                }
                                if (this.e) {
                                    su.c("Preload aborted for URL \"" + str + "\"");
                                } else {
                                    su.c("Preload failed for URL \"" + str + "\"", e);
                                }
                                if (file.exists() && !file.delete()) {
                                    su.e("Could not delete partial cache file at " + file.getAbsolutePath());
                                }
                                a(str, file);
                                a.remove(str2);
                                z = false;
                            }
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = null;
                }
            }
        }
        return z;
    }

    public int b() {
        int i = 0;
        if (this.d != null) {
            for (File file : this.d.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() {
        /*
            r11 = this;
            r6 = 0
            java.io.File r0 = r11.d
            if (r0 != 0) goto L6
        L5:
            return r6
        L6:
            r5 = 0
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File r0 = r11.d
            java.io.File[] r8 = r0.listFiles()
            int r9 = r8.length
            r7 = r6
        L14:
            if (r7 >= r9) goto L33
            r4 = r8[r7]
            java.lang.String r0 = r4.getName()
            java.lang.String r1 = ".done"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L4c
            long r0 = r4.lastModified()
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 >= 0) goto L4c
            r2 = r4
        L2d:
            int r3 = r7 + 1
            r7 = r3
            r5 = r2
            r2 = r0
            goto L14
        L33:
            if (r5 == 0) goto L4a
            boolean r0 = r5.delete()
            java.io.File r1 = r11.a(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L48
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L48:
            r6 = r0
            goto L5
        L4a:
            r0 = r6
            goto L48
        L4c:
            r0 = r2
            r2 = r5
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xu.c():boolean");
    }
}
