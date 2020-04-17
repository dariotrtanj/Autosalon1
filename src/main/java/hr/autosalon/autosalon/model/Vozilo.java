/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TRTANJ
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "vozilo")
public class Vozilo extends Entitet{
    
    
    private String marka;
    private String model;
    private Integer godiste;
    private Integer kilometraza;
    private BigDecimal cijena;
    private Boolean uvoz;
    
   
    @Override
    public String toString() {
        return getMarka() + " " + getModel();
    }

    

    
    
    
}
