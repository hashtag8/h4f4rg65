package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class bbh {
    TextView a;
    RelativeLayout b;
    Context c;

    public void a(Context context) {
        this.c = context;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.sc_add_all_textview_line);
        this.a.setTypeface(ahu.a(this.c));
        this.b = (RelativeLayout) view.findViewById(R.id.sc_add_all_click_layout);
    }

    public void a(String str) {
        this.a.setText(((Object) this.c.getResources().getText(R.string.SoundCloudAddAll_Str)) + " (" + str + ")");
    }
}
