package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class buj {
    private static final byte[] b = {13, 10};
    private static final byte[] c = {45, 45};
    public static final buj a = new buj();

    protected buj() {
    }

    public void a(buc bucVar, OutputStream outputStream) throws IOException {
        if (bucVar instanceof bui) {
            a((bug) bucVar, outputStream);
        } else if (bucVar instanceof buk) {
            a((buk) bucVar, outputStream);
        } else {
            if (bucVar instanceof bul) {
                ((bul) bucVar).writeTo(outputStream);
                return;
            }
            throw new IllegalArgumentException("Unsupported body class");
        }
    }

    public void a(bug bugVar, OutputStream outputStream) throws IOException {
        buh header = bugVar.getHeader();
        if (header == null) {
            throw new IllegalArgumentException("Missing header");
        }
        a(header, outputStream);
        buc body = bugVar.getBody();
        if (body == null) {
            throw new IllegalArgumentException("Missing body");
        }
        OutputStream outputStreamA = a(outputStream, bugVar.getContentTransferEncoding(), body instanceof bub);
        a(body, outputStreamA);
        if (outputStreamA != outputStream) {
            outputStreamA.close();
        }
    }

    public void a(buk bukVar, OutputStream outputStream) throws IOException {
        bup bupVarA = a(a(bukVar));
        a(bukVar.getPreambleRaw(), outputStream);
        outputStream.write(b);
        for (bue bueVar : bukVar.getBodyParts()) {
            outputStream.write(c);
            a(bupVarA, outputStream);
            outputStream.write(b);
            a(bueVar, outputStream);
            outputStream.write(b);
        }
        outputStream.write(c);
        a(bupVarA, outputStream);
        outputStream.write(c);
        outputStream.write(b);
        a(bukVar.getEpilogueRaw(), outputStream);
    }

    public void a(buh buhVar, OutputStream outputStream) throws IOException {
        Iterator<bun> it = buhVar.iterator();
        while (it.hasNext()) {
            a(it.next().getRaw(), outputStream);
            outputStream.write(b);
        }
        outputStream.write(b);
    }

    protected OutputStream a(OutputStream outputStream, String str, boolean z) {
        if (but.a(str)) {
            return bst.a(outputStream);
        }
        if (but.b(str)) {
            return bst.a(outputStream, z);
        }
        return outputStream;
    }

    private btc a(buk bukVar) {
        bug parent = bukVar.getParent();
        if (parent == null) {
            throw new IllegalArgumentException("Missing parent entity in multipart");
        }
        buh header = parent.getHeader();
        if (header == null) {
            throw new IllegalArgumentException("Missing header in parent entity");
        }
        btc btcVar = (btc) header.a("Content-Type");
        if (btcVar == null) {
            throw new IllegalArgumentException("Content-Type field not specified");
        }
        return btcVar;
    }

    private bup a(btc btcVar) {
        String strC = btcVar.c();
        if (strC == null) {
            throw new IllegalArgumentException("Multipart boundary not specified");
        }
        return bur.a(strC);
    }

    private void a(bup bupVar, OutputStream outputStream) throws IOException {
        if (bupVar instanceof buo) {
            buo buoVar = (buo) bupVar;
            outputStream.write(buoVar.c(), 0, buoVar.b());
        } else {
            outputStream.write(bupVar.a());
        }
    }
}
