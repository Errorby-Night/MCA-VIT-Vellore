
public class trys{
    public static void main(String args[]){
        int a[][] = new int[3][];
        a[0] = new int[2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1] = new int[3];
        a[1][0] = 3;
        a[1][1] = 4;
        a[1][2] = 5;
        for(int i = 0; i <a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
        }
    }
}