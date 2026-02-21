package defpackage;

import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.ti;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class aql extends aqo {
    @Override // defpackage.aqo
    public void a(int i, MusicData musicData) {
        tk tkVarG;
        if (musicData != null && (tkVarG = g()) != null) {
            tkVarG.a((Map<String, String>) new ti.a().a(i == 0 ? "Play Song - Local Device" : "Play Song - Speaker").b("Source - " + MusicData.getPlayType(musicData.type)).a());
        }
    }

    @Override // defpackage.aqo
    public void a() {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Room Configuration").b("Device Disconnected").a());
        }
    }

    @Override // defpackage.aqo
    public void a(String str, String str2, int i) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Setup Room - Failure").b("Channel Type - " + str).c("Method - " + str2).a(i).a());
        }
    }

    @Override // defpackage.aqo
    public void b(String str, String str2, int i) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Setup Room - Success").b("Channel Type - " + str).c("Method - " + str2).a(i).a());
        }
    }

    @Override // defpackage.aqo
    public void a(String str, int i) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Troubleshooting").b("Channel Type - " + str).c("Number of Occurrences").a(i).a());
        }
    }

    @Override // defpackage.aqo
    public void a(String str, String str2) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Changed Music Service").b(str).c(str2).a());
        }
    }

    @Override // defpackage.aqo
    public void b() {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a("Tutorial");
            tkVarG.a((Map<String, String>) new ti.c().a());
        }
    }

    @Override // defpackage.aqo
    public void a(int i) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) ((ti.a) new ti.a().a(1, "" + i).a(1, i)).a());
        }
    }

    @Override // defpackage.aqo
    public void c() {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a("Queue Screen");
            tkVarG.a((Map<String, String>) new ti.c().a());
        }
    }

    @Override // defpackage.aqo
    public void a(String str) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a("Music service opened - " + str);
            tkVarG.a((Map<String, String>) new ti.c().a());
        }
    }

    @Override // defpackage.aqo
    public void d() {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a("Settings Page");
            tkVarG.a((Map<String, String>) new ti.c().a());
        }
    }

    @Override // defpackage.aqo
    public void e() {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a("Full Screen Player");
            tkVarG.a((Map<String, String>) new ti.c().a());
        }
    }

    @Override // defpackage.aqo
    public void b(int i) {
        tk tkVarG = g();
        if (tkVarG != null) {
            tkVarG.a((Map<String, String>) new ti.a().a("Room Configuration").b("Linking").c("Number of Speakers").a(i).a());
        }
    }

    private tk g() {
        mj mjVarA = HarmanApplication.a();
        if (mjVarA == null) {
            return null;
        }
        try {
            return th.a(mjVarA).a("UA-46614088-19");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
