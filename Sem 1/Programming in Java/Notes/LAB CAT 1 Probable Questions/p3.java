/*
 * Write a program to read the marks obtained by 10 students in an internal exam through command line arguments and store them in 
 * a float array. Determine the average mark and display the count of the number of students who have scored more than the average.
 */

import javax.swing.text.html.StyleSheet;

class p3{
    public static void main(String[] args) {
        float marks[] = new float[10];
        float sum = 0.0f;
        int count = 0;
        for(int i = 0; i < 10; i++){
        marks[i] = Float.parseFloat(args[i]);
        sum += marks[i];
        }
        sum = sum / 10;
        System.out.println("The average mark is " + sum);
        for(int i = 0; i < 10; i++)
            if(marks[i] >= sum)
                count++;
        System.out.println(count + " number of students scored above average.");
    }
}