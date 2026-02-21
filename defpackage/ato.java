package defpackage;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.harman.hkconnect.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ato extends atm {
    Resources a;
    private TextView b;
    private TimePicker c;

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_fota_updated_time_pickup, (ViewGroup) null);
        this.b = (TextView) viewInflate.findViewById(R.id.timerpick_from);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: ato.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ato.this.an();
                ato.this.am();
            }
        });
        this.c = (TimePicker) viewInflate.findViewById(R.id.timer_controls);
        ao();
        an();
        return viewInflate;
    }

    private void al() {
        this.b.setText(a(R.string.FotaSilenceFrom) + e().l().b());
        mm.b("TEST_DATE onshow get value fromvalue  = %s", this.b.getText().toString());
        am();
        this.c.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: ato.2
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, final int i, final int i2) {
                mo.a.a(new Runnable() { // from class: ato.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ato.this.b(ato.this.e().l().a(i, i2));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        int[] iArrC = e().l().c();
        if (iArrC != null) {
            this.c.setCurrentHour(Integer.valueOf(iArrC[0]));
            this.c.setCurrentMinute(Integer.valueOf(iArrC[1]));
            mm.b("TEST_DATE hour = %s , minute = %s  ", Integer.valueOf(iArrC[0]), Integer.valueOf(iArrC[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.b.setText(a(R.string.FotaSilenceFrom, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.b.setTextAppearance(p(), R.style.font_blue_18);
    }

    @Override // defpackage.atm
    protected void c() {
        super.c();
        mm.b("TEST_DATE onhide store value boardDisplay = %s ,fromvalue  = %s , toValue = %s ", new Object[0]);
    }

    @Override // defpackage.atm
    protected void b() {
        super.b();
        e().c(true);
        e().b(q().getString(R.string.FotaSilenceUpdateTime));
        al();
    }

    private void ao() {
        this.a = Resources.getSystem();
        int identifier = this.a.getIdentifier("hour", "id", "android");
        int identifier2 = this.a.getIdentifier("minute", "id", "android");
        int identifier3 = this.a.getIdentifier("amPm", "id", "android");
        NumberPicker numberPicker = (NumberPicker) this.c.findViewById(identifier);
        NumberPicker numberPicker2 = (NumberPicker) this.c.findViewById(identifier2);
        NumberPicker numberPicker3 = (NumberPicker) this.c.findViewById(identifier3);
        a(numberPicker);
        a(numberPicker2);
        a(numberPicker3);
    }

    private void a(NumberPicker numberPicker) {
        int childCount = numberPicker.getChildCount();
        int color = q().getColor(R.color.white);
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
