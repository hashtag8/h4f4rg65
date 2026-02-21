package defpackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes.dex */
public class bjt implements bjr {
    private MulticastSocket a;
    private bix b;
    private int c = 3000;

    public bjt(int i, bix bixVar) {
        this.a = null;
        this.b = null;
        this.a = new MulticastSocket(i);
        this.b = bixVar;
    }

    public bjt(SocketAddress socketAddress, bix bixVar) {
        this.a = null;
        this.b = null;
        this.a = new MulticastSocket(socketAddress);
        this.b = bixVar;
    }

    @Override // defpackage.bjr
    public void a(InetAddress inetAddress) throws IOException {
        this.a.joinGroup(inetAddress);
    }

    @Override // defpackage.bjr
    public void a(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        this.a.joinGroup(socketAddress, networkInterface);
    }

    @Override // defpackage.bjr
    public void b(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        this.a.leaveGroup(socketAddress, networkInterface);
    }

    @Override // defpackage.bjr
    public void b(InetAddress inetAddress) throws IOException {
        this.a.leaveGroup(inetAddress);
    }

    @Override // defpackage.bjr
    public void a(boolean z) {
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        if (!z) {
            this.a.setSoTimeout(this.c);
        }
        this.a.receive(datagramPacket);
        String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        if (this.b != null) {
            this.b.a(datagramPacket.getAddress().getHostAddress(), datagramPacket.getPort(), str);
        }
    }

    @Override // defpackage.bjr
    public void a(int i) {
        this.c = i;
    }
}
