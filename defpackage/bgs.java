package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface bgs {
    public static final bgs a = new bgs() { // from class: bgs.1
        @Override // defpackage.bgs
        public bri a(File file) {
            return brc.a(file);
        }

        @Override // defpackage.bgs
        public brh b(File file) {
            try {
                return brc.b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return brc.b(file);
            }
        }

        @Override // defpackage.bgs
        public brh c(File file) {
            try {
                return brc.c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return brc.c(file);
            }
        }

        @Override // defpackage.bgs
        public void d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // defpackage.bgs
        public boolean e(File file) {
            return file.exists();
        }

        @Override // defpackage.bgs
        public long f(File file) {
            return file.length();
        }

        @Override // defpackage.bgs
        public void a(File file, File file2) throws IOException {
            d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // defpackage.bgs
        public void g(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    bri a(File file);

    void a(File file, File file2);

    brh b(File file);

    brh c(File file);

    void d(File file);

    boolean e(File file);

    long f(File file);

    void g(File file);
}
