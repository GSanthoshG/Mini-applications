import java.util.*;
public class Product{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<Integer> price = new ArrayList<>();
    static ArrayList<Integer> quantity = new ArrayList<>();
    static ArrayList<String> sellername = new ArrayList<>();
    static ArrayList<Integer> warranty = new ArrayList<>();
    static ArrayList<Integer> returntime = new ArrayList<>();
    static ArrayList<String> rating = new ArrayList<>();
    static int indexpro = 0, rem = 0;
    static void merchantpro(){
        System.out.println("1. Add Product. ");
        System.out.println("2. Edit Product. ");
        System.out.println("3. Remove Product. ");
        System.out.println("4. Back. ");
        System.out.println("5. Exit. ");
        System.out.print("Enter your choice: ");
        int as = sc.nextInt();
        switch(as){
            case 1:
            add_product();
            break;
            case 2:
            edit_product();
            break;
            case 3:
            remove_product();
            break;
            case 4:
            System.out.println("\033[H\033[2J");
            Merchantpage.merchant();
            break;
            case 5:
            Amazon1.exit();
            break;
            default:
            System.out.println("Invalid Input");
                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                System.out.println("\033[H\033[2J");
                merchantpro();
            break;
        }
    }
    
    static void add_product(){
            System.out.println("Enter product name: ");
            name.add(sc.next());
            System.out.println("Enter product price: ");
            price.add(sc.nextInt());
            System.out.println("Enter product quantity: ");
            quantity.add(sc.nextInt());
            System.out.println("How many months of warranty for your product?: ");
            warranty.add(sc.nextInt());
            System.out.println("Return time for your product: ");
            returntime.add(sc.nextInt());
            System.out.println("Rating for your product: ");
            rating.add(sc.next());
            sellername.add(Merchantpage.merchantname.get(Merchantpage.index));
            System.out.println("Product added successfully...");
                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                System.out.println("\033[H\033[2J");
                merchantpro();
                
            }
            
            static void edit_product(){
                System.out.println("Enter the name of the product to be edited: ");
                String sa = sc.next();
                int flag = 0;
                for(int i=0;i<name.size();i++){
                    if(sa.equals(name.get(i))){
                        indexpro=i;
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    System.out.println("\033[H\033[2J");
                    edits();
                }
                else{
                    System.out.println("Product not found");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edit_product();
                    }
            }

            static void edits(){
                System.out.println("1. Edit name");
                System.out.println("2. Edit price");
                System.out.println("3. Edit quantity");
                System.out.println("4. Edit warranty");
                System.out.println("5. Edit returntime");
                System.out.println("6. Edit rating");
                System.out.println("7. back");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                switch(ch){
                    case 1:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new name: ");
                    name.set(indexpro,sc.next());
                    
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 2:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new price: ");
                    price.set(indexpro,sc.nextInt());
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 3:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new quantity: ");
                    quantity.set(indexpro,sc.nextInt());
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 4:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new warrantyperiod: ");
                    warranty.set(indexpro,sc.nextInt());
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 5:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new returntime: ");
                    returntime.set(indexpro,sc.nextInt());
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 6:
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter new rating: ");
                    rating.set(indexpro,sc.next());
                    System.out.println("Changes made successfully");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    edits();
                    break;

                    case 7:
                    System.out.println("\033[H\033[2J");
                    merchantpro();
                    break;

                    default:
                    System.out.println("Invalid Input");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    merchantpro();
                    break;
                }
            }

    static void remove_product(){
        System.out.println("Enter product name: ");
        String sd = sc.next();
        for(int i=0;i<name.size();i++){
                if(name.get(i).equals(sd)){
                    rem = i;
                    break;
                }
        }
        name.remove(rem);
        price.remove(rem);
        quantity.remove(rem);
        warranty.remove(rem);
        returntime.remove(rem);
        rating.remove(rem);
        sellername.remove(rem);
        System.out.println("Product removed successfully.");
        System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    merchantpro();   
    }
}
