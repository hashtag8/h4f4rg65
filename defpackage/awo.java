package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class awo extends Dialog {
    View.OnClickListener a;
    AdapterView.OnItemClickListener b;
    private Context c;
    private TextView d;
    private TextView e;
    private ListView f;
    private List<String> g;
    private asi h;
    private String i;

    public awo(Context context, String str) {
        this(context, R.style.CustomDialog);
        this.i = str;
    }

    public awo(Context context, int i) {
        super(context, i);
        this.a = new View.OnClickListener() { // from class: awo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.dialog_play_song_close /* 2131690092 */:
                        awo.this.c();
                        break;
                }
            }
        };
        this.b = new AdapterView.OnItemClickListener() { // from class: awo.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (awo.this.h != null) {
                    awo.this.h.a(i2);
                }
                awo.this.c();
            }
        };
        this.c = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_play_song);
        a();
        b();
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        if (ahn.a()) {
            attributes.width = aff.s;
        } else {
            attributes.width = ahn.a(this.c).a - ((ahn.a(this.c).a / 10) * 2);
        }
        window.setAttributes(attributes);
        this.d = (TextView) findViewById(R.id.dialog_play_song_title);
        this.d.setText(this.i);
        this.e = (TextView) findViewById(R.id.dialog_play_song_close);
        this.f = (ListView) findViewById(R.id.dialog_play_song_listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.c, R.layout.dialog_play_song_item);
        arrayAdapter.addAll(this.g);
        mm.b("DIALOG", "" + arrayAdapter.getCount());
        mm.b("DATA", "" + this.g.size());
        this.f.setAdapter((ListAdapter) arrayAdapter);
        this.d.setTypeface(ahu.a(this.c));
    }

    private void b() {
        this.e.setOnClickListener(this.a);
        this.f.setOnItemClickListener(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        dismiss();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(List<String> list) {
        this.g = list;
    }

    public void a(asi asiVar) {
        this.h = asiVar;
    }
}
