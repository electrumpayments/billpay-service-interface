package io.electrum.billpay.utils;

public class Paths {
    //Base paths
    public static final String VERSION_NUMBER ="/v4";
    public static final String BASE_PATH = "/billpay" + VERSION_NUMBER;

    //Account lookup paths
    public static final String REQUEST_ACCOUNT_INFO = "/accountLookups/{requestId}";
    public static final String REQUEST_TRAFFIC_FINE_INFO = "/accountLookups/traffic/{requestId}";
    public static final String REQUEST_POLICY_INFO = "/accountLookups//policy/{requestId}";

    //Payment paths
    public static final String CREATE_POLICY_PAYMENT = "/policy/{paymentId}";
    public static final String CREATE_TRAFFIC_FINE_PAYMENT = "/traffic/{paymentId}";
    public static final String CREATE_ACCOUNT_PAYMENT = "/{paymentId}";
    public static final String CONFIRM_PAYMENT = "/{paymentId}/confirmations/{adviceId}";
    public static final String REVERSE_PAYMENT = "/{paymentId}/reversals/{adviceId}";

    //Refund paths
    public static final String CREATE_REFUND = "/refunds/{refundId}";
    public static final String CONFIRM_REFUND = "/refunds/{refundId}/confirmations/{adviceId}";
    public static final String REVERSE_REFUND = "/refunds/{refundId}/reversals/{adviceId}";
}
