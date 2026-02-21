package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class atb {
    public static asx a;
    public static HashMap<String, asz> b = new HashMap<>();
    public static ArrayList<Integer> c = new ArrayList<>();
    public static HashMap<Integer, Boolean> d = new HashMap<>();
    public static boolean e = false;

    static {
        d.put(0, true);
        d.put(1, true);
        d.put(2, true);
        d.put(3, false);
        d.put(4, true);
        d.put(5, true);
        d.put(6, true);
    }

    public static void a(final atc atcVar) {
        agv.a(false).a(asw.a().c(), new aux() { // from class: atb.1
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b();
                if (atcVar != null) {
                    atcVar.p();
                }
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str) {
                mm.a((Object) str);
                asw.a().a(str);
                try {
                    abw abwVar = new abw();
                    JSONObject jSONObject = new JSONObject(str);
                    atb.a = (asx) abwVar.a(jSONObject.getJSONObject("app").getString("android"), asx.class);
                    for (asz aszVar : (List) abwVar.a(jSONObject.getString("device"), new adp<List<asz>>() { // from class: atb.1.1
                    }.b())) {
                        atb.b.put(aszVar.b(), aszVar);
                    }
                    for (ata ataVar : (List) abwVar.a(jSONObject.getString("musicService"), new adp<List<ata>>() { // from class: atb.1.2
                    }.b())) {
                        if (!ataVar.a) {
                            atb.c.add(Integer.valueOf(ataVar.b));
                        }
                    }
                    if (atcVar != null) {
                        atcVar.o();
                    }
                } catch (Exception e2) {
                    mm.b();
                    e2.printStackTrace();
                    if (atcVar != null) {
                        atcVar.p();
                    }
                }
            }
        });
    }
}
