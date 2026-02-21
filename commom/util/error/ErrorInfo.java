package com.harman.commom.util.error;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.ahp;
import defpackage.bru;
import defpackage.bsc;
import defpackage.bse;
import java.io.Serializable;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class ErrorInfo implements Parcelable {
    public static final Parcelable.Creator<ErrorInfo> CREATOR = new Parcelable.Creator<ErrorInfo>() { // from class: com.harman.commom.util.error.ErrorInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ErrorInfo createFromParcel(Parcel parcel) {
            return new ErrorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ErrorInfo[] newArray(int i) {
            return new ErrorInfo[i];
        }
    };
    private int a;
    private String b;
    private String c;
    private Bundle d;
    private Throwable e;

    protected ErrorInfo() {
        this.a = 0;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Bundle d() {
        return this.d;
    }

    public String toString() {
        bsc bscVar = new bsc(this, new ahp());
        if (this.a != 0) {
            bscVar.a("errorCode", this.a);
        }
        bscVar.a("debugMessage", this.b).a("userMessage", this.c);
        if (this.d != null) {
            for (String str : new TreeSet(this.d.keySet())) {
                bscVar.a("contextData:" + str, bru.b(String.valueOf(this.d.get(str)), 1000));
            }
        }
        if (this.e != null) {
            bscVar.a("exception", bse.a(this.e));
        }
        return bscVar.h();
    }

    public ErrorInfo e() {
        return a((Integer) null);
    }

    public boolean a(int i) {
        return a(Integer.valueOf(i)) != null;
    }

    private ErrorInfo a(Integer num) {
        Object obj = d() == null ? null : d().get("caused_by");
        int i = 0;
        while (obj instanceof ErrorInfo) {
            int i2 = i + 1;
            if (i >= 10) {
                break;
            }
            ErrorInfo errorInfo = (ErrorInfo) obj;
            if (num == null || errorInfo.a() != num.intValue()) {
                if (errorInfo.d() == null) {
                    i = i2;
                    this = errorInfo;
                    obj = null;
                } else {
                    this = errorInfo;
                    obj = errorInfo.d().get("caused_by");
                    i = i2;
                }
            } else {
                return errorInfo;
            }
        }
        if (num == null || this.a() == num.intValue()) {
            return this;
        }
        return null;
    }

    private ErrorInfo(Parcel parcel) {
        this.a = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readBundle();
        this.e = (Throwable) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeBundle(this.d);
        parcel.writeSerializable(this.e);
    }

    public static class a {
        private ErrorInfo a = new ErrorInfo();

        public a a(int i) {
            this.a.a = i;
            return this;
        }

        public a a(String str) {
            this.a.b = str;
            return this;
        }

        public a b(String str) {
            this.a.c = str;
            return this;
        }

        public a a(int i, Object... objArr) {
            this.a.c = HarmanApplication.a().getString(i, objArr);
            return this;
        }

        public a a(Bundle bundle) {
            this.a.d = bundle;
            return this;
        }

        public a a(Serializable serializable) {
            if (this.a.d == null) {
                this.a.d = new Bundle();
            }
            this.a.d.putSerializable("data", serializable);
            return this;
        }

        public a a(Throwable th) {
            this.a.e = th;
            return this;
        }

        public ErrorInfo a() {
            if (this.a.e == null) {
                this.a.e = new Exception("ErrorInfo built here");
            }
            return this.a;
        }
    }
}
