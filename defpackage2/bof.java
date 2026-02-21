package defpackage;

import android.content.res.Resources;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class bof extends blw {
    public bof(bln blnVar, String str, String str2, bnw bnwVar, bnu bnuVar) {
        super(blnVar, str, str2, bnwVar, bnuVar);
    }

    public boolean a(boi boiVar) {
        bnv bnvVarB = b(a(b(), boiVar), boiVar);
        blh.h().a("Fabric", "Sending app info to " + a());
        if (boiVar.j != null) {
            blh.h().a("Fabric", "App icon hash is " + boiVar.j.a);
            blh.h().a("Fabric", "App icon size is " + boiVar.j.c + "x" + boiVar.j.d);
        }
        int iB = bnvVarB.b();
        blh.h().a("Fabric", ("POST".equals(bnvVarB.p()) ? "Create" : "Update") + " app request ID: " + bnvVarB.b("X-REQUEST-ID"));
        blh.h().a("Fabric", "Result was " + iB);
        return bmo.a(iB) == 0;
    }

    private bnv a(bnv bnvVar, boi boiVar) {
        return bnvVar.a("X-CRASHLYTICS-API-KEY", boiVar.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    private bnv b(bnv bnvVar, boi boiVar) {
        bnv bnvVarE = bnvVar.e("app[identifier]", boiVar.b).e("app[name]", boiVar.f).e("app[display_version]", boiVar.c).e("app[build_version]", boiVar.d).a("app[source]", Integer.valueOf(boiVar.g)).e("app[minimum_sdk_version]", boiVar.h).e("app[built_sdk_version]", boiVar.i);
        if (!bme.d(boiVar.e)) {
            bnvVarE.e("app[instance_identifier]", boiVar.e);
        }
        if (boiVar.j != null) {
            InputStream inputStreamOpenRawResource = null;
            try {
                inputStreamOpenRawResource = this.a.r().getResources().openRawResource(boiVar.j.b);
                bnvVarE.e("app[icon][hash]", boiVar.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputStreamOpenRawResource).a("app[icon][width]", Integer.valueOf(boiVar.j.c)).a("app[icon][height]", Integer.valueOf(boiVar.j.d));
            } catch (Resources.NotFoundException e) {
                blh.h().e("Fabric", "Failed to find app icon with resource ID: " + boiVar.j.b, e);
            } finally {
                bme.a((Closeable) inputStreamOpenRawResource, "Failed to close app icon InputStream.");
            }
        }
        if (boiVar.k != null) {
            for (blp blpVar : boiVar.k) {
                bnvVarE.e(a(blpVar), blpVar.b());
                bnvVarE.e(b(blpVar), blpVar.c());
            }
        }
        return bnvVarE;
    }

    String a(blp blpVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", blpVar.a());
    }

    String b(blp blpVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", blpVar.a());
    }
}
