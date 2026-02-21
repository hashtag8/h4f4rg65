package defpackage;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.nowplaying.MyQueueLayout;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.arw;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class aoa extends ajl implements View.OnClickListener {
    private Context a;
    private DashboardActivity.b b;
    private ImageView c;
    private MyQueueLayout d;
    private CoordinatorLayout e;
    private ImageView f;
    private ImageView g;

    public boolean a() {
        if (this.a instanceof DashboardActivity) {
            return true;
        }
        if (this.a instanceof aqb) {
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new DashboardActivity.b() { // from class: aoa.1
            @Override // com.harman.hkconnect.ui.DashboardActivity.b
            public boolean a(int i, KeyEvent keyEvent) {
                return aoa.this.goBack(i, keyEvent);
            }
        };
        if (a()) {
            ((DashboardActivity) this.a).a(this.b);
        }
        setStyle(0, R.style.Theme.Black.NoTitleBar.Fullscreen);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(com.harman.hkconnect.R.layout.dashboard_musicqueue_fragment_new, viewGroup, false);
        if (ahn.a()) {
        }
        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(point);
        ((MyQueueLayout) viewInflate.findViewById(com.harman.hkconnect.R.id.myqueue_layout)).setTextViewWidth(point.x - ahn.a(getActivity(), 140.0f));
        this.c = (ImageView) viewInflate.findViewById(com.harman.hkconnect.R.id.music_queue_back);
        this.f = (ImageView) viewInflate.findViewById(com.harman.hkconnect.R.id.queue_shuffle);
        this.f.setImageResource(com.harman.hkconnect.R.drawable.shuffle_icon_no_alpha);
        a(MusicPlaylistManager.a().e() == 0);
        this.g = (ImageView) viewInflate.findViewById(com.harman.hkconnect.R.id.queue_repeat_mode);
        this.g.setColorFilter(-1);
        this.g.setAlpha(1.0f);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(com.harman.hkconnect.R.id.music_queue_clear_all_layout);
        this.d = (MyQueueLayout) viewInflate.findViewById(com.harman.hkconnect.R.id.myqueue_layout);
        this.e = (CoordinatorLayout) viewInflate.findViewById(com.harman.hkconnect.R.id.coordinator_layout);
        this.d.setCoordinatorLayout(this.e);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a = activity;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.requestWindowFeature(1);
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: aoa.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return aoa.this.goBack(i, keyEvent);
            }
        });
        dialogOnCreateDialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = dialogOnCreateDialog.getWindow().getAttributes();
        attributes.width = getResources().getInteger(com.harman.hkconnect.R.integer.music_queue_width);
        attributes.height = getResources().getInteger(com.harman.hkconnect.R.integer.music_queue_height);
        attributes.format = -3;
        attributes.gravity = 17;
        attributes.flags = 2;
        attributes.dimAmount = 0.5f;
        dialogOnCreateDialog.getWindow().setAttributes(attributes);
        return dialogOnCreateDialog;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void b() {
        if (this.a instanceof DashboardActivity) {
            ((DashboardActivity) this.a).a(this.b);
        }
        f();
        MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
        b(musicPlaylistManagerA);
        a(musicPlaylistManagerA);
    }

    public void c() {
        if (this.a instanceof DashboardActivity) {
            ((DashboardActivity) this.a).af();
        }
    }

    private void f() {
        if (aof.a().r() && !aof.a().l()) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
        b(musicPlaylistManagerA);
        if (musicPlaylistManagerA.e() == 0) {
            a(true);
        } else {
            a(false);
        }
        this.d.a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.harman.hkconnect.R.id.music_queue_back /* 2131689985 */:
                if (this.a instanceof DashboardActivity) {
                    ((DashboardActivity) this.a).W();
                }
                break;
            case com.harman.hkconnect.R.id.queue_shuffle /* 2131689986 */:
                g();
                break;
            case com.harman.hkconnect.R.id.queue_repeat_mode /* 2131689987 */:
                h();
                break;
            case com.harman.hkconnect.R.id.music_queue_clear_all_layout /* 2131689989 */:
                if (MusicPlaylistManager.a().i().a() > 0) {
                    i();
                }
                break;
        }
    }

    private void g() {
        MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
        if (musicPlaylistManagerA.e() == 0) {
            musicPlaylistManagerA.c(1);
        } else {
            musicPlaylistManagerA.c(0);
        }
        a(musicPlaylistManagerA);
    }

    private void a(boolean z) {
        if (z) {
            this.f.setImageResource(com.harman.hkconnect.R.drawable.shuffle_icon_no_alpha);
            this.f.setColorFilter(-1);
            this.f.setAlpha(0.3f);
        } else {
            this.f.setImageResource(com.harman.hkconnect.R.drawable.shuffle_icon_no_alpha);
            this.f.setColorFilter(-1);
            this.f.setAlpha(1.0f);
        }
    }

    private void a(MusicPlaylistManager musicPlaylistManager) {
        a(musicPlaylistManager.e() == 0);
        this.d.c();
        this.d.a();
        f();
    }

    private void h() {
        MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
        if (musicPlaylistManagerA.d() == 2) {
            musicPlaylistManagerA.b(1);
        } else if (musicPlaylistManagerA.d() == 1) {
            musicPlaylistManagerA.b(0);
        } else if (musicPlaylistManagerA.d() == 0) {
            musicPlaylistManagerA.b(2);
        }
        b(musicPlaylistManagerA);
    }

    private void b(MusicPlaylistManager musicPlaylistManager) {
        if (musicPlaylistManager.d() == 2) {
            this.g.setImageResource(com.harman.hkconnect.R.drawable.repeat_all);
            this.g.setColorFilter(-1);
            this.g.setAlpha(1.0f);
        } else if (musicPlaylistManager.d() == 1) {
            this.g.setImageResource(com.harman.hkconnect.R.drawable.repeat_one);
            this.g.setColorFilter(-1);
            this.g.setAlpha(1.0f);
        } else if (musicPlaylistManager.d() == 0) {
            this.g.setImageResource(com.harman.hkconnect.R.drawable.repeat_all);
            this.g.setColorFilter(-1);
            this.g.setAlpha(0.3f);
        }
    }

    private void i() {
        arw arwVarB = new arw.a(getActivity()).a(getString(com.harman.hkconnect.R.string.PlayListClearAllMessage_Str)).b(getString(com.harman.hkconnect.R.string.PlayListClearAllAlertTitle_Str)).a(getString(com.harman.hkconnect.R.string.PlayListClearAllAlertTitle_Str), new DialogInterface.OnClickListener() { // from class: aoa.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MusicPlaylistManager.a().g();
                aoa.this.d();
                if (aoa.this.a instanceof DashboardActivity) {
                    ((DashboardActivity) aoa.this.a).V();
                    ((DashboardActivity) aoa.this.a).Z();
                }
            }
        }).b(getString(com.harman.hkconnect.R.string.Cancel_Str), null).d(false).b();
        if (!getActivity().isFinishing()) {
            arwVarB.show();
        }
    }

    public void d() {
        this.d.c();
        f();
    }

    public void e() {
        this.d.c();
    }

    public boolean goBack(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ((DashboardActivity) this.a).W();
            return true;
        }
        if (i == 24 || i == 25) {
            ((DashboardActivity) this.a).k(true);
            return true;
        }
        return false;
    }
}
