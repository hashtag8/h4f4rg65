package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class pt {
    private static final Pattern a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    public static ps a(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long jLongValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new ps(jLongValue, Long.valueOf(matcher.group(2), 16).longValue() - jLongValue, matcher.group(3), matcher.group(4));
        } catch (Exception e) {
            blh.h().a("CrashlyticsCore", "Could not parse map entry: " + str);
            return null;
        }
    }
}
