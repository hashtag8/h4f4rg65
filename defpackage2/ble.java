package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/* JADX INFO: loaded from: classes.dex */
public class ble {
    public static void a(InputStream inputStream, String str) throws IOException {
        JarInputStream jarInputStream = new JarInputStream(inputStream);
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry != null) {
                if (nextJarEntry.getName().contains(".")) {
                    System.out.println("File : " + nextJarEntry.getName());
                    String name = nextJarEntry.getName();
                    String[] strArrSplit = name.split("\\.");
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        String str3 = strArrSplit[strArrSplit.length - 1];
                        if (str3 != null && str3.equals("so") && str2 != null && str2.length() >= 3) {
                            File file = new File(String.valueOf(str) + "/" + name);
                            if (!file.exists() || nextJarEntry.getTime() >= file.lastModified()) {
                                file.getParentFile().mkdirs();
                                if (!file.exists() && !file.createNewFile()) {
                                    throw new FileNotFoundException("File " + file.getAbsolutePath() + " does not exist.");
                                }
                                if (!file.exists()) {
                                    throw new FileNotFoundException("File " + file.getAbsolutePath() + " does not exist.");
                                }
                                byte[] bArr = new byte[1024];
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i = jarInputStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, i);
                                        }
                                    } finally {
                                        fileOutputStream.close();
                                    }
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                jarInputStream.close();
                return;
            }
        }
    }
}
