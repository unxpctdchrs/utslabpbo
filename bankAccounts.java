import java.util.ArrayList;

public class bankAccounts{
    String name;
    int accountNumber;
    float balance;
    String regisDate;

    int userTotal = 0;
    static ArrayList <bankAccounts> accounts = new ArrayList<bankAccounts>();

    //nyimpan accountNumber
    static ArrayList <Integer> accountNumbers = new ArrayList<Integer>();

    public void bankAccount (String name, int accountNumber, float balance, String regisDate){
        bankAccounts newAccount = new bankAccounts();
        newAccount.name = name;
        newAccount.accountNumber = accountNumber;
        newAccount.balance = balance;
        newAccount.regisDate = regisDate;
        accounts.add(newAccount);
        accountNumbers.add(accountNumber);//nambah account number yg udh di generate pertama kali
    }

    public void getData(){
        System.out.println("user total : " + userTotal);
        System.out.println("=============== Accounts ===============");

        //loop arraylist sizenya buat ngambil semua data
        for(int i = 0; i < accounts.size(); i++){
            System.out.println("name : "+accounts.get(i).name);
            System.out.println("account number : " + accounts.get(i).accountNumber);
            System.out.println("balance : " + accounts.get(i).balance);
            System.out.println("registration date : " + accounts.get(i).regisDate);
            System.out.println("========================================");
        }
    }

    public void transfer(int originAcc, int destinationAcc, float amount){
        bankAccounts originAccount = null;
        bankAccounts destinationAccount = null;
        
        // cari akun dengan nomor akun
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountNumber == originAcc) {
                originAccount = accounts.get(i);
            }
            if (accounts.get(i).accountNumber == destinationAcc) {
                destinationAccount = accounts.get(i);
            }
        }
        
        // Perform the transfer
        originAccount.balance -= amount;
        destinationAccount.balance += amount;

    }

    public void deposit(int originAcc, float amount){
        bankAccounts originAccount = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountNumber == originAcc) {
                originAccount = accounts.get(i);
            }
        }

        // perform the deposit
        originAccount.balance += amount;

    }
}