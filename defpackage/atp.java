package defpackage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceAutoCompleteTextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class atp extends atm {
    private List<String> a;
    private TypefaceAutoCompleteTextView b;
    private RecyclerView c;
    private a d;
    private ImageView e;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_fota_updated_timezone_pickup, (ViewGroup) null);
        this.b = (TypefaceAutoCompleteTextView) viewInflate.findViewById(R.id.timezone_searchbar);
        this.c = (RecyclerView) viewInflate.findViewById(R.id.display_search_result_rv);
        this.e = (ImageView) viewInflate.findViewById(R.id.search_clear_button);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: atp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                atp.this.b.setText("");
                atp.this.al();
            }
        });
        this.c.setLayoutManager(new LinearLayoutManager(p()));
        this.a = aht.a();
        this.d = new a();
        this.d.a(this.a);
        this.c.setAdapter(this.d);
        this.b.addTextChangedListener(new TextWatcher() { // from class: atp.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(final Editable editable) {
                mq.b().b(new Runnable() { // from class: atp.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TextUtils.isEmpty(editable.toString())) {
                            atp.this.al();
                        } else {
                            atp.this.a((List<String>) atp.this.b(editable.toString()));
                        }
                    }
                });
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<String> list) {
        mo.a.a(new Runnable() { // from class: atp.3
            @Override // java.lang.Runnable
            public void run() {
                atp.this.d.a(list);
                atp.this.d.c();
            }
        });
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        e().c(true);
        e().b(a(R.string.kSettings_Time_Zone));
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.a) {
            if (str2.toLowerCase().contains(str.toLowerCase().trim())) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        mo.a.a(new Runnable() { // from class: atp.4
            @Override // java.lang.Runnable
            public void run() {
                atp.this.d.a(atp.this.a);
                atp.this.d.c();
            }
        });
    }

    public class a extends RecyclerView.a<C0057a> {
        private List<String> b;

        public a() {
        }

        public void a(List<String> list) {
            this.b = list;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0057a a(ViewGroup viewGroup, int i) {
            return new C0057a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bean_list, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(C0057a c0057a, final int i) {
            c0057a.o.setText(this.b.get(i));
            c0057a.p.setOnClickListener(new View.OnClickListener() { // from class: atp.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    mm.b("TEST_TIMEZONE name = %s", a.this.b.get(i));
                    atp.this.e().l().a((String) a.this.b.get(i));
                    atp.this.p().onBackPressed();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return this.b.size();
        }

        /* JADX INFO: renamed from: atp$a$a, reason: collision with other inner class name */
        public class C0057a extends RecyclerView.v {
            private TextView o;
            private View p;

            public C0057a(View view) {
                super(view);
                this.o = (TextView) view.findViewById(R.id.tv_item_search_content);
                this.p = view;
            }
        }
    }
}
