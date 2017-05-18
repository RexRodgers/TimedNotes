package com.rextechnicalsolutions.timednotesgit;

import java.util.LinkedList;
import java.util.Calendar;

/**
 * This class is used to manage a list of related events
 *
 * Created by Rex on 2/13/17.
 */

public class YearEventList {

    /** This field is the description of the list */
    private String listName;

    private MonthList[] monthList;

    private int year;

    /** This field defines the default color of the list events as displayed to the user */
    private String defaultColor; //TODO implement the coloring

    /**
     * null constructor method
     */
    public YearEventList() {
        this("Default", Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * The actual constructor
     * @param name
     * @param listYear
     */
    public YearEventList(String name, int listYear) {
        this.listName = name;
        this.year = listYear;
        this.monthList = new MonthList[13];
        for (int i = 1; i < this.monthList.length; i++)
            this.monthList[i] = new MonthList();
    }

    private class MonthList {

        /** This field is the list of events within one month */
        private LinkedList<Event> dailyEventList; //TODO Im th

        /** This field is used to generate an event id number */
        private int nextEventId;

        /**
         * This is the null constructor
         */
        public MonthList() {
            this.dailyEventList = new LinkedList<Event>();
            this.nextEventId = 0;
        }

        /**
         * This is how events are added to a timeline
         * @param name
         * @param startDateTime
         * @param endDateTime
         */
        public void addEvent(String name, Calendar startDateTime, Calendar endDateTime) {
            Event newEvent = new Event(this.nextEventId++, name, startDateTime, endDateTime);
            int index = 0;
            while (index < this.dailyEventList.size() &&
                    newEvent.getStartDateTime().after(this.dailyEventList.get(index).getStartDateTime())) {
                index++;
            }
            this.dailyEventList.add(index, newEvent);
        }

        /**
         * This is how an event is removed from a timeline
         * @param toRemove
         * @return boolean output of whether event was removed
         */
        public boolean removeEvent(Event toRemove) {
            return this.dailyEventList.remove(toRemove);
        }

    }
}
