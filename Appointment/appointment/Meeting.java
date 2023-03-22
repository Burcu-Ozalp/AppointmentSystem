/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.util.ArrayList;

public class Meeting {

    private MDate date;
    private ArrayList<Person> attendees;
    private Person host;
    private boolean isOnline;
    private String url;
    private String location;
    private boolean cancelledMeeting = false;
    
    
    public Meeting() {
    }

   public Meeting(String name) {
    }

    public Meeting(int day,int month,int year, Person host, boolean isOnline, String url, String location) {
        date = new MDate(day,month,year);
        this.attendees = attendees;
        this.host = host;
        this.isOnline = isOnline;
        if (this.isOnline == true) {
            this.url = url;
        } else {
            this.location = location;
        }
    }

    public Meeting(String name, MDate datee) {
        this.date = datee;
    }
 
    public void setDate(MDate date) {
        this.date = date;
    }

    public void setAttendees(ArrayList<Person> attendees) {
        this.attendees = attendees;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCancelledMeeting(boolean cancelledMeeting) {
        this.cancelledMeeting = cancelledMeeting;
    }

    public boolean isCancelledMeeting() {
        return cancelledMeeting;
    }
    
    public MDate getDate() {
        return date;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }

    public Person getHost() {
        return host;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    public void equals(MDate date, Person host, ArrayList<Person> attendee) {
        if (date.equals(this.date) && host == (this.host) && attendee.equals(this.attendees)) {
            System.out.println("Two meeting is equal.");
        } else {
            System.out.println("Two meeting is not equal.");
        }
    }

    public boolean addAttendee(Person attend) {
        for (int i = 0; i < attendees.size(); i++) {
            if (attend == this.attendees.get(i)) {
                return false;
            } else {
                attendees.add(attend);
                return true;
            }
        }
        if (attendees.add(attend)) {
            return true;
        }
        return false;
    }

    public boolean removeAttendee(Person attend) {
        attendees.remove(attend);
        return true;
    }

    public void removeAllAttendees() {
        if (this.cancelledMeeting == true) {
            attendees.removeAll(attendees);
        } else {
            System.out.println("Meeting is not cancelled.");
        }
    }

    @Override
    public String toString() {
        return "Meeting{" + "date=" + date + ", attendees=" + attendees + ", host=" + host + ", isOnline=" + isOnline + ", url=" + url + ", location=" + location + '}';
    }

}
