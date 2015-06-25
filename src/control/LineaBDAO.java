package control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.UnknownServiceException;
import tablesB.Actualizaciones;

import java.util.List;
import java.util.Objects;

public class LineaBDAO
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
        try
        {
            if (sessionFactory == null)
            {
                System.out.println("Load " + database);
                sessionFactory = buildSessionFactory();
            }
            else
            {
                System.out.println(database + " = " + db);
                if (!Objects.equals(database, db))
                {
                    System.out.println("Change " + database);
                    sessionFactory.close();
                    sessionFactory = buildSessionFactory();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error Build");
            e.printStackTrace();
        }

        return sessionFactory;
    }

    public static List<Actualizaciones> getActualizacion(int sta)
    {
        db = database;
        database = config(sta);
        List<Actualizaciones> la = null;
        Session session = null;
        Transaction tr = null;

        try
        {
            session = getSessionFactory(sta).openSession();

            ManagedSessionContext.bind(session);
            tr = session.getTransaction();
        }
        catch (Exception e)
        {
            if (e instanceof UnknownServiceException)
            {
                sessionFactory.close();
                return null;
            }
            else
            {
                System.out.println("Error de Session");
                e.printStackTrace();
            }
        }


        try
        {
            tr.begin();
            la = session.createCriteria(Actualizaciones.class).list();

            if (!tr.wasCommitted())
                tr.commit();
        }
        catch (GenericJDBCException ge)
        {
            System.out.println("Error1");
            sessionFactory.close();
//            ge.printStackTrace();

            return null;
        }
        catch (Exception e)
        {
            System.out.println("Error2");
            e.printStackTrace();

            return null;
        }
        finally
        {
            if (session != null && (session.isConnected() || session.isOpen()))
                session.close();
            ManagedSessionContext.unbind(sessionFactory);
        }

        return la;
    }
}
