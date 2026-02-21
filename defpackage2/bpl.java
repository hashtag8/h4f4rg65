package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bpl {
    private static final bpm a;
    private static final bpn[] b;

    static {
        bpm bpmVar;
        try {
            bpmVar = (bpm) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            bpmVar = null;
        } catch (ClassNotFoundException e2) {
            bpmVar = null;
        } catch (IllegalAccessException e3) {
            bpmVar = null;
        } catch (InstantiationException e4) {
            bpmVar = null;
        }
        if (bpmVar == null) {
            bpmVar = new bpm();
        }
        a = bpmVar;
        b = new bpn[0];
    }

    public static String a(bpk bpkVar) {
        return a.a(bpkVar);
    }
}
