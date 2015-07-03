package control;

import tables8.Actual;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/estado8")
public class Linea8Estado extends HttpServlet implements Servlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            int info = Integer.parseInt(req.getParameter("estacion"));
            Actual a = Linea8DAO.getActualizacion(info);

            if (a == null)
            {
//                System.out.println("A null");
                JsonObject e = Json.createObjectBuilder().
                        add("error", "ErrorDB").build();
                resp.getWriter().print(e);
                return;
            }

            JsonObject object = Json.createObjectBuilder().
                    add("vif1", a.getVif1()).
                    add("vif2", a.getVif2()).
                    add("vcor", a.getVcor()).
                    add("npc", a.getNpc()).
                    add("pfa1", a.getPfa1()).
                    add("pfa2", a.getPfa2()).
                    add("pfa3", a.getPfa3()).
                    add("pfa4", a.getPfa4()).
                    add("fecha", fecha(a.getFecha())).build();

            resp.getWriter().print(object);
        }
        catch (NullPointerException npe)
        {
            System.out.println("NUllPoinExcp null");
            resp.getWriter().print("ErrorBD");
            npe.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req, resp);
    }

    private String fecha(Date d)
    {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a'   'dd/MM/yyyy");
        return format.format(d);
    }
}
