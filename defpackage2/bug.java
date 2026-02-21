package defpackage;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
public abstract class bug implements buf {
    private buc body;
    private buh header;
    private bug parent;

    protected bug() {
        this.header = null;
        this.body = null;
        this.parent = null;
    }

    protected bug(bug bugVar) {
        this.header = null;
        this.body = null;
        this.parent = null;
        if (bugVar.header != null) {
            this.header = new buh(bugVar.header);
        }
        if (bugVar.body != null) {
            setBody(bud.a(bugVar.body));
        }
    }

    public bug getParent() {
        return this.parent;
    }

    public void setParent(bug bugVar) {
        this.parent = bugVar;
    }

    public buh getHeader() {
        return this.header;
    }

    public void setHeader(buh buhVar) {
        this.header = buhVar;
    }

    public buc getBody() {
        return this.body;
    }

    public void setBody(buc bucVar) {
        if (this.body != null) {
            throw new IllegalStateException("body already set");
        }
        this.body = bucVar;
        bucVar.setParent(this);
    }

    public buc removeBody() {
        if (this.body == null) {
            return null;
        }
        buc bucVar = this.body;
        this.body = null;
        bucVar.setParent(null);
        return bucVar;
    }

    public void setMessage(bui buiVar) {
        setBody(buiVar, "message/rfc822", null);
    }

    public void setMultipart(buk bukVar) {
        setBody(bukVar, "multipart/" + bukVar.getSubType(), Collections.singletonMap("boundary", but.a()));
    }

    public void setMultipart(buk bukVar, Map<String, String> map) {
        String str = "multipart/" + bukVar.getSubType();
        if (!map.containsKey("boundary")) {
            HashMap map2 = new HashMap(map);
            map2.put("boundary", but.a());
            map = map2;
        }
        setBody(bukVar, str, map);
    }

    public void setText(bum bumVar) {
        setText(bumVar, "plain");
    }

    public void setText(bum bumVar, String str) {
        String str2 = "text/" + str;
        Map<String, String> mapSingletonMap = null;
        String strA = bumVar.a();
        if (strA != null && !strA.equalsIgnoreCase("us-ascii")) {
            mapSingletonMap = Collections.singletonMap("charset", strA);
        }
        setBody(bumVar, str2, mapSingletonMap);
    }

    public void setBody(buc bucVar, String str) {
        setBody(bucVar, str, null);
    }

    public void setBody(buc bucVar, String str, Map<String, String> map) {
        setBody(bucVar);
        obtainHeader().b(bth.a(str, map));
    }

    public String getMimeType() {
        return btc.a((btc) getHeader().a("Content-Type"), getParent() != null ? (btc) getParent().getHeader().a("Content-Type") : null);
    }

    public String getCharset() {
        return btc.a((btc) getHeader().a("Content-Type"));
    }

    public String getContentTransferEncoding() {
        return btb.a((btb) getHeader().a(MIME.CONTENT_TRANSFER_ENC));
    }

    public void setContentTransferEncoding(String str) {
        obtainHeader().b(bth.b(str));
    }

    public String getDispositionType() {
        bta btaVar = (bta) obtainField(MIME.CONTENT_DISPOSITION);
        if (btaVar == null) {
            return null;
        }
        return btaVar.a();
    }

    public void setContentDisposition(String str) {
        obtainHeader().b(bth.a(str, null, -1L, null, null, null));
    }

    public void setContentDisposition(String str, String str2) {
        obtainHeader().b(bth.a(str, str2, -1L, null, null, null));
    }

    public void setContentDisposition(String str, String str2, long j) {
        obtainHeader().b(bth.a(str, str2, j, null, null, null));
    }

    public void setContentDisposition(String str, String str2, long j, Date date, Date date2, Date date3) {
        obtainHeader().b(bth.a(str, str2, j, date, date2, date3));
    }

    public String getFilename() {
        bta btaVar = (bta) obtainField(MIME.CONTENT_DISPOSITION);
        if (btaVar == null) {
            return null;
        }
        return btaVar.c();
    }

    public void setFilename(String str) {
        buh buhVarObtainHeader = obtainHeader();
        bta btaVar = (bta) buhVarObtainHeader.a(MIME.CONTENT_DISPOSITION);
        if (btaVar == null) {
            if (str != null) {
                buhVarObtainHeader.b(bth.a("attachment", str, -1L, null, null, null));
            }
        } else {
            String strA = btaVar.a();
            HashMap map = new HashMap(btaVar.b());
            if (str == null) {
                map.remove("filename");
            } else {
                map.put("filename", str);
            }
            buhVarObtainHeader.b(bth.b(strA, map));
        }
    }

    public boolean isMimeType(String str) {
        return getMimeType().equalsIgnoreCase(str);
    }

    public boolean isMultipart() {
        btc btcVar = (btc) getHeader().a("Content-Type");
        return (btcVar == null || btcVar.c() == null || !getMimeType().startsWith("multipart/")) ? false : true;
    }

    @Override // defpackage.buf
    public void dispose() {
        if (this.body != null) {
            this.body.dispose();
        }
    }

    buh obtainHeader() {
        if (this.header == null) {
            this.header = new buh();
        }
        return this.header;
    }

    <F extends bun> F obtainField(String str) {
        buh header = getHeader();
        if (header == null) {
            return null;
        }
        return (F) header.a(str);
    }
}
