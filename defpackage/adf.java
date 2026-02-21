package defpackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class adf extends ack<Date> {
    public static final acl a = new acl() { // from class: adf.1
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            if (adpVar.a() == Date.class) {
                return new adf();
            }
            return null;
        }
    };
    private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d = a();

    private static DateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Override // defpackage.ack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date b(adq adqVar) {
        if (adqVar.f() != ads.NULL) {
            return a(adqVar.h());
        }
        adqVar.j();
        return null;
    }

    private synchronized Date a(String str) {
        Date date;
        try {
            date = this.c.parse(str);
        } catch (ParseException e) {
            try {
                date = this.b.parse(str);
            } catch (ParseException e2) {
                try {
                    date = this.d.parse(str);
                } catch (ParseException e3) {
                    throw new aci(str, e3);
                }
            }
        }
        return date;
    }

    @Override // defpackage.ack
    public synchronized void a(adt adtVar, Date date) {
        if (date == null) {
            adtVar.f();
        } else {
            adtVar.b(this.b.format(date));
        }
    }
}
