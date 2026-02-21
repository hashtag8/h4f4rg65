package defpackage;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes.dex */
public final class but {
    private static final Log a = LogFactory.getLog(but.class);
    private static final Random b = new Random();
    private static int c = 0;
    private static final ThreadLocal<DateFormat> d = new ThreadLocal<DateFormat>() { // from class: but.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            return new a();
        }
    };

    private but() {
    }

    public static boolean a(String str) {
        return "base64".equalsIgnoreCase(str);
    }

    public static boolean b(String str) {
        return "quoted-printable".equalsIgnoreCase(str);
    }

    public static String a() {
        return "-=Part." + Integer.toHexString(b()) + '.' + Long.toHexString(b.nextLong()) + '.' + Long.toHexString(System.currentTimeMillis()) + '.' + Long.toHexString(b.nextLong()) + "=-";
    }

    public static String a(Date date, TimeZone timeZone) {
        DateFormat dateFormat = d.get();
        if (timeZone == null) {
            dateFormat.setTimeZone(TimeZone.getDefault());
        } else {
            dateFormat.setTimeZone(timeZone);
        }
        return dateFormat.format(date);
    }

    public static String a(String str, int i) {
        int length = str.length();
        if (i + length > 76) {
            StringBuilder sb = new StringBuilder();
            int i2 = -i;
            int iB = b(str, 0);
            while (iB != length) {
                int iB2 = b(str, iB + 1);
                if (iB2 - i2 > 76) {
                    sb.append(str.substring(Math.max(0, i2), iB));
                    sb.append("\r\n");
                } else {
                    iB = i2;
                }
                i2 = iB;
                iB = iB2;
            }
            sb.append(str.substring(Math.max(0, i2)));
            return sb.toString();
        }
        return str;
    }

    private static int b(String str, int i) {
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                i2++;
            } else {
                return i2;
            }
        }
        return length;
    }

    private static synchronized int b() {
        int i;
        i = c;
        c = i + 1;
        return i;
    }

    static final class a extends SimpleDateFormat {
        public a() {
            super("EEE, d MMM yyyy HH:mm:ss ", Locale.US);
        }

        @Override // java.text.SimpleDateFormat, java.text.DateFormat
        public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            StringBuffer stringBuffer2 = super.format(date, stringBuffer, fieldPosition);
            int i = ((this.calendar.get(15) + this.calendar.get(16)) / 1000) / 60;
            if (i < 0) {
                stringBuffer2.append('-');
                i = -i;
            } else {
                stringBuffer2.append('+');
            }
            stringBuffer2.append(String.format("%02d%02d", Integer.valueOf(i / 60), Integer.valueOf(i % 60)));
            return stringBuffer2;
        }
    }
}
