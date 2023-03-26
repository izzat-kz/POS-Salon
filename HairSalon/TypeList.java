/*
  -> simple java POS system.
  -> @author izzat-kz <m.izzatkz@gmail.com>
*/

package HairSalon;

//OBJECT
public class TypeList { //consists of both services and products

    private static String[] type = {"1  : Hair Cutting ", "2  : Hair Colouring ", "3  : Hair Waxing","4  : Nails Treatment",
            "    5  : OUI Repair Shampoo " , "6  : Living Proof Dry Shampoo ", "    7  : Olaplex Bonding Oil",  "8  : Arata Hair Cream"};
    // Array String type

    // CONSTRUCTOR
    public TypeList(String[] type){
        this.type = type;
    }



    //ACCESSOR method
    public static String getHairCutN() {     // 'N' stands for Name
        return type[0];
    }  

    public static String getHairColN() {
        return type[1];
    }

    public static String getHairWaxN() {
        return type[2];
    }

    public static String getNailTreatN() {
        return type[3];
    }

    public static String getOuiN() {
        return type[4];
    }
    public static String getLivN() {
        return type[5];
    }
    public static String getOlapN() {
        return type[6];
    }
    public static String getArataN() {
        return type[7];
    }

}
