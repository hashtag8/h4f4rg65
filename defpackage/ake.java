package defpackage;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.custom.ClearEditText;
import defpackage.aoj;

/* JADX INFO: loaded from: classes.dex */
public class ake implements View.OnFocusChangeListener, TextView.OnEditorActionListener {
    private final aoj.b a;
    private final boolean b;

    public ake(aoj.b bVar, boolean z) {
        this.a = bVar;
        this.b = z;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        ClearEditText clearEditText = (ClearEditText) textView;
        a(clearEditText);
        clearEditText.clearFocus();
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            a((ClearEditText) view);
            ady adyVarO = aof.a().o();
            if (adyVarO != null && adyVarO.f().contains(this.a.m())) {
                mm.b("stop playback", new Object[0]);
                HarmanApplication.a().sendBroadcast(new Intent("EditRoomPauseUi"));
            }
        }
    }

    private void a(ClearEditText clearEditText) {
        String string = clearEditText.getText().toString();
        if (bru.a((CharSequence) string.trim())) {
            clearEditText.setText(this.a.n().h());
            return;
        }
        if (!string.equals(this.a.n().h())) {
            RoomItem roomItemN = this.a.n();
            roomItemN.a(string);
            if (this.b) {
                roomItemN.a(this.a.m().k());
                roomItemN.y();
            }
        }
    }
}
