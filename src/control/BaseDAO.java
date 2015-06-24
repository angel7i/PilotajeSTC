package control;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.ServiceRegistry;
import tablesB.Actualizaciones;

import java.util.List;
import java.util.Objects;

public class BaseDAO
{
    private static String database;
    private static String db;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static String config(int sta)
    {
        switch (sta)
        {
            case 1:
                return "RomRub.cfg.xml";
            case 2:
                return "BueVis.cfg.xml";
            case 3:
                return "Garibal.cfg.xml";
            case 4:
                return "Tepito.cfg.xml";
            case 5:
                return "SanLaz.cfg.xml";
            case 6:
                return "DepOce.cfg.xml";
            case 7:
                return "VilAra.cfg.xml";
            case 8:
                return "Impul.cfg.xml";
            case 9:
                return "Muzquiz.cfg.xml";
            case 10:
                return "Olimp.cfg.xml";
            case 11:
                return "CdAzt.cfg.xml";
            case 12:
                return "PmtCdAzt.cfg.xml";
        }

        return "";
    }

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure(database);

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(int sta)
    {
        if (sessionFactory == null)
        {
            System.out.println("Load Linea");
            sessionFactory = buildSessionFactory();
        }
        else
        {
            if (!Objects.equals(database, db))
                sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }

    public static List<Actualizaciones> getActualizacion(int sta)
    {
        db = database;
        database = config(sta);
        List<Actualizaciones> la = null;
        Session session = getSessionFactory(sta).openSession();
//        session.setFlushMode(FlushMode.MANUAL);
        ManagedSessionContext.bind(session);
        Transaction tr = session.getTransaction();

        try
        {
            tr.begin();
            la = session.createCriteria(Actualizaciones.class).list();
//            ManagedSessionContext.unbind(sessionFactory);
//            session.flush();

            if (!tr.wasCommitted())
                tr.commit();
        }
        catch (JDBCConnectionException je)
        {
            System.out.println("Error1");
//            if (tr != null)
//                tr.rollback();

            je.printStackTrace();
        }
        catch (HibernateException he)
        {
            System.out.println("Error2");
//            if (he instanceof TransactionException)
//            {
//                return null;
//            }
//            else if (tr != null)
//                return null;

            he.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println("Error3");
//            if (tr != null)
//                return null;

            e.printStackTrace();
        }
        finally
        {
            if (session.isConnected() || session.isOpen())
                session.close();
            ManagedSessionContext.unbind(sessionFactory);
        }

        return la;
    }
}
