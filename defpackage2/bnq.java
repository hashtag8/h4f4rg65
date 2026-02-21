package defpackage;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bnq implements bnl {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private bmn e;
    private File f;

    public bnq(Context context, File file, String str, String str2) {
        this.a = context;
        this.b = file;
        this.c = str2;
        this.d = new File(this.b, str);
        this.e = new bmn(this.d);
        e();
    }

    private void e() {
        this.f = new File(this.b, this.c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    @Override // defpackage.bnl
    public void a(byte[] bArr) {
        this.e.a(bArr);
    }

    @Override // defpackage.bnl
    public int a() {
        return this.e.a();
    }

    @Override // defpackage.bnl
    public void a(String str) throws Throwable {
        this.e.close();
        a(this.d, new File(this.f, str));
        this.e = new bmn(this.d);
    }

    private void a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        OutputStream outputStreamA = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            outputStreamA = a(file2);
            bme.a(fileInputStream, outputStreamA, new byte[1024]);
            bme.a((Closeable) fileInputStream, "Failed to close file input stream");
            bme.a((Closeable) outputStreamA, "Failed to close output stream");
            file.delete();
        } catch (Throwable th2) {
            th = th2;
            bme.a((Closeable) fileInputStream, "Failed to close file input stream");
            bme.a((Closeable) outputStreamA, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream a(File file) {
        return new FileOutputStream(file);
    }

    @Override // defpackage.bnl
    public List<File> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // defpackage.bnl
    public void a(List<File> list) {
        for (File file : list) {
            bme.a(this.a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // defpackage.bnl
    public List<File> c() {
        return Arrays.asList(this.f.listFiles());
    }

    @Override // defpackage.bnl
    public void d() {
        try {
            this.e.close();
        } catch (IOException e) {
        }
        this.d.delete();
    }

    @Override // defpackage.bnl
    public boolean b() {
        return this.e.b();
    }

    @Override // defpackage.bnl
    public boolean a(int i, int i2) {
        return this.e.a(i, i2);
    }
}
