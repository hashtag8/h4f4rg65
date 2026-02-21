package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class ays {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    ImageView e;
    Context f;

    public void a(Context context) {
        this.f = context;
    }

    public void a(View view) {
        this.a = (TextView) view.findViewById(R.id.rdio_playlist_user);
        this.a.setTypeface(ahu.a(this.f));
        this.b = (TextView) view.findViewById(R.id.rdio_playlist_title);
        this.b.setTypeface(ahu.a(this.f));
        this.c = (TextView) view.findViewById(R.id.rdio_playlist_track_count);
        this.c.setTypeface(ahu.a(this.f));
        this.d = (ImageView) view.findViewById(R.id.iv);
        this.e = (ImageView) view.findViewById(R.id.rdio_add_all_button);
    }

    public void a(String str, String str2, String str3, String str4) {
        try {
            this.b.setText(str);
            this.a.setText(str2);
            this.c.setText(str3);
            new ahw().a(this.d, str4);
        } catch (Exception e) {
        }
    }
}
