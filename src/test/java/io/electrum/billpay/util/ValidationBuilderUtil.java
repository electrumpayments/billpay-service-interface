package io.electrum.billpay.util;

import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Merchant;
import io.electrum.vas.model.MerchantName;
import io.electrum.vas.model.Originator;

public class ValidationBuilderUtil {

   public static Originator originator() {
      return new Originator().institution(institution()).terminalId("12345678").merchant(merchant());
   }

   public static Institution institution() {
      return new Institution().id("institutionId").name("institutionName");
   }

   public static Merchant merchant() {
      return new Merchant().merchantType("0000").merchantId("123456789012345").merchantName(merchantName());
   }

   public static MerchantName merchantName() {
      return new MerchantName().name("merchantNameName").city("city").region("WP").country("ZA");
   }


}
