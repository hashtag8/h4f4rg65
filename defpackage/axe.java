package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.age;
import defpackage.axd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axe extends age {
    private final String a;
    private final String b;
    private final String c;
    private ArrayList<axb> d;
    private awz e;
    private int f;

    static /* synthetic */ int g(axe axeVar) {
        int i = axeVar.f;
        axeVar.f = i - 1;
        return i;
    }

    public axe(awz awzVar) {
        super(awzVar.a);
        this.a = "user:public-playlist";
        this.b = "user:playlist";
        this.c = "user:playlist-entries";
        this.e = awzVar;
        this.d = new ArrayList<>();
    }

    public void e() {
        this.f = 0;
    }

    @Override // defpackage.age
    protected void b(final int i, int i2, final age.a aVar) {
        if (d().containsKey(Integer.valueOf(i)) || (i >= this.e.h && this.e.h > 0)) {
            aVar.a(i, new ArrayList(), null);
            return;
        }
        a(true);
        final boolean zContainsKey = this.e.c.containsKey("user:playlist");
        String str = zContainsKey ? "user:playlist-entries" : "user:public-playlist";
        if (zContainsKey) {
            String str2 = this.e.c.get("user:playlist");
            HashMap<String, String> map = this.e.c;
            StringBuilder sbAppend = new StringBuilder().append(str2).append("/entries?pageIndex=");
            int i3 = this.f;
            this.f = i3 + 1;
            map.put("user:playlist-entries", sbAppend.append(i3).toString());
        }
        axc.a().a(this.e.c, str, new axd.b() { // from class: axe.1
            agz a;

            @Override // axd.b
            public void a(String str3, JSONObject jSONObject, String str4) {
                if (str3.compareTo("catalog:track") == 0) {
                    int i4 = Integer.parseInt(str4);
                    if (jSONObject != null) {
                        axb axbVar = new axb();
                        axbVar.a = jSONObject.optString("id");
                        axbVar.b = jSONObject.optString("name");
                        axbVar.c = jSONObject.optString("artistName");
                        axbVar.d = jSONObject.optString("albumName");
                        axbVar.e = jSONObject.optInt("lengthInSeconds");
                        axbVar.f = jSONObject.optString("genre");
                        axbVar.g = jSONObject.optString("label");
                        axbVar.h = jSONObject.optString("releaseYear");
                        axbVar.i = awp.a(jSONObject);
                        JukeMusicDataLocal jukeMusicDataLocalA = awp.a(axbVar);
                        jukeMusicDataLocalA.queue_source = 1;
                        axbVar.i.putAll(((axb) axe.this.d.get(i4)).i);
                        axe.this.d.set(i4, axbVar);
                        axe.this.d().put(Integer.valueOf(i4), jukeMusicDataLocalA);
                        this.a.a();
                        return;
                    }
                    return;
                }
                ArrayList<axb> arrayListB = awp.b(jSONObject);
                if (zContainsKey) {
                    try {
                        axe.this.e.h = jSONObject.getInt("collectionLength");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a(arrayListB, jSONObject);
                    return;
                }
                axe.this.e.h = arrayListB.size();
                if (axe.this.d.isEmpty()) {
                    a(arrayListB, jSONObject);
                } else {
                    a(jSONObject);
                }
            }

            private void a(List<axb> list, final JSONObject jSONObject) {
                this.a = new agz(list.size(), new Runnable() { // from class: axe.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a(jSONObject);
                    }
                }, null);
                List<MusicData> listA = awp.a(list);
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    MusicData musicData = listA.get(i4);
                    int i5 = i + i4;
                    if (!axe.this.d().containsKey(Integer.valueOf(i5))) {
                        axe.this.d.add(i5, list.get(i4));
                        axe.this.d().put(Integer.valueOf(i5), musicData);
                    }
                }
                for (int i6 = 0; i6 < list.size(); i6++) {
                    axc.a().a(list.get(i6).i, "catalog:track", this, "" + (i + i6), "", 0, 1);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(JSONObject jSONObject) {
                List<MusicData> listA = awp.a(axe.this.d);
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    listA.get(i4).queue_source = 1;
                }
                axe.this.a(false);
                aVar.a(i, listA, jSONObject);
            }

            @Override // axd.b
            public void a(String str3, JSONArray jSONArray) {
            }

            private void a() {
                ArrayList arrayList = new ArrayList();
                for (int i4 = i; i4 < axe.this.d.size(); i4++) {
                    arrayList.add(axe.this.d.get(i4));
                    axe.this.d().remove(Integer.valueOf(i4));
                }
                axe.this.d.removeAll(arrayList);
            }

            @Override // axd.b
            public void a(String str3, String str4) {
                if (str3.compareTo("catalog:track") == 0) {
                    if (zContainsKey) {
                        try {
                            axe.g(axe.this);
                            a();
                            aVar.a(new ErrorInfo.a().a(str4).a());
                            axe.this.a(false);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    this.a.a();
                    return;
                }
                if (str3.compareTo("user:playlist-entries") == 0) {
                    if (zContainsKey) {
                        axe.g(axe.this);
                        aVar.a(new ErrorInfo.a().a(str4).a());
                        axe.this.a(false);
                        return;
                    }
                    return;
                }
                aVar.a(new ErrorInfo.a().a(str4).a());
                axe.this.a(false);
            }
        }, "", "", i, Math.max(i2, 100), zContainsKey);
    }

    @Override // defpackage.age
    public void b() {
        super.b();
        this.d.clear();
    }

    public List<axb> f() {
        return this.d;
    }
}
