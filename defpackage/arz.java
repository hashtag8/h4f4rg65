package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.asb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class arz extends Dialog {
    View.OnClickListener a;
    private Context b;
    private TextView c;
    private TextView d;
    private ListView e;
    private List<String> f;
    private asi g;

    public arz(Context context) {
        this(context, R.style.BottomPlayerDialogTheme);
    }

    public arz(Context context, int i) {
        super(context, i);
        this.a = new View.OnClickListener() { // from class: arz.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.dialog_play_song_close /* 2131690092 */:
                        arz.this.c();
                        break;
                }
            }
        };
        this.b = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_play_song);
        a();
        b();
    }

    private void a() {
        getWindow().setAttributes(ahn.a(getWindow().getAttributes(), this.b));
        this.c = (TextView) findViewById(R.id.dialog_play_song_title);
        this.d = (TextView) findViewById(R.id.dialog_play_song_close);
        this.d.setText(this.d.getText().toString().toUpperCase());
        this.e = (ListView) findViewById(R.id.dialog_play_song_listview);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toUpperCase());
        }
        this.f = arrayList;
        this.e.setAdapter((ListAdapter) new ArrayAdapter(this.b, R.layout.dialog_play_song_item, this.f));
        this.c.setTypeface(ahu.a(this.b));
    }

    private void b() {
        this.d.setOnClickListener(this.a);
        this.e.setOnItemClickListener(new asb(this.b, new asb.a() { // from class: arz.1
            @Override // asb.a
            public void a(int i) {
                if (arz.this.g != null) {
                    arz.this.g.a(i);
                }
                arz.this.c();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        dismiss();
    }

    public void a(String str) {
        if (this.c != null) {
            this.c.setText(str);
        }
    }

    public void a(List<String> list) {
        this.f = list;
    }

    public void a(asi asiVar) {
        this.g = asiVar;
    }
}
