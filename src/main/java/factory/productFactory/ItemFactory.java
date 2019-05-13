package factory.productFactory;

import Builder.itemBuilder.ItemInterface;
import domain.*;



public class ItemFactory {
    // private ItemInterface itemInterface;
    public static ItemInterface getItem(String item) {
        switch (item) {
            case "Juice":
                return new Juice();

            case "Cigarette":
                return new Cigarette();

            case "Ice":
                return new Ice();

            case "EnergyDringk":
                return new EnergyDrink();

            case "Soda":
                return new Soda();
            case "Snaks":
                return new Snaks();

            case "Alcohol":
                switch ("Alcohol") {
                    case "Beer":
                        return new Beer();

                    case "Gin":
                        return new Gin();

                    case "Whisky":
                        return new Whisky();

                    case "Juice":
                        return new Wine();

                    default:
                        return null;
                }
            default:
                return null;


        }
        //case "Snaks":
        //return new Snaks();
        //final JOptionPane.showMessageDialog(null,);


    }
}

