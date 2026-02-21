package defpackage;

import android.app.ActivityManager;
import defpackage.bml;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class py {
    private static final ol a = ol.a("0");
    private static final ol b = ol.a("Unity");

    public static void a(oo ooVar, String str, String str2, long j) {
        ooVar.a(1, ol.a(str2));
        ooVar.a(2, ol.a(str));
        ooVar.a(3, j);
    }

    public static void a(oo ooVar, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        ol olVarA = ol.a(str);
        ol olVarA2 = ol.a(str2);
        ol olVarA3 = ol.a(str3);
        ol olVarA4 = ol.a(str4);
        ol olVarA5 = ol.a(str5);
        ol olVarA6 = str6 != null ? ol.a(str6) : null;
        ooVar.g(7, 2);
        ooVar.k(a(olVarA, olVarA2, olVarA3, olVarA4, olVarA5, i, olVarA6));
        ooVar.a(1, olVarA);
        ooVar.a(2, olVarA3);
        ooVar.a(3, olVarA4);
        ooVar.g(5, 2);
        ooVar.k(a(olVarA2));
        ooVar.a(1, olVarA2);
        ooVar.a(6, olVarA5);
        if (olVarA6 != null) {
            ooVar.a(8, b);
            ooVar.a(9, olVarA6);
        }
        ooVar.b(10, i);
    }

    public static void a(oo ooVar, String str, String str2, boolean z) {
        ol olVarA = ol.a(str);
        ol olVarA2 = ol.a(str2);
        ooVar.g(8, 2);
        ooVar.k(a(olVarA, olVarA2, z));
        ooVar.b(1, 3);
        ooVar.a(2, olVarA);
        ooVar.a(3, olVarA2);
        ooVar.a(4, z);
    }

    public static void a(oo ooVar, int i, String str, int i2, long j, long j2, boolean z, Map<bml.a, String> map, int i3, String str2, String str3) {
        ol olVarA = a(str);
        ol olVarA2 = a(str3);
        ol olVarA3 = a(str2);
        ooVar.g(9, 2);
        ooVar.k(a(i, olVarA, i2, j, j2, z, map, i3, olVarA3, olVarA2));
        ooVar.b(3, i);
        ooVar.a(4, olVarA);
        ooVar.a(5, i2);
        ooVar.a(6, j);
        ooVar.a(7, j2);
        ooVar.a(10, z);
        for (Map.Entry<bml.a, String> entry : map.entrySet()) {
            ooVar.g(11, 2);
            ooVar.k(a(entry.getKey(), entry.getValue()));
            ooVar.b(1, entry.getKey().h);
            ooVar.a(2, ol.a(entry.getValue()));
        }
        ooVar.a(12, i3);
        if (olVarA3 != null) {
            ooVar.a(13, olVarA3);
        }
        if (olVarA2 != null) {
            ooVar.a(14, olVarA2);
        }
    }

    public static void a(oo ooVar, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        ol olVarA = ol.a(str);
        ol olVarA2 = a(str2);
        ol olVarA3 = a(str3);
        int iB = 0 + oo.b(1, olVarA);
        if (str2 != null) {
            iB += oo.b(2, olVarA2);
        }
        if (str3 != null) {
            iB += oo.b(3, olVarA3);
        }
        ooVar.g(6, 2);
        ooVar.k(iB);
        ooVar.a(1, olVarA);
        if (str2 != null) {
            ooVar.a(2, olVarA2);
        }
        if (str3 != null) {
            ooVar.a(3, olVarA3);
        }
    }

    public static void a(oo ooVar, long j, String str, qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, pi piVar, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) {
        ol olVarA = ol.a(str2);
        ol olVarA2 = str3 == null ? null : ol.a(str3.replace("-", ""));
        ol olVarA3 = piVar.a();
        if (olVarA3 == null) {
            blh.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        piVar.c();
        ooVar.g(10, 2);
        ooVar.k(a(j, str, qcVar, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, olVarA, olVarA2, f, i2, z, j2, j3, olVarA3));
        ooVar.a(1, j);
        ooVar.a(2, ol.a(str));
        a(ooVar, qcVar, thread, stackTraceElementArr, threadArr, list, 8, olVarA, olVarA2, map, runningAppProcessInfo, i);
        a(ooVar, f, i2, z, i, j2, j3);
        a(ooVar, olVarA3);
    }

    private static void a(oo ooVar, qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ol olVar, ol olVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws IOException {
        ooVar.g(3, 2);
        ooVar.k(a(qcVar, thread, stackTraceElementArr, threadArr, list, i, olVar, olVar2, map, runningAppProcessInfo, i2));
        a(ooVar, qcVar, thread, stackTraceElementArr, threadArr, list, i, olVar, olVar2);
        if (map != null && !map.isEmpty()) {
            a(ooVar, map);
        }
        if (runningAppProcessInfo != null) {
            ooVar.a(3, runningAppProcessInfo.importance != 100);
        }
        ooVar.a(4, i2);
    }

    private static void a(oo ooVar, qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ol olVar, ol olVar2) throws IOException {
        ooVar.g(1, 2);
        ooVar.k(a(qcVar, thread, stackTraceElementArr, threadArr, list, i, olVar, olVar2));
        a(ooVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            a(ooVar, threadArr[i2], list.get(i2), 0, false);
        }
        a(ooVar, qcVar, 1, i, 2);
        ooVar.g(3, 2);
        ooVar.k(a());
        ooVar.a(1, a);
        ooVar.a(2, a);
        ooVar.a(3, 0L);
        ooVar.g(4, 2);
        ooVar.k(a(olVar, olVar2));
        ooVar.a(1, 0L);
        ooVar.a(2, 0L);
        ooVar.a(3, olVar);
        if (olVar2 != null) {
            ooVar.a(4, olVar2);
        }
    }

    private static void a(oo ooVar, Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ooVar.g(2, 2);
            ooVar.k(a(entry.getKey(), entry.getValue()));
            ooVar.a(1, ol.a(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            ooVar.a(2, ol.a(value));
        }
    }

    private static void a(oo ooVar, qc qcVar, int i, int i2, int i3) throws IOException {
        int i4 = 0;
        ooVar.g(i3, 2);
        ooVar.k(a(qcVar, 1, i2));
        ooVar.a(1, ol.a(qcVar.b));
        String str = qcVar.a;
        if (str != null) {
            ooVar.a(3, ol.a(str));
        }
        for (StackTraceElement stackTraceElement : qcVar.c) {
            a(ooVar, 4, stackTraceElement, true);
        }
        qc qcVar2 = qcVar.d;
        if (qcVar2 != null) {
            if (i < i2) {
                a(ooVar, qcVar2, i + 1, i2, 6);
                return;
            }
            while (qcVar2 != null) {
                qcVar2 = qcVar2.d;
                i4++;
            }
            ooVar.a(7, i4);
        }
    }

    private static void a(oo ooVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws IOException {
        ooVar.g(1, 2);
        ooVar.k(a(thread, stackTraceElementArr, i, z));
        ooVar.a(1, ol.a(thread.getName()));
        ooVar.a(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(ooVar, 3, stackTraceElement, z);
        }
    }

    private static void a(oo ooVar, int i, StackTraceElement stackTraceElement, boolean z) throws IOException {
        ooVar.g(i, 2);
        ooVar.k(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            ooVar.a(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            ooVar.a(1, 0L);
        }
        ooVar.a(2, ol.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            ooVar.a(3, ol.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            ooVar.a(4, stackTraceElement.getLineNumber());
        }
        ooVar.a(5, z ? 4 : 0);
    }

    private static void a(oo ooVar, Float f, int i, boolean z, int i2, long j, long j2) throws IOException {
        ooVar.g(5, 2);
        ooVar.k(a(f, i, z, i2, j, j2));
        if (f != null) {
            ooVar.a(1, f.floatValue());
        }
        ooVar.c(2, i);
        ooVar.a(3, z);
        ooVar.a(4, i2);
        ooVar.a(5, j);
        ooVar.a(6, j2);
    }

    private static void a(oo ooVar, ol olVar) throws IOException {
        if (olVar != null) {
            ooVar.g(6, 2);
            ooVar.k(b(olVar));
            ooVar.a(1, olVar);
        }
    }

    private static int a(ol olVar, ol olVar2, ol olVar3, ol olVar4, ol olVar5, int i, ol olVar6) {
        int iB = 0 + oo.b(1, olVar) + oo.b(2, olVar3) + oo.b(3, olVar4);
        int iA = a(olVar2);
        int iJ = iB + iA + oo.j(5) + oo.l(iA) + oo.b(6, olVar5);
        if (olVar6 != null) {
            iJ = iJ + oo.b(8, b) + oo.b(9, olVar6);
        }
        return iJ + oo.e(10, i);
    }

    private static int a(ol olVar) {
        return 0 + oo.b(1, olVar);
    }

    private static int a(ol olVar, ol olVar2, boolean z) {
        return 0 + oo.e(1, 3) + oo.b(2, olVar) + oo.b(3, olVar2) + oo.b(4, z);
    }

    private static int a(bml.a aVar, String str) {
        return oo.e(1, aVar.h) + oo.b(2, ol.a(str));
    }

    private static int a(int i, ol olVar, int i2, long j, long j2, boolean z, Map<bml.a, String> map, int i3, ol olVar2, ol olVar3) {
        int i4;
        int iB = (olVar == null ? 0 : oo.b(4, olVar)) + oo.e(3, i) + 0 + oo.d(5, i2) + oo.b(6, j) + oo.b(7, j2) + oo.b(10, z);
        if (map != null) {
            Iterator<Map.Entry<bml.a, String>> it = map.entrySet().iterator();
            while (true) {
                i4 = iB;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<bml.a, String> next = it.next();
                int iA = a(next.getKey(), next.getValue());
                iB = iA + oo.j(11) + oo.l(iA) + i4;
            }
        } else {
            i4 = iB;
        }
        return (olVar3 == null ? 0 : oo.b(14, olVar3)) + i4 + oo.d(12, i3) + (olVar2 == null ? 0 : oo.b(13, olVar2));
    }

    private static int a(ol olVar, ol olVar2) {
        int iB = 0 + oo.b(1, 0L) + oo.b(2, 0L) + oo.b(3, olVar);
        if (olVar2 != null) {
            return iB + oo.b(4, olVar2);
        }
        return iB;
    }

    private static int a(long j, String str, qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, ol olVar, ol olVar2, Float f, int i3, boolean z, long j2, long j3, ol olVar3) {
        int iB = 0 + oo.b(1, j) + oo.b(2, ol.a(str));
        int iA = a(qcVar, thread, stackTraceElementArr, threadArr, list, i, olVar, olVar2, map, runningAppProcessInfo, i2);
        int iJ = iB + iA + oo.j(3) + oo.l(iA);
        int iA2 = a(f, i3, z, i2, j2, j3);
        int iJ2 = iA2 + oo.j(5) + oo.l(iA2) + iJ;
        if (olVar3 != null) {
            int iB2 = b(olVar3);
            return iJ2 + iB2 + oo.j(6) + oo.l(iB2);
        }
        return iJ2;
    }

    private static int a(qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ol olVar, ol olVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int i3;
        int iB;
        int i4;
        int iA = a(qcVar, thread, stackTraceElementArr, threadArr, list, i, olVar, olVar2);
        int iJ = 0 + iA + oo.j(1) + oo.l(iA);
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                i4 = iJ;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                int iA2 = a(next.getKey(), next.getValue());
                iJ = iA2 + oo.j(2) + oo.l(iA2) + i4;
            }
            i3 = i4;
        } else {
            i3 = iJ;
        }
        if (runningAppProcessInfo != null) {
            iB = oo.b(3, runningAppProcessInfo.importance != 100) + i3;
        } else {
            iB = i3;
        }
        return iB + oo.d(4, i2);
    }

    private static int a(qc qcVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ol olVar, ol olVar2) {
        int iA = a(thread, stackTraceElementArr, 4, true);
        int iJ = iA + oo.j(1) + oo.l(iA) + 0;
        int length = threadArr.length;
        int iJ2 = iJ;
        for (int i2 = 0; i2 < length; i2++) {
            int iA2 = a(threadArr[i2], list.get(i2), 0, false);
            iJ2 += iA2 + oo.j(1) + oo.l(iA2);
        }
        int iA3 = a(qcVar, 1, i);
        int iJ3 = iA3 + oo.j(2) + oo.l(iA3) + iJ2;
        int iA4 = a();
        int iJ4 = iJ3 + iA4 + oo.j(3) + oo.l(iA4);
        int iA5 = a(olVar, olVar2);
        return iJ4 + iA5 + oo.j(3) + oo.l(iA5);
    }

    private static int a(String str, String str2) {
        int iB = oo.b(1, ol.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return iB + oo.b(2, ol.a(str2));
    }

    private static int a(Float f, int i, boolean z, int i2, long j, long j2) {
        return (f != null ? 0 + oo.b(1, f.floatValue()) : 0) + oo.f(2, i) + oo.b(3, z) + oo.d(4, i2) + oo.b(5, j) + oo.b(6, j2);
    }

    private static int b(ol olVar) {
        return oo.b(1, olVar);
    }

    private static int a(qc qcVar, int i, int i2) {
        int i3 = 0;
        int iB = oo.b(1, ol.a(qcVar.b)) + 0;
        String str = qcVar.a;
        if (str != null) {
            iB += oo.b(3, ol.a(str));
        }
        StackTraceElement[] stackTraceElementArr = qcVar.c;
        int length = stackTraceElementArr.length;
        int i4 = 0;
        while (i4 < length) {
            int iA = a(stackTraceElementArr[i4], true);
            i4++;
            iB = iA + oo.j(4) + oo.l(iA) + iB;
        }
        qc qcVar2 = qcVar.d;
        if (qcVar2 != null) {
            if (i < i2) {
                int iA2 = a(qcVar2, i + 1, i2);
                return iB + iA2 + oo.j(6) + oo.l(iA2);
            }
            while (qcVar2 != null) {
                qcVar2 = qcVar2.d;
                i3++;
            }
            return iB + oo.d(7, i3);
        }
        return iB;
    }

    private static int a() {
        return 0 + oo.b(1, a) + oo.b(2, a) + oo.b(3, 0L);
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int iB;
        if (stackTraceElement.isNativeMethod()) {
            iB = oo.b(1, Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            iB = oo.b(1, 0L) + 0;
        }
        int iB2 = iB + oo.b(2, ol.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            iB2 += oo.b(3, ol.a(stackTraceElement.getFileName()));
        }
        return oo.d(5, z ? 2 : 0) + ((stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) ? iB2 : iB2 + oo.b(4, stackTraceElement.getLineNumber()));
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int iD = oo.d(2, i) + oo.b(1, ol.a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iA = a(stackTraceElement, z);
            iD += iA + oo.j(3) + oo.l(iA);
        }
        return iD;
    }

    private static ol a(String str) {
        if (str == null) {
            return null;
        }
        return ol.a(str);
    }
}
