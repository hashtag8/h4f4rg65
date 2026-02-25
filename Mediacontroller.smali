.class public Lcom/bfrx/MediaController;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bfrx/MediaController$PcmTimer;,
        Lcom/bfrx/MediaController$GPlayMode;,
        Lcom/bfrx/MediaController$NativeHandler;,
        Lcom/bfrx/MediaController$MeasurementHandler;,
        Lcom/bfrx/MediaController$DeviceHandler;,
        Lcom/bfrx/MediaController$PlaylistHandler;,
        Lcom/bfrx/MediaController$PlayStateHandler;
    }
.end annotation


# static fields
.field public static IS_FIRST_STOP_FOR_LINK:Z

.field private static MINIMUMEVENTTIME:J

.field protected static MINIMUM_MEMORY:I

.field private static MSG_ERROR_ONLINE_TIMEOUT:I

.field private static MUSIC_PLAYER_THREAD:Ljava/lang/String;

.field private static RETRY:Z

.field public static autorecoveryFailTime:J

.field private static count:I

.field private static isBlackfireRunInSeperateProcess:Z

.field private static isRecoveryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field static lastPrintTime:J

.field private static latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private static mActiveDevices:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field static mAppContext:Ljava/lang/Object;

.field private static mBytesTransfered:J

.field public static mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

.field private static mDataStatusShown:Z

.field private static mDeviceInitCount:I

.field private static mDeviceInitTime:J

.field private static mDevicePlayCount:I

.field private static mDisconnected:Z

.field private static mDiscontinuity:Z

.field private static mGapCount:J

.field protected static mHandle:J

.field protected static mInitailized:Z

.field private static mLastPcmTime:J

.field private static mLoaded:Z

.field private static mMaxPcmInterval:J

.field private static mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

.field protected static mMedia:Lcom/bfrx/MediaItem;

.field private static mMediaPosition:I

.field protected static mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

.field protected static mOverride:Z

.field private static mPcmTimeout:Ljava/util/Timer;

.field private static mPlayStartTime:J

.field private static mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

.field private static mQueueing:Z

.field private static mSelf:Lcom/bfrx/MediaController;

.field private static mSilence:Z

.field private static mStartPlayTime:J

.field private static mStatsEnabled:Z

.field static mStopping:Z

.field private static mTotalGapTime:J

.field private static mTotalIntervalTime:J

.field private static mTrackInitTime:J

.field static final mWaitOnDevice:Ljava/lang/Object;

.field static mWaitOnStop:Ljava/lang/Object;

.field private static mWorkerThread:Llc;

.field protected static m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

.field private static mbGPlaylistMode:Z

.field private static mbStop:Z

.field private static mplayTime:J


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v6, 0x1

    const/4 v3, 0x0

    const-wide/16 v4, 0x0

    const/4 v2, 0x0

    .line 52
    sput-boolean v2, Lcom/bfrx/MediaController;->IS_FIRST_STOP_FOR_LINK:Z

    .line 53
    sput-wide v4, Lcom/bfrx/MediaController;->autorecoveryFailTime:J

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->isRecoveryMap:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;

    .line 211
    sput-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    .line 212
    sput-boolean v2, Lcom/bfrx/MediaController;->mLoaded:Z

    .line 213
    sput-object v3, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    .line 214
    sput-boolean v2, Lcom/bfrx/MediaController;->mInitailized:Z

    .line 215
    const/16 v0, 0xa

    sput v0, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    .line 216
    sput-object v3, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    .line 217
    sput-boolean v6, Lcom/bfrx/MediaController;->RETRY:Z

    .line 219
    sput-object v3, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    .line 220
    const/4 v0, -0x1

    sput v0, Lcom/bfrx/MediaController;->mMediaPosition:I

    .line 221
    sput-object v3, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    .line 222
    sput-object v3, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    .line 223
    sput-object v3, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    .line 224
    sput-object v3, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    .line 225
    sput-object v3, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    .line 226
    sput-boolean v2, Lcom/bfrx/MediaController;->mOverride:Z

    .line 227
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mWaitOnDevice:Ljava/lang/Object;

    .line 228
    sput-boolean v2, Lcom/bfrx/MediaController;->mQueueing:Z

    .line 229
    const-wide/16 v0, -0x1

    sput-wide v0, Lcom/bfrx/MediaController;->mplayTime:J

    .line 230
    const-wide/16 v0, 0x3e8

    sput-wide v0, Lcom/bfrx/MediaController;->MINIMUMEVENTTIME:J

    .line 231
    sput-boolean v2, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 232
    sput-boolean v6, Lcom/bfrx/MediaController;->mDisconnected:Z

    .line 235
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    .line 236
    sput-boolean v2, Lcom/bfrx/MediaController;->mStopping:Z

    .line 237
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mWaitOnStop:Ljava/lang/Object;

    .line 238
    sput-boolean v2, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    .line 239
    sput-boolean v2, Lcom/bfrx/MediaController;->mbStop:Z

    .line 240
    sput-object v3, Lcom/bfrx/MediaController;->mPcmTimeout:Ljava/util/Timer;

    .line 241
    sput-wide v4, Lcom/bfrx/MediaController;->mLastPcmTime:J

    .line 242
    const-wide/16 v0, 0x12c

    sput-wide v0, Lcom/bfrx/MediaController;->mMaxPcmInterval:J

    .line 243
    sput-wide v4, Lcom/bfrx/MediaController;->mBytesTransfered:J

    .line 244
    sput-wide v4, Lcom/bfrx/MediaController;->mTotalGapTime:J

    .line 245
    sput-wide v4, Lcom/bfrx/MediaController;->mGapCount:J

    .line 246
    sput-wide v4, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    .line 247
    sput-wide v4, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 248
    sput-wide v4, Lcom/bfrx/MediaController;->mTrackInitTime:J

    .line 249
    sput-wide v4, Lcom/bfrx/MediaController;->mDeviceInitTime:J

    .line 250
    sput v2, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    .line 251
    sput v2, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    .line 252
    sput-boolean v6, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    .line 253
    sput-boolean v2, Lcom/bfrx/MediaController;->mDataStatusShown:Z

    .line 254
    sput-boolean v2, Lcom/bfrx/MediaController;->mSilence:Z

    .line 256
    const-string v0, "MUSIC_PLAYER_THREAD"

    sput-object v0, Lcom/bfrx/MediaController;->MUSIC_PLAYER_THREAD:Ljava/lang/String;

    .line 257
    const/16 v0, 0xbbc

    sput v0, Lcom/bfrx/MediaController;->MSG_ERROR_ONLINE_TIMEOUT:I

    .line 258
    sput-boolean v2, Lcom/bfrx/MediaController;->isBlackfireRunInSeperateProcess:Z

    .line 270
    :try_start_8b
    const-string v0, "java mobilecast loading shared libraries"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 273
    const-string v0, "avutil"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 274
    const-string v0, "avresample"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 275
    const-string v0, "avcodec"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 276
    const-string v0, "avformat"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_a7
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_8b .. :try_end_a7} :catch_aa

    .line 910
    :goto_a7
    sput v2, Lcom/bfrx/MediaController;->count:I

    return-void

    .line 279
    :catch_aa
    move-exception v0

    .line 280
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "loading shared libraries failed, Build.CPU_ABI="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    goto :goto_a7
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 288
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 295
    const/4 v0, -0x1

    sput v0, Lcom/bfrx/MediaController;->mMediaPosition:I

    .line 296
    new-instance v0, Llc;

    invoke-direct {v0}, Llc;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mWorkerThread:Llc;

    .line 298
    return-void
.end method

.method static synthetic access$000()J
    .registers 2

    .prologue
    .line 51
    sget-wide v0, Lcom/bfrx/MediaController;->mStartPlayTime:J

    return-wide v0
.end method

.method static synthetic access$002(J)J
    .registers 2

    .prologue
    .line 51
    sput-wide p0, Lcom/bfrx/MediaController;->mStartPlayTime:J

    return-wide p0
.end method

.method static synthetic access$100()Z
    .registers 1

    .prologue
    .line 51
    invoke-static {}, Lcom/bfrx/MediaController;->stopSync()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000()J
    .registers 2

    .prologue
    .line 51
    sget-wide v0, Lcom/bfrx/MediaController;->mLastPcmTime:J

    return-wide v0
.end method

.method static synthetic access$1100()J
    .registers 2

    .prologue
    .line 51
    sget-wide v0, Lcom/bfrx/MediaController;->mMaxPcmInterval:J

    return-wide v0
.end method

.method static synthetic access$200()Lcom/bfrx/MediaController$MeasurementHandler;
    .registers 1

    .prologue
    .line 51
    sget-object v0, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    return-object v0
.end method

.method static synthetic access$300()I
    .registers 1

    .prologue
    .line 51
    sget v0, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    return v0
.end method

.method static synthetic access$304()I
    .registers 1

    .prologue
    .line 51
    sget v0, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    return v0
.end method

.method static synthetic access$400(J)I
    .registers 4

    .prologue
    .line 51
    invoke-static {p0, p1}, Lcom/bfrx/MediaController;->getActiveCount(J)I

    move-result v0

    return v0
.end method

.method static synthetic access$502(Z)Z
    .registers 1

    .prologue
    .line 51
    sput-boolean p0, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    return p0
.end method

.method static synthetic access$604()I
    .registers 1

    .prologue
    .line 51
    sget v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    return v0
.end method

.method static synthetic access$700()J
    .registers 2

    .prologue
    .line 51
    sget-wide v0, Lcom/bfrx/MediaController;->mTrackInitTime:J

    return-wide v0
.end method

.method static synthetic access$800()Z
    .registers 1

    .prologue
    .line 51
    sget-boolean v0, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    return v0
.end method

.method static synthetic access$900(JJ)Z
    .registers 6

    .prologue
    .line 51
    invoke-static {p0, p1, p2, p3}, Lcom/bfrx/MediaController;->isDeviceAvailable(JJ)Z

    move-result v0

    return v0
.end method

.method public static addDeviceID(J)V
    .registers 4

    .prologue
    .line 817
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1b

    .line 818
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->mPlayStartTime:J

    .line 819
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 821
    :cond_1b
    return-void
.end method

.method private static native addMediaItem(JLjava/lang/String;)V
.end method

.method public static addMediaItem(Ljava/lang/String;)V
    .registers 3

    .prologue
    .line 861
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->addMediaItem(JLjava/lang/String;)V

    .line 862
    return-void
.end method

.method public static addVirtualDevice(JJ)Z
    .registers 10

    .prologue
    .line 1720
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1721
    const/4 v0, 0x0

    .line 1722
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    move-wide v2, p0

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/bfrx/MediaController;->addVirtualDevice(JJJ)Z

    move-result v0

    goto :goto_9
.end method

.method private static native addVirtualDevice(JJJ)Z
.end method

.method private native bind()Z
.end method

