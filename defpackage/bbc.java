package defpackage;

import com.musicservice.shoutcast.model.RadioData;
import com.musicservice.shoutcast.model.Station;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bbc extends ags<List<Station>> {
    public bbc(agn agnVar, String str, lr lrVar) {
        super(agnVar, str, lrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ags
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<Station> b(String str) {
        ArrayList arrayList = new ArrayList();
        List list = (List) new abw().a(str, new adp<List<RadioData>>() { // from class: bbc.1
        }.b());
        for (int i = 0; i < list.size(); i++) {
            RadioData radioData = (RadioData) list.get(i);
            arrayList.add(new Station(radioData.getName(), "", radioData.getUID(), 0, "", radioData.getImageUrl(), radioData.getDescription(), radioData.getStreamUrl()));
        }
        return arrayList;
    }
}
