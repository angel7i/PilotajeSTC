package tablesB;
// Generated Jun 17, 2015 3:02:42 PM by HRomRub Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Actualizaciones generated by hbm2java
 */
@Entity
@Table(name="actualizaciones"
    ,catalog="pilotaje"
)
public class Actualizaciones  implements java.io.Serializable {


     private String nombre;
     private String estado;
     private Date fecha;

    public Actualizaciones() {
    }

    public Actualizaciones(String nombre, String estado, Date fecha) {
       this.nombre = nombre;
       this.estado = estado;
       this.fecha = fecha;
    }
   
     @Id 

    
    @Column(name="nombre", unique=true, nullable=false, length=4)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {

        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString()
    {
        return nombre + " Est: " + estado  + " Fec: " + fecha;
    }
}


