package defpackage;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class wi {
    private String a;
    private String[] b;
    private wh c;

    private Uri a(Uri uri, Context context, String str, boolean z) throws wj {
        try {
            boolean zA = a(uri);
            if (zA) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new wj("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new wj("Query parameter already exists: ms");
            }
            String strA = z ? this.c.a(context, str) : this.c.a(context);
            return zA ? b(uri, "dc_ms", strA) : a(uri, "ms", strA);
        } catch (UnsupportedOperationException e) {
            throw new wj("Provided Uri is not in a valid state");
        }
    }

    private Uri a(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl");
        }
        return iIndexOf != -1 ? Uri.parse(string.substring(0, iIndexOf + 1) + str + "=" + str2 + "&" + string.substring(iIndexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri b(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf(";adurl");
        if (iIndexOf != -1) {
            return Uri.parse(string.substring(0, iIndexOf + 1) + str + "=" + str2 + ";" + string.substring(iIndexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int iIndexOf2 = string.indexOf(encodedPath);
        return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";" + str + "=" + str2 + ";" + string.substring(encodedPath.length() + iIndexOf2));
    }

    public Uri a(Uri uri, Context context) throws wj {
        try {
            return a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new wj("Provided Uri is not in a valid state");
        }
    }

    public wh a() {
        return this.c;
    }

    public void a(MotionEvent motionEvent) {
        this.c.a(motionEvent);
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.a);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.b) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean c(Uri uri) {
        return b(uri) && uri.getPath().endsWith("/aclk");
    }
}
