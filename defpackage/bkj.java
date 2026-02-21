package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Xml;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class bkj implements biw {
    private static bkj d;
    private bjn f;
    private biv a = null;
    private bkz b = new bkz();
    private Hashtable<String, bjn> c = new Hashtable<>();
    private Timer e = new Timer();
    private ArrayList<String> g = new ArrayList<>();
    private ArrayList<String> h = new ArrayList<>();

    public static synchronized bkj a() {
        if (d == null) {
            d = new bkj();
        }
        return d;
    }

    private bkj() {
    }

    public synchronized void b(final bjh bjhVar) {
        if (!this.c.containsKey(bjhVar.i()) && !this.g.contains(bjhVar.i()) && !this.h.contains(bjhVar.i())) {
            this.h.add(bjhVar.i());
            new Thread(new Runnable() { // from class: bkj.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v16, types: [org.xmlpull.v1.XmlPullParser] */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v12 */
                /* JADX WARN: Type inference failed for: r1v13 */
                /* JADX WARN: Type inference failed for: r1v14 */
                /* JADX WARN: Type inference failed for: r1v15 */
                /* JADX WARN: Type inference failed for: r1v16 */
                /* JADX WARN: Type inference failed for: r1v17 */
                /* JADX WARN: Type inference failed for: r1v18 */
                /* JADX WARN: Type inference failed for: r1v19 */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedInputStream, java.io.InputStream] */
                /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
                /* JADX WARN: Type inference failed for: r1v9 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ?? bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(bjhVar.d()).openConnection()).getInputStream());
                            try {
                                try {
                                    ?? NewPullParser = Xml.newPullParser();
                                    NewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                                    NewPullParser.setInput(bufferedInputStream, null);
                                    NewPullParser.nextTag();
                                    bkj.this.a(NewPullParser, bjhVar);
                                    bufferedInputStream = bufferedInputStream;
                                    if (bufferedInputStream != 0) {
                                        try {
                                            bufferedInputStream.close();
                                            bufferedInputStream = bufferedInputStream;
                                        } catch (IOException e) {
                                            Log.d("DLNA-LIB ", e.getMessage());
                                            bufferedInputStream = "DLNA-LIB ";
                                        }
                                    }
                                } catch (IOException e2) {
                                    Log.d("DLNA-LIB ", e2.getMessage());
                                    bufferedInputStream = bufferedInputStream;
                                    if (bufferedInputStream != 0) {
                                        try {
                                            bufferedInputStream.close();
                                            bufferedInputStream = bufferedInputStream;
                                        } catch (IOException e3) {
                                            Log.d("DLNA-LIB ", e3.getMessage());
                                            bufferedInputStream = "DLNA-LIB ";
                                        }
                                    }
                                } catch (XmlPullParserException e4) {
                                    Log.d("DLNA-LIB ", e4.getMessage());
                                    bufferedInputStream = bufferedInputStream;
                                    if (bufferedInputStream != 0) {
                                        try {
                                            bufferedInputStream.close();
                                            bufferedInputStream = bufferedInputStream;
                                        } catch (IOException e5) {
                                            Log.d("DLNA-LIB ", e5.getMessage());
                                            bufferedInputStream = "DLNA-LIB ";
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                if (bufferedInputStream != 0) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e6) {
                                        Log.d("DLNA-LIB ", e6.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e7) {
                            Log.d("DLNA-LIB ", e7.getMessage());
                        }
                    } catch (IOException e8) {
                    }
                }
            }).start();
        }
    }

    public void a(bjn bjnVar) {
        if (bjnVar != null) {
            bkx.a("Device description: Name: " + bjnVar.a() + "Device URN Type " + bjnVar.b() + " ");
            if (bjnVar.b() != null && bjnVar.b().contains("urn:schemas-upnp-org:device:MediaServer")) {
                if (!this.c.containsKey(bjnVar.c())) {
                    this.c.put(bjnVar.c(), bjnVar);
                    b(bjnVar);
                    return;
                }
                return;
            }
            this.g.add(bjnVar.c());
        }
    }

    public synchronized void b() {
        this.c.clear();
        this.h.clear();
        this.g.clear();
    }

    public synchronized void b(bjf bjfVar) {
        if (this.c.containsKey(bjfVar.a())) {
            bjn bjnVarRemove = this.c.remove(bjfVar.a());
            this.h.remove(bjfVar.a());
            c(bjnVarRemove);
        }
    }

    public synchronized void a(bja bjaVar) {
        this.b.add(bjaVar);
    }

    public synchronized void b(bja bjaVar) {
        this.b.remove(bjaVar);
    }

    public synchronized void b(final bjn bjnVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bkj.2
            @Override // java.lang.Runnable
            public void run() {
                int size = bkj.this.b.size();
                for (int i = 0; i < size; i++) {
                    ((bja) bkj.this.b.get(i)).a(bjnVar);
                }
            }
        });
    }

    public synchronized void c(final bjn bjnVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: bkj.3
            @Override // java.lang.Runnable
            public void run() {
                int size = bkj.this.b.size();
                for (int i = 0; i < size; i++) {
                    ((bja) bkj.this.b.get(i)).b(bjnVar);
                }
            }
        });
    }

    public synchronized ArrayList<bjn> c() {
        ArrayList<bjn> arrayList;
        Enumeration<bjn> enumerationElements = this.c.elements();
        arrayList = new ArrayList<>();
        while (enumerationElements.hasMoreElements()) {
            arrayList.add(enumerationElements.nextElement());
        }
        return arrayList;
    }

    public synchronized void d() {
        ArrayList arrayList = new ArrayList();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                arrayList.add(networkInterfaces.nextElement());
            }
        }
        this.a = biv.a();
        if (this.a != null) {
            this.a.a(this);
            this.a.c().a(new biy(this.a));
            this.a.b().a(new biz(this.a));
            this.a.d();
            f();
        }
    }

    private synchronized void f() {
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = new Timer();
        this.e.schedule(new TimerTask() { // from class: bkj.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Enumeration enumerationKeys = bkj.this.c.keys();
                while (enumerationKeys.hasMoreElements()) {
                    bjn bjnVar = (bjn) bkj.this.c.get((String) enumerationKeys.nextElement());
                    if (bjnVar.j()) {
                        Log.d("DMS unavailable", "device isExpired");
                        bkj.this.c.remove(bjnVar.g().i());
                        bkj.this.c(bjnVar);
                    }
                }
            }
        }, 300000L, 300000L);
    }

    @Override // defpackage.biw
    public void a(bje bjeVar) {
        if (this.c.containsKey(bjeVar.a())) {
            this.c.get(bjeVar.a()).n(bjeVar.f());
        }
    }

    @Override // defpackage.biw
    public void a(bjf bjfVar) {
        b(bjfVar);
    }

    @Override // defpackage.biw
    public void a(String str, int i, bjg bjgVar) {
    }

    @Override // defpackage.biw
    public void a(bjk bjkVar) {
    }

    @Override // defpackage.biw
    public void a(bjh bjhVar) {
        if (!bkt.b(bjhVar.d())) {
            b(bjhVar);
        }
    }

    public void d(bjn bjnVar) {
        this.f = bjnVar;
    }

    public bjn e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(XmlPullParser xmlPullParser, bjh bjhVar) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        bjn bjnVar;
        bjo bjoVar;
        String str2;
        boolean z4;
        bjq bjqVar;
        try {
            int eventType = xmlPullParser.getEventType();
            bjn bjnVar2 = new bjn(bjhVar);
            String text = "";
            ArrayList<bjo> arrayList = new ArrayList<>();
            bjn bjnVar3 = bjnVar2;
            boolean z5 = false;
            boolean z6 = false;
            String str3 = null;
            bjq bjqVar2 = null;
            int next = eventType;
            bjo bjoVar2 = null;
            while (next != 1) {
                String name = xmlPullParser.getName();
                switch (next) {
                    case 2:
                        String str4 = name.equals("URLBase") ? null : str3;
                        if (name.equals("device")) {
                            if (bjnVar3 != null) {
                                if (bjnVar3.f() != null) {
                                    for (int i = 0; i < bjnVar3.f().size(); i++) {
                                        if (bjnVar3.f().get(i).a().contains("urn:schemas-upnp-org:service:ContentDirectory")) {
                                            bkx.a("Device description: Name: " + bjnVar3.a() + "Device Service Type " + bjnVar3.f().get(i).a());
                                            bjq bjqVar3 = bjnVar3.f().get(i);
                                            if (bjqVar3.c() == null || bjqVar3.c().size() == 0) {
                                                bjqVar3.a(bjnVar3.i(), bjnVar3.c());
                                            }
                                        }
                                    }
                                }
                                a(bjnVar3);
                            }
                            bjqVar = null;
                            z3 = z6;
                            z4 = z5;
                            str2 = str4;
                            bjnVar = new bjn(bjhVar);
                            bjoVar = bjoVar2;
                        } else if (name.equals("iconList")) {
                            bjqVar = bjqVar2;
                            z3 = true;
                            z4 = z5;
                            str2 = str4;
                            bjnVar = bjnVar3;
                            bjoVar = bjoVar2;
                        } else if (name.equals("serviceList")) {
                            bjqVar = bjqVar2;
                            z3 = z6;
                            z4 = true;
                            str2 = str4;
                            bjnVar = bjnVar3;
                            bjoVar = bjoVar2;
                        } else if (name.equals("icon") && z6) {
                            bjqVar = bjqVar2;
                            z3 = z6;
                            z4 = z5;
                            str2 = str4;
                            bjnVar = bjnVar3;
                            bjoVar = new bjo();
                        } else if (name.equals("service") && z5) {
                            bjqVar = new bjq(bjnVar3);
                            z3 = z6;
                            z4 = z5;
                            str2 = str4;
                            bjnVar = bjnVar3;
                            bjoVar = bjoVar2;
                        } else {
                            bjqVar = bjqVar2;
                            z3 = z6;
                            z4 = z5;
                            str2 = str4;
                            bjnVar = bjnVar3;
                            bjoVar = bjoVar2;
                        }
                        break;
                    case 3:
                        if (name.equals("device")) {
                            if (bjnVar3.f() != null) {
                                for (int i2 = 0; i2 < bjnVar3.f().size(); i2++) {
                                    if (bjnVar3.f().get(i2).a().contains("urn:schemas-upnp-org:service:ContentDirectory")) {
                                        bjq bjqVar4 = bjnVar3.f().get(i2);
                                        if (str3 == null || str3 == "") {
                                            bjqVar4.a(bjnVar3.i(), bjnVar3.c());
                                        } else {
                                            bjnVar3.i(str3);
                                            bjqVar4.a(bjnVar3.e(), bjnVar3.c());
                                        }
                                    }
                                }
                            }
                            a().a(bjnVar3);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("friendlyName")) {
                            bjnVar3.m(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("manufacturer")) {
                            bjnVar3.c(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("manufacturerURL")) {
                            bjnVar3.d(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("major")) {
                            bjnVar3.l(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("minor")) {
                            bjnVar3.a(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("modelDescription")) {
                            bjnVar3.e(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("modelName")) {
                            bjnVar3.f(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("modelNumber")) {
                            bjnVar3.g(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("deviceType")) {
                            bjnVar3.j(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("UDN")) {
                            bjnVar3.k(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("modelURL")) {
                            bjnVar3.h(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("specVersion")) {
                            bjnVar3.b(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("URLBase")) {
                            z = z5;
                            z2 = z6;
                            str = text;
                        } else if (name.equals("deviceType")) {
                            bjnVar3.j(text);
                            z = z5;
                            z2 = z6;
                            str = str3;
                        } else if (name.equals("iconList")) {
                            bjnVar3.a(arrayList);
                            str = str3;
                            z = z5;
                            z2 = false;
                        } else if (name.equals("serviceList")) {
                            z = false;
                            z2 = z6;
                            str = str3;
                        } else {
                            z = z5;
                            z2 = z6;
                            str = str3;
                        }
                        if (z2 && bjoVar2 != null) {
                            if (name.equals("url")) {
                                bjoVar2.d(text);
                            } else if (name.equals("width")) {
                                bjoVar2.b(text);
                            } else if (name.equals("height")) {
                                bjoVar2.c(text);
                            } else if (name.equals("mimetype")) {
                                bjoVar2.a(text);
                            }
                        }
                        if (z && bjqVar2 != null) {
                            if (name.equals(bjn.a)) {
                                bjqVar2.a(text);
                            } else if (name.equals(bjn.b)) {
                                bjqVar2.b(text);
                            } else if (name.equals(bjn.c)) {
                                bjqVar2.c(text);
                            } else if (name.equals(bjn.d)) {
                                bjqVar2.d(text);
                            } else if (name.equals(bjn.e)) {
                                bjqVar2.e(bjn.e);
                            }
                        }
                        if (name.equals("icon")) {
                            if (bjoVar2 != null) {
                                arrayList.add(bjoVar2);
                                z3 = z2;
                                bjnVar = bjnVar3;
                                bjoVar = bjoVar2;
                                bjq bjqVar5 = bjqVar2;
                                str2 = str;
                                z4 = z;
                                bjqVar = bjqVar5;
                            }
                        } else if (name.equals("service") && bjqVar2 != null) {
                            bjnVar3.f.add(bjqVar2);
                        }
                        z3 = z2;
                        bjnVar = bjnVar3;
                        bjoVar = bjoVar2;
                        bjq bjqVar6 = bjqVar2;
                        str2 = str;
                        z4 = z;
                        bjqVar = bjqVar6;
                        break;
                    case 4:
                        text = xmlPullParser.getText();
                        bjqVar = bjqVar2;
                        bjnVar = bjnVar3;
                        str2 = str3;
                        z3 = z6;
                        z4 = z5;
                        bjoVar = bjoVar2;
                        break;
                    default:
                        bjqVar = bjqVar2;
                        bjnVar = bjnVar3;
                        str2 = str3;
                        z3 = z6;
                        z4 = z5;
                        bjoVar = bjoVar2;
                        break;
                }
                bjnVar3 = bjnVar;
                bjo bjoVar3 = bjoVar;
                z5 = z4;
                z6 = z3;
                str3 = str2;
                bjqVar2 = bjqVar;
                next = xmlPullParser.next();
                bjoVar2 = bjoVar3;
            }
        } catch (IOException e) {
            Log.d("DLNA-LIB ", e.getMessage());
        } catch (XmlPullParserException e2) {
            Log.d("DLNA-LIB ", e2.getMessage());
        }
    }
}
