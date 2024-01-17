package package1;

public class StraightLine {
    private int x1, y1, x2, y2;

    public StraightLine(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void findSlope(){
        double slope = (double)(this.y2 - this.y1) / (this.x2 - this.x1);
        System.out.println("The slope of the line is: " + slope);
    }
}
