package com.factory.domain.customerPaymentFactory;

import com.Builder.customerPaymentBuilder.CustomerpaymentInterface;
import com.domain.customerPayment.Cash;
import com.domain.customerPayment.Credit;

public class customerPayFactory {
    public CustomerpaymentInterface getCustPayment(String type)
    {
        if(type.equalsIgnoreCase("credit"))
        {
            return new Credit();
        }
        if(type.equalsIgnoreCase("cash"))
        {
            return new Cash();
        }else return null;
    }
}
