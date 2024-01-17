import org.hibernate.*;
import org.hibernate.boot.*;

public class test1{
    public static void main(String args[]){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();;
        MetaData meta MetaDataSources(ssr).getMetaDataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Trasaction t = session.beginTransaction();
        Employee e1 = new Employee();
        e1.setID(100);
        e1.setName("Srijan");
        e1.setSalary(1000000);
        session.save(e1);
        t.commit();
        factory.close();
        session.close();
    }
}