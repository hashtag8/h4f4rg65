package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class asr extends az {
    public static final String ae = asr.class.getSimpleName();
    private TextView af;
    private TextView ag;
    private TextView ah;
    private asm am;
    private CheckBox ai = null;
    private CheckBox aj = null;
    private LinearLayout ak = null;
    private LinearLayout al = null;
    private boolean an = false;

    @Override // defpackage.az, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
    }

    @Override // defpackage.az, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    public void a(asm asmVar) {
        this.am = asmVar;
    }

    @Override // defpackage.az, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.am.a(0);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.legal_landing_dialog, viewGroup, false);
        viewInflate.getBackground().setAlpha(HttpStatus.SC_NO_CONTENT);
        this.ai = (CheckBox) viewInflate.findViewById(R.id.checkboxEula);
        this.ai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: asr.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!asr.this.aj.isChecked() || !z) {
                    asr.this.an = false;
                    asr.this.af.setVisibility(4);
                } else {
                    asr.this.an = true;
                    asr.this.af.setVisibility(0);
                }
            }
        });
        this.ak = (LinearLayout) viewInflate.findViewById(R.id.ll_check_eula);
        this.ak.setOnClickListener(new View.OnClickListener() { // from class: asr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!asr.this.ai.isChecked()) {
                    asr.this.ai.setChecked(true);
                } else {
                    asr.this.ai.setChecked(false);
                }
            }
        });
        this.aj = (CheckBox) viewInflate.findViewById(R.id.checkboxPrivacy);
        this.aj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: asr.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!asr.this.ai.isChecked() || !z) {
                    asr.this.an = false;
                    asr.this.af.setVisibility(4);
                } else {
                    asr.this.an = true;
                    asr.this.af.setVisibility(0);
                }
            }
        });
        this.al = (LinearLayout) viewInflate.findViewById(R.id.ll_check_privacy);
        this.al.setOnClickListener(new View.OnClickListener() { // from class: asr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!asr.this.aj.isChecked()) {
                    asr.this.aj.setChecked(true);
                } else {
                    asr.this.aj.setChecked(false);
                }
            }
        });
        this.ag = (TextView) viewInflate.findViewById(R.id.textEulaLink);
        SpannableString spannableString = new SpannableString(a(R.string.kEULAConfirm_Str));
        spannableString.setSpan(new a(new View.OnClickListener() { // from class: asr.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                asn.a.a(asr.this.p());
            }
        }), 4, spannableString.length(), 33);
        this.ag.setMovementMethod(LinkMovementMethod.getInstance());
        this.ag.setHighlightColor(0);
        this.ag.setText(spannableString);
        this.ah = (TextView) viewInflate.findViewById(R.id.textPrivacyLink);
        SpannableString spannableString2 = new SpannableString(a(R.string.kPrivacyConfirm_Str));
        spannableString2.setSpan(new a(new View.OnClickListener() { // from class: asr.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                asn.a.b(asr.this.p());
            }
        }), 4, spannableString2.length(), 33);
        this.ah.setMovementMethod(LinkMovementMethod.getInstance());
        this.ah.setHighlightColor(0);
        this.ah.setText(spannableString2);
        this.af = (TextView) viewInflate.findViewById(R.id.txtEulaButton);
        this.af.setVisibility(4);
        this.af.setOnClickListener(new View.OnClickListener() { // from class: asr.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (asr.this.an) {
                    aho.a("LEGAL_PERSIST", true);
                    asr.this.b();
                }
            }
        });
        d().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: asr.8
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        return viewInflate;
    }

    class a extends ClickableSpan {
        private final View.OnClickListener b;

        public a(View.OnClickListener onClickListener) {
            this.b = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.b.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
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
}
