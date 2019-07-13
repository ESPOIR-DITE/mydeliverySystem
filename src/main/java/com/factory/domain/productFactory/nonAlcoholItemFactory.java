package com.factory.domain.productFactory;

import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.domain.itemDomain.beverages.noAlcoholic.*;

public class nonAlcoholItemFactory {
    public NoAlcoholicItemInterface getNonAlcohol(String nonAlco)
    {
        switch (nonAlco)
        {
            case "cooldrink":
                return new CoolDrink();
                //break;
            case "energydrink":
                return new EnergyDrink();
                // break;
            case "juice":
                return new Juice();
                //break;
            case"soda":
                return new Soda();
            case "softdrink":
                return new SoftDrink();
               // break;

        }
         return null;
    }
}
