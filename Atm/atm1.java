import java.util.*;
class Atm1{
    private static Scanner sc = new Scanner(System.in);
    static String users[] = {"santhosh","vasanth"};
    static int balance[] = {20000,30000};
    static int pin[] = {1234,4321};
    static int amount[] = {0,0,0,0};
    static int amount1[] = {100,200,500,2000};
    static int locker = 0;
    static int ind=0;
    static int attempt = 1;
    static void homescreen(){
        while(true){
        System.out.println("1. Admin login.");
        System.out.println("2. User login.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int a = sc.nextInt();
        switch(a){
            case 1:
            System.out.println("\033[H\033[2J");
            System.out.print("Enter Admin Name: ");
            String adminname = sc.next();
            System.out.print("Enter Admin ID: ");
            int adminid = sc.nextInt();
            if(adminname.equals("admin") && adminid == 1234){
                System.out.println("\033[H\033[2J");
                System.out.println("Admin login successfull");
                adminscreen();
            }
            else if(adminname.equals("admin1") && adminid == 4321){
                System.out.println("\033[H\033[2J");
                System.out.println("Admin login successfull");
                adminscreen();
            }
            else{
                System.out.println("Invalid Input");
            }
                break;
            
            case 2:
            if(attempt<=3){
            System.out.println("\033[H\033[2J");
            System.out.print("Enter User Name: ");
            String username = sc.next();
            System.out.print("Enter User Pin: ");
            int userpin = sc.nextInt();
            for(int i=0;i<users.length;i++){
                if(username.equals(users[i])){
                    ind=i;
                }
            }
            if(username.equals(users[ind]) && userpin==pin[ind]){
                userscreen();
        }
        else{
            System.out.println("Invalid Input");
            attempt++;
        }
    }
    else{
        System.out.println("Attemps exceeded");
    }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\033[H\033[2J");
                System.out.println("Invalid Input");
                break;
        }
        System.out.println("Press 0 to continue");
            int sf = sc.nextInt();
            if(sf==0){
                System.out.println("\033[H\033[2J");
    }   
    }
}

    static void adminscreen(){
        while(true){ 
        System.out.println("1. Load amount");
        System.out.println("2. Amount available");
        System.out.println("3. Back");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int b = sc.nextInt();
        switch(b){
            case 1:
            System.out.println("\033[H\033[2J");
               loadamount();
               System.out.println("\033[H\033[2J");
               break;
            case 2:
            System.out.println("\033[H\033[2J");
                showamount();
                break;
            case 3:
            System.out.println("\033[H\033[2J");
                homescreen();
            break;
            case 4:
                System.exit(0);
            break;
            default:
            System.out.println("\033[H\033[2J");
            System.out.println("Invalid Input");

            break;
        }
    }
    }

    static void loadamount(){
            for(int i=0;i<4;i++){
                System.out.print(amount1[i]+"-->: ");
                amount[i]+=sc.nextInt();
            }
            System.out.println("Amount loaded successfully");
            System.out.println("Press 0 to continue");
            int sn = sc.nextInt();
            if(sn==0){
                System.out.println("\033[H\033[2J");    
                adminscreen();
            }    
    }

    static void showamount(){
        for(int i=0;i<4;i++){
            System.out.println(amount1[i]+"--> "+amount[i]);
            locker+= amount1[i]*amount[i];
        }
            System.out.println("Total locker amount: "+locker);
            System.out.println("Press 0 to continue");
            int sn = sc.nextInt();
            if(sn==0){
                System.out.println("\033[H\033[2J");    
                adminscreen();
            }    
    }

    static void userscreen(){
        while(true){
        System.out.println("1. Withdraw.");
        System.out.println("2. Deposit.");
        System.out.println("3. Check Balance.");
        System.out.println("4. Pin Change.");
        System.out.println("5. Back.");
        System.out.println("6. Exit.");
        System.out.print("Enter your choice: ");
        int n = sc.nextInt();
        switch(n){
            case 1:
            System.out.println("\033[H\033[2J");
            withdraw();
            break;
            case 2:
            System.out.println("\033[H\033[2J");
            deposit();
            break;
            case 3:
            System.out.println("\033[H\033[2J");
            balance();
            break;
            case 4:
            System.out.println("\033[H\033[2J");
            pinchange();
            case 5:
            System.out.println("\033[H\033[2J");
            homescreen();
            break;
            case 6:
            System.exit(0);
            break;
            default:
            System.out.println("\033[H\033[2J");
            System.out.println("Invalid Input");
            break;
        }
        System.out.println("Press 0 to continue");
            int sf = sc.nextInt();
            if(sf==0){
                System.out.println("\033[H\033[2J");
    }   
    }
    }
    static void pinchange(){
        System.out.print("Enter your CurrentPin: ");
        int pinnum = sc.nextInt();
        if(pinnum == pin[ind]){
            System.out.print("Enter new pin :");
            int pinnum1 = sc.nextInt();
            System.out.print("Confirm New Pin: ");
            int pinnum2 = sc.nextInt();
            if(pinnum1==pinnum2){
                pin[ind]=pinnum1;
                System.out.println("Pin Changed Successfully");
            }
            else{
                System.out.println("New Pin MisMatch");
            }
            }
            else{
                System.out.println("Invalid pin");
            } 
            System.out.println("Press 0 to continue");
            int sf = sc.nextInt();
            if(sf==0){
                System.out.println("\033[H\033[2J");
    }   
        }
    static void withdraw(){
        System.out.print("Enter amount to be withdrawn: ");
        int collect = sc.nextInt();
        if(collect>balance[ind]){
            System.out.println("Insufficient Balance");
        }
        else if(collect>locker){
            System.out.println("Insufficient Balance in Machine");
        }
        else{
        System.out.println("Amount withdraw successfull");
        balance[ind] = balance[ind]-collect;
        System.out.println("Your Balance: "+balance[ind]);
        }
        System.out.println("Press 0 to continue");
        int sf = sc.nextInt();
        if(sf==0){
            System.out.println("\033[H\033[2J");
        }    
    }
    static void balance(){
    System.out.println("Your Balance: "+balance[ind]);
            System.out.println("Press 0 to continue");
            int sf = sc.nextInt();
            if(sf==0){
                System.out.println("\033[H\033[2J");
            }    
}
    static void deposit(){
        int count = 0;
            for(int i=0;i<4;i++){
                System.out.print("Enter No. of "+amount1[i]+"'s to be deposited: ");
                amount[i]+=sc.nextInt();
                count+= amount[i]*amount1[i];
            }
            balance[ind]+=count;
            System.out.println("Total Amount Deposited: "+count);
            System.out.println("Your Balance: "+balance[ind]);
            System.out.println("Press 0 to continue");
            int sn = sc.nextInt();
            if(sn==0){
                System.out.println("\033[H\033[2J");
            }    
    }
    public static void main(String ar[]){
        homescreen();
    }
}