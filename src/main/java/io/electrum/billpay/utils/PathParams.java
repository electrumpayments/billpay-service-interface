package io.electrum.billpay.utils;

/**
 * Use path parameters defined in {@link io.electrum.billpay.api.AccountLookupsResource}, 
 * {@link io.electrum.billpay.api.PaymentsResource} and 
 * {@link io.electrum.billpay.api.RefundsResource}.
 */
@Deprecated
public class PathParams {
    public static final String REQUEST_ID = "requestId";
    public static final String ADVICE_ID  = "adviceId";
    public static final String PAYMENT_ID = "paymentId";
    public static final String REFUND_ID = "refundId";
}