/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package edu.ufp.cm.examplejtable;

/*
 * TableDemo.java requires no other files.
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * TableDemo is just like SimpleTableDemo, except that it uses a custom
 * TableModel.
 */
public class TableDemo extends JPanel {

    public TableDemo(String[] columnNames, Object[][] cellsMatrixData) {
        super(new GridLayout(1, 0));

        JTable table = new JTable(new TableModel(columnNames, cellsMatrixData));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI(String[] columnNames, Object[][] cellsMatrixData) {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TableDemo newContentPane = new TableDemo(columnNames, cellsMatrixData);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /*
         * String[] columnNames = {"Timestamp"}; Object[][] data = { {new
         * Date(System.currentTimeMillis()).toString()}, {new
         * Date(System.currentTimeMillis()).toString()}, {new
         * Date(System.currentTimeMillis()).toString()}, {new
         * Date(System.currentTimeMillis()).toString()} };
         */
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {
                        String[] columnNames = {"Name", "Timestamp"};
                        String[] peopleNames = {"Andre", "Maria", "Lucas", "Antonio"};
                        Object[][] data;
                        
                        Random r = new Random(System.currentTimeMillis());
                        
                        /* Simular que se executou uma query com n resultados TimeTable */
                        int n = r.nextInt(10)+1;
                        ArrayList<TimeTable> timetable = new ArrayList<TimeTable>();
                        String name = peopleNames[r.nextInt(peopleNames.length)];
                        for (int i = 0; i < n; i++) {
                            timetable.add(new TimeTable(name, new Date(System.currentTimeMillis() + r.nextInt())));
                        }
                        /* Criar e preencher matriz data com os resultados da query armazenados em timetable */
                        data = new Object[n][columnNames.length];
                        for (int i = 0; i < n; i++) {
                            data[i][0] = timetable.get(i).getName();
                            data[i][1] = timetable.get(i).getTimestamp().toString();
                        }
                        /* Criar e mostrar JTable com os resultados da query armazenados em data */
                        createAndShowGUI(columnNames, data);
                    }
                });
    }
}
