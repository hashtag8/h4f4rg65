package defpackage;

import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class bjj {
    private static final Logger a = Logger.getLogger(bjj.class.getName());

    public static bji a(String str) {
        bjd bjfVar;
        String strTrim;
        String str2;
        String str3;
        String strTrim2;
        String strTrim3;
        String strTrim4;
        String str4;
        String strTrim5;
        String strTrim6;
        String strTrim7;
        String strTrim8;
        String strTrim9;
        String strTrim10;
        String string;
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        String[] strArrSplit = str.split("\n");
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String strTrim11 = null;
        while (i < strArrSplit.length) {
            String str18 = strArrSplit[i];
            if (i == 0) {
                String str19 = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str18.trim();
                strTrim = str19;
            } else if (str18.toUpperCase().startsWith("CACHE-CONTROL:")) {
                strTrim10 = str5;
                String str20 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str18.substring("CACHE-CONTROL:".length()).trim();
                strTrim = str17;
                str2 = str20;
            } else if (str18.toUpperCase().startsWith("DATE:")) {
                strTrim9 = str6;
                strTrim10 = str5;
                String str21 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str18.substring("DATE:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str21;
            } else if (str18.toUpperCase().startsWith("LOCATION:")) {
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str22 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str18.substring("LOCATION:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str22;
            } else if (str18.toUpperCase().startsWith("SERVER:")) {
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str23 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str18.substring("SERVER:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str23;
            } else if (str18.toUpperCase().startsWith("ST:")) {
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str24 = str12;
                str4 = str11;
                strTrim5 = str18.substring("ST:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str24;
            } else if (str18.toUpperCase().startsWith("EXT:")) {
                String strTrim12 = str18.substring("EXT:".length()).trim();
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = strTrim12;
            } else if (str18.toUpperCase().startsWith("USN:")) {
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str25 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str18.substring("USN:".length()).trim();
                strTrim = str17;
                str2 = str25;
            } else if (str18.toUpperCase().startsWith("CONTENT-LENGTH:")) {
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str26 = str14;
                strTrim3 = str18.substring("CONTENT-LENGTH:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str26;
            } else if (str18.toUpperCase().startsWith("HOST:")) {
                strTrim2 = str18.substring("HOST:".length()).trim();
                int iIndexOf = strTrim2.indexOf(":");
                if (iIndexOf > 0) {
                    string = strTrim2.substring(iIndexOf + 1);
                    strTrim2 = strTrim2.substring(0, iIndexOf);
                } else {
                    string = Integer.toString(1900);
                }
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                String str27 = str17;
                str2 = str16;
                str3 = string;
                strTrim = str27;
            } else if (str18.toUpperCase().startsWith("NT:")) {
                String strTrim13 = str18.substring("NT:".length()).trim();
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
                strTrim = str17;
                str2 = strTrim13;
            } else if (str18.toUpperCase().startsWith("NTS:")) {
                strTrim = str18.substring("NTS:".length()).trim();
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
            } else if (str18.toUpperCase().startsWith("MX:")) {
                strTrim11 = str18.substring("MX:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
            } else if (str18.toUpperCase().startsWith("MAN:")) {
                str18.substring("MAN:".length()).trim();
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
            } else {
                arrayList.add(str18);
                strTrim = str17;
                str2 = str16;
                str3 = str15;
                strTrim2 = str14;
                strTrim3 = str13;
                strTrim4 = str12;
                str4 = str11;
                strTrim5 = str10;
                strTrim6 = str9;
                strTrim7 = str8;
                strTrim8 = str7;
                strTrim9 = str6;
                strTrim10 = str5;
            }
            i++;
            str5 = strTrim10;
            str6 = strTrim9;
            str7 = strTrim8;
            str8 = strTrim7;
            str9 = strTrim6;
            str10 = strTrim5;
            str11 = str4;
            str12 = strTrim4;
            str13 = strTrim3;
            str14 = strTrim2;
            str15 = str3;
            str16 = str2;
            str17 = strTrim;
        }
        if (str5 != null && str5.toUpperCase().startsWith("M-SEARCH")) {
            bjg bjgVar = new bjg();
            bjgVar.a(str);
            bjgVar.b(str14);
            bjgVar.e(str15);
            bjgVar.d(strTrim11);
            bjgVar.c(str10);
            bjgVar.a(arrayList);
            return bjgVar;
        }
        if (str5 != null && str5.equalsIgnoreCase("HTTP/1.1 200 OK")) {
            bjh bjhVar = new bjh();
            bjhVar.h(str);
            bjhVar.a(str6);
            bjhVar.b(str7);
            bjhVar.c(str8);
            bjhVar.d(str9);
            bjhVar.e(str10);
            bjhVar.f(str11);
            bjhVar.i(str12);
            bjhVar.g(str13);
            bjhVar.a(arrayList);
            return bjhVar;
        }
        if (str17 != null && str17.trim().length() > 0) {
            if ("ssdp:alive".equals(str17)) {
                bjfVar = new bje();
                ((bje) bjfVar).h(str6);
                ((bje) bjfVar).i(str8);
                ((bje) bjfVar).j(str9);
            } else if ("ssdp:update".equals(str17)) {
                bjfVar = new bjk();
                ((bjk) bjfVar).h(str6);
                ((bjk) bjfVar).i(str8);
                ((bjk) bjfVar).j(str9);
            } else if ("ssdp:byebye".equals(str17)) {
                bjfVar = new bjf();
                ((bjf) bjfVar).h(str13);
            } else {
                return null;
            }
            bjfVar.a(str);
            bjfVar.f(str5);
            bjfVar.c(str14);
            bjfVar.g(str15);
            bjfVar.d(str16);
            bjfVar.e(str17);
            bjfVar.b(str12);
            bjfVar.a(arrayList);
            return bjfVar;
        }
        a.finest("Message not  : \n" + str);
        return null;
    }
}
