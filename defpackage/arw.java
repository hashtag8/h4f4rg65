package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class arw extends ase {
    private int a;
    private Context b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;

    public arw(Context context, int i) {
        super(context, i);
        this.a = 0;
    }

    public static class a {
        private final arw a;
        private Context b;
        private String c;
        private int d;
        private CharSequence e;
        private String f;
        private String g;
        private String h;
        private View i;
        private DialogInterface.OnClickListener p;
        private DialogInterface.OnClickListener q;
        private DialogInterface.OnClickListener r;
        private int s;
        private int j = 0;
        private boolean k = true;
        private boolean l = true;
        private boolean m = true;
        private boolean n = false;
        private boolean o = true;
        private boolean t = false;

        public a(Context context) {
            this.b = context;
            this.a = new arw(this.b, R.style.CustomDialog);
            this.a.a(this.b);
        }

        public a a(boolean z) {
            this.l = z;
            return this;
        }

        public a b(boolean z) {
            this.m = z;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a a(int i) {
            this.e = (String) this.b.getText(i);
            return this;
        }

        public a a(int i, boolean z) {
            this.s = i;
            this.t = z;
            return this;
        }

        public a c(boolean z) {
            this.o = z;
            return this;
        }

        public a b(int i) {
            this.c = (String) this.b.getText(i);
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(View view) {
            this.i = view;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            this.f = ((String) this.b.getText(i)).toUpperCase();
            this.p = onClickListener;
            return this;
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f = str.toUpperCase();
            this.p = onClickListener;
            return this;
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.g = str.toUpperCase();
            this.q = onClickListener;
            return this;
        }

        public a d(boolean z) {
            this.a.setCanceledOnTouchOutside(z);
            return this;
        }

        public a e(boolean z) {
            this.k = z;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.a.setOnCancelListener(onCancelListener);
            return this;
        }

        public a f(boolean z) {
            this.a.setCancelable(z);
            return this;
        }

        public a a() {
            this.n = true;
            return this;
        }

        public arw b() {
            View viewInflate = ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.custom_dialog, (ViewGroup) null);
            this.a.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(this.a.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.a.getWindow().setAttributes(layoutParams);
            this.a.c = (TextView) viewInflate.findViewById(R.id.id_dialog_title);
            this.a.e = (TextView) viewInflate.findViewById(R.id.id_dialog_okbtn);
            this.a.g = (TextView) viewInflate.findViewById(R.id.id_dialog_cancelbtn);
            this.a.f = (TextView) viewInflate.findViewById(R.id.id_dialog_skipbtn);
            this.a.d = (TextView) viewInflate.findViewById(R.id.id_dialog_message);
            this.a.h = (ImageView) viewInflate.findViewById(R.id.id_dialog_imgae);
            this.a.i = (ImageView) viewInflate.findViewById(R.id.warn);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.id_dialog_content);
            LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.id_button_layout);
            if (this.o) {
                this.a.c.setVisibility(0);
            } else {
                this.a.c.setVisibility(8);
            }
            this.a.c.setText(this.c);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: arw.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.a.dismiss();
                }
            };
            if (this.f != null) {
                this.a.e.setText(this.f);
                if (this.p != null) {
                    this.a.e.setOnClickListener(new View.OnClickListener() { // from class: arw.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.p.onClick(a.this.a, -1);
                            if (a.this.m) {
                                a.this.a.dismiss();
                            }
                        }
                    });
                } else {
                    this.a.e.setOnClickListener(onClickListener);
                }
            } else {
                this.a.e.setVisibility(8);
            }
            if (this.g != null) {
                this.a.g.setText(this.g);
                if (this.q != null) {
                    this.a.g.setOnClickListener(new View.OnClickListener() { // from class: arw.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.q.onClick(a.this.a, -2);
                            if (a.this.m) {
                                a.this.a.dismiss();
                            }
                        }
                    });
                } else {
                    this.a.g.setOnClickListener(onClickListener);
                }
            } else {
                this.a.g.setVisibility(8);
            }
            if (this.h != null) {
                this.a.f.setText(this.h);
                if (this.r != null) {
                    this.a.f.setOnClickListener(new View.OnClickListener() { // from class: arw.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            a.this.r.onClick(a.this.a, -3);
                            if (a.this.m) {
                                a.this.a.dismiss();
                            }
                        }
                    });
                } else {
                    this.a.f.setOnClickListener(onClickListener);
                }
            } else {
                this.a.f.setVisibility(8);
            }
            if (this.e != null) {
                this.a.d.setText(this.e);
                if (this.n) {
                    this.a.d.setGravity(3);
                }
            } else if (this.i != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.i, new ViewGroup.LayoutParams(-1, -2));
            } else {
                linearLayout.setVisibility(8);
            }
            if (this.j != 0) {
                this.a.h.setVisibility(0);
                this.a.h.setImageResource(this.j);
            }
            if (this.s != 0 && this.t) {
                this.a.i.setVisibility(0);
                this.a.i.setImageResource(this.s);
            }
            if (!this.k) {
                linearLayout2.setVisibility(8);
            }
            if (this.d != 0) {
                this.a.a(this.d);
                this.a.getWindow().setFlags(this.d, this.d);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
            layoutParams2.gravity = 17;
            if (ahn.a()) {
                layoutParams2.width = aff.t;
            } else {
                layoutParams2.rightMargin = (int) this.b.getResources().getDimension(R.dimen.dialog_margin);
                layoutParams2.leftMargin = (int) this.b.getResources().getDimension(R.dimen.dialog_margin);
            }
            this.a.setContentView(viewInflate, layoutParams2);
            if (this.l) {
                new asc(this.a).a(null);
            }
            this.a.setOwnerActivity((Activity) this.b);
            return this.a;
        }
    }

    public Context a() {
        return this.b;
    }

    public void a(Context context) {
        this.b = context;
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        if (this.d != null) {
            this.d.setText(str);
            this.d.requestLayout();
        }
    }

    public void b(String str) {
        if (this.e != null) {
            this.e.setText(str);
            this.e.requestLayout();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.e != null) {
            if (onClickListener == null) {
                this.e.setClickable(false);
                this.e.setBackgroundColor(0);
            } else {
                this.e.setClickable(true);
                this.e.setBackgroundResource(R.drawable.custom_dialog_button_bg);
            }
            this.e.setOnClickListener(onClickListener);
        }
    }

    @Override // defpackage.ase, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (b() != 0) {
            ((Activity) a()).getWindow().clearFlags(b());
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return ((i == 24 || i == 25) && getOwnerActivity() != null) ? getOwnerActivity().onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }
}