.method public static changeAllVols(I)Z
    .registers 5

    .prologue
    .line 1551
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1552
    const/4 v0, 0x0

    .line 1553
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->changeAllVols(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native changeAllVols(JI)Z
.end method

.method public static clearDeviceID()V
    .registers 1

    .prologue
    .line 839
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 840
    return-void
.end method

.method public static convertMillisToTimeString(J)Ljava/lang/String;
    .registers 12

    .prologue
    .line 1404
    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    const-string v1, "%01d:%02d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 1405
    invoke-virtual {v4, p0, p1}, Ljava/util/concurrent/TimeUnit;->toMinutes(J)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 1406
    invoke-virtual {v4, p0, p1}, Ljava/util/concurrent/TimeUnit;->toSeconds(J)J

    move-result-wide v4

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    sget-object v7, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v7, p0, p1}, Ljava/util/concurrent/TimeUnit;->toMinutes(J)J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/util/concurrent/TimeUnit;->toSeconds(J)J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    .line 1404
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1408
    return-object v0
.end method

.method private native deinit(J)Z
.end method

.method public static deinitialize()Z
    .registers 1

    .prologue
    .line 386
    :try_start_0
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    invoke-virtual {v0}, Lcom/bfrx/MediaController;->finish()Z
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_5} :catch_7

    move-result v0

    .line 390
    :goto_6
    return v0

    .line 387
    :catch_7
    move-exception v0

    .line 388
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 390
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public static endSession()Z
    .registers 6

    .prologue
    const-wide/16 v4, 0x0

    const/4 v0, 0x0

    .line 466
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 483
    :cond_9
    :goto_9
    return v0

    .line 468
    :cond_a
    const-string v1, "java endSession: ending session1"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 469
    invoke-static {}, Lcom/bfrx/MediaController;->isInitialized()Z

    move-result v1

    if-eqz v1, :cond_9

    .line 471
    sget-boolean v1, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    if-nez v1, :cond_9

    .line 474
    sput-wide v4, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 475
    const/4 v1, 0x1

    sput-boolean v1, Lcom/bfrx/MediaController;->mStopping:Z

    .line 476
    const-string v1, "java endSession: ending session2"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 477
    invoke-static {}, Llb;->a()J

    move-result-wide v2

    sget v1, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    int-to-long v4, v1

    cmp-long v1, v2, v4

    if-gez v1, :cond_45

    .line 478
    const-string v1, "Java endSession memory error. Requires at least 5mb of free memory."

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 479
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v1, :cond_45

    .line 480
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    const/4 v2, 0x2

    const-string v3, "Out of Memory. Requires at least 5mb of free memory."

    invoke-interface {v1, v2, v3}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    .line 482
    :cond_45
    const-string v1, "java endSession: ending session"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 483
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->endSession(J)Z

    move-result v0

    goto :goto_9
.end method

.method private static native endSession(J)Z
.end method

.method public static getActiveCount()I
    .registers 4

    .prologue
    .line 1759
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1760
    const/4 v0, 0x0

    .line 1761
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getActiveCount(J)I

    move-result v0

    goto :goto_9
.end method

.method private static native getActiveCount(J)I
.end method

.method public static getActiveGroups()I
    .registers 4

    .prologue
    .line 1619
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1620
    const/4 v0, 0x0

    .line 1621
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getActiveGroups(J)I

    move-result v0

    goto :goto_9
.end method

.method private static native getActiveGroups(J)I
.end method

.method public static getAvailableGroups()I
    .registers 4

    .prologue
    .line 1819
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1820
    const/4 v0, 0x0

    .line 1821
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getAvailableGroups(J)I

    move-result v0

    goto :goto_9
.end method

.method private static native getAvailableGroups(J)I
.end method

.method public static getDelay()J
    .registers 4

    .prologue
    .line 1922
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_b

    .line 1923
    const-wide/16 v0, -0x1

    .line 1924
    :goto_a
    return-wide v0

    :cond_b
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getDelay(J)J

    move-result-wide v0

    goto :goto_a
.end method

.method private static native getDelay(J)J
.end method

.method public static getDeviceName(J)Ljava/lang/String;
    .registers 6

    .prologue
    .line 1862
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1863
    const/4 v0, 0x0

    .line 1864
    :goto_9
    return-object v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->getDeviceName(JJ)Ljava/lang/String;

    move-result-object v0

    goto :goto_9
.end method

.method private static native getDeviceName(JJ)Ljava/lang/String;
.end method

.method public static getDeviceVolume()I
    .registers 4

    .prologue
    .line 1581
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1582
    const/4 v0, -0x1

    .line 1583
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getDeviceVolume(J)I

    move-result v0

    goto :goto_9
.end method

.method private static native getDeviceVolume(J)I
.end method

.method public static getFirstAvailableGroup()I
    .registers 4

    .prologue
    .line 1829
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1830
    const/4 v0, 0x0

    .line 1831
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getFirstAvailableGroup(J)I

    move-result v0

    goto :goto_9
.end method

.method private static native getFirstAvailableGroup(J)I
.end method

