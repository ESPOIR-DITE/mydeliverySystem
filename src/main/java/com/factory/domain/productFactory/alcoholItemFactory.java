package com.factory.domain.productFactory;

import com.Builder.itemBuilder.drink.alcoholProduct.Alcohol;
import com.domain.itemDomain.beverages.alcoholicItem.Beer;
import com.domain.itemDomain.beverages.alcoholicItem.Gin;
import com.domain.itemDomain.beverages.alcoholicItem.Whisky;
import com.domain.itemDomain.beverages.alcoholicItem.Wine;

public class alcoholItemFactory
{
    public Alcohol getAlcohol(String type)
    {
        switch (type)
        {
            case "beer":
                return new Beer();
            case "gin":
                return  new Gin();
            case "whisky":
                return  new Whisky();
            case "wine":
                return new Wine();

            default:
                return null;
        }

    }
}
