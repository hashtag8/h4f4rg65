package defpackage;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
public final class ast {
    public static final ast a = new ast();
    private static final String b = ast.class.getSimpleName();
    private static List<asp> c = new ArrayList();
    private static ass d;

    static final class a extends bpk implements bph<bpf> {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ ass c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Context context, ass assVar) {
            super(0);
            this.a = str;
            this.b = context;
            this.c = assVar;
        }

        @Override // defpackage.bph
        public /* synthetic */ bpf a() throws Throwable {
            b();
            return bpf.a;
        }

        public final void b() throws Throwable {
            List listA = ast.a.a(this.a);
            if (listA != null) {
                ast.a.a(this.b, (List<asp>) listA);
                ass assVar = this.c;
                if (assVar != null) {
                    assVar.a(ast.a(ast.a));
                    return;
                }
                return;
            }
            ast.a.a();
        }
    }

    private ast() {
    }

    public static final /* synthetic */ List a(ast astVar) {
        return c;
    }

    public final void a(Context context, String str, ass assVar) {
        bpj.b(context, "context");
        bpj.b(str, "url");
        d = assVar;
        if (c.isEmpty()) {
            bpg.a((31 & 1) != 0, (31 & 2) != 0 ? false : false, (31 & 4) != 0 ? (ClassLoader) null : null, (31 & 8) != 0 ? (String) null : null, (31 & 16) != 0 ? -1 : 0, new a(str, context, assVar));
        } else if (assVar != null) {
            assVar.a(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        ass assVar;
        c.clear();
        c.add(new asp("EULA_HKController", "1.0.0", "", "EULA_HKController_Android.txt"));
        c.add(new asp("PrivacyPolicy", "1.0.0", "", "PrivacyPolicy.txt"));
        if (d != null && (assVar = d) != null) {
            assVar.a(c);
        }
        mm.c("download eula failed, reset to default version", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final List<asp> a(String str) {
        asp aspVar;
        ArrayList arrayList = new ArrayList();
        try {
            URL url = new URL(str);
            mm.b("URL:" + url, new Object[0]);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new bpe("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParserNewPullParser.setInput(httpURLConnection.getInputStream(), null);
                bpj.a((Object) xmlPullParserNewPullParser, "parser");
                StringBuilder sb = new StringBuilder();
                asp aspVar2 = new asp("", "", "", "");
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    switch (eventType) {
                        case 2:
                            if (bpo.a(xmlPullParserNewPullParser.getName(), "Release", true)) {
                                aspVar = new asp("", "", "", "");
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(0);
                                bpj.a((Object) attributeValue, "parser.getAttributeValue(0)");
                                aspVar.a(attributeValue);
                                String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(1);
                                bpj.a((Object) attributeValue2, "parser.getAttributeValue(1)");
                                aspVar.b(attributeValue2);
                                mm.b("START_TAG: name:" + aspVar.a() + ", version:" + aspVar.b(), new Object[0]);
                            } else {
                                aspVar = aspVar2;
                            }
                            sb.setLength(0);
                            break;
                        case 3:
                            if (bpj.a((Object) xmlPullParserNewPullParser.getName(), (Object) "Release")) {
                                String string = sb.toString();
                                bpj.a((Object) string, "builder.toString()");
                                aspVar2.c(string);
                                arrayList.add(aspVar2);
                                mm.b("END_TAG:" + sb.toString(), new Object[0]);
                            }
                            aspVar = aspVar2;
                            break;
                        case 4:
                            String text = xmlPullParserNewPullParser.getText();
                            bpj.a((Object) text, "parser.text");
                            String str2 = text;
                            int length = str2.length() - 1;
                            boolean z = false;
                            int i = 0;
                            while (i <= length) {
                                boolean z2 = str2.charAt(!z ? i : length) <= ' ';
                                if (z) {
                                    if (!z2) {
                                        sb.append(str2.subSequence(i, length + 1).toString());
                                        mm.b("TEXT:" + sb.toString(), new Object[0]);
                                        aspVar = aspVar2;
                                    } else {
                                        length--;
                                    }
                                    break;
                                } else if (z2) {
                                    i++;
                                } else {
                                    z = true;
                                }
                            }
                            sb.append(str2.subSequence(i, length + 1).toString());
                            mm.b("TEXT:" + sb.toString(), new Object[0]);
                            aspVar = aspVar2;
                            break;
                        default:
                            aspVar = aspVar2;
                            break;
                    }
                    aspVar2 = aspVar;
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                mm.b(b, "Parse xml exception: " + e.getMessage());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            mm.b(b, "Parse xml IO exception: " + e2.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(Context context, List<asp> list) throws Throwable {
        if (list != null) {
            for (asp aspVar : list) {
                String strA = aspVar.a();
                switch (strA.hashCode()) {
                    case -1956897094:
                        if (strA.equals("PrivacyPolicy")) {
                            String strD = aho.d("PrivacyPolicy");
                            String strB = aspVar.b();
                            bpj.a((Object) strD, "privacyVer");
                            boolean zA = a(strB, strD);
                            mm.c("is privacy version changed " + zA + ", " + aspVar.b() + ", " + strD, new Object[0]);
                            if (zA) {
                                aho.a("LEGAL_PERSIST", false);
                                aho.a("PrivacyPolicy", aspVar.b());
                                mm.c("saving new version " + aspVar.b() + " policy file", new Object[0]);
                                String strC = aspVar.c();
                                StringBuilder sb = new StringBuilder();
                                File filesDir = context.getFilesDir();
                                bpj.a((Object) filesDir, "context.filesDir");
                                b(strC, sb.append(filesDir.getPath()).append(File.separator).append("PrivacyPolicy.txt").toString());
                                StringBuilder sb2 = new StringBuilder();
                                File filesDir2 = context.getFilesDir();
                                bpj.a((Object) filesDir2, "context.filesDir");
                                aspVar.c(sb2.append(filesDir2.getPath()).append(File.separator).append("PrivacyPolicy.txt").toString());
                            }
                            aspVar.d("PrivacyPolicy.txt");
                            if (!c.contains(aspVar)) {
                                c.add(aspVar);
                            }
                        }
                        break;
                    case -1844328231:
                        if (strA.equals("EULA_HKController")) {
                            String strD2 = aho.d("EULA_HKController");
                            String strB2 = aspVar.b();
                            bpj.a((Object) strD2, "eulaVer");
                            boolean zA2 = a(strB2, strD2);
                            mm.c("is EULA version changed " + zA2 + ", " + aspVar.b() + ", " + strD2, new Object[0]);
                            if (zA2) {
                                aho.a("LEGAL_PERSIST", false);
                                aho.a("EULA_HKController", aspVar.b());
                                mm.c("saving new version " + aspVar.b() + " EULA file", new Object[0]);
                                String strC2 = aspVar.c();
                                StringBuilder sb3 = new StringBuilder();
                                File filesDir3 = context.getFilesDir();
                                bpj.a((Object) filesDir3, "context.filesDir");
                                b(strC2, sb3.append(filesDir3.getPath()).append(File.separator).append("EULA_HKController_Android.txt").toString());
                                StringBuilder sb4 = new StringBuilder();
                                File filesDir4 = context.getFilesDir();
                                bpj.a((Object) filesDir4, "context.filesDir");
                                aspVar.c(sb4.append(filesDir4.getPath()).append(File.separator).append("EULA_HKController_Android.txt").toString());
                            }
                            aspVar.d("EULA_HKController_Android.txt");
                            if (!c.contains(aspVar)) {
                                c.add(aspVar);
                            }
                        }
                        break;
                }
            }
        }
    }

    private final boolean a(String str, String str2) {
        String[] strArr = new String[3];
        String[] strArr2 = new String[3];
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i] = stringTokenizer.nextToken();
            i++;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str2, ".");
        int i2 = 0;
        while (stringTokenizer2.hasMoreTokens()) {
            strArr2[i2] = stringTokenizer2.nextToken();
            i2++;
        }
        try {
            if (Integer.parseInt(strArr[0]) > Integer.parseInt(strArr2[0])) {
                return true;
            }
            if (Integer.parseInt(strArr[0]) != Integer.parseInt(strArr2[0])) {
                return false;
            }
            if (Integer.parseInt(strArr[1]) > Integer.parseInt(strArr2[1])) {
                return true;
            }
            if (Integer.parseInt(strArr[1]) == Integer.parseInt(strArr2[1])) {
                return Integer.parseInt(strArr[2]) > Integer.parseInt(strArr2[2]);
            }
            return false;
        } catch (Exception e) {
            mm.b(b, "Version compare Exception " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r3 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveFile = "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = ", "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            defpackage.mm.b(r1, r2)
            r1 = 0
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            java.io.File r3 = new java.io.File
            r3.<init>(r9)
            java.net.URL r2 = new java.net.URL     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            r2.<init>(r8)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            if (r2 != 0) goto L66
            bpe r2 = new bpe     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.lang.String r3 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r2.<init>(r3)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            throw r2     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
        L3f:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0
            r3.<init>()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r4 = "save file failed msg="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> Lb0
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb0
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lb0
            defpackage.mm.e(r1, r3)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L65
            r2.disconnect()
        L65:
            return
        L66:
            r0 = r2
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            r1 = r0
            int r2 = r1.getResponseCode()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 != r2) goto La0
            r1.connect()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.lang.String r2 = "connection.inputStream"
            defpackage.bpj.a(r4, r2)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            r5.<init>(r3)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            int r2 = r4.read()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
        L87:
            r3 = -1
            if (r2 == r3) goto L92
            r5.write(r2)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            int r2 = r4.read()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            goto L87
        L92:
            r4.close()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            r5.close()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            java.lang.String r2 = "save eula file success"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
            defpackage.mm.c(r2, r3)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> La6
        La0:
            if (r1 == 0) goto L65
            r1.disconnect()
            goto L65
        La6:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        Laa:
            if (r2 == 0) goto Laf
            r2.disconnect()
        Laf:
            throw r1
        Lb0:
            r1 = move-exception
            goto Laa
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ast.b(java.lang.String, java.lang.String):void");
    }
}
