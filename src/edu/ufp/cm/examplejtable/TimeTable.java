package edu.ufp.cm.examplejtable;

import java.util.Date;

/**
 *
 * @author rmoreira
 */
public class TimeTable {

    private String name;
    private Date timestamp;

    public TimeTable(String name, Date timestamp) {
        this.timestamp = timestamp;
        this.name = name;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
