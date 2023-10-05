/* WAP to read marks of a student in 6 different subjects through command line arguments. Determine and display the average. */
class p1{
    public static void main(String args[]){
        double avg;
        double sum = 0.0;
        for(int i = 0; i < 6; i++)
            sum += Integer.parseInt(args[i]);
        avg = sum / 6.0;
        System.out.printf("The average is: %.2f", avg);
    }
}