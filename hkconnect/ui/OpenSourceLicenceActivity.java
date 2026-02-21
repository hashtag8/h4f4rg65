package com.harman.hkconnect.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.ahn;
import defpackage.aju;
import defpackage.ajv;
import defpackage.amf;
import defpackage.aqc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OpenSourceLicenceActivity extends aqc implements View.OnClickListener {
    private aju m;
    private ListView n;
    private List<b> o;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqc, defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_open_source_licence);
        n();
        m();
        this.n.setAdapter((ListAdapter) new a(this, this.o));
        if (ahn.a()) {
            this.n.setPadding(ahn.a(this, 50.0f), 0, 0, 0);
        }
        l();
    }

    private void l() {
        this.m = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.license_parent), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.m.a(true);
        this.m.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).g(R.string.kSettings_License_Str).j(R.color.black).c());
    }

    private void m() {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(new b("Android Asynchronous Http Client", "Copyright(C) 2013 James Smith", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Apache-mime4j", "Copyright(C) 2004 Zoldar", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Commons-codec", "Copyright(C) 2009 JavaGems", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Gson", "Copyright(C) 2008 Google", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Httpcore", "Copyright(C) 2004 Ok2c", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Httpmime", "Copyright(C) 2004 Gary Rudolph", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("Picasso", "Copyright(C) 2013 Square, Inc.", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("FFmpeg", "Copyright(C) ffmpeg.org", "GNU Lesser General Public License (LGPL) version 2.1", "https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html", ""));
        this.o.add(new b("AndroidSlidingUpPanel", "Copyright(C) 2014 Umano Team", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
        this.o.add(new b("DragSortListView", "Copyright(C) 2012 Carl Bauer", "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ""));
    }

    private void n() {
        this.n = (ListView) findViewById(R.id.licence_listview);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    static class b {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        public b() {
        }
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    static class a extends amf<b> {
        public a(Context context, List<b> list) {
            super(context, list);
        }

        @Override // defpackage.amf, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = this.d.inflate(R.layout.licence_item, (ViewGroup) null);
                cVar = new c();
                cVar.a = (TypefaceTextView) view.findViewById(R.id.name);
                cVar.b = (TypefaceTextView) view.findViewById(R.id.copyRight);
                cVar.c = (TypefaceTextView) view.findViewById(R.id.licenceVersion);
                cVar.d = (TypefaceTextView) view.findViewById(R.id.licenceUrl);
                cVar.e = (TypefaceTextView) view.findViewById(R.id.licenceDescription);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.a.setText(getItem(i).a());
            cVar.b.setText(getItem(i).b());
            cVar.c.setText(getItem(i).c());
            cVar.d.setText(getItem(i).d());
            cVar.e.setText(getItem(i).e());
            if (TextUtils.isEmpty(getItem(i).b())) {
                cVar.b.setVisibility(8);
            } else {
                cVar.b.setVisibility(0);
            }
            if (TextUtils.isEmpty(getItem(i).c())) {
                cVar.c.setVisibility(8);
            } else {
                cVar.c.setVisibility(0);
            }
            if (TextUtils.isEmpty(getItem(i).e())) {
                cVar.e.setVisibility(8);
            } else {
                cVar.e.setVisibility(0);
            }
            return view;
        }
    }

    static class c {
        public TypefaceTextView a;
        public TypefaceTextView b;
        public TypefaceTextView c;
        public TypefaceTextView d;
        public TypefaceTextView e;

        c() {
        }
    }
}
