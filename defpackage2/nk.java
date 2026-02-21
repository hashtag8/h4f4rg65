package defpackage;

import android.os.Bundle;
import defpackage.nu;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class nk {
    private static final Set<String> a = new HashSet(Arrays.asList("app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"));

    public nj a(nu nuVar) {
        Bundle bundleB;
        String strA;
        boolean z = nu.b.CUSTOM.equals(nuVar.c) && nuVar.e != null;
        boolean z2 = nu.b.PREDEFINED.equals(nuVar.c) && nuVar.g != null;
        if (!z && !z2) {
            return null;
        }
        if (z2) {
            bundleB = b(nuVar);
        } else {
            Bundle bundle = new Bundle();
            if (nuVar.f != null) {
                a(bundle, nuVar.f);
            }
            bundleB = bundle;
        }
        if (z2) {
            String str = (String) nuVar.h.get("success");
            strA = a(nuVar.g, (str == null || Boolean.parseBoolean(str)) ? false : true);
        } else {
            strA = a(nuVar.e);
        }
        blh.h().a("Answers", "Logging event into firebase...");
        return new nj(strA, bundleB);
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        if (a.contains(str)) {
            return "fabric_" + str;
        }
        String strReplaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (strReplaceAll.startsWith("ga_") || strReplaceAll.startsWith("google_") || strReplaceAll.startsWith("firebase_") || !Character.isLetter(strReplaceAll.charAt(0))) {
            strReplaceAll = "fabric_" + strReplaceAll;
        }
        if (strReplaceAll.length() > 40) {
            return strReplaceAll.substring(0, 40);
        }
        return strReplaceAll;
    }

    private String b(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String strReplaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (strReplaceAll.startsWith("ga_") || strReplaceAll.startsWith("google_") || strReplaceAll.startsWith("firebase_") || !Character.isLetter(strReplaceAll.charAt(0))) {
            strReplaceAll = "fabric_" + strReplaceAll;
        }
        if (strReplaceAll.length() > 40) {
            return strReplaceAll.substring(0, 40);
        }
        return strReplaceAll;
    }

    private String a(String str, boolean z) {
        if (z) {
            switch (str) {
                case "purchase":
                    return "failed_ecommerce_purchase";
                case "signUp":
                    return "failed_sign_up";
                case "login":
                    return "failed_login";
            }
        }
        switch (str) {
            case "purchase":
                return "ecommerce_purchase";
            case "addToCart":
                return "add_to_cart";
            case "startCheckout":
                return "begin_checkout";
            case "contentView":
                return "select_content";
            case "search":
                return "search";
            case "share":
                return "share";
            case "rating":
                return "rate_content";
            case "signUp":
                return "sign_up";
            case "login":
                return "login";
            case "invite":
                return "invite";
            case "levelStart":
                return "level_start";
            case "levelEnd":
                return "level_end";
            default:
                return a(str);
        }
    }

    private Bundle b(nu nuVar) {
        Bundle bundle = new Bundle();
        if ("purchase".equals(nuVar.g)) {
            a(bundle, "item_id", (String) nuVar.h.get("itemId"));
            a(bundle, "item_name", (String) nuVar.h.get("itemName"));
            a(bundle, "item_category", (String) nuVar.h.get("itemType"));
            a(bundle, "value", b(nuVar.h.get("itemPrice")));
            a(bundle, "currency", (String) nuVar.h.get("currency"));
        } else if ("addToCart".equals(nuVar.g)) {
            a(bundle, "item_id", (String) nuVar.h.get("itemId"));
            a(bundle, "item_name", (String) nuVar.h.get("itemName"));
            a(bundle, "item_category", (String) nuVar.h.get("itemType"));
            a(bundle, "price", b(nuVar.h.get("itemPrice")));
            a(bundle, "value", b(nuVar.h.get("itemPrice")));
            a(bundle, "currency", (String) nuVar.h.get("currency"));
            bundle.putLong("quantity", 1L);
        } else if ("startCheckout".equals(nuVar.g)) {
            a(bundle, "quantity", Long.valueOf(((Integer) nuVar.h.get("itemCount")).intValue()));
            a(bundle, "value", b(nuVar.h.get("totalPrice")));
            a(bundle, "currency", (String) nuVar.h.get("currency"));
        } else if ("contentView".equals(nuVar.g)) {
            a(bundle, "content_type", (String) nuVar.h.get("contentType"));
            a(bundle, "item_id", (String) nuVar.h.get("contentId"));
            a(bundle, "item_name", (String) nuVar.h.get("contentName"));
        } else if ("search".equals(nuVar.g)) {
            a(bundle, "search_term", (String) nuVar.h.get("query"));
        } else if ("share".equals(nuVar.g)) {
            a(bundle, "method", (String) nuVar.h.get("method"));
            a(bundle, "content_type", (String) nuVar.h.get("contentType"));
            a(bundle, "item_id", (String) nuVar.h.get("contentId"));
            a(bundle, "item_name", (String) nuVar.h.get("contentName"));
        } else if ("rating".equals(nuVar.g)) {
            a(bundle, "rating", String.valueOf(nuVar.h.get("rating")));
            a(bundle, "content_type", (String) nuVar.h.get("contentType"));
            a(bundle, "item_id", (String) nuVar.h.get("contentId"));
            a(bundle, "item_name", (String) nuVar.h.get("contentName"));
        } else if ("signUp".equals(nuVar.g) || "login".equals(nuVar.g) || "invite".equals(nuVar.g)) {
            a(bundle, "method", (String) nuVar.h.get("method"));
        } else if ("levelStart".equals(nuVar.g)) {
            a(bundle, "level_name", (String) nuVar.h.get("levelName"));
        } else if ("levelEnd".equals(nuVar.g)) {
            a(bundle, "score", a(nuVar.h.get("score")));
            a(bundle, "level_name", (String) nuVar.h.get("levelName"));
            a(bundle, "success", c((String) nuVar.h.get("success")));
        }
        a(bundle, nuVar.f);
        return bundle;
    }

    private void a(Bundle bundle, String str, Long l) {
        if (l != null) {
            bundle.putLong(str, l.longValue());
        }
    }

    private void a(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    private void a(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    private void a(Bundle bundle, String str, Double d) {
        Double dA = a(d);
        if (dA != null) {
            bundle.putDouble(str, dA.doubleValue());
        }
    }

    private Double a(Object obj) {
        String strValueOf = String.valueOf(obj);
        if (strValueOf == null) {
            return null;
        }
        return Double.valueOf(strValueOf);
    }

    private Integer c(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str.equals("true") ? 1 : 0);
    }

    private Double b(Object obj) {
        if (((Long) obj) == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(((Long) obj).longValue()).divide(mt.a).doubleValue());
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String strB = b(entry.getKey());
            if (value instanceof String) {
                bundle.putString(strB, entry.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(strB, ((Double) entry.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(strB, ((Long) entry.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(strB, ((Integer) entry.getValue()).intValue());
            }
        }
    }
}
