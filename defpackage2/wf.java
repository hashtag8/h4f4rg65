package defpackage;

import defpackage.aan;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class wf extends aac<String> {
    private final aan.b<String> a;

    public wf(int i, String str, aan.b<String> bVar, aan.a aVar) {
        super(i, str, aVar);
        this.a = bVar;
    }

    public wf(String str, aan.b<String> bVar, aan.a aVar) {
        this(0, str, bVar, aVar);
    }

    @Override // defpackage.aac
    protected aan<String> a(zo zoVar) {
        String str;
        try {
            str = new String(zoVar.b, abp.a(zoVar.c));
        } catch (UnsupportedEncodingException e) {
            str = new String(zoVar.b);
        }
        return aan.a(str, abp.a(zoVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aac
    public void a(String str) {
        this.a.a(str);
    }
}
