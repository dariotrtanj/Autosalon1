/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Prodavac;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author TRTANJ
 */
public class ObradaProdavac extends Obrada<Prodavac>{
    
    

    public ObradaProdavac() {
        super();
    }
    public ObradaProdavac(Prodavac entitet) {
        super(entitet);
    }
    
    
    public Prodavac autoriziraj(String email, String lozinka){
        
        List<Prodavac> lista = session.createQuery("from Prodavac o "
                + " where o.email=:email")
                .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Prodavac o = lista.get(0);
        if(o==null){
            return null;
        }
        
        return BCrypt.checkpw(lozinka, o.getLozinka()) ? o : null;
    }
    
    
    @Override
    public List<Prodavac> getPodaci() {
        return session.createQuery("from Prodavac").list();
        
    }
    
    public List<Prodavac> getPodaci(String uvjet) {
        return session.createQuery("from Prodavac p "
                + " where concat(p.ime, ' ', p.prezime) like :uvjet "
                + " or concat(p.prezime, ' ', p.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }
    
    
    @Override
    protected void kontrolaCreate() throws AutosalonException {
       kontrolaEmail();
       //kontrolaLozinka();
       
    }
    
    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }
    
    @Override
    protected void kontrolaDelete() throws AutosalonException {
        
    }
    
    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }

    private void kontrolaLozinka() throws AutosalonException {
        if(entitet.getLozinka()==null || BCrypt.checkpw("", entitet.getLozinka())){
            throw new AutosalonException("Obavezno lozinka");
    }
        
   
}

    protected void kontrolaEmail()  throws AutosalonException{
       
    }

    
    
    

}

    

