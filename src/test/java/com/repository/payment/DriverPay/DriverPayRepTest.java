package com.repository.payment.DriverPay;

import com.Builder.driverPay.Payment;
import com.factory.domain.paymentfacto.PaymentFactory;
import com.factory.repository.DriverPayRepFac;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class DriverPayRepTest {
    DriverPayRep driverPayRep;

    PaymentFactory paymentFactory = new PaymentFactory();
    Payment b1=paymentFactory.getDriverPayInt("month");

    DriverPayRepFac driverPayRepFac = new DriverPayRepFac();
    @Before
    public void setUp() throws Exception {
        driverPayRep= driverPayRepFac.getDriverpayRep("driverPayRep");
    }

    @Test
    public void create() {
        Assert.assertNotNull(driverPayRep);
        b1.distance(13);
        b1.numberOfOrder(30);
        b1.paymentRate(30);
        b1.buildDriverNumber("03923");
        b1.buildPayDate(2011+" "+11+" "+17);
        b1.paymentType();

        //System.out.println(b1.getDriverPaymentProduct().toString());
       driverPayRep.create(b1.getDriverPaymentProduct());

    }

    @Test
    public void update() {
        b1.payCode("1000");
        b1.distance(3);
        b1.numberOfOrder(0);
        b1.paymentRate(30);
        b1.buildDriverNumber("0392");
        b1.buildPayDate(2011+" "+11+" "+17);
        b1.paymentType();
        driverPayRep.update(b1.getDriverPaymentProduct());
    }

    @Test
    public void delete() {
        driverPayRep.delete("1001");
    }

    @Test
    public void read() {
        System.out.println(driverPayRep.read("1001").toString());
    }

    @Test
    public void readAll() {
        ArrayList <String> myList=new ArrayList<>();
        myList=driverPayRep.getAll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(i+" "+myList.get(i)+"\n");
        }
    }

    @Test
    public void getItemNumber() {

    }


}