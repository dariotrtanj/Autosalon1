/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon;

import hr.autosalon.autosalon.controller.ObradaKupac;
import hr.autosalon.autosalon.controller.ObradaProdavac;
import hr.autosalon.autosalon.controller.ObradaVozilo;
import hr.autosalon.autosalon.model.Kupac;
import hr.autosalon.autosalon.model.Prodaja;
import hr.autosalon.autosalon.model.Prodavac;
import hr.autosalon.autosalon.model.Vozilo;
import hr.autosalon.autosalon.util.AutosalonException;
import hr.autosalon.autosalon.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRTANJ
 */
public class Start {

  
    public Start(){
       /*HibernateUtil.getSessionFactory().openSession();*/
       
        /*List<Vozilo> lista = new ArrayList<>();
        Vozilo v;
        for (int i = 0; i < 1000; i++) {
            v=new Vozilo();
            v.setMarka("generirano" + i);
            lista.add(v);
            
        }*/
        
        /*Vozilo v = new Vozilo();
        v.setMarka("Volkswagen");
        v.setModel("Golf");
        v.setGodiste("godište");
        v.setKilometraza("kilometraza");
        v.setCijena(new BigDecimal(10000));
        v.setUvoz("true");
        ObradaVozilo ov = new ObradaVozilo(v);
        try {
            ov.create();
            } catch (AutosalonException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        Kupac k = new Kupac();
        k.setIme("Dario");
        k.setPrezime("Trtanj");
        k.setOib("63612978880");
        k.setEmail("trtanjd@gmail.com");
        k.setBrojTelefona("098683861");
        k.setBrojUgovora("369");
        ObradaKupac ok = new ObradaKupac(k);
        try {
            ok.create();
            } catch (AutosalonException ex) {
                System.out.println("Spremanje nije prošlo. Razlog:");
                System.out.println(ex.getPoruka());
                
                
        Prodavac p = new Prodavac();
        p.setIme("Ivan");
        p.setPrezime("Ivanov");
        p.setOib("77995289480");
        p.setEmail("ivanov@gmail.com");
        p.setIban("HR5523600003222222223");
        ObradaProdavac op = new ObradaProdavac(p);
        try {
            op.create();
            } catch(AutosalonException ex){ 
                 System.out.println("Spremanje nije prošlo. Razlog:");
                 System.out.println(ex.getPoruka());
                 
                 
       
        
                 
                 
            }
                
                
                
        }*/
                
    }
    
    public static void main(String[] args) {
        new Start();
    }
}

        
