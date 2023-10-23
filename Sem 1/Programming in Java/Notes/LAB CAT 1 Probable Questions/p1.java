/*
 * WAP to read the rainfall recorded in 3 districts for the last 3 days through command line arguments and store it in a 2D array of type float. 
 * Display the highest rainfall in each district.
 */

class p1{
    public static void main(String[] args) {
        float arr[][] = new float[3][3];
        int k = 0;
        float max = 0.0f;
        for(int i = 0; i < 3; i++){      
            max = 0.0f;      
            for(int j = 0; j < 3; j++){
                arr[i][j] = Float.parseFloat(args[k++]);
                if(arr[i][j] > max)
                    max = arr[i][j];
            }
            System.out.println("The highest rainfall for district " + (i + 1) + "is: " + max);
        }
    }
}