/*  Create a class with two overloaded methods by name productOfNumbers(). The first version take two arguments - an array and the size of the array of type int. 
*   The method should return the product of all the array elements. The second version of the overloaded method should take arguments of floating point data type.
*   Create a main class to test the overloaded functions of the above class. 
*/


class Overload{
    public int productOfNumbers(int arr[], int n){
        int p = 1;
        for(int i = 0; i < n; i++)
            p *= arr[i];
        return p;
    }
    public double productOfNumbers(double arr[], int n){
        double p = 1.0;
        for(int i = 0; i < n; i++)
            p *= arr[i];
        return p;
    }
}

class p6{
    public static void main(String args[]){
        Overload obj = new Overload();
        System.out.println("Product is: " +obj.productOfNumbers(new int[]{2, 3, 5, 10, 2},5));
        System.out.printf("Product is: %.2f" ,obj.productOfNumbers(new double[]{2.5, 3.6, 4.3},3));
    }
}