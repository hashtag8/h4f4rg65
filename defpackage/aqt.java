package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.ady;
import defpackage.bif;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class aqt {
    private Context a;
    private Bitmap b;
    private ady c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private bip j;
    private MusicData k = null;
    private ady.a l;

    public aqt(Context context, ady adyVar, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.b = null;
        this.a = context;
        this.b = null;
        this.c = adyVar;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        ahe.a(imageView);
        ahe.a(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Bitmap bitmap) {
        return bitmap.getWidth() >= 50 && bitmap.getHeight() >= 50;
    }

    public void a(String str) {
        this.f.setVisibility(4);
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.j = new AnonymousClass1();
            bif.a(this.a).a(str).a(R.drawable.empty_cover_art_small).a(this.j);
        } else {
            if (MusicPlaylistManager.a().s() == null) {
                this.g.setVisibility(0);
                a();
                return;
            }
            ahe.a(this.a.getContentResolver(), ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), Long.valueOf(MusicPlaylistManager.a().s().album_id).longValue()), new AnonymousClass6());
            this.h.setColorFilter(0);
            this.i.setColorFilter(0);
        }
    }

    /* JADX INFO: renamed from: aqt$1, reason: invalid class name */
    class AnonymousClass1 implements bip {
        AnonymousClass1() {
        }

        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            ady.a aVarR;
            if (aqt.this.a(bitmap) || (bitmap = aqt.this.a()) != null) {
                aqt.this.h.setImageBitmap(bitmap);
                aqt.this.g.setVisibility(0);
                aqt.this.g.setImageBitmap(bitmap);
                agx.a().a(aqt.this.i, aqt.this.h, bitmap);
                mm.b("Spotify Source", "Linked Group =%s", aqt.this.c);
                if (aqt.this.c != null && aqt.this.c.r() == ady.a.PATH_SPOTIFY) {
                    mm.b("Spotify Source", "Set blurred spotify icon in background...");
                    agx.a().d(new agw() { // from class: aqt.1.1
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap2) {
                            mm.b("Spotify Source", "bitmap loaded...");
                            agx.a().a(aqt.this.d, aqt.this.e, bitmap2);
                            aqt.this.b = bitmap2;
                        }
                    });
                    return;
                } else {
                    agx.a().a(bitmap, false, new agw() { // from class: aqt.1.2
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap2) {
                            agx.a().a(aqt.this.d, aqt.this.e, bitmap2);
                            aqt.this.b = bitmap2;
                        }
                    });
                    return;
                }
            }
            aqt aqtVar = aqt.this;
            if (aqt.this.c != null) {
                aVarR = aqt.this.c.r();
            } else {
                aVarR = null;
            }
            agx.a().a(aqt.this.d, aqt.this.e, aqtVar.b(aVarR));
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
            agx.a().b(R.drawable.empty_no_cover_art, new agw() { // from class: aqt.1.3
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    aqt.this.h.setImageBitmap(bitmap);
                    agx.a().b(new agw() { // from class: aqt.1.3.1
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap2) {
                            agx.a().a(aqt.this.d, aqt.this.e, bitmap2);
                        }
                    });
                    agx.a().a(aqt.this.i, aqt.this.h, bitmap);
                }
            });
            aqt.this.b = null;
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    }

    /* JADX INFO: renamed from: aqt$6, reason: invalid class name */
    class AnonymousClass6 implements agw {
        AnonymousClass6() {
        }

        @Override // defpackage.agw
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                aqt.this.h.setImageBitmap(bitmap);
                aqt.this.g.setVisibility(0);
                aqt.this.g.setImageBitmap(bitmap);
                agx.a().a(aqt.this.i, aqt.this.h, bitmap);
                agx.a().a(bitmap, false, new agw() { // from class: aqt.6.1
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap2) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap2);
                        aqt.this.b = bitmap2;
                    }
                });
                return;
            }
            agx.a().b(R.drawable.empty_no_cover_art, new agw() { // from class: aqt.6.2
                @Override // defpackage.agw
                public void a(Bitmap bitmap2) {
                    aqt.this.h.setImageBitmap(bitmap2);
                    aqt.this.g.setVisibility(0);
                    aqt.this.g.setImageDrawable(aqt.this.a.getResources().getDrawable(R.drawable.empty_cover_art_small));
                    agx.a().b(new agw() { // from class: aqt.6.2.1
                        @Override // defpackage.agw
                        public void a(Bitmap bitmap3) {
                            agx.a().a(aqt.this.d, aqt.this.e, bitmap3);
                        }
                    });
                    agx.a().a(aqt.this.i, aqt.this.h, bitmap2);
                    aqt.this.b = null;
                }
            });
        }
    }

    private void a(MusicData musicData) {
        a(musicData.album_art);
    }

    public Bitmap a() {
        if (this.c == null) {
            return null;
        }
        ady.a aVarR = this.c.r();
        if (!a(aVarR)) {
            return null;
        }
        this.l = aVarR;
        this.k = MusicPlaylistManager.a().s();
        return b(aVarR);
    }

    private boolean a(ady.a aVar) {
        if (this.l != aVar) {
            return true;
        }
        if (this.l == ady.a.PATH_FC_IS_STREAMING_TO_DEVICE) {
            return brs.b(MusicPlaylistManager.a().s(), this.k);
        }
        return false;
    }

    public Bitmap b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(ady.a aVar) {
        switch (aVar) {
            case PATH_AUX:
                this.i.setImageResource(R.drawable.a_u_x_emptystate_icon_big);
                this.g.setImageResource(R.drawable.emptystate_aux_small);
                agx.a().g(new agw() { // from class: aqt.7
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_HDMI:
                this.i.setImageResource(R.drawable.hdmibig);
                this.g.setImageResource(R.drawable.hdmismall);
                agx.a().g(new agw() { // from class: aqt.8
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_OPTICAL:
                this.i.setImageResource(R.drawable.opticalbig);
                this.g.setImageResource(R.drawable.opticalsmall);
                agx.a().h(new agw() { // from class: aqt.9
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_BT:
                this.i.setImageResource(R.drawable.bluetooth_state);
                this.g.setImageResource(R.drawable.emptystate_bluetooth_small);
                agx.a().c(new agw() { // from class: aqt.10
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_SPOTIFY:
                this.i.setImageResource(R.drawable.spotifybig);
                this.g.setImageResource(R.drawable.spotifysmall);
                agx.a().d(new agw() { // from class: aqt.11
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_GOOGLE_CAST:
                this.i.setImageResource(R.drawable.google_cast_big_image);
                this.g.setImageResource(R.drawable.google_cast_mini_player_status);
                agx.a().e(new agw() { // from class: aqt.12
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_AIRPLAY:
                this.i.setImageResource(R.drawable.airplay_big_image);
                this.g.setImageResource(R.drawable.air_play_mini_player_status);
                agx.a().f(new agw() { // from class: aqt.13
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_FC_IS_STREAMING_TO_DEVICE:
                if (this.k != null) {
                    a(this.k);
                    return null;
                }
                bif.a((Context) HarmanApplication.a()).a(R.drawable.empty_no_cover_art).a(this.i);
                this.g.setImageResource(R.drawable.empty_cover_art_small);
                agx.a().a(new agw() { // from class: aqt.2
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
                break;
            case PATH_FC_NOT_STREAMING_TO_DEVICE_IS_STREAMING:
                bif.a((Context) HarmanApplication.a()).a(R.drawable.empty_no_cover_art).a(this.i);
                this.g.setImageResource(R.drawable.empty_cover_art_small);
                agx.a().b(new agw() { // from class: aqt.3
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
            case PATH_FC_NOT_STREAMING_TO_DEVICE_NOT_STREAMING:
                bif.a((Context) HarmanApplication.a()).a(R.drawable.empty_no_cover_art).a(this.i);
                this.g.setImageResource(R.drawable.empty_cover_art_small);
                agx.a().a(new agw() { // from class: aqt.4
                    @Override // defpackage.agw
                    public void a(Bitmap bitmap) {
                        agx.a().a(aqt.this.d, aqt.this.e, bitmap);
                        aqt.this.b = bitmap;
                    }
                });
                break;
        }
        return this.b;
    }
}
