/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zakaria
 */
public class Impots {

    private Connection cnx = null;

    public Impots() {
        this.cnx = new DAO().getCnx();
    }

    public List<double[]> GetDBImpots() {
        String sql;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<double[]> list = new ArrayList<>();
        try {
            //champ1,champ2,champ3
            sql = "select * from impot ";
            st = this.cnx.prepareStatement(sql);
            //st.setQueryTimeout(1);
            rs = st.executeQuery();
            while (rs.next()) {
                double[] temp = {rs.getDouble(1), rs.getDouble(2), rs.getDouble(3)};
                list.add(temp);
            }
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return list;
    }

    public double CalculeNBPARTS(String statut, int nbEnfant) {
        double NBPARTS = 0;
        if (nbEnfant < 3) {
            if (statut.equalsIgnoreCase("Marie")) {
                NBPARTS += ((nbEnfant / 2) + 2);
            } else {
                NBPARTS += ((nbEnfant / 2) + 1);
            }
        } else {
            if (statut.equalsIgnoreCase("Marie")) {
                NBPARTS += ((nbEnfant / 2) + 2);
            } else {
                NBPARTS += ((nbEnfant / 2) + 1);
            }
            NBPARTS += NBPARTS / 2;
        }
        return NBPARTS;
    }

    public double CalculeQF(double nbParts, double S) {
        //JOptionPane.showMessageDialog(null, (S * 0.72) / nbParts);
        return (S * 0.72) / nbParts;
    }

    public int getNumberRows(String sql) 
    {
        PreparedStatement st = null;
        ResultSet rs = null;
        try 
        {
            st = this.cnx.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.last()) {
                return rs.getRow();
            } else {
                return 0; //just cus I like to always do some kinda else statement.
            }
        } catch (Exception e) {
            System.out.println("Error getting row count");
            e.printStackTrace();
        }
        return 0;
    }

    public double[] GetChamps(double QF) {
        double[] tab = new double[2];
        String sql;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //champ1,champ2,champ3
            sql = "select champ2,champ3 from impot where champ1>="+QF+" limit 1";
            int nbrows=getNumberRows(sql);
            //JOptionPane.showMessageDialog(null, rs.next());
            //System.out.println(rs.next());
            if (nbrows!=0) 
            {
                
                st = this.cnx.prepareStatement(sql);
                //st.setDouble(1, QF);
                st.setQueryTimeout(1);
                rs = st.executeQuery();
                while (rs.next()) {
                    tab[0] = rs.getDouble(1);
                    tab[1] = rs.getDouble(2);
                    //JOptionPane.showMessageDialog(null, Arrays.toString(tab));
                }
            } 
            else
            {
                sql = "select champ2,champ3 from impot where champ1=0";
                st = this.cnx.prepareStatement(sql);
                rs = st.executeQuery();
                while (rs.next()) {
                    tab[0] = rs.getDouble(1);
                    tab[1] = rs.getDouble(2);
                }
            }
            //JOptionPane.showMessageDialog(null, Arrays.toString(tab));
            st.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return tab;
    }

    public double CalculeImpot(double[] tab, double nbParts, double S) {
        return (tab[0] * (S * 0.72)) - (tab[1] * nbParts);
    }
}
