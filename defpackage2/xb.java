package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class xb {
    public static final wx<String> a = wx.a("gads:sdk_core_experiment_id");
    public static final wx<String> b = wx.a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final wx<Boolean> c = wx.a("gads:request_builder:singleton_webview", (Boolean) false);
    public static final wx<String> d = wx.a("gads:request_builder:singleton_webview_experiment_id");
    public static final wx<Boolean> e = wx.a("gads:sdk_crash_report_enabled", (Boolean) false);
    public static final wx<Boolean> f = wx.a("gads:sdk_crash_report_full_stacktrace", (Boolean) false);
    public static final wx<Boolean> g = wx.a("gads:block_autoclicks", (Boolean) false);
    public static final wx<String> h = wx.a("gads:block_autoclicks_experiment_id");
    public static final wx<String> i = wx.b("gads:prefetch:experiment_id");
    public static final wx<String> j = wx.a("gads:spam_app_context:experiment_id");
    public static final wx<Boolean> k = wx.a("gads:spam_app_context:enabled", (Boolean) false);
    public static final wx<String> l = wx.a("gads:video_stream_cache:experiment_id");
    public static final wx<Integer> m = wx.a("gads:video_stream_cache:limit_count", 5);
    public static final wx<Integer> n = wx.a("gads:video_stream_cache:limit_space", 8388608);
    public static final wx<Long> o = wx.a("gads:video_stream_cache:limit_time_sec", 300L);
    public static final wx<Long> p = wx.a("gads:video_stream_cache:notify_interval_millis", 1000L);
    public static final wx<Integer> q = wx.a("gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final wx<String> r = wx.b("gads:spam_ad_id_decorator:experiment_id");
    public static final wx<Boolean> s = wx.a("gads:spam_ad_id_decorator:enabled", (Boolean) false);
    public static final wx<String> t = wx.a("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final wx<String> u = wx.a("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final wx<String> v = wx.a("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final wx<Boolean> w = wx.a("gads:enabled_sdk_csi", (Boolean) false);
    public static final wx<Integer> x = wx.a("gads:sdk_csi_batch_size", 20);
    public static final wx<String> y = wx.a("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final wx<Boolean> z = wx.a("gads:sdk_csi_write_to_file", (Boolean) false);
    public static final wx<Boolean> A = wx.a("gads:enable_content_fetching", (Boolean) true);
    public static final wx<Integer> B = wx.a("gads:content_length_weight", 1);
    public static final wx<Integer> C = wx.a("gads:content_age_weight", 1);
    public static final wx<Integer> D = wx.a("gads:min_content_len", 11);
    public static final wx<Integer> E = wx.a("gads:fingerprint_number", 10);
    public static final wx<Integer> F = wx.a("gads:sleep_sec", 10);
    public static final wx<String> G = wx.a("gads:kitkat_interstitial_workaround:experiment_id");
    public static final wx<Boolean> H = wx.a("gads:kitkat_interstitial_workaround:enabled", (Boolean) true);
    public static final wx<Boolean> I = wx.a("gads:interstitial_follow_url", (Boolean) true);
    public static final wx<Boolean> J = wx.a("gads:interstitial_follow_url:register_click", (Boolean) true);
    public static final wx<String> K = wx.a("gads:interstitial_follow_url:experiment_id");
    public static final wx<Boolean> L = wx.a("gads:analytics_enabled", (Boolean) true);
    public static final wx<Boolean> M = wx.a("gads:ad_key_enabled", (Boolean) false);
    public static final wx<Integer> N = wx.a("gads:webview_cache_version", 0);
    public static final wx<String> O = wx.b("gads:pan:experiment_id");
    public static final wx<String> P = wx.a("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final wx<Boolean> Q = wx.a("gads:ad_manager_creator:enabled", (Boolean) true);
    public static final wx<Boolean> R = wx.a("gads:log:verbose_enabled", (Boolean) false);
    public static final wx<Boolean> S = wx.a("gads:sdk_less_mediation:enabled", (Boolean) true);
    public static final wx<Boolean> T = wx.a("gads:device_info_caching:enabled", (Boolean) true);
    public static final wx<Long> U = wx.a("gads:device_info_caching_expiry_ms:expiry", 300000L);
    public static final wx<Boolean> V = wx.a("gads:gen204_signals:enabled", (Boolean) false);

    public static List<String> a() {
        return sy.h().a();
    }
}
