package defpackage;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class alh extends HashMap<Long, String> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String put(final Long l, String str) {
        String str2 = (String) super.put(l, str);
        new Timer().schedule(new TimerTask() { // from class: alh.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                mm.b("the url has been removed since the time only have 15min", new Object[0]);
                alh.this.remove(l);
            }
        }, 870000L);
        return str2;
    }
}
