package defpackage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class buq {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    private static Log e = LogFactory.getLog(buq.class);
    private static a[] f = {new a("ISO8859_1", "ISO-8859-1", new String[]{"ISO_8859-1:1987", "iso-ir-100", "ISO_8859-1", "latin1", "l1", "IBM819", "CP819", "csISOLatin1", "8859_1", "819", "IBM-819", "ISO8859-1", "ISO_8859_1"}), new a("ISO8859_2", "ISO-8859-2", new String[]{"ISO_8859-2:1987", "iso-ir-101", "ISO_8859-2", "latin2", "l2", "csISOLatin2", "8859_2", "iso8859_2"}), new a("ISO8859_3", "ISO-8859-3", new String[]{"ISO_8859-3:1988", "iso-ir-109", "ISO_8859-3", "latin3", "l3", "csISOLatin3", "8859_3"}), new a("ISO8859_4", "ISO-8859-4", new String[]{"ISO_8859-4:1988", "iso-ir-110", "ISO_8859-4", "latin4", "l4", "csISOLatin4", "8859_4"}), new a("ISO8859_5", "ISO-8859-5", new String[]{"ISO_8859-5:1988", "iso-ir-144", "ISO_8859-5", "cyrillic", "csISOLatinCyrillic", "8859_5"}), new a("ISO8859_6", "ISO-8859-6", new String[]{"ISO_8859-6:1987", "iso-ir-127", "ISO_8859-6", "ECMA-114", "ASMO-708", "arabic", "csISOLatinArabic", "8859_6"}), new a("ISO8859_7", "ISO-8859-7", new String[]{"ISO_8859-7:1987", "iso-ir-126", "ISO_8859-7", "ELOT_928", "ECMA-118", "greek", "greek8", "csISOLatinGreek", "8859_7", "sun_eu_greek"}), new a("ISO8859_8", "ISO-8859-8", new String[]{"ISO_8859-8:1988", "iso-ir-138", "ISO_8859-8", "hebrew", "csISOLatinHebrew", "8859_8"}), new a("ISO8859_9", "ISO-8859-9", new String[]{"ISO_8859-9:1989", "iso-ir-148", "ISO_8859-9", "latin5", "l5", "csISOLatin5", "8859_9"}), new a("ISO8859_13", "ISO-8859-13", new String[0]), new a("ISO8859_15", "ISO-8859-15", new String[]{"ISO_8859-15", "Latin-9", "8859_15", "csISOlatin9", "IBM923", "cp923", "923", "L9", "IBM-923", "ISO8859-15", "LATIN9", "LATIN0", "csISOlatin0", "ISO8859_15_FDIS"}), new a("KOI8_R", "KOI8-R", new String[]{"csKOI8R", "koi8"}), new a(HTTP.ASCII, "US-ASCII", new String[]{"ANSI_X3.4-1968", "iso-ir-6", "ANSI_X3.4-1986", "ISO_646.irv:1991", "ISO646-US", "us", "IBM367", "cp367", "csASCII", "ascii7", "646", "iso_646.irv:1983"}), new a("UTF8", HTTP.UTF_8, new String[0]), new a(HTTP.UTF_16, HTTP.UTF_16, new String[]{"UTF_16"}), new a("UnicodeBigUnmarked", "UTF-16BE", new String[]{"X-UTF-16BE", "UTF_16BE", "ISO-10646-UCS-2"}), new a("UnicodeLittleUnmarked", "UTF-16LE", new String[]{"UTF_16LE", "X-UTF-16LE"}), new a("Big5", "Big5", new String[]{"csBig5", "CN-Big5", "BIG-FIVE", "BIGFIVE"}), new a("Big5_HKSCS", "Big5-HKSCS", new String[]{"big5hkscs"}), new a("EUC_JP", "EUC-JP", new String[]{"csEUCPkdFmtJapanese", "Extended_UNIX_Code_Packed_Format_for_Japanese", "eucjis", "x-eucjp", "eucjp", "x-euc-jp"}), new a("EUC_KR", "EUC-KR", new String[]{"csEUCKR", "ksc5601", "5601", "ksc5601_1987", "ksc_5601", "ksc5601-1987", "ks_c_5601-1987", "euckr"}), new a("GB18030", "GB18030", new String[]{"gb18030-2000"}), new a("EUC_CN", "GB2312", new String[]{"x-EUC-CN", "csGB2312", "euccn", "euc-cn", "gb2312-80", "gb2312-1980", "CN-GB", "CN-GB-ISOIR165"}), new a("GBK", "windows-936", new String[]{"CP936", "MS936", "ms_936", "x-mswin-936"}), new a("Cp037", "IBM037", new String[]{"ebcdic-cp-us", "ebcdic-cp-ca", "ebcdic-cp-wt", "ebcdic-cp-nl", "csIBM037"}), new a("Cp273", "IBM273", new String[]{"csIBM273"}), new a("Cp277", "IBM277", new String[]{"EBCDIC-CP-DK", "EBCDIC-CP-NO", "csIBM277"}), new a("Cp278", "IBM278", new String[]{"CP278", "ebcdic-cp-fi", "ebcdic-cp-se", "csIBM278"}), new a("Cp280", "IBM280", new String[]{"ebcdic-cp-it", "csIBM280"}), new a("Cp284", "IBM284", new String[]{"ebcdic-cp-es", "csIBM284"}), new a("Cp285", "IBM285", new String[]{"ebcdic-cp-gb", "csIBM285"}), new a("Cp297", "IBM297", new String[]{"ebcdic-cp-fr", "csIBM297"}), new a("Cp420", "IBM420", new String[]{"ebcdic-cp-ar1", "csIBM420"}), new a("Cp424", "IBM424", new String[]{"ebcdic-cp-he", "csIBM424"}), new a("Cp437", "IBM437", new String[]{"437", "csPC8CodePage437"}), new a("Cp500", "IBM500", new String[]{"ebcdic-cp-be", "ebcdic-cp-ch", "csIBM500"}), new a("Cp775", "IBM775", new String[]{"csPC775Baltic"}), new a("Cp838", "IBM-Thai", new String[0]), new a("Cp850", "IBM850", new String[]{"850", "csPC850Multilingual"}), new a("Cp852", "IBM852", new String[]{"852", "csPCp852"}), new a("Cp855", "IBM855", new String[]{"855", "csIBM855"}), new a("Cp857", "IBM857", new String[]{"857", "csIBM857"}), new a("Cp858", "IBM00858", new String[]{"CCSID00858", "CP00858", "PC-Multilingual-850+euro"}), new a("Cp860", "IBM860", new String[]{"860", "csIBM860"}), new a("Cp861", "IBM861", new String[]{"861", "cp-is", "csIBM861"}), new a("Cp862", "IBM862", new String[]{"862", "csPC862LatinHebrew"}), new a("Cp863", "IBM863", new String[]{"863", "csIBM863"}), new a("Cp864", "IBM864", new String[]{"cp864", "csIBM864"}), new a("Cp865", "IBM865", new String[]{"865", "csIBM865"}), new a("Cp866", "IBM866", new String[]{"866", "csIBM866"}), new a("Cp868", "IBM868", new String[]{"cp-ar", "csIBM868"}), new a("Cp869", "IBM869", new String[]{"cp-gr", "csIBM869"}), new a("Cp870", "IBM870", new String[]{"ebcdic-cp-roece", "ebcdic-cp-yu", "csIBM870"}), new a("Cp871", "IBM871", new String[]{"ebcdic-cp-is", "csIBM871"}), new a("Cp918", "IBM918", new String[]{"ebcdic-cp-ar2", "csIBM918"}), new a("Cp1026", "IBM1026", new String[]{"csIBM1026"}), new a("Cp1047", "IBM1047", new String[]{"IBM-1047"}), new a("Cp1140", "IBM01140", new String[]{"CCSID01140", "CP01140", "ebcdic-us-37+euro"}), new a("Cp1141", "IBM01141", new String[]{"CCSID01141", "CP01141", "ebcdic-de-273+euro"}), new a("Cp1142", "IBM01142", new String[]{"CCSID01142", "CP01142", "ebcdic-dk-277+euro", "ebcdic-no-277+euro"}), new a("Cp1143", "IBM01143", new String[]{"CCSID01143", "CP01143", "ebcdic-fi-278+euro", "ebcdic-se-278+euro"}), new a("Cp1144", "IBM01144", new String[]{"CCSID01144", "CP01144", "ebcdic-it-280+euro"}), new a("Cp1145", "IBM01145", new String[]{"CCSID01145", "CP01145", "ebcdic-es-284+euro"}), new a("Cp1146", "IBM01146", new String[]{"CCSID01146", "CP01146", "ebcdic-gb-285+euro"}), new a("Cp1147", "IBM01147", new String[]{"CCSID01147", "CP01147", "ebcdic-fr-297+euro"}), new a("Cp1148", "IBM01148", new String[]{"CCSID01148", "CP01148", "ebcdic-international-500+euro"}), new a("Cp1149", "IBM01149", new String[]{"CCSID01149", "CP01149", "ebcdic-is-871+euro"}), new a("Cp1250", "windows-1250", new String[0]), new a("Cp1251", "windows-1251", new String[0]), new a("Cp1252", "windows-1252", new String[0]), new a("Cp1253", "windows-1253", new String[0]), new a("Cp1254", "windows-1254", new String[0]), new a("Cp1255", "windows-1255", new String[0]), new a("Cp1256", "windows-1256", new String[0]), new a("Cp1257", "windows-1257", new String[0]), new a("Cp1258", "windows-1258", new String[0]), new a("ISO2022CN", "ISO-2022-CN", new String[0]), new a("ISO2022JP", "ISO-2022-JP", new String[]{"csISO2022JP", "JIS", "jis_encoding", "csjisencoding"}), new a("ISO2022KR", "ISO-2022-KR", new String[]{"csISO2022KR"}), new a("JIS_X0201", "JIS_X0201", new String[]{"X0201", "JIS0201", "csHalfWidthKatakana"}), new a("JIS_X0212-1990", "JIS_X0212-1990", new String[]{"iso-ir-159", "x0212", "JIS0212", "csISO159JISX02121990"}), new a("JIS_C6626-1983", "JIS_C6626-1983", new String[]{"x-JIS0208", "JIS0208", "csISO87JISX0208", "x0208", "JIS_X0208-1983", "iso-ir-87"}), new a("SJIS", "Shift_JIS", new String[]{"MS_Kanji", "csShiftJIS", "shift-jis", "x-sjis", "pck"}), new a("TIS620", "TIS-620", new String[0]), new a("MS932", "Windows-31J", new String[]{"windows-932", "csWindows31J", "x-ms-cp932"}), new a("EUC_TW", "EUC-TW", new String[]{"x-EUC-TW", "cns11643", "euctw"}), new a("x-Johab", "johab", new String[]{"johab", "cp1361", "ms1361", "ksc5601-1992", "ksc5601_1992"}), new a("MS950_HKSCS", "", new String[0]), new a("MS874", "windows-874", new String[]{"cp874"}), new a("MS949", "windows-949", new String[]{"windows949", "ms_949", "x-windows-949"}), new a("MS950", "windows-950", new String[]{"x-windows-950"}), new a("Cp737", 0 == true ? 1 : 0, new String[0]), new a("Cp856", 0 == true ? 1 : 0, new String[0]), new a("Cp875", 0 == true ? 1 : 0, new String[0]), new a("Cp921", 0 == true ? 1 : 0, new String[0]), new a("Cp922", 0 == true ? 1 : 0, new String[0]), new a("Cp930", 0 == true ? 1 : 0, new String[0]), new a("Cp933", 0 == true ? 1 : 0, new String[0]), new a("Cp935", 0 == true ? 1 : 0, new String[0]), new a("Cp937", 0 == true ? 1 : 0, new String[0]), new a("Cp939", 0 == true ? 1 : 0, new String[0]), new a("Cp942", 0 == true ? 1 : 0, new String[0]), new a("Cp942C", 0 == true ? 1 : 0, new String[0]), new a("Cp943", 0 == true ? 1 : 0, new String[0]), new a("Cp943C", 0 == true ? 1 : 0, new String[0]), new a("Cp948", 0 == true ? 1 : 0, new String[0]), new a("Cp949", 0 == true ? 1 : 0, new String[0]), new a("Cp949C", 0 == true ? 1 : 0, new String[0]), new a("Cp950", 0 == true ? 1 : 0, new String[0]), new a("Cp964", 0 == true ? 1 : 0, new String[0]), new a("Cp970", 0 == true ? 1 : 0, new String[0]), new a("Cp1006", 0 == true ? 1 : 0, new String[0]), new a("Cp1025", 0 == true ? 1 : 0, new String[0]), new a("Cp1046", 0 == true ? 1 : 0, new String[0]), new a("Cp1097", 0 == true ? 1 : 0, new String[0]), new a("Cp1098", 0 == true ? 1 : 0, new String[0]), new a("Cp1112", 0 == true ? 1 : 0, new String[0]), new a("Cp1122", 0 == true ? 1 : 0, new String[0]), new a("Cp1123", 0 == true ? 1 : 0, new String[0]), new a("Cp1124", 0 == true ? 1 : 0, new String[0]), new a("Cp1381", 0 == true ? 1 : 0, new String[0]), new a("Cp1383", 0 == true ? 1 : 0, new String[0]), new a("Cp33722", 0 == true ? 1 : 0, new String[0]), new a("Big5_Solaris", 0 == true ? 1 : 0, new String[0]), new a("EUC_JP_LINUX", 0 == true ? 1 : 0, new String[0]), new a("EUC_JP_Solaris", 0 == true ? 1 : 0, new String[0]), new a("ISCII91", 0 == true ? 1 : 0, new String[]{"x-ISCII91", "iscii"}), new a("ISO2022_CN_CNS", 0 == true ? 1 : 0, new String[0]), new a("ISO2022_CN_GB", 0 == true ? 1 : 0, new String[0]), new a("x-iso-8859-11", 0 == true ? 1 : 0, new String[0]), new a("JISAutoDetect", 0 == true ? 1 : 0, new String[0]), new a("MacArabic", 0 == true ? 1 : 0, new String[0]), new a("MacCentralEurope", 0 == true ? 1 : 0, new String[0]), new a("MacCroatian", 0 == true ? 1 : 0, new String[0]), new a("MacCyrillic", 0 == true ? 1 : 0, new String[0]), new a("MacDingbat", 0 == true ? 1 : 0, new String[0]), new a("MacGreek", "MacGreek", new String[0]), new a("MacHebrew", 0 == true ? 1 : 0, new String[0]), new a("MacIceland", 0 == true ? 1 : 0, new String[0]), new a("MacRoman", "MacRoman", new String[]{"Macintosh", "MAC", "csMacintosh"}), new a("MacRomania", 0 == true ? 1 : 0, new String[0]), new a("MacSymbol", 0 == true ? 1 : 0, new String[0]), new a("MacThai", 0 == true ? 1 : 0, new String[0]), new a("MacTurkish", 0 == true ? 1 : 0, new String[0]), new a("MacUkraine", 0 == true ? 1 : 0, new String[0]), new a("UnicodeBig", 0 == true ? 1 : 0, new String[0]), new a("UnicodeLittle", 0 == true ? 1 : 0, new String[0])};
    private static SortedSet<String> g;
    private static SortedSet<String> h;
    private static Map<String, a> i;

    static {
        g = null;
        h = null;
        i = null;
        g = new TreeSet();
        h = new TreeSet();
        byte[] bArr = {100, 117, 109, 109, 121};
        for (a aVar : f) {
            try {
                new String(bArr, aVar.a);
                g.add(aVar.a.toLowerCase());
            } catch (UnsupportedEncodingException e2) {
            } catch (UnsupportedOperationException e3) {
            }
            try {
                "dummy".getBytes(aVar.a);
                h.add(aVar.a.toLowerCase());
            } catch (UnsupportedEncodingException e4) {
            } catch (UnsupportedOperationException e5) {
            }
        }
        i = new HashMap();
        for (a aVar2 : f) {
            i.put(aVar2.a.toLowerCase(), aVar2);
            if (aVar2.b != null) {
                i.put(aVar2.b.toLowerCase(), aVar2);
            }
            if (aVar2.c != null) {
                for (String str : aVar2.c) {
                    i.put(str.toLowerCase(), aVar2);
                }
            }
        }
        if (e.isDebugEnabled()) {
            e.debug("Character sets which support decoding: " + g);
            e.debug("Character sets which support encoding: " + h);
        }
        a = Charset.forName("US-ASCII");
        b = Charset.forName("ISO-8859-1");
        c = Charset.forName(HTTP.UTF_8);
        d = a;
    }

    static class a implements Comparable<a> {
        private String a;
        private String b;
        private String[] c;

        private a(String str, String str2, String[] strArr) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = str;
            this.b = str2;
            this.c = strArr;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.a.compareTo(aVar.a);
        }
    }

    public static Charset a(String str) {
        if (str == null) {
            str = "ISO-8859-1";
        }
        try {
            return Charset.forName(str);
        } catch (IllegalCharsetNameException e2) {
            e.info("Illegal charset " + str + ", fallback to ISO-8859-1: " + e2);
            return Charset.forName("ISO-8859-1");
        } catch (UnsupportedCharsetException e3) {
            e.info("Unsupported charset " + str + ", fallback to ISO-8859-1: " + e3);
            return Charset.forName("ISO-8859-1");
        }
    }
}
