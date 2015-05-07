/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zakaria
 */
public class Modele extends AbstractTableModel
{
    private int Nblignes=0;
    private int Nbcolonnes;
    private String[] Titres;
    private ArrayList<Vector<String>> MesLignes=new ArrayList<Vector<String>>();
    public Modele(ResultSet rs)
    {
        try
        {
            ResultSetMetaData rsmd=rs.getMetaData();
            Nbcolonnes=rsmd.getColumnCount();
            Titres=new String[Nbcolonnes];
            for (int i = 0; i < Nbcolonnes; i++) 
            {
                Titres[i]=rsmd.getColumnLabel(i+1);
            }
            Vector<String> Ligne;
            while(rs.next())
            {
                Ligne=new Vector<>();
                for (int i = 0; i < Nbcolonnes; i++) 
                {
                    Ligne.add(rs.getObject(i+1).toString());
                }
                MesLignes.add(Ligne);
                Nblignes++;
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String getColumnName(int column) {
        return Titres[column];
    }

    @Override
    public int getRowCount() {
       return Nblignes;
    }

    @Override
    public int getColumnCount() {
        return Nbcolonnes;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return MesLignes.get(rowIndex).get(columnIndex);
    }
}
