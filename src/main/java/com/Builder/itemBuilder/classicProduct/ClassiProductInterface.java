package com.Builder.itemBuilder.classicProduct;

import com.Builder.itemBuilder.ItemInterface;

public interface ClassiProductInterface extends ItemInterface {
    void flavor(String flavor);
    ClassicProduct getClassic();
}
