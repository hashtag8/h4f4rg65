package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class awh {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.isConnected()) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean a(int i) {
        InetAddress inetAddress;
        Future futureSubmit;
        InetAddress inetAddress2 = null;
        try {
            futureSubmit = Executors.newSingleThreadExecutor().submit(new Callable<InetAddress>() { // from class: awh.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public InetAddress call() {
                    try {
                        return InetAddress.getByName("google.com");
                    } catch (UnknownHostException e) {
                        return null;
                    }
                }
            });
            inetAddress = (InetAddress) futureSubmit.get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            inetAddress = null;
        } catch (ExecutionException e2) {
        } catch (TimeoutException e3) {
        }
        try {
            futureSubmit.cancel(true);
        } catch (InterruptedException e4) {
        } catch (ExecutionException e5) {
            inetAddress2 = inetAddress;
            inetAddress = inetAddress2;
        } catch (TimeoutException e6) {
            inetAddress2 = inetAddress;
            inetAddress = inetAddress2;
        }
        return (inetAddress == null || inetAddress.equals("")) ? false : true;
    }
}
