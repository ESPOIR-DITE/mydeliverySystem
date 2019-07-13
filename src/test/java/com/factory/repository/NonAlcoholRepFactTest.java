package com.factory.repository;

import com.configPack.ConfigNoAlcohol;
import com.configPack.repositoryController.NonAlcolRepConfig;
import com.factory.domain.productFactory.nonAlcoholItemFactory;
import com.repository.ItemRep.noAlcoholRepository.NoAlcoholRepositoryClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class NonAlcoholRepFactTest {

    NonAlcoholRepFact nonAlcoholRepFact;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(NonAlcolRepConfig.class);




    @Before
    public void setUp()
    {
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigBeer.class);

        nonAlcoholRepFact = (NonAlcoholRepFact) ctx.getBean("nonRep");

    }

    @Test
    public void getRepNonAlco() {

       // Assert.assertNotNull(nonAlcoholRepFact);
       NoAlcoholRepositoryClass noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
       Assert.assertNotNull(noAlcoholRepositoryClass);

    }
}