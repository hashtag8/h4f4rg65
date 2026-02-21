package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class qo {
    public boolean a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("deezer-session", 0).edit();
        editorEdit.clear();
        return editorEdit.commit();
    }

    public boolean a(qi qiVar, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("deezer-session", 0).edit();
        editorEdit.putString("access_token", qiVar.b());
        editorEdit.putLong("expires_in", qiVar.c());
        return editorEdit.commit();
    }

    public boolean b(qi qiVar, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("deezer-session", 0);
        qiVar.a(context, sharedPreferences.getString("access_token", null));
        qiVar.a(sharedPreferences.getLong("expires_in", 0L));
        return qiVar.a();
    }
}
