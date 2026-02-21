package defpackage;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class bul implements buc {
    private bug parent = null;

    public abstract void writeTo(OutputStream outputStream);

    protected bul() {
    }

    public bug getParent() {
        return this.parent;
    }

    @Override // defpackage.buc
    public void setParent(bug bugVar) {
        this.parent = bugVar;
    }

    public bul copy() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.buf
    public void dispose() {
    }
}
