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

import hr.autosalon.autosalon.util.Pomocno;
import hr.autosalon.autosalon.view.SplashScreen;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author TRTANJ
 */
public class Start {

    public Start() {
        
        
        //HibernateUtil.getSessionFactory().openSession();
        
        //Pomocno.pocetniInsert();
        
        new SplashScreen().setVisible(true);
        
        
    }

    public static void main(String[] args) {
        new Start();
    }
}