.method private static native getGPlaylist(J)[Ljava/lang/String;
.end method

.method private static native getGlobalPlaylistSize(J)I
.end method

.method public static getGroupName(I)Ljava/lang/String;
    .registers 5

    .prologue
    .line 1840
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1841
    const/4 v0, 0x0

    .line 1842
    :goto_9
    return-object v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->getGroupName(JI)Ljava/lang/String;

    move-result-object v0

    goto :goto_9
.end method

.method private static native getGroupName(JI)Ljava/lang/String;
.end method

.method public static getGroupNameForDevice(J)Ljava/lang/String;
    .registers 6

    .prologue
    .line 1851
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1852
    const/4 v0, 0x0

    .line 1853
    :goto_9
    return-object v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->getGroupNameForDevice(JJ)Ljava/lang/String;

    move-result-object v0

    goto :goto_9
.end method

.method private static native getGroupNameForDevice(JJ)Ljava/lang/String;
.end method

.method public static getGroupVolume(I)I
    .registers 5

    .prologue
    .line 1481
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1482
    const/4 v0, -0x1

    .line 1483
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->getGroupVolume(JI)I

    move-result v0

    goto :goto_9
.end method

.method private static native getGroupVolume(JI)I
.end method

.method public static getInfoStats()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1889
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1890
    const/4 v0, 0x0

    .line 1894
    :goto_9
    return-object v0

    .line 1891
    :cond_a
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    if-eqz v0, :cond_17

    .line 1892
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-interface {v0, v2, v3}, Lcom/bfrx/MediaController$NativeHandler;->getOperatingInfo(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_9

    .line 1894
    :cond_17
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getOperatingInfo(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_9
.end method

.method public static getInstance()Lcom/bfrx/MediaController;
    .registers 1

    .prologue
    .line 726
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    return-object v0
.end method

.method public static getMedia()Lcom/bfrx/MediaItem;
    .registers 1

    .prologue
    .line 426
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    return-object v0
.end method

.method private static native getNextAvailableGroup(JI)I
.end method

.method protected static native getOperatingInfo(J)Ljava/lang/String;
.end method

.method public static getVersion()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1874
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1875
    const/4 v0, 0x0

    .line 1879
    :goto_9
    return-object v0

    .line 1876
    :cond_a
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    if-eqz v0, :cond_17

    .line 1877
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-interface {v0, v2, v3}, Lcom/bfrx/MediaController$NativeHandler;->getVersion(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_9

    .line 1879
    :cond_17
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->getVersion(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_9
.end method

.method protected static native getVersion(J)Ljava/lang/String;
.end method

.method private native init(ILjava/lang/String;Z)J
.end method

.method public static initialize(Ljava/lang/Object;Z)Z
    .registers 3

    .prologue
    .line 359
    const-string v0, ""

    invoke-static {p0, p1, v0}, Lcom/bfrx/MediaController;->initialize(Ljava/lang/Object;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static initialize(Ljava/lang/Object;ZLjava/lang/String;)Z
    .registers 4

    .prologue
    .line 363
    sput-object p0, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    .line 375
    invoke-static {p1, p2}, Lcom/bfrx/MediaController;->initialize(ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static initialize(ZLjava/lang/String;)Z
    .registers 9

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 314
    invoke-static {}, Lmn;->a()V

    .line 315
    sget-boolean v0, Lcom/bfrx/MediaController;->mLoaded:Z

    if-nez v0, :cond_38

    .line 316
    new-instance v0, Lcom/bfrx/MediaController;

    invoke-direct {v0}, Lcom/bfrx/MediaController;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    .line 317
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    if-nez v0, :cond_1d

    .line 318
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "self was set to null immediately"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 319
    :cond_1d
    const-string v0, "java loading MobileCast"

    new-array v1, v4, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 321
    sget-object v0, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    check-cast v0, Landroid/content/Context;

    invoke-static {v0}, Llb;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_36

    .line 322
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Could not load mobile cast"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 325
    :cond_36
    sput-boolean v5, Lcom/bfrx/MediaController;->mLoaded:Z

    .line 327
    :cond_38
    sget-boolean v0, Lcom/bfrx/MediaController;->mInitailized:Z

    if-eqz v0, :cond_44

    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_ad

    .line 328
    :cond_44
    const-string v0, "java initializing mobilecast, free memory=%MB"

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {}, Llb;->a()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 330
    invoke-static {}, Llb;->a()J

    move-result-wide v0

    sget v2, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_73

    .line 331
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_6b

    .line 332
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    const-string v1, "Out of memory. Requires at least 5mb of free memory."

    invoke-interface {v0, v6, v1}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    .line 333
    :cond_6b
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Java initialize failed. Requires at least 5mb of free memory."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 335
    :cond_73
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    if-eqz v0, :cond_84

    .line 336
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    invoke-direct {v0}, Lcom/bfrx/MediaController;->bind()Z

    .line 337
    sget-object v0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    invoke-interface {v0, v4, p1, p0}, Lcom/bfrx/MediaController$NativeHandler;->initialize(ILjava/lang/String;Z)J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    .line 339
    :cond_84
    sget-boolean v0, Lcom/bfrx/MediaController;->mOverride:Z

    if-nez v0, :cond_90

    .line 340
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    invoke-direct {v0, v4, p1, p0}, Lcom/bfrx/MediaController;->init(ILjava/lang/String;Z)J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    .line 341
    :cond_90
    invoke-static {}, Llb;->a()J

    move-result-wide v0

    sget v2, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_ad

    .line 342
    const-string v0, "Java initialize memory error. Requires at least 5mb of free memory."

    new-array v1, v4, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 343
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_ad

    .line 344
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    const-string v1, "Out of memory. Requires at least 5mb of free memory."

    invoke-interface {v0, v6, v1}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    .line 350
    :cond_ad
    return v5
.end method

.method private static native isDeviceActive(JJ)Z
.end method

.method private static native isDeviceAvailable(JJ)Z
.end method

.method public static isDeviceIdActive(J)Z
    .registers 6

    .prologue
    .line 1750
    invoke-static {}, Lmm;->b()V

    .line 1751
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_d

    .line 1752
    const/4 v0, 0x0

    .line 1755
    :goto_c
    return v0

    .line 1753
    :cond_d
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->isDeviceActive(JJ)Z

    move-result v0

    .line 1754
    invoke-static {}, Lmm;->b()V

    goto :goto_c
.end method

.method public static isDeviceIdAvailable(J)Z
    .registers 8

    .prologue
    const/4 v0, 0x0

    .line 1770
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 1791
    :goto_9
    return v0

    .line 1772
    :cond_a
    new-instance v1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v1, v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    .line 1773
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v2, Lcom/bfrx/MediaController$13;

    invoke-direct {v2, v1, p0, p1}, Lcom/bfrx/MediaController$13;-><init>(Ljava/util/concurrent/atomic/AtomicBoolean;J)V

    invoke-virtual {v0, v2}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 1781
    sget-object v2, Lcom/bfrx/MediaController;->mWaitOnDevice:Ljava/lang/Object;

    monitor-enter v2

    .line 1783
    :try_start_1e
    sget-object v0, Lcom/bfrx/MediaController;->mWaitOnDevice:Ljava/lang/Object;

    const-wide/16 v4, 0x3e8

    invoke-virtual {v0, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_25
    .catch Ljava/lang/InterruptedException; {:try_start_1e .. :try_end_25} :catch_2e
    .catchall {:try_start_1e .. :try_end_25} :catchall_33

    .line 1788
    :goto_25
    :try_start_25
    monitor-exit v2
    :try_end_26
    .catchall {:try_start_25 .. :try_end_26} :catchall_33

    .line 1789
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    .line 1790
    invoke-static {}, Lmm;->b()V

    goto :goto_9

    .line 1785
    :catch_2e
    move-exception v0

    .line 1786
    :try_start_2f
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_25

    .line 1788
    :catchall_33
    move-exception v0

    monitor-exit v2
    :try_end_35
    .catchall {:try_start_2f .. :try_end_35} :catchall_33

    throw v0
.end method

.method public static isGPlaylistMode()Z
    .registers 1

    .prologue
    .line 846
    sget-boolean v0, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    return v0
.end method

.method public static isInitCalled()Z
    .registers 4

    .prologue
    .line 305
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isInitialized()Z
    .registers 1

    .prologue
    .line 301
    sget-boolean v0, Lcom/bfrx/MediaController;->mInitailized:Z

    return v0
.end method

.method public static isIsBlackfireRunInSeperateProcess()Z
    .registers 1

    .prologue
    .line 261
    sget-boolean v0, Lcom/bfrx/MediaController;->isBlackfireRunInSeperateProcess:Z

    return v0
.end method

.method private static native joinGPlayListGroup(J)V
.end method

.method public static joinGlobalSession()Z
    .registers 4

    .prologue
    .line 850
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 851
    const/4 v0, 0x0

    .line 852
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->joinGlobalSession(J)Z

    move-result v0

    sput-boolean v0, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    goto :goto_9
.end method

.method static native joinGlobalSession(J)Z
.end method

.method private static native leaveGPlayListGroup(J)V
.end method

.method public static leaveGlobalSession()V
    .registers 4

    .prologue
    const/4 v0, 0x0

    .line 865
    sput-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 866
    sput-boolean v0, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    .line 867
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_12

    .line 868
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->leaveGlobalSession(J)V

    .line 869
    :cond_12
    return-void
.end method

.method static native leaveGlobalSession(J)V
.end method

.method private static native moveToNextListItem(J)V
.end method

.method private static onConnectionRecover()V
    .registers 2

    .prologue
    .line 1362
    const-string v0, "java onConnectionRecover"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1364
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$12;

    invoke-direct {v1}, Lcom/bfrx/MediaController$12;-><init>()V

    invoke-virtual {v0, v1}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 1377
    return-void
.end method

.method private static onDeviceChanged(Ljava/lang/Object;)V
    .registers 3

    .prologue
    .line 1092
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$9;

    invoke-direct {v1, p0}, Lcom/bfrx/MediaController$9;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 1101
    return-void
.end method

.method public static onDeviceError(JILjava/lang/Object;)V
    .registers 6

    .prologue
    .line 904
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onDeviceError"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 905
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_35

    .line 906
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    check-cast p3, Ljava/lang/String;

    invoke-interface {v0, p0, p1, p2, p3}, Lcom/bfrx/MediaController$DeviceHandler;->onDeviceError(JILjava/lang/String;)V

    .line 907
    :cond_35
    invoke-static {}, Lmm;->b()V

    .line 908
    return-void
.end method

.method public static onDeviceInitialized(J)V
    .registers 6

    .prologue
    .line 968
    sget-boolean v0, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    if-nez v0, :cond_5

    .line 978
    :goto_4
    return-void

    .line 970
    :cond_5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 972
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/bfrx/MediaController$7;

    invoke-direct {v3, v0, v1}, Lcom/bfrx/MediaController$7;-><init>(J)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 977
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_4
.end method

.method public static onDevicePlayStarted(J)V
    .registers 8

    .prologue
    .line 946
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_1f

    .line 947
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "auto-recovery onDevicePlayStarted  end deviceid:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 948
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v0, p0, p1}, Lcom/bfrx/MediaController$DeviceHandler;->onDevicePlayStarted(J)V

    .line 951
    :cond_1f
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 952
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "java onDevicePlayStarted:start time:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-wide v4, Lcom/bfrx/MediaController;->mStartPlayTime:J

    sub-long v4, v0, v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ms id:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 953
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/bfrx/MediaController$6;

    invoke-direct {v3, v0, v1, p0, p1}, Lcom/bfrx/MediaController$6;-><init>(JJ)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 963
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 964
    return-void
.end method

.method public static onDeviceRecover(JLjava/lang/Object;)Z
    .registers 5

    .prologue
    .line 937
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_1f

    .line 938
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "auto-recovery onDeviceRecover ing deviceid:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 939
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v0, p0, p1, p2}, Lcom/bfrx/MediaController$DeviceHandler;->onDeviceRecover(JLjava/lang/Object;)V

    .line 942
    :cond_1f
    const/4 v0, 0x1

    return v0
.end method

.method public static onDeviceVolumeChange(JIJJ)V
    .registers 10

    .prologue
    .line 987
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onDeviceVolumeChange deviceid="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p0, p1}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",value="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", originator="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 988
    invoke-static {p3, p4}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", phoneID="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p5, p6}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 987
    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 991
    cmp-long v0, p0, p3

    if-eqz v0, :cond_48

    cmp-long v0, p5, p3

    if-eqz v0, :cond_51

    .line 992
    :cond_48
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_51

    .line 993
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v0, p0, p1, p2}, Lcom/bfrx/MediaController$DeviceHandler;->onDeviceVolumeChange(JI)V

    .line 996
    :cond_51
    return-void
.end method

.method private static onGetPlayTime(J)V
    .registers 6

    .prologue
    .line 1414
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/bfrx/MediaController;->lastPrintTime:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x2710

    cmp-long v0, v0, v2

    if-lez v0, :cond_34

    .line 1415
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "notifyPlayTime java onGetPlayTime: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-wide/16 v2, 0x3e8

    div-long v2, p0, v2

    invoke-static {v2, v3}, Lcom/bfrx/MediaController;->convertMillisToTimeString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1416
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->lastPrintTime:J

    .line 1418
    :cond_34
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_3d

    .line 1419
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0, p0, p1}, Lcom/bfrx/MediaController$PlayStateHandler;->onPlayTime(J)V

    .line 1435
    :cond_3d
    return-void
.end method

.method public static onMediaSourceErr()V
    .registers 2

    .prologue
    .line 1883
    invoke-static {}, Lmm;->b()V

    .line 1884
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    sget v1, Lcom/bfrx/MediaController;->MSG_ERROR_ONLINE_TIMEOUT:I

    invoke-interface {v0, v1}, Lcom/bfrx/MediaController$DeviceHandler;->onFcError(I)V

    .line 1885
    invoke-static {}, Lmm;->b()V

    .line 1886
    return-void
.end method

.method public static onNativeMessage(Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 4

    .prologue
    .line 878
    invoke-static {}, Lmm;->b()V

    .line 879
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onNativeMessage:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " message:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 880
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_33

    .line 881
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    check-cast p0, Ljava/lang/String;

    check-cast p1, Ljava/lang/String;

    invoke-interface {v0, p0, p1}, Lcom/bfrx/MediaController$PlayStateHandler;->alert(Ljava/lang/String;Ljava/lang/String;)V

    .line 900
    :cond_33
    invoke-static {}, Lmm;->b()V

    .line 901
    return-void
.end method

.method private static onNetworkDisconnected()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    .line 1130
    sput-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 1131
    sput-boolean v0, Lcom/bfrx/MediaController;->mbGPlaylistMode:Z

    .line 1132
    invoke-static {}, Lmm;->b()V

    .line 1133
    sput-boolean v0, Lcom/bfrx/MediaController;->mInitailized:Z

    .line 1134
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_13

    .line 1135
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$DeviceHandler;->onNetworkDisconnected()V

    .line 1136
    :cond_13
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_1c

    .line 1137
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlaylistHandler;->onNetworkDisconnected()V

    .line 1139
    :cond_1c
    invoke-static {}, Lmm;->b()V

    .line 1140
    return-void
.end method

.method private static onNetworkUp()V
    .registers 0

    .prologue
    .line 1128
    return-void
.end method

.method private static onNewDevice(Ljava/lang/Object;)V
    .registers 3

    .prologue
    .line 1067
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bfrx/MediaController;->mInitailized:Z

    .line 1068
    invoke-static {}, Lmq;->a()Lmq;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$8;

    invoke-direct {v1, p0}, Lcom/bfrx/MediaController$8;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lmq;->a(Ljava/lang/Runnable;)V

    .line 1084
    return-void
.end method

.method private static onPlayFinished()V
    .registers 0

    .prologue
    .line 1217
    return-void
.end method

.method private static onPlayMediaSource(JLjava/lang/Object;JJ)V
    .registers 13

    .prologue
    .line 1307
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onPlayMediaSource:source:="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " url:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object v0, p2

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " position:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1308
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_3e

    .line 1309
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    move-object v3, p2

    check-cast v3, Ljava/lang/String;

    move-wide v1, p0

    move-wide v4, p3

    invoke-interface/range {v0 .. v5}, Lcom/bfrx/MediaController$PlayStateHandler;->onPlayMediaSource(JLjava/lang/String;J)V

    .line 1310
    :cond_3e
    return-void
.end method

.method private static onPlayPaused()V
    .registers 0

    .prologue
    .line 1242
    return-void
.end method

.method private static onPlayStopped(I)V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 1384
    sget-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    if-nez v0, :cond_9

    .line 1385
    const-wide/16 v0, 0x0

    sput-wide v0, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 1386
    :cond_9
    sput-boolean v2, Lcom/bfrx/MediaController;->mStopping:Z

    .line 1387
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onPlayStopped reason = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1388
    if-nez p0, :cond_37

    .line 1389
    const-string v0, "stop by finished track"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 1390
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_33

    .line 1391
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlayStateHandler;->onFinishedPlaying()V

    .line 1392
    :cond_33
    invoke-static {}, Lmm;->b()V

    .line 1401
    :cond_36
    :goto_36
    return-void

    .line 1393
    :cond_37
    const/4 v0, 0x1

    if-ne p0, v0, :cond_49

    .line 1395
    const-string v0, "stop by interrup"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 1396
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_36

    .line 1397
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlayStateHandler;->onStopped()V

    goto :goto_36

    .line 1398
    :cond_49
    const/4 v0, 0x2

    if-ne p0, v0, :cond_36

    .line 1399
    const-string v0, "stop by user call stop"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    goto :goto_36
.end method

.method public static onPrivateCommand(J[B[B)V
    .registers 6

    .prologue
    .line 1159
    const-string v0, "onPrivateCommand content: %s"

    invoke-static {v0, p3}, Lmm;->a(Ljava/lang/String;[B)V

    .line 1160
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$11;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/bfrx/MediaController$11;-><init>(J[B[B)V

    invoke-virtual {v0, v1}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 1167
    return-void
.end method

.method public static onPrivateData(JLjava/lang/Object;Ljava/lang/Object;)V
    .registers 6

    .prologue
    .line 1176
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onPrivateData:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " properties:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1177
    return-void
.end method

.method public static onPrivateData(J[B[B)V
    .registers 6

    .prologue
    .line 1149
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "never call this method:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " properties:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 1151
    return-void
.end method

.method private static onQueryAlbumArt(J)Ljava/lang/Object;
    .registers 4

    .prologue
    .line 1351
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_b

    .line 1352
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    invoke-interface {v0, p0, p1}, Lcom/bfrx/MediaController$PlaylistHandler;->onQueryAlbumArt(J)Ljava/lang/String;

    move-result-object v0

    .line 1353
    :goto_a
    return-object v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method private static onQueryTrack(JI)Ljava/lang/Object;
    .registers 5

    .prologue
    .line 1345
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_b

    .line 1346
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    invoke-interface {v0, p0, p1, p2}, Lcom/bfrx/MediaController$PlaylistHandler;->onQueryTrack(JI)Lcom/bfrx/MediaItem;

    move-result-object v0

    .line 1347
    :goto_a
    return-object v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method private static onRemoveDevice(J)V
    .registers 4

    .prologue
    .line 1112
    invoke-static {}, Lmm;->b()V

    .line 1113
    const-string v0, "onRemoveDevice"

    invoke-static {v0}, Lcom/bfrx/MediaController;->printCurrentWifiStatus(Ljava/lang/String;)V

    .line 1114
    invoke-static {p0, p1}, Lcom/bfrx/MediaController;->removeDeviceID(J)V

    .line 1115
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$10;

    invoke-direct {v1, p0, p1}, Lcom/bfrx/MediaController$10;-><init>(J)V

    invoke-virtual {v0, v1}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 1123
    invoke-static {}, Lmm;->b()V

    .line 1124
    return-void
.end method

.method private static onRemoveTrack(JJJ)V
    .registers 14

    .prologue
    .line 1338
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onRemoveTrack: item "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1339
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_25

    .line 1340
    sget-object v1, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    move-wide v2, p0

    move-wide v4, p2

    move-wide v6, p4

    invoke-interface/range {v1 .. v7}, Lcom/bfrx/MediaController$PlaylistHandler;->onRemoveTrack(JJJ)V

    .line 1341
    :cond_25
    return-void
.end method

.method private static onSourceAlbumArt(JLjava/lang/Object;)V
    .registers 5

    .prologue
    .line 1357
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_b

    .line 1358
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    check-cast p2, Ljava/lang/String;

    invoke-interface {v0, p0, p1, p2}, Lcom/bfrx/MediaController$PlaylistHandler;->onSourceAlbumArt(JLjava/lang/String;)V

    .line 1359
    :cond_b
    return-void
.end method

.method private static onSourceAvailable(JZ)V
    .registers 7

    .prologue
    const/4 v2, 0x1

    .line 1258
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourceAvailable ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1259
    new-instance v0, Lcom/bfrx/Device;

    invoke-direct {v0}, Lcom/bfrx/Device;-><init>()V

    .line 1260
    iput-wide p0, v0, Lcom/bfrx/Device;->uniqueID:J

    .line 1261
    iput-boolean p2, v0, Lcom/bfrx/Device;->isPlaying:Z

    .line 1262
    iput-boolean v2, v0, Lcom/bfrx/Device;->isSource:Z

    .line 1263
    sget-object v1, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v1, :cond_2e

    .line 1264
    sget-object v1, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v1, v0, v2}, Lcom/bfrx/MediaController$DeviceHandler;->onDeviceDiscovered(Lcom/bfrx/Device;Z)V

    .line 1265
    :cond_2e
    return-void
.end method

.method private static onSourceChanged(JZ)V
    .registers 7

    .prologue
    const/4 v2, 0x1

    .line 1273
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourceAvailable ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1274
    new-instance v0, Lcom/bfrx/Device;

    invoke-direct {v0}, Lcom/bfrx/Device;-><init>()V

    .line 1275
    iput-wide p0, v0, Lcom/bfrx/Device;->uniqueID:J

    .line 1276
    iput-boolean p2, v0, Lcom/bfrx/Device;->isPlaying:Z

    .line 1277
    iput-boolean v2, v0, Lcom/bfrx/Device;->isSource:Z

    .line 1278
    sget-object v1, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v1, :cond_2e

    .line 1279
    sget-object v1, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    invoke-interface {v1, v0, v2}, Lcom/bfrx/MediaController$DeviceHandler;->onDeviceDiscovered(Lcom/bfrx/Device;Z)V

    .line 1280
    :cond_2e
    return-void
.end method

.method public static onSourceError(ILjava/lang/Object;)V
    .registers 4

    .prologue
    const/4 v1, 0x3

    .line 912
    const-string v0, "onSourceError"

    invoke-static {v0}, Lmm;->a(Ljava/lang/String;)V

    .line 913
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_20

    if-ne p0, v1, :cond_20

    .line 915
    sget v0, Lcom/bfrx/MediaController;->count:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/bfrx/MediaController;->count:I

    .line 916
    sget v0, Lcom/bfrx/MediaController;->count:I

    if-ne v0, v1, :cond_20

    .line 917
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    check-cast p1, Ljava/lang/String;

    invoke-interface {v0, p0, p1}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    .line 918
    const/4 v0, 0x0

    sput v0, Lcom/bfrx/MediaController;->count:I

    .line 921
    :cond_20
    return-void
.end method

.method private static onSourceExitSession(JZ)V
    .registers 5

    .prologue
    .line 1282
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourceExitSession ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1283
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_22

    .line 1284
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    invoke-interface {v0, p0, p1, p2}, Lcom/bfrx/MediaController$PlaylistHandler;->onRemoveSource(JZ)V

    .line 1285
    :cond_22
    return-void
.end method

.method private static onSourcePlay(JLjava/lang/Object;)V
    .registers 5

    .prologue
    .line 1288
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourcePlay ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": track= "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object v0, p2

    check-cast v0, Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1289
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_35

    .line 1290
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    check-cast p2, Lcom/bfrx/MediaItem;

    invoke-interface {v0, p2}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourcePlaying(Lcom/bfrx/MediaItem;)V

    .line 1291
    :cond_35
    return-void
.end method

.method private static onSourcePlayFinished(J)V
    .registers 4

    .prologue
    .line 1300
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourcePlayFinished ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1301
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_22

    .line 1302
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlayStateHandler;->onFinished()V

    .line 1303
    :cond_22
    return-void
.end method

.method private static onSourcePlayStopped(J)V
    .registers 4

    .prologue
    .line 1294
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourcePlayStopped ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1295
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_22

    .line 1296
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlayStateHandler;->onStopped()V

    .line 1297
    :cond_22
    return-void
.end method

.method private static onSourceQueued(JLjava/lang/Object;I)V
    .registers 7

    .prologue
    const/4 v2, 0x0

    .line 1313
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "java onSourceQueued: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object v0, p2

    check-cast v0, Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    move-object v0, p2

    .line 1314
    check-cast v0, Lcom/bfrx/MediaItem;

    invoke-virtual {v0, v2}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 1316
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-eqz v0, :cond_53

    .line 1317
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v1

    move-object v0, p2

    check-cast v0, Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_53

    move-object v0, p2

    .line 1318
    check-cast v0, Lcom/bfrx/MediaItem;

    sget-object v1, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v1}, Lcom/bfrx/MediaItem;->getArtist()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bfrx/MediaItem;->setArtist(Ljava/lang/String;)V

    .line 1319
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-nez v0, :cond_53

    move-object v0, p2

    .line 1320
    check-cast v0, Lcom/bfrx/MediaItem;

    invoke-virtual {v0, v2}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 1324
    :cond_53
    :goto_53
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-nez v0, :cond_62

    .line 1326
    const-wide/16 v0, 0x32

    :try_start_59
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_5c
    .catch Ljava/lang/InterruptedException; {:try_start_59 .. :try_end_5c} :catch_5d

    goto :goto_53

    .line 1327
    :catch_5d
    move-exception v0

    .line 1328
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_53

    .line 1332
    :cond_62
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_6d

    .line 1333
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    check-cast p2, Lcom/bfrx/MediaItem;

    invoke-interface {v0, p2, p3}, Lcom/bfrx/MediaController$PlaylistHandler;->onSourceQueued(Lcom/bfrx/MediaItem;I)V

    .line 1335
    :cond_6d
    return-void
.end method

.method private static onSourceUnavailable(J)V
    .registers 6

    .prologue
    const/4 v2, 0x0

    .line 1268
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onSourceUnavailable ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1269
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    if-eqz v0, :cond_22

    .line 1270
    sget-object v0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    invoke-interface {v0, p0, p1, v2}, Lcom/bfrx/MediaController$PlaylistHandler;->onRemoveSource(JZ)V

    .line 1271
    :cond_22
    return-void
.end method

.method private static onStartedPlaying()V
    .registers 3

    .prologue
    const/4 v2, 0x1

    .line 1183
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 1184
    sput-boolean v2, Lcom/bfrx/MediaController;->mInitailized:Z

    .line 1185
    invoke-static {}, Lmm;->b()V

    .line 1186
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-eqz v0, :cond_1d

    .line 1187
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v0, v2}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 1188
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_1d

    .line 1189
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    sget-object v1, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-interface {v0, v1}, Lcom/bfrx/MediaController$PlayStateHandler;->onStartedPlaying(Lcom/bfrx/MediaItem;)V

    .line 1191
    :cond_1d
    sput-boolean v2, Lcom/bfrx/MediaController;->mbStop:Z

    .line 1192
    return-void
.end method

.method public static onVersionError(JILjava/lang/Object;)V
    .registers 6

    .prologue
    .line 925
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    if-eqz v0, :cond_b

    .line 926
    sget-object v0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    check-cast p3, Ljava/lang/String;

    invoke-interface {v0, p0, p1, p2, p3}, Lcom/bfrx/MediaController$DeviceHandler;->onVersionError(JILjava/lang/String;)V

    .line 928
    :cond_b
    return-void
.end method

.method private static native pause(J)Z
.end method

.method public static pauseDeviceProbe()V
    .registers 4

    .prologue
    .line 1907
    invoke-static {}, Lmm;->b()V

    .line 1908
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_c

    .line 1912
    :goto_b
    return-void

    .line 1910
    :cond_c
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->pauseDeviceProbe(J)V

    .line 1911
    invoke-static {}, Lmm;->b()V

    goto :goto_b
.end method

.method static native pauseDeviceProbe(J)V
.end method

.method private static native pcmToFirecast(J[BI)I
.end method

.method public static pcmToFirecast([BI)I
    .registers 12

    .prologue
    const/4 v6, -0x1

    const/4 v7, 0x0

    const-wide/16 v8, 0x0

    .line 1962
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v0, v0, v8

    if-nez v0, :cond_13

    .line 1963
    const-string v0, "java pcmToFirecast mobilecast not initialized"

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    move v0, v6

    .line 2045
    :goto_12
    return v0

    .line 1966
    :cond_13
    sget-boolean v0, Lcom/bfrx/MediaController;->mStopping:Z

    if-eqz v0, :cond_1d

    sget-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    if-nez v0, :cond_1d

    move v0, v6

    .line 1967
    goto :goto_12

    .line 1970
    :cond_1d
    sget-wide v0, Lcom/bfrx/MediaController;->mStartPlayTime:J

    cmp-long v0, v0, v8

    if-gtz v0, :cond_27

    sget-boolean v0, Lcom/bfrx/MediaController;->mbStop:Z

    if-eqz v0, :cond_33

    :cond_27
    sget-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    if-eqz v0, :cond_9a

    sget-boolean v0, Lcom/bfrx/MediaController;->mStopping:Z

    if-nez v0, :cond_9a

    sget-boolean v0, Lcom/bfrx/MediaController;->mbStop:Z

    if-eqz v0, :cond_9a

    .line 1972
    :cond_33
    sput-wide v8, Lcom/bfrx/MediaController;->mBytesTransfered:J

    .line 1973
    sput-wide v8, Lcom/bfrx/MediaController;->mTotalGapTime:J

    .line 1974
    sput-wide v8, Lcom/bfrx/MediaController;->mGapCount:J

    .line 1975
    sput-wide v8, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    .line 1976
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 1977
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-eqz v0, :cond_7d

    .line 1978
    sget v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    if-eqz v0, :cond_51

    sget-wide v0, Lcom/bfrx/MediaController;->mLastPcmTime:J

    cmp-long v0, v0, v8

    if-eqz v0, :cond_51

    move v0, v6

    .line 1979
    goto :goto_12

    .line 1980
    :cond_51
    const/16 v0, 0x3e8

    invoke-static {v0}, Lcom/bfrx/MediaController;->setDelay(I)Z

    .line 1981
    invoke-static {v7}, Lcom/bfrx/MediaController;->setContinuousMode(Z)Z

    .line 1986
    :goto_59
    const-string v0, "java pcmToFirecast starting session"

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1987
    invoke-static {}, Lcom/bfrx/MediaController;->startSession()Z

    move-result v0

    if-nez v0, :cond_98

    .line 1988
    const-string v0, "java pcmToFirecast failed to start session"

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1989
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bfrx/MediaController;->mStopping:Z

    .line 1990
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->stopPlaying(J)Z

    .line 1992
    sput-wide v8, Lcom/bfrx/MediaController;->mLastPcmTime:J

    .line 1993
    sget-boolean v0, Lcom/bfrx/MediaController;->mbStop:Z

    if-nez v0, :cond_93

    move v0, v6

    .line 1994
    goto :goto_12

    .line 1983
    :cond_7d
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mPcmTimeout:Ljava/util/Timer;

    .line 1984
    sget-object v0, Lcom/bfrx/MediaController;->mPcmTimeout:Ljava/util/Timer;

    new-instance v1, Lcom/bfrx/MediaController$PcmTimer;

    invoke-direct {v1}, Lcom/bfrx/MediaController$PcmTimer;-><init>()V

    const-wide/16 v2, 0xc8

    const-wide/16 v4, 0x64

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    goto :goto_59

    .line 1995
    :cond_93
    sput-wide v8, Lcom/bfrx/MediaController;->mStartPlayTime:J

    move v0, v6

    .line 1996
    goto/16 :goto_12

    .line 1998
    :cond_98
    sput-boolean v7, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 2024
    :cond_9a
    sget-wide v0, Lcom/bfrx/MediaController;->mLastPcmTime:J

    cmp-long v0, v0, v8

    if-lez v0, :cond_fe

    .line 2025
    sget-wide v0, Lcom/bfrx/MediaController;->mBytesTransfered:J

    int-to-long v2, p1

    add-long/2addr v0, v2

    sput-wide v0, Lcom/bfrx/MediaController;->mBytesTransfered:J

    .line 2026
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/bfrx/MediaController;->mLastPcmTime:J

    sub-long/2addr v0, v2

    .line 2027
    sget-wide v2, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    add-long/2addr v2, v0

    sput-wide v2, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    .line 2028
    sget-wide v2, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    const-wide/16 v4, 0x3e8

    cmp-long v2, v2, v4

    if-ltz v2, :cond_c2

    .line 2030
    sput-wide v8, Lcom/bfrx/MediaController;->mBytesTransfered:J

    .line 2031
    sput-wide v8, Lcom/bfrx/MediaController;->mTotalGapTime:J

    .line 2032
    sput-wide v8, Lcom/bfrx/MediaController;->mGapCount:J

    .line 2033
    sput-wide v8, Lcom/bfrx/MediaController;->mTotalIntervalTime:J

    .line 2036
    :cond_c2
    const-wide/16 v2, 0x14

    cmp-long v2, v0, v2

    if-lez v2, :cond_d4

    .line 2037
    sget-wide v2, Lcom/bfrx/MediaController;->mGapCount:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    sput-wide v2, Lcom/bfrx/MediaController;->mGapCount:J

    .line 2038
    sget-wide v2, Lcom/bfrx/MediaController;->mTotalGapTime:J

    add-long/2addr v2, v0

    sput-wide v2, Lcom/bfrx/MediaController;->mTotalGapTime:J

    .line 2040
    :cond_d4
    const-wide/16 v2, 0x1f4

    cmp-long v2, v0, v2

    if-lez v2, :cond_fe

    .line 2041
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "java pcmToFirecast() gap="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " >20ms gapcount="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-wide v2, Lcom/bfrx/MediaController;->mGapCount:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 2044
    :cond_fe
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/bfrx/MediaController;->mLastPcmTime:J

    .line 2045
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->pcmToFirecast(J[BI)I

    move-result v0

    goto/16 :goto_12
.end method

.method public static play(Lcom/bfrx/MediaItem;Z)V
    .registers 4

    .prologue
    .line 574
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "MediaController play isResume="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 575
    sget-object v0, Lcom/bfrx/MediaController;->latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v1, Lcom/bfrx/MediaController$3;

    invoke-direct {v1, p1, p0}, Lcom/bfrx/MediaController$3;-><init>(ZLcom/bfrx/MediaItem;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 583
    sget-object v0, Lcom/bfrx/MediaController;->latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lcom/bfrx/MediaController;->runNextTask(Ljava/util/concurrent/atomic/AtomicReference;)V

    .line 584
    return-void
.end method

.method protected static native playFileResume(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z
.end method

.method public static playFileResume(Lcom/bfrx/MediaItem;)Z
    .registers 8

    .prologue
    .line 565
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Unknown artist"

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getId()J

    move-result-wide v5

    invoke-static/range {v0 .. v6}, Lcom/bfrx/MediaController;->playFileResume(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z

    move-result v0

    return v0
.end method

.method private static native playFileStart(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
.end method

.method public static playRawPcm(Lcom/bfrx/MediaItem;)Z
    .registers 7

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 489
    if-nez p0, :cond_5

    .line 561
    :cond_4
    :goto_4
    return v0

    .line 491
    :cond_5
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 493
    invoke-static {}, Llb;->a()J

    move-result-wide v2

    sget v4, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-gez v2, :cond_2a

    .line 494
    const-string v1, "Java playRawPcm memory error. Requires at least 5mb of free memory."

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 495
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v1, :cond_4

    .line 496
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    const/4 v2, 0x2

    const-string v3, "Out of Memory. Requires at least 5mb of free memory."

    invoke-interface {v1, v2, v3}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    goto :goto_4

    .line 499
    :cond_2a
    const-wide/16 v2, 0x0

    sput-wide v2, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 500
    invoke-virtual {p0, v1}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 501
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "playRawPcm "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v2, v0}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 502
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    const-string v2, "48"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_61

    .line 503
    const v0, 0xbb80

    const/16 v2, 0x10

    invoke-static {v0, v2}, Lcom/bfrx/MediaController;->setSessionFormat(II)Z

    .line 506
    :cond_61
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v2, Lcom/bfrx/MediaController$2;

    invoke-direct {v2, p0}, Lcom/bfrx/MediaController$2;-><init>(Lcom/bfrx/MediaItem;)V

    invoke-virtual {v0, v2}, Lmp;->execute(Ljava/lang/Runnable;)V

    move v0, v1

    .line 561
    goto :goto_4
.end method

.method public static playRemoteItem(Lcom/bfrx/MediaItem;)Z
    .registers 5

    .prologue
    .line 697
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 698
    const/4 v0, 0x0

    .line 699
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getId()J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3, p0}, Lcom/bfrx/MediaController;->playRemoteSource(JJLjava/lang/Object;)Z

    move-result v0

    goto :goto_9
.end method

.method private static native playRemoteSource(JJLjava/lang/Object;)Z
.end method

.method public static playSync(Lcom/bfrx/MediaItem;Z)Z
    .registers 16

    .prologue
    const/4 v13, 0x3

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 587
    const-string v0, "fix buring ---"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 588
    if-nez p0, :cond_c

    move v0, v7

    .line 693
    :goto_b
    return v0

    .line 591
    :cond_c
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_14

    move v0, v7

    .line 592
    goto :goto_b

    .line 594
    :cond_14
    const-string v0, "fix buring ---"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 595
    const-string v0, "java starting play"

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 596
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    .line 597
    sput v7, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    .line 598
    sput v7, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    .line 599
    sput-boolean v8, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    .line 600
    sget-object v1, Lcom/bfrx/MediaController;->mWaitOnStop:Ljava/lang/Object;

    monitor-enter v1

    .line 601
    :goto_2d
    :try_start_2d
    sget-boolean v0, Lcom/bfrx/MediaController;->mStopping:Z
    :try_end_2f
    .catchall {:try_start_2d .. :try_end_2f} :catchall_3c

    if-eqz v0, :cond_3f

    .line 603
    :try_start_31
    sget-object v0, Lcom/bfrx/MediaController;->mWaitOnStop:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->wait()V
    :try_end_36
    .catch Ljava/lang/InterruptedException; {:try_start_31 .. :try_end_36} :catch_37
    .catchall {:try_start_31 .. :try_end_36} :catchall_3c

    goto :goto_2d

    .line 604
    :catch_37
    move-exception v0

    .line 605
    :try_start_38
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_2d

    .line 608
    :catchall_3c
    move-exception v0

    monitor-exit v1
    :try_end_3e
    .catchall {:try_start_38 .. :try_end_3e} :catchall_3c

    throw v0

    :cond_3f
    :try_start_3f
    monitor-exit v1
    :try_end_40
    .catchall {:try_start_3f .. :try_end_40} :catchall_3c

    .line 610
    sput-wide v10, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 612
    const/16 v0, 0x3e8

    invoke-static {v0}, Lcom/bfrx/MediaController;->setDelay(I)Z

    .line 613
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v0, :cond_50

    .line 614
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0, v7}, Lcom/bfrx/MediaController$PlayStateHandler;->useLocalDevice(Z)V

    .line 616
    :cond_50
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-nez v0, :cond_8b

    const-string v1, ""

    .line 617
    :goto_56
    if-nez p0, :cond_92

    const-string v0, ""

    .line 618
    :goto_5a
    if-eqz v1, :cond_5e

    if-nez v0, :cond_68

    .line 619
    :cond_5e
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-nez v0, :cond_97

    const-string v1, ""

    .line 620
    :goto_64
    if-nez p0, :cond_9e

    const-string v0, ""

    .line 622
    :cond_68
    :goto_68
    if-nez v1, :cond_6c

    const-string v1, ""

    .line 623
    :cond_6c
    if-nez v0, :cond_70

    const-string v0, ""

    .line 624
    :cond_70
    invoke-virtual {v1, v0}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_7a

    sget-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    if-eqz v0, :cond_ad

    .line 626
    :cond_7a
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_ad

    .line 627
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-nez v0, :cond_a3

    .line 628
    const-string v0, "fix buring ---"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    move v0, v7

    .line 629
    goto :goto_b

    .line 616
    :cond_8b
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v1

    goto :goto_56

    .line 617
    :cond_92
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_5a

    .line 619
    :cond_97
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    goto :goto_64

    .line 620
    :cond_9e
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    goto :goto_68

    .line 631
    :cond_a3
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0}, Lcom/bfrx/MediaController$PlayStateHandler;->onStopped()V

    .line 632
    sget-object v0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    invoke-interface {v0, p0}, Lcom/bfrx/MediaController$PlayStateHandler;->LoadTrack(Lcom/bfrx/MediaItem;)I

    .line 635
    :cond_ad
    sget-object v12, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    .line 636
    if-eq v12, p0, :cond_b6

    .line 637
    if-eqz v12, :cond_b6

    .line 638
    invoke-virtual {v12, v7}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 639
    :cond_b6
    invoke-virtual {p0, v8}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 640
    sput-object p0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    .line 641
    const-string v0, "java playing media source"

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 642
    sput-boolean v8, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 644
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 650
    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_db

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_e3

    .line 651
    :cond_db
    const-string v0, "fix buring ---"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    move v0, v7

    .line 652
    goto/16 :goto_b

    .line 654
    :cond_e3
    sget-object v0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-eqz v0, :cond_124

    if-eqz p1, :cond_124

    .line 658
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Unknown artist"

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getId()J

    move-result-wide v5

    invoke-static/range {v0 .. v6}, Lcom/bfrx/MediaController;->playFileResume(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z

    move-result v0

    move v1, v7

    .line 659
    :goto_fe
    if-nez v0, :cond_15b

    if-ge v1, v13, :cond_15b

    .line 660
    add-int/lit8 v9, v1, 0x1

    .line 662
    const-wide/16 v0, 0x64

    :try_start_106
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_109
    .catch Ljava/lang/InterruptedException; {:try_start_106 .. :try_end_109} :catch_11f

    .line 666
    :goto_109
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Unknown artist"

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getId()J

    move-result-wide v5

    invoke-static/range {v0 .. v6}, Lcom/bfrx/MediaController;->playFileResume(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z

    move-result v0

    move v1, v9

    goto :goto_fe

    .line 663
    :catch_11f
    move-exception v0

    .line 664
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_109

    .line 671
    :cond_124
    const-string v0, "fix buring ---"

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 672
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Unknown artist"

    invoke-static {v0, v1, v2, v3, v4}, Lcom/bfrx/MediaController;->playFileStart(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    move v1, v7

    .line 673
    :goto_13a
    if-nez v0, :cond_15b

    if-ge v1, v13, :cond_15b

    .line 674
    add-int/lit8 v1, v1, 0x1

    .line 676
    const-wide/16 v2, 0x64

    :try_start_142
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_145
    .catch Ljava/lang/InterruptedException; {:try_start_142 .. :try_end_145} :catch_156

    .line 680
    :goto_145
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Unknown artist"

    invoke-static {v2, v3, v0, v4, v5}, Lcom/bfrx/MediaController;->playFileStart(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    goto :goto_13a

    .line 677
    :catch_156
    move-exception v0

    .line 678
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_145

    .line 684
    :cond_15b
    sput-wide v10, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 685
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sub-long/2addr v0, v10

    sput-wide v0, Lcom/bfrx/MediaController;->mTrackInitTime:J

    .line 687
    sget-object v0, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    if-eqz v0, :cond_16f

    .line 688
    sget-object v0, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    sget-wide v2, Lcom/bfrx/MediaController;->mTrackInitTime:J

    invoke-interface {v0, v2, v3}, Lcom/bfrx/MediaController$MeasurementHandler;->onTrackInitialzed(J)V

    .line 689
    :cond_16f
    if-eq v12, p0, :cond_176

    .line 690
    if-eqz v12, :cond_176

    .line 691
    invoke-virtual {v12, v7}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 692
    :cond_176
    invoke-virtual {p0, v8}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    move v0, v8

    .line 693
    goto/16 :goto_b
.end method

.method private static printCurrentWifiStatus(Ljava/lang/String;)V
    .registers 5

    .prologue
    .line 1104
    sget-object v0, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    if-nez v0, :cond_5

    .line 1109
    :goto_4
    return-void

    .line 1106
    :cond_5
    sget-object v0, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    check-cast v0, Landroid/content/Context;

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    check-cast v0, Landroid/net/wifi/WifiManager;

    .line 1107
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v0

    .line 1108
    const-string v1, "%s %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    goto :goto_4
.end method

.method public static probeDestinations()Z
    .registers 4

    .prologue
    .line 1868
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1869
    const/4 v0, 0x0

    .line 1870
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->probeDestinations(J)Z

    move-result v0

    goto :goto_9
.end method

.method private static native probeDestinations(J)Z
.end method

.method public static probeDevices(I)Z
    .registers 8

    .prologue
    const/4 v6, 0x1

    const/4 v0, 0x0

    .line 1898
    const-string v1, "probeDevices group=%d, mHandle=%l"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v1, v2}, Lmm;->c(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1899
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_21

    .line 1903
    :goto_20
    return v0

    .line 1901
    :cond_21
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v2, v3, p0}, Lcom/bfrx/MediaController;->probeDevices(JI)Z

    move-result v1

    .line 1902
    const-string v2, "probeDevices ret=%b"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v0

    invoke-static {v2, v3}, Lmm;->c(Ljava/lang/Object;[Ljava/lang/Object;)V

    move v0, v1

    .line 1903
    goto :goto_20
.end method

.method static native probeDevices(JI)Z
.end method

.method public static probeGlobalSession()V
    .registers 4

    .prologue
    .line 872
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_9

    .line 875
    :goto_8
    return-void

    .line 874
    :cond_9
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->probeGlobalSession(J)V

    goto :goto_8
.end method

.method static native probeGlobalSession(J)V
.end method

.method private static native queryPrivateData(JJLjava/lang/String;)Z
.end method

.method public static queryPrivateData(JLjava/lang/String;)Z
    .registers 7

    .prologue
    .line 1005
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1006
    const/4 v0, 0x0

    .line 1007
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/bfrx/MediaController;->queryPrivateData(JJLjava/lang/String;)Z

    move-result v0

    goto :goto_9
.end method

.method public static queueItem(Lcom/bfrx/MediaItem;)Z
    .registers 9

    .prologue
    const/4 v0, 0x0

    .line 703
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 722
    :cond_9
    :goto_9
    return v0

    .line 705
    :cond_a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 707
    sget-object v1, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-nez v1, :cond_14

    .line 708
    sput-object p0, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    .line 709
    :cond_14
    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v4, v5}, Lcom/bfrx/MediaController;->getGlobalPlaylistSize(J)I

    move-result v1

    .line 710
    if-gtz v1, :cond_23

    .line 711
    sput v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    .line 712
    sput v0, Lcom/bfrx/MediaController;->mDevicePlayCount:I

    .line 713
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    .line 715
    :cond_23
    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getArtist()Ljava/lang/String;

    move-result-object v7

    invoke-static {v4, v5, v0, v6, v7}, Lcom/bfrx/MediaController;->queueTrack(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 716
    if-gtz v1, :cond_9

    .line 717
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v2

    sput-wide v4, Lcom/bfrx/MediaController;->mTrackInitTime:J

    .line 718
    sput-wide v2, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 719
    sget-object v1, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    if-eqz v1, :cond_9

    .line 720
    sget-object v1, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    sget-wide v2, Lcom/bfrx/MediaController;->mTrackInitTime:J

    invoke-interface {v1, v2, v3}, Lcom/bfrx/MediaController$MeasurementHandler;->onTrackInitialzed(J)V

    goto :goto_9
.end method

.method private static native queueTrack(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
.end method

.method public static removeActiveDevice(J)Z
    .registers 6

    .prologue
    .line 1730
    invoke-static {}, Lmm;->b()V

    .line 1731
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_d

    .line 1732
    const/4 v0, 0x0

    .line 1737
    :goto_c
    return v0

    .line 1733
    :cond_d
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmm;->a(Ljava/lang/Object;)V

    .line 1734
    invoke-static {p0, p1}, Lcom/bfrx/MediaController;->removeDeviceID(J)V

    .line 1735
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->removeActiveDevice(JJ)Z

    move-result v0

    .line 1736
    invoke-static {}, Lmm;->b()V

    goto :goto_c
.end method

.method private static native removeActiveDevice(JJ)Z
.end method

.method public static removeActiveGroup(I)Z
    .registers 5

    .prologue
    .line 1657
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1658
    const/4 v0, 0x0

    .line 1659
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->removeActiveGroup(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native removeActiveGroup(JI)Z
.end method

.method public static removeDeviceID(J)V
    .registers 4

    .prologue
    .line 828
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1f

    .line 829
    sget v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    if-lez v0, :cond_16

    .line 830
    sget v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lcom/bfrx/MediaController;->mDeviceInitCount:I

    .line 831
    :cond_16
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 833
    :cond_1f
    return-void
.end method

.method private static native removeTrack(JJLjava/lang/String;)Z
.end method

.method public static removeVirtualDevice(JJ)Z
    .registers 10

    .prologue
    .line 1740
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1741
    const/4 v0, 0x0

    .line 1742
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    move-wide v2, p0

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/bfrx/MediaController;->removeVirtualDevice(JJJ)Z

    move-result v0

    goto :goto_9
.end method

.method private static native removeVirtualDevice(JJJ)Z
.end method

.method public static restartFCS(IZ)Z
    .registers 8

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x0

    .line 1448
    invoke-static {}, Lmm;->b()V

    .line 1450
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    if-nez v0, :cond_27

    .line 1451
    const-string v0, "java loading mobilecast"

    new-array v2, v1, [Ljava/lang/Object;

    invoke-static {v0, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1452
    new-instance v0, Lcom/bfrx/MediaController;

    invoke-direct {v0}, Lcom/bfrx/MediaController;-><init>()V

    sput-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    .line 1453
    sget-object v0, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    if-nez v0, :cond_1d

    .line 1468
    :cond_1c
    :goto_1c
    return v1

    .line 1455
    :cond_1d
    sget-object v0, Lcom/bfrx/MediaController;->mAppContext:Ljava/lang/Object;

    check-cast v0, Landroid/content/Context;

    invoke-static {v0}, Llb;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 1459
    :cond_27
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_38

    .line 1461
    const-string v0, ""

    .line 1462
    sget-object v2, Lcom/bfrx/MediaController;->mSelf:Lcom/bfrx/MediaController;

    invoke-direct {v2, p0, v0, p1}, Lcom/bfrx/MediaController;->init(ILjava/lang/String;Z)J

    move-result-wide v2

    sput-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    goto :goto_1c

    .line 1467
    :cond_38
    invoke-static {}, Lmm;->b()V

    .line 1468
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v0, v2, v4

    if-eqz v0, :cond_44

    const/4 v0, 0x1

    :goto_42
    move v1, v0

    goto :goto_1c

    :cond_44
    move v0, v1

    goto :goto_42
.end method

.method public static restartFCS(Z)Z
    .registers 2

    .prologue
    .line 1444
    const/4 v0, 0x0

    invoke-static {v0, p0}, Lcom/bfrx/MediaController;->restartFCS(IZ)Z

    move-result v0

    return v0
.end method

.method private static runNextTask(Ljava/util/concurrent/atomic/AtomicReference;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/lang/Runnable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 770
    sget-object v0, Lcom/bfrx/MediaController;->MUSIC_PLAYER_THREAD:Ljava/lang/String;

    invoke-static {v0}, Lmq;->a(Ljava/lang/String;)Lmo;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$5;

    invoke-direct {v1, p0}, Lcom/bfrx/MediaController$5;-><init>(Ljava/util/concurrent/atomic/AtomicReference;)V

    invoke-virtual {v0, v1}, Lmo;->a(Ljava/lang/Runnable;)Z

    .line 789
    return-void
.end method

.method static native seek(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z
.end method

.method public static seek(Lcom/bfrx/MediaItem;J)Z
    .registers 12

    .prologue
    const-wide/16 v6, 0x3e8

    const/4 v0, 0x0

    .line 430
    const-string v1, "java seek to %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    div-long v4, p1, v6

    div-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 431
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_1d

    .line 434
    :goto_1c
    return v0

    :cond_1d
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bfrx/MediaItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Unknown artist"

    move-wide v5, p1

    invoke-static/range {v0 .. v6}, Lcom/bfrx/MediaController;->seek(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z

    move-result v0

    goto :goto_1c
.end method

.method public static sendCommand(IJJ)Z
    .registers 14

    .prologue
    .line 1572
    invoke-static {}, Lmm;->b()V

    .line 1573
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_d

    .line 1574
    const/4 v0, 0x0

    .line 1577
    :goto_c
    return v0

    .line 1575
    :cond_d
    sget-wide v1, Lcom/bfrx/MediaController;->mHandle:J

    move v3, p0

    move-wide v4, p1

    move-wide v6, p3

    invoke-static/range {v1 .. v7}, Lcom/bfrx/MediaController;->sendCommand(JIJJ)Z

    move-result v0

    .line 1576
    invoke-static {}, Lmm;->b()V

    goto :goto_c
.end method

.method private static native sendCommand(JIJJ)Z
.end method

.method public static sendIotCommand(JII)Z
    .registers 10

    .prologue
    .line 1054
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1055
    const/4 v0, 0x0

    .line 1056
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    move-wide v2, p0

    move v4, p2

    move v5, p3

    invoke-static/range {v0 .. v5}, Lcom/bfrx/MediaController;->sendIotCommand(JJII)Z

    move-result v0

    goto :goto_9
.end method

.method private static native sendIotCommand(JJII)Z
.end method

.method private static native sendPlaylistCommand(JJLjava/lang/String;)Z
.end method

.method private static native sendPrivateByteCommand(JJ[B)Z
.end method

.method private static native sendPrivateCommand(JJLjava/lang/String;)Z
.end method

.method public static sendPrivateCommand(J[B)Z
    .registers 7

    .prologue
    .line 1046
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1047
    const/4 v0, 0x0

    .line 1050
    :goto_9
    return v0

    .line 1048
    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/bfrx/MediaController;->sendPrivateByteCommand(JJ[B)Z

    move-result v0

    goto :goto_9
.end method

.method public static sendSourcePrivateCommand(ILjava/lang/String;)Z
    .registers 6

    .prologue
    .line 1251
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1252
    const/4 v0, 0x0

    .line 1253
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->sendSourcePrivateCommand(JILjava/lang/String;)Z

    move-result v0

    goto :goto_9
.end method

.method private static native sendSourcePrivateCommand(JILjava/lang/String;)Z
.end method

.method public static setAbsoluteVolume(JI)Z
    .registers 7

    .prologue
    .line 1610
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1611
    const/4 v0, 0x0

    .line 1612
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/bfrx/MediaController;->setAbsoluteVolume(JJI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setAbsoluteVolume(JJI)Z
.end method

.method public static setActiveDevice(J)Z
    .registers 8

    .prologue
    const/4 v0, 0x0

    .line 1663
    .line 1664
    invoke-static {}, Lmm;->b()V

    .line 1665
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_d

    .line 1717
    :goto_c
    return v0

    .line 1667
    :cond_d
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lmm;->a(Ljava/lang/Object;)V

    .line 1668
    invoke-static {p0, p1}, Lcom/bfrx/MediaController;->addDeviceID(J)V

    .line 1669
    sput-boolean v0, Lcom/bfrx/MediaController;->mStatsEnabled:Z

    .line 1670
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->setActiveDevice(JJ)Z

    move-result v0

    .line 1716
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setActiveDevice ret="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lmm;->a(Ljava/lang/Object;)V

    goto :goto_c
.end method

.method private static native setActiveDevice(JJ)Z
.end method

.method public static setActiveGroup(I)Z
    .registers 5

    .prologue
    .line 1651
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1652
    const/4 v0, 0x0

    .line 1653
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setActiveGroup(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setActiveGroup(JI)Z
.end method

.method public static setActiveGroups(I)Z
    .registers 5

    .prologue
    .line 1630
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1631
    const/4 v0, 0x0

    .line 1632
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setActiveGroups(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setActiveGroups(JI)Z
.end method

.method private static native setContinuousMode(JZ)Z
.end method

.method public static setContinuousMode(Z)Z
    .registers 5

    .prologue
    .line 1928
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1929
    const/4 v0, 0x0

    .line 1930
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setContinuousMode(JZ)Z

    move-result v0

    goto :goto_9
.end method

.method public static setDelay(I)Z
    .registers 5

    .prologue
    .line 1916
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1917
    const/4 v0, 0x0

    .line 1918
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setDelay(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setDelay(JI)Z
.end method

.method public static setDeviceHandler(Lcom/bfrx/MediaController$DeviceHandler;)V
    .registers 1

    .prologue
    .line 800
    sput-object p0, Lcom/bfrx/MediaController;->m_deviceHandler:Lcom/bfrx/MediaController$DeviceHandler;

    .line 801
    return-void
.end method

.method private static native setDeviceSettings(JLcom/bfrx/Device;)Z
.end method

.method public static setDeviceSettings(Lcom/bfrx/Device;)Z
    .registers 7

    .prologue
    const/4 v0, 0x0

    .line 1801
    invoke-static {}, Lmm;->b()V

    .line 1802
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_14

    .line 1803
    const-string v1, "CLLOG WIFISETUP handle 0"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1811
    :goto_13
    return v0

    .line 1806
    :cond_14
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v2, v3, p0}, Lcom/bfrx/MediaController;->setDeviceSettings(JLcom/bfrx/Device;)Z

    move-result v1

    .line 1807
    const-string v2, "CLLOG WIFISETUP setDeviceSettings %s, role %s,device %s, name %s, groupId %s, roomId %s, icon %s, ssid %s, key %s, hashCode %d"

    const/16 v3, 0xa

    new-array v3, v3, [Ljava/lang/Object;

    .line 1808
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x1

    invoke-virtual {p0}, Lcom/bfrx/Device;->getRole()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x2

    iget-wide v4, p0, Lcom/bfrx/Device;->uniqueID:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x3

    invoke-virtual {p0}, Lcom/bfrx/Device;->getMkGroupName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x4

    invoke-virtual {p0}, Lcom/bfrx/Device;->getMkGroupId()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x5

    .line 1809
    invoke-virtual {p0}, Lcom/bfrx/Device;->getMkRoomId()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x6

    invoke-virtual {p0}, Lcom/bfrx/Device;->getMkIconIndex()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x7

    iget-object v4, p0, Lcom/bfrx/Device;->ssid:Ljava/lang/String;

    aput-object v4, v3, v0

    const/16 v0, 0x8

    iget-object v4, p0, Lcom/bfrx/Device;->key:Ljava/lang/String;

    aput-object v4, v3, v0

    const/16 v0, 0x9

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    .line 1807
    invoke-static {v2, v3}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1810
    invoke-static {}, Lmm;->b()V

    move v0, v1

    .line 1811
    goto :goto_13
.end method

.method public static setHandler(Lcom/bfrx/MediaController$PlayStateHandler;)V
    .registers 1

    .prologue
    .line 792
    sput-object p0, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    .line 793
    return-void
.end method

.method public static setInitHandler(Lcom/bfrx/MediaController$NativeHandler;Z)V
    .registers 2

    .prologue
    .line 808
    sput-boolean p1, Lcom/bfrx/MediaController;->mOverride:Z

    .line 809
    sput-object p0, Lcom/bfrx/MediaController;->mNativeHandler:Lcom/bfrx/MediaController$NativeHandler;

    .line 811
    return-void
.end method

.method public static setIsBlackfireRunInSeperateProcess(Z)V
    .registers 1

    .prologue
    .line 265
    sput-boolean p0, Lcom/bfrx/MediaController;->isBlackfireRunInSeperateProcess:Z

    .line 266
    return-void
.end method

.method public static setLossless(I)Z
    .registers 5

    .prologue
    .line 1472
    invoke-static {}, Lmm;->b()V

    .line 1473
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_d

    .line 1474
    const/4 v0, 0x0

    .line 1477
    :goto_c
    return v0

    .line 1475
    :cond_d
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setLossless(JI)Z

    move-result v0

    .line 1476
    invoke-static {}, Lmm;->b()V

    goto :goto_c
.end method

.method private static native setLossless(JI)Z
.end method

.method public static setMeasurementHandler(Lcom/bfrx/MediaController$MeasurementHandler;)V
    .registers 1

    .prologue
    .line 804
    sput-object p0, Lcom/bfrx/MediaController;->mMeasurementHandler:Lcom/bfrx/MediaController$MeasurementHandler;

    .line 805
    return-void
.end method

.method public static setPlaylistHandler(Lcom/bfrx/MediaController$PlaylistHandler;)V
    .registers 1

    .prologue
    .line 796
    sput-object p0, Lcom/bfrx/MediaController;->mPlaylistHandler:Lcom/bfrx/MediaController$PlaylistHandler;

    .line 797
    return-void
.end method

.method public static setSessionFormat(II)Z
    .registers 6

    .prologue
    .line 438
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 439
    const/4 v0, 0x0

    .line 440
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1}, Lcom/bfrx/MediaController;->setSessionFormat(JII)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setSessionFormat(JII)Z
.end method

.method public static setSessionTimeout(I)Z
    .registers 3

    .prologue
    .line 1934
    const/16 v0, 0x12c

    if-le p0, v0, :cond_6

    .line 1935
    const/4 v0, 0x0

    .line 1937
    :goto_5
    return v0

    .line 1936
    :cond_6
    int-to-long v0, p0

    sput-wide v0, Lcom/bfrx/MediaController;->mMaxPcmInterval:J

    .line 1937
    const/4 v0, 0x1

    goto :goto_5
.end method

.method public static setSourceIpAddress(I)Z
    .registers 7

    .prologue
    const/4 v0, 0x0

    .line 393
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 396
    :goto_9
    return v0

    .line 395
    :cond_a
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "java MediaController setSourceIpAddress ip="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 396
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setSourceIpAddress(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setSourceIpAddress(JI)Z
.end method

.method public static setVolume(I)Z
    .registers 7

    .prologue
    const/4 v0, 0x0

    .line 1557
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 1560
    :goto_9
    return v0

    .line 1559
    :cond_a
    const-string v1, "setVolume, value=%d, mHandle=%d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x1

    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1560
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->setVolume(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native setVolume(JI)Z
.end method

.method public static setVolumeById(JI)Z
    .registers 9

    .prologue
    const/4 v0, 0x0

    .line 1564
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0, p1}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " value"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lmm;->a(Ljava/lang/Object;)V

    .line 1565
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_24

    .line 1568
    :goto_23
    return v0

    .line 1567
    :cond_24
    const-string v1, "setVolume, value=%d, mHandle=%l,deviceid=%l"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x1

    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x2

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 1568
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/bfrx/MediaController;->setVolumeById(JJI)Z

    move-result v0

    goto :goto_23
.end method

.method private static native setVolumeById(JJI)Z
.end method

.method public static startSession()Z
    .registers 6

    .prologue
    const/4 v0, 0x0

    .line 448
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 458
    :cond_9
    :goto_9
    return v0

    .line 450
    :cond_a
    invoke-static {}, Llb;->a()J

    move-result-wide v2

    sget v1, Lcom/bfrx/MediaController;->MINIMUM_MEMORY:I

    int-to-long v4, v1

    cmp-long v1, v2, v4

    if-gez v1, :cond_29

    .line 451
    const-string v1, "Java startSession memory error. Requires at least 5mb of free memory."

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 452
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    if-eqz v1, :cond_9

    .line 453
    sget-object v1, Lcom/bfrx/MediaController;->mControlHandler:Lcom/bfrx/MediaController$PlayStateHandler;

    const/4 v2, 0x2

    const-string v3, "Out of Memory. Requires at least 5mb of free memory."

    invoke-interface {v1, v2, v3}, Lcom/bfrx/MediaController$PlayStateHandler;->onSourceError(ILjava/lang/String;)V

    goto :goto_9

    .line 456
    :cond_29
    sget-boolean v1, Lcom/bfrx/MediaController;->mStopping:Z

    if-nez v1, :cond_9

    .line 458
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->startSession(J)Z

    move-result v0

    goto :goto_9
.end method

.method private static native startSession(J)Z
.end method

.method public static stop()V
    .registers 2

    .prologue
    .line 734
    const-string v0, "MediaController stop"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 735
    sget-object v0, Lcom/bfrx/MediaController;->latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v1, Lcom/bfrx/MediaController$4;

    invoke-direct {v1}, Lcom/bfrx/MediaController$4;-><init>()V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 743
    sget-object v0, Lcom/bfrx/MediaController;->latestStopPlayCommand:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0}, Lcom/bfrx/MediaController;->runNextTask(Ljava/util/concurrent/atomic/AtomicReference;)V

    .line 744
    return-void
.end method

.method protected static native stopPlaying(J)Z
.end method

.method private static stopSync()Z
    .registers 6

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 747
    invoke-static {}, Lmm;->b()V

    .line 748
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_e

    .line 766
    :goto_d
    return v0

    .line 750
    :cond_e
    sput-boolean v0, Lcom/bfrx/MediaController;->mDiscontinuity:Z

    .line 751
    sput-boolean v1, Lcom/bfrx/MediaController;->mStopping:Z

    .line 752
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v2, v3}, Lcom/bfrx/MediaController;->stopPlaying(J)Z

    .line 753
    sget-object v2, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    if-eqz v2, :cond_3e

    .line 754
    sget-object v2, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v2}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2f

    sget-object v2, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v2}, Lcom/bfrx/MediaItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_32

    .line 755
    :cond_2f
    invoke-static {}, Lcom/bfrx/MediaController;->endSession()Z

    .line 756
    :cond_32
    sget-object v2, Lcom/bfrx/MediaController;->mMedia:Lcom/bfrx/MediaItem;

    invoke-virtual {v2, v0}, Lcom/bfrx/MediaItem;->setPlaying(Z)V

    .line 757
    const-string v2, "java stop(): media stopped"

    new-array v3, v0, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 763
    :cond_3e
    sput-boolean v0, Lcom/bfrx/MediaController;->mStopping:Z

    .line 764
    sput-wide v4, Lcom/bfrx/MediaController;->mStartPlayTime:J

    .line 765
    invoke-static {}, Lmm;->b()V

    move v0, v1

    .line 766
    goto :goto_d
.end method

.method public static toggleGroup(I)Z
    .registers 5

    .prologue
    .line 1641
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1642
    const/4 v0, 0x0

    .line 1643
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, p0}, Lcom/bfrx/MediaController;->toggleGroup(JI)Z

    move-result v0

    goto :goto_9
.end method

.method private static native toggleGroup(JI)Z
.end method

.method private static native toggleStopPlay(JZ)V
.end method

.method private static native volumeChangeAll(JI)Z
.end method

.method public static volumeChangeDevice(I)Z
    .registers 9

    .prologue
    const/4 v0, 0x0

    .line 1593
    .line 1594
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 1605
    :goto_9
    return v0

    .line 1597
    :cond_a
    sget-object v1, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gtz v1, :cond_17

    .line 1598
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v2, v3, p0}, Lcom/bfrx/MediaController;->volumeChangeAll(JI)Z

    :cond_17
    move v1, v0

    move v2, v0

    .line 1601
    :goto_19
    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_3a

    .line 1602
    sget-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    sget-object v0, Lcom/bfrx/MediaController;->mActiveDevices:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7, p0}, Lcom/bfrx/MediaController;->volumeChangeDevice(JJI)Z

    move-result v0

    .line 1603
    if-nez v0, :cond_36

    move v2, v0

    .line 1601
    :cond_36
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_19

    :cond_3a
    move v0, v2

    .line 1605
    goto :goto_9
.end method

.method private static native volumeChangeDevice(JJI)Z
.end method

.method public static volumeDown()Z
    .registers 4

    .prologue
    .line 1500
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1501
    const/4 v0, 0x0

    .line 1503
    :goto_9
    return v0

    :cond_a
    const/4 v0, -0x1

    invoke-static {v0}, Lcom/bfrx/MediaController;->volumeChangeDevice(I)Z

    move-result v0

    goto :goto_9
.end method

.method private static native volumeDown(J)Z
.end method

.method public static volumeDownAll()Z
    .registers 4

    .prologue
    .line 1520
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1521
    const/4 v0, 0x0

    .line 1522
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->volumeDown(J)Z

    move-result v0

    goto :goto_9
.end method

.method public static volumeDownDevice(J)Z
    .registers 6

    .prologue
    .line 1543
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1544
    const/4 v0, 0x0

    .line 1546
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const/4 v2, -0x5

    invoke-static {v0, v1, p0, p1, v2}, Lcom/bfrx/MediaController;->volumeChangeDevice(JJI)Z

    move-result v0

    goto :goto_9
.end method

.method public static volumeUp()Z
    .registers 4

    .prologue
    .line 1490
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1491
    const/4 v0, 0x0

    .line 1493
    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/bfrx/MediaController;->volumeChangeDevice(I)Z

    move-result v0

    goto :goto_9
.end method

.method private static native volumeUp(J)Z
.end method

.method public static volumeUpAll()Z
    .registers 4

    .prologue
    .line 1510
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1511
    const/4 v0, 0x0

    .line 1512
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1}, Lcom/bfrx/MediaController;->volumeUp(J)Z

    move-result v0

    goto :goto_9
.end method

.method public static volumeUpDevice(J)Z
    .registers 6

    .prologue
    .line 1531
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1532
    const/4 v0, 0x0

    .line 1534
    :goto_9
    return v0

    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    const/4 v2, 0x5

    invoke-static {v0, v1, p0, p1, v2}, Lcom/bfrx/MediaController;->volumeChangeDevice(JJI)Z

    move-result v0

    goto :goto_9
.end method


# virtual methods
.method protected doParentInit()Z
    .registers 2

    .prologue
    .line 379
    const/4 v0, 0x0

    return v0
.end method

.method protected finalize()V
    .registers 3

    .prologue
    .line 401
    const-string v0, "java MediaController finalize called"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 402
    invoke-static {}, Lmq;->b()Lmp;

    move-result-object v0

    new-instance v1, Lcom/bfrx/MediaController$1;

    invoke-direct {v1, p0}, Lcom/bfrx/MediaController$1;-><init>(Lcom/bfrx/MediaController;)V

    invoke-virtual {v0, v1}, Lmp;->execute(Ljava/lang/Runnable;)V

    .line 408
    return-void
.end method

.method protected finish()Z
    .registers 7

    .prologue
    const-wide/16 v4, 0x0

    const/4 v0, 0x0

    .line 411
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v1, v2, v4

    if-nez v1, :cond_a

    .line 419
    :cond_9
    :goto_9
    return v0

    .line 413
    :cond_a
    const-string v1, "java MediaController finish called"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lmm;->b(Ljava/lang/Object;[Ljava/lang/Object;)V

    .line 414
    sget-wide v2, Lcom/bfrx/MediaController;->mHandle:J

    invoke-direct {p0, v2, v3}, Lcom/bfrx/MediaController;->deinit(J)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 415
    sput-boolean v0, Lcom/bfrx/MediaController;->mInitailized:Z

    .line 416
    sput-wide v4, Lcom/bfrx/MediaController;->mHandle:J

    .line 417
    const/4 v0, 0x1

    goto :goto_9
.end method

.method public multicastQueryPrivateData(Ljava/lang/String;)Z
    .registers 6

    .prologue
    const-wide/16 v2, 0x0

    .line 1016
    invoke-static {}, Lmm;->b()V

    .line 1017
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_d

    .line 1018
    const/4 v0, 0x0

    .line 1021
    :goto_c
    return v0

    .line 1019
    :cond_d
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, v2, v3, p1}, Lcom/bfrx/MediaController;->queryPrivateData(JJLjava/lang/String;)Z

    move-result v0

    .line 1020
    invoke-static {}, Lmm;->b()V

    goto :goto_c
.end method

.method public multicastSendPrivateCommand([B)Z
    .registers 6

    .prologue
    const-wide/16 v2, 0x0

    .line 1031
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    .line 1032
    const/4 v0, 0x0

    .line 1035
    :goto_9
    return v0

    .line 1033
    :cond_a
    sget-wide v0, Lcom/bfrx/MediaController;->mHandle:J

    invoke-static {v0, v1, v2, v3, p1}, Lcom/bfrx/MediaController;->sendPrivateByteCommand(JJ[B)Z

    move-result v0

    goto :goto_9
.end method
