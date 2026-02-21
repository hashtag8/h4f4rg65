package defpackage;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class awf {
    public static void a(Context context, String str, Object obj) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStreamOpenFileOutput);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        fileOutputStreamOpenFileOutput.close();
    }

    public static Object a(Context context, String str) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStreamOpenFileInput);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStreamOpenFileInput.close();
        return object;
    }
}
