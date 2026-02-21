package defpackage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class asq extends az implements View.OnClickListener {
    public static final String ae = asq.class.getSimpleName();
    private TextView ag;
    private ImageView ah;
    private TextView af = null;
    private String ai = "EULA_HKController_Android.txt";
    private int aj = R.string.kEULA_Str;

    public void b(String str) {
        this.ai = str;
    }

    public void d(int i) {
        this.aj = i;
    }

    @Override // defpackage.az, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = this.aj == R.string.kEULA_Str;
        View viewInflate = layoutInflater.inflate(R.layout.legal_dialog, viewGroup, false);
        this.af = (TextView) viewInflate.findViewById(R.id.text_view);
        this.ah = (ImageView) viewInflate.findViewById(R.id.back_btn);
        this.ag = (TextView) viewInflate.findViewById(R.id.text_title);
        this.ag.setText(this.aj);
        this.ah.setOnClickListener(this);
        StringBuffer stringBuffer = new StringBuffer();
        String strC = c(this.ai);
        if (strC.equalsIgnoreCase("")) {
            strC = d(this.ai);
        }
        stringBuffer.append(strC);
        if (z) {
            Locale locale = q().getConfiguration().locale;
            stringBuffer.append("\r\n");
            if (locale.getLanguage().endsWith("de")) {
                stringBuffer.append(a(R.string.ToS_de));
            } else {
                stringBuffer.append(a(R.string.ToS_other_language));
            }
        }
        this.af.setText(stringBuffer.toString());
        if (z) {
            View viewFindViewById = viewInflate.findViewById(R.id.googlecast_license_terms);
            viewFindViewById.setOnClickListener(this);
            viewFindViewById.setVisibility(ain.o ? 0 : 8);
            View viewFindViewById2 = viewInflate.findViewById(R.id.googlecast_license_privacy);
            viewFindViewById2.setOnClickListener(this);
            viewFindViewById2.setVisibility(ain.o ? 0 : 8);
            View viewFindViewById3 = viewInflate.findViewById(R.id.googlecast_open_source_licence);
            viewFindViewById3.setOnClickListener(this);
            viewFindViewById3.setVisibility(ain.o ? 0 : 8);
            View viewFindViewById4 = viewInflate.findViewById(R.id.google_analytics);
            viewFindViewById4.setOnClickListener(this);
            viewFindViewById4.setVisibility(ain.o ? 0 : 8);
        }
        return viewInflate;
    }

    private String c(String str) {
        try {
            FileInputStream fileInputStreamOpenFileInput = p().openFileInput(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStreamOpenFileInput.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    mm.c("load file from data section success , " + str, new Object[0]);
                    return str2;
                }
            }
        } catch (Exception e) {
            mm.e("load eula from data section failed, msg=" + e.getLocalizedMessage() + ", " + str, new Object[0]);
            return "";
        }
    }

    private String d(String str) {
        InputStream inputStreamOpen;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStreamOpen = p().getAssets().open(str);
            bArr = new byte[1024];
        } catch (Exception e) {
            mm.e("load file from assets failed, msg=" + e.getLocalizedMessage() + ", " + str, new Object[0]);
        }
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            return byteArrayOutputStream.toString();
        }
        byteArrayOutputStream.close();
        inputStreamOpen.close();
        mm.c("load file from assets success , " + str, new Object[0]);
        return byteArrayOutputStream.toString();
    }

    @Override // android.support.v4.app.Fragment
    public void C() {
        super.C();
    }

    @Override // defpackage.az
    public Dialog c(Bundle bundle) {
        Dialog dialog = new Dialog(p(), android.R.style.Theme.Black.NoTitleBar);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(q().getColor(R.color.black)));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        attributes.windowAnimations = R.style.EULADialogStyle;
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.googlecast_license_terms /* 2131689728 */:
                e("http://www.google.com/policies/terms/");
                break;
            case R.id.googlecast_license_privacy /* 2131689729 */:
                e("http://www.google.com/policies/privacy/");
                break;
            case R.id.google_analytics /* 2131689730 */:
                e("https://www.google.com/policies/privacy/partners/");
                break;
            case R.id.googlecast_open_source_licence /* 2131689732 */:
                e("https://support.google.com/googlecast/answer/6121012");
                break;
            case R.id.back_btn /* 2131690521 */:
                b();
                break;
        }
    }

    private void e(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        a(Intent.createChooser(intent, "please select a browser"));
    }
}
