package defpackage;

import android.content.Context;
import defpackage.bml;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class nx {
    private final Context a;
    private final bml b;
    private final String c;
    private final String d;

    public nx(Context context, bml bmlVar, String str, String str2) {
        this.a = context;
        this.b = bmlVar;
        this.c = str;
        this.d = str2;
    }

    public nv a() {
        Map<bml.a, String> mapH = this.b.h();
        return new nv(this.b.c(), UUID.randomUUID().toString(), this.b.b(), mapH.get(bml.a.ANDROID_ID), mapH.get(bml.a.ANDROID_ADVERTISING_ID), this.b.j(), mapH.get(bml.a.FONT_TOKEN), bme.m(this.a), this.b.d(), this.b.g(), this.c, this.d);
    }
}
