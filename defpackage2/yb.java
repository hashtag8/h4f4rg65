package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.text.TextUtils;
import defpackage.qx;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yb extends yh {
    private final Map<String, String> a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public yb(zp zpVar, Map<String, String> map) {
        super(zpVar, "createCalendarEvent");
        this.a = map;
        this.b = zpVar.c();
        c();
    }

    private String a(String str) {
        return TextUtils.isEmpty(this.a.get(str)) ? "" : this.a.get(str);
    }

    private void c() {
        this.c = a("description");
        this.f = a("summary");
        this.d = e("start_ticks");
        this.e = e("end_ticks");
        this.g = a("location");
    }

    private long e(String str) {
        String str2 = this.a.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public void a() {
        if (this.b == null) {
            b("Activity context is not available.");
            return;
        }
        if (!sy.c().c(this.b).f()) {
            b("This feature is not available on the device.");
            return;
        }
        AlertDialog.Builder builderB = sy.c().b(this.b);
        builderB.setTitle(sy.f().a(qx.b.create_calendar_title, "Create calendar event"));
        builderB.setMessage(sy.f().a(qx.b.create_calendar_message, "Allow Ad to create a calendar event?"));
        builderB.setPositiveButton(sy.f().a(qx.b.accept, "Accept"), new DialogInterface.OnClickListener() { // from class: yb.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                yb.this.b.startActivity(yb.this.b());
            }
        });
        builderB.setNegativeButton(sy.f().a(qx.b.decline, "Decline"), new DialogInterface.OnClickListener() { // from class: yb.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                yb.this.b("Operation denied by user.");
            }
        });
        builderB.create().show();
    }

    Intent b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.c);
        data.putExtra("eventLocation", this.g);
        data.putExtra("description", this.f);
        if (this.d > -1) {
            data.putExtra("beginTime", this.d);
        }
        if (this.e > -1) {
            data.putExtra("endTime", this.e);
        }
        data.setFlags(268435456);
        return data;
    }
}
