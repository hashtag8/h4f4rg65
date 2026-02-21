package defpackage;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class bfy implements ben {
    public static final ben a = new bfy();

    @Override // defpackage.ben
    public bfg a(Proxy proxy, bfi bfiVar) {
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        List<bes> listK = bfiVar.k();
        bfg bfgVarA = bfiVar.a();
        URL urlA = bfgVarA.a();
        int size = listK.size();
        for (int i = 0; i < size; i++) {
            bes besVar = listK.get(i);
            if ("Basic".equalsIgnoreCase(besVar.a()) && (passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(urlA.getHost(), a(proxy, urlA), bfw.a(urlA), urlA.getProtocol(), besVar.b(), besVar.a(), urlA, Authenticator.RequestorType.SERVER)) != null) {
                return bfgVarA.g().a("Authorization", bex.a(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()))).a();
            }
        }
        return null;
    }

    @Override // defpackage.ben
    public bfg b(Proxy proxy, bfi bfiVar) {
        List<bes> listK = bfiVar.k();
        bfg bfgVarA = bfiVar.a();
        URL urlA = bfgVarA.a();
        int size = listK.size();
        for (int i = 0; i < size; i++) {
            bes besVar = listK.get(i);
            if ("Basic".equalsIgnoreCase(besVar.a())) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), a(proxy, urlA), inetSocketAddress.getPort(), urlA.getProtocol(), besVar.b(), besVar.a(), urlA, Authenticator.RequestorType.PROXY);
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    return bfgVarA.g().a("Proxy-Authorization", bex.a(passwordAuthenticationRequestPasswordAuthentication.getUserName(), new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()))).a();
                }
            }
        }
        return null;
    }

    private InetAddress a(Proxy proxy, URL url) {
        return (proxy == null || proxy.type() == Proxy.Type.DIRECT) ? InetAddress.getByName(url.getHost()) : ((InetSocketAddress) proxy.address()).getAddress();
    }
}
