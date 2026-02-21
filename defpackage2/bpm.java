package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bpm {
    public String a(bpk bpkVar) {
        String string = bpkVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring("kotlin.jvm.functions.".length()) : string;
    }
}
