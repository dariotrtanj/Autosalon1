/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author TRTANJ
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "prodaja")
public class Prodaja extends Entitet {
    
    private Date datumProdaje;
    
    @OneToOne
    private Kupac kupac;
    
    @ManyToOne
    private Prodavac prodavac;
    
    @OneToOne
    private Vozilo vozilo;

    

  @Override
    public String toString() {
        return getVozilo().getMarka()+" "+getVozilo().getModel();
    }

    
}
