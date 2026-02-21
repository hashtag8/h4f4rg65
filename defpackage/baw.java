package defpackage;

import com.musicservice.shoutcast.model.Genre;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class baw extends ags<List<Genre>> {
    public baw(agn agnVar, String str, lr lrVar) {
        super(agnVar, str, lrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ags
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<Genre> b(String str) {
        return (List) new abw().a(str, new adp<List<Genre>>() { // from class: baw.1
        }.b());
    }
}
