package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bjk extends bjd {
    protected String a;
    protected String b;
    protected String c;

    @Override // defpackage.bjd
    public String e() {
        return "ssdp:update";
    }

    public String f() {
        return this.a;
    }

    public void h(String str) {
        this.a = str;
    }

    public String g() {
        return this.b;
    }

    public void i(String str) {
        this.b = str;
    }

    public String h() {
        return this.c;
    }

    public void j(String str) {
        this.c = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d()).append("\r\n");
        stringBuffer.append("HOST: " + b()).append("\r\n");
        stringBuffer.append("NT: " + c()).append("\r\n");
        stringBuffer.append("NTS: " + e()).append("\r\n");
        stringBuffer.append("LOCATION: " + g()).append("\r\n");
        stringBuffer.append("USN: " + a()).append("\r\n");
        stringBuffer.append("CACHE-CONTROL: " + f()).append("\r\n");
        stringBuffer.append("SERVER: " + h()).append("\r\n");
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}
