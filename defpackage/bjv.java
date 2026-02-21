package defpackage;

import android.util.Log;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes.dex */
public class bjv implements bjs {
    @Override // defpackage.bjs
    public void a(String str, InetAddress inetAddress, int i, bix bixVar, int i2) {
        MulticastSocket multicastSocket;
        if (str != null) {
            try {
                multicastSocket = new MulticastSocket((SocketAddress) null);
            } catch (Exception e) {
                e = e;
                multicastSocket = null;
            }
            try {
                multicastSocket.setReuseAddress(true);
                DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.length(), inetAddress, i);
                multicastSocket.setSoTimeout(5000);
                multicastSocket.send(datagramPacket);
                while (true) {
                    byte[] bArr = new byte[1024];
                    DatagramPacket datagramPacket2 = new DatagramPacket(bArr, bArr.length);
                    multicastSocket.receive(datagramPacket2);
                    String str2 = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                    if (bixVar != null) {
                        bixVar.a(datagramPacket2.getAddress().getHostAddress(), datagramPacket2.getPort(), str2);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                multicastSocket.close();
                Log.d("DLNA-LIB ", e.getMessage());
            }
        }
    }

    @Override // defpackage.bjs
    public bjr a(int i, bix bixVar) {
        return new bjt(i, bixVar);
    }

    @Override // defpackage.bjs
    public bjr a(SocketAddress socketAddress, bix bixVar) {
        return new bjt(socketAddress, bixVar);
    }

    @Override // defpackage.bjs
    public void a(String str, SocketAddress socketAddress, NetworkInterface networkInterface) {
    }
}
