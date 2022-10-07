package Tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Tutorial.bean.Employee;

public class myBeanDAO {
	private static SessionFactory session;

    private static void connect() {
    	if (session == null) {
    		Configuration configuration = new Configuration();
    		configuration.configure("hibernate.cfg.xml");
    		configuration.addAnnotatedClass(Employee.class);
    		session = configuration.buildSessionFactory();
    	}
    }

    private static void disconnect() {
        if (session != null) {
            session.close();
        }
    }

    public static void save(Employee e) {
        connect();

        Session s = session.openSession();
        s.beginTransaction();
        s.save(e);
        s.getTransaction().commit();
        s.close();
    }   	

    public static Employee find(int id) {
        connect();

        Session s = session.openSession();
        s.beginTransaction();
        Employee e = (Employee) s.get(Employee.class, id);
        s.getTransaction().commit();
        s.close();
        return e;
    }

    public static List<Employee> findAll() {
        connect();

        Session s = session.openSession();
        s.beginTransaction();
        List<Employee> e = (List<Employee>) s.createQuery("from Employee").list();
        s.getTransaction().commit();
        s.close();
        return e;
    }
}
