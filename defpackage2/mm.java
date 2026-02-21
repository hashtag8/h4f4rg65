package defpackage;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mm {
    private static boolean c = true;
    private static boolean d = false;
    private static boolean e = true;
    public static String a = f() + "/harmanlog/";
    public static String b = a + "log.txt";
    private static ThreadLocal<List<bsq>> f = new ThreadLocal<>();

    public static void a(boolean z) {
        c = z;
    }

    public static void b(boolean z) {
        d = z;
    }

    private static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static void a() {
        new File(b).delete();
    }

    private static String f() {
        if (!e()) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static void a(Object obj) {
        String str;
        if (!d && c) {
            if (obj != null) {
                str = g() + "==>" + obj.toString();
            } else {
                str = g() + "==>Null";
            }
            Log.e("HKConnect", str);
            b(str);
        }
    }

    public static void b() {
        if (!d && c) {
            String str = g() + "==";
            Log.e("HKConnect", str);
            b(str);
        }
    }

    public static void a(String str, String str2) {
        if (!d && c) {
            String str3 = g() + "==>" + str2.toString();
            Log.e(str, str3);
            b(str3);
        }
    }

    public static void a(String str) {
        if (!d && c) {
            String str2 = g() + "==>" + str.toString();
            System.out.println(str2);
            b(str2);
        }
    }

    public static void a(String str, byte[] bArr) {
        if (!d && c) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; bArr != null && i < bArr.length; i++) {
                String hexString = Integer.toHexString(bArr[i] & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                stringBuffer.append(hexString.toUpperCase());
                stringBuffer.append(",");
            }
            Log.e("communicate", a(stackTrace[3]) + str + "--->>" + ((Object) stringBuffer));
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02X,", Byte.valueOf(b2)));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void b(byte[] bArr) {
        if (!d && c) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            if (bArr == null) {
                stringBuffer.append("null");
            } else {
                for (byte b2 : bArr) {
                    stringBuffer.append((int) b2);
                    stringBuffer.append("-");
                }
            }
            Log.e("HKConnect", a(stackTrace[3]) + "--->>" + ((Object) stringBuffer));
        }
    }

    public static void b(String str) {
        if (!d && c) {
        }
    }

    public static void c() {
        if (!d && c) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(a(stackTraceElement));
                stringBuffer.append("\n");
            }
            Log.d("BACKTRACE_TAG", stringBuffer.toString());
            b(stringBuffer.toString());
        }
    }

    public static void a(Object obj, Object... objArr) {
        if (!d && c) {
            a(2, String.valueOf(obj), objArr);
        }
    }

    public static void b(Object obj, Object... objArr) {
        if (!d && c) {
            a(3, String.valueOf(obj), objArr);
        }
    }

    public static void c(Object obj, Object... objArr) {
        if (!d) {
            a(4, String.valueOf(obj), objArr);
        }
    }

    public static void d(Object obj, Object... objArr) {
        if (!d) {
            a(5, String.valueOf(obj), objArr);
        }
    }

    public static void e(Object obj, Object... objArr) {
        if (!d) {
            a(6, String.valueOf(obj), objArr);
        }
    }

    private static void a(int i, String str, Object... objArr) {
        StackTraceElement[] stackTrace;
        if (!d) {
            StringBuilder sb = new StringBuilder();
            if (c && (stackTrace = Thread.currentThread().getStackTrace()) != null && stackTrace.length >= 5) {
                sb.append(a(stackTrace[4])).append("==>");
            }
            Throwable th = null;
            if (objArr != null && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Throwable)) {
                th = (Throwable) objArr[objArr.length - 1];
                objArr = Arrays.copyOfRange(objArr, 0, objArr.length - 1);
            }
            if (bru.b(str, "%s") != objArr.length) {
                sb.append(String.valueOf(str)).append(' ').append(Arrays.toString(objArr));
            } else {
                try {
                    sb.append(String.format(String.valueOf(str), objArr));
                } catch (RuntimeException e2) {
                    sb.append(String.valueOf(str)).append(Arrays.toString(objArr));
                }
            }
            if (th != null) {
                sb.append("\n").append(Log.getStackTraceString(th));
            }
            Log.println(i, "HKConnect", sb.toString());
        }
    }

    private static String a(StackTraceElement stackTraceElement) {
        StringBuffer stringBuffer = new StringBuffer();
        if (d) {
            String fileName = stackTraceElement.getFileName();
            if (fileName != null) {
                stringBuffer.append(fileName.replace(".java", ""));
            }
        } else {
            stringBuffer.append(stackTraceElement.getClassName());
        }
        stringBuffer.append(".");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("(");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(")");
        stringBuffer.append(" thread " + Thread.currentThread().getId() + " ");
        return stringBuffer.toString();
    }

    private static String g() {
        return a(Thread.currentThread().getStackTrace()[4]);
    }

    public static void b(Object obj) {
        String str;
        if (!d && c) {
            if (obj != null) {
                str = g() + "==>" + obj.toString();
            } else {
                str = g() + "==>Null";
            }
            Log.e("HKConnect", str);
            b(str);
        }
    }

    public static void d() {
        List<bsq> linkedList = f.get();
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            f.set(linkedList);
        }
        bsq bsqVar = new bsq();
        bsqVar.a();
        linkedList.add(bsqVar);
    }

    public static void c(String str) {
        bsq bsqVarRemove = null;
        List<bsq> list = f.get();
        if (list != null && !list.isEmpty()) {
            bsqVarRemove = list.remove(list.size() - 1);
        }
        if (str == null) {
            str = "";
        }
        if (bsqVarRemove == null) {
            b("Timer " + str + " took START NOT CALLED", new Object[0]);
        } else {
            b("Timer " + str + " took " + bru.a(">", list.size()) + String.valueOf(bsqVarRemove.b()) + "/" + bsqVarRemove.c(), new Object[0]);
        }
    }
}
