package defpackage;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class aii implements Cursor {
    private final Cursor a;

    public aii(Cursor cursor) {
        this.a = cursor;
    }

    @Override // android.database.Cursor
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getCount();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getPosition();
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        if (this.a == null) {
            return false;
        }
        return this.a.move(i);
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        if (this.a == null) {
            return false;
        }
        return this.a.moveToPosition(i);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        if (this.a == null) {
            return false;
        }
        return this.a.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        if (this.a == null) {
            return false;
        }
        return this.a.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        if (this.a == null) {
            return false;
        }
        return this.a.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        if (this.a == null) {
            return false;
        }
        return this.a.moveToPrevious();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        if (this.a == null) {
            return false;
        }
        return this.a.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        if (this.a == null) {
            return false;
        }
        return this.a.isLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        if (this.a == null) {
            return false;
        }
        return this.a.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        if (this.a == null) {
            return false;
        }
        return this.a.isAfterLast();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.a == null) {
            return 0;
        }
        return this.a.getColumnIndex(str);
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        if (this.a == null) {
            return 0;
        }
        return this.a.getColumnIndexOrThrow(str);
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        return this.a == null ? "" : this.a.getColumnName(i);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return this.a == null ? new String[1] : this.a.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getColumnCount();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        return this.a == null ? new byte[1] : this.a.getBlob(i);
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        if (this.a == null) {
            return "";
        }
        try {
            String string = this.a.getString(i);
            return string == null ? "" : string;
        } catch (RuntimeException e) {
            new ml().a("Bad index " + i, e);
            return "";
        }
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        if (this.a != null) {
            this.a.copyStringToBuffer(i, charArrayBuffer);
        }
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        if (this.a == null) {
            return (short) 0;
        }
        return this.a.getShort(i);
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        if (this.a == null) {
            return 0;
        }
        return this.a.getInt(i);
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        if (this.a == null) {
            return 0L;
        }
        return this.a.getLong(i);
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        if (this.a == null) {
            return 0.0f;
        }
        return this.a.getFloat(i);
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        if (this.a == null) {
            return 0.0d;
        }
        return this.a.getDouble(i);
    }

    @Override // android.database.Cursor
    public int getType(int i) {
        if (this.a == null) {
            return 0;
        }
        return this.a.getType(i);
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        if (this.a == null) {
            return false;
        }
        return this.a.isNull(i);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        if (this.a != null) {
            this.a.deactivate();
        }
    }

    @Override // android.database.Cursor
    public boolean requery() {
        if (this.a == null) {
            return false;
        }
        return this.a.requery();
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.a != null) {
            this.a.close();
        }
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        if (this.a == null) {
            return true;
        }
        return this.a.isClosed();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        if (this.a != null) {
            this.a.registerContentObserver(contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (this.a != null) {
            this.a.unregisterContentObserver(contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        if (this.a != null) {
            this.a.setNotificationUri(contentResolver, uri);
        }
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        if (this.a == null) {
            return null;
        }
        return this.a.getNotificationUri();
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        if (this.a == null) {
            return false;
        }
        return this.a.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        if (this.a == null) {
            return null;
        }
        return this.a.getExtras();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        if (this.a == null) {
            return null;
        }
        return this.a.respond(bundle);
    }
}
