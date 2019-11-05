package edu.ufp.cm.examplejtable;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rmoreira
 */
public class TableModel extends AbstractTableModel {

    private boolean DEBUG = false;
    
    /*
    private String[] columnNames = {"First Name",
        "Last Name",
        "Sport",
        "# of Years",
        "Vegetarian"};
    
    private Object[][] data = {
        {"Kathy", "Smith",
            "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe",
            "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black",
            "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White",
            "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)}
    };
    */
    private String[] columnNames = null;
    private Object[][] data = null;

    public TableModel(String[] columnNames, Object[][] cellsMatrixData) {
        super();
        this.columnNames = new String[columnNames.length];
        for(int i=0; i<columnNames.length; i++) {
            this.columnNames[i] = columnNames[i];
        }
        this.data = new Object[cellsMatrixData.length][cellsMatrixData[0].length];
        for(int i=0; i<cellsMatrixData.length; i++) {
            for(int j=0; j<cellsMatrixData[i].length; j++) {
            this.data[i][j] = cellsMatrixData[i][j];
            }
        }
    }
    
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/editor for
     * each cell. If we didn't implement this method, then the last column would
     * contain text ("true"/"false"), rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}