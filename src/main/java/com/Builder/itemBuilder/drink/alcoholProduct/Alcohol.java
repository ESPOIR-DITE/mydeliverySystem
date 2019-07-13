package com.Builder.itemBuilder.drink.alcoholProduct;

import com.Builder.itemBuilder.ItemInterface;
import com.Builder.itemBuilder.drink.DrinkInterface;

public interface Alcohol extends DrinkInterface {

     void percentageOfAlcohol(String percentage);
     AlcoholProduct getAlcoholProduct();


}
