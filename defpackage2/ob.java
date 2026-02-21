package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
class ob {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    ob(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static ob a(Properties properties) {
        return new ob(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static ob a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return a(properties);
    }
}
