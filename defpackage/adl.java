package defpackage;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class adl extends ack<Date> {
    public static final acl a = new acl() { // from class: adl.1
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            if (adpVar.a() == Date.class) {
                return new adl();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    @Override // defpackage.ack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(adq adqVar) {
        Date date;
        if (adqVar.f() == ads.NULL) {
            adqVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(adqVar.h()).getTime());
            } catch (ParseException e) {
                throw new aci(e);
            }
        }
        return date;
    }

    @Override // defpackage.ack
    public synchronized void a(adt adtVar, Date date) {
        adtVar.b(date == null ? null : this.b.format((java.util.Date) date));
    }
}
