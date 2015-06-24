package control;

import tablesB.Actualizaciones;

import javax.json.Json;
import javax.json.JsonArray;
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
import java.util.List;

@WebServlet("/estado")

public class Estado extends HttpServlet implements Servlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            int info = Integer.parseInt(req.getParameter("estacion"));
            List<Actualizaciones> a = BaseDAO.getActualizacion(info);

            if (a == null)
            {
                resp.getWriter().print("ErrorBD");
                return;
            }

            JsonObject e1 = Json.createObjectBuilder().
                    add("estado", a.get(0).getEstado()).
                    add("fecha", fecha(a.get(0).getFecha())).build();
            JsonObject e2 = Json.createObjectBuilder().
                    add("estado", a.get(1).getEstado()).
                    add("fecha", fecha(a.get(1).getFecha())).build();
            JsonObject e3 = Json.createObjectBuilder().
                    add("estado", a.get(2).getEstado()).
                    add("fecha", fecha(a.get(2).getFecha())).build();

            JsonArray array = Json.createArrayBuilder().
                    add(e1).add(e2).add(e3).build();

            resp.getWriter().print(array);
        }
        catch (NullPointerException npe)
        {
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
