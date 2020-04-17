/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.model;

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
@Table(name = "kupac")
public class Kupac extends Entitet{
    
    
    private String ime;
    private String prezime;
    private String oib;
    private String email;
    private String brojTelefona;
    private String brojUgovora;
    
    @Override
    public String toString() {
        return prezime + " " + ime;
    }

}
