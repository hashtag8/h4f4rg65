package defpackage;

import android.media.MediaDescription;
import android.net.Uri;
import defpackage.dg;

/* JADX INFO: loaded from: classes.dex */
public class dh extends dg {
    public static Uri h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    public static class a extends dg.a {
        public static void b(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }
}
