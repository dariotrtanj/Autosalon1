/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.util;

import hr.autosalon.autosalon.Start;
import hr.autosalon.autosalon.controller.ObradaKupac;
import hr.autosalon.autosalon.controller.ObradaProdaja;
import hr.autosalon.autosalon.controller.ObradaProdavac;
import hr.autosalon.autosalon.controller.ObradaVozilo;
import hr.autosalon.autosalon.model.Kupac;
import hr.autosalon.autosalon.model.Prodaja;
import hr.autosalon.autosalon.model.Prodavac;
import hr.autosalon.autosalon.model.Vozilo;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author TRTANJ
 */
public class Pomocno {
    
    public static Prodavac LOGIRAN;
    
    private final static DecimalFormat df = df();
    
    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
          .atZone(ZoneId.systemDefault())
            .toInstant());
    }
    
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
    
    
    public static String getNazivAplikacije(){
        return "Autosalon";
    }
    
    public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
    public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df.format(b);
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
           
    }


    
    public static void pocetniInsert(){
        
        
        Prodavac prodavac = new Prodavac();
        prodavac.setIme("Dario");
        prodavac.setPrezime("Trtanj");
        prodavac.setOib("63612978880");
        prodavac.setEmail("trtanjd@gmail.com");
        prodavac.setIban("HR5523600003222222223");
        prodavac.setLozinka(BCrypt.hashpw("t", BCrypt.gensalt()));
        
        ObradaProdavac obradaProdavac = new ObradaProdavac(prodavac);
        try {
            obradaProdavac.create();
            } catch (AutosalonException ex) {
            System.out.println(ex.getPoruka());
        }
        Prodavac p = new Prodavac();
        p.setIme("Borna");
        p.setPrezime("Bornić");
        p.setOib("63612978881");
        p.setEmail("borna@gmail.com");
        p.setIban("HR5523600003222222221");
        p.setLozinka(BCrypt.hashpw("t", BCrypt.gensalt()));
        
        obradaProdavac = new ObradaProdavac(p);
        try {
            obradaProdavac.create();
            } catch (AutosalonException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        
        Kupac kupac = new Kupac();
        kupac.setIme("Ivan");
        kupac.setPrezime("Ivanov");
        kupac.setOib("77995289480");
        kupac.setEmail("ivanov@gmail.com");
        kupac.setBrojTelefona("098683862");
        kupac.setBrojUgovora("369");
        
        ObradaKupac obradaKupac = new ObradaKupac(kupac);
        try {
            obradaKupac.create();
            } catch (AutosalonException ex) {
                System.out.println(ex.getPoruka());
        }
        
        Kupac k = new Kupac();
        k.setIme("Pero");
        k.setPrezime("Perić");
        k.setOib("12345678901");
        k.setEmail("pperic@gmail.com");
        k.setBrojTelefona("098111222");
        k.setBrojUgovora("370");
        
        obradaKupac = new ObradaKupac(k);
        try {
            obradaKupac.create();
            } catch (AutosalonException ex) {
                System.out.println(ex.getPoruka());
        }
        
            
            
        Vozilo vozilo = new Vozilo();
        vozilo.setMarka("Volkswagen");
        vozilo.setModel("Golf");
        vozilo.setGodiste(2011);
        vozilo.setKilometraza(155000);
        vozilo.setCijena(new BigDecimal(10000));
        vozilo.setUvoz(true);
        
        ObradaVozilo obradaVozilo = new ObradaVozilo(vozilo);
        try {
            obradaVozilo.create();
            } catch (AutosalonException ex) {
        }
        
       /* List<Vozilo> lista = new ArrayList<>();
        Vozilo v1;
        for (int i = 0; i < 1000; i++) {
            v1 = new Vozilo();
            v1.setMarka("generirano" + i);
            lista.add(v1);*/
            
            
        Vozilo v = new Vozilo();
        v.setMarka("Volkswagen");
        v.setModel("Touareg");
        v.setGodiste(2018);
        v.setKilometraza(15000);
        v.setCijena(new BigDecimal(20000));
        v.setUvoz(true);
        
        obradaVozilo = new ObradaVozilo(v);
        try {
            obradaVozilo.create();
            } catch (AutosalonException ex) {
                System.out.println(ex.getPoruka());
        }
        
        
        
        
        Prodaja prodaja = new Prodaja();
        prodaja.setDatumProdaje(new Date());
        prodaja.setKupac(kupac);
        prodaja.setProdavac(prodavac);
        prodaja.setVozilo(vozilo);
        
        
        ObradaProdaja obradaProdaja=new ObradaProdaja(prodaja);
        try {
            obradaProdaja.create();
            } catch (AutosalonException ex) {
        }
        
        Prodaja s = new Prodaja();
        s.setDatumProdaje(new Date());
        s.setKupac(k);
        s.setProdavac(prodavac);
        s.setVozilo(v);
        
        
        obradaProdaja=new ObradaProdaja(s);
        try {
            obradaProdaja.create();
            } catch (AutosalonException ex) {
        }
        
        

        //vozilo.getProdaje().add(prodaja);
        
        
    }
        
        
        public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }

    private static DecimalFormat df() {
       NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    
    }
    
}


    

         
        
    
        
   

    

