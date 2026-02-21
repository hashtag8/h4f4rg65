package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.ajn;
import defpackage.ajo;
import defpackage.arp;
import defpackage.azk;
import in.srain.cube.views.GridViewWithHeaderAndFooter;

/* JADX INFO: loaded from: classes.dex */
public class AnimationGridView extends GridViewWithHeaderAndFooter {
    private boolean b;
    private ajo c;
    private int d;

    public void setNeedAddFooter(boolean z) {
        this.b = z;
    }

    public AnimationGridView(Context context) {
        super(context);
        this.b = true;
        a();
    }

    public AnimationGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        a();
    }

    public AnimationGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        a();
    }

    private void a() {
        this.c = new ajo((DashboardActivity) getContext(), this);
        setOnTouchListener(this.c);
    }

    @Override // in.srain.cube.views.GridViewWithHeaderAndFooter, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        arp arpVar = null;
        if (this.b) {
            arpVar = new arp(this);
        }
        super.setAdapter(listAdapter);
        if (this.b) {
            arpVar.a();
        }
    }

    public void setOnItemChosenListener(final ajn ajnVar) {
        this.c.a(ajnVar);
        if (getOnItemClickListener() == null) {
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.ui.custom.AnimationGridView.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long j) {
                    final Object itemAtPosition = adapterView.getItemAtPosition(i);
                    if (itemAtPosition instanceof azk) {
                        ajnVar.a(adapterView, i, itemAtPosition);
                    } else {
                        ((DashboardActivity) AnimationGridView.this.getContext()).a(new Runnable() { // from class: com.harman.hkconnect.ui.custom.AnimationGridView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ajnVar.a(adapterView, i, itemAtPosition);
                            }
                        });
                    }
                }
            });
        }
    }

    public void setLeftMargin(int i) {
        this.d = i;
    }

    public int getLeftMargin() {
        return this.d;
    }

    public void setAllowDrag(boolean z) {
        this.c.a(z);
    }
}
