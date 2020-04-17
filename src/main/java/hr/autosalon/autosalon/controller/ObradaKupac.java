/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Kupac;
import hr.autosalon.autosalon.model.Vozilo;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;


/**
 *
 * @author TRTANJ
 */
public  class ObradaKupac extends Obrada<Kupac>{
    
    public ObradaKupac(Kupac entitet){
        super(entitet);
    }
    
    public ObradaKupac(){
        super();
    }
    
    
    
    @Override
    protected void kontrolaCreate() throws AutosalonException {
       kontrolaBrojUgovora();
      // kontrolaIstiNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutosalonException {
        
    }
    
    private void kontrolaBrojUgovora() throws AutosalonException{
        
    }

    @Override
    public List<Kupac> getPodaci() {
        return session.createQuery("from Kupac").list();
        
    }
    
     public List<Kupac> getPodaci(String uvjet){
        
         return session.createQuery("from Kupac p "
                + " where concat(p.ime, ' ', p.prezime) like :uvjet "
                + " or concat(p.prezime, ' ', p.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
     }
     

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }
    
    private void kontrolaIstiNaziv() throws AutosalonException {
        //kreirajte kontrolu koja će javiti da isti naziv postoji
      // u bazi i zbog toga neće kreirati novi smjer
    
        for (Kupac k : getPodaci()) {
            if(k.getIme().toString().equals(entitet.getIme())&&k.getPrezime().toString().equals(entitet.getPrezime())){
                   throw  new AutosalonException("Kupac postoji u bazi, odaberite drugo ime i prezime");
            }
        }
      
    }
    

}

    
        
    
    
   
    

