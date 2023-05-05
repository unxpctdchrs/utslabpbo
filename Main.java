import java.util.Scanner;
import java.security.SecureRandom;

public class Main {
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        bankAccounts newbank = new bankAccounts();
        while(true){
            clearScreen();
            System.out.println("================ BANK OF IKLC ================");
            System.out.println("1. Register");
            System.out.println("2. Transfer");
            System.out.println("3. Deposit");
            System.out.println("==============================================");
            System.out.print(": ");

            try{
                int choice = scn.nextInt();
                if(choice == 1){
                    clearScreen();
                    
                    int accountNumber;
                    float balance;
                    System.out.print("input name : ");
                    String name = scn.next();
                    System.out.print("input balance : ");
                    balance = scn.nextFloat();

                    //time
                    java.util.Date dt = new java.util.Date();
                    java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String regisDate = SDF.format(dt);

                    //accountNumber
                    SecureRandom rand = new SecureRandom();
                    int randomInt = rand.nextInt(99999) + 100000;
                    accountNumber = randomInt;

                    newbank.bankAccount(name, accountNumber, balance, regisDate);
                    newbank.userTotal++;
                    
                    System.out.print("add another account? (y/n)");
                    String input = scn.next();

                    while(input.equals("y")){
                        System.out.print("input name : ");
                        name = scn.next();
                        System.out.print("input balance : ");
                        balance = scn.nextFloat();

                        //time
                        dt = new java.util.Date();
                        SDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        regisDate = SDF.format(dt);

                        //accountNumber
                        rand = new SecureRandom();
                        boolean isUnique = false;
                        while (!isUnique) {
                            randomInt = rand.nextInt(99999) + 100000;
                            if (!bankAccounts.accountNumbers.contains(randomInt)) {
                                isUnique = true;
                            }
                        }
                        accountNumber = randomInt;

                        newbank.bankAccount(name, accountNumber, balance, regisDate);
                        newbank.userTotal++;
                    
                        System.out.print("add another account? (y/n)");
                        input = scn.next();

                    }
                    
                }
                else if(choice == 2){
                    clearScreen();
                    newbank.getData();
                
                    System.out.print("Masukkan nomor akun pengirim : ");
                    int originAcc = scn.nextInt();
                    System.out.print("Masukkan nomor akun penerima : ");
                    int destinationAcc = scn.nextInt();
                    System.out.print("Masukkan nominal yang ingin di transfer : ");
                    float amount = scn.nextFloat();
                    
                    newbank.transfer(originAcc, destinationAcc, amount);
                    
                }
                else if(choice == 3){
                    clearScreen();
                    newbank.getData();
                    System.out.print("Masukkan nomor akun yang ingin diisi : ");
                    int originAcc = scn.nextInt();
                    System.out.print("Masukkan nominal yang ingin di deposit : ");
                    float amount = scn.nextFloat();

                    newbank.deposit(originAcc, amount);
                }
            } catch (Exception e){
                clearScreen();
                scn.nextLine();
            }
        }
    }
}

