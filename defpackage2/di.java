package defpackage;

import android.media.MediaMetadata;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class di {
    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
