package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.harman.hkconnect.R;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class afh {
    private static BitmapDrawable k;
    public static final String[] a = {"_id", "_data"};
    private static StringBuilder c = new StringBuilder();
    private static Formatter d = new Formatter(c, Locale.getDefault());
    private static final Object[] e = new Object[5];
    public static agb b = null;
    private static HashMap<Context, Object> f = new HashMap<>();
    private static final BitmapFactory.Options g = new BitmapFactory.Options();
    private static final BitmapFactory.Options h = new BitmapFactory.Options();
    private static final Uri i = Uri.parse("content://media/external/audio/albumart");
    private static final HashMap<Long, Drawable> j = new HashMap<>();

    static {
        g.inPreferredConfig = Bitmap.Config.RGB_565;
        g.inDither = false;
        h.inPreferredConfig = Bitmap.Config.RGB_565;
        h.inDither = false;
    }

    public static Bitmap a(Context context, long j2, BitmapDrawable bitmapDrawable) {
        return a(context, j2);
    }

    private static Bitmap a(Context context, long j2) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriWithAppendedId = ContentUris.withAppendedId(i, j2);
        if (uriWithAppendedId != null) {
            try {
                parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uriWithAppendedId, "r");
            } catch (FileNotFoundException e2) {
                parcelFileDescriptorOpenFileDescriptor = null;
            } catch (Throwable th2) {
                parcelFileDescriptorOpenFileDescriptor = null;
                th = th2;
            }
            try {
                g.inJustDecodeBounds = true;
                if (parcelFileDescriptorOpenFileDescriptor != null && parcelFileDescriptorOpenFileDescriptor.getFileDescriptor() != null) {
                    BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, g);
                    g.inSampleSize = 1;
                    g.inJustDecodeBounds = false;
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, g);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (IOException e3) {
                        }
                    }
                } else if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (FileNotFoundException e5) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e6) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        }
        return bitmapDecodeFileDescriptor;
    }

    public static BitmapDrawable a(final Context context) {
        if (k == null) {
            agx.a().b(R.drawable.empty_cover_art_small, new agw() { // from class: afh.1
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    BitmapDrawable unused = afh.k = new BitmapDrawable(context.getResources(), bitmap);
                    afh.k.setFilterBitmap(false);
                    afh.k.setDither(false);
                }
            });
        }
        return k;
    }

    public static Bitmap a(Context context, long j2, long j3) {
        return a(context, j2, j3, false);
    }

    public static Bitmap a(Context context, long j2, long j3, boolean z) {
        Bitmap bitmapB;
        InputStream inputStreamOpenInputStream = null;
        if (j3 < 0) {
            if (j2 >= 0 && (bitmapB = b(context, j2, -1L)) != null) {
                return bitmapB;
            }
            if (z) {
                return b(context);
            }
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriWithAppendedId = ContentUris.withAppendedId(i, j3);
        try {
            if (uriWithAppendedId == null) {
                return null;
            }
            try {
                inputStreamOpenInputStream = contentResolver.openInputStream(uriWithAppendedId);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, h);
                if (inputStreamOpenInputStream == null) {
                    return bitmapDecodeStream;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return bitmapDecodeStream;
                } catch (IOException e2) {
                    return bitmapDecodeStream;
                }
            } catch (FileNotFoundException e3) {
                Bitmap bitmapB2 = b(context, j2, j3);
                if (bitmapB2 != null) {
                    if (bitmapB2.getConfig() == null && (bitmapB2 = bitmapB2.copy(Bitmap.Config.RGB_565, false)) == null && z) {
                        Bitmap bitmapB3 = b(context);
                        if (inputStreamOpenInputStream == null) {
                            return bitmapB3;
                        }
                        try {
                            inputStreamOpenInputStream.close();
                            return bitmapB3;
                        } catch (IOException e4) {
                            return bitmapB3;
                        }
                    }
                } else if (z) {
                    bitmapB2 = b(context);
                }
                if (inputStreamOpenInputStream == null) {
                    return bitmapB2;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return bitmapB2;
                } catch (IOException e5) {
                    return bitmapB2;
                }
            } catch (OutOfMemoryError e6) {
                e6.printStackTrace();
                Bitmap bitmapB4 = b(context);
                if (inputStreamOpenInputStream == null) {
                    return bitmapB4;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return bitmapB4;
                } catch (IOException e7) {
                    return bitmapB4;
                }
            }
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }

    public static Bitmap b(Context context, long j2, long j3) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        int iRound;
        Bitmap bitmapCopy;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2;
        int iRound2;
        int iRound3 = 1;
        if (j3 < 0 && j2 < 0) {
            throw new IllegalArgumentException("Must specify an album or a song id");
        }
        try {
            if (j3 < 0) {
                Uri uri = Uri.parse("content://media/external/audio/media/" + j2 + "/albumart");
                if (context == null || (parcelFileDescriptorOpenFileDescriptor2 = context.getContentResolver().openFileDescriptor(uri, "r")) == null) {
                    bitmapCopy = null;
                } else {
                    FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    options.inDither = false;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if ((options.outHeight > 50 || options.outWidth > 50) && (iRound3 = Math.round(options.outHeight / 50.0f)) >= (iRound2 = Math.round(options.outWidth / 50.0f))) {
                        iRound3 = iRound2;
                    }
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = iRound3;
                    bitmapCopy = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options).copy(Bitmap.Config.RGB_565, true);
                }
                return bitmapCopy;
            }
            Uri uriWithAppendedId = ContentUris.withAppendedId(i, j3);
            if (context == null || (parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uriWithAppendedId, "r")) == null) {
                return null;
            }
            FileDescriptor fileDescriptor2 = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inPurgeable = true;
            options2.inInputShareable = true;
            options2.inDither = false;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor2, null, options2);
            if ((options2.outHeight > 50 || options2.outWidth > 50) && (iRound3 = Math.round(options2.outHeight / 50.0f)) >= (iRound = Math.round(options2.outWidth / 50.0f))) {
                iRound3 = iRound;
            }
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = iRound3;
            return BitmapFactory.decodeFileDescriptor(fileDescriptor2, null, options2).copy(Bitmap.Config.RGB_565, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.empty_cover_art_small);
    }

    public static int a(String str, int i2) {
        if (str == null || "".equals(str.trim())) {
            return R.drawable.dashboard_default_genre;
        }
        if (str.toUpperCase().contains("Classical".toUpperCase())) {
            return R.drawable.dashboard_genre_classical;
        }
        if (str.toUpperCase().contains("Country".toUpperCase()) || str.toUpperCase().contains("folk".toUpperCase())) {
            return R.drawable.dashboard_genre_country;
        }
        if (str.toUpperCase().contains("Electronica".toUpperCase()) || str.toUpperCase().contains("Dance".toUpperCase()) || str.toUpperCase().contains("electronica/dance".toUpperCase())) {
            return R.drawable.dashboard_genre_electronica;
        }
        if (str.toUpperCase().contains("Hip Hop/Rap".toUpperCase()) || str.toUpperCase().contains("hip".toUpperCase()) || str.toUpperCase().contains("hop".toUpperCase()) || str.toUpperCase().contains("rap".toUpperCase()) || str.toUpperCase().contains("hop/rap".toUpperCase())) {
            return R.drawable.dashboard_genre_hiphop;
        }
        if (str.toUpperCase().contains("Jazz".toUpperCase()) || str.toUpperCase().contains("blues".toUpperCase())) {
            return R.drawable.dashboard_genre_jazz;
        }
        if (str.toUpperCase().contains("New Age".toUpperCase()) || str.toUpperCase().contains("world".toUpperCase())) {
            return R.drawable.dashboard_genre_newage;
        }
        if (str.toUpperCase().contains("Pop".toUpperCase())) {
            return R.drawable.dashboard_genre_pop;
        }
        if (str.toUpperCase().contains("R&B".toUpperCase().toUpperCase())) {
            return R.drawable.dashboard_genre_rb;
        }
        return str.toUpperCase().contains("rock".toUpperCase()) ? R.drawable.dashboard_genre_rock : R.drawable.dashboard_default_genre;
    }
}
