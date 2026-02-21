package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bjf extends bjd {
    protected String a;

    @Override // defpackage.bjd
    public String e() {
        return "ssdp:byebye";
    }

    public String f() {
        return this.a;
    }

    public void h(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d()).append("\r\n");
        stringBuffer.append("HOST: " + b()).append("\r\n");
        stringBuffer.append("NT: " + c()).append("\r\n");
        stringBuffer.append("NTS: " + e()).append("\r\n");
        stringBuffer.append("USN: " + a()).append("\r\n");
        stringBuffer.append("CONTENT-LENGTH: " + f()).append("\r\n");
        return stringBuffer.toString();
    }
}
