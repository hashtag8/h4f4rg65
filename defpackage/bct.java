package defpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bct implements Comparator<JSONObject> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH).parse(jSONObject.getString("created")).compareTo(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH).parse(jSONObject2.getString("created")));
        } catch (ParseException e) {
            new ml().a("JSON parsing error", e);
            return 0;
        } catch (JSONException e2) {
            new ml().a("JSON unable to getString", e2);
            return 0;
        }
    }
}
