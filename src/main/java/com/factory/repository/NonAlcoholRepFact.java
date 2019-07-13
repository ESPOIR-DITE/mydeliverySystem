package com.factory.repository;

import com.domain.itemDomain.beverages.noAlcoholic.*;
import com.repository.ItemRep.noAlcoholRepository.NoAlcoholRepository;
import com.repository.ItemRep.noAlcoholRepository.NoAlcoholRepositoryClass;

public class NonAlcoholRepFact {
    NoAlcoholRepositoryClass no,nonAlco;
    public NoAlcoholRepositoryClass getRepNonAlco(String s)
    {

        if(s.equals("nonAlcohol"))
        {

            nonAlco= no.getNonAlco();
        }
        return nonAlco;
    }
}
