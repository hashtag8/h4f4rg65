package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes.dex */
public class arm extends LinearLayout {
    private static int m = 32;
    private Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private a l;
    private TextView n;
    private ArrayList<TextView> o;
    private View.OnClickListener p;
    private qi q;
    private qn r;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();
    }

    public void setmOnDeezerListner(a aVar) {
        this.l = aVar;
    }

    public arm(Context context) {
        super(context);
        this.n = null;
        this.o = new ArrayList<>();
        this.p = new View.OnClickListener() { // from class: arm.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                arm.this.a((TextView) view);
                if (arm.this.l != null) {
                    switch (view.getId()) {
                        case R.id.playlists /* 2131689959 */:
                            arm.this.l.d();
                            break;
                        case R.id.charts /* 2131689960 */:
                            arm.this.l.g();
                            break;
                        case R.id.hear_this /* 2131689969 */:
                            arm.this.l.e();
                            break;
                        case R.id.explore /* 2131689970 */:
                            arm.this.l.f();
                            break;
                        case R.id.radio_channels /* 2131689971 */:
                            arm.this.l.b();
                            break;
                        case R.id.albums /* 2131689973 */:
                            arm.this.l.h();
                            break;
                        case R.id.artists /* 2131689974 */:
                            arm.this.l.c();
                            break;
                        case R.id.mymp3s /* 2131689975 */:
                            arm.this.l.i();
                            break;
                        case R.id.settings /* 2131689976 */:
                            arm.this.l.a();
                            break;
                    }
                }
            }
        };
        this.q = null;
        this.r = new b();
        a(context);
    }

    private void a(Context context) {
        m = ahn.a(context, 20.0f);
        this.a = context;
        LayoutInflater.from(this.a).inflate(R.layout.dashboard_left_right, this);
        this.b = (TextView) findViewById(R.id.hear_this);
        this.c = (TextView) findViewById(R.id.explore);
        this.d = (TextView) findViewById(R.id.charts);
        this.e = (TextView) findViewById(R.id.radio_channels);
        this.f = (TextView) findViewById(R.id.account_name);
        this.g = (TextView) findViewById(R.id.playlists);
        this.h = (TextView) findViewById(R.id.albums);
        this.i = (TextView) findViewById(R.id.settings);
        this.j = (TextView) findViewById(R.id.artists);
        this.k = (TextView) findViewById(R.id.mymp3s);
        this.b.setOnClickListener(this.p);
        this.c.setOnClickListener(this.p);
        this.d.setOnClickListener(this.p);
        this.e.setOnClickListener(this.p);
        this.g.setOnClickListener(this.p);
        this.h.setOnClickListener(this.p);
        this.i.setOnClickListener(this.p);
        this.j.setOnClickListener(this.p);
        this.k.setOnClickListener(this.p);
        a();
        Drawable drawable = getResources().getDrawable(R.drawable.settings_icon2x);
        drawable.setBounds(0, 0, m, m);
        this.i.setCompoundDrawables(drawable, null, null, null);
        this.o.add(this.b);
        this.o.add(this.c);
        this.o.add(this.d);
        this.o.add(this.e);
        this.o.add(this.f);
        this.o.add(this.g);
        this.o.add(this.h);
        this.o.add(this.j);
        this.o.add(this.k);
        this.o.add(this.i);
        if (!ahn.a()) {
            Iterator<TextView> it = this.o.iterator();
            while (it.hasNext()) {
                it.next().setBackgroundResource(R.drawable.deezer_textview_selector);
            }
            return;
        }
        this.n = this.b;
        for (TextView textView : this.o) {
            textView.setBackgroundColor(Color.parseColor("#d6d6d6"));
            textView.setTextColor(Color.parseColor("#777777"));
        }
        this.n.setBackgroundColor(Color.parseColor("#656565"));
        this.n.setTextColor(Color.parseColor("#ffffff"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        if (ahn.a() && this.n != textView) {
            this.n.setBackgroundColor(Color.parseColor("#d6d6d6"));
            this.n.setTextColor(Color.parseColor("#777777"));
            textView.setBackgroundColor(Color.parseColor("#656565"));
            textView.setTextColor(Color.parseColor("#ffffff"));
            this.n = textView;
        }
    }

    public void a() {
        FileInputStream fileInputStreamOpenFileInput = null;
        String strD = aho.d("user_name");
        aho.d("user_picture");
        if (TextUtils.isEmpty(strD)) {
            getCurrentUserInfo();
            return;
        }
        this.f.setText(strD);
        try {
            try {
                fileInputStreamOpenFileInput = this.a.openFileInput("pic.jpeg");
                Drawable drawableA = a(fileInputStreamOpenFileInput);
                drawableA.setBounds(0, 0, m, m);
                this.f.setCompoundDrawables(drawableA, null, null, null);
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (fileInputStreamOpenFileInput != null) {
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public Drawable a(InputStream inputStream) {
        return a(b(inputStream));
    }

    public Bitmap b(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        agv.a(true).a(str, new auk(new String[]{"image/png", "image/jpeg"}) { // from class: arm.1
            @Override // defpackage.aug
            public void a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
            }

            @Override // defpackage.aug
            public void a(int i, Header[] headerArr, byte[] bArr) {
                Drawable drawableA = arm.this.a(bArr);
                drawableA.setBounds(0, 0, arm.m, arm.m);
                arm.this.f.setCompoundDrawables(drawableA, null, null, null);
                try {
                    FileOutputStream fileOutputStreamOpenFileOutput = arm.this.a.openFileOutput("pic.jpeg", 0);
                    fileOutputStreamOpenFileOutput.write(bArr);
                    fileOutputStreamOpenFileOutput.flush();
                    fileOutputStreamOpenFileOutput.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public Drawable a(byte[] bArr) {
        return a(b(bArr));
    }

    public Bitmap b(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public Drawable a(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    private void getCurrentUserInfo() {
        this.q = new qj("135461");
        new qo().b(this.q, this.a);
        new qh(this.q, this.r).execute(new ql("user/me"));
    }

    class b implements qn {
        private b() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                akn aknVar = (akn) new qu(akn.class).a(str);
                if (aknVar != null && !TextUtils.isEmpty(aknVar.c())) {
                    arm.this.f.setText(aknVar.c());
                    aho.a("user_name", aknVar.c());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.b())) {
                    arm.this.a(aknVar.b());
                    aho.a("user_picture", aknVar.b());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.a())) {
                    aho.a("user_id", aknVar.a());
                }
                if (aknVar != null && !TextUtils.isEmpty(aknVar.d())) {
                    aho.a("user_status", aknVar.d());
                }
            } catch (IllegalStateException e) {
            }
        }

        @Override // defpackage.qn
        public void a(IOException iOException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(MalformedURLException malformedURLException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qm qmVar, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }
}
