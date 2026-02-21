package com.harman.hkconnect.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import defpackage.adw;
import defpackage.adx;
import defpackage.aof;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FOTAToolSetUrlActivity extends Activity implements View.OnClickListener {
    public static String a = "com.harman.hkconnect.setRedbend";
    public static Context i;
    public TextView b;
    public Button c;
    public RadioGroup d;
    public Button e;
    public ListView f;
    public a g;
    public List<adx> h = new ArrayList();
    public adx j = null;
    public byte k = 0;
    public Handler l = new Handler() { // from class: com.harman.hkconnect.ui.FOTAToolSetUrlActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            FOTAToolSetUrlActivity.this.h.removeAll(FOTAToolSetUrlActivity.this.h);
            FOTAToolSetUrlActivity.this.h.addAll(aof.a().f());
            FOTAToolSetUrlActivity.this.g.notifyDataSetChanged();
            System.out.println("-------DeviceTool--------size------>" + FOTAToolSetUrlActivity.this.h.size());
            FOTAToolSetUrlActivity.this.l.sendEmptyMessageDelayed(0, 10000L);
        }
    };
    public b m = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fota_tool_set_url);
        i = this;
        this.b = (TextView) findViewById(R.id.tree_type_value);
        this.c = (Button) findViewById(R.id.query);
        this.c.setOnClickListener(this);
        this.d = (RadioGroup) findViewById(R.id.tree_type);
        this.d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.harman.hkconnect.ui.FOTAToolSetUrlActivity.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (((RadioButton) FOTAToolSetUrlActivity.this.findViewById(radioGroup.getCheckedRadioButtonId())).getText().equals("test type")) {
                    FOTAToolSetUrlActivity.this.k = (byte) 1;
                } else {
                    FOTAToolSetUrlActivity.this.k = (byte) 0;
                }
            }
        });
        this.e = (Button) findViewById(R.id.update);
        this.e.setOnClickListener(this);
        this.f = (ListView) findViewById(R.id.device);
        this.f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.harman.hkconnect.ui.FOTAToolSetUrlActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                FOTAToolSetUrlActivity.this.j = (adx) view.getTag();
                FOTAToolSetUrlActivity.this.g.notifyDataSetChanged();
            }
        });
        this.g = new a();
        this.f.setAdapter((ListAdapter) this.g);
        this.l.sendEmptyMessageDelayed(0, 10000L);
        this.m = new b();
        registerReceiver(this.m, new IntentFilter(a));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.query /* 2131690130 */:
                if (this.j == null) {
                    Toast.makeText(i, "please select one device from mac address list", 0).show();
                } else {
                    adw.a().f(this.j);
                }
                break;
            case R.id.update /* 2131690131 */:
                if (this.j == null) {
                    Toast.makeText(i, "please select one device from mac address list", 0).show();
                } else {
                    adw.a().a(this.j, this.k);
                }
                break;
        }
    }

    class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FOTAToolSetUrlActivity.this.h.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return FOTAToolSetUrlActivity.this.h.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return FOTAToolSetUrlActivity.this.h.get(i).R().uniqueID;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = LayoutInflater.from(FOTAToolSetUrlActivity.i).inflate(R.layout.device_mac_item, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.msg)).setText(FOTAToolSetUrlActivity.this.h.get(i).d());
            viewInflate.setTag(getItem(i));
            if (FOTAToolSetUrlActivity.this.h.get(i) == FOTAToolSetUrlActivity.this.j) {
                viewInflate.setBackgroundColor(267386880);
            }
            return viewInflate;
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getByteExtra("TreeType", (byte) 0) == 0) {
                FOTAToolSetUrlActivity.this.b.setText(FOTAToolSetUrlActivity.this.j.d() + "---is--> production type");
            } else {
                FOTAToolSetUrlActivity.this.b.setText(FOTAToolSetUrlActivity.this.j.d() + "---is--> test type");
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.m);
    }
}
