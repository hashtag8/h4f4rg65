package com.harman.hkconnect.setup.newpage.info;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.adx;
import defpackage.adz;
import defpackage.ain;
import defpackage.aoy;
import defpackage.ape;
import defpackage.apq;
import defpackage.apr;
import defpackage.apt;
import defpackage.apv;
import defpackage.mm;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomItem implements Parcelable {
    public static final Parcelable.Creator<RoomItem> CREATOR = new Parcelable.Creator<RoomItem>() { // from class: com.harman.hkconnect.setup.newpage.info.RoomItem.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoomItem createFromParcel(Parcel parcel) {
            return new RoomItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoomItem[] newArray(int i) {
            return new RoomItem[i];
        }
    };
    private int a;
    private boolean b;
    private int c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private adx j;
    private adx k;
    private aoy l;
    private adx r;
    private adx s;
    private adx t;
    private adx u;
    private adx v;
    private adx w;
    private byte i = 0;
    private List<adx> m = new ArrayList();
    private boolean n = true;
    private boolean o = false;
    private long p = 0;
    private boolean q = true;

    public boolean a() {
        return this.o;
    }

    public boolean b() {
        return this.q;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public boolean c() {
        return this.n;
    }

    public void a(long j) {
        this.p = j;
    }

    public long d() {
        return this.p;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void a(byte b) {
        this.i = b;
        switch (b) {
            case 0:
                this.l = new apt();
                break;
            case 1:
                this.l = new apv();
                break;
            case 2:
            case 5:
                this.l = new ape();
                break;
            case 3:
                this.l = new apq();
                break;
            case 4:
                this.l = new apr();
                break;
            default:
                this.l = new apt();
                break;
        }
    }

    public byte e() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte((byte) (this.b ? 1 : 0));
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
    }

    public void a(adz adzVar) {
        this.a = adzVar.s();
        this.c = adzVar.m();
        this.d = adzVar.l();
        this.e = this.d;
        this.f = adzVar.A() % ain.y.length;
        this.g = adzVar.o();
        this.h = adzVar.p();
        this.p = adzVar.h().P();
        a(adzVar.d());
    }

    public RoomItem(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
    }

    public RoomItem() {
    }

    public void a(int i) {
        this.a = i;
    }

    public int f() {
        return this.a;
    }

    public boolean g() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public void b(int i) {
        this.c = i;
    }

    public String h() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String i() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public int j() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public int k() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public int l() {
        return this.h;
    }

    public void e(int i) {
        this.h = i;
    }

    public adx m() {
        return this.j;
    }

    public void a(adx adxVar) {
        this.j = adxVar;
    }

    public adx n() {
        return this.k;
    }

    public void b(adx adxVar) {
        this.k = adxVar;
    }

    public adx o() {
        return this.r;
    }

    public void c(adx adxVar) {
        this.r = adxVar;
    }

    public adx p() {
        return this.s;
    }

    public void d(adx adxVar) {
        this.s = adxVar;
    }

    public adx q() {
        return this.t;
    }

    public void e(adx adxVar) {
        this.t = adxVar;
    }

    public adx r() {
        return this.u;
    }

    public adx s() {
        return this.v;
    }

    public void f(adx adxVar) {
        this.v = adxVar;
    }

    public adx t() {
        return this.w;
    }

    public void g(adx adxVar) {
        this.w = adxVar;
    }

    public aoy u() {
        return this.l;
    }

    public List<adx> v() {
        return this.m;
    }

    public void a(List<adx> list) {
        this.m.clear();
        this.m.addAll(list);
    }

    public void w() {
        if (this.l != null) {
            mm.b("have send command------", new Object[0]);
            this.l.a(this);
        }
    }

    public int x() {
        if (this.m == null || this.m.isEmpty()) {
            return 0;
        }
        return this.m.size();
    }

    public void y() {
        if (this.l != null) {
            mm.b("Sending Edit Room command------", new Object[0]);
            this.l.b(this);
        }
    }
}
