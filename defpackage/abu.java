package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public enum abu implements abv {
    IDENTITY { // from class: abu.1
        @Override // defpackage.abv
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: abu.2
        @Override // defpackage.abv
        public String a(Field field) {
            return abu.b(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: abu.3
        @Override // defpackage.abv
        public String a(Field field) {
            return abu.b(abu.b(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: abu.4
        @Override // defpackage.abv
        public String a(Field field) {
            return abu.b(field.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: abu.5
        @Override // defpackage.abv
        public String a(Field field) {
            return abu.b(field.getName(), "-").toLowerCase();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char cCharAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i++;
            cCharAt = str.charAt(i);
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (!Character.isUpperCase(cCharAt)) {
            return sb.append(a(Character.toUpperCase(cCharAt), str, i + 1)).toString();
        }
        return str;
    }

    private static String a(char c, String str, int i) {
        return i < str.length() ? c + str.substring(i) : String.valueOf(c);
    }
}
