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

import java.net.InetAddress;
import java.util.List;
import java.util.Objects;

public class LineaBDAO
{
    private static String database;
    private static String db;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static String url;

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

            url = configuration.getProperty("connection.url").substring(13).split("/")[0];

            InetAddress address = InetAddress.getByName(url);
            boolean reachable = address.isReachable(2000);


            if (!reachable)
            {
                return null;
            }

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
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
                System.out.println("\r" + database + " = " + db);
                if (!Objects.equals(database, db))
                {
                    System.out.println("Change to " + database);
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
//        System.out.println("Estacion = " + database);
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
                System.out.println("Error de Servicio");
                if (sessionFactory != null && !sessionFactory.isClosed())
                {
                    sessionFactory.close();
                }

                return null;
            }
            else if (e instanceof NullPointerException)
            {
                System.out.println("Error de Session");
                if (sessionFactory != null && !sessionFactory.isClosed())
                {
                    sessionFactory.close();
                }

                return null;
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
            if (sessionFactory != null && !sessionFactory.isClosed())
            {
                sessionFactory.close();
            }

            return null;
        }
        catch (Exception e)
        {
            System.out.println("Error2");
            if (sessionFactory != null && !sessionFactory.isClosed())
            {
                sessionFactory.close();
            }


            return null;
        }
        finally
        {
            if (session != null && (session.isConnected() || session.isOpen()))
            {
                if (tr != null && tr.isActive())
                {
                    tr.rollback();
                }

                session.close();
                session = null;
            }

            ManagedSessionContext.unbind(sessionFactory);
        }

        return la;
    }
}
