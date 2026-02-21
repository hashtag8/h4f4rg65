package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class aht {
    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String str : availableIDs) {
            String strA = a(TimeZone.getTimeZone(str));
            System.out.println(strA);
            arrayList.add(strA);
        }
        System.out.println("\nTotal TimeZone ID " + availableIDs.length);
        return arrayList;
    }

    public static String a(TimeZone timeZone) {
        long hours = TimeUnit.MILLISECONDS.toHours(timeZone.getRawOffset());
        long jAbs = Math.abs(TimeUnit.MILLISECONDS.toMinutes(timeZone.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours));
        mm.b("TimeZoneUtil Hours =  " + hours, new Object[0]);
        if (hours >= 0) {
            return String.format("%s (GMT+%d:%02d)", timeZone.getID(), Long.valueOf(hours), Long.valueOf(jAbs));
        }
        return String.format("%s (GMT%d:%02d)", timeZone.getID(), Long.valueOf(hours), Long.valueOf(jAbs));
    }

    public static String b() {
        return a(TimeZone.getDefault());
    }

    public static byte a(String str) {
        String strSubstring;
        try {
            if (str.contains("+")) {
                strSubstring = str.substring(str.indexOf("+"), str.lastIndexOf(")"));
            } else {
                strSubstring = str.substring(str.indexOf("-"), str.lastIndexOf(")"));
            }
            switch (strSubstring) {
            }
            return (byte) 0;
        } catch (Exception e) {
            mm.a((Object) (str + "is error"));
            return (byte) 0;
        }
    }

    public static byte a(int[] iArr) {
        switch (iArr[0]) {
            case 0:
                return (byte) 13;
            case 1:
                return (byte) 2;
            case 2:
                return (byte) 3;
            case 3:
                return (byte) 4;
            case 4:
                return (byte) 5;
            case 5:
                return (byte) 6;
            case 6:
                return (byte) 7;
            case 7:
                return (byte) 8;
            case 8:
                return (byte) 9;
            case 9:
                return (byte) 10;
            case 10:
                return (byte) 11;
            case 11:
                return (byte) 12;
            case 12:
                return (byte) 1;
            case 13:
                return (byte) 14;
            case 14:
                return (byte) 15;
            case 15:
                return (byte) 16;
            case 16:
                return (byte) 17;
            case 17:
                return (byte) 18;
            case 18:
                return (byte) 19;
            case 19:
                return (byte) 20;
            case 20:
                return (byte) 21;
            case 21:
                return (byte) 22;
            case 22:
                return (byte) 23;
            case 23:
                return (byte) 24;
            default:
                return (byte) 0;
        }
    }

    public static int[] a(byte b) {
        int[] iArr = new int[2];
        switch (b) {
            case 1:
                iArr[0] = 12;
            case 2:
                iArr[0] = 1;
            case 3:
                iArr[0] = 2;
            case 4:
                iArr[0] = 3;
            case 5:
                iArr[0] = 4;
            case 6:
                iArr[0] = 5;
            case 7:
                iArr[0] = 6;
            case 8:
                iArr[0] = 7;
            case 9:
                iArr[0] = 8;
            case 10:
                iArr[0] = 9;
            case 11:
                iArr[0] = 10;
            case 12:
                iArr[0] = 11;
            case 13:
                iArr[0] = 24;
            case 14:
                iArr[0] = 13;
            case 15:
                iArr[0] = 14;
            case 16:
                iArr[0] = 15;
            case 17:
                iArr[0] = 16;
            case 18:
                iArr[0] = 17;
            case 19:
                iArr[0] = 18;
            case 20:
                iArr[0] = 19;
            case 21:
                iArr[0] = 20;
            case 22:
                iArr[0] = 21;
            case 23:
                iArr[0] = 22;
            case 24:
                iArr[0] = 23;
                break;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        return iArr;
    }
}
