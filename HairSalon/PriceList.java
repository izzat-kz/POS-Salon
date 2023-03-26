/*
  -> simple java POS system.
  -> @author izzat-kz <m.izzatkz@gmail.com>
*/

package HairSalon;

//OBJECT
public class PriceList extends TypeList {

    static double[] price = {10, 15, 13, 20, 34, 28, 22, 45};

    public PriceList(String[] item, double[] price){
        super(item);
        this.price = price;
    }


    public static double getHairCutP(){     // P stands for Price
        return price[0];
    } 

    public static double getHairColP(){
        return price[1];
    }

    public static double getHairWaxP(){
        return price[2];
    }

    public static double getNailTreatP() {
        return price[3];
    }

    public static double getOuiP(){
        return price[4];
    }

    public static double getLivP(){
        return price[5];
    }

    public static double getOlapP(){
        return price[6];
    }

    public static double getArataP(){
        return price[7];
    }

}