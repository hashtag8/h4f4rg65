package com.harman.hkconnect.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.harman.hkconnect.R;
import defpackage.agu;
import defpackage.aho;

/* JADX INFO: loaded from: classes.dex */
public class ToolActivity extends Activity implements View.OnClickListener {
    public Button a;
    public Button b;
    private CheckBox c;
    private CheckBox d;
    private CheckBox e;
    private CheckBox f;
    private CheckBox g;
    private CheckBox h;
    private CheckBox i;
    private CheckBox j;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.too_activity);
        this.a = (Button) findViewById(R.id.fota);
        this.a.setOnClickListener(this);
        this.b = (Button) findViewById(R.id.config);
        this.b.setOnClickListener(this);
        this.c = (CheckBox) findViewById(R.id.setup_all_speakers);
        this.c.setOnClickListener(this);
        this.c.setChecked(aho.b("KEY_SETUP_ALL_SPEAKERS", true));
        this.d = (CheckBox) findViewById(R.id.enter_demo_mode);
        this.d.setOnClickListener(this);
        this.d.setChecked(aho.b("KEY_ENTER_DEMO_MODE", false));
        this.g = (CheckBox) findViewById(R.id.show_and_save_the_wifi_password);
        this.g.setOnClickListener(this);
        this.g.setChecked(aho.b("KEY_SHOW_AND_SAVE_THE_WIFI_PASSWORD", false));
        this.h = (CheckBox) findViewById(R.id.show_the_device_ip_in_drag_page);
        this.h.setOnClickListener(this);
        this.h.setChecked(aho.b("KEY_SHOW_THE_DEVICE_INFO_IN_DASHBOARD", false));
        this.e = (CheckBox) findViewById(R.id.show_dlna);
        this.e.setVisibility(8);
        this.e.setOnClickListener(this);
        this.e.setChecked(aho.b("KEY_SHOW_DLNA", false));
        this.i = (CheckBox) findViewById(R.id.show_device_reset);
        this.i.setOnClickListener(this);
        this.i.setChecked(aho.b("KEY_SHOW_DEVICE_RESET", false));
        this.j = (CheckBox) findViewById(R.id.show_room_type_in_room_name);
        this.j.setOnClickListener(this);
        this.j.setChecked(aho.b("KEY_SHOW_ROOM_TYPE_IN_ROOM_NAME", false));
        this.f = (CheckBox) findViewById(R.id.show_original_code);
        this.f.setOnClickListener(this);
        this.f.setChecked(aho.b("KEY_SHOW_ORIGINAL_CODE", false));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enter_demo_mode /* 2131691156 */:
                if (this.d.isChecked()) {
                    aho.a("KEY_ENTER_DEMO_MODE", true);
                } else {
                    aho.a("KEY_ENTER_DEMO_MODE", false);
                }
                break;
            case R.id.fota /* 2131691157 */:
                startActivity(new Intent().setClass(this, FOTAToolSetUrlActivity.class));
                break;
            case R.id.config /* 2131691158 */:
                startActivity(new Intent().setClass(this, ConfigSetUrlActivity.class));
                finish();
                break;
            case R.id.setup_all_speakers /* 2131691159 */:
                if (this.c.isChecked()) {
                    aho.a("KEY_SETUP_ALL_SPEAKERS", true);
                } else {
                    aho.a("KEY_SETUP_ALL_SPEAKERS", false);
                }
                break;
            case R.id.show_and_save_the_wifi_password /* 2131691160 */:
                if (this.g.isChecked()) {
                    aho.a("KEY_SHOW_AND_SAVE_THE_WIFI_PASSWORD", true);
                } else {
                    aho.a("KEY_SHOW_AND_SAVE_THE_WIFI_PASSWORD", false);
                }
                break;
            case R.id.show_the_device_ip_in_drag_page /* 2131691161 */:
                if (this.h.isChecked()) {
                    aho.a("KEY_SHOW_THE_DEVICE_INFO_IN_DASHBOARD", true);
                } else {
                    aho.a("KEY_SHOW_THE_DEVICE_INFO_IN_DASHBOARD", false);
                }
                break;
            case R.id.show_device_reset /* 2131691162 */:
                if (this.i.isChecked()) {
                    aho.a("KEY_SHOW_DEVICE_RESET", true);
                } else {
                    aho.a("KEY_SHOW_DEVICE_RESET", false);
                }
                break;
            case R.id.show_room_type_in_room_name /* 2131691163 */:
                if (this.j.isChecked()) {
                    aho.a("KEY_SHOW_ROOM_TYPE_IN_ROOM_NAME", true);
                } else {
                    aho.a("KEY_SHOW_ROOM_TYPE_IN_ROOM_NAME", false);
                }
                break;
            case R.id.show_dlna /* 2131691164 */:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("The app will shut down!");
                builder.setTitle("Tips");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.ToolActivity.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (ToolActivity.this.e.isChecked()) {
                            aho.a("KEY_SHOW_DLNA", true);
                        } else {
                            aho.a("KEY_SHOW_DLNA", false);
                            aho.a("MOST_RECENT_SERVICE", 100);
                        }
                        agu.b(ToolActivity.this);
                    }
                });
                builder.create().show();
                break;
            case R.id.show_original_code /* 2131691165 */:
                if (this.f.isChecked()) {
                    aho.a("KEY_SHOW_ORIGINAL_CODE", true);
                } else {
                    aho.a("KEY_SHOW_ORIGINAL_CODE", false);
                }
                break;
        }
    }
}
