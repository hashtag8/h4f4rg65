package defpackage;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class adm extends ack<Time> {
    public static final acl a = new acl() { // from class: adm.1
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            if (adpVar.a() == Time.class) {
                return new adm();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    @Override // defpackage.ack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(adq adqVar) {
        Time time;
        if (adqVar.f() == ads.NULL) {
            adqVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(adqVar.h()).getTime());
            } catch (ParseException e) {
                throw new aci(e);
            }
        }
        return time;
    }

    @Override // defpackage.ack
    public synchronized void a(adt adtVar, Time time) {
        adtVar.b(time == null ? null : this.b.format((Date) time));
    }
}
