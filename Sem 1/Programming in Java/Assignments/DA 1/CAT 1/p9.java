import java.util.*;

class Account{
    String Name;
    long acc_no;
    int balance;

    public Account(String Name, long acc_no, int balance){
        this.Name = Name;
        this.acc_no = acc_no;
        this.balance = balance;
    }

    void withdraw(int withdrawAmt){
        balance -= withdrawAmt;
    }

    void deposit(int depositAmt){
        balance += depositAmt;
    }

    void balanceEnquiry(){
        System.out.println("Balance: " + balance);
    }

    void display(){
        System.out.printf("Name: %s\nAccount Number: %d\nBalance: %d\n", Name, acc_no, balance);
    }
}

class SavingsAccount extends Account{
    int interest_rate;
    public SavingsAccount(String Name, long acc_no, int balance, int interest_rate){
        super(Name, acc_no, balance);
        this.interest_rate = interest_rate;
    }
    int calculateInterest(){
        return (super.balance * interest_rate / 100);
    }
}

class CurrentAccount extends Account{
    int fee;
    public CurrentAccount(String Name, long acc_no, int balance, int fee){
        super(Name, acc_no, balance);
        this.fee = fee;
    }

    void withdraw(int withdrawAmt){
        balance -= withdrawAmt - fee;
    }

    void deposit(int depositAmt){
        balance += depositAmt - fee;
    }
}

class p9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the account holder: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        long acc_no = sc.nextLong();
        System.out.print("Choose the type of account:\n1. Savings\n2. Current\n");
        int acc_type = sc.nextInt();
        System.out.print("Initial Balance: ");
        int bal = sc.nextInt();
        
        if(acc_type == 1){
            int op = 0;
            System.out.print("Interest Rate: ");
            int rate = sc.nextInt();
            SavingsAccount acc = new SavingsAccount(name, acc_no, bal, rate);
            while(op != 6){
                
                System.out.println("Perform the following operations:\n1. Deposit\n2. Withdraw\n3. Calculate Interest\n4. Enquire Balance\n5. Display Details\n6. Exit\nEnter your choice: ");
                op = sc.nextInt();
                switch(op){
                    case 1:
                        System.out.print("Enter the amount you want to deposit: ");
                        int depositAmt = sc.nextInt();
                        acc.deposit(depositAmt);
                        break;
                    case 2:
                        System.out.print("Enter the amount you want to withdraw: ");
                        int withdrawAmt = sc.nextInt();
                        acc.deposit(withdrawAmt);
                        break;
                    case 3:
                        int interest = acc.calculateInterest();
                        acc.balance += interest;
                        System.out.println("Interest: " + interest+"\nBalance after calculating interest: " + acc.balance);
                        break;
                    case 4:
                        acc.balanceEnquiry();
                        break;
                    case 5:
                        acc.display();
                }

            }
        }

        if(acc_type == 2){
            int op = 0;
            System.out.print("Fee per transaction: ");
            int fee = sc.nextInt();
            Account acc = new CurrentAccount(name, acc_no, bal, fee);
            while(op != 5){
                System.out.println("Perform the following operations:\n1. Deposit\n2. Withdraw\n3. Enquire Balance\n4. Display Details\n5. Exit\nEnter your choice: ");
                op = sc.nextInt();
                switch(op){
                    case 1:
                        System.out.print("Enter the amount you want to deposit: ");
                        int depositAmt = sc.nextInt();
                        acc.deposit(depositAmt);
                        break;
                    case 2:
                        System.out.print("Enter the amount you want to withdraw: ");
                        int withdrawAmt = sc.nextInt();
                        acc.deposit(withdrawAmt);
                        break;
                    case 3:
                        acc.balanceEnquiry();
                        break;
                    case 4:
                        acc.display();
                }

            }
        }
        sc.close();
    }
}