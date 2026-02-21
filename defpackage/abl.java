package defpackage;

import android.os.SystemClock;
import defpackage.wl;
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
public class abl implements ym {
    protected static final boolean a = abk.b;
    private static int d = 3000;
    private static int e = 4096;
    protected final abq b;
    protected final abm c;

    public abl(abq abqVar) {
        this(abqVar, new abm(e));
    }

    public abl(abq abqVar, abm abmVar) {
        this.b = abqVar;
        this.c = abmVar;
    }

    protected static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void a(long j, aac<?> aacVar, byte[] bArr, StatusLine statusLine) {
        if (a || j > d) {
            Object[] objArr = new Object[5];
            objArr[0] = aacVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(aacVar.s().b());
            abk.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, aac<?> aacVar, abj abjVar) throws abj {
        aba abaVarS = aacVar.s();
        int iR = aacVar.r();
        try {
            abaVarS.a(abjVar);
            aacVar.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iR)));
        } catch (abj e2) {
            aacVar.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iR)));
            throw e2;
        }
    }

    private void a(Map<String, String> map, wl.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.b != null) {
            map.put("If-None-Match", aVar.b);
        }
        if (aVar.d > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.d)));
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException {
        we weVar = new we(this.c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new abh();
            }
            byte[] bArrA = this.c.a(1024);
            while (true) {
                int i = content.read(bArrA);
                if (i == -1) {
                    break;
                }
                weVar.write(bArrA, 0, i);
            }
            byte[] byteArray = weVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                abk.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a(bArrA);
            weVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e3) {
                abk.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a((byte[]) null);
            weVar.close();
            throw th;
        }
    }

    @Override // defpackage.ym
    public zo a(aac<?> aacVar) throws abj {
        byte[] bArr;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap map = new HashMap();
                    a(map, aacVar.f());
                    HttpResponse httpResponseA = this.b.a(aacVar, map);
                    try {
                        StatusLine statusLine = httpResponseA.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        mapEmptyMap = a(httpResponseA.getAllHeaders());
                        if (statusCode == 304) {
                            wl.a aVarF = aacVar.f();
                            if (aVarF == null) {
                                return new zo(HttpStatus.SC_NOT_MODIFIED, null, mapEmptyMap, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            aVarF.g.putAll(mapEmptyMap);
                            return new zo(HttpStatus.SC_NOT_MODIFIED, aVarF.a, aVarF.g, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        }
                        byte[] bArrA = httpResponseA.getEntity() != null ? a(httpResponseA.getEntity()) : new byte[0];
                        try {
                            a(SystemClock.elapsedRealtime() - jElapsedRealtime, aacVar, bArrA, statusLine);
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            return new zo(statusCode, bArrA, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        } catch (IOException e2) {
                            e = e2;
                            bArr = bArrA;
                            httpResponse = httpResponseA;
                            if (httpResponse == null) {
                                throw new aab(e);
                            }
                            int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                            abk.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), aacVar.d());
                            if (bArr == null) {
                                throw new yz((zo) null);
                            }
                            zo zoVar = new zo(statusCode2, bArr, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (statusCode2 != 401 && statusCode2 != 403) {
                                throw new abh(zoVar);
                            }
                            a("auth", aacVar, new wd(zoVar));
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bArr = null;
                        httpResponse = httpResponseA;
                    }
                } catch (MalformedURLException e4) {
                    throw new RuntimeException("Bad URL " + aacVar.d(), e4);
                } catch (SocketTimeoutException e5) {
                    a("socket", aacVar, new abi());
                } catch (ConnectTimeoutException e6) {
                    a("connection", aacVar, new abi());
                }
            } catch (IOException e7) {
                e = e7;
                bArr = null;
            }
        }
    }
}
