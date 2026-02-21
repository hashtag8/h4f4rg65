package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.aob;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aoc extends arg implements View.OnClickListener, View.OnKeyListener {
    final Runnable a;
    private View b;
    private TextView c;
    private LinearLayout d;
    private Handler e;

    public aoc(Context context, int i) {
        super(context, i);
        this.a = new Runnable() { // from class: aoc.2
            @Override // java.lang.Runnable
            public void run() {
                aoc.this.dismiss();
            }
        };
        this.e = new Handler() { // from class: aoc.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    ain.E = false;
                }
            }
        };
    }

    @Override // defpackage.arg
    protected void a() {
        if (c() != null) {
            this.b = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.volume_popup_layout, (ViewGroup) null);
            this.c = (TextView) this.b.findViewById(R.id.volume_popup_layout_close);
            getWindow().getAttributes().gravity = 80;
            this.d = (LinearLayout) this.b.findViewById(R.id.volume_list_layout);
            this.b.setFocusableInTouchMode(true);
            this.c.setOnClickListener(this);
            this.b.setOnKeyListener(this);
        }
    }

    public void a(boolean z) {
        b();
        b(z);
    }

    public void b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (ahn.a()) {
            layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.volume_width_margin_pad);
            layoutParams.rightMargin = (int) getContext().getResources().getDimension(R.dimen.volume_width_margin_pad);
        } else {
            layoutParams.width = ahn.a(getContext()).a;
        }
        setContentView(this.b, layoutParams);
    }

    private void b(final boolean z) {
        List<adz> listC = c();
        ady adyVarA = aob.h().a();
        if (adyVarA != null) {
            listC = adyVarA.f();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.d.removeAllViews();
        if (listC != null) {
            if (listC.size() > 1) {
                aru aruVar = new aru(getContext());
                aruVar.setBackingGroup(aof.a().b());
                this.d.addView(aruVar, layoutParams);
            }
            Iterator<adz> it = listC.iterator();
            while (it.hasNext()) {
                this.d.addView(new arv(getContext(), it.next(), false), layoutParams);
            }
            aob.h().a(new aob.b() { // from class: aoc.1
                @Override // aob.b
                public void a(boolean z2) {
                    if (z) {
                        aoc.this.c(z2);
                    }
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aob.h().b();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        mm.b("onKeyonKeyDown event.getAction() = " + keyEvent.getAction() + " ，keyCode = " + i, new Object[0]);
        if ((Build.VERSION.SDK_INT < 28 && keyEvent.getAction() == 0) || (Build.VERSION.SDK_INT >= 28 && (keyEvent.getAction() == 0 || keyEvent.getAction() == 1))) {
            ain.E = true;
            this.e.removeMessages(1);
            if (i == 24) {
                aob.h().d();
                return true;
            }
            if (i == 25) {
                aob.h().e();
                return true;
            }
        } else {
            this.e.sendEmptyMessageDelayed(1, 500L);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        mo.a.removeCallbacks(this.a);
        if (z) {
            mo.a.postDelayed(this.a, 3000L);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        mo.a.removeCallbacks(this.a);
        super.dismiss();
        Iterator<adz> it = c().iterator();
        while (it.hasNext()) {
            aob.h().a(it.next().s());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.volume_popup_layout_close /* 2131691210 */:
                dismiss();
                break;
        }
    }
}
