package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class axm extends Dialog {
    public axm(Context context, int i) {
        super(context, i);
    }

    public static class a {
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private View f;
        private DialogInterface.OnCancelListener h;
        private DialogInterface.OnClickListener k;
        private DialogInterface.OnClickListener l;
        private boolean g = true;
        private boolean i = true;
        private int j = 0;

        public a(Context context) {
            this.a = context;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(View view) {
            this.f = view;
            return this;
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.d = str;
            this.k = onClickListener;
            return this;
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.e = str;
            this.l = onClickListener;
            return this;
        }

        public a a(boolean z) {
            this.g = z;
            return this;
        }

        public axm a() {
            LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
            final axm axmVar = new axm(this.a, R.style.CustomDialog);
            axmVar.setCanceledOnTouchOutside(this.g);
            axmVar.setCancelable(this.i);
            axmVar.setOnCancelListener(this.h);
            View viewInflate = layoutInflater.inflate(R.layout.juke_custom_dialog, (ViewGroup) null);
            axmVar.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            Button button = (Button) viewInflate.findViewById(R.id.id_dialog_okbtn);
            button.setTypeface(ahu.a(this.a));
            Button button2 = (Button) viewInflate.findViewById(R.id.id_dialog_cancelbtn);
            button2.setTypeface(ahu.a(this.a));
            View viewFindViewById = viewInflate.findViewById(R.id.id_dialog_cancelbtn_holder);
            TextView textView = (TextView) viewInflate.findViewById(R.id.id_dialog_message);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.id_dialog_imgae);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.id_dialog_content);
            ((TextView) viewInflate.findViewById(R.id.juke_popup_title)).setText(this.b);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: axm.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    axmVar.dismiss();
                }
            };
            if (this.d != null) {
                button.setText(this.d);
                if (this.k != null) {
                    button.setOnClickListener(new View.OnClickListener() { // from class: axm.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.k.onClick(axmVar, -1);
                        }
                    });
                } else {
                    button.setOnClickListener(onClickListener);
                }
            } else {
                button.setVisibility(8);
            }
            if (this.e != null) {
                button2.setText(this.e);
                if (this.l != null) {
                    button2.setOnClickListener(new View.OnClickListener() { // from class: axm.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.l.onClick(axmVar, -2);
                            axmVar.dismiss();
                        }
                    });
                } else {
                    button2.setOnClickListener(onClickListener);
                }
            } else {
                button2.setVisibility(8);
                viewFindViewById.setVisibility(8);
            }
            if (this.c != null) {
                textView.setText(this.c);
            } else if (this.f != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.f, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.j != 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(this.j);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.rightMargin = (int) this.a.getResources().getDimension(R.dimen.dialog_margin);
            layoutParams.leftMargin = (int) this.a.getResources().getDimension(R.dimen.dialog_margin);
            axmVar.setContentView(viewInflate, layoutParams);
            return axmVar;
        }
    }
}
