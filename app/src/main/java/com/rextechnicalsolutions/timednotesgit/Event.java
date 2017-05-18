package com.rextechnicalsolutions.timednotesgit;

import android.util.Log;

import java.util.Calendar;

/**
 * This class is used to define a event
 *
 * Created by Rex on 2/13/17.
 */

public class Event {

    /** This field defines a unique event id number */
    private int eventId;

    /** This field defines what type of activity the event is */
    private String eventName;

    /** This field defines the starting date and time */
    private Calendar startDateTime;

    /** This file defines the ending date and time */
    private Calendar endDateTime;

    /**
     * Constructor with only start time/no end time
     * @param name
     * @param startDateTime
     */
    public Event(int idNum, String name, Calendar startDateTime) {
        this(idNum, name, startDateTime, null);
    }

    /**
     * constructor with start and end time
     * @param name
     * @param startDateTime
     * @param endDateTime
     */
    public Event(int idNum, String name, Calendar startDateTime, Calendar endDateTime) {
        if (name == null || name.isEmpty()) {
            Log.d("DEBUG", "Invalid name");
            throw new IllegalArgumentException("Invalid event name");
        }
        this.eventId = idNum;
        this.eventName = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    /**
     * mutator for start date
     * @param newStart
     */
    public void setStartDate(Calendar newStart) {
        this.startDateTime = newStart;
    }

    /**
     * mutator for end date
     * @param newEnd
     */
    public void setEndDate(Calendar newEnd) {
        this.endDateTime = newEnd;
    }

    /**
     * mutator for event name
     * @param newName
     */
    public void setEventName(String newName) {
        this.eventName = newName;
    }

    /**
     * getter for start date
     * @return the start date
     */
    public Calendar getStartDateTime() {
        return this.startDateTime;
    }

    /**
     * getter for end date
     * @return the end date
     */
    public Calendar getEndDateTime() {
        return this.endDateTime;
    }

    /**
     * getter for event name
     * @return the event name
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * overriding the equals method
     * @param o object to compare to
     * @return boolean return of whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event compareTo = (Event) o;
        if (this.eventId != compareTo.eventId) {
            return false;
        }
        if (!this.eventName.equals(compareTo.getEventName())) {
            return false;
        }
        if (!this.startDateTime.equals(compareTo.getStartDateTime())) {
            return false;
        }
        return this.endDateTime.equals(compareTo.getEndDateTime());
    }

    //TODO add toString method for my formatting
}