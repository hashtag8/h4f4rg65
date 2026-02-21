package defpackage;

import android.media.session.MediaSession;

/* JADX INFO: loaded from: classes.dex */
public class dm {

    public static class a {
        public static Object a(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long b(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }
}
