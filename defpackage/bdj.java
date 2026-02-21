package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import defpackage.age;
import defpackage.bdh;
import defpackage.bdi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdj extends age {
    private ArrayList<bdg> a;
    private bdh.a b;

    public bdj(bdh.a aVar, String str) {
        super(str);
        this.b = aVar;
        this.a = new ArrayList<>();
    }

    @Override // defpackage.age
    protected void b(final int i, final int i2, final age.a aVar) {
        bdh.a().a(this.b, new bdi.b() { // from class: bdj.1
            @Override // bdi.b
            public void a(bdh.a aVar2, JSONObject jSONObject, String str) {
                bdj.this.a(i, i2, jSONObject, aVar);
            }

            @Override // bdi.b
            public void a(bdh.a aVar2, JSONArray jSONArray) {
            }

            @Override // bdi.b
            public void a(bdh.a aVar2, String str) {
                aVar.a(new ErrorInfo.a().a(str).a());
                bdj.this.a(false);
            }
        }, c(), "", i, i2 > 0 ? Math.max(i2, 100) : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, JSONObject jSONObject, age.a aVar) {
        ArrayList<bdg> arrayListA = bcv.a(jSONObject);
        if (arrayListA.size() > 0) {
            List<MusicData> listA = bdh.a(arrayListA);
            for (int i3 = 0; i3 < listA.size(); i3++) {
                MusicData musicData = listA.get(i3);
                musicData.queue_source = 1;
                int i4 = i3 + i;
                if (!d().containsKey(Integer.valueOf(i4))) {
                    this.a.add(i4, arrayListA.get(i3));
                    d().put(Integer.valueOf(i4), musicData);
                }
            }
            aVar.a(i, listA.subList(0, Math.min(i2, listA.size())), jSONObject);
        } else {
            aVar.a(i, null, jSONObject);
        }
        a(false);
    }

    @Override // defpackage.age
    public void b() {
        super.b();
        this.a.clear();
    }

    public List<bdg> e() {
        return this.a;
    }
}
