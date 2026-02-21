package defpackage;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class aqi {

    public interface a {
        void a(View view);

        void b(View view);
    }

    public static void a(View view, final a aVar) {
        if (aVar != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: aqi.1
                private boolean b = true;
                private Handler c = new Handler() { // from class: aqi.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        aVar.a((View) message.obj);
                    }
                };

                /* JADX WARN: Type inference failed for: r0v4, types: [aqi$1$2] */
                @Override // android.view.View.OnClickListener
                public void onClick(final View view2) {
                    if (this.b) {
                        this.b = false;
                        new Thread() { // from class: aqi.1.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Thread.sleep(450L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (!AnonymousClass1.this.b) {
                                    AnonymousClass1.this.b = true;
                                    Message messageObtainMessage = AnonymousClass1.this.c.obtainMessage();
                                    messageObtainMessage.obj = view2;
                                    AnonymousClass1.this.c.sendMessage(messageObtainMessage);
                                }
                            }
                        }.start();
                    } else {
                        this.b = true;
                        aVar.b(view2);
                    }
                }
            });
        }
    }
}
