package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import defpackage.age;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amh extends age {
    private aue a;
    private qi b;
    private List<akm> c;

    public amh(long j, qi qiVar) {
        super(Long.toString(j));
        this.c = new ArrayList();
        this.a = agv.a(true);
        this.b = qiVar;
    }

    @Override // defpackage.age
    protected void b(final int i, int i2, final age.a aVar) {
        this.a.a("https://api.deezer.com/playlist/" + c() + "/tracks?limit=" + i2 + "&index=" + i + "&access_token=" + this.b.b(), new aum() { // from class: amh.1
            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONObject jSONObject) {
                if (jSONObject != null) {
                    List listA = new qv(akm.class).a(jSONObject.toString());
                    if (listA != null) {
                        mm.b("deezer test track is not null", listA);
                    }
                    ArrayList arrayList = new ArrayList();
                    mm.b("deezer test is love tracks & love track first load ", Boolean.valueOf(all.a), Boolean.valueOf(all.b));
                    if (listA != null) {
                        if (!all.a) {
                            amh.this.a((List<akm>) listA, arrayList, i);
                        } else if (all.b) {
                            amh.this.a((List<akm>) listA, arrayList, i);
                            all.b = false;
                        }
                    }
                    aVar.a(i, arrayList, jSONObject);
                }
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    aVar.a(new ErrorInfo.a().a(th).a(jSONObject.toString()).a());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<akm> list, List<MusicData> list2, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            MusicData musicDataA = als.a(list.get(i2));
            musicDataA.queue_source = 1;
            if (!d().containsKey(Integer.valueOf(i2 + i))) {
                d().put(Integer.valueOf(i2 + i), musicDataA);
                this.c.add(list.get(i2));
                if (this.c.size() == 1) {
                    mm.b("deezer test", "-----add track ");
                }
                list2.add(musicDataA);
            }
        }
    }

    public List<akm> e() {
        mm.b("deezer test", Integer.valueOf(this.c.size()));
        return this.c;
    }
}
