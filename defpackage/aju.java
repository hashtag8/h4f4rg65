package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceAutoCompleteTextView;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class aju {
    public a<String> a;
    public LinkedList<String> b;
    private final View c;
    private Toolbar e;
    private gk f;
    private TypefaceAutoCompleteTextView g;
    private Runnable i;
    private View j;
    private View k;
    private View l;
    private View m;
    private boolean d = false;
    private ajv h = null;
    private boolean n = false;

    public aju(gk gkVar, Toolbar toolbar, View view, View view2, View view3, View view4, View view5) {
        brw.a(gkVar, "context", new Object[0]);
        brw.a(toolbar, "toolbar", new Object[0]);
        brw.a(view, "statusBar", new Object[0]);
        brw.a(view2, "backgroundView", new Object[0]);
        brw.a(view4, "toolbarShadow", new Object[0]);
        brw.a(view5, "contentBackground", new Object[0]);
        this.f = gkVar;
        this.e = toolbar;
        this.f.a(toolbar);
        this.f.g().b(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f.g().a(0.0f);
        }
        this.c = view;
        this.j = view2;
        this.k = view3;
        this.l = view4;
        this.m = view5;
        toolbar.setNavigationIcon(R.drawable.dashboard_navigation_leftpanel_icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: aju.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view6) {
                aju.this.f();
            }
        });
        this.g = (TypefaceAutoCompleteTextView) toolbar.findViewById(R.id.myEditText);
        this.g.setVisibility(8);
        this.g.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: aju.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                aju.this.g.clearFocus();
                if (aju.this.h != null && aju.this.h.B() != null) {
                    aju.this.h.B().a(textView.getText().toString(), false);
                }
                aju.this.c();
                return true;
            }
        });
        this.g.addTextChangedListener(new TextWatcher() { // from class: aju.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aju.this.h.x() != null && !aju.this.h.x().b().isShowing() && awd.b) {
                    aju.this.h.x().a(aju.this.g);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                awd.b = true;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                aju.this.a(editable);
            }
        });
        this.b = new LinkedList<>();
        i();
        this.a = new a<>(this.f, R.layout.autocomplete_textview, this.b);
        this.g.setAdapter(this.a);
        this.g.setIsAutoCompleteEnabled(false);
        this.g.setThreshold(1000);
        this.g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: aju.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view6, int i, long j) {
                if (i > aju.this.b.size() - 1) {
                    aju.this.g.setText("");
                    aju.this.j();
                    return;
                }
                String str = aju.this.b.get(i);
                if (str.equals(aju.this.f.getString(R.string.PlayListClearAllAlertTitle_Str))) {
                    aju.this.g.setText(str);
                    aju.this.g.setSelection(str.length());
                } else {
                    aju.this.a(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.d) {
            this.f.onBackPressed();
        } else if (this.i != null) {
            this.i.run();
        }
    }

    public void a(Runnable runnable) {
        this.i = runnable;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(ajv ajvVar) {
        if (this.d) {
            this.e.setNavigationIcon(R.drawable.back_button);
        } else if (ajvVar == null) {
            if (this.h == null) {
                this.e.setNavigationIcon(R.drawable.dashboard_navigation_leftpanel_icon);
            } else {
                this.e.setNavigationIcon(this.h.s());
            }
        } else {
            this.e.setNavigationIcon(ajvVar.s());
        }
        if (ajvVar != null) {
            this.h = ajvVar;
            b(ajvVar.b());
            b();
            if (ajvVar.r()) {
                a(ajvVar.u(), ajvVar.v());
                if (ajvVar.c()) {
                    this.g.setIsAutoCompleteEnabled(true);
                    this.g.setThreshold(0);
                } else {
                    this.g.setIsAutoCompleteEnabled(false);
                    this.g.setThreshold(1000);
                }
            } else {
                this.n = false;
                a(ajvVar.e(), ajvVar.d(), ajvVar.t(), ajvVar.f());
                c(ajvVar.i());
            }
            if (ajvVar.z() != null) {
                this.j.setBackground(ajvVar.z());
                b(0);
                this.m.setBackgroundColor(0);
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                return;
            }
            this.j.setBackgroundColor(0);
            this.m.setBackgroundColor(this.f.getResources().getColor(ajvVar.n()));
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        }
    }

    public ajv a() {
        return this.h;
    }

    private void b(int i) {
        this.e.setBackgroundColor(i);
        this.c.setBackgroundColor(a(i, 0.8f));
    }

    private int a(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f;
        return Color.HSVToColor(fArr);
    }

    public void a(int i) {
        if (this.f != null && this.f.g() != null && this.f.g().a() != null) {
            this.f.g().a().setVisibility(i);
        }
    }

    public void a(TypefaceTextView typefaceTextView, SpannableStringBuilder spannableStringBuilder) {
        typefaceTextView.setSingleLine(false);
        typefaceTextView.setEllipsize(TextUtils.TruncateAt.END);
        typefaceTextView.setMaxLines(2);
        typefaceTextView.setText(spannableStringBuilder);
    }

    private void a(String str, int i, SpannableStringBuilder spannableStringBuilder, boolean z) {
        ((InputMethodManager) this.f.getSystemService("input_method")).hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        this.g.setVisibility(8);
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.e.findViewById(R.id.toolbar_title);
        ImageView imageView = (ImageView) this.e.findViewById(R.id.toolbar_logo);
        typefaceTextView.setVisibility(8);
        imageView.setVisibility(8);
        if (str != null || spannableStringBuilder != null) {
            this.f.g().a(false);
            this.f.g().b(true);
            this.f.g().a("");
            this.f.g().c(true);
            typefaceTextView.setVisibility(0);
            typefaceTextView.setTextColor(this.h.g());
            if (this.h != null && this.h.h()) {
                typefaceTextView.setGravity(17);
                if (!this.h.o()) {
                    typefaceTextView.setPadding(0, 0, ahn.a(this.f, 48.0f), 0);
                } else {
                    typefaceTextView.setPadding(0, 0, 0, 0);
                }
            } else {
                typefaceTextView.setGravity(0);
            }
            if (spannableStringBuilder != null) {
                a(typefaceTextView, spannableStringBuilder);
                return;
            }
            typefaceTextView.setText(str);
            typefaceTextView.setOnClickListener(new View.OnClickListener() { // from class: aju.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aju.this.h != null && aju.this.h.a() != null) {
                        aju.this.h.a().a(view);
                    }
                }
            });
            if (this.h != null && this.h.a() != null) {
                this.h.a().a((TextView) typefaceTextView);
            }
            if (!z) {
                typefaceTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            return;
        }
        if (i != 0) {
            this.f.g().b(false);
            this.f.g().a(true);
            imageView.setVisibility(0);
            Drawable drawable = this.f.getResources().getDrawable(i);
            if (this.f.g() != null && this.f.g().a() != null) {
                this.f.g().a().setVisibility(8);
            }
            if (this.h != null && this.h.h()) {
                Toolbar.b bVar = new Toolbar.b(-2, ahn.a(this.f, 48.0f));
                bVar.a = 17;
                int iA = ahn.a(this.f, 8.0f);
                imageView.setLayoutParams(bVar);
                imageView.setPadding(0, iA, 0, iA);
            }
            imageView.setImageDrawable(drawable);
            if (this.h.q() != 0) {
                imageView.setColorFilter(this.h.q(), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    private void c(int i) {
        if (i != 0) {
            this.e.setTitleTextColor(i);
        }
    }

    public void b() {
        MenuItem menuItemFindItem;
        if (this.h != null && (menuItemFindItem = this.e.getMenu().findItem(R.id.action_search)) != null) {
            menuItemFindItem.setVisible(this.h.o());
            Drawable drawable = this.f.getResources().getDrawable(this.h.l());
            drawable.setColorFilter(this.f.getResources().getColor(R.color.white_50), PorterDuff.Mode.MULTIPLY);
            if (this.h.m() != -1) {
                drawable.setColorFilter(this.h.m(), PorterDuff.Mode.MULTIPLY);
            }
            menuItemFindItem.setIcon(drawable);
            menuItemFindItem.setOnMenuItemClickListener(this.h.p());
        }
    }

    private void a(int i, int i2) {
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.e.findViewById(R.id.toolbar_title);
        ImageView imageView = (ImageView) this.e.findViewById(R.id.toolbar_logo);
        typefaceTextView.setVisibility(8);
        imageView.setVisibility(8);
        MenuItem menuItemFindItem = this.e.getMenu().findItem(R.id.action_search);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(true);
            this.f.g().a(false);
            this.f.g().b(false);
            String strJ = this.h.j();
            if (strJ != null) {
                this.g.setText(strJ);
            } else {
                this.g.setText(this.h.C());
            }
            if (this.h != null && this.h.k() != null) {
                this.g.setHint(this.h.k());
            } else {
                this.g.setHint(R.string.SpeakerSetupResearchTitle_Str);
            }
            this.g.setVisibility(0);
            this.g.setTextColor(i);
            this.g.setBackgroundColor(i2);
            this.g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: aju.6
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (!z && !aju.this.g.getText().toString().isEmpty() && aju.this.g.getVisibility() != 8) {
                        aju.this.b(aju.this.g.getText().toString());
                    }
                }
            });
            if (this.g.requestFocus()) {
                this.g.isFocusable();
                if (this.h.x() != null && this.h.y()) {
                    this.h.x().a(this.g);
                }
                ((InputMethodManager) this.f.getSystemService("input_method")).showSoftInput(this.g, 1);
            }
            this.g.setSelection(this.g.getEditableText().toString().length());
            this.n = true;
        }
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_search) {
            return false;
        }
        if (this.h != null && this.h.p() != null) {
            this.h.p().onMenuItemClick(menuItem);
        }
        return true;
    }

    public void c() {
        ((InputMethodManager) this.f.getSystemService("input_method")).hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        String string = this.g.getText().toString();
        if (!bru.a((CharSequence) string) && this.h.A() != null) {
            this.h.A().a(string, ajw.SEARCH_PRESSED);
        }
    }

    private boolean g() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.f.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return false;
        }
        return currentInputMethodSubtype.getLocale().equalsIgnoreCase("ko");
    }

    public void a(Editable editable) {
        boolean zG = g();
        mm.b("onKeyStroke isKorean=" + zG, new Object[0]);
        if (!zG && this.h != null && this.h.w()) {
            String string = editable.toString();
            if (this.h.A() != null) {
                this.h.A().a(string, ajw.INSTANT_SEARCH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!bru.a((CharSequence) str) && this.h.A() != null) {
            this.h.A().a(str, ajw.ITEM_CHOSEN);
            b(str);
        }
    }

    private void h() {
        aho.a("STORED_RECENT_SEARCH_HISTORY", new JSONArray((Collection) this.b).toString());
    }

    private void i() {
        String strD = aho.d("STORED_RECENT_SEARCH_HISTORY");
        if (strD != null && strD.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray(strD);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.get(i).toString());
                }
                this.b.addAll(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.b.contains(str)) {
            this.b.remove(str);
        }
        if (this.b.size() >= 10) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.b.subList(0, 9));
            this.b.clear();
            this.b.addAll(arrayList);
        }
        this.b.addFirst(str);
        this.a.clear();
        this.a.addAll(this.b);
        this.a.notifyDataSetChanged();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        aho.e("STORED_RECENT_SEARCH_HISTORY");
        this.b.clear();
        this.a.clear();
        this.a.notifyDataSetChanged();
        aho.e("tidal_search");
    }

    public String d() {
        return this.g.getVisibility() == 0 ? this.g.getText().toString() : "";
    }

    public boolean e() {
        return this.n;
    }

    public class a<T> extends ArrayAdapter {
        public a(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            if (textView != null) {
                if (i == getCount() - 1) {
                    textView.setTextColor(aju.this.f.getResources().getColor(R.color.blue_bg));
                    textView.setBackgroundResource(R.drawable.ripple_gray);
                } else {
                    textView.setTextColor(aju.this.f.getResources().getColor(R.color.black_50));
                    textView.setBackgroundResource(R.drawable.ripple_gray);
                }
            }
            return textView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return super.getCount() + 1;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i) {
            return i == getCount() + (-1) ? aju.this.f.getString(R.string.PlayListClearAllAlertTitle_Str) : super.getItem(i);
        }
    }
}
