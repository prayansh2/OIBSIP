import java.util.Scanner;


class BankAccount{
    String name;
    String userName;
    String password;
    String accountN0;
    Float balance = 100000f;
    int transaction = 0;
    String transactionHistory = "";

    public void register(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter your name :");
        this.name = sc.nextLine();
        System.out.println("Enter your username :");
        this.userName = sc.nextLine();
        System.out.println("Enter your password :");
        this.password = sc.nextLine();
        System.out.println("Enter your accountno :");
        this.accountN0 = sc.nextLine();
        System.out.println("\nRegistration Complete ...kindly login");
    }
    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("Enter Your Username");
            String Username = sc.nextLine();
            if(Username.equals(userName)) {
                while (!isLogin) {
                    System.out.println("Enter Your Password");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("Login successfull");
                        isLogin =true;
                    }
                    else{
                        System.out.println("Incorrect Password");
                    }
                }
            }
            else{
                System.out.println("Username not Fond");
            }
        }
        return isLogin;
    }
    public void withdraw() {
        System.out.println("Enter amount to withdraw :");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if (balance >= amount){
                transaction++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + "Rs Withdraw\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("\nInsufficient Balance ");
            }
        }
        catch (Exception e){
        }
    }
    public void deposit(){
        System.out.println("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if (amount <= 100000f){
                transaction++;
                balance -= amount;
                System.out.println("\n Successfully Deposited");
                String str = amount + "Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("\nSorry.... Limit is 100000.00");
            }
        }
        catch (Exception e){
        }
    }


    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receipent's Name :");
        String receipent = sc.nextLine();
        System.out.println("Enter amount to transfer:");
        float amount = sc.nextFloat();

        try{
            if (balance >= amount){
                if (amount <= 50000f){
                    transaction++;
                    balance -= amount;
                    System.out.println("\n Successfully Transfered to "+ receipent);
                    String str = amount + "Rs transfered to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry.... Limit is 50000.00");
                }
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch (Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n" + balance + "Rs ");
    }

    public void transHistory(){
        if( transaction == 0){
            System.out.println("\nEmpty");
        }
        else{
            System.out.println("\n"+ transactionHistory);
        }
    }
}
public class AtmInterface{

    public static int takenIntegerInput(int limit){
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try{
                Scanner sc = new Scanner(System.in);
                input =sc.nextInt();
                flag = true;
                if (flag && input>limit || input<1){
                    System.out.println("Choose the number between 1 to" + limit);
                    flag=false;
                }
            }catch(Exception e){
                System.err.println("Enter only integer value.");
                flag=false;
            }
        }
        return input ;
    }

    public static void main(String[] args) {
        System.out.println("\n******************** WELCOME TO BOI ATM INTERFACE********************** ");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Choose one option");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter Your Choice");
                int ch = takenIntegerInput(2);
                if (ch==1) {
                    if (b.login()) {
                        System.out.println("\n******************** WELCOME BACK" + b.name +"********************** ");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("1.withdraw \n2.Deposite \n3.Transfer \n4.check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice");
                            int c = takenIntegerInput(2);
                            switch (c) {
                                case 1:
                                    b.withdraw();

                                case 2:
                                    b.deposit();

                                case 3:
                                    b.transfer();
                                case 4 :
                                    b.checkBalance();
                                case 5 :
                                    b.transHistory();

                                case 6:
                                    isFinished =true;
                                    break;

                            }
                        }
                    }

                }
                else{
                    System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }
    }
}






