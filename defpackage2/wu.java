package defpackage;

import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class wu {

    public static class a {
        final long a;
        final String b;

        a(long j, String str) {
            this.a = j;
            this.b = str;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof a) && ((a) obj).a == this.a;
        }

        public int hashCode() {
            return (int) this.a;
        }
    }

    static long a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long a(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        return i != 1 ? i % 2 == 0 ? a((j * j) % 1073807359, i / 2) % 1073807359 : ((a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            su.b("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void a(int i, long j, String str, PriorityQueue<a> priorityQueue) {
        a aVar = new a(j, str);
        if ((priorityQueue.size() != i || priorityQueue.peek().a <= aVar.a) && !priorityQueue.contains(aVar)) {
            priorityQueue.add(aVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void a(String[] strArr, int i, int i2, PriorityQueue<a> priorityQueue) {
        long jB = b(strArr, 0, i2);
        a(i, jB, a(strArr, 0, i2), priorityQueue);
        long jA = a(16785407L, i2 - 1);
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 >= (strArr.length - i2) + 1) {
                return;
            }
            jB = a(ws.a(strArr[i4 - 1]), ws.a(strArr[(i4 + i2) - 1]), jB, jA, 16785407L);
            a(i, jB, a(strArr, i4, i2), priorityQueue);
            i3 = i4 + 1;
        }
    }

    private static long b(String[] strArr, int i, int i2) {
        long jA = (((long) ws.a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            jA = (((jA * 16785407) % 1073807359) + ((((long) ws.a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return jA;
    }
}
