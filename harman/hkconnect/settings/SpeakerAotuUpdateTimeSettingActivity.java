package com.harman.hkconnect.settings;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.harman.hkconnect.R;
import defpackage.aju;
import defpackage.ajv;
import defpackage.aqb;
import defpackage.mm;
import java.lang.reflect.Field;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class SpeakerAotuUpdateTimeSettingActivity extends aqb {
    Resources m;
    private TextView n;
    private TextView o;
    private aju p;
    private TimePicker s;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aqb, defpackage.gk, defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_update_time_setting);
        l();
        k();
    }

    private void k() {
        this.p = new aju(this, (Toolbar) findViewById(R.id.toolbar), findViewById(R.id.device_auto_update_layout), findViewById(R.id.fullscreen_background), findViewById(R.id.fullscreen_background_tint), findViewById(R.id.toolbar_shadow), findViewById(R.id.content_bg));
        this.p.a(true);
        this.p.a(new ajv.a().d(R.color.settings_toolbar_color).e(getResources().getColor(R.color.white)).a("Auto update time").j(R.color.transparent).c());
    }

    private void l() {
        this.n = (TextView) findViewById(R.id.activity_device_update_time_setting_from_tv);
        this.o = (TextView) findViewById(R.id.activity_device_update_time_setting_to_tv);
        this.s = (TimePicker) findViewById(R.id.activity_device_update_time_setting_timepicker);
        m();
        this.s.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.harman.hkconnect.settings.SpeakerAotuUpdateTimeSettingActivity.1
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                mm.b("hourofDay = %s , minute = %s ", Integer.valueOf(i), Integer.valueOf(i2));
                SpeakerAotuUpdateTimeSettingActivity.this.a(timePicker, i, i2);
            }
        });
    }

    public void a(TimePicker timePicker, int i, int i2) {
        String str = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        if (calendar.get(9) == 0) {
            str = "AM";
        } else if (calendar.get(9) == 1) {
            str = "PM";
            i -= 12;
        }
        this.n.setText("From " + i + ":" + i2 + str);
        this.o.setText("To " + i + ":" + i2 + str);
    }

    @Override // defpackage.ba, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    private void m() {
        this.m = Resources.getSystem();
        int identifier = this.m.getIdentifier("hour", "id", "android");
        int identifier2 = this.m.getIdentifier("minute", "id", "android");
        int identifier3 = this.m.getIdentifier("amPm", "id", "android");
        NumberPicker numberPicker = (NumberPicker) this.s.findViewById(identifier);
        NumberPicker numberPicker2 = (NumberPicker) this.s.findViewById(identifier2);
        NumberPicker numberPicker3 = (NumberPicker) this.s.findViewById(identifier3);
        a(numberPicker);
        a(numberPicker2);
        a(numberPicker3);
    }

    private void a(NumberPicker numberPicker) {
        int childCount = numberPicker.getChildCount();
        int color = getResources().getColor(R.color.white);
        for (int i = 0; i < childCount; i++) {
            View childAt = numberPicker.getChildAt(i);
            try {
                Field declaredField = numberPicker.getClass().getDeclaredField("mSelectorWheelPaint");
                declaredField.setAccessible(true);
                ((Paint) declaredField.get(numberPicker)).setColor(color);
                ((EditText) childAt).setTextColor(color);
                numberPicker.invalidate();
            } catch (IllegalAccessException e) {
                mm.d("setNumberPickerTextColor", e);
            } catch (IllegalArgumentException e2) {
                mm.d("setNumberPickerTextColor", e2);
            } catch (NoSuchFieldException e3) {
                mm.d("setNumberPickerTextColor", e3);
            }
        }
    }
}
