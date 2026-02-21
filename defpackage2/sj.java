package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sj {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object c = new Object();
    private static sj d;
    private final a b;

    public class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(sj.a);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            su.c("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    sj(Context context) {
        this.b = new a(context, "google_inapp_purchase.db");
    }

    public static sj a(Context context) {
        sj sjVar;
        synchronized (c) {
            if (d == null) {
                d = new sj(context);
            }
            sjVar = d;
        }
        return sjVar;
    }

    public SQLiteDatabase a() {
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            su.e("Error opening writable conversion tracking database");
            return null;
        }
    }

    public si a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new si(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void a(si siVar) {
        if (siVar == null) {
            return;
        }
        synchronized (c) {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.delete("InAppPurchase", String.format("%s = %d", "purchase_id", Long.valueOf(siVar.a)), null);
            }
        }
    }

    public int b() {
        Cursor cursorRawQuery = null;
        int i = 0;
        synchronized (c) {
            SQLiteDatabase sQLiteDatabaseA = a();
            try {
                if (sQLiteDatabaseA != null) {
                    try {
                        cursorRawQuery = sQLiteDatabaseA.rawQuery("select count(*) from InAppPurchase", null);
                        if (cursorRawQuery.moveToFirst()) {
                            i = cursorRawQuery.getInt(0);
                        } else if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (SQLiteException e) {
                        su.e("Error getting record count" + e.getMessage());
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        return i;
    }

    public void b(si siVar) {
        if (siVar == null) {
            return;
        }
        synchronized (c) {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_id", siVar.c);
            contentValues.put("developer_payload", siVar.b);
            contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
            siVar.a = sQLiteDatabaseA.insert("InAppPurchase", null, contentValues);
            if (b() > 20000) {
                c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x0031, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002c, B:15:0x002f, B:28:0x005a, B:29:0x005d, B:24:0x0052), top: B:34:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r11 = this;
            r9 = 0
            java.lang.Object r10 = defpackage.sj.c
            monitor-enter(r10)
            android.database.sqlite.SQLiteDatabase r0 = r11.a()     // Catch: java.lang.Throwable -> L31
            if (r0 != 0) goto Lc
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
        Lb:
            return
        Lc:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.database.sqlite.SQLiteException -> L34 java.lang.Throwable -> L56
            if (r1 == 0) goto L2a
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r0 == 0) goto L2a
            si r0 = r11.a(r1)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            r11.a(r0)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
        L2a:
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.lang.Throwable -> L31
        L2f:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
            goto Lb
        L31:
            r0 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L31
            throw r0
        L34:
            r0 = move-exception
            r1 = r9
        L36:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r2.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L5e
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5e
            defpackage.su.e(r0)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.lang.Throwable -> L31
            goto L2f
        L56:
            r0 = move-exception
            r1 = r9
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Throwable -> L31
        L5d:
            throw r0     // Catch: java.lang.Throwable -> L31
        L5e:
            r0 = move-exception
            goto L58
        L60:
            r0 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sj.c():void");
    }
}
