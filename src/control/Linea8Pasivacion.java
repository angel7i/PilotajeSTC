package control;

import tables8.Cambioedo;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/pasivacion8")
public class Linea8Pasivacion extends HttpServlet implements Servlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            List<Cambioedo> cambioedos = null;
            int info = Integer.parseInt(req.getParameter("estacion"));

            if (req.getParameter("from") != null && req.getParameter("to") != null)
            {
                Date from = toDate(req.getParameter("from"));
                Date to = toDate(req.getParameter("to"));
                System.out.println("Estacion: " + info + " From:"+from+" To:"+to);
                cambioedos = Linea8DAO.getPasivacionesFromTo(info, from, to);
            }
            else
            {
                cambioedos = Linea8DAO.getPasivaciones(info);
            }
            if (cambioedos == null)
            {
//                System.out.println("Cambios null");
                JsonObject e = Json.createObjectBuilder().
                        add("error", "ErrorDB").build();
                resp.getWriter().print(e);
                return;
            }

            resp.getWriter().print(ArrayJson(cambioedos));
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

    private JsonArray ArrayJson(List<Cambioedo> cambioedos)
    {
        JsonArrayBuilder jsonArray = null;

        try
        {
            jsonArray = Json.createArrayBuilder();

            for (Cambioedo c : cambioedos)
            {
                JsonObject object = Json.createObjectBuilder().
                        add("vif1", c.getVif1()).
                        add("vif2", c.getVif2()).
                        add("vcor", c.getVcor()).
                        add("npc", c.getNpc()).
                        add("pfa1", c.getPfa1()).
                        add("pfa2", c.getPfa2()).
                        add("pfa3", c.getPfa3()).
                        add("pfa4", c.getPfa4()).
                        add("fecha", fecha(c.getFecha())).build();
                jsonArray.add(object);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return jsonArray.build();
    }

    private String fecha(Date d)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy" + "\n" +  "hh:mm:ss a");
        return format.format(d);
    }

    private Date toDate(String s)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        Date d = null;

        try
        {
            d = format.parse(s);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return  d;
    }
}
