package defpackage;

import java.util.StringTokenizer;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class bks {
    private String a = "";
    private int b = 0;
    private String c = "";

    public static final String a(int i) {
        switch (i) {
            case 100:
                return "Continue";
            case HttpStatus.SC_OK /* 200 */:
                return "OK";
            case HttpStatus.SC_PARTIAL_CONTENT /* 206 */:
                return "Partial Content";
            case HttpStatus.SC_BAD_REQUEST /* 400 */:
                return "Bad Request";
            case HttpStatus.SC_NOT_FOUND /* 404 */:
                return "Not Found";
            case HttpStatus.SC_PRECONDITION_FAILED /* 412 */:
                return "Precondition Failed";
            case HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE /* 416 */:
                return "Invalid Range";
            case HttpStatus.SC_INTERNAL_SERVER_ERROR /* 500 */:
                return "Internal Server Error";
            default:
                return "";
        }
    }

    public bks() {
        a("");
        b(0);
        b("");
    }

    public bks(String str) {
        c(str);
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public static boolean c(int i) {
        return 200 <= i && i < 300;
    }

    public void c(String str) {
        if (str == null) {
            a("1.1");
            b(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            b(a(HttpStatus.SC_INTERNAL_SERVER_ERROR));
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            if (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken().trim());
                if (stringTokenizer.hasMoreTokens()) {
                    int i = 0;
                    try {
                        i = Integer.parseInt(stringTokenizer.nextToken());
                    } catch (Exception e) {
                    }
                    b(i);
                    String str2 = "";
                    while (stringTokenizer.hasMoreTokens()) {
                        if (str2.length() >= 0) {
                            str2 = str2 + " ";
                        }
                        str2 = str2 + stringTokenizer.nextToken();
                    }
                    b(str2.trim());
                }
            }
        } catch (Exception e2) {
        }
    }
}
