package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.arw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ary extends az {
    private static ary ae;
    private c af;
    private int ag = 0;

    public enum b {
        DEVICE_LIST,
        NOTIC_MSG
    }

    public interface c {
        void a(int i);
    }

    public interface e {
        void a(int i);
    }

    public void a(c cVar) {
        this.af = cVar;
    }

    @Override // defpackage.az
    public Dialog c(Bundle bundle) {
        Bundle bundleL = l();
        return bundleL == null ? super.c(bundle) : a((List<adx>) bundleL.getSerializable(b.DEVICE_LIST.name()), bundleL.getString(b.NOTIC_MSG.name()));
    }

    protected arw a(List<adx> list, String str) {
        View viewInflate = LayoutInflater.from(p()).inflate(R.layout.custom_selectchannel_notice_dialog, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.msg_tv)).setText(R.string.SpeakerSetupSoundBarMore_Str);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.content_list);
        recyclerView.a(new a(p(), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(p()));
        recyclerView.setItemAnimator(new jr());
        recyclerView.setAdapter(new d(list, new e() { // from class: ary.1
            @Override // ary.e
            public void a(int i) {
                ary.this.ag = i;
            }
        }));
        return new arw.a(p()).a(viewInflate).b(str).a(false).a(p().getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ary.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    if (ary.this.af != null) {
                        ary.this.af.a(ary.this.ag);
                    }
                }
            }
        }).d(false).f(false).b();
    }

    public class d extends RecyclerView.a<f> {
        private List<adx> b;
        private e c;
        private int d;

        public d(List<adx> list, e eVar) {
            this.b = list;
            this.c = eVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public f a(ViewGroup viewGroup, int i) {
            return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_selectchannel_notice_content_item, (ViewGroup) null));
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(f fVar, final int i) {
            fVar.n.setText(this.b.get(i).x() + " (" + (i + 1) + ")");
            fVar.o.setOnClickListener(new View.OnClickListener() { // from class: ary.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.d = i;
                    d.this.c.a(i);
                    d.this.c();
                }
            });
            fVar.o.setChecked(i == this.d);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return this.b.size();
        }
    }

    public static class f extends RecyclerView.v {
        TextView n;
        CheckBox o;

        f(View view) {
            super(view);
            this.n = (TextView) view.findViewById(R.id.id_name);
            this.o = (CheckBox) view.findViewById(R.id.custom_content_checkbox);
        }
    }

    public static ary a(List<adx> list, String str, c cVar) {
        if (ae == null) {
            ae = new ary();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(b.DEVICE_LIST.name(), new ArrayList(list));
        bundle.putString(b.NOTIC_MSG.name(), str);
        ae.a(cVar);
        ae.g(bundle);
        return ae;
    }

    public class a extends RecyclerView.g {
        private final int[] b = {android.R.attr.listDivider};
        private Drawable c;
        private int d;

        public a(Context context, int i) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.b);
            this.c = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            this.d = i;
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            c(canvas, recyclerView);
        }

        private void c(Canvas canvas, RecyclerView recyclerView) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int bottom = ((RecyclerView.i) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                this.c.setBounds(paddingLeft, bottom, width, this.c.getIntrinsicHeight() + bottom);
                this.c.draw(canvas);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            if (this.d == 0) {
                rect.set(0, 0, this.c.getIntrinsicWidth(), 0);
            } else {
                rect.set(0, 0, 0, this.c.getIntrinsicHeight());
            }
        }
    }
}
