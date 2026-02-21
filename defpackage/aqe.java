package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AppPlayerTotalVolumeSeekbar;
import com.harman.hkconnect.ui.custom.BarAdapt51VolumeSeekBar;
import com.harman.hkconnect.ui.custom.LinearLayoutManager;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioTrackData;
import com.musicservice.shoutcast.model.Station;
import defpackage.ahn;
import defpackage.aqi;
import defpackage.arw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class aqe extends Fragment implements DialogInterface.OnDismissListener, aqi.a {
    private static Object aC = new Object();
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private LinearLayout D;
    private TextView E;
    private LinearLayout F;
    private TextView G;
    private TextView H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private RelativeLayout M;
    private AppPlayerTotalVolumeSeekbar N;
    private ImageView O;
    private ImageView P;
    private SeekBar Q;
    private TextView R;
    private TextView S;
    private ImageView T;
    private RecyclerView U;
    private RelativeLayout V;
    private LinearLayout W;
    private LinearLayout X;
    private RelativeLayout Y;
    private ImageView Z;
    public MusicPlaylistManager a;
    private aro aA;
    private aro aB;
    private TextView aa;
    private ImageView ab;
    private ImageView ac;
    private RelativeLayout ad;
    private ImageButton ae;
    private ImageButton af;
    private ImageView ag;
    private MusicData ai;
    private c aj;
    private ady ak;
    private int al;
    private int am;
    private aqt ap;
    private ImageView aq;
    private ArrayList<MusicData> ar;
    private Dialog au;
    public ImageView b;
    protected TextView c;
    public aqf d;
    public TypefaceTextView e;
    private long j;
    private aeb l;
    private ImageView m;
    private BarAdapt51VolumeSeekBar n;
    private ImageView o;
    private ImageView p;
    private Context q;
    private b r;
    private RelativeLayout s;
    private TextView t;
    private TextView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;
    private boolean k = true;
    private TextView L = null;
    private long ah = 0;
    private IntentFilter an = null;
    private boolean ao = false;
    private f as = f.UNSUBSCRIBED;
    private e at = e.UNSUBSCRIBE;
    BroadcastReceiver f = new BroadcastReceiver() { // from class: aqe.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            mm.a((Object) "fixrecovery");
            String action = intent.getAction();
            long longExtra = intent.getLongExtra("deviceid", 0L);
            if (action.equals("ACTION_START_RECOVERY") && aqe.this.a(aqe.this.ak, longExtra)) {
                mm.a((Object) "fixrecovery");
                aqe.this.R();
            } else if (action.equals("ACTION_FINISH_RECOVERY")) {
                mm.a((Object) "fixrecovery");
                aqe.this.S();
            }
        }
    };
    private View.OnClickListener av = new View.OnClickListener() { // from class: aqe.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            aqm aqmVar = ((DashboardActivity) aqe.this.q).p.get(0);
            if (!aqmVar.b()) {
                ((DashboardActivity) aqe.this.q).b(aqmVar);
                aho.a(aqmVar.c(), true);
            } else if (!aho.a(aqmVar.c())) {
                ((DashboardActivity) aqe.this.q).a(aqmVar);
                aho.a(aqmVar.c(), true);
            } else {
                Intent launchIntentForPackage = ((DashboardActivity) aqe.this.q).getPackageManager().getLaunchIntentForPackage(aqmVar.c());
                if (launchIntentForPackage != null) {
                    ((DashboardActivity) aqe.this.q).startActivity(launchIntentForPackage);
                }
            }
        }
    };
    private View.OnClickListener aw = new AnonymousClass7();
    private View.OnTouchListener ax = new View.OnTouchListener() { // from class: aqe.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || aqe.this.V.getVisibility() != 0) {
                return false;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.0f, 0.0f, -aqe.this.getResources().getDimensionPixelSize(R.dimen.bottomPlayerGroupMembershipArea_size));
            translateAnimation.setDuration(300L);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(300L);
            aqe.this.T.animate().rotation(0.0f).setDuration(300L).start();
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: aqe.8.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    aqe.this.W.setOnClickListener(null);
                    aqe.this.W.setOnTouchListener(null);
                    aqe.this.Y.setVisibility(8);
                    aqe.this.Y.setOnClickListener(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    aqe.this.U.setVisibility(8);
                    aqe.this.V.setVisibility(4);
                    aqe.this.W.setOnClickListener(aqe.this.aw);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setFillAfter(true);
            aqe.this.X.startAnimation(alphaAnimation);
            aqe.this.V.startAnimation(translateAnimation);
            return true;
        }
    };
    private View.OnClickListener ay = new View.OnClickListener() { // from class: aqe.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mm.b("Clicked like " + (aqe.this.a.s() instanceof MixRadioTrackData) + " " + (view.getId() == R.id.mixradio_music_playback_like), new Object[0]);
            switch (view.getId()) {
                case R.id.mixradio_music_playback_like /* 2131689836 */:
                    MusicData musicDataS = aqe.this.a.s();
                    if (aqe.this.ae != null) {
                        if (aqe.this.ae.isSelected()) {
                            aqe.this.ae.setSelected(false);
                            if (musicDataS instanceof MixRadioTrackData) {
                                ((MixRadioTrackData) musicDataS).a(((MixRadioTrackData) musicDataS).a() ? false : true);
                                ayf.a().a("" + musicDataS.songId, "unlike", true);
                            }
                        } else {
                            aqe.this.ae.setSelected(true);
                            if (musicDataS instanceof MixRadioTrackData) {
                                ((MixRadioTrackData) musicDataS).a(((MixRadioTrackData) musicDataS).a() ? false : true);
                                ayf.a().a("" + musicDataS.songId, "like", true);
                            }
                        }
                    }
                    break;
                case R.id.mixradio_music_playback_dislike /* 2131689837 */:
                    MusicData musicDataS2 = aqe.this.a.s();
                    if (!(musicDataS2 instanceof MixRadioAdvertData)) {
                        ayf ayfVarA = ayf.a();
                        if (ayfVarA.c()) {
                            ayfVarA.g = true;
                            ayf.a().a("" + musicDataS2.songId, "skipnext", true);
                            aqe.this.a.r();
                            ayfVarA.a(1, true, true);
                        } else {
                            ayfVarA.d();
                        }
                        ((MixRadioTrackData) musicDataS2).b(((MixRadioTrackData) musicDataS2).b() ? false : true);
                        ayf.a().a("" + musicDataS2.songId, "dislike", true);
                    }
                    break;
            }
        }
    };
    private View.OnClickListener az = new View.OnClickListener() { // from class: aqe.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            aqe.this.a.a(true);
            if (aqe.this.ai != null || view.getId() == R.id.widget_playback_play_Pause_candidate || view.getId() == R.id.widget_drawer_play_Pause_candidate || aqe.this.B()) {
                switch (view.getId()) {
                    case R.id.widget_drawer_play_Pause_candidate /* 2131689828 */:
                    case R.id.widget_playback_play_Pause_candidate /* 2131689851 */:
                        if (aqe.this.B()) {
                            final adx adxVarX = aqe.this.ak.x();
                            if (!aqe.this.g()) {
                                adw.a().c(aqe.this.ak);
                                aqe.this.b(false);
                                if (aqe.this.k) {
                                    aqe.this.aa();
                                    aqe.this.k = false;
                                }
                            } else {
                                if ((adxVarX == null || adxVarX.u() != 2 || adxVarX.q() != 7) && adxVarX.q() != 8) {
                                    adw.a().d(aqe.this.ak);
                                } else {
                                    adw.a().j(adxVarX);
                                }
                                aqe.this.b(false);
                            }
                            mq.c().schedule(new Runnable() { // from class: aqe.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aqe.this.ae();
                                    adw.a().queryPrivateDataAll(adxVarX);
                                }
                            }, 100L, TimeUnit.MILLISECONDS);
                            break;
                        } else {
                            if (aqe.this.b().r() == null) {
                                aqe.this.k();
                            }
                            switch (AnonymousClass22.a[aqe.this.b().r().ordinal()]) {
                                case 1:
                                case 2:
                                    new arw.a(aqe.this.q).b(aqe.this.q.getString(R.string.Warning_Str)).a(aqe.this.q.getString(R.string.kSameQueue_BreakIn_Str)).a(aqe.this.q.getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: aqe.10.2
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            aqe.this.k();
                                        }
                                    }).b(aqe.this.q.getString(R.string.Cancel_Str), null).d(false).f(true).b().show();
                                    break;
                                default:
                                    aqe.this.k();
                                    break;
                            }
                        }
                        break;
                    case R.id.widget_playback_prev /* 2131689850 */:
                        if (aqe.this.B()) {
                            adw.a().g(aqe.this.ak);
                        } else {
                            aqe.this.a.q();
                            aqe.this.Z();
                        }
                        break;
                    case R.id.widget_playback_next /* 2131689853 */:
                        if (aqe.this.B()) {
                            adw.a().e(aqe.this.ak);
                            mq.b().b(new Runnable() { // from class: aqe.10.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    for (int i = 0; i < 2; i++) {
                                        try {
                                            Thread.sleep(1000L);
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                        aqe.this.ae();
                                    }
                                }
                            });
                        } else {
                            MusicData musicDataS = aqe.this.a.s();
                            if (musicDataS != null) {
                                if ((musicDataS instanceof MixRadioTrackData) || (musicDataS instanceof MixRadioAdvertData)) {
                                    ayf ayfVarA = ayf.a();
                                    if (ayfVarA.c()) {
                                        ayfVarA.g = true;
                                        ayf.a().a("" + musicDataS.songId, "skipnext", true);
                                        aqe.this.a.r();
                                        aqe.this.Z();
                                        ayfVarA.a(1, true, true);
                                    } else {
                                        ayfVarA.d();
                                    }
                                } else if (musicDataS.type == 7) {
                                    azd azdVarA = azd.a();
                                    azdVarA.d();
                                    if (azdVarA.h()) {
                                        azc.b();
                                    } else {
                                        aqe.this.a.r();
                                        aqe.this.Z();
                                    }
                                } else {
                                    aqe.this.a.r();
                                    aqe.this.Z();
                                }
                            }
                        }
                        break;
                }
            }
        }
    };
    private boolean aD = false;
    final Handler g = new Handler();
    private View.OnClickListener aE = new View.OnClickListener() { // from class: aqe.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((aqc) aqe.this.q).a(aqe.this);
            ((aqc) aqe.this.q).k(false);
        }
    };
    private Handler aF = new Handler();
    private Runnable aG = new Runnable() { // from class: aqe.19
        @Override // java.lang.Runnable
        public void run() {
            mm.b("SpotifySubscribe. Sending Renewal request... ", new Object[0]);
            if (aqe.this.as == f.UNSUBSCRIBED) {
                aqe.this.a(e.SUBSCRIBE, false);
                return;
            }
            aqe.this.at = e.SUBSCRIBE;
            aqe.this.a(e.RENEWAL, false);
        }
    };
    Handler h = new Handler();
    Runnable i = new Runnable() { // from class: aqe.20
        @Override // java.lang.Runnable
        public void run() {
            if (aqe.this.a.v() || aqe.this.B()) {
                if (!aqe.this.aD) {
                    int iT = (int) aqe.this.a.t();
                    long j = iT * 1000;
                    if (aqe.this.B()) {
                        j = (int) aqe.this.j;
                        iT = ((int) aqe.this.j) / 1000;
                    }
                    long j2 = aqe.this.ah - j;
                    long j3 = (j < 0 || j >= 1271308768) ? 0L : j;
                    long j4 = j2 < 0 ? 0L : j2;
                    aqe.this.R.setText(art.a(j3));
                    aqe.this.S.setText("- " + art.a(j4));
                    aqe.this.Q.setProgress(iT);
                    aqe.this.h.postDelayed(aqe.this.i, 1000L);
                    aqe.this.j += 1000;
                    return;
                }
                return;
            }
            aqe.this.ad();
        }
    };

    public enum a {
        LINKED_GROUP
    }

    public interface b {
        ImageView a();

        ImageView b();
    }

    public interface d {
        void a();
    }

    enum e {
        SUBSCRIBE,
        UNSUBSCRIBE,
        RENEWAL
    }

    enum f {
        SUBSCRIBED,
        UNSUBSCRIBED,
        RENEWED
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        brw.a(arguments, "arguments", new Object[0]);
        this.ak = (ady) arguments.getSerializable(a.LINKED_GROUP.name());
        brw.a(this.ak, "linkedGroup", new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.q = activity;
        this.r = (b) activity;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.an = new IntentFilter();
        this.an.addAction("ACTION_START_RECOVERY");
        this.an.addAction("ACTION_FINISH_RECOVERY");
        new ahm(getActivity(), this.f).a(this.an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ady adyVar, long j) {
        List<adz> listF;
        List<adx> listK;
        if (adyVar != null && (listF = adyVar.f()) != null && !listF.isEmpty()) {
            for (adz adzVar : listF) {
                if (adzVar != null && (listK = adzVar.k()) != null && !listK.isEmpty()) {
                    for (adx adxVar : listK) {
                        if (adxVar != null && adxVar.P() == j) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        mm.b("Network Chage log", "onCreateView of BottomPlayerItem");
        View viewInflate = layoutInflater.inflate(R.layout.bottom_player_viewpager_item, (ViewGroup) null);
        this.a = MusicPlaylistManager.a();
        this.s = (RelativeLayout) viewInflate.findViewById(R.id.drawer_top_handle);
        this.w = (ImageView) viewInflate.findViewById(R.id.widget_drawer_albumart);
        this.b = (ImageView) viewInflate.findViewById(R.id.widget_drawer_exclamation);
        this.v = (ImageView) viewInflate.findViewById(R.id.widget_drawer_play_Pause_candidate);
        this.t = (TextView) viewInflate.findViewById(R.id.widget_drawer_trackname);
        this.p = (ImageView) viewInflate.findViewById(R.id.spotify_icon_for_drawer_trackname);
        this.u = (TextView) viewInflate.findViewById(R.id.widget_drawer_artistname);
        this.x = (ImageView) viewInflate.findViewById(R.id.close_drawer_button);
        this.aq = (ImageView) viewInflate.findViewById(R.id.speaker_number_limitation);
        this.y = (ImageView) viewInflate.findViewById(R.id.top_bar_exclamation);
        this.z = (ImageView) viewInflate.findViewById(R.id.top_bar_room_icon);
        this.A = (ImageView) viewInflate.findViewById(R.id.widget_playback_play_Pause_candidate);
        this.B = (ImageView) viewInflate.findViewById(R.id.widget_playback_prev);
        this.C = (ImageView) viewInflate.findViewById(R.id.widget_playback_next);
        this.o = (ImageView) viewInflate.findViewById(R.id.spotify_icon);
        this.c = (TextView) viewInflate.findViewById(R.id.main_control_trackname);
        this.E = (TextView) viewInflate.findViewById(R.id.main_control_artistname);
        this.F = (LinearLayout) viewInflate.findViewById(R.id.main_control_qobuz_quality_holder);
        this.G = (TextView) viewInflate.findViewById(R.id.main_control_qobuz_quality_specs);
        this.H = (TextView) viewInflate.findViewById(R.id.main_control_qobuz_quality_icon);
        this.c.setEnabled(true);
        this.D = (LinearLayout) viewInflate.findViewById(R.id.player_control_area);
        this.N = (AppPlayerTotalVolumeSeekbar) viewInflate.findViewById(R.id.widget_display_cell_volume_seekbar);
        this.N.setBackingGroup(this.ak);
        this.n = (BarAdapt51VolumeSeekBar) viewInflate.findViewById(R.id.widget_display_master_device_volume_seekbar);
        this.O = (ImageView) viewInflate.findViewById(R.id.back_blur_albumart);
        this.P = (ImageView) viewInflate.findViewById(R.id.front_blur_foreground);
        this.I = (ImageView) viewInflate.findViewById(R.id.widget_playback_queue);
        this.L = (TextView) viewInflate.findViewById(R.id.top_bar_room_name);
        this.M = (RelativeLayout) viewInflate.findViewById(R.id.widget_player_cell);
        this.Q = (SeekBar) viewInflate.findViewById(R.id.music_seek_bar);
        this.R = (TextView) viewInflate.findViewById(R.id.music_control_start_timer);
        this.S = (TextView) viewInflate.findViewById(R.id.music_control_end_timer);
        this.aa = (TextView) viewInflate.findViewById(R.id.widget_display_cell_link);
        this.T = (ImageView) viewInflate.findViewById(R.id.top_bar_show_members);
        this.W = (LinearLayout) viewInflate.findViewById(R.id.top_bar_touch_layout);
        this.X = (LinearLayout) viewInflate.findViewById(R.id.main_player_except_top);
        this.Y = (RelativeLayout) viewInflate.findViewById(R.id.dismiss_overlay_rooms);
        this.J = (ImageView) viewInflate.findViewById(R.id.widget_more_options);
        this.K = (ImageView) viewInflate.findViewById(R.id.widget_drawer_speaker_icon);
        this.Z = (ImageView) viewInflate.findViewById(R.id.drawer_multi_volume);
        this.m = (ImageView) viewInflate.findViewById(R.id.bar_adapt_volume);
        this.ab = (ImageView) viewInflate.findViewById(R.id.loading_animation_small_player);
        this.ac = (ImageView) viewInflate.findViewById(R.id.loading_animation_expanded_player);
        this.ad = (RelativeLayout) viewInflate.findViewById(R.id.timer_controls);
        this.e = (TypefaceTextView) viewInflate.findViewById(R.id.tv_play_local_music);
        this.ac.setVisibility(8);
        this.ab.setVisibility(8);
        this.ag = (ImageView) viewInflate.findViewById(R.id.album_fade_foreground);
        this.A.setImageResource(R.drawable.play_icon);
        this.ae = (ImageButton) viewInflate.findViewById(R.id.mixradio_music_playback_like);
        this.af = (ImageButton) viewInflate.findViewById(R.id.mixradio_music_playback_dislike);
        this.ae.setOnClickListener(this.ay);
        this.af.setOnClickListener(this.ay);
        this.d = new aqf(this.q, R.style.BottomPlayerDialogTheme);
        this.d.a(b());
        this.J.setOnClickListener(new View.OnClickListener() { // from class: aqe.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqe.this.d.b();
                ((TextView) aqe.this.d.findViewById(R.id.close_repeat_mode_dialog)).setOnClickListener(new View.OnClickListener() { // from class: aqe.12.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        aqe.this.d.dismiss();
                    }
                });
                new asc(aqe.this.d).a(null);
            }
        });
        this.U = (RecyclerView) viewInflate.findViewById(R.id.top_bar_membership_listview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.q);
        linearLayoutManager.b(0);
        this.U.setLayoutManager(linearLayoutManager);
        this.aj = new c(layoutInflater);
        this.aj.a(this.ak.f());
        this.U.setAdapter(this.aj);
        this.V = (RelativeLayout) viewInflate.findViewById(R.id.group_membership_layout);
        this.Y.setVisibility(8);
        this.Y.setOnTouchListener(this.ax);
        this.x.setOnClickListener(new View.OnClickListener() { // from class: aqe.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((DashboardActivity) aqe.this.q).J();
            }
        });
        this.aq.setOnClickListener(new View.OnClickListener() { // from class: aqe.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aqe.this.O();
            }
        });
        this.o.setOnClickListener(this.av);
        this.p.setOnClickListener(this.av);
        if (this.a != null && this.a.i().a() > 0) {
            this.D.setVisibility(0);
            this.e.setVisibility(8);
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(4);
            this.D.setVisibility(8);
            this.e.setVisibility(0);
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: aqe.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqe.this.a.e() == 0) {
                    aqe.this.a.c(1);
                }
                aqe.this.ar = new ArrayList();
                Cursor cursorA = afm.a(aff.c, aff.h, null, null, "title", 0, Integer.MAX_VALUE, aqe.this.q);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        aqe.this.ar.add(new LocalMusicData(cursorA));
                    }
                    cursorA.close();
                }
                aqe.this.a.e(aqe.this.ar);
                aqe.this.e.setVisibility(8);
                ((DashboardActivity) aqe.this.q).J();
                ((DashboardActivity) aqe.this.q).K();
            }
        });
        this.Q.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: aqe.26
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(art.a(aqe.this.ah - ((long) (i * 1000))), "0:00")) {
                    adw.a().b();
                    mm.b("alan test", "queryPrivateDataAllForCurrentGroup");
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                aqe.this.ad();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (aqe.this.ai != null || aqe.this.B()) {
                    aqe.this.a.a(seekBar.getProgress());
                    aqe.this.aa();
                }
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: aqe.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqe.this.q instanceof DashboardActivity) {
                    ((DashboardActivity) aqe.this.q).ah();
                    aqo.f().c();
                }
            }
        });
        this.aa.setOnClickListener(new View.OnClickListener() { // from class: aqe.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqe.this.q instanceof DashboardActivity) {
                    ((DashboardActivity) aqe.this.q).a(aqe.this.ak.f().size() <= 1, aqe.this.N());
                }
                adw.a().c();
            }
        });
        this.v.setOnClickListener(this.az);
        this.A.setOnClickListener(this.az);
        aqi.a(this.B, this);
        this.C.setOnClickListener(this.az);
        this.ap = new aqt(this.q, b(), this.r.a(), this.r.b(), this.K, this.w, this.O, this.P);
        r();
        MusicData musicDataS = this.a.s();
        int iC = aho.c("streamingGroupId");
        if (musicDataS != null) {
            if (Q() || (b() != null && b().d() == iC)) {
                a(musicDataS, Q());
            } else {
                agx.a().a(new agw() { // from class: aqe.29
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqe.this.r.a(), aqe.this.r.b(), bitmap);
                    }
                });
            }
        }
        X();
        this.y.setOnClickListener(new View.OnClickListener() { // from class: aqe.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator<adz> it = aqe.this.ak.f().iterator();
                while (it.hasNext()) {
                    ((DashboardActivity) aqe.this.q).h(it.next().s());
                }
            }
        });
        this.aB = new aro(this.ac, this.q.getResources().getColor(R.color.blue_bg));
        this.aB.a(arj.d, 33);
        this.aA = new aro(this.ab, this.q.getResources().getColor(R.color.blue_bg));
        this.aA.a(arj.d, 33);
        if (this.a.w() || this.ak.q().ag() != null) {
            d();
        } else {
            c();
        }
        this.al = this.q.getResources().getDimensionPixelSize(R.dimen.tablet_margin_leftright_land);
        this.am = this.q.getResources().getDimensionPixelSize(R.dimen.tablet_margin_leftright_port);
        if (ahn.a()) {
            P();
        }
        this.s.setBackgroundResource(R.color.black);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte N() {
        if (this.ak != null) {
            return this.ak.m();
        }
        return (byte) 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.au == null || !this.au.isShowing()) {
            View viewInflate = LayoutInflater.from(this.q).inflate(R.layout.speaker_limitation_dialog, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.id_dialog_message)).setText(R.string.kSignNoticeViewMessage_Str);
            TextView textView = (TextView) viewInflate.findViewById(R.id.unlink);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.ok);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.never_remind_me_again);
            textView.setText(R.string.UnLink_Str);
            textView2.setText(R.string.OK_Str);
            textView3.setText(R.string.kSignNoticeViewNeverRemindButtonTitle_Str);
            this.au = new arw.a(this.q).b(this.q.getString(R.string.kSignNoticeViewTitle_Str)).a(viewInflate).e(false).d(false).f(false).b();
            textView.setOnClickListener(new View.OnClickListener() { // from class: aqe.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aqe.this.au.dismiss();
                    if (aqe.this.q instanceof DashboardActivity) {
                        ((DashboardActivity) aqe.this.q).a(aqe.this.ak.f().size() <= 1, aqe.this.N());
                    }
                    adw.a().c();
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: aqe.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aqe.this.au.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: aqe.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aqe.this.d(false);
                    aqe.this.au.dismiss();
                    aho.a("NEVER_REMIND_ME_AGAIN", true);
                }
            });
            new asc(this.au).a(null);
        }
    }

    private void P() {
        ahn.a aVarA = ahn.a(this.q);
        a(aVarA.a > aVarA.b);
    }

    public void a(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
        if (z) {
            layoutParams.leftMargin = this.al;
            layoutParams.rightMargin = this.al;
        } else {
            layoutParams.leftMargin = this.am;
            layoutParams.rightMargin = this.am;
        }
        this.M.setLayoutParams(layoutParams);
        this.M.invalidate();
    }

    public ImageView a() {
        return this.ag;
    }

    private boolean Q() {
        return brs.a(aof.a().o(), this.ak);
    }

    public ady b() {
        return this.ak;
    }

    public void c() {
        if (this.aA != null) {
            this.aA.d();
        }
        if (this.aB != null) {
            this.aB.d();
        }
        this.v.setVisibility(4);
        this.D.setVisibility(8);
    }

    public void d() {
        if (!this.aD && (this.a.u() != -1 || B())) {
            this.v.setVisibility(0);
        }
        this.D.setVisibility(0);
        this.e.setVisibility(8);
    }

    public void e() {
        y();
        c();
        this.e.setVisibility(0);
    }

    public void f() {
        this.D.setVisibility(0);
        y();
        A();
    }

    /* JADX INFO: renamed from: aqe$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            aqe.this.U.setVisibility(0);
            aqe.this.h.post(new Runnable() { // from class: aqe.7.1
                @Override // java.lang.Runnable
                public void run() {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.0f, -aqe.this.getResources().getDimensionPixelSize(R.dimen.bottomPlayerGroupMembershipArea_size), 0.0f);
                    translateAnimation.setDuration(300L);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
                    alphaAnimation.setDuration(300L);
                    aqe.this.T.animate().rotation(-180.0f).setDuration(300L).start();
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: aqe.7.1.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            aqe.this.V.setVisibility(0);
                            aqe.this.W.setOnClickListener(null);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            aqe.this.W.setOnTouchListener(aqe.this.ax);
                            aqe.this.Y.setVisibility(0);
                            aqe.this.Y.setOnTouchListener(aqe.this.ax);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    alphaAnimation.setFillAfter(true);
                    aqe.this.X.startAnimation(alphaAnimation);
                    aqe.this.V.startAnimation(translateAnimation);
                }
            });
        }
    }

    private void c(boolean z) {
        this.B.setAlpha(0.3f);
        this.B.setClickable(false);
        this.J.setAlpha(0.3f);
        this.J.setClickable(false);
        if (!z) {
            this.ae.setVisibility(0);
            this.af.setVisibility(0);
            this.af.setSelected(false);
            this.ae.setSelected(false);
            this.C.setAlpha(1.0f);
            this.C.setClickable(true);
            return;
        }
        this.af.setVisibility(8);
        this.ae.setVisibility(8);
        this.af.setSelected(false);
        this.ae.setSelected(false);
        this.C.setAlpha(0.3f);
        this.C.setClickable(false);
    }

    public boolean g() {
        return this.ak.q().y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        synchronized (aC) {
            this.aD = true;
            this.v.setVisibility(8);
            this.ab.setVisibility(0);
            this.ac.setVisibility(0);
            this.A.setVisibility(8);
            this.ac.invalidate();
            this.v.invalidate();
            this.A.invalidate();
            this.ab.invalidate();
            if (this.aA == null) {
                mm.b("CLLOG ANIMATION START SMALL " + this, new Object[0]);
                this.aA = new aro(this.ab, this.q.getResources().getColor(R.color.blue_bg));
                this.aA.a(arj.d, 33);
                this.aA.c();
            } else if (!this.aA.a()) {
                this.aA.e();
                this.aA.c();
            }
            if (this.aB == null) {
                mm.b("CLLOG ANIMATION START EXPANDED " + this, new Object[0]);
                this.aB = new aro(this.ac, this.q.getResources().getColor(R.color.blue_bg));
                this.aB.a(arj.d, 33);
                this.aB.c();
            } else if (!this.aB.a()) {
                this.aB.e();
                this.aB.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        synchronized (aC) {
            this.aD = false;
            if (this.aA != null) {
                this.aA.d();
                this.ab.setVisibility(8);
                this.ab.invalidate();
            }
            if (this.aB != null) {
                this.aB.d();
                this.ac.setVisibility(8);
                this.ac.invalidate();
            }
            this.A.setVisibility(0);
            if (this.a.w()) {
                b(brs.a(this.ak, aof.a().o()));
                this.v.setVisibility(0);
                this.v.invalidate();
                this.A.invalidate();
            }
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        mm.b("setUserVisibleHint", this, Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        if (getView() != null && z && brs.a(this.ak, aof.a().b())) {
            Bitmap bitmapB = this.ap.b();
            if (bitmapB == null) {
                if (brs.a(this.ak, aof.a().o())) {
                    agx.a().b(new agw() { // from class: aqe.11
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap) {
                            agx.a().a(aqe.this.r.a(), aqe.this.r.b(), bitmap, 250);
                        }
                    });
                    return;
                } else {
                    agx.a().a(new agw() { // from class: aqe.13
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap) {
                            agx.a().a(aqe.this.r.a(), aqe.this.r.b(), bitmap, 250);
                        }
                    });
                    return;
                }
            }
            agx.a().a(this.r.a(), this.r.b(), bitmapB, 250);
        }
    }

    public void h() {
        R();
    }

    public void i() {
        S();
    }

    public void j() {
        if (brs.a(this.ak, aof.a().o()) && MusicPlaylistManager.a().y() == 2) {
            R();
        } else {
            S();
        }
    }

    public void k() {
        if (this.ai == null && !Q()) {
            if (aof.a().o() == null) {
                aof.a().a(new d() { // from class: aqe.14
                    @Override // aqe.d
                    public void a() {
                        mq.a("FC_THREAD").post(new Runnable() { // from class: aqe.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aqe.this.a.n();
                                aqe.this.a.k();
                            }
                        });
                    }
                });
                return;
            } else {
                this.a.n();
                this.a.k();
                return;
            }
        }
        m();
    }

    public void l() {
        if (this.a.v()) {
            this.a.l();
        }
    }

    public void m() {
        if (this.a.v()) {
            this.a.l();
        }
        if (b().r() != null) {
            switch (b().r()) {
                case PATH_AUX:
                case PATH_BT:
                    this.a.k();
                    break;
                default:
                    this.a.k();
                    break;
            }
        }
    }

    public void a(float f2) {
        this.b.setVisibility(8);
        this.s.setVisibility(0);
        this.M.setVisibility(0);
        float f3 = 2.5f * f2;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.s.setAlpha(1.0f - f3);
        this.M.setAlpha(f3);
    }

    public void n() {
        this.s.setVisibility(4);
        this.M.setVisibility(0);
        this.M.setAlpha(1.0f);
        w();
    }

    public void o() {
        if (this.ao) {
            this.b.setVisibility(0);
        }
        this.M.setVisibility(4);
        this.s.setVisibility(0);
        this.s.setAlpha(1.0f);
        this.X.clearAnimation();
    }

    public void p() {
        if (this.V.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(1L);
            this.T.animate().rotation(0.0f).setDuration(1L).start();
            alphaAnimation.setFillAfter(true);
            this.X.startAnimation(alphaAnimation);
            this.Y.setVisibility(8);
            this.Y.setOnClickListener(null);
            this.V.setVisibility(4);
            this.W.setOnClickListener(this.aw);
        }
    }

    private void T() {
        List<adz> listD = aof.a().d();
        if (listD != null && listD.size() > 1) {
            if (U()) {
                this.aa.setEnabled(true);
                return;
            } else {
                this.aa.setEnabled(false);
                return;
            }
        }
        this.aa.setEnabled(false);
    }

    private boolean U() {
        if (this.ak.f().size() <= 0) {
            return false;
        }
        adz adzVar = this.ak.f().get(0);
        if (adzVar.d() != 2 && adzVar.d() != 5 && adzVar.d() != 4 && adzVar.d() != 3) {
            return true;
        }
        adw.a().g(adzVar.e());
        if (adzVar.f() == 4) {
            return adzVar.i().Z();
        }
        if (adzVar.f() == 3) {
            return adzVar.i().Y();
        }
        return adzVar.f() != 16;
    }

    public void q() {
        T();
        X();
        mm.b("CLLOG STARTNAMES " + this.ak.h() + " " + this.ak.i(), new Object[0]);
        if (this.ak.c() > 1) {
            this.T.setVisibility(0);
            this.z.setVisibility(8);
            this.W.setOnClickListener(this.aw);
            this.Z.setImageAlpha(255);
            this.Z.setOnClickListener(this.aE);
            this.m.setImageAlpha(76);
            this.m.setOnClickListener(null);
        } else {
            this.T.setVisibility(8);
            this.z.setVisibility(0);
            this.z.setImageResource(this.ak.h());
            this.K.setImageResource(this.ak.h());
            this.W.setOnClickListener(null);
            this.Z.setImageAlpha(76);
            this.Z.setOnClickListener(null);
            if (this.ak.f().size() > 0) {
                if (this.ak.f().get(0).d() == 4 || this.ak.f().get(0).d() == 2) {
                    this.m.setImageAlpha(255);
                    this.m.setOnClickListener(this.aE);
                }
            } else {
                this.m.setImageAlpha(76);
                this.m.setOnClickListener(null);
            }
        }
        this.L.setText(this.ak.i());
        a(this.ak);
        this.aj.a(this.ak.f());
        if (((DashboardActivity) this.q).R() && this.s.getVisibility() == 0) {
            n();
        }
        V();
    }

    private void V() {
        if (aho.b("NEVER_REMIND_ME_AGAIN", false)) {
            Log.i("NEVER_REMIND_ME_AGAIN", String.valueOf(aho.b("NEVER_REMIND_ME_AGAIN", false)));
            d(false);
        } else {
            d(arb.a(this.ak));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        ady adyVarB = aof.a().b();
        boolean z2 = adyVarB != null && (adyVarB.k() || MusicPlaylistManager.a().v());
        if (z && z2) {
            this.aq.setVisibility(0);
            this.x.setVisibility(8);
        } else {
            this.aq.setVisibility(8);
            this.x.setVisibility(0);
        }
    }

    public void r() {
        if (this.a.w()) {
            if (this.ak.k()) {
                if (E() || F() || G()) {
                    this.t.setText(this.q.getResources().getString(R.string.kMoveQueueRoom_Str, this.ak.i()));
                } else {
                    aeb aebVarAg = this.ak.q().ag();
                    if (aebVarAg != null && !TextUtils.isEmpty(aebVarAg.c())) {
                        this.t.setText(aebVarAg.c());
                        String strA = a(aebVarAg.d(), aebVarAg.e());
                        if (TextUtils.isEmpty(strA)) {
                            this.u.setVisibility(8);
                            this.w.setVisibility(4);
                        } else {
                            this.w.setVisibility(0);
                            this.u.setVisibility(0);
                            this.u.setText(strA);
                        }
                    } else {
                        this.t.setText(this.q.getResources().getString(R.string.kMoveQueueRoom_Str, this.ak.i()));
                        this.u.setVisibility(8);
                    }
                }
                this.w.setVisibility(0);
            } else {
                this.t.setText(this.q.getResources().getString(R.string.kMoveQueueRoom_Str, this.ak.i()));
                this.w.setVisibility(4);
                this.u.setVisibility(8);
            }
            this.e.setVisibility(8);
        } else if (!B()) {
            if (this.ak.k()) {
                if (this.ak.q().ag().c() != null) {
                    this.t.setText(this.ak.q().ag().c());
                    String strA2 = a(this.ak.q().ag().d(), this.ak.q().ag().e());
                    if (!TextUtils.isEmpty(strA2)) {
                        this.u.setVisibility(0);
                        this.u.setText(strA2);
                    } else {
                        this.u.setVisibility(8);
                    }
                } else {
                    this.t.setText(this.ak.i());
                    this.u.setVisibility(8);
                }
                this.w.setVisibility(0);
            } else {
                this.t.setText(this.ak.i());
                this.w.setVisibility(4);
                this.u.setVisibility(8);
            }
            this.e.setVisibility(0);
        }
        this.aj.a(this.ak.f());
        this.L.setText(this.ak.i());
        if (this.ak.c() > 1) {
            this.T.setVisibility(0);
            this.z.setVisibility(8);
            this.W.setOnClickListener(this.aw);
            this.Z.setImageAlpha(255);
            this.Z.setOnClickListener(this.aE);
            this.m.setImageAlpha(76);
            this.m.setOnClickListener(null);
        } else {
            this.T.setVisibility(8);
            this.z.setVisibility(0);
            this.z.setImageResource(this.ak.h());
            this.W.setOnClickListener(null);
            this.Z.setImageAlpha(76);
            this.Z.setOnClickListener(null);
            if (this.ak.f().size() > 0) {
                if (this.ak.f().get(0).d() == 4 || this.ak.f().get(0).d() == 2) {
                    this.m.setImageAlpha(255);
                    this.m.setOnClickListener(this.aE);
                }
            } else {
                this.m.setImageAlpha(76);
                this.m.setOnClickListener(null);
            }
        }
        this.K.setImageResource(this.ak.h());
        a(this.ak);
        this.K.setVisibility(0);
        this.ap.a();
        this.v.setImageResource(R.drawable.drawer_play);
        this.A.setImageResource(R.drawable.play_icon);
        if (H()) {
            if (this.a.w()) {
                this.c.setText(this.q.getResources().getString(R.string.kMoveQueueHere_Str));
                this.e.setVisibility(8);
            } else {
                this.c.setText(this.q.getResources().getString(R.string.kNoMusicInQueue_Str));
            }
            this.E.setText("");
        } else {
            this.l = this.ak.q().ag();
            if (this.l != null) {
                this.c.setText(this.l.c());
                this.E.setText(a(this.l.d(), this.l.e()));
                if (B() || D()) {
                    if (!TextUtils.isEmpty(this.l.f())) {
                        this.ap.a(this.l.f());
                    }
                    String strC = this.ak.q().ag().c();
                    this.t.setText(TextUtils.isEmpty(strC) ? this.q.getResources().getString(R.string.kMoveQueueRoom_Str, this.ak.i()) : strC);
                    this.u.setVisibility(TextUtils.isEmpty(strC) ? 8 : 0);
                    this.u.setText(a(this.ak.q().ag().d(), this.ak.q().ag().e()));
                    if (this.k) {
                        aa();
                        this.k = false;
                    }
                }
            } else {
                this.c.setText(this.q.getResources().getString(R.string.kNoMusicInQueue_Str));
            }
        }
        this.F.setVisibility(8);
        this.af.setVisibility(8);
        this.ae.setVisibility(8);
        if (B()) {
            adw.a().r(this.ak.q());
            this.Q.setOnTouchListener(new View.OnTouchListener() { // from class: aqe.16
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            z();
            b(false);
            v();
            return;
        }
        if (C() || E() || D() || G() || F()) {
            this.w.setVisibility(0);
            W();
            if (this.a.w()) {
                f();
            } else {
                e();
            }
            if (E() || G() || F()) {
                s();
                return;
            }
            return;
        }
        W();
        Z();
        this.Q.setProgress(0);
        ad();
        this.ai = null;
        this.Q.setVisibility(4);
        this.ad.setVisibility(4);
        A();
    }

    private void W() {
        this.s.setAlpha(1.0f);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        L();
    }

    public void s() {
        this.c.setText("");
        this.E.setText("");
        this.u.setText("");
        this.u.setVisibility(8);
    }

    public void t() {
        this.l = this.ak.q().ag();
        this.ah = this.l.b();
        this.Q.setMax((int) (this.l.b() / 1000));
        this.j = this.l.a();
        this.Q.setProgress(((int) this.j) / 1000);
    }

    public void a(int i) {
        mm.b("SpotifySubscribe Event Received. DeviceResponse = " + i + " Action:: " + this.at, new Object[0]);
        if (this.at == e.SUBSCRIBE || this.at == e.RENEWAL) {
            if (i == 0) {
                this.as = this.at == e.SUBSCRIBE ? f.SUBSCRIBED : f.RENEWED;
                ab();
                return;
            } else {
                mm.e("SpotifySubscribe Command Failed: action:" + this.at, new Object[0]);
                a(this.at == e.SUBSCRIBE ? e.SUBSCRIBE : e.RENEWAL, false);
                return;
            }
        }
        if (this.at == e.UNSUBSCRIBE) {
            mm.b("SpotifySubscribe Unsubscription Command: Device Response " + i + "action:" + this.at, new Object[0]);
            this.as = f.UNSUBSCRIBED;
            ac();
        }
    }

    public void u() {
        this.l = this.ak.q().ag();
        adw.a().e(this.ak.q());
        this.ah = this.l.b();
        mm.b("updateSpotifyPicture currentSongDuration=" + this.ah, new Object[0]);
        this.Q.setMax((int) (this.l.b() / 1000));
        ad();
        aa();
        this.k = false;
        if (this.as == f.UNSUBSCRIBED) {
            a(e.SUBSCRIBE, false);
        }
    }

    public void v() {
        ady adyVarO = aof.a().o();
        if (adyVarO != null) {
            aho.a("streamingGroupId", adyVarO.d());
        }
        if (!bru.a((CharSequence) this.ak.q().ag().c())) {
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
        T();
        this.B.setAlpha(1.0f);
        this.B.setClickable(true);
        this.C.setAlpha(1.0f);
        this.C.setClickable(true);
        this.J.setVisibility(0);
        this.I.setVisibility(4);
    }

    private void X() {
        this.ao = Y();
        if (this.ao) {
            this.y.setVisibility(0);
            this.b.setVisibility(0);
        } else {
            this.y.setVisibility(8);
            this.b.setVisibility(8);
        }
    }

    private boolean Y() {
        for (adz adzVar : this.ak.f()) {
            if (adzVar.d() == 1) {
                if (adzVar.k().size() < 2) {
                    return true;
                }
            } else if (adzVar.d() == 2) {
                if (adzVar.k().size() < 6) {
                    return true;
                }
            } else if (adzVar.d() == 4 && adzVar.k().size() < 3) {
                return true;
            }
        }
        return false;
    }

    private void a(ady adyVar) {
        int iE = adyVar.e();
        int i = iE == -1 ? -16777216 : iE;
        int iRgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        int iRgb2 = Color.rgb(Color.red(iE), Color.green(iE), Color.blue(iE));
        this.z.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
        this.K.setColorFilter(iRgb2, PorterDuff.Mode.MULTIPLY);
    }

    public void w() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null && !((aqc) this.q).A()) {
            this.N.setBackingGroup(adyVarB);
        }
    }

    public boolean x() {
        return true;
    }

    public void y() {
        this.Q.setVisibility(4);
        this.ad.setVisibility(4);
    }

    public void z() {
        this.Q.setVisibility(0);
        this.ad.setVisibility(0);
    }

    public void A() {
        this.I.setVisibility(4);
        this.B.setAlpha(0.3f);
        this.B.setClickable(false);
        this.C.setAlpha(0.3f);
        this.C.setClickable(false);
        this.J.setVisibility(4);
        T();
    }

    public boolean B() {
        return this.ak.m() == 33;
    }

    public boolean C() {
        return this.ak.m() == 2;
    }

    public boolean D() {
        return this.ak.m() == 34;
    }

    public boolean E() {
        return this.ak.m() == 3;
    }

    public boolean F() {
        return this.ak.m() == 16;
    }

    public boolean G() {
        return this.ak.m() == 4;
    }

    public boolean H() {
        return this.ak.m() == 32;
    }

    public void I() {
        W();
        this.I.setVisibility(0);
        this.J.setVisibility(0);
        ady adyVarO = aof.a().o();
        if (adyVarO != null) {
            aho.a("streamingGroupId", adyVarO.d());
        }
        T();
    }

    protected void b(boolean z) {
        if (this.a.v() && z && this.ak.m() == 32) {
            this.v.setImageResource(R.drawable.drawer_pause);
            this.A.setImageResource(R.drawable.pause_icon);
            if (x()) {
                aa();
                return;
            }
            return;
        }
        if (B() && g()) {
            this.v.setImageResource(R.drawable.drawer_pause);
            this.A.setImageResource(R.drawable.pause_icon);
            return;
        }
        this.A.setImageResource(R.drawable.play_icon);
        this.v.setImageResource(R.drawable.drawer_play);
        if (x()) {
            ad();
        }
        this.k = true;
    }

    public void a(MusicData musicData, boolean z) {
        mm.b("TEST_DEVICE_ROUCE", "SOURCE=" + ((int) this.ak.m()));
        b(z);
        I();
        this.Q.setVisibility(0);
        this.Q.setOnTouchListener(new View.OnTouchListener() { // from class: aqe.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.D.setVisibility(0);
        this.e.setVisibility(8);
        this.ai = musicData;
        if (agc.c(this.ai)) {
            this.I.setAlpha(0.3f);
            this.I.setClickable(false);
        } else {
            this.I.setAlpha(1.0f);
            this.I.setClickable(true);
        }
        if (!this.c.getText().toString().equals(musicData.musicName) || !this.E.getText().toString().equals(musicData.artist)) {
            this.t.setText(musicData.musicName);
            this.u.setVisibility(0);
            if (agc.d(musicData) && (musicData instanceof Station)) {
                Station station = (Station) musicData;
                this.E.setText(station.currenttrack);
                this.u.setText(station.currenttrack);
            } else {
                this.E.setText(a(musicData.artist, musicData.album));
                this.u.setText(a(musicData.artist, musicData.album));
            }
            this.c.setText(musicData.musicName);
            if (agc.f(musicData)) {
                int i = ((QobuzMusicData) musicData).h;
                switch (i) {
                    case 16:
                        this.H.setText(this.q.getString(R.string.CD));
                        this.H.setVisibility(0);
                        break;
                    case 24:
                        this.H.setText(this.q.getString(R.string.hi_res));
                        this.H.setVisibility(0);
                        break;
                    default:
                        this.H.setVisibility(8);
                        break;
                }
                this.G.setText(this.q.getString(R.string.qobuz_quality_string, Integer.valueOf(i), ((QobuzMusicData) musicData).g));
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
        }
        w();
        this.Q.setMax(((int) this.a.c()) / 1000);
        this.ah = this.a.c();
        mm.b("setStreamingUi currentSongDuration=" + this.ah, new Object[0]);
        this.ap.a();
        a(musicData);
    }

    private String a(String str, String str2) {
        if (bru.a((CharSequence) str) && bru.a((CharSequence) str2)) {
            return "";
        }
        if (bru.a((CharSequence) str) || !bru.a((CharSequence) str2)) {
            return (!bru.a((CharSequence) str) || bru.a((CharSequence) str2)) ? str + " - " + str2 : str2;
        }
        return str;
    }

    public void a(MusicData musicData) {
        if ((musicData instanceof MixRadioAdvertData) || (musicData instanceof MixRadioTrackData)) {
            c(musicData instanceof MixRadioAdvertData);
            return;
        }
        this.af.setVisibility(8);
        this.ae.setVisibility(8);
        this.af.setSelected(false);
        this.ae.setSelected(false);
        if ((musicData instanceof MusicPlaylistManager.NonStreamingMusicData) || (N() != 32 && N() != 33)) {
            this.B.setAlpha(0.3f);
            this.B.setClickable(false);
            this.C.setAlpha(0.3f);
            this.C.setClickable(false);
            return;
        }
        if (agc.d(musicData)) {
            this.B.setAlpha(0.3f);
            this.B.setClickable(false);
            this.C.setAlpha(0.3f);
            this.C.setClickable(false);
            this.J.setAlpha(0.3f);
            this.J.setClickable(false);
            y();
            return;
        }
        if (agc.e(musicData)) {
            this.B.setAlpha(0.3f);
            this.B.setClickable(false);
            this.C.setAlpha(1.0f);
            this.C.setClickable(true);
            this.J.setAlpha(0.3f);
            this.J.setClickable(false);
            y();
            return;
        }
        if (N() == 32 && this.a.x()) {
            this.B.setAlpha(0.3f);
            this.B.setClickable(false);
            this.C.setAlpha(0.3f);
            this.C.setClickable(false);
            this.ad.setVisibility(0);
            return;
        }
        this.B.setAlpha(1.0f);
        this.B.setClickable(true);
        this.C.setAlpha(1.0f);
        this.C.setClickable(true);
        this.J.setAlpha(1.0f);
        this.J.setClickable(true);
        this.ad.setVisibility(0);
    }

    public void J() {
        this.B.setAlpha(0.3f);
        this.B.setClickable(false);
        this.C.setAlpha(0.3f);
        this.C.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.R.setText("");
        this.S.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final e eVar, final boolean z) {
        mm.b("SpotifySubscribe sendSpotifySubscriptionRequestAndWait Command: " + eVar, new Object[0]);
        mq.b().b(new Runnable() { // from class: aqe.18
            @Override // java.lang.Runnable
            public void run() {
                if (z || (eVar != null && eVar != aqe.this.at)) {
                    for (int i = 0; i < 3; i++) {
                        mm.b("SpotifySubscribe sendSpotifySubscriptionRequestAndWait Retry Count: " + i, new Object[0]);
                        aqe.this.b(eVar.ordinal() + 1);
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (eVar != e.SUBSCRIBE || aqe.this.as != f.SUBSCRIBED) {
                            if (eVar != e.RENEWAL || aqe.this.as != f.RENEWED) {
                                if (eVar == e.UNSUBSCRIBE && aqe.this.as == f.UNSUBSCRIBED) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.ai != null || B()) {
            this.h.post(this.i);
            V();
        }
    }

    private void ab() {
        mm.b("Starting Renewal task", new Object[0]);
        ac();
        this.aF.postDelayed(this.aG, 270000L);
    }

    private void ac() {
        mm.b("Stopping Renewal task", new Object[0]);
        this.aF.removeCallbacks(this.aG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad() {
        this.h.removeCallbacks(this.i);
        V();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (getActivity() != null) {
            aob.h().f();
            ((aqc) getActivity()).B();
            w();
        }
    }

    class c extends RecyclerView.a<a> {
        LayoutInflater a;
        private List<adz> c;

        public c(LayoutInflater layoutInflater) {
            this.a = layoutInflater;
        }

        public void a(List<adz> list) {
            this.c = list;
            c();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(ViewGroup viewGroup, int i) {
            View viewInflate = this.a.inflate(R.layout.bottomplayer_group_membership_item, viewGroup, false);
            a aVar = new a(viewInflate);
            aVar.o = (TextView) viewInflate.findViewById(R.id.group_membership_textview);
            aVar.n = (ImageView) viewInflate.findViewById(R.id.group_membership_icon);
            return aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(a aVar, int i) {
            adz adzVar = this.c.get(i);
            if (adzVar != null) {
                bif.a((Context) aqe.this.getActivity()).a(adzVar.m()).a(R.dimen.bottomPlayerGroupMembershipItem_groupMembershipIcon_size, R.dimen.bottomPlayerGroupMembershipItem_groupMembershipIcon_size).e().a(aVar.n);
                aVar.o.setText(adzVar.l());
                int iQ = adzVar.q();
                if (iQ == -1) {
                    iQ = -16777216;
                }
                aVar.n.setColorFilter(Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ)), PorterDuff.Mode.MULTIPLY);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public long b(int i) {
            return 0L;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return this.c.size();
        }

        class a extends RecyclerView.v {
            ImageView n;
            TextView o;

            public a(View view) {
                super(view);
            }
        }
    }

    @Override // aqi.a
    public void a(View view) {
        if (((int) this.j) / 1000 <= 3) {
            b(view);
            return;
        }
        mm.b("doubleclickutil ------------------------->OnSingleClick", new Object[0]);
        if (B()) {
            adw.a().g(this.ak);
            Z();
            this.j = 0L;
            ad();
            if (g()) {
                aa();
                this.k = false;
                return;
            } else {
                this.Q.setProgress(0);
                this.k = true;
                return;
            }
        }
        this.a.q();
        Z();
    }

    @Override // aqi.a
    public void b(View view) {
        mm.b("doubleclickutil ------------------------->OnDoubleClick", new Object[0]);
        if (B()) {
            Z();
            this.j = 0L;
            ad();
            aa();
            this.k = false;
            adw.a().f(this.ak);
            mq.b().b(new Runnable() { // from class: aqe.21
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        aqe.this.ae();
                    }
                }
            });
        }
    }

    public void K() {
        this.v.setVisibility(((this.a == null || this.a.u() == -1) && !B()) ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        adw.a().a(this.ak);
        adw.a().b(this.ak);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ak != null && this.ak != aof.a().b()) {
            aob.h().a(this.ak.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        mm.b("SpotifySubscribe. Sending Subscription request =  " + i, new Object[0]);
        c(i);
        adw.a().a(aof.a().b().x(), i);
    }

    private void c(int i) {
        e eVar;
        if (i == 3) {
            eVar = e.RENEWAL;
        } else {
            eVar = i == 1 ? e.SUBSCRIBE : e.UNSUBSCRIBE;
        }
        this.at = eVar;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (B()) {
            a(this.as == f.UNSUBSCRIBED ? e.SUBSCRIBE : e.RENEWAL, false);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        if (B() && this.as != f.UNSUBSCRIBED) {
            a(e.UNSUBSCRIBE, false);
        }
    }

    public void L() {
        if (this.as != f.UNSUBSCRIBED) {
            a(e.UNSUBSCRIBE, false);
        }
    }

    public void M() {
        this.at = e.SUBSCRIBE;
        ac();
        this.as = f.UNSUBSCRIBED;
        a(e.SUBSCRIBE, true);
    }
}
