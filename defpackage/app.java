package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class app extends aoj {
    private View a;
    private TextView b;
    private String c = null;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.show_error_message_layout, (ViewGroup) null);
        this.c = l().getString("MESSAGE");
        am();
        return this.a;
    }

    private void am() {
        b(false);
        c(false);
        a(true);
        an().c("");
        an().b(a(R.string.OK_Str));
        this.b = (TextView) this.a.findViewById(R.id.message_tx);
        if (this.c != null) {
            this.b.setText(this.c);
        }
    }

    @Override // defpackage.aoj
    public void e() {
        an().a(aoi.CHOOSE_CHANNEL_TYPE, (Bundle) null);
    }
}
