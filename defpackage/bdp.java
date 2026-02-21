package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.asb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class bdp extends Dialog {
    View.OnClickListener a;
    private Context b;
    private TextView c;
    private TextView d;
    private ListView e;
    private List<String> f;
    private asi g;
    private String h;

    public bdp(Context context, String str) {
        this(context, R.style.BottomPlayerDialogTheme);
        this.h = str;
    }

    public bdp(Context context, int i) {
        super(context, R.style.BottomPlayerDialogTheme);
        this.a = new View.OnClickListener() { // from class: bdp.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.dialog_play_song_close /* 2131690092 */:
                        bdp.this.c();
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
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        if (ahn.a()) {
            attributes.width = aff.s;
        } else {
            attributes.width = -1;
        }
        window.setAttributes(attributes);
        this.c = (TextView) findViewById(R.id.dialog_play_song_title);
        this.c.setText(this.h);
        this.d = (TextView) findViewById(R.id.dialog_play_song_close);
        this.d.setOnClickListener(this.a);
        this.e = (ListView) findViewById(R.id.dialog_play_song_listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.b, R.layout.dialog_play_song_item);
        arrayAdapter.addAll(this.f);
        mm.b("DIALOG", "" + arrayAdapter.getCount());
        mm.b("DATA", "" + this.f.size());
        this.e.setAdapter((ListAdapter) arrayAdapter);
        this.c.setTypeface(ahu.a(this.b));
    }

    private void b() {
        this.e.setOnItemClickListener(new asb(this.b, new asb.a() { // from class: bdp.1
            @Override // asb.a
            public void a(int i) {
                if (bdp.this.g != null) {
                    bdp.this.g.a(i);
                }
                bdp.this.c();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        dismiss();
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(((String) listIterator.next()).toUpperCase());
        }
        this.f = arrayList;
    }

    public void a(asi asiVar) {
        this.g = asiVar;
    }
}
