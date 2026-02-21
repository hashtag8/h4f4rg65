package defpackage;

import android.os.SystemClock;
import defpackage.lf;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class lz implements lk {
    protected static final boolean a = ly.b;
    private static int d = 3000;
    private static int e = 4096;
    protected final me b;
    protected final ma c;

    public lz(me meVar) {
        this(meVar, new ma(e));
    }

    public lz(me meVar, ma maVar) {
        this.b = meVar;
        this.c = maVar;
    }

    @Override // defpackage.lk
    public ln a(lq<?> lqVar) throws lx {
        byte[] bArr;
        byte[] bArrA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap map = new HashMap();
                    a(map, lqVar.g());
                    HttpResponse httpResponseA = this.b.a(lqVar, map);
                    try {
                        StatusLine statusLine = httpResponseA.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        mapEmptyMap = a(httpResponseA.getAllHeaders());
                        if (statusCode == 304) {
                            lf.a aVarG = lqVar.g();
                            if (aVarG == null) {
                                return new ln(HttpStatus.SC_NOT_MODIFIED, null, mapEmptyMap, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            aVarG.g.putAll(mapEmptyMap);
                            return new ln(HttpStatus.SC_NOT_MODIFIED, aVarG.a, aVarG.g, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        }
                        if (statusCode == 301 || statusCode == 302) {
                            lqVar.c(mapEmptyMap.get("Location"));
                        }
                        if (httpResponseA.getEntity() != null) {
                            bArrA = a(httpResponseA.getEntity());
                        } else {
                            bArrA = new byte[0];
                        }
                        try {
                            a(SystemClock.elapsedRealtime() - jElapsedRealtime, lqVar, bArrA, statusLine);
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            return new ln(statusCode, bArrA, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        } catch (IOException e2) {
                            e = e2;
                            bArr = bArrA;
                            httpResponse = httpResponseA;
                            if (httpResponse != null) {
                                int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                                if (statusCode2 == 301 || statusCode2 == 302) {
                                    ly.c("Request at %s has been redirected to %s", lqVar.e(), lqVar.d());
                                } else {
                                    ly.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), lqVar.d());
                                }
                                if (bArr != null) {
                                    ln lnVar = new ln(statusCode2, bArr, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                    if (statusCode2 == 401 || statusCode2 == 403) {
                                        a("auth", lqVar, new le(lnVar));
                                    } else if (statusCode2 == 301 || statusCode2 == 302) {
                                        a("redirect", lqVar, new lp(lnVar));
                                    } else {
                                        throw new lv(lnVar);
                                    }
                                } else {
                                    throw new lm(e);
                                }
                            } else {
                                throw new lo(e);
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bArr = null;
                        httpResponse = httpResponseA;
                    }
                } catch (MalformedURLException e4) {
                    throw new RuntimeException("Bad URL " + lqVar.d(), e4);
                } catch (SocketTimeoutException e5) {
                    a("socket", lqVar, new lw());
                } catch (ConnectTimeoutException e6) {
                    a("connection", lqVar, new lw());
                }
            } catch (IOException e7) {
                e = e7;
                bArr = null;
            }
        }
    }

    private void a(long j, lq<?> lqVar, byte[] bArr, StatusLine statusLine) {
        if (a || j > d) {
            Object[] objArr = new Object[5];
            objArr[0] = lqVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(lqVar.u().b());
            ly.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, lq<?> lqVar, lx lxVar) throws lx {
        lu luVarU = lqVar.u();
        int iT = lqVar.t();
        try {
            luVarU.a(lxVar);
            lqVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iT)));
        } catch (lx e2) {
            lqVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iT)));
            throw e2;
        }
    }

    private void a(Map<String, String> map, lf.a aVar) {
        if (aVar != null) {
            if (aVar.b != null) {
                map.put("If-None-Match", aVar.b);
            }
            if (aVar.d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.d)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException {
        mg mgVar = new mg(this.c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new lv();
            }
            byte[] bArrA = this.c.a(1024);
            while (true) {
                int i = content.read(bArrA);
                if (i == -1) {
                    break;
                }
                mgVar.write(bArrA, 0, i);
            }
            byte[] byteArray = mgVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                ly.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a(bArrA);
            mgVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e3) {
                ly.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a((byte[]) null);
            mgVar.close();
            throw th;
        }
    }

    protected static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
