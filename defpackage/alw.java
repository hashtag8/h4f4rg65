package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class alw extends amf<akm> {
    private int a;

    public static class a {
        public ImageView a;
    }

    public alw(Context context, List<akm> list) {
        super(context, list);
        this.a = 0;
        this.a = a(context);
    }

    @Override // defpackage.amf, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.d.inflate(R.layout.deezer_flow_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.a = (ImageView) view.findViewById(R.id.img1);
            int iA = a(this.b);
            view.setLayoutParams(new AbsListView.LayoutParams(iA, iA));
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        new ahw().a(aVar.a, getItem(i).e().d());
        return view;
    }

    private int a(Context context) {
        int i = ahn.a(context).a;
        if (ahn.a()) {
            if (context.getResources().getConfiguration().orientation == 2) {
                return (int) (((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - context.getResources().getDimensionPixelSize(R.dimen.left_menu_width)) / 9.0f);
            }
            return (int) (((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) - context.getResources().getDimensionPixelSize(R.dimen.left_menu_width)) / 5.0f);
        }
        return (int) ((i - context.getResources().getDimensionPixelSize(R.dimen.right_panel_marginRight_no_handle)) / 5.0f);
    }
}
