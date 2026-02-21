package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bud {
    public static buc a(buc bucVar) {
        if (bucVar == null) {
            throw new IllegalArgumentException("Body is null");
        }
        if (bucVar instanceof bui) {
            return new bui((bui) bucVar);
        }
        if (bucVar instanceof buk) {
            return new buk((buk) bucVar);
        }
        if (bucVar instanceof bul) {
            return ((bul) bucVar).copy();
        }
        throw new IllegalArgumentException("Unsupported body class");
    }
}
