package io.electrum.billpay.utils;

/**
 * Use path constants defined in {@link io.electrum.billpay.api.AccountLookupsResource}, 
 * {@link io.electrum.billpay.api.PaymentsResource} and 
 * {@link io.electrum.billpay.api.RefundsResource}.
 */
@Deprecated
public class Paths {

   // Account lookup paths
   public static final String ACCOUNT_LOOKUP_BASE_PATH = "/accountLookups";

   public static final String REQUEST_ACCOUNT_INFO = ACCOUNT_LOOKUP_BASE_PATH + "/{" + PathParams.REQUEST_ID + "}";
   public static final String REQUEST_TRAFFIC_FINE_INFO =
         ACCOUNT_LOOKUP_BASE_PATH + "/traffic/{" + PathParams.REQUEST_ID + "}";
   public static final String REQUEST_POLICY_INFO =
         ACCOUNT_LOOKUP_BASE_PATH + "/policy/{" + PathParams.REQUEST_ID + "}";

   // Payment paths
   public static final String PAYMENTS_BASE_PATH = "/payments";

   public static final String CREATE_POLICY_PAYMENT = PAYMENTS_BASE_PATH + "/policy/{" + PathParams.PAYMENT_ID + "}";
   public static final String CREATE_TRAFFIC_FINE_PAYMENT =
         PAYMENTS_BASE_PATH + "/traffic/{" + PathParams.PAYMENT_ID + "}";
   public static final String CREATE_ACCOUNT_PAYMENT = PAYMENTS_BASE_PATH + "/{" + PathParams.PAYMENT_ID + "}";
   public static final String CONFIRM_PAYMENT =
         PAYMENTS_BASE_PATH + "/{" + PathParams.PAYMENT_ID + "}/confirmations/{" + PathParams.ADVICE_ID + "}";
   public static final String REVERSE_PAYMENT =
         PAYMENTS_BASE_PATH + "/{" + PathParams.PAYMENT_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";

   // Refund paths
   public static final String REFUNDS_BASE_PATH = "/refunds";

   public static final String CREATE_REFUND = REFUNDS_BASE_PATH + "/{" + PathParams.REFUND_ID + "}";
   public static final String CONFIRM_REFUND =
         REFUNDS_BASE_PATH + "/{" + PathParams.REFUND_ID + "}/confirmations/{" + PathParams.ADVICE_ID + "}";
   public static final String REVERSE_REFUND =
         REFUNDS_BASE_PATH + "/{" + PathParams.REFUND_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";
}