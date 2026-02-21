package defpackage;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import defpackage.bif;
import defpackage.bil;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class bhr extends bil {
    private static final UriMatcher a = new UriMatcher(-1);
    private final Context b;

    static {
        a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    bhr(Context context) {
        this.b = context;
    }

    @Override // defpackage.bil
    public boolean a(bij bijVar) {
        Uri uri = bijVar.d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && a.match(bijVar.d) != -1;
    }

    @Override // defpackage.bil
    public bil.a a(bij bijVar, int i) {
        InputStream inputStreamB = b(bijVar);
        if (inputStreamB != null) {
            return new bil.a(inputStreamB, bif.d.DISK);
        }
        return null;
    }

    private InputStream b(bij bijVar) {
        ContentResolver contentResolver = this.b.getContentResolver();
        Uri uriLookupContact = bijVar.d;
        switch (a.match(uriLookupContact)) {
            case 1:
                uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
                if (uriLookupContact == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uriLookupContact);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uriLookupContact);
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact);
        }
        return a.a(contentResolver, uriLookupContact);
    }

    @TargetApi(14)
    static class a {
        static InputStream a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }
}
