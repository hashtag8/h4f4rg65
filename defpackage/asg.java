package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class asg extends ase {
    private final Activity a;

    public asg(Activity activity) {
        super(activity);
        this.a = activity;
        a();
    }

    private void a() {
        View viewInflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.trouble_shoot_dialog, (ViewGroup) null);
        viewInflate.setBackgroundResource(R.drawable.default_white_dialog_bg);
        requestWindowFeature(1);
        addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        ((TextView) viewInflate.findViewById(R.id.trouble_shoot_ok_text_view)).setOnClickListener(new View.OnClickListener() { // from class: asg.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new asd(asg.this).a();
            }
        });
    }
}
