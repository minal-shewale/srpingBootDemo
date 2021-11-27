package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private  static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

       boolean flag = false;

       Session session= factory.openSession();

        List<Employee> empList=session.createQuery("from Employee").list();

        for(Employee e: empList)
        {
            if (e.getEmpEmailId().equals(empEmailId)&&e.getEmpPassword().equals(empPassword))
            {
                flag=true;
            }
        }

        return flag;
    }
}
