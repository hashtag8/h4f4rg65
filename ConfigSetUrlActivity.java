package com.harman.hkconnect.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.harman.hkconnect.R;
import defpackage.agu;
import defpackage.aho;

/* JADX INFO: loaded from: classes.dex */
public class ConfigSetUrlActivity extends Activity implements View.OnClickListener {
    public RadioGroup a;
    public Handler b = new Handler() { // from class: com.harman.hkconnect.ui.ConfigSetUrlActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Process.killProcess(Process.myPid());
            System.exit(0);
            ConfigSetUrlActivity.this.finish();
        }
    };
    private RadioButton c;
    private RadioButton d;
    private RadioButton e;
    private Button f;
    private int g;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.config_tool_set_url);
        this.c = (RadioButton) findViewById(R.id.product);
        this.d = (RadioButton) findViewById(R.id.beta);
        this.e = (RadioButton) findViewById(R.id.test);
        this.f = (Button) findViewById(R.id.sub_but);
        this.f.setOnClickListener(this);
        int iB = aho.b("ConfigType", 0);
        switch (iB) {
            case 0:
                this.c.setChecked(true);
                break;
            case 1:
                this.d.setChecked(true);
                break;
            case 2:
                this.e.setChecked(true);
                break;
        }
        this.g = iB;
        this.a = (RadioGroup) findViewById(R.id.tree_type);
        this.a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.harman.hkconnect.ui.ConfigSetUrlActivity.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) ConfigSetUrlActivity.this.findViewById(radioGroup.getCheckedRadioButtonId());
                if (radioButton.getText().equals("product url")) {
                    ConfigSetUrlActivity.this.g = 0;
                } else if (radioButton.getText().equals("beta url")) {
                    ConfigSetUrlActivity.this.g = 1;
                } else if (radioButton.getText().equals("test url")) {
                    ConfigSetUrlActivity.this.g = 2;
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The app will shut down!");
        builder.setTitle("Tips");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.ConfigSetUrlActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                aho.a("ConfigType", ConfigSetUrlActivity.this.g);
                agu.b(ConfigSetUrlActivity.this);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.ui.ConfigSetUrlActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
