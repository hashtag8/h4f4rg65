package com.harman.hkconnect.ui.custom;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class CustomLayoutManager extends android.support.v7.widget.LinearLayoutManager {
    private int a;
    private int b;

    public CustomLayoutManager(Context context, int i, int i2) {
        super(context);
        this.a = i;
        this.b = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int z() {
        return Math.round((this.a / 2.0f) - (this.b / 2.0f));
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int B() {
        return z();
    }
}
