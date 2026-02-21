package defpackage;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.harman.hkconnect.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class aub extends az {
    Dialog ae = null;
    private ail af;
    private Spinner ag;

    public enum a {
        WIFI_LIST,
        WIFI_LEVEL_LIST
    }

    public enum b {
        SSID,
        PASSWORD
    }

    public static aub al() {
        return new aub();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        brw.a(l(), "arguments", new Object[0]);
        ArrayList<String> stringArrayList = l().getStringArrayList(a.WIFI_LIST.name());
        ArrayList<Integer> integerArrayList = l().getIntegerArrayList(a.WIFI_LEVEL_LIST.name());
        brw.a(stringArrayList, a.WIFI_LIST.name(), new Object[0]);
        brw.a(integerArrayList, a.WIFI_LEVEL_LIST.name(), new Object[0]);
        View viewInflate = layoutInflater.inflate(R.layout.dialog_productsetup_network_input, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.password_input);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.id_dialog_checkbox);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.id_dialog_checkbox_save_password);
        if (aho.b("KEY_SHOW_AND_SAVE_THE_WIFI_PASSWORD", false)) {
            checkBox.setChecked(true);
            checkBox2.setVisibility(0);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: aub.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    editText.setInputType(Allocation.USAGE_SHARED);
                } else {
                    editText.setInputType(129);
                }
                editText.setSelection(editText.length());
            }
        });
        this.ag = (Spinner) viewInflate.findViewById(R.id.wifi_spinner);
        ba baVarP = n().p();
        if (baVarP == null || baVarP.isFinishing()) {
            return null;
        }
        String strB = ahx.a().b();
        int iIndexOf = stringArrayList.indexOf(strB);
        mm.b("@@@@@@ index = " + iIndexOf, new Object[0]);
        if (iIndexOf < 0) {
            mm.b("@@@@@@ ######can't show default ssid", new Object[0]);
            stringArrayList.add(0, strB);
            integerArrayList.add(0, Integer.valueOf(ahx.a().c()));
        }
        this.af = new ail(baVarP, stringArrayList, integerArrayList);
        mm.b("@@@@@@currentWifi = " + strB, new Object[0]);
        this.ag.setAdapter((SpinnerAdapter) this.af);
        if (strB != null) {
            String strReplace = strB.replace("\"", "");
            this.af.a(strReplace);
            int iIndexOf2 = stringArrayList.indexOf(strReplace);
            mm.b("@@@@@@ index2 = " + iIndexOf2, new Object[0]);
            if (iIndexOf2 < 0) {
                mm.b("@@@@@@ ######2can't show default ssid", new Object[0]);
            } else {
                this.ag.setSelection(iIndexOf2);
            }
        }
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: aub.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    aho.e((String) aub.this.ag.getSelectedItem());
                    editText.setText("");
                } else if (editText.getText().toString().trim().isEmpty() && ((String) aub.this.ag.getSelectedItem()) != null) {
                    editText.setText(aho.d((String) aub.this.ag.getSelectedItem()));
                    editText.setInputType(Allocation.USAGE_SHARED);
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: aub.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!editText.getText().toString().trim().isEmpty() && ((String) aub.this.ag.getSelectedItem()) != null) {
                    aho.a((String) aub.this.ag.getSelectedItem(), editText.getText().toString().trim());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        if (editText.getText().toString().trim().isEmpty() && ((String) this.ag.getSelectedItem()) != null && aho.b("KEY_SHOW_AND_SAVE_THE_WIFI_PASSWORD", false)) {
            editText.setText(aho.d((String) this.ag.getSelectedItem()));
            editText.setInputType(Allocation.USAGE_SHARED);
        }
        this.ag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: aub.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == aub.this.af.getCount() - 1) {
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        viewInflate.findViewById(R.id.id_dialog_okbtn).setOnClickListener(new View.OnClickListener() { // from class: aub.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aub.this.b();
                String strTrim = editText.getText().toString().trim();
                String str = (String) aub.this.ag.getSelectedItem();
                Intent intent = new Intent();
                intent.putExtra(b.SSID.name(), str);
                intent.putExtra(b.PASSWORD.name(), strTrim);
                aub.this.n().a(aub.this.o(), -1, intent);
            }
        });
        viewInflate.findViewById(R.id.id_dialog_cancelbtn).setOnClickListener(new View.OnClickListener() { // from class: aub.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aub.this.n().a(aub.this.o(), 0, (Intent) null);
                aub.this.b();
            }
        });
        b(false);
        d().setTitle(R.string.wifisetup_Permissions_dialog_title);
        return viewInflate;
    }
}
