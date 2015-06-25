package tables8;
// Generated Jun 22, 2015 2:37:51 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import static javax.persistence.GenerationType.*;

/**
 * Actual generated by hbm2java
 */
@Entity
@Table(name="actual"
    ,catalog="pilotaje8"
)
public class Actual  implements java.io.Serializable {


     private Integer id;
     private String vif1;
     private String vif2;
     private String vcor;
     private String npc;
     private String pfa1;
     private String pfa2;
     private String pfa3;
     private String pfa4;
     private Date fecha;

    public Actual() {
    }

    public Actual(String vif1, String vif2, String vcor, String npc, String pfa1, String pfa2, String pfa3, String pfa4, Date fecha) {
       this.vif1 = vif1;
       this.vif2 = vif2;
       this.vcor = vcor;
       this.npc = npc;
       this.pfa1 = pfa1;
       this.pfa2 = pfa2;
       this.pfa3 = pfa3;
       this.pfa4 = pfa4;
       this.fecha = fecha;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getActualcol() {
        return this.id;
    }
    
    public void setActualcol(Integer actualcol) {
        this.id = actualcol;
    }

    
    @Column(name="vif1", length=1)
    public String getVif1() {
        return this.vif1;
    }
    
    public void setVif1(String vif1) {
        this.vif1 = vif1;
    }

    
    @Column(name="vif2", length=1)
    public String getVif2() {
        return this.vif2;
    }
    
    public void setVif2(String vif2) {
        this.vif2 = vif2;
    }

    
    @Column(name="vcor", length=1)
    public String getVcor() {
        return this.vcor;
    }
    
    public void setVcor(String vcor) {
        this.vcor = vcor;
    }

    
    @Column(name="npc", length=1)
    public String getNpc() {
        return this.npc;
    }
    
    public void setNpc(String npc) {
        this.npc = npc;
    }

    
    @Column(name="pfa1", length=1)
    public String getPfa1() {
        return this.pfa1;
    }
    
    public void setPfa1(String pfa1) {
        this.pfa1 = pfa1;
    }

    
    @Column(name="pfa2", length=1)
    public String getPfa2() {
        return this.pfa2;
    }
    
    public void setPfa2(String pfa2) {
        this.pfa2 = pfa2;
    }

    
    @Column(name="pfa3", length=1)
    public String getPfa3() {
        return this.pfa3;
    }
    
    public void setPfa3(String pfa3) {
        this.pfa3 = pfa3;
    }

    
    @Column(name="pfa4", length=1)
    public String getPfa4() {
        return this.pfa4;
    }
    
    public void setPfa4(String pfa4) {
        this.pfa4 = pfa4;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


