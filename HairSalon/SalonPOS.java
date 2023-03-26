/*
  -> simple java POS system.
  -> @author izzat-kz <m.izzatkz@gmail.com>
*/

package HairSalon;

import java.util.Date;
import java.util.Scanner;

//CLASS
public class SalonPOS {
    public static void main(String args[]) {
        //SCANNER
        Scanner scan = new Scanner(System.in);

        // Category
        int categorySelect[] = new int[99];  //initializing the max

        // Membership
        int membership = 0;

        // Item Selection
        int Quantity[][] = new int[99][99];

        // Total
        double total[] = new double[99];
        double payment;

        // Necessary variables for Looping
        int repeat = 0;
        int item = 0;
        int i = 0;
        int finish;


        // Date & Time
        Date today;
        today = new Date();

        /* *****************************STARTING PAGE*****************************
         **************************************************************************
         */

        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("|           H A I R  S A L O N  P O S            |");
        System.out.println("");


        /* ********************************MAIN PAGE**********************************
         * **************************************************************************
         */
        do {
            {
                repeat = 0;
                System.out.println("--------------------------------------------------");
                System.out.println("The time is: " + today);
                System.out.println("--------------------------------------------------");

                System.out.println("S E L E C T  C A T E G O R Y");
                System.out.println("--------------------------------------------------");
                System.out.println("1. Purchase");
                System.out.println("2. Exit Program");
                System.out.println("--------------------------------------------------");
                categorySelect[i] = scan.nextInt();



                /* ***************************CATEGORY SELECT 2**********************
                 * ***********************TERMINATE PROGRAM************************
                 */

                if (categorySelect[i] == 2) {
                    System.out.println("Program Has Been Terminated.");
                    System.out.println(" ");
                    repeat = 0;
                }

                /* ***************************CATEGORY SELECT 1*****************************
                 * *******************************PURCHASE**********************************
                 */

                else if (categorySelect[i] == 1) {

                    finish = 1;
                    ItemList(item, finish, Quantity, scan); //Method


               /* *************************START OF COMPUTING TOTAL*****************************
                * ******************************************************************************
                */

                    TotalAmount(item, Quantity, total, i); //Method

                    // MEMBERSHIP CHECK
                    System.out.println("Premium Member?");
                    System.out.println("     1    : Yes");
                    System.out.println("     2    : No");
                    membership = scan.nextInt();


                    if(membership==1){
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Member: Get 5% Discount");
                        total[i] = total[i] * 0.95;
                    }

                    else if(membership==2){

                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Non-member: Standard Pricing");
                        membership=2;
                    }

// CASH TO BE RECIEVED
                    System.out.println("            RM" + total[i]);
                    System.out.println("------------------------");
                    System.out.println("Total Is : RM " + (total[i]));
                    System.out.println("Please input payment:");
                    payment = scan.nextDouble();
                    System.out.println("Recieved: RM " + payment);


// IF PAYMENT IS INSUFFICIENT
                    if ((payment < (total[i]))) {
                        System.out.println("Insufficient Funds!!");
                        System.out.println("------------------------");
                        System.out.println("Please Pay in Full!!");


                        System.out.println("________________________________________________");
                        System.out.println("Another Transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        repeat = scan.nextInt();
                        System.out.println("----------------------------------------------------------------------");

                    }
// IF PAYMENT IS ENOUGH
                    else {
                        System.out.println("-----------");
                        System.out.println("Your Change is: RM " + (payment - (total[i])));
                        System.out.println("------------------------");
                        System.out.println("Thank You! Have A Nice Day!");

// RETURN TO MAIN PAGE?
                        System.out.println("________________________________________________");
                        System.out.println("Another Transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        repeat = scan.nextInt();
                        System.out.println("----------------------------------------------------------------------");

                    }
                }
// IF CATEGORY SELECT IS INVALID
                else {
                    System.out.println("INVALID CHOICE!");
                    System.out.println("Another Transaction?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    repeat = scan.nextInt();
                }
// END OF DO LOOP
            }
            i++;
        }
        while (repeat == 1);
    }


    // METHOD FOR ITEM LIST
    public static void ItemList(int item, int finish, int Quantity[][], Scanner scan) {
        for (item = 0; finish == 1; item++) {
            System.out.println("________________________________________________");
            System.out.println("Product List");
            System.out.println("||   Services          " + "|         Products           ||");
            System.out.println(TypeList.getHairCutN() + "\t" + TypeList.getOuiN());
            System.out.println(TypeList.getHairColN() + "\t" + TypeList.getLivN());
            System.out.println(TypeList.getHairWaxN() + "\t" + TypeList.getOlapN());
            System.out.println(TypeList.getNailTreatN() + "\t" + TypeList.getArataN());
            System.out.println("________________________________________________");

            
			// INPUT OF ITEM TYPE & QUANTITY
			
            // Item Type
            System.out.println("________________________________________________");
            System.out.println("Select Product");
            Quantity[item][0] = scan.nextInt();

            // Quantity
            if ((Quantity[item][0] > 8) || (Quantity[item][0] < 0)) {
                finish = 1;
            } else {
                System.out.println("------------------------------------------------");
                System.out.println("How Many?");
                Quantity[item][1] = scan.nextInt();
                System.out.println("________________________________________________");
            }
            // Matching input with variables

            switch (Quantity[item][0]) {
                case 1:
                    System.out.println("Hair Cutting: " + "RM" + PriceList.getHairCutP());
                    Quantity[item][0] = (int) PriceList.getHairCutP();
                    break;
                case 2:
                    System.out.println("Hair Colouring: " + "RM" + PriceList.getHairColP());
                    Quantity[item][0] = (int) PriceList.getHairColP();
                    break;
                case 3:
                    System.out.println("Hair Waxing: " + "RM" + PriceList.getHairWaxP());
                    Quantity[item][0] = (int) PriceList.getHairWaxP();
                    break;
                case 4:
                    System.out.println("Nail treatment: " + "RM" + PriceList.getNailTreatP());
                    Quantity[item][0] = (int) PriceList.getNailTreatP();
                    break;
                case 5:
                    System.out.println("OUI Repair Shampoo: " + "RM" + PriceList.getOuiP());
                    Quantity[item][0] = (int) PriceList.getOuiP();
                    break;
                case 6:
                    System.out.println("Living Proof Dry Shampoo: " + "RM" + PriceList.getLivP());
                    Quantity[item][0] = (int) PriceList.getLivP();
                    break;
                case 7:
                    System.out.println("Olaplex Bonding Oil: " + "RM" + PriceList.getOlapP());
                    Quantity[item][0] = (int) PriceList.getOlapP();
                    break;
                case 8:
                    System.out.println("Arata Hair Cream: " + "RM" + PriceList.getArataP());
                    Quantity[item][0] = (int) PriceList.getArataP();
                    break;
                default:
                    System.out.println("Product Select Invalid!!");
                    Quantity[item][0] = 0;
            }


            if (Quantity[item][0] == 0) {
                finish = 1;
            } else {
                System.out.println("RM" + (Quantity[item][0]) + " X " + (Quantity[item][1]) + " = " + "RM" + (Quantity[item][0] * Quantity[item][1]));
                System.out.println("________________________________________________");

                // BUY ANOTHER PRODUCT?
                System.out.println("Anything else?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                finish = scan.nextInt();

            }
        }
    }

    // METHOD FOR TOTAL AMOUNT
    public static void TotalAmount(int item, int Quantity[][], double total[], int i) {

        System.out.println("________________________________________________");
        System.out.println("TOTAL");
        System.out.println("________________________________________________");

        // NOT PRINT EMPTY VALUES OF PRODUCT QUANTITY
        for (item = 0; item <= 8; item++) {
            if (Quantity[item][0] * Quantity[item][1] == 0) {

            } else {
                System.out.println(" RM" + (Quantity[item][0]) + " X " + (Quantity[item][1]) + " = " + "RM" + (Quantity[item][0] * Quantity[item][1]));
            }
        }

        System.out.println("------------------");


        // COMPUTING FOR TOTAL AMMOUNT
        for (item = 0; item <= 8; item++) {
            total[i] += Quantity[item][0] * Quantity[item][1];

        }
    }
}