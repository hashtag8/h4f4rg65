package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            throw new IllegalArgumentException("Package identifier must not be null.");
        }
        this.infoPackage = str;
        this.infoModule = str2 == null ? UNAVAILABLE : str2;
        this.infoRelease = str3 == null ? UNAVAILABLE : str3;
        this.infoTimestamp = str4 == null ? UNAVAILABLE : str4;
        this.infoClassloader = str5 == null ? UNAVAILABLE : str5;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        stringBuffer.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            stringBuffer.append(':').append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            stringBuffer.append(':').append(this.infoTimestamp);
        }
        stringBuffer.append(')');
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            stringBuffer.append('@').append(this.infoClassloader);
        }
        return stringBuffer.toString();
    }

    public static final VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        if (strArr == null) {
            throw new IllegalArgumentException("Package identifier list must not be null.");
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            VersionInfo versionInfoLoadVersionInfo = loadVersionInfo(str, classLoader);
            if (versionInfoLoadVersionInfo != null) {
                arrayList.add(versionInfoLoadVersionInfo);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    public static final VersionInfo loadVersionInfo(String str, ClassLoader classLoader) {
        Properties properties;
        if (str == null) {
            throw new IllegalArgumentException("Package identifier must not be null.");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(new StringBuffer().append(str.replace('.', '/')).append("/").append(VERSION_PROPERTY_FILE).toString());
            if (resourceAsStream != null) {
                try {
                    properties = new Properties();
                    properties.load(resourceAsStream);
                } finally {
                    resourceAsStream.close();
                }
            } else {
                properties = null;
            }
        } catch (IOException e) {
            properties = null;
        }
        if (properties != null) {
            return fromMap(str, properties, classLoader);
        }
        return null;
    }

    protected static final VersionInfo fromMap(String str, Map map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        if (str == null) {
            throw new IllegalArgumentException("Package identifier must not be null.");
        }
        if (map != null) {
            String str5 = (String) map.get(PROPERTY_MODULE);
            String str6 = (str5 == null || str5.length() >= 1) ? str5 : null;
            String str7 = (String) map.get(PROPERTY_RELEASE);
            String str8 = (str7 == null || (str7.length() >= 1 && !str7.equals("${pom.version}"))) ? str7 : null;
            String str9 = (String) map.get(PROPERTY_TIMESTAMP);
            if (str9 == null || (str9.length() >= 1 && !str9.equals("${mvn.timestamp}"))) {
                str2 = str9;
                str3 = str8;
                str4 = str6;
            } else {
                str2 = null;
                str3 = str8;
                str4 = str6;
            }
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        return new VersionInfo(str, str4, str3, str2, classLoader != null ? classLoader.toString() : null);
    }
}
