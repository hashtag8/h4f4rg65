package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class aei extends aep {
    public static byte[] a = {72, 65};
    public int b;
    private byte e;
    private byte f;
    private byte[] g;
    private byte h;
    private byte[] i;
    private byte[] j;

    public aei(byte[] bArr, byte[] bArr2) {
        this(bArr);
        this.i = bArr2;
    }

    public void a(byte[] bArr) {
        this.i = bArr;
    }

    public byte[] a() {
        return this.i;
    }

    public aei(byte[] bArr) {
        this.h = (byte) 0;
        this.e = bArr[0];
        this.f = bArr[1];
    }

    public aei() {
        this.h = (byte) 0;
    }

    public void a(byte b) {
        if (this.i != null) {
            this.j = new byte[this.i.length + 8];
            this.g = mk.c(this.i.length);
            System.arraycopy(this.i, 0, this.j, 8, this.i.length);
        } else {
            this.g = new byte[]{0, 0};
            this.j = new byte[8];
        }
        this.h = c();
        this.j[0] = a[0];
        this.j[1] = a[1];
        this.j[2] = this.e;
        this.j[3] = this.f;
        this.j[4] = b;
        this.j[5] = this.g[0];
        this.j[6] = this.g[1];
        this.j[7] = this.h;
    }

    private byte c() {
        if (this.i == null || this.i.length == 0) {
            return (byte) 0;
        }
        return agy.a(this.i);
    }

    @Override // defpackage.aep
    public byte[] b() {
        return this.j;
    }

    public void b(byte[] bArr) {
        this.j = bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        if (this.j != null && this.j.length > 0) {
            stringBuffer.append("content=");
            stringBuffer.append(mm.a(this.j)).append(",");
        }
        if (this.i != null && this.i.length > 0) {
            stringBuffer.append("payload=");
            stringBuffer.append(mm.a(this.i)).append(",");
        }
        if (this.g != null && this.g.length > 0) {
            stringBuffer.append("lenghtBytes=");
            stringBuffer.append(mm.a(this.g)).append(",");
        }
        stringBuffer.append("cmd_id=");
        stringBuffer.append(String.format("%02X", Byte.valueOf(this.e))).append(",");
        stringBuffer.append("sub_cmd_id=");
        stringBuffer.append(String.format("%02X", Byte.valueOf(this.f))).append(",");
        stringBuffer.append("checkSum=");
        stringBuffer.append(String.format("%02X", Byte.valueOf(this.h))).append(",");
        stringBuffer.append("length=").append(this.b).append(",");
        stringBuffer.append("id=").append(this.c).append(",");
        stringBuffer.append("type=").append(this.d).append(",");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
