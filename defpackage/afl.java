package defpackage;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class afl extends CursorWrapper {
    private String a;
    private ArrayList<Integer> b;
    private int c;
    private int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public afl(Cursor cursor, String str) {
        super(cursor);
        this.b = new ArrayList<>();
        this.c = 0;
        this.d = 0;
        this.a = str.toLowerCase();
        if (this.a != "") {
            this.c = super.getCount();
            this.b.clear();
            ArrayList arrayList = new ArrayList();
            int columnIndex = getColumnIndex("title");
            int columnIndex2 = getColumnIndex("artist");
            int columnIndex3 = getColumnIndex("album");
            int columnIndex4 = getColumnIndex("name");
            if (columnIndex > -1) {
                arrayList.add(Integer.valueOf(columnIndex));
            }
            if (columnIndex2 > -1) {
                arrayList.add(Integer.valueOf(columnIndex2));
            }
            if (columnIndex3 > -1) {
                arrayList.add(Integer.valueOf(columnIndex3));
            }
            if (columnIndex4 > -1) {
                arrayList.add(Integer.valueOf(columnIndex4));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                for (int i = 0; i < this.c; i++) {
                    super.moveToPosition(i);
                    String string = getString(iIntValue);
                    if (string != null && string.toLowerCase().contains(this.a) && !this.b.contains(Integer.valueOf(i))) {
                        this.b.add(Integer.valueOf(i));
                        this.d++;
                    }
                }
            }
            this.c = this.d;
            this.d = 0;
            super.moveToFirst();
            return;
        }
        this.c = super.getCount();
        this.b.clear();
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.add(Integer.valueOf(i2));
            this.d++;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean move(int i) {
        return moveToPosition(this.d + i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToNext() {
        return moveToPosition(this.d + 1);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPrevious() {
        return moveToPosition(this.d - 1);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToLast() {
        return moveToPosition(this.c - 1);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPosition(int i) {
        if (i >= this.c || i < 0) {
            return false;
        }
        this.d = i;
        return super.moveToPosition(this.b.get(i).intValue());
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getCount() {
        return this.c;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getPosition() {
        return this.d;
    }
}
