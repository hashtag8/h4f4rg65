package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.PlayList;
import com.harman.commom.util.error.ErrorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class age {
    private HashMap<Integer, MusicData> a;
    private String c;
    private boolean b = false;
    private int d = 0;
    private boolean e = false;

    public interface a {
        void a(int i, List<MusicData> list, JSONObject jSONObject);

        void a(ErrorInfo errorInfo);
    }

    protected abstract void b(int i, int i2, a aVar);

    public age(String str) {
        a(str);
    }

    private void a(String str) {
        this.c = str;
        this.a = new HashMap<>();
    }

    public void a(final PlayList playList) {
        if (!this.b) {
            if (this.d == 0) {
                this.d = b(playList);
            }
            b(this.d + 1, 100, new a() { // from class: age.1
                @Override // age.a
                public void a(int i, List<MusicData> list, JSONObject jSONObject) {
                    if (!age.this.e) {
                        playList.b(list);
                        if (list.size() > 0) {
                            age.this.d += list.size();
                            age.this.a(playList);
                        }
                    }
                }

                @Override // age.a
                public void a(ErrorInfo errorInfo) {
                }
            });
        }
    }

    private int b(PlayList playList) {
        for (int iA = playList.a() - 1; iA >= 0; iA--) {
            if (playList.b(iA).queue_source == 1) {
                return iA;
            }
        }
        return Math.min(playList.a(), this.d);
    }

    public void a(int i, int i2, a aVar) {
        List<MusicData> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = i; i3 < i + i2; i3++) {
            if (this.a.containsKey(Integer.valueOf(i3))) {
                arrayList.add(this.a.get(Integer.valueOf(i3)));
            } else {
                arrayList2.add(Integer.valueOf(i3));
            }
        }
        if (arrayList2.isEmpty()) {
            aVar.a(i, arrayList, null);
        } else {
            b(i, i2, aVar);
        }
    }

    public void a() {
        this.e = true;
    }

    public void b() {
        this.a.clear();
    }

    protected String c() {
        return this.c;
    }

    protected HashMap<Integer, MusicData> d() {
        return this.a;
    }

    protected void a(boolean z) {
        this.b = z;
    }
}
