package com.harman.commom.music.player.service;

import defpackage.agd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RadioMusicData extends MusicData {
    private ArrayList<MusicData> a = new ArrayList<>();
    private int b = 0;

    public boolean a() {
        this.b++;
        if (this.a.size() != this.b) {
            return true;
        }
        this.b--;
        return c();
    }

    public void a(MusicData musicData) {
        this.a.add(musicData);
    }

    public void a(int i, MusicData musicData) {
        if (i > b()) {
            a(musicData);
        } else {
            this.a.add(i, musicData);
        }
    }

    public MusicData a(int i) {
        return this.a.get(i);
    }

    public int b() {
        return this.a.size();
    }

    public boolean c() {
        return false;
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public agd getPlayAbleUrl() {
        return new agd(a(this.b).path);
    }

    public MusicData d() {
        if (b() > this.b) {
            return a(this.b);
        }
        return null;
    }

    public int e() {
        return this.b;
    }
}
