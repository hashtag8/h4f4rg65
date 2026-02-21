package com.harman.commom.music.player.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import defpackage.aff;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonIntentReceiver extends BroadcastReceiver {
    private static long a = 0;
    private static boolean b = false;
    private static boolean c = false;
    private static Handler d = new Handler() { // from class: com.harman.commom.music.player.service.MediaButtonIntentReceiver.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!MediaButtonIntentReceiver.c) {
                        Intent intent = new Intent();
                        intent.putExtra("autoshuffle", "true");
                        intent.setFlags(335544320);
                        boolean unused = MediaButtonIntentReceiver.c = true;
                    }
                    break;
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        KeyEvent keyEvent;
        if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
            int keyCode = keyEvent.getKeyCode();
            int action = keyEvent.getAction();
            long eventTime = keyEvent.getEventTime();
            String str = null;
            switch (keyCode) {
                case 79:
                case 85:
                    str = "";
                    break;
                case 86:
                    str = "stop";
                    break;
                case 87:
                    str = "next";
                    break;
                case 88:
                    str = "previous";
                    break;
                case 126:
                    str = "play";
                    break;
                case 127:
                    str = "pause";
                    break;
            }
            if (aff.b != 2004 && str != null) {
                if (action == 0) {
                    if (b) {
                        if ("".equals(str) && a != 0 && eventTime - a > 1000) {
                            d.sendMessage(d.obtainMessage(1, context));
                        }
                    } else {
                        Intent intent2 = new Intent(context, (Class<?>) MusicService.class);
                        intent2.setAction("com.harman.hkconnect.android.music.ui.musicservicecommand");
                        if (keyCode == 79 && eventTime - a < 300) {
                            intent2.putExtra("command", "next");
                            context.startService(intent2);
                            a = 0L;
                        } else {
                            intent2.putExtra("command", str);
                            context.startService(intent2);
                            a = eventTime;
                        }
                        c = false;
                        b = true;
                    }
                } else {
                    d.removeMessages(1);
                    b = false;
                }
                if (isOrderedBroadcast()) {
                    abortBroadcast();
                }
            }
        }
    }
}
