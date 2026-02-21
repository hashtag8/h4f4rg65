package com.stc.upnp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import defpackage.bja;
import defpackage.bjn;
import defpackage.bkj;
import defpackage.bkx;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class DlnaService extends Service implements bja {
    public static String a = "upnp:class = \"object.container.album.musicAlbum\"";
    public static String b = "upnp:class = \"object.container.person.musicArtist\"";
    public static String c = "upnp:class = \"object.container.genre.musicGenre\"";
    public static String d = "upnp:class = \"object.container.playlistContainer\"";
    public static String e = "upnp:class = \"object.item.audioItem.musicTrack\"";
    public static String f = "dc:title contains ";
    private bkj h;
    private final IBinder g = new a();
    private Stack<Integer> i = new Stack<>();

    public class a extends Binder {
        public a() {
        }
    }

    @Override // defpackage.bja
    public void a(bjn bjnVar) {
        Intent intent = new Intent("dlna.player.NEW_DEVICES_FOUND");
        Bundle bundle = new Bundle();
        bundle.putSerializable("device", bjnVar);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    @Override // defpackage.bja
    public void b(bjn bjnVar) {
        sendBroadcast(new Intent("dlna.player.NEW_DEVICES_FOUND"));
    }

    public void a() {
        this.h = bkj.a();
        this.h.a(this);
        try {
            this.h.d();
        } catch (Exception e2) {
            bkx.a(Log.getStackTraceString(e2));
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.g;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        bkx.a("Application started");
        a();
        return 2;
    }
}
