package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.RippleTextView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class apx extends RecyclerView.a<d> {
    private final Context a;
    private List<b> b;
    private a c;

    public interface a {
        void a(b bVar);
    }

    public enum c {
        IDLE,
        IN_PROGRESS,
        WAITING,
        SUCCESS,
        FAILURE,
        RETRY
    }

    public apx(Context context, a aVar) {
        this.a = context;
        this.c = aVar;
    }

    public void a(List<b> list) {
        this.b = list;
        c();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d a(ViewGroup viewGroup, int i) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_devices_list_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public void a(d dVar, int i) {
        final b bVar = this.b.get(i);
        adx adxVarA = bVar.a();
        dVar.p.setProgress(bVar.b());
        dVar.q.setText(bVar.b() + "%");
        mm.b("TEST_LOACAL_UPGRADE", "IN_PROGRESS=" + bVar.b() + ", deviceInfo.getState() = " + bVar.c() + " deviceInfo = " + bVar + " deviceInfos = " + this.b);
        dVar.n.setOnClickListener(null);
        dVar.r.setVisibility(8);
        dVar.q.setVisibility(8);
        dVar.s.setVisibility(8);
        dVar.t.setVisibility(8);
        dVar.u.setVisibility(8);
        dVar.v.setVisibility(8);
        dVar.v.setTextAppearance(this.a, R.style.font_white_16_alpha50);
        dVar.t.setOnClickListener(new View.OnClickListener() { // from class: apx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bVar.a(c.IDLE);
                apx.this.c.a(bVar);
                apx.this.c();
            }
        });
        switch (bVar.c()) {
            case IDLE:
                dVar.u.setVisibility(0);
                dVar.q.setVisibility(0);
                dVar.p.setProgress(0);
                dVar.q.setText("0%");
                dVar.o.setText(this.a.getString(R.string.FotaFirmwareDownloading_Str, adxVarA.x(), Integer.valueOf(i + 1)));
                break;
            case IN_PROGRESS:
                dVar.u.setVisibility(0);
                dVar.q.setVisibility(0);
                dVar.o.setText(this.a.getString(R.string.FotaFirmwareDownloading_Str, adxVarA.x(), Integer.valueOf(i + 1)));
                break;
            case WAITING:
                dVar.s.setVisibility(0);
                dVar.v.setVisibility(0);
                if (bVar.b() < 100) {
                    dVar.v.setText(this.a.getString(R.string.FotaDeviceOfflineWaiting));
                } else {
                    dVar.v.setText(this.a.getString(R.string.FotaProcessTakeMinutes_combineIsUpdating_Str, adxVarA.x(), Long.valueOf(adxVarA.ai())));
                }
                break;
            case SUCCESS:
                dVar.v.setVisibility(0);
                dVar.v.setText(this.a.getString(R.string.FotaUpdateSuccessful_Str, adxVarA.x() + "(" + (i + 1) + ")"));
                dVar.r.setImageResource(R.drawable.check_icon_big_copy);
                dVar.r.setVisibility(0);
                break;
            case FAILURE:
                dVar.v.setVisibility(0);
                dVar.v.setTextAppearance(this.a, R.style.font_red_16);
                dVar.v.setText(this.a.getString(R.string.FotaUpdateFail_Str, adxVarA.x() + "(" + (i + 1) + ")"));
                break;
            case RETRY:
                dVar.v.setVisibility(0);
                dVar.v.setTextAppearance(this.a, R.style.font_red_16);
                dVar.v.setText(this.a.getString(R.string.FotaUpdateFail_Str, adxVarA.x() + "(" + (i + 1) + ")"));
                dVar.t.setVisibility(0);
                dVar.p.setProgress(0);
                dVar.q.setText("0%");
                break;
            default:
                dVar.p.setVisibility(4);
                dVar.q.setVisibility(8);
                break;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public int a() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    public static class d extends RecyclerView.v {
        private final View n;
        private final TextView o;
        private final ProgressBar p;
        private final TextView q;
        private final ImageView r;
        private final ProgressBar s;
        private RippleTextView t;
        private RelativeLayout u;
        private TextView v;

        public d(View view) {
            super(view);
            this.n = view;
            this.o = (TextView) view.findViewById(R.id.updateDevicesListItem_name);
            this.p = (ProgressBar) view.findViewById(R.id.updateDevicesListItem_progress);
            this.q = (TextView) view.findViewById(R.id.updateDevicesListItem_progressText);
            this.r = (ImageView) view.findViewById(R.id.updateDevicesListItem_successful_icon);
            this.s = (ProgressBar) view.findViewById(R.id.updateDevicesListItem_waitingForOnline);
            this.t = (RippleTextView) view.findViewById(R.id.updateDevicesListItem_retry);
            this.u = (RelativeLayout) view.findViewById(R.id.update_inprocess_layout);
            this.v = (TextView) view.findViewById(R.id.update_waitting_notice);
        }
    }

    public static class b {
        private adx a;
        private int b = 0;
        private c c = c.IDLE;
        private ErrorInfo d;

        public b(adx adxVar) {
            this.a = adxVar;
        }

        public adx a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public void a(int i) {
            this.b = i;
        }

        public c c() {
            return this.c;
        }

        public void a(c cVar) {
            this.c = cVar;
        }

        public void a(ErrorInfo errorInfo) {
            this.d = errorInfo;
        }

        public String toString() {
            return bsc.b(this, new ahp());
        }
    }
}
