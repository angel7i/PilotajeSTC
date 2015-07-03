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
import tables8.Actual;
import tables8.Cambioedo;

import java.net.InetAddress;
import java.util.List;
import java.util.Objects;

public class Linea8DAO
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
                return "Iztac.cfg.xml";
            case 2:
                return "Chabac.cfg.xml";
            case 3:
                return "Garibal8.cfg.xml";
            case 4:
                return "Obrera.cfg.xml";
            case 5:
                return "Iztapa.cfg.xml";
            case 6:
                return "LaViga.cfg.xml";
            case 7:
                return "Consti.cfg.xml";
            case 8:
                return "UAM.cfg.xml";
            case 9:
                return "CerEst.cfg.xml";
            case 10:
                return "Escuad.cfg.xml";
            case 11:
                return "SalAgu.cfg.xml";
            case 12:
                return "BelArt.cfg.xml";
            case 13:
                return "SJuanL.cfg.xml";
            case 14:
                return "Aculco.cfg.xml";
            case 15:
                return "Apatlaco.cfg.xml";
            case 16:
                return "Coyuya.cfg.xml";
            case 17:
                return "Doctor.cfg.xml";
            case 18:
                return "Atlalilco.cfg.xml";
            case 19:
                return "SAnita.cfg.xml";
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

    public static Actual getActualizacion(int sta)
    {
        db = database;
        database = config(sta);
        List<Actual> la = null;
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
            else
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
            la = session.createCriteria(Actual.class).list();

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
            }

            ManagedSessionContext.unbind(sessionFactory);
        }

        return la.get(0);
    }

    public static List<Cambioedo> getPasivaciones(int sta)
    {
        db = database;
        database = config(sta);
        List<Cambioedo> cambioedos = null;
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
            }
            else
            {
                System.out.println("Error de Session");
                if (sessionFactory != null && !sessionFactory.isClosed())
                {
                    sessionFactory.close();
                }
            }

            return null;
        }
        try
        {
            tr.begin();
            cambioedos = session.createCriteria(Cambioedo.class).list();

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
                session.close();

            ManagedSessionContext.unbind(sessionFactory);
        }

        return cambioedos;
    }
}
