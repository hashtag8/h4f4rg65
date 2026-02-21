package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface bhe {
    public static final bhe a = new bhe() { // from class: bhe.1
        @Override // defpackage.bhe
        public boolean a(int i, List<bgw> list) {
            return true;
        }

        @Override // defpackage.bhe
        public boolean a(int i, List<bgw> list, boolean z) {
            return true;
        }

        @Override // defpackage.bhe
        public boolean a(int i, bqu bquVar, int i2, boolean z) {
            bquVar.g(i2);
            return true;
        }

        @Override // defpackage.bhe
        public void a(int i, bgt bgtVar) {
        }
    };

    void a(int i, bgt bgtVar);

    boolean a(int i, bqu bquVar, int i2, boolean z);

    boolean a(int i, List<bgw> list);

    boolean a(int i, List<bgw> list, boolean z);
}
