package com.bfrx;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import defpackage.lb;
import defpackage.lc;
import defpackage.mm;
import defpackage.mn;
import defpackage.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class MediaController {
    private static int count;
    static long lastPrintTime;
    private static long mPlayStartTime;
    private static lc mWorkerThread;
    public static boolean IS_FIRST_STOP_FOR_LINK = false;
    public static long autorecoveryFailTime = 0;
    private static Map<Long, Long> isRecoveryMap = new HashMap();
    private static AtomicReference<Runnable> latestStopPlayCommand = new AtomicReference<>();
    protected static long mHandle = 0;
    private static boolean mLoaded = false;
    private static MediaController mSelf = null;
    protected static boolean mInitailized = false;
    protected static int MINIMUM_MEMORY = 10;
    static Object mAppContext = null;
    private static boolean RETRY = true;
    protected static MediaItem mMedia = null;
    private static int mMediaPosition = -1;
    public static PlayStateHandler mControlHandler = null;
    private static PlaylistHandler mPlaylistHandler = null;
    protected static DeviceHandler m_deviceHandler = null;
    private static MeasurementHandler mMeasurementHandler = null;
    protected static NativeHandler mNativeHandler = null;
    protected static boolean mOverride = false;
    static final Object mWaitOnDevice = new Object();
    private static boolean mQueueing = false;
    private static long mplayTime = -1;
    private static long MINIMUMEVENTTIME = 1000;
    private static boolean mDiscontinuity = false;
    private static boolean mDisconnected = true;
    private static ArrayList<Long> mActiveDevices = new ArrayList<>();
    static boolean mStopping = false;
    static Object mWaitOnStop = new Object();
    private static boolean mbGPlaylistMode = false;
    private static boolean mbStop = false;
    private static Timer mPcmTimeout = null;
    private static long mLastPcmTime = 0;
    private static long mMaxPcmInterval = 300;
    private static long mBytesTransfered = 0;
    private static long mTotalGapTime = 0;
    private static long mGapCount = 0;
    private static long mTotalIntervalTime = 0;
    private static long mStartPlayTime = 0;
    private static long mTrackInitTime = 0;
    private static long mDeviceInitTime = 0;
    private static int mDeviceInitCount = 0;
    private static int mDevicePlayCount = 0;
    private static boolean mStatsEnabled = true;
    private static boolean mDataStatusShown = false;
    private static boolean mSilence = false;
    private static String MUSIC_PLAYER_THREAD = "MUSIC_PLAYER_THREAD";
    private static int MSG_ERROR_ONLINE_TIMEOUT = 3004;
    private static boolean isBlackfireRunInSeperateProcess = false;

    public interface DeviceHandler {
        void onDeviceDiscovered(Device device, boolean z);

        void onDeviceError(long j, int i, String str);

        void onDevicePlayStarted(long j);

        void onDeviceRecover(long j, Object obj);

        void onDeviceRecover(long j, String str);

        void onDeviceVolumeChange(long j, int i);

        void onFcError(int i);

        void onNetworkDisconnected();

        void onPrivateCommand(long j, byte[] bArr, byte[] bArr2);

        void onRemoveDevice(long j);

        void onVersionError(long j, int i, String str);
    }

    public enum GPlayMode {
        JOIN,
        LEAVE,
        TOGGLEPLAY,
        NEXT
    }

    public interface MeasurementHandler {
        void onDeviceInitialized(long j, long j2);

        void onDevicePlayStarted(long j, long j2);

        void onTrackInitialzed(long j);
    }

    public interface NativeHandler {
        String getOperatingInfo(long j);

        String getVersion(long j);

        long initialize(int i, String str, boolean z);

        boolean playFileResume(String str, String str2, String str3, long j);
    }

    public interface PlayStateHandler {
        boolean IsLoaded(boolean z);

        int LoadTrack(MediaItem mediaItem);

        void Play();

        void Stop();

        void Unload();

        void Update();

        void alert(String str, String str2);

        void onFinished();

        void onFinishedPlaying();

        void onMoveNext();

        void onPlayEnded(boolean z);

        void onPlayMediaSource(long j, String str, long j2);

        void onPlayStarted();

        void onPlayTime(long j);

        void onSourceError(int i, String str);

        void onSourcePlaying(MediaItem mediaItem);

        void onStartedPlaying(MediaItem mediaItem);

        void onStopped();

        void useLocalDevice(boolean z);
    }

    public interface PlaylistHandler {
        void onMoveNext();

        void onNetworkDisconnected();

        String onQueryAlbumArt(long j);

        MediaItem onQueryTrack(long j, int i);

        void onRemoveSource(long j, boolean z);

        void onRemoveTrack(long j, long j2, long j3);

        void onSourceAlbumArt(long j, String str);

        void onSourceQueued(MediaItem mediaItem, int i);
    }

    private static native void addMediaItem(long j, String str);

    private static native boolean addVirtualDevice(long j, long j2, long j3);

    private native boolean bind();

    private static native boolean changeAllVols(long j, int i);

    private native boolean deinit(long j);

    private static native boolean endSession(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int getActiveCount(long j);

    private static native int getActiveGroups(long j);

    private static native int getAvailableGroups(long j);

    private static native long getDelay(long j);

    private static native String getDeviceName(long j, long j2);

    private static native int getDeviceVolume(long j);

    private static native int getFirstAvailableGroup(long j);

    private static native String[] getGPlaylist(long j);

    private static native int getGlobalPlaylistSize(long j);

    private static native String getGroupName(long j, int i);

    private static native String getGroupNameForDevice(long j, long j2);

    private static native int getGroupVolume(long j, int i);

    private static native int getNextAvailableGroup(long j, int i);

    protected static native String getOperatingInfo(long j);

    protected static native String getVersion(long j);

    private native long init(int i, String str, boolean z);

    private static native boolean isDeviceActive(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isDeviceAvailable(long j, long j2);

    private static native void joinGPlayListGroup(long j);

    static native boolean joinGlobalSession(long j);

    private static native void leaveGPlayListGroup(long j);

    static native void leaveGlobalSession(long j);

    private static native void moveToNextListItem(long j);

    private static native boolean pause(long j);

    static native void pauseDeviceProbe(long j);

    private static native int pcmToFirecast(long j, byte[] bArr, int i);

    protected static native boolean playFileResume(long j, String str, String str2, String str3, long j2);

    private static native boolean playFileStart(long j, String str, String str2, String str3);

    private static native boolean playRemoteSource(long j, long j2, Object obj);

    private static native boolean probeDestinations(long j);

    static native boolean probeDevices(long j, int i);

    static native void probeGlobalSession(long j);

    private static native boolean queryPrivateData(long j, long j2, String str);

    private static native boolean queueTrack(long j, String str, String str2, String str3);

    private static native boolean removeActiveDevice(long j, long j2);

    private static native boolean removeActiveGroup(long j, int i);

    private static native boolean removeTrack(long j, long j2, String str);

    private static native boolean removeVirtualDevice(long j, long j2, long j3);

    static native boolean seek(long j, String str, String str2, String str3, long j2);

    private static native boolean sendCommand(long j, int i, long j2, long j3);

    private static native boolean sendIotCommand(long j, long j2, int i, int i2);

    private static native boolean sendPlaylistCommand(long j, long j2, String str);

    private static native boolean sendPrivateByteCommand(long j, long j2, byte[] bArr);

    private static native boolean sendPrivateCommand(long j, long j2, String str);

    private static native boolean sendSourcePrivateCommand(long j, int i, String str);

    private static native boolean setAbsoluteVolume(long j, long j2, int i);

    private static native boolean setActiveDevice(long j, long j2);

    private static native boolean setActiveGroup(long j, int i);

    private static native boolean setActiveGroups(long j, int i);

    private static native boolean setContinuousMode(long j, boolean z);

    private static native boolean setDelay(long j, int i);

    private static native boolean setDeviceSettings(long j, Device device);

    private static native boolean setLossless(long j, int i);

    private static native boolean setSessionFormat(long j, int i, int i2);

    private static native boolean setSourceIpAddress(long j, int i);

    private static native boolean setVolume(long j, int i);

    private static native boolean setVolumeById(long j, long j2, int i);

    private static native boolean startSession(long j);

    protected static native boolean stopPlaying(long j);

    private static native boolean toggleGroup(long j, int i);

    private static native void toggleStopPlay(long j, boolean z);

    private static native boolean volumeChangeAll(long j, int i);

    private static native boolean volumeChangeDevice(long j, long j2, int i);

    private static native boolean volumeDown(long j);

    private static native boolean volumeUp(long j);

    static /* synthetic */ int access$304() {
        int i = mDevicePlayCount + 1;
        mDevicePlayCount = i;
        return i;
    }

    static /* synthetic */ int access$604() {
        int i = mDeviceInitCount + 1;
        mDeviceInitCount = i;
        return i;
    }

    static {
        try {
            mm.b("java mobilecast loading shared libraries", new Object[0]);
            System.loadLibrary("avutil");
            System.loadLibrary("avresample");
            System.loadLibrary("avcodec");
            System.loadLibrary("avformat");
        } catch (UnsatisfiedLinkError e) {
            mm.b("loading shared libraries failed, Build.CPU_ABI=" + Build.CPU_ABI, new Object[0]);
        }
        count = 0;
    }

    public static boolean isIsBlackfireRunInSeperateProcess() {
        return isBlackfireRunInSeperateProcess;
    }

    public static void setIsBlackfireRunInSeperateProcess(boolean z) {
        isBlackfireRunInSeperateProcess = z;
    }

    public MediaController() {
        mMediaPosition = -1;
        mWorkerThread = new lc();
    }

    public static boolean isInitialized() {
        return mInitailized;
    }

    public static boolean isInitCalled() {
        return mHandle != 0;
    }

    public static boolean initialize(boolean z, String str) {
        mn.a();
        if (!mLoaded) {
            mSelf = new MediaController();
            if (mSelf == null) {
                throw new RuntimeException("self was set to null immediately");
            }
            mm.b("java loading MobileCast", new Object[0]);
            if (!lb.a((Context) mAppContext)) {
                throw new RuntimeException("Could not load mobile cast");
            }
            mLoaded = true;
        }
        if (!mInitailized || mHandle == 0) {
            mm.b("java initializing mobilecast, free memory=%MB", Long.valueOf(lb.a()));
            if (lb.a() < MINIMUM_MEMORY) {
                if (mControlHandler != null) {
                    mControlHandler.onSourceError(2, "Out of memory. Requires at least 5mb of free memory.");
                }
                throw new RuntimeException("Java initialize failed. Requires at least 5mb of free memory.");
            }
            if (mNativeHandler != null) {
                mSelf.bind();
                mHandle = mNativeHandler.initialize(0, str, z);
            }
            if (!mOverride) {
                mHandle = mSelf.init(0, str, z);
            }
            if (lb.a() < MINIMUM_MEMORY) {
                mm.b("Java initialize memory error. Requires at least 5mb of free memory.", new Object[0]);
                if (mControlHandler != null) {
                    mControlHandler.onSourceError(2, "Out of memory. Requires at least 5mb of free memory.");
                }
            }
        }
        return true;
    }

    public static boolean initialize(Object obj, boolean z) {
        return initialize(obj, z, "");
    }

    public static boolean initialize(Object obj, boolean z, String str) {
        mAppContext = obj;
        return initialize(z, str);
    }

    protected boolean doParentInit() {
        return false;
    }

    public static boolean deinitialize() {
        try {
            return mSelf.finish();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean setSourceIpAddress(int i) {
        if (mHandle == 0) {
            return false;
        }
        mm.b("java MediaController setSourceIpAddress ip=" + i, new Object[0]);
        return setSourceIpAddress(mHandle, i);
    }

    protected void finalize() {
        mm.b("java MediaController finalize called", new Object[0]);
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.1
            @Override // java.lang.Runnable
            public void run() {
                MediaController.this.finish();
            }
        });
    }

    protected boolean finish() {
        if (mHandle == 0) {
            return false;
        }
        mm.b("java MediaController finish called", new Object[0]);
        if (!deinit(mHandle)) {
            return false;
        }
        mInitailized = false;
        mHandle = 0L;
        return true;
    }

    public static MediaItem getMedia() {
        return mMedia;
    }

    public static boolean seek(MediaItem mediaItem, long j) {
        mm.b("java seek to %d", Long.valueOf((j / 1000) / 1000));
        if (mHandle == 0) {
            return false;
        }
        return seek(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist", j);
    }

    public static boolean setSessionFormat(int i, int i2) {
        if (mHandle == 0) {
            return false;
        }
        return setSessionFormat(mHandle, i, i2);
    }

    public static boolean startSession() {
        if (mHandle == 0) {
            return false;
        }
        if (lb.a() < MINIMUM_MEMORY) {
            mm.b("Java startSession memory error. Requires at least 5mb of free memory.", new Object[0]);
            if (mControlHandler == null) {
                return false;
            }
            mControlHandler.onSourceError(2, "Out of Memory. Requires at least 5mb of free memory.");
            return false;
        }
        if (mStopping) {
            return false;
        }
        return startSession(mHandle);
    }

    public static boolean endSession() {
        if (mHandle == 0) {
            return false;
        }
        mm.b("java endSession: ending session1", new Object[0]);
        if (!isInitialized() || mDiscontinuity) {
            return false;
        }
        mStartPlayTime = 0L;
        mStopping = true;
        mm.b("java endSession: ending session2", new Object[0]);
        if (lb.a() < MINIMUM_MEMORY) {
            mm.b("Java endSession memory error. Requires at least 5mb of free memory.", new Object[0]);
            if (mControlHandler != null) {
                mControlHandler.onSourceError(2, "Out of Memory. Requires at least 5mb of free memory.");
            }
        }
        mm.b("java endSession: ending session", new Object[0]);
        return endSession(mHandle);
    }

    public static boolean playRawPcm(final MediaItem mediaItem) {
        if (mediaItem == null || mediaItem.getUrl() == null) {
            return false;
        }
        if (lb.a() < MINIMUM_MEMORY) {
            mm.b("Java playRawPcm memory error. Requires at least 5mb of free memory.", new Object[0]);
            if (mControlHandler == null) {
                return false;
            }
            mControlHandler.onSourceError(2, "Out of Memory. Requires at least 5mb of free memory.");
            return false;
        }
        mStartPlayTime = 0L;
        mediaItem.setPlaying(true);
        mm.b("playRawPcm " + mediaItem.getUrl(), new Object[0]);
        if (mediaItem.getUrl().contains("48")) {
            setSessionFormat(48000, 16);
        }
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.2
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
            
                r0 = com.bfrx.MediaController.mStartPlayTime = 0;
                defpackage.mm.b("playRawPcm interrupted", new java.lang.Object[0]);
                r1.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
            
                r0.printStackTrace();
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r6 = this;
                    r0 = 1920(0x780, float:2.69E-42)
                    byte[] r0 = new byte[r0]
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L5a
                    com.bfrx.MediaItem r2 = r1     // Catch: java.io.FileNotFoundException -> L5a
                    java.lang.String r2 = r2.getUrl()     // Catch: java.io.FileNotFoundException -> L5a
                    r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L5a
                Lf:
                    int r2 = r1.read(r0)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    r3 = -1
                    if (r2 == r3) goto L7c
                L16:
                    int r3 = com.bfrx.MediaController.pcmToFirecast(r0, r2)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    if (r3 >= r2) goto Lf
                    com.bfrx.MediaItem r3 = r1     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    boolean r3 = r3.isPlaying()     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    if (r3 != 0) goto L64
                    r2 = 0
                    com.bfrx.MediaController.access$002(r2)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6f
                    java.lang.String r0 = "playRawPcm interrupted"
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6f
                    defpackage.mm.b(r0, r2)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6f
                    r1.close()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6f
                L34:
                    r1.close()     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L5f
                    java.lang.String r0 = "playRawPcm finished"
                    r1 = 0
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L5f
                    defpackage.mm.b(r0, r1)     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L5f
                L3f:
                    return
                L40:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    goto L34
                L45:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L6f
                    r1.close()     // Catch: java.io.IOException -> L55 java.io.FileNotFoundException -> L5a
                    java.lang.String r0 = "playRawPcm finished"
                    r1 = 0
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.io.IOException -> L55 java.io.FileNotFoundException -> L5a
                    defpackage.mm.b(r0, r1)     // Catch: java.io.IOException -> L55 java.io.FileNotFoundException -> L5a
                    goto L3f
                L55:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L5a
                    goto L3f
                L5a:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto L3f
                L5f:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L5a
                    goto L3f
                L64:
                    r4 = 1
                    java.lang.Thread.sleep(r4)     // Catch: java.io.IOException -> L45 java.lang.InterruptedException -> L6a java.lang.Throwable -> L6f
                    goto L16
                L6a:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L6f
                    goto L16
                L6f:
                    r0 = move-exception
                    r1.close()     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L8d
                    java.lang.String r1 = "playRawPcm finished"
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L8d
                    defpackage.mm.b(r1, r2)     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L8d
                L7b:
                    throw r0     // Catch: java.io.FileNotFoundException -> L5a
                L7c:
                    r1.close()     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L88
                    java.lang.String r0 = "playRawPcm finished"
                    r1 = 0
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L88
                    defpackage.mm.b(r0, r1)     // Catch: java.io.FileNotFoundException -> L5a java.io.IOException -> L88
                    goto L3f
                L88:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L5a
                    goto L3f
                L8d:
                    r1 = move-exception
                    r1.printStackTrace()     // Catch: java.io.FileNotFoundException -> L5a
                    goto L7b
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bfrx.MediaController.AnonymousClass2.run():void");
            }
        });
        return true;
    }

    public static boolean playFileResume(MediaItem mediaItem) {
        return playFileResume(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist", mediaItem.getId());
    }

    public static void play(final MediaItem mediaItem, final boolean z) {
        mm.b("MediaController play isResume=" + z, new Object[0]);
        latestStopPlayCommand.set(new Runnable() { // from class: com.bfrx.MediaController.3
            @Override // java.lang.Runnable
            public void run() {
                mm.b("MediaController play running begin isResume=" + z, new Object[0]);
                MediaController.playSync(mediaItem, z);
                mm.b("MediaController play running end isResume=" + z, new Object[0]);
            }
        });
        runNextTask(latestStopPlayCommand);
    }

    public static boolean playSync(MediaItem mediaItem, boolean z) {
        mm.a((Object) "fix buring ---");
        if (mediaItem != null && mediaItem.getUrl() != null) {
            mm.a((Object) "fix buring ---");
            mm.b("java starting play", new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            mDeviceInitCount = 0;
            mDevicePlayCount = 0;
            mStatsEnabled = true;
            synchronized (mWaitOnStop) {
                while (mStopping) {
                    try {
                        mWaitOnStop.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            mStartPlayTime = jCurrentTimeMillis;
            setDelay(1000);
            if (mControlHandler != null) {
                mControlHandler.useLocalDevice(false);
            }
            String url = mMedia == null ? "" : mMedia.getUrl();
            String url2 = mediaItem == null ? "" : mediaItem.getUrl();
            if (url == null || url2 == null) {
                url = mMedia == null ? "" : mMedia.getTitle();
                url2 = mediaItem == null ? "" : mediaItem.getTitle();
            }
            if (url == null) {
                url = "";
            }
            if (url2 == null) {
                url2 = "";
            }
            if ((url.compareTo(url2) != 0 || mDiscontinuity) && mediaItem.getUrl() == null) {
                if (mControlHandler == null) {
                    mm.a((Object) "fix buring ---");
                    return false;
                }
                mControlHandler.onStopped();
                mControlHandler.LoadTrack(mediaItem);
            }
            MediaItem mediaItem2 = mMedia;
            if (mediaItem2 != mediaItem && mediaItem2 != null) {
                mediaItem2.setPlaying(false);
            }
            mediaItem.setPlaying(true);
            mMedia = mediaItem;
            mm.b("java playing media source", new Object[0]);
            mDiscontinuity = true;
            mm.a((Object) mediaItem.getUrl());
            if (mediaItem.getUrl() == null || mediaItem.getUrl().length() == 0) {
                mm.a((Object) "fix buring ---");
                return false;
            }
            if (mMedia != null && z) {
                boolean zPlayFileResume = playFileResume(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist", mediaItem.getId());
                int i = 0;
                while (!zPlayFileResume && i < 3) {
                    int i2 = i + 1;
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    zPlayFileResume = playFileResume(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist", mediaItem.getId());
                    i = i2;
                }
            } else {
                mm.a((Object) "fix buring ---");
                boolean zPlayFileStart = playFileStart(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist");
                int i3 = 0;
                while (!zPlayFileStart && i3 < 3) {
                    i3++;
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    zPlayFileStart = playFileStart(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), "Unknown artist");
                }
            }
            mStartPlayTime = jCurrentTimeMillis;
            mTrackInitTime = System.currentTimeMillis() - jCurrentTimeMillis;
            if (mMeasurementHandler != null) {
                mMeasurementHandler.onTrackInitialzed(mTrackInitTime);
            }
            if (mediaItem2 != mediaItem && mediaItem2 != null) {
                mediaItem2.setPlaying(false);
            }
            mediaItem.setPlaying(true);
            return true;
        }
        return false;
    }

    public static boolean playRemoteItem(MediaItem mediaItem) {
        if (mHandle == 0) {
            return false;
        }
        return playRemoteSource(mHandle, mediaItem.getId(), mediaItem);
    }

    public static boolean queueItem(MediaItem mediaItem) {
        boolean zQueueTrack = false;
        if (mHandle != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (mMedia == null) {
                mMedia = mediaItem;
            }
            int globalPlaylistSize = getGlobalPlaylistSize(mHandle);
            if (globalPlaylistSize <= 0) {
                mDeviceInitCount = 0;
                mDevicePlayCount = 0;
                mStatsEnabled = true;
            }
            zQueueTrack = queueTrack(mHandle, mediaItem.getUrl(), mediaItem.getTitle(), mediaItem.getArtist());
            if (globalPlaylistSize <= 0) {
                mTrackInitTime = System.currentTimeMillis() - jCurrentTimeMillis;
                mStartPlayTime = jCurrentTimeMillis;
                if (mMeasurementHandler != null) {
                    mMeasurementHandler.onTrackInitialzed(mTrackInitTime);
                }
            }
        }
        return zQueueTrack;
    }

    public static MediaController getInstance() {
        return mSelf;
    }

    public static void stop() {
        mm.b("MediaController stop", new Object[0]);
        latestStopPlayCommand.set(new Runnable() { // from class: com.bfrx.MediaController.4
            @Override // java.lang.Runnable
            public void run() {
                mm.b("MediaController stop running begin", new Object[0]);
                MediaController.stopSync();
                mm.b("MediaController stop running end", new Object[0]);
            }
        });
        runNextTask(latestStopPlayCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean stopSync() {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        mDiscontinuity = false;
        mStopping = true;
        stopPlaying(mHandle);
        if (mMedia != null) {
            if (mMedia.getUrl() == null || mMedia.getUrl().isEmpty()) {
                endSession();
            }
            mMedia.setPlaying(false);
            mm.b("java stop(): media stopped", new Object[0]);
        }
        mStopping = false;
        mStartPlayTime = 0L;
        mm.b();
        return true;
    }

    private static void runNextTask(final AtomicReference<Runnable> atomicReference) {
        mq.a(MUSIC_PLAYER_THREAD).a(new Runnable() { // from class: com.bfrx.MediaController.5
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = (Runnable) atomicReference.getAndSet(null);
                if (runnable != null) {
                    runnable.run();
                    try {
                        Thread.sleep(200L);
                        return;
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                mm.b("Subsequently changed %s task, no need to run next task", new Object[0]);
            }
        });
    }

    public static void setHandler(PlayStateHandler playStateHandler) {
        mControlHandler = playStateHandler;
    }

    public static void setPlaylistHandler(PlaylistHandler playlistHandler) {
        mPlaylistHandler = playlistHandler;
    }

    public static void setDeviceHandler(DeviceHandler deviceHandler) {
        m_deviceHandler = deviceHandler;
    }

    public static void setMeasurementHandler(MeasurementHandler measurementHandler) {
        mMeasurementHandler = measurementHandler;
    }

    public static void setInitHandler(NativeHandler nativeHandler, boolean z) {
        mOverride = z;
        mNativeHandler = nativeHandler;
    }

    public static void addDeviceID(long j) {
        if (!mActiveDevices.contains(Long.valueOf(j))) {
            mPlayStartTime = System.currentTimeMillis();
            mActiveDevices.add(Long.valueOf(j));
        }
    }

    public static void removeDeviceID(long j) {
        if (mActiveDevices.contains(Long.valueOf(j))) {
            if (mDeviceInitCount > 0) {
                mDeviceInitCount--;
            }
            mActiveDevices.remove(Long.valueOf(j));
        }
    }

    public static void clearDeviceID() {
        mActiveDevices.clear();
    }

    public static boolean isGPlaylistMode() {
        return mbGPlaylistMode;
    }

    public static boolean joinGlobalSession() {
        if (mHandle == 0) {
            return false;
        }
        boolean zJoinGlobalSession = joinGlobalSession(mHandle);
        mbGPlaylistMode = zJoinGlobalSession;
        return zJoinGlobalSession;
    }

    public static void addMediaItem(String str) {
        addMediaItem(mHandle, str);
    }

    public static void leaveGlobalSession() {
        mDiscontinuity = false;
        mbGPlaylistMode = false;
        if (mHandle != 0) {
            leaveGlobalSession(mHandle);
        }
    }

    public static void probeGlobalSession() {
        if (mHandle != 0) {
            probeGlobalSession(mHandle);
        }
    }

    public static void onNativeMessage(Object obj, Object obj2) {
        mm.b();
        mm.b("java onNativeMessage:" + obj + " message:" + obj2, new Object[0]);
        if (mControlHandler != null) {
            mControlHandler.alert((String) obj, (String) obj2);
        }
        mm.b();
    }

    public static void onDeviceError(long j, int i, Object obj) {
        mm.a((Object) ("onDeviceError" + j + " " + i + " " + obj));
        if (m_deviceHandler != null) {
            m_deviceHandler.onDeviceError(j, i, (String) obj);
        }
        mm.b();
    }

    public static void onSourceError(int i, Object obj) {
        mm.a("onSourceError");
        if (mControlHandler != null && i == 3) {
            count++;
            if (count == 3) {
                mControlHandler.onSourceError(i, (String) obj);
                count = 0;
            }
        }
    }

    public static void onVersionError(long j, int i, Object obj) {
        if (m_deviceHandler != null) {
            m_deviceHandler.onVersionError(j, i, (String) obj);
        }
    }

    public static boolean onDeviceRecover(long j, Object obj) {
        if (m_deviceHandler != null) {
            mm.a((Object) ("auto-recovery onDeviceRecover ing deviceid:" + j));
            m_deviceHandler.onDeviceRecover(j, obj);
            return true;
        }
        return true;
    }

    public static void onDevicePlayStarted(final long j) {
        if (m_deviceHandler != null) {
            mm.a((Object) ("auto-recovery onDevicePlayStarted  end deviceid:" + j));
            m_deviceHandler.onDevicePlayStarted(j);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        mm.b("java onDevicePlayStarted:start time:" + (jCurrentTimeMillis - mStartPlayTime) + "ms id:" + j, new Object[0]);
        new Thread(new Runnable() { // from class: com.bfrx.MediaController.6
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.mMeasurementHandler != null) {
                    MediaController.mMeasurementHandler.onDevicePlayStarted(MediaController.access$304(), jCurrentTimeMillis - MediaController.mStartPlayTime);
                }
                if (MediaController.m_deviceHandler != null) {
                    MediaController.m_deviceHandler.onDevicePlayStarted(j);
                }
                if (MediaController.mHandle != 0 && MediaController.mDevicePlayCount >= MediaController.getActiveCount(MediaController.mHandle)) {
                    boolean unused = MediaController.mStatsEnabled = false;
                }
            }
        }).start();
    }

    public static void onDeviceInitialized(long j) {
        if (mStatsEnabled) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            new Thread(new Runnable() { // from class: com.bfrx.MediaController.7
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaController.mMeasurementHandler != null) {
                        MediaController.mMeasurementHandler.onDeviceInitialized(MediaController.access$604(), (jCurrentTimeMillis - MediaController.mStartPlayTime) - MediaController.mTrackInitTime);
                    }
                }
            }).start();
        }
    }

    public static void onDeviceVolumeChange(long j, int i, long j2, long j3) {
        mm.a((Object) ("onDeviceVolumeChange deviceid=" + Long.toHexString(j) + ",value=" + i + ", originator=" + Long.toHexString(j2) + ", phoneID=" + Long.toHexString(j3)));
        if ((j == j2 || j3 != j2) && m_deviceHandler != null) {
            m_deviceHandler.onDeviceVolumeChange(j, i);
        }
    }

    public static boolean queryPrivateData(long j, String str) {
        if (mHandle == 0) {
            return false;
        }
        return queryPrivateData(mHandle, j, str);
    }

    public boolean multicastQueryPrivateData(String str) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        boolean zQueryPrivateData = queryPrivateData(mHandle, 0L, str);
        mm.b();
        return zQueryPrivateData;
    }

    public boolean multicastSendPrivateCommand(byte[] bArr) {
        if (mHandle == 0) {
            return false;
        }
        return sendPrivateByteCommand(mHandle, 0L, bArr);
    }

    public static boolean sendPrivateCommand(long j, byte[] bArr) {
        if (mHandle == 0) {
            return false;
        }
        return sendPrivateByteCommand(mHandle, j, bArr);
    }

    public static boolean sendIotCommand(long j, int i, int i2) {
        if (mHandle == 0) {
            return false;
        }
        return sendIotCommand(mHandle, j, i, i2);
    }

    private static void onNewDevice(final Object obj) {
        mInitailized = true;
        mq.a().a(new Runnable() { // from class: com.bfrx.MediaController.8
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.m_deviceHandler != null) {
                    synchronized (MediaController.m_deviceHandler) {
                        MediaController.m_deviceHandler.onDeviceDiscovered((Device) obj, false);
                    }
                }
            }
        });
    }

    private static void onDeviceChanged(final Object obj) {
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.9
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.m_deviceHandler != null) {
                    synchronized (MediaController.m_deviceHandler) {
                        MediaController.m_deviceHandler.onDeviceDiscovered((Device) obj, true);
                    }
                }
            }
        });
    }

    private static void printCurrentWifiStatus(String str) {
        if (mAppContext != null) {
            mm.b("%s %s", str, ((WifiManager) ((Context) mAppContext).getSystemService("wifi")).getConnectionInfo());
        }
    }

    private static void onRemoveDevice(final long j) {
        mm.b();
        printCurrentWifiStatus("onRemoveDevice");
        removeDeviceID(j);
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.10
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.m_deviceHandler != null) {
                    synchronized (MediaController.m_deviceHandler) {
                        MediaController.m_deviceHandler.onRemoveDevice(j);
                    }
                }
            }
        });
        mm.b();
    }

    private static void onNetworkUp() {
    }

    private static void onNetworkDisconnected() {
        mDiscontinuity = false;
        mbGPlaylistMode = false;
        mm.b();
        mInitailized = false;
        if (m_deviceHandler != null) {
            m_deviceHandler.onNetworkDisconnected();
        }
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onNetworkDisconnected();
        }
        mm.b();
    }

    public static void onPrivateData(long j, byte[] bArr, byte[] bArr2) {
        mm.a((Object) ("never call this method:" + bArr + " properties:" + bArr2));
    }

    public static void onPrivateCommand(final long j, final byte[] bArr, final byte[] bArr2) {
        mm.a("onPrivateCommand content: %s", bArr2);
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.11
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.m_deviceHandler != null) {
                    MediaController.m_deviceHandler.onPrivateCommand(j, bArr, bArr2);
                }
            }
        });
    }

    public static void onPrivateData(long j, Object obj, Object obj2) {
        mm.b("java onPrivateData:" + obj + " properties:" + obj2, new Object[0]);
    }

    private static void onStartedPlaying() {
        mDiscontinuity = false;
        mInitailized = true;
        mm.b();
        if (mMedia != null) {
            mMedia.setPlaying(true);
            if (mControlHandler != null) {
                mControlHandler.onStartedPlaying(mMedia);
            }
        }
        mbStop = true;
    }

    private static void onPlayFinished() {
    }

    private static void onPlayPaused() {
    }

    public static boolean sendSourcePrivateCommand(int i, String str) {
        if (mHandle == 0) {
            return false;
        }
        return sendSourcePrivateCommand(mHandle, i, str);
    }

    private static void onSourceAvailable(long j, boolean z) {
        mm.b("onSourceAvailable ip=" + j, new Object[0]);
        Device device = new Device();
        device.uniqueID = j;
        device.isPlaying = z;
        device.isSource = true;
        if (m_deviceHandler != null) {
            m_deviceHandler.onDeviceDiscovered(device, true);
        }
    }

    private static void onSourceUnavailable(long j) {
        mm.b("onSourceUnavailable ip=" + j, new Object[0]);
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onRemoveSource(j, false);
        }
    }

    private static void onSourceChanged(long j, boolean z) {
        mm.b("onSourceAvailable ip=" + j, new Object[0]);
        Device device = new Device();
        device.uniqueID = j;
        device.isPlaying = z;
        device.isSource = true;
        if (m_deviceHandler != null) {
            m_deviceHandler.onDeviceDiscovered(device, true);
        }
    }

    private static void onSourceExitSession(long j, boolean z) {
        mm.b("onSourceExitSession ip=" + j, new Object[0]);
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onRemoveSource(j, z);
        }
    }

    private static void onSourcePlay(long j, Object obj) {
        mm.b("onSourcePlay ip=" + j + ": track= " + ((MediaItem) obj).getTitle(), new Object[0]);
        if (mControlHandler != null) {
            mControlHandler.onSourcePlaying((MediaItem) obj);
        }
    }

    private static void onSourcePlayStopped(long j) {
        mm.b("onSourcePlayStopped ip=" + j, new Object[0]);
        if (mControlHandler != null) {
            mControlHandler.onStopped();
        }
    }

    private static void onSourcePlayFinished(long j) {
        mm.b("onSourcePlayFinished ip=" + j, new Object[0]);
        if (mControlHandler != null) {
            mControlHandler.onFinished();
        }
    }

    private static void onPlayMediaSource(long j, Object obj, long j2, long j3) {
        mm.b("java onPlayMediaSource:source:=" + j + " url:" + ((String) obj) + " position:" + j2, new Object[0]);
        if (mControlHandler != null) {
            mControlHandler.onPlayMediaSource(j, (String) obj, j2);
        }
    }

    private static void onSourceQueued(long j, Object obj, int i) {
        mm.b("java onSourceQueued: " + ((MediaItem) obj).getTitle(), new Object[0]);
        ((MediaItem) obj).setPlaying(false);
        if (mMedia != null && mMedia.getUrl().equals(((MediaItem) obj).getUrl())) {
            ((MediaItem) obj).setArtist(mMedia.getArtist());
            if (mPlaylistHandler == null) {
                ((MediaItem) obj).setPlaying(false);
            }
        }
        while (mPlaylistHandler == null) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onSourceQueued((MediaItem) obj, i);
        }
    }

    private static void onRemoveTrack(long j, long j2, long j3) {
        mm.b("java onRemoveTrack: item " + j3, new Object[0]);
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onRemoveTrack(j, j2, j3);
        }
    }

    private static Object onQueryTrack(long j, int i) {
        if (mPlaylistHandler != null) {
            return mPlaylistHandler.onQueryTrack(j, i);
        }
        return null;
    }

    private static Object onQueryAlbumArt(long j) {
        if (mPlaylistHandler != null) {
            return mPlaylistHandler.onQueryAlbumArt(j);
        }
        return null;
    }

    private static void onSourceAlbumArt(long j, Object obj) {
        if (mPlaylistHandler != null) {
            mPlaylistHandler.onSourceAlbumArt(j, (String) obj);
        }
    }

    private static void onConnectionRecover() {
        mm.b("java onConnectionRecover", new Object[0]);
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.12
            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.mbGPlaylistMode) {
                    MediaController.mMedia.setPlaying(false);
                }
            }
        });
    }

    private static void onPlayStopped(int i) {
        if (!mDiscontinuity) {
            mStartPlayTime = 0L;
        }
        mStopping = false;
        mm.b("java onPlayStopped reason = " + i, new Object[0]);
        if (i == 0) {
            mm.a((Object) "stop by finished track");
            if (mControlHandler != null) {
                mControlHandler.onFinishedPlaying();
            }
            mm.b();
            return;
        }
        if (i == 1) {
            mm.a((Object) "stop by interrup");
            if (mControlHandler != null) {
                mControlHandler.onStopped();
                return;
            }
            return;
        }
        if (i == 2) {
            mm.a((Object) "stop by user call stop");
        }
    }

    public static String convertMillisToTimeString(long j) {
        return String.format(Locale.ENGLISH, "%01d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j))));
    }

    private static void onGetPlayTime(long j) {
        if (System.currentTimeMillis() - lastPrintTime > 10000) {
            mm.b("notifyPlayTime java onGetPlayTime: " + convertMillisToTimeString(j / 1000), new Object[0]);
            lastPrintTime = System.currentTimeMillis();
        }
        if (mControlHandler != null) {
            mControlHandler.onPlayTime(j);
        }
    }

    public static boolean restartFCS(boolean z) {
        return restartFCS(0, z);
    }

    public static boolean restartFCS(int i, boolean z) {
        mm.b();
        if (mSelf == null) {
            mm.b("java loading mobilecast", new Object[0]);
            mSelf = new MediaController();
            if (mSelf == null || !lb.a((Context) mAppContext)) {
                return false;
            }
        }
        if (mHandle == 0) {
            mHandle = mSelf.init(i, "", z);
            return false;
        }
        mm.b();
        return mHandle != 0;
    }

    public static boolean setLossless(int i) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        boolean lossless = setLossless(mHandle, i);
        mm.b();
        return lossless;
    }

    public static int getGroupVolume(int i) {
        if (mHandle == 0) {
            return -1;
        }
        return getGroupVolume(mHandle, i);
    }

    public static boolean volumeUp() {
        if (mHandle == 0) {
            return false;
        }
        return volumeChangeDevice(1);
    }

    public static boolean volumeDown() {
        if (mHandle == 0) {
            return false;
        }
        return volumeChangeDevice(-1);
    }

    public static boolean volumeUpAll() {
        if (mHandle == 0) {
            return false;
        }
        return volumeUp(mHandle);
    }

    public static boolean volumeDownAll() {
        if (mHandle == 0) {
            return false;
        }
        return volumeDown(mHandle);
    }

    public static boolean volumeUpDevice(long j) {
        if (mHandle == 0) {
            return false;
        }
        return volumeChangeDevice(mHandle, j, 5);
    }

    public static boolean volumeDownDevice(long j) {
        if (mHandle == 0) {
            return false;
        }
        return volumeChangeDevice(mHandle, j, -5);
    }

    public static boolean changeAllVols(int i) {
        if (mHandle == 0) {
            return false;
        }
        return changeAllVols(mHandle, i);
    }

    public static boolean setVolume(int i) {
        if (mHandle == 0) {
            return false;
        }
        mm.b("setVolume, value=%d, mHandle=%d", Integer.valueOf(i), Long.valueOf(mHandle));
        return setVolume(mHandle, i);
    }

    public static boolean setVolumeById(long j, int i) {
        mm.a((Object) (Long.toHexString(j) + " value"));
        if (mHandle == 0) {
            return false;
        }
        mm.b("setVolume, value=%d, mHandle=%l,deviceid=%l", Integer.valueOf(i), Long.valueOf(mHandle), Long.valueOf(j));
        return setVolumeById(mHandle, j, i);
    }

    public static boolean sendCommand(int i, long j, long j2) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        boolean zSendCommand = sendCommand(mHandle, i, j, j2);
        mm.b();
        return zSendCommand;
    }

    public static int getDeviceVolume() {
        if (mHandle == 0) {
            return -1;
        }
        return getDeviceVolume(mHandle);
    }

    public static boolean volumeChangeDevice(int i) {
        if (mHandle == 0) {
            return false;
        }
        if (mActiveDevices.size() <= 0) {
            volumeChangeAll(mHandle, i);
        }
        boolean z = false;
        for (int i2 = 0; i2 < mActiveDevices.size(); i2++) {
            boolean zVolumeChangeDevice = volumeChangeDevice(mHandle, mActiveDevices.get(i2).longValue(), i);
            if (!zVolumeChangeDevice) {
                z = zVolumeChangeDevice;
            }
        }
        return z;
    }

    public static boolean setAbsoluteVolume(long j, int i) {
        if (mHandle == 0) {
            return false;
        }
        return setAbsoluteVolume(mHandle, j, i);
    }

    public static int getActiveGroups() {
        if (mHandle == 0) {
            return 0;
        }
        return getActiveGroups(mHandle);
    }

    public static boolean setActiveGroups(int i) {
        if (mHandle == 0) {
            return false;
        }
        return setActiveGroups(mHandle, i);
    }

    public static boolean toggleGroup(int i) {
        if (mHandle == 0) {
            return false;
        }
        return toggleGroup(mHandle, i);
    }

    public static boolean setActiveGroup(int i) {
        if (mHandle == 0) {
            return false;
        }
        return setActiveGroup(mHandle, i);
    }

    public static boolean removeActiveGroup(int i) {
        if (mHandle == 0) {
            return false;
        }
        return removeActiveGroup(mHandle, i);
    }

    public static boolean setActiveDevice(long j) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        mm.a((Object) (j + ""));
        addDeviceID(j);
        mStatsEnabled = false;
        boolean activeDevice = setActiveDevice(mHandle, j);
        mm.a((Object) ("setActiveDevice ret=" + activeDevice + "  " + j));
        return activeDevice;
    }

    public static boolean addVirtualDevice(long j, long j2) {
        if (mHandle == 0) {
            return false;
        }
        return addVirtualDevice(mHandle, j, j2);
    }

    public static boolean removeActiveDevice(long j) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        mm.a((Object) (j + ""));
        removeDeviceID(j);
        boolean zRemoveActiveDevice = removeActiveDevice(mHandle, j);
        mm.b();
        return zRemoveActiveDevice;
    }

    public static boolean removeVirtualDevice(long j, long j2) {
        if (mHandle == 0) {
            return false;
        }
        return removeVirtualDevice(mHandle, j, j2);
    }

    public static boolean isDeviceIdActive(long j) {
        mm.b();
        if (mHandle == 0) {
            return false;
        }
        boolean zIsDeviceActive = isDeviceActive(mHandle, j);
        mm.b();
        return zIsDeviceActive;
    }

    public static int getActiveCount() {
        if (mHandle == 0) {
            return 0;
        }
        return getActiveCount(mHandle);
    }

    public static boolean isDeviceIdAvailable(final long j) {
        if (mHandle == 0) {
            return false;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        mq.b().execute(new Runnable() { // from class: com.bfrx.MediaController.13
            @Override // java.lang.Runnable
            public void run() {
                atomicBoolean.set(MediaController.isDeviceAvailable(MediaController.mHandle, j));
                synchronized (MediaController.mWaitOnDevice) {
                    MediaController.mWaitOnDevice.notify();
                }
            }
        });
        synchronized (mWaitOnDevice) {
            try {
                mWaitOnDevice.wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean z = atomicBoolean.get();
        mm.b();
        return z;
    }

    public static boolean setDeviceSettings(Device device) {
        mm.b();
        if (mHandle == 0) {
            mm.b("CLLOG WIFISETUP handle 0", new Object[0]);
            return false;
        }
        boolean deviceSettings = setDeviceSettings(mHandle, device);
        mm.b("CLLOG WIFISETUP setDeviceSettings %s, role %s,device %s, name %s, groupId %s, roomId %s, icon %s, ssid %s, key %s, hashCode %d", Boolean.valueOf(deviceSettings), Integer.valueOf(device.getRole()), Long.valueOf(device.uniqueID), device.getMkGroupName(), Integer.valueOf(device.getMkGroupId()), Integer.valueOf(device.getMkRoomId()), Integer.valueOf(device.getMkIconIndex()), device.ssid, device.key, Integer.valueOf(device.hashCode()));
        mm.b();
        return deviceSettings;
    }

    public static int getAvailableGroups() {
        if (mHandle == 0) {
            return 0;
        }
        return getAvailableGroups(mHandle);
    }

    public static int getFirstAvailableGroup() {
        if (mHandle == 0) {
            return 0;
        }
        return getFirstAvailableGroup(mHandle);
    }

    public static String getGroupName(int i) {
        if (mHandle == 0) {
            return null;
        }
        return getGroupName(mHandle, i);
    }

    public static String getGroupNameForDevice(long j) {
        if (mHandle == 0) {
            return null;
        }
        return getGroupNameForDevice(mHandle, j);
    }

    public static String getDeviceName(long j) {
        if (mHandle == 0) {
            return null;
        }
        return getDeviceName(mHandle, j);
    }

    public static boolean probeDestinations() {
        if (mHandle == 0) {
            return false;
        }
        return probeDestinations(mHandle);
    }

    public static String getVersion() {
        if (mHandle == 0) {
            return null;
        }
        if (mNativeHandler != null) {
            return mNativeHandler.getVersion(mHandle);
        }
        return getVersion(mHandle);
    }

    public static void onMediaSourceErr() {
        mm.b();
        m_deviceHandler.onFcError(MSG_ERROR_ONLINE_TIMEOUT);
        mm.b();
    }

    public static String getInfoStats() {
        if (mHandle == 0) {
            return null;
        }
        if (mNativeHandler != null) {
            return mNativeHandler.getOperatingInfo(mHandle);
        }
        return getOperatingInfo(mHandle);
    }

    public static boolean probeDevices(int i) {
        mm.c("probeDevices group=%d, mHandle=%l", Integer.valueOf(i), Long.valueOf(mHandle));
        if (mHandle == 0) {
            return false;
        }
        boolean zProbeDevices = probeDevices(mHandle, i);
        mm.c("probeDevices ret=%b", Boolean.valueOf(zProbeDevices));
        return zProbeDevices;
    }

    public static void pauseDeviceProbe() {
        mm.b();
        if (mHandle != 0) {
            pauseDeviceProbe(mHandle);
            mm.b();
        }
    }

    public static boolean setDelay(int i) {
        if (mHandle == 0) {
            return false;
        }
        return setDelay(mHandle, i);
    }

    public static long getDelay() {
        if (mHandle == 0) {
            return -1L;
        }
        return getDelay(mHandle);
    }

    public static boolean setContinuousMode(boolean z) {
        if (mHandle == 0) {
            return false;
        }
        return setContinuousMode(mHandle, z);
    }

    public static boolean setSessionTimeout(int i) {
        if (i > 300) {
            return false;
        }
        mMaxPcmInterval = i;
        return true;
    }

    static class PcmTimer extends TimerTask {
        PcmTimer() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MediaController.mLastPcmTime > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - MediaController.mLastPcmTime;
                if (jCurrentTimeMillis > MediaController.mMaxPcmInterval) {
                    mm.b("PcmTimer timed out with " + jCurrentTimeMillis + "ms", new Object[0]);
                    cancel();
                    if (MediaController.mMedia != null) {
                        MediaController.endSession();
                    } else {
                        MediaController.stop();
                    }
                }
            }
        }
    }

    public static int pcmToFirecast(byte[] bArr, int i) {
        if (mHandle == 0) {
            mm.b("java pcmToFirecast mobilecast not initialized", new Object[0]);
            return -1;
        }
        if (mStopping && !mDiscontinuity) {
            return -1;
        }
        if ((mStartPlayTime <= 0 && !mbStop) || (mDiscontinuity && !mStopping && mbStop)) {
            mBytesTransfered = 0L;
            mTotalGapTime = 0L;
            mGapCount = 0L;
            mTotalIntervalTime = 0L;
            mStartPlayTime = System.currentTimeMillis();
            if (mMedia != null) {
                if (mDeviceInitCount != 0 && mLastPcmTime != 0) {
                    return -1;
                }
                setDelay(1000);
                setContinuousMode(false);
            } else {
                mPcmTimeout = new Timer();
                mPcmTimeout.scheduleAtFixedRate(new PcmTimer(), 200L, 100L);
            }
            mm.b("java pcmToFirecast starting session", new Object[0]);
            if (!startSession()) {
                mm.b("java pcmToFirecast failed to start session", new Object[0]);
                mStopping = true;
                stopPlaying(mHandle);
                mLastPcmTime = 0L;
                if (!mbStop) {
                    return -1;
                }
                mStartPlayTime = 0L;
                return -1;
            }
            mDiscontinuity = false;
        }
        if (mLastPcmTime > 0) {
            mBytesTransfered += (long) i;
            long jCurrentTimeMillis = System.currentTimeMillis() - mLastPcmTime;
            mTotalIntervalTime += jCurrentTimeMillis;
            if (mTotalIntervalTime >= 1000) {
                mBytesTransfered = 0L;
                mTotalGapTime = 0L;
                mGapCount = 0L;
                mTotalIntervalTime = 0L;
            }
            if (jCurrentTimeMillis > 20) {
                mGapCount++;
                mTotalGapTime += jCurrentTimeMillis;
            }
            if (jCurrentTimeMillis > 500) {
                mm.b("java pcmToFirecast() gap=" + jCurrentTimeMillis + " >20ms gapcount=" + mGapCount, new Object[0]);
            }
        }
        mLastPcmTime = System.currentTimeMillis();
        return pcmToFirecast(mHandle, bArr, i);
    }
}
