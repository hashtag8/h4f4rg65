package defpackage;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.harman.hkconnect.ui.custom.TypefaceAutoCompleteTextView;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class awj {
    ListView a;
    a b;
    private PopupWindow c;
    private LayoutInflater d;
    private Context e;
    private TypefaceAutoCompleteTextView f;

    public void a() {
        if (this.c != null && this.c.isShowing()) {
            this.c.dismiss();
        }
    }

    public PopupWindow b() {
        return this.c;
    }

    public PopupWindow a(View view) {
        if (view instanceof TypefaceAutoCompleteTextView) {
            this.f = (TypefaceAutoCompleteTextView) view;
        }
        ArrayList<String> arrayListC = c();
        if (arrayListC != null) {
            this.b = new a(this.e, arrayListC);
            this.a.setAdapter((ListAdapter) this.b);
        }
        this.c.setFocusable(false);
        this.c.setOutsideTouchable(true);
        int[] iArrB = awe.b(this.e);
        this.c.setWidth(iArrB[0]);
        if (arrayListC == null) {
            this.c.setHeight(0);
        } else {
            this.c.setHeight(iArrB[1] / 3);
        }
        this.c.setContentView(this.a);
        this.c.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: awj.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
            }
        });
        this.c.showAsDropDown(view, 0, 18);
        return this.c;
    }

    private void a(ArrayList<String> arrayList) {
        try {
            awf.a(this.e, "SDATA", arrayList);
        } catch (Exception e) {
            bkx.a(Log.getStackTraceString(e));
        }
    }

    private ArrayList<String> c() {
        try {
            return (ArrayList) awf.a(this.e, "SDATA");
        } catch (IOException e) {
            bkx.a(Log.getStackTraceString(e));
            return null;
        } catch (ClassNotFoundException e2) {
            bkx.a(Log.getStackTraceString(e2));
            return null;
        }
    }

    private int b(String str) {
        ArrayList<String> arrayListC = c();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayListC.size()) {
                return -1;
            }
            if (!arrayListC.get(i2).equalsIgnoreCase(str.trim())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(String str) {
        ArrayList<String> arrayListC = c();
        if (arrayListC == null) {
            arrayListC = new ArrayList<>();
            arrayListC.add(0, str);
        } else {
            int iB = b(str);
            if (iB >= 0 && arrayListC.size() <= 10) {
                arrayListC.remove(iB);
                arrayListC.add(0, str);
            } else if (arrayListC.size() < 10) {
                arrayListC.add(0, str);
            } else {
                arrayListC.add(0, str);
                arrayListC.remove(10);
            }
        }
        a(arrayListC);
    }

    class a extends ArrayAdapter<String> {
        private Context b;
        private ArrayList<String> c;

        public a(Context context, ArrayList<String> arrayList) {
            super(context, 0, arrayList);
            this.b = context;
            this.c = arrayList;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                awj.this.d = (LayoutInflater) this.b.getSystemService("layout_inflater");
                view = awj.this.d.inflate(R.layout.simple_list_item_1, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.text1);
            textView.setTextSize(2.1313622E9f);
            textView.setText(this.c.get(i));
            return view;
        }
    }
}
