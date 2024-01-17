public class Student {
    private int regno, int_mark, end_mark;
    private String name, course;
    
    Student(int regno, String name, String course, int int_mark, int end_mark){
        this.regno = regno;
        this.name = name;
        this.course = course;
        this.int_mark = int_mark;
        this.end_mark = end_mark;
    }
    void isPassFail()throws FailedException{
        if(end_mark < 40 || (int_mark + (end_mark * 0.4) < 46))
            throw new FailedException("Invalid Mark Exception");
    }
}
