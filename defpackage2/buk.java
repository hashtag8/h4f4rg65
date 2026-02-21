package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class buk implements buc {
    private List<bue> bodyParts;
    private bup epilogue;
    private transient String epilogueStrCache;
    private bug parent;
    private bup preamble;
    private transient String preambleStrCache;
    private String subType;

    public buk(String str) {
        this.bodyParts = new LinkedList();
        this.parent = null;
        this.preamble = bup.a;
        this.preambleStrCache = "";
        this.epilogue = bup.a;
        this.epilogueStrCache = "";
        this.subType = str;
    }

    public buk(buk bukVar) {
        this.bodyParts = new LinkedList();
        this.parent = null;
        this.preamble = bukVar.preamble;
        this.preambleStrCache = bukVar.preambleStrCache;
        this.epilogue = bukVar.epilogue;
        this.epilogueStrCache = bukVar.epilogueStrCache;
        Iterator<bue> it = bukVar.bodyParts.iterator();
        while (it.hasNext()) {
            addBodyPart(new bue(it.next()));
        }
        this.subType = bukVar.subType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public bug getParent() {
        return this.parent;
    }

    @Override // defpackage.buc
    public void setParent(bug bugVar) {
        this.parent = bugVar;
        Iterator<bue> it = this.bodyParts.iterator();
        while (it.hasNext()) {
            it.next().setParent(bugVar);
        }
    }

    public int getCount() {
        return this.bodyParts.size();
    }

    public List<bue> getBodyParts() {
        return Collections.unmodifiableList(this.bodyParts);
    }

    public void setBodyParts(List<bue> list) {
        this.bodyParts = list;
        Iterator<bue> it = list.iterator();
        while (it.hasNext()) {
            it.next().setParent(this.parent);
        }
    }

    public void addBodyPart(bue bueVar) {
        if (bueVar == null) {
            throw new IllegalArgumentException();
        }
        this.bodyParts.add(bueVar);
        bueVar.setParent(this.parent);
    }

    public void addBodyPart(bue bueVar, int i) {
        if (bueVar == null) {
            throw new IllegalArgumentException();
        }
        this.bodyParts.add(i, bueVar);
        bueVar.setParent(this.parent);
    }

    public bue removeBodyPart(int i) {
        bue bueVarRemove = this.bodyParts.remove(i);
        bueVarRemove.setParent(null);
        return bueVarRemove;
    }

    public bue replaceBodyPart(bue bueVar, int i) {
        if (bueVar == null) {
            throw new IllegalArgumentException();
        }
        bue bueVar2 = this.bodyParts.set(i, bueVar);
        if (bueVar == bueVar2) {
            throw new IllegalArgumentException("Cannot replace body part with itself");
        }
        bueVar.setParent(this.parent);
        bueVar2.setParent(null);
        return bueVar2;
    }

    bup getPreambleRaw() {
        return this.preamble;
    }

    void setPreambleRaw(bup bupVar) {
        this.preamble = bupVar;
        this.preambleStrCache = null;
    }

    public String getPreamble() {
        if (this.preambleStrCache == null) {
            this.preambleStrCache = bur.a(this.preamble);
        }
        return this.preambleStrCache;
    }

    public void setPreamble(String str) {
        this.preamble = bur.a(str);
        this.preambleStrCache = str;
    }

    bup getEpilogueRaw() {
        return this.epilogue;
    }

    void setEpilogueRaw(bup bupVar) {
        this.epilogue = bupVar;
        this.epilogueStrCache = null;
    }

    public String getEpilogue() {
        if (this.epilogueStrCache == null) {
            this.epilogueStrCache = bur.a(this.epilogue);
        }
        return this.epilogueStrCache;
    }

    public void setEpilogue(String str) {
        this.epilogue = bur.a(str);
        this.epilogueStrCache = str;
    }

    @Override // defpackage.buf
    public void dispose() {
        Iterator<bue> it = this.bodyParts.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
    }
}
