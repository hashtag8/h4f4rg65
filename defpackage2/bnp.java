package defpackage;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class bnp extends bnq {
    public bnp(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    @Override // defpackage.bnq
    public OutputStream a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
