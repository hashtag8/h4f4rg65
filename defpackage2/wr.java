package defpackage;

import android.util.Base64OutputStream;
import defpackage.wu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class wr {
    private final int b;
    private final wq d = new wt();
    private final int a = 6;
    private final int c = 0;

    static class a {
        ByteArrayOutputStream a = new ByteArrayOutputStream(4096);
        Base64OutputStream b = new Base64OutputStream(this.a, 10);

        public void a(byte[] bArr) {
            this.b.write(bArr);
        }

        public String toString() {
            String string;
            try {
                this.b.close();
            } catch (IOException e) {
                su.b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.a.close();
                string = this.a.toString();
            } catch (IOException e2) {
                su.b("HashManager: Unable to convert to Base64.", e2);
                string = "";
            } finally {
                this.a = null;
                this.b = null;
            }
            return string;
        }
    }

    public wr(int i) {
        this.b = i;
    }

    private String b(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        a aVarA = a();
        Arrays.sort(strArrSplit, new Comparator<String>() { // from class: wr.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                return str3.length() - str2.length();
            }
        });
        for (int i = 0; i < strArrSplit.length && i < this.b; i++) {
            if (strArrSplit[i].trim().length() != 0) {
                try {
                    aVarA.a(this.d.a(strArrSplit[i]));
                } catch (IOException e) {
                    su.b("Error while writing hash to byteStream", e);
                }
            }
        }
        return aVarA.toString();
    }

    String a(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        a aVarA = a();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new Comparator<wu.a>() { // from class: wr.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(wu.a aVar, wu.a aVar2) {
                return (int) (aVar.a - aVar2.a);
            }
        });
        for (String str2 : strArrSplit) {
            String[] strArrB = ws.b(str2);
            if (strArrB.length >= this.a) {
                wu.a(strArrB, this.b, this.a, (PriorityQueue<wu.a>) priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                aVarA.a(this.d.a(((wu.a) it.next()).b));
            } catch (IOException e) {
                su.b("Error while writing hash to byteStream", e);
            }
        }
        return aVarA.toString();
    }

    public String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.c) {
            case 0:
                return a(stringBuffer.toString());
            case 1:
                return b(stringBuffer.toString());
            default:
                return "";
        }
    }

    a a() {
        return new a();
    }
}
