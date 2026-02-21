package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
class oq {
    private final b a;
    private final AlertDialog.Builder b;

    interface a {
        void a(boolean z);
    }

    static class b {
        private boolean a;
        private final CountDownLatch b;

        private b() {
            this.a = false;
            this.b = new CountDownLatch(1);
        }

        void a(boolean z) {
            this.a = z;
            this.b.countDown();
        }

        boolean a() {
            return this.a;
        }

        void b() {
            try {
                this.b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public static oq a(Activity activity, bot botVar, final a aVar) {
        final b bVar = new b();
        pf pfVar = new pf(activity, botVar);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView scrollViewA = a(activity, pfVar.b());
        builder.setView(scrollViewA).setTitle(pfVar.a()).setCancelable(false).setNeutralButton(pfVar.c(), new DialogInterface.OnClickListener() { // from class: oq.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                bVar.a(true);
                dialogInterface.dismiss();
            }
        });
        if (botVar.d) {
            builder.setNegativeButton(pfVar.e(), new DialogInterface.OnClickListener() { // from class: oq.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    bVar.a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (botVar.f) {
            builder.setPositiveButton(pfVar.d(), new DialogInterface.OnClickListener() { // from class: oq.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    aVar.a(true);
                    bVar.a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new oq(builder, bVar);
    }

    private static ScrollView a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int iA = a(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, R.style.TextAppearance.Medium);
        textView.setPadding(iA, iA, iA, iA);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(a(f, 14), a(f, 2), a(f, 10), a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private static int a(float f, int i) {
        return (int) (i * f);
    }

    private oq(AlertDialog.Builder builder, b bVar) {
        this.a = bVar;
        this.b = builder;
    }

    public void a() {
        this.b.show();
    }

    public void b() {
        this.a.b();
    }

    public boolean c() {
        return this.a.a();
    }
}
