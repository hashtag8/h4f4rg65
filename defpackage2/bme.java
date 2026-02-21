package defpackage;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/* JADX INFO: loaded from: classes.dex */
public class bme {
    private static Boolean b = null;
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long d = -1;
    public static final Comparator<File> a = new Comparator<File>() { // from class: bme.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r0 = r1[1];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r0 = 0
            r5 = 1
            boolean r1 = r7.exists()
            if (r1 == 0) goto L39
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r1.<init>(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
        L14:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r1 == 0) goto L34
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4 = 2
            java.lang.String[] r1 = r3.split(r1, r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r3 = r1.length     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 <= r5) goto L14
            r3 = 0
            r3 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            boolean r3 = r3.equals(r8)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 == 0) goto L14
            r3 = 1
            r0 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
        L34:
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
        L39:
            return r0
        L3a:
            r1 = move-exception
            r2 = r0
        L3c:
            blq r3 = defpackage.blh.h()     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r5.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "Error parsing "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L67
            r3.e(r4, r5, r1)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
            goto L39
        L5e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L61:
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
            throw r0
        L67:
            r0 = move-exception
            goto L61
        L69:
            r1 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bme.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static int a() {
        return a.a().ordinal();
    }

    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, a> k = new HashMap(4);

        static {
            k.put("armeabi-v7a", ARMV7);
            k.put("armeabi", ARMV6);
            k.put("arm64-v8a", ARM64);
            k.put("x86", X86_32);
        }

        static a a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                blh.h().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                return UNKNOWN;
            }
            return aVar;
        }
    }

    public static synchronized long b() {
        if (d == -1) {
            long jA = 0;
            String strA = a(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty(strA)) {
                String upperCase = strA.toUpperCase(Locale.US);
                try {
                    if (upperCase.endsWith("KB")) {
                        jA = a(upperCase, "KB", 1024);
                    } else if (upperCase.endsWith("MB")) {
                        jA = a(upperCase, "MB", 1048576);
                    } else if (upperCase.endsWith("GB")) {
                        jA = a(upperCase, "GB", 1073741824);
                    } else {
                        blh.h().a("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                    }
                } catch (NumberFormatException e) {
                    blh.h().e("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                }
            }
            d = jA;
        }
        return d;
    }

    static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static ActivityManager.RunningAppProcessInfo a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    public static String a(String str) {
        return a(str, "SHA-1");
    }

    public static String b(String str) {
        return a(str, "SHA-256");
    }

    public static String b(InputStream inputStream) {
        return a(inputStream, "SHA-1");
    }

    private static String a(String str, String str2) {
        return a(str.getBytes(), str2);
    }

    private static String a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            blh.h().e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            blh.h().e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        if (string.length() > 0) {
            return a(string);
        }
        return null;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long c(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static Float c(Context context) {
        if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return null;
        }
        return Float.valueOf(r1.getIntExtra("level", -1) / r1.getIntExtra("scale", -1));
    }

    public static boolean d(Context context) {
        if (f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void a(Context context, String str) {
        if (e(context)) {
            blh.h().a("Fabric", str);
        }
    }

    public static void a(Context context, String str, Throwable th) {
        if (e(context)) {
            blh.h().e("Fabric", str);
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        if (e(context)) {
            blh.h().a(i, "Fabric", str2);
        }
    }

    public static boolean e(Context context) {
        if (b == null) {
            b = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return b.booleanValue();
    }

    public static boolean a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iA = a(context, str, "bool");
            if (iA > 0) {
                return resources.getBoolean(iA);
            }
            int iA2 = a(context, str, "string");
            if (iA2 > 0) {
                return Boolean.parseBoolean(context.getString(iA2));
            }
            return z;
        }
        return z;
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, j(context));
    }

    public static boolean f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean g(Context context) {
        boolean zF = f(context);
        String str = Build.TAGS;
        if ((zF || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zF && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int h(Context context) {
        int i = 0;
        if (f(context)) {
            i = 1;
        }
        if (g(context)) {
            i |= 2;
        }
        if (c()) {
            return i | 4;
        }
        return i;
    }

    public static int a(Context context, boolean z) {
        Float fC = c(context);
        if (!z || fC == null) {
            return 1;
        }
        if (fC.floatValue() >= 99.0d) {
            return 3;
        }
        if (fC.floatValue() < 99.0d) {
            return 2;
        }
        return 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = c[i2 >>> 4];
            cArr[(i * 2) + 1] = c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String b(Context context, String str) {
        int iA = a(context, str, "string");
        return iA > 0 ? context.getString(iA) : "";
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                blh.h().e("Fabric", str, e);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                blh.h().e("Fabric", str, e);
            }
        }
    }

    public static boolean d(String str) {
        return str == null || str.length() == 0;
    }

    public static String j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        return i > 0 ? context.getResources().getResourcePackageName(i) : context.getPackageName();
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                return;
            }
        }
    }

    public static String a(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String k(Context context) throws Throwable {
        InputStream inputStreamOpenRawResource;
        Throwable th;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(l(context));
        } catch (Exception e) {
            e = e;
            inputStreamOpenRawResource = null;
        } catch (Throwable th2) {
            inputStreamOpenRawResource = null;
            th = th2;
            a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
            throw th;
        }
        try {
            try {
                String strB = b(inputStreamOpenRawResource);
                str = d(strB) ? null : strB;
                a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
            } catch (Throwable th3) {
                th = th3;
                a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            blh.h().e("Fabric", "Could not calculate hash for app icon.", e);
            a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
        }
        return str;
    }

    public static int l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m(Context context) {
        int iA = a(context, "io.fabric.android.build_id", "string");
        if (iA == 0) {
            iA = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (iA == 0) {
            return null;
        }
        String string = context.getResources().getString(iA);
        blh.h().a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean n(Context context) {
        if (!c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
