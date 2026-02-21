package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class aqf extends Dialog {
    private LinearLayout a;
    private ImageView b;
    private LinearLayout c;
    private ImageView d;
    private LinearLayout e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private ady i;

    public aqf(Context context, int i) {
        super(context, i);
        setContentView(R.layout.bottom_player_repeat_dialog);
        getWindow().setAttributes(ahn.a(getWindow().getAttributes(), context));
        d();
        e();
        b();
    }

    public void a(ady adyVar) {
        this.i = adyVar;
    }

    public int a() {
        if (this.i != null) {
            return this.i.d();
        }
        return -1;
    }

    public void b() {
        MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
        a(musicPlaylistManagerA);
        b(musicPlaylistManagerA);
    }

    private void d() {
        this.b = (ImageView) findViewById(R.id.bottom_player_room_settings);
        this.d = (ImageView) findViewById(R.id.dialog_shuffle_image);
        this.f = (ImageView) findViewById(R.id.dialog_repeat_image);
        this.b.setColorFilter(getContext().getResources().getColor(R.color.bottomplayer_dialog_text));
        this.a = (LinearLayout) findViewById(R.id.dialog_room_settings_button);
        this.c = (LinearLayout) findViewById(R.id.dialog_shuffle_button);
        this.e = (LinearLayout) findViewById(R.id.dialog_repeat_button);
        this.g = (TextView) findViewById(R.id.bottomplayer_shuffle_text);
        this.h = (TextView) findViewById(R.id.bottomplayer_repeat_text);
    }

    protected boolean c() {
        return aof.a().b() != null && aof.a().b().m() == 33;
    }

    private void e() {
        this.c.setOnClickListener(new View.OnClickListener() { // from class: aqf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
                if (aqf.this.c()) {
                    if (musicPlaylistManagerA.f(aqf.this.a()) == 0) {
                        musicPlaylistManagerA.b(aqf.this.a(), 1);
                        adw.a().j(aqf.this.i);
                    } else {
                        musicPlaylistManagerA.b(aqf.this.a(), 0);
                        adw.a().k(aqf.this.i);
                    }
                } else if (musicPlaylistManagerA.e() == 0) {
                    musicPlaylistManagerA.c(1);
                } else {
                    musicPlaylistManagerA.c(0);
                }
                aqf.this.b(musicPlaylistManagerA);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: aqf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MusicPlaylistManager musicPlaylistManagerA = MusicPlaylistManager.a();
                if (aqf.this.c()) {
                    if (musicPlaylistManagerA.g(aqf.this.a()) == 2) {
                        musicPlaylistManagerA.c(aqf.this.a(), 0);
                        adw.a().i(aqf.this.i);
                    } else if (musicPlaylistManagerA.g(aqf.this.a()) == 0) {
                        musicPlaylistManagerA.c(aqf.this.a(), 2);
                        adw.a().h(aqf.this.i);
                    }
                } else if (musicPlaylistManagerA.d() == 2) {
                    musicPlaylistManagerA.b(1);
                } else if (musicPlaylistManagerA.d() == 1) {
                    musicPlaylistManagerA.b(0);
                } else if (musicPlaylistManagerA.d() == 0) {
                    musicPlaylistManagerA.b(2);
                }
                aqf.this.a(musicPlaylistManagerA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MusicPlaylistManager musicPlaylistManager) {
        if (c()) {
            if (musicPlaylistManager.g(a()) == 2) {
                this.f.setImageResource(R.drawable.repeat_all_selected);
                this.f.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
                this.h.setText(getContext().getResources().getString(R.string.kActionSheetRepeatAll_Str));
                this.h.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
                return;
            }
            if (musicPlaylistManager.g(a()) == 1) {
                this.f.setImageResource(R.drawable.repeat_one_selected);
                this.f.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
                this.h.setText(getContext().getResources().getString(R.string.kActionSheetRepeatOne_Str));
                this.h.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
                return;
            }
            if (musicPlaylistManager.g(a()) == 0) {
                this.f.setImageResource(R.drawable.repeat_all);
                this.f.setBackground(null);
                this.h.setText(getContext().getResources().getString(R.string.kActionSheetNoRepeat_Str));
                this.h.setTextColor(getContext().getResources().getColor(R.color.bottomplayer_dialog_text));
                return;
            }
            return;
        }
        if (musicPlaylistManager.d() == 2) {
            this.f.setImageResource(R.drawable.repeat_all_selected);
            this.f.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
            this.h.setText(getContext().getResources().getString(R.string.kActionSheetRepeatAll_Str));
            this.h.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
            return;
        }
        if (musicPlaylistManager.d() == 1) {
            this.f.setImageResource(R.drawable.repeat_one_selected);
            this.f.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
            this.h.setText(getContext().getResources().getString(R.string.kActionSheetRepeatOne_Str));
            this.h.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
            return;
        }
        if (musicPlaylistManager.d() == 0) {
            this.f.setImageResource(R.drawable.repeat_all);
            this.f.setBackground(null);
            this.h.setText(getContext().getResources().getString(R.string.kActionSheetNoRepeat_Str));
            this.h.setTextColor(getContext().getResources().getColor(R.color.bottomplayer_dialog_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MusicPlaylistManager musicPlaylistManager) {
        if (c()) {
            if (musicPlaylistManager.f(a()) == 0) {
                this.d.setImageResource(R.drawable.shuffle_icon);
                this.d.setBackground(null);
                this.g.setTextColor(getContext().getResources().getColor(R.color.bottomplayer_dialog_text));
                return;
            } else {
                if (musicPlaylistManager.f(a()) == 1) {
                    this.d.setImageResource(R.drawable.shuffle_icon_selected);
                    this.d.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
                    this.g.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
                    return;
                }
                return;
            }
        }
        if (musicPlaylistManager.e() == 0) {
            this.d.setImageResource(R.drawable.shuffle_icon);
            this.d.setBackground(null);
            this.g.setTextColor(getContext().getResources().getColor(R.color.bottomplayer_dialog_text));
        } else if (musicPlaylistManager.e() == 1) {
            this.d.setImageResource(R.drawable.shuffle_icon_selected);
            this.d.setBackground(getContext().getResources().getDrawable(R.drawable.shuffle_selected_bg));
            this.g.setTextColor(getContext().getResources().getColor(R.color.blue_bg));
        }
    }
}
