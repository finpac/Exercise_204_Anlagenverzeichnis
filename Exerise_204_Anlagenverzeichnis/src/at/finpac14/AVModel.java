package at.finpac14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        liste.clear();
        liste = (ArrayList<Anlagenverzeichnis>) ois.readObject();
    }


}
