package defpackage;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes.dex */
class bci implements AuthScheme {
    public static Pattern c = Pattern.compile("^OAuth (\\w+)$");
    public HashMap<String, String> a = new HashMap<>();
    public HttpParams b;
    private bcb d;

    public bci(bcb bcbVar, HttpParams httpParams) {
        this.d = bcbVar;
        this.b = httpParams;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "oauth";
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getParameter(String str) {
        return this.a.get(str);
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getRealm() {
        return getParameter("realm");
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        return true;
    }

    @Override // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        Header headerA;
        String strA = a(httpRequest);
        synchronized (bci.class) {
            bck bckVarH = this.d.h();
            if ((bckVarH == null || bckVarH.a == null || bckVarH.a.equals(strA)) && this.d.b() == null) {
                try {
                    this.d.a();
                } catch (IOException e) {
                    throw new AuthenticationException("Error refreshing token", e);
                } catch (IllegalStateException e2) {
                    throw new AuthenticationException("Error refreshing token", e2);
                }
            }
            headerA = bca.a(this.d.h());
        }
        return headerA;
    }

    @Override // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        CharArrayBuffer buffer;
        int valuePos;
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        String name = header.getName();
        if (!name.equalsIgnoreCase("WWW-Authenticate")) {
            throw new MalformedChallengeException("Unexpected header name: " + name);
        }
        if (header instanceof FormattedHeader) {
            buffer = ((FormattedHeader) header).getBuffer();
            valuePos = ((FormattedHeader) header).getValuePos();
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            buffer = charArrayBuffer;
            valuePos = 0;
        }
        while (valuePos < buffer.length() && HTTP.isWhitespace(buffer.charAt(valuePos))) {
            valuePos++;
        }
        int i = valuePos;
        while (i < buffer.length() && !HTTP.isWhitespace(buffer.charAt(i))) {
            i++;
        }
        String strSubstring = buffer.substring(valuePos, i);
        if (!strSubstring.equalsIgnoreCase(getSchemeName())) {
            throw new MalformedChallengeException("Invalid scheme identifier: " + strSubstring);
        }
        HeaderElement[] elements = BasicHeaderValueParser.DEFAULT.parseElements(buffer, new ParserCursor(i, buffer.length()));
        if (elements.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        for (HeaderElement headerElement : elements) {
            this.a.put(headerElement.getName(), headerElement.getValue());
        }
    }

    static String a(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return null;
        }
        return a(httpRequest.getFirstHeader("Authorization"));
    }

    static String a(Header header) {
        if (header == null || header.getValue() == null || !"Authorization".equalsIgnoreCase(header.getName())) {
            return null;
        }
        Matcher matcher = c.matcher(header.getValue());
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    static class b implements AuthSchemeFactory {
        private bcb a;

        public b(bcb bcbVar) {
            this.a = bcbVar;
        }

        @Override // org.apache.http.auth.AuthSchemeFactory
        public AuthScheme newInstance(HttpParams httpParams) {
            return new bci(this.a, httpParams);
        }
    }

    static class a implements Credentials {
        public static final Credentials a = new a();

        a() {
        }

        @Override // org.apache.http.auth.Credentials
        public Principal getUserPrincipal() {
            return null;
        }

        @Override // org.apache.http.auth.Credentials
        public String getPassword() {
            return null;
        }
    }
}
