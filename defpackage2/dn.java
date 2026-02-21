package defpackage;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dn {
    public static int a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static final class a {
        public static String a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static int c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }
    }
}
