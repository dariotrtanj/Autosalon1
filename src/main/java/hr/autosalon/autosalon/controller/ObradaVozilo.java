/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;


import hr.autosalon.autosalon.model.Vozilo;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;

/**
 *
 * @author TRTANJ
 */
public class ObradaVozilo extends Obrada<Vozilo>{

    public ObradaVozilo(Vozilo entitet) {
        super(entitet);
    }

    public ObradaVozilo() {
        super();
        
    }
   

    @Override
    protected void kontrolaCreate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutosalonException {
       
    }

    @Override
    public List<Vozilo> getPodaci() {
        return session.createQuery("from Vozilo").list();
        
    }
    
    public List<Vozilo> getPodaci(String uvjet) {
        return session.createQuery("from Vozilo p "
                + " where concat(p.marka, ' ', p.model) like :uvjet "
                + " or concat(p.model, ' ', p.marka) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }
    

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }

    

    
}
    

       
    

    

