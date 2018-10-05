package io.electrum.billpay.utils;

public class Paths {
   // Base paths
   public static final String VERSION_NUMBER = "/v4";
   public static final String BASE_PATH = "/billpay" + VERSION_NUMBER;

   // Account lookup paths
   public static final String ACCOUNT_LOOKUP_BASE_PATH = "/accountLookups";

   public static final String REQUEST_ACCOUNT_INFO = "/{" + PathParams.REQUEST_ID + "}";
   public static final String REQUEST_TRAFFIC_FINE_INFO = "/traffic/{" + PathParams.REQUEST_ID + "}";
   public static final String REQUEST_POLICY_INFO = "/policy/{" + PathParams.REQUEST_ID + "}";

   // Payment paths
   public static final String PAYMENTS_BASE_PATH = "/payments";

   public static final String CREATE_POLICY_PAYMENT = "/policy/{" + PathParams.PAYMENT_ID + "}";
   public static final String CREATE_TRAFFIC_FINE_PAYMENT = "/traffic/{" + PathParams.PAYMENT_ID + "}";
   public static final String CREATE_ACCOUNT_PAYMENT = "/{" + PathParams.PAYMENT_ID + "}";
   public static final String CONFIRM_PAYMENT =
         "/{" + PathParams.PAYMENT_ID + "}/confirmations/{" + PathParams.ADVICE_ID + "}";
   public static final String REVERSE_PAYMENT =
         "/{" + PathParams.PAYMENT_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";

   // Refund paths
   public static final String REFUNDS_BASE_PATH = "/refunds";

   public static final String CREATE_REFUND = "/{" + PathParams.REFUND_ID + "}";
   public static final String CONFIRM_REFUND =
         "/{" + PathParams.REFUND_ID + "}/confirmations/{" + PathParams.ADVICE_ID + "}";
   public static final String REVERSE_REFUND =
         "/{" + PathParams.REFUND_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";
}