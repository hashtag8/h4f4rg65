package com.harman.commom.music.player.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.musicservice.musicserver.nokia.NokiaMusicData;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioMusicData;
import defpackage.ahk;
import defpackage.ain;
import defpackage.aof;
import defpackage.ayf;
import defpackage.ml;
import defpackage.mm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PlayList implements Parcelable {
    private List<MusicData> b;
    private List<MusicData> c;
    private List<MusicData> d;
    private int e;
    private a f;
    public static int a = 0;
    public static final Parcelable.Creator<PlayList> CREATOR = new Parcelable.Creator<PlayList>() { // from class: com.harman.commom.music.player.service.PlayList.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayList createFromParcel(Parcel parcel) {
            return new PlayList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayList[] newArray(int i) {
            return new PlayList[i];
        }
    };

    public interface a {
        void a();
    }

    public PlayList() {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = -1;
    }

    public PlayList(Parcel parcel) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = -1;
        this.b = parcel.readArrayList(null);
    }

    public void a(MusicData musicData) {
        if (musicData instanceof NokiaMusicData) {
            int iA = a(this.b);
            int iA2 = a(this.c);
            if (iA != -1) {
                c(iA);
                this.b.add(iA, musicData);
                this.c.add(iA2, musicData);
                return;
            }
        }
        this.b.add(musicData);
        this.c.add(musicData);
        i();
    }

    public void a(int i, int i2) {
        if (i == this.e) {
            this.e = i2;
        } else if (i < this.e && i2 >= this.e) {
            this.e--;
        } else if (i > this.e && i2 <= this.e) {
            this.e++;
        }
        if (this.b.equals(this.c)) {
            this.c.add(i2, this.c.remove(i));
        }
        this.b.add(i2, this.b.remove(i));
    }

    public void a(boolean z) {
        if (this.e != -1) {
            if (this.e >= this.b.size()) {
                new ml().a("Play position for shuffling was out of bounds");
                return;
            }
            if (this.b.size() > 1) {
                if (z) {
                    this.b.clear();
                    this.b = g();
                    MusicData musicDataRemove = this.b.remove(this.e);
                    Collections.shuffle(this.b);
                    this.b.add(0, musicDataRemove);
                    this.e = 0;
                } else {
                    MusicData musicData = this.b.get(this.e);
                    this.b.clear();
                    this.b = g();
                    this.e = this.b.indexOf(musicData);
                }
            }
            i();
        }
    }

    private List<MusicData> g() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.c.size(); i++) {
            arrayList.add(this.c.get(i));
        }
        return arrayList;
    }

    public int a(List<MusicData> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof NokiaMusicData) {
                return i;
            }
        }
        return -1;
    }

    public void a(int i, MusicData musicData) {
        if (musicData instanceof NokiaMusicData) {
            int iA = a(this.b);
            int iA2 = a(this.c);
            if (iA != -1 && iA2 != -1) {
                c(iA);
                this.c.add(iA2, musicData);
                this.b.add(iA, musicData);
                e(iA - 1);
                return;
            }
        }
        this.c.add(i, musicData);
        this.b.add(i, musicData);
        i();
    }

    public void a(int i, List<MusicData> list, int i2) {
        this.c.addAll(i, list);
        this.b.addAll(i, a(list, i2));
        i();
    }

    public void a(int i, List<MusicData> list) {
        a(i, list, -1);
    }

    public void b(List<MusicData> list) {
        a(this.c.size(), list);
    }

    private List<MusicData> a(List<MusicData> list, int i) {
        if (MusicPlaylistManager.a().e() == 1) {
            ArrayList arrayList = new ArrayList(list);
            if (i < 0) {
                Collections.shuffle(arrayList);
            } else {
                MusicData musicData = (MusicData) arrayList.remove(i);
                Collections.shuffle(arrayList);
                arrayList.add(0, musicData);
            }
            return arrayList;
        }
        return list;
    }

    public boolean a(int i, boolean z) {
        return a(i, z, 0);
    }

    private boolean a(int i, boolean z, int i2) {
        if (this.b == null || this.b.size() <= 0 || this.e >= this.b.size()) {
            return false;
        }
        if (this.e >= 0 && this.e < this.b.size() && (this.b.get(this.e) instanceof MixRadioMusicData) && !aof.a().l()) {
            MixRadioMusicData mixRadioMusicData = (MixRadioMusicData) this.b.get(this.e);
            final String str = "" + mixRadioMusicData.a(mixRadioMusicData.e()).songId;
            new Thread(new Runnable() { // from class: com.harman.commom.music.player.service.PlayList.1
                @Override // java.lang.Runnable
                public void run() {
                    ayf.a().a("" + str, "stop", false);
                }
            }).start();
            if (mixRadioMusicData.a(mixRadioMusicData.e()) instanceof MixRadioAdvertData) {
                MixRadioAdvertData mixRadioAdvertData = (MixRadioAdvertData) mixRadioMusicData.a(mixRadioMusicData.e());
                long jT = MusicPlaylistManager.a().t();
                long j = mixRadioAdvertData.duration;
                if (mixRadioAdvertData.a.containsKey("start")) {
                    ayf.a().a(mixRadioAdvertData.a.get("start"));
                }
                if (!z) {
                    if (mixRadioAdvertData.a.containsKey("firstQuartile")) {
                        ayf.a().a(mixRadioAdvertData.a.get("firstQuartile"));
                    }
                    if (mixRadioAdvertData.a.containsKey("midpoint")) {
                        ayf.a().a(mixRadioAdvertData.a.get("midpoint"));
                    }
                    if (mixRadioAdvertData.a.containsKey("thirdQuartile")) {
                        ayf.a().a(mixRadioAdvertData.a.get("thirdQuartile"));
                    }
                    if (mixRadioAdvertData.a.containsKey("complete")) {
                        ayf.a().a(mixRadioAdvertData.a.get("complete"));
                    }
                } else {
                    int i3 = (int) (j / 4);
                    int i4 = (int) (j / 2);
                    if (jT >= i3 && mixRadioAdvertData.a.containsKey("firstQuartile")) {
                        ayf.a().a(mixRadioAdvertData.a.get("firstQuartile"));
                    }
                    if (jT >= i4 && mixRadioAdvertData.a.containsKey("midpoint")) {
                        ayf.a().a(mixRadioAdvertData.a.get("midpoint"));
                    }
                    if (jT >= i4 + i3 && mixRadioAdvertData.a.containsKey("thirdQuartile")) {
                        ayf.a().a(mixRadioAdvertData.a.get("thirdQuartile"));
                    }
                }
            }
            if (!z) {
                ayf.a().a(1, false, true);
            }
        }
        if (i2 == this.b.size()) {
            return false;
        }
        if (this.e >= 0 && (this.b.get(this.e) instanceof RadioMusicData) && aof.a().k() && !aof.a().l()) {
            return ((RadioMusicData) this.b.get(this.e)).a();
        }
        if (i == 2) {
            if (this.b != null && this.b.size() > 0) {
                if (this.e == this.b.size() - 1) {
                    this.e = 0;
                } else {
                    this.e++;
                }
            }
        } else if (i == 1) {
            if (this.b != null && this.b.size() > 0) {
                if (this.e == this.b.size() - 1) {
                    if (z) {
                        this.e = 0;
                    }
                } else if (z) {
                    this.e++;
                }
            }
        } else if (i == 0) {
            if (this.b != null && this.b.size() > 0) {
                if (this.e == this.b.size() - 1) {
                    if (!z) {
                        return false;
                    }
                    this.e = 0;
                } else {
                    this.e++;
                }
            }
        } else if (i == 3) {
            List<MusicData> listH = h();
            listH.removeAll(this.d);
            if (listH.size() == 0) {
                this.d.clear();
                listH = h();
            }
            MusicData musicData = listH.get(ahk.a(listH.size()));
            this.d.add(musicData);
            this.e = this.b.indexOf(musicData);
        }
        if (this.e > this.b.size() - 1 || this.e < 0) {
            return false;
        }
        if (a >= a()) {
            mm.b("burning overnight4", new Object[0]);
            return false;
        }
        if (aof.a().k() && aof.a().l() && b(this.e).type != 1 && !ain.j) {
            a(i, z, i2 + 1);
        }
        return true;
    }

    private List<MusicData> h() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.b.size(); i++) {
            arrayList.add(this.b.get(i));
        }
        return arrayList;
    }

    public boolean a(int i) {
        if (i == 2) {
            if (this.b != null && this.b.size() > 0) {
                if (this.e > 0) {
                    this.e--;
                } else {
                    this.e = this.b.size() - 1;
                }
            }
        } else if (i == 1 || i == 0) {
            if (this.b != null && this.b.size() > 0) {
                if (this.e <= 0) {
                    return true;
                }
                this.e--;
            }
        } else if (i == 3) {
            List<MusicData> listH = h();
            listH.removeAll(this.d);
            if (listH.size() == 0) {
                this.d.clear();
                listH = h();
            }
            MusicData musicData = listH.get(ahk.a(listH.size()));
            this.d.add(musicData);
            this.e = this.b.indexOf(musicData);
        }
        if (this.e > this.b.size() - 1 || this.e < 0) {
            return false;
        }
        if (aof.a().k() && aof.a().l() && b(this.e).type != 1) {
            a(i);
        }
        return true;
    }

    public int a() {
        return this.b.size();
    }

    public void b() {
        this.b.clear();
        this.c.clear();
        this.e = -1;
    }

    public MusicData b(int i) {
        MusicData musicData = this.b.get(i);
        return musicData instanceof RadioMusicData ? ((RadioMusicData) musicData).d() : this.b.get(i);
    }

    public List<MusicData> c() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public int b(MusicData musicData) {
        return this.b.indexOf(musicData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.b);
    }

    public void a(ArrayList<Integer> arrayList) {
        int iIndexOf;
        Iterator<MusicData> it = this.b.iterator();
        while (it.hasNext()) {
            MusicData next = it.next();
            if (arrayList.contains(Integer.valueOf(next.type)) && (iIndexOf = this.b.indexOf(next)) >= 0 && iIndexOf < this.b.size()) {
                if (iIndexOf < this.e) {
                    this.e--;
                } else if (iIndexOf == this.e) {
                    if (iIndexOf == a() - 1) {
                        this.e = 0;
                    }
                    it.remove();
                    this.c.remove(next);
                }
                it.remove();
                this.c.remove(next);
            }
        }
        if (this.c.isEmpty()) {
            MusicPlaylistManager.a().o();
        }
    }

    public void c(int i) {
        if (i >= 0 && i < this.b.size()) {
            this.c.remove(this.b.remove(i));
        }
    }

    public boolean d(int i) {
        if (i >= 0 && i < this.b.size()) {
            if (i < this.e) {
                this.e--;
            } else if (i == this.e) {
                if (i == a() - 1) {
                    this.e = 0;
                }
                this.c.remove(this.b.remove(i));
                return true;
            }
            this.c.remove(this.b.remove(i));
        }
        return false;
    }

    public boolean d() {
        return this.b.isEmpty();
    }

    public MusicData e() {
        if (this.e > -1 && this.b != null && this.b.size() > 0 && this.e < this.b.size()) {
            MusicData musicData = this.b.get(this.e);
            if (musicData instanceof RadioMusicData) {
                return ((RadioMusicData) musicData).d();
            }
            return this.b.get(this.e);
        }
        return null;
    }

    public boolean e(int i) {
        if (this.e == i && i != 0) {
            return false;
        }
        this.e = i;
        return true;
    }

    public int f() {
        return this.e;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    private void i() {
        if (this.f != null) {
            this.f.a();
        }
    }
}
