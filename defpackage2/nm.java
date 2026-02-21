package defpackage;

import defpackage.nm;

/* JADX INFO: loaded from: classes.dex */
public abstract class nm<T extends nm> extends mw<T> {
    final mv c;

    abstract String a();

    public String toString() {
        return "{type:\"" + a() + "\", predefinedAttributes:" + this.c + ", customAttributes:" + this.b + "}";
    }
}
