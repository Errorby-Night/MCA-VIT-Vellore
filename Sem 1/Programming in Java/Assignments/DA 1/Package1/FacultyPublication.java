package Package1;

public class FacultyPublication{
    public int id, nop, noc;
    public String Name;
    
    public FacultyPublication(String Name, int id, int nop, int noc){
        this.id = id;
        this.nop = nop;
        this.noc = noc;
        this.Name = Name;
    }

    public void display(){
        System.out.println("ID: " + id + "\nName: " + Name + "\nNumber of publications: " + nop + "\nNumber of citations: " + noc);
    }
}