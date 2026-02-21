package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class bdo extends Dialog {
    public bdo(Context context, int i) {
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

        public a a(int i) {
            this.b = (String) this.a.getText(i);
            return this;
        }

        public a a(String str) {
            this.b = str;
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

        public bdo a() {
            LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
            final bdo bdoVar = new bdo(this.a, R.style.CustomDialog);
            bdoVar.setCanceledOnTouchOutside(this.g);
            bdoVar.setCancelable(this.i);
            bdoVar.setOnCancelListener(this.h);
            View viewInflate = layoutInflater.inflate(R.layout.tidal_custom_dialog, (ViewGroup) null);
            bdoVar.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            TextView textView = (TextView) viewInflate.findViewById(R.id.id_dialog_okbtn);
            textView.setTypeface(ahu.a(this.a));
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.id_dialog_cancelbtn);
            textView2.setTypeface(ahu.a(this.a));
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.id_dialog_message);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.id_dialog_imgae);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.id_dialog_content);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tidal_popup_title);
            textView4.setText(this.b);
            textView4.setTypeface(ahu.b(this.a));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: bdo.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bdoVar.dismiss();
                }
            };
            if (this.d != null) {
                textView.setText(this.d);
                if (this.k != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: bdo.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.k.onClick(bdoVar, -1);
                        }
                    });
                } else {
                    textView.setOnClickListener(onClickListener);
                }
            } else {
                textView.setVisibility(8);
            }
            if (this.e != null) {
                textView2.setText(this.e);
                if (this.l != null) {
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: bdo.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.l.onClick(bdoVar, -2);
                            bdoVar.dismiss();
                        }
                    });
                } else {
                    textView2.setOnClickListener(onClickListener);
                }
            } else {
                textView2.setVisibility(8);
            }
            if (this.c != null) {
                textView3.setText(this.c);
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
            bdoVar.setContentView(viewInflate, layoutParams);
            return bdoVar;
        }
    }
}
