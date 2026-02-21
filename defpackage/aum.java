package defpackage;

import android.util.Log;
import org.apache.http.Header;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class aum extends aux {
    public aum() {
        super(HTTP.UTF_8);
    }

    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public void a(int i, Header[] headerArr, JSONArray jSONArray) {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", th);
    }

    public void a(int i, Header[] headerArr, Throwable th, JSONArray jSONArray) {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", th);
    }

    @Override // defpackage.aux
    public void a(int i, Header[] headerArr, String str, Throwable th) {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", th);
    }

    @Override // defpackage.aux
    public void a(int i, Header[] headerArr, String str) {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    @Override // defpackage.aux, defpackage.aug
    public final void a(final int i, final Header[] headerArr, final byte[] bArr) {
        if (i != 204) {
            Runnable runnable = new Runnable() { // from class: aum.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final Object objA = aum.this.a(bArr);
                        aum.this.a(new Runnable() { // from class: aum.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (objA instanceof JSONObject) {
                                    aum.this.a(i, headerArr, (JSONObject) objA);
                                    return;
                                }
                                if (objA instanceof JSONArray) {
                                    aum.this.a(i, headerArr, (JSONArray) objA);
                                } else if (objA instanceof String) {
                                    aum.this.a(i, headerArr, (String) objA, new JSONException("Response cannot be parsed as JSON data"));
                                } else {
                                    aum.this.a(i, headerArr, new JSONException("Unexpected response type " + objA.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (JSONException e) {
                        aum.this.a(new Runnable() { // from class: aum.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aum.this.a(i, headerArr, e, (JSONObject) null);
                            }
                        });
                    }
                }
            };
            if (!d()) {
                new Thread(runnable).start();
                return;
            } else {
                runnable.run();
                return;
            }
        }
        a(i, headerArr, new JSONObject());
    }

    @Override // defpackage.aux, defpackage.aug
    public final void a(final int i, final Header[] headerArr, final byte[] bArr, final Throwable th) {
        if (bArr != null) {
            Runnable runnable = new Runnable() { // from class: aum.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final Object objA = aum.this.a(bArr);
                        aum.this.a(new Runnable() { // from class: aum.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (objA instanceof JSONObject) {
                                    aum.this.a(i, headerArr, th, (JSONObject) objA);
                                    return;
                                }
                                if (objA instanceof JSONArray) {
                                    aum.this.a(i, headerArr, th, (JSONArray) objA);
                                } else if (objA instanceof String) {
                                    aum.this.a(i, headerArr, (String) objA, th);
                                } else {
                                    aum.this.a(i, headerArr, new JSONException("Unexpected response type " + objA.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (JSONException e) {
                        aum.this.a(new Runnable() { // from class: aum.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aum.this.a(i, headerArr, e, (JSONObject) null);
                            }
                        });
                    }
                }
            };
            if (!d()) {
                new Thread(runnable).start();
                return;
            } else {
                runnable.run();
                return;
            }
        }
        Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
        a(i, headerArr, th, (JSONObject) null);
    }

    protected Object a(byte[] bArr) throws JSONException {
        Object objNextValue = null;
        if (bArr == null) {
            return null;
        }
        String strA = a(bArr, e());
        if (strA != null) {
            strA = strA.trim();
            if (strA.startsWith("\ufeff")) {
                strA = strA.substring(1);
            }
            if (strA.startsWith("{") || strA.startsWith("[")) {
                objNextValue = new JSONTokener(strA).nextValue();
            }
        }
        return objNextValue != null ? objNextValue : strA;
    }
}
