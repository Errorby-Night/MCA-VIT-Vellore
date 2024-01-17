import java.util.*;


class GameCharge{
    String name;
    int g_type;
    char p_type;
    int amount;
    public GameCharge(){
        name = "";
        g_type = 0;
        p_type= '\0';
        amount = 0;
    }
    public void getData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Person Name: ");
        name = sc.nextLine();
        System.out.print("Select Game Type:\n1. Gymnasium & Snooker\n2. Indoor Badminton\n3. Squash\n4. Synthetic Tennis\nEnter your choice: ");
        g_type = sc.nextInt();
        sc.nextLine();   // consume \n
        System.out.print("Select the person type:\nS - Student\nF - Faculty\nEnter your choice: ");
        p_type = sc.next().charAt(0);
    }
    public static void dispAmount(GameCharge a[]){
        for (int i = 0 ;i < a.length; i++){
            if(a[i].g_type == 1){
                if(a[i].p_type == 'S')
                    a[i].amount = 2500;
                else
                    a[i].amount = 1750;
            }
            if(a[i].g_type == 2){
                if(a[i].p_type == 'S')
                    a[i].amount = 1000;
                else
                    a[i].amount = 750;
            }
            if(a[i].g_type == 3){
                if(a[i].p_type == 'S')
                    a[i].amount = 1000;
                else
                    a[i].amount = 750;
            }
            if(a[i].g_type == 4){
                if(a[i].p_type == 'S')
                    a[i].amount = 2000;
                else
                    a[i].amount = 1500;
            }

            System.out.println(a[i].name + " needs to pay: Rs " + a[i].amount);
        }
    }
}

class p8{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = sc.nextInt();
        GameCharge a[] = new GameCharge[n];
        System.out.println("Enter the details of the people:");
        for(int i = 0; i < n; i++){
            a[i] = new GameCharge();
            a[i].getData();
        }
        GameCharge.dispAmount(a);
        sc.close();
    }
}