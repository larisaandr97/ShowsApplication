package unibuc.DAO;

import unibuc.Domain.PriceCategory;

public class PriceCategoryDAO {


    private PriceCategory[] priceCategoryList;

    public void addPriceCategory(String name, int discount){
        PriceCategory prc = new PriceCategory( name,discount);
        PriceCategory[] aux = new PriceCategory[priceCategoryList.length+1];
        int ok=0;
        for(int i=0;i<priceCategoryList.length;i++)
        {
            if (priceCategoryList[i] == null) {
                aux[i] = prc;
                ok = 1;
            }
            else {
                aux[i] = priceCategoryList[i];
            }
        }
        if(ok==0)
            aux[priceCategoryList.length-1]=prc;
        priceCategoryList = aux;
    }

    public void deletePriceCategory(String name)
    {

        for(int i=0;i<priceCategoryList.length;i++)
        {
            if (priceCategoryList[i].getName().equals(name)) {
                priceCategoryList[i] = null;
            }
        }
    }
    public int searchPriceCategory(String name)
    {

        for(int i=0;i<priceCategoryList.length;i++)
            if (priceCategoryList[i].getName().equals(name)) {
               return priceCategoryList[i].getDiscount();
            }
        System.out.println("This price category name doesn't exist.");
         return 0;
    }
}
