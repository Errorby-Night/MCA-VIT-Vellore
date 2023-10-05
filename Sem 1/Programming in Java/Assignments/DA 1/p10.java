import java.util.*;

abstract class ThreeDimensionalShape{
    public abstract void getData();
    public abstract void areaShapes();
}

class Cube extends ThreeDimensionalShape{
    int edge;
    public void getData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge length: ");
        edge = sc.nextInt();
    }

    public void areaShapes(){
        System.out.println("Area of the cube is: " + (6 * edge * edge));
    }
}

class RectangularPrism extends ThreeDimensionalShape{
    int length, width, height;
    public void getData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        length = sc.nextInt();
        System.out.print("Enter the width: ");
        width = sc.nextInt();
        System.out.print("Enter the height: ");
        height = sc.nextInt();
    }

    public void areaShapes(){
        int area = 2 * ((width * length) + (length * height) + (height * width));
        System.out.println("Area of the rectangular prism is: " + area);
    }
}

class p10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char shape_type;
        System.out.print("Enter the type of three dimensional shapes(c/r): ");
        shape_type = sc.next().charAt(0);
        switch(shape_type){
            case 'c':
                Cube c = new Cube();
                c.getData();
                c.areaShapes();
                break;
            case 'r':
                RectangularPrism rp = new RectangularPrism();
                rp.getData();
                rp.areaShapes();
        }


        sc.close();
    }
}