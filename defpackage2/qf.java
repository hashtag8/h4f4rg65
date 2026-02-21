package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class qf {
    private static final FilenameFilter a = new FilenameFilter() { // from class: qf.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    };

    static int a(File file, int i, Comparator<File> comparator) {
        return a(file, a, i, comparator);
    }

    static int a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        int i2 = 0;
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            Arrays.sort(fileArrListFiles, comparator);
            int length2 = fileArrListFiles.length;
            i2 = length;
            int i3 = 0;
            while (i3 < length2) {
                File file2 = fileArrListFiles[i3];
                if (i2 <= i) {
                    break;
                }
                file2.delete();
                i3++;
                i2--;
            }
        }
        return i2;
    }
}
