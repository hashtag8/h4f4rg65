package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class azl extends Dialog {
    private Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private String e;
    private String f;

    public azl(Context context) {
        this(context, R.style.DialogStyle);
    }

    public azl(Context context, int i) {
        super(context, i);
        this.a = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rdio_station_dialog);
        this.b = (TextView) findViewById(R.id.rdio_dialog_title);
        this.b.setTypeface(ahu.a(this.a));
        this.c = (TextView) findViewById(R.id.rdio_dialog_message);
        this.c.setTypeface(ahu.a(this.a));
        this.d = (TextView) findViewById(R.id.rdio_dialog_button);
        this.c.setText(this.e);
        this.b.setText(this.f);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: azl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                azl.this.dismiss();
            }
        });
    }

    public void a(String str) {
        this.e = str;
    }

    public void b(String str) {
        this.f = str;
    }
}
