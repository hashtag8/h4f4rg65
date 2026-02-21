package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class aus implements Serializable {
    protected boolean a;
    protected boolean b;
    protected final ConcurrentHashMap<String, String> c;
    protected final ConcurrentHashMap<String, b> d;
    protected final ConcurrentHashMap<String, a> e;
    protected final ConcurrentHashMap<String, Object> f;
    protected String g;

    public static class a {
        public final File a;
        public final String b;
        public final String c;
    }

    public aus() {
        this((Map) null);
    }

    public aus(Map<String, String> map) {
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
        this.f = new ConcurrentHashMap<>();
        this.g = HTTP.UTF_8;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.c.put(str, str2);
        }
    }

    public void a(String str, int i) {
        if (str != null) {
            this.c.put(str, String.valueOf(i));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.c.put(str, String.valueOf(j));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, b> entry2 : this.d.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry<String, a> entry3 : this.e.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (BasicNameValuePair basicNameValuePair : a((String) null, this.f)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(basicNameValuePair.getName());
            sb.append("=");
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }

    public HttpEntity a(aut autVar) {
        if (this.b) {
            return b(autVar);
        }
        if (this.d.isEmpty() && this.e.isEmpty()) {
            return c();
        }
        return c(autVar);
    }

    private HttpEntity b(aut autVar) {
        aun aunVar = new aun(autVar, (this.e.isEmpty() && this.d.isEmpty()) ? false : true);
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            aunVar.a(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : this.f.entrySet()) {
            aunVar.a(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<String, a> entry3 : this.e.entrySet()) {
            aunVar.a(entry3.getKey(), entry3.getValue());
        }
        for (Map.Entry<String, b> entry4 : this.d.entrySet()) {
            b value = entry4.getValue();
            if (value.a != null) {
                aunVar.a(entry4.getKey(), b.a(value.a, value.b, value.c, value.d));
            }
        }
        return aunVar;
    }

    private HttpEntity c() {
        try {
            return new UrlEncodedFormEntity(a(), this.g);
        } catch (UnsupportedEncodingException e) {
            Log.e("RequestParams", "createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity c(aut autVar) throws IOException {
        auv auvVar = new auv(autVar);
        auvVar.a(this.a);
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            auvVar.b(entry.getKey(), entry.getValue(), this.g);
        }
        for (BasicNameValuePair basicNameValuePair : a((String) null, this.f)) {
            auvVar.b(basicNameValuePair.getName(), basicNameValuePair.getValue(), this.g);
        }
        for (Map.Entry<String, b> entry2 : this.d.entrySet()) {
            b value = entry2.getValue();
            if (value.a != null) {
                auvVar.a(entry2.getKey(), value.b, value.a, value.c);
            }
        }
        for (Map.Entry<String, a> entry3 : this.e.entrySet()) {
            a value2 = entry3.getValue();
            auvVar.a(entry3.getKey(), value2.a, value2.b, value2.c);
        }
        return auvVar;
    }

    protected List<BasicNameValuePair> a() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(a((String) null, this.f));
        return linkedList;
    }

    private List<BasicNameValuePair> a(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(a(str == null ? (String) obj3 : String.format("%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.addAll(a(String.format("%s[%d]", str, Integer.valueOf(i)), list.get(i)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.addAll(a(String.format("%s[%d]", str, Integer.valueOf(i2)), objArr[i2]));
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedList.addAll(a(str, it.next()));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    protected String b() {
        return URLEncodedUtils.format(a(), this.g);
    }

    public static class b {
        public final InputStream a;
        public final String b;
        public final String c;
        public final boolean d;

        public b(InputStream inputStream, String str, String str2, boolean z) {
            this.a = inputStream;
            this.b = str;
            this.c = str2;
            this.d = z;
        }

        static b a(InputStream inputStream, String str, String str2, boolean z) {
            if (str2 == null) {
                str2 = "application/octet-stream";
            }
            return new b(inputStream, str, str2, z);
        }
    }
}
