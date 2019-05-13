package repository.ItemRep;

import Builder.itemBuilder.ItemProduct;

import java.util.LinkedList;
import java.util.List;

public class ItemRepository implements ItemRepo {
    private static ItemRepository repository=null;
    private List<ItemProduct>itemList;

    public ItemRepository(List<ItemProduct> itemList) {
        this.itemList =new LinkedList<>();
    }

    @Override
    public List<ItemProduct> getItems() {
        return this.itemList;
    }

    @Override
    public ItemProduct create(ItemProduct itemProduct) {
        itemList=new LinkedList<>();
        return null;
    }

    @Override
    public ItemProduct update(ItemProduct itemProduct) {
        itemList.add(generatesNumber(), itemProduct);

        return null;
    }

    @Override
    public void delete(String s) {

        itemList.clear();
    }

    @Override
    public ItemProduct read(String s) {
        for(int i=0;i<itemList.size();i++)
        {
            System.out.println(itemList.get(i));
        }
        return null;
    }
    public int generatesNumber()
    {
        return 0;
    }
}
