package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class bmm {
    private final blv<String> a = new blv<String>() { // from class: bmm.1
        @Override // defpackage.blv
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String b(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };
    private final blt<String> b = new blt<>();

    public String a(Context context) {
        try {
            String strA = this.b.a(context, this.a);
            if ("".equals(strA)) {
                return null;
            }
            return strA;
        } catch (Exception e) {
            blh.h().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
