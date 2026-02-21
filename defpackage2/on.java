package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class on extends FileOutputStream {
    public static final FilenameFilter a = new FilenameFilter() { // from class: on.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };
    private final String b;
    private File c;
    private File d;
    private boolean e;

    public on(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.e = false;
        this.b = file + File.separator + str;
        this.c = new File(this.b + ".cls_temp");
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.e) {
            this.e = true;
            super.flush();
            super.close();
            File file = new File(this.b + ".cls");
            if (this.c.renameTo(file)) {
                this.c = null;
                this.d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.c + " -> " + file + str);
            }
        }
    }

    public void a() throws IOException {
        if (!this.e) {
            this.e = true;
            super.flush();
            super.close();
        }
    }
}
