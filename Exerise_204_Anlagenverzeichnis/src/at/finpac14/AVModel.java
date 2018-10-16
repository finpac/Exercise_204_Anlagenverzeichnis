package at.finpac14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.table.AbstractTableModel;

public class AVModel extends AbstractTableModel
{
 private static final String filename = System.getProperty("user.dir")
            + File.separator + "CSV-Dateiordner"
            + File.separator + "anlagenverzeichnis.csv";

    private ArrayList<Anlagenverzeichnis> liste = new ArrayList();

    private String[] colNames =
    {
        "Bezeichnung", "AK", "Inbetriebnahme", "ND", "bish. ND", "Afa bisher", "Wert von Afa", "Afa d. J.", "BW 32.12"
    };

    @Override
    public int getRowCount()
    {
        return liste.size();
    }

    @Override
    public int getColumnCount()
    {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Anlagenverzeichnis a = liste.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return a.getBezeichnung();
            case 1:
                return a.getAnschaffungswert();
            case 2:
                return a.getInbetriebnahme();
            case 3:
                return a.getNutzungsdauer();
            case 4:
                return a.getBihNutzungsdauer();
            case 5:
                return a.getAfABisher();
            case 6:
                return a.getWertVorAfA();
            case 7:
                return a.getAfAdJ();
            case 8:
                return a.getBuchwert();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return colNames[column];
    }

    public void load() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String line = " ";
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String wert = "";
        fileReader.readLine();

        while ((line = fileReader.readLine()) != null) {
            String[] tokens = line.split(";");
            
            String bez = tokens[0];
            
            double anlagenwert;
            if(tokens[1].length() > 3)
            {
                wert = tokens[1].replace('.', '_').trim();
                String[] los = wert.split("_");
                anlagenwert = Double.parseDouble(los[0] + "" + los[1]);
            }
            else
            {
                anlagenwert = Double.parseDouble(tokens[1]);
            }
            
            String inbetriebn = tokens[2];
            String nutzungsdau = tokens[3].replace(',', '.');
            double nd = Double.parseDouble(nutzungsdau);
            liste.add(new Anlagenverzeichnis(bez, anlagenwert, inbetriebn, nd));
        }
        fileReader.close();
    }

    public ArrayList<Anlagenverzeichnis> getListe() {
        return liste;
    }
}



