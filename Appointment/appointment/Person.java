package appointment;

import java.util.ArrayList;

public class Person {

    private String name;
    private int id;
    private ArrayList<Meeting> myMeetings;
    private ArrayList<Meeting> iOrganize;
    private static int count = 0;

    public Person() {

    }

    public Person(String name) {

        this.name = name;
        this.id = count;
        Person.count++;
        this.myMeetings = new ArrayList<>();
        this.iOrganize = new ArrayList<>();
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public ArrayList<Meeting> getMyMeetings() {
        return myMeetings;
    }

    public ArrayList<Meeting> getiOrganize() {
        return iOrganize;
    }

    public String equals(Person isSame) {
        if (this.name == isSame.name && this.id == isSame.id) {
            return "They are same person";
        }
        return "They are not same person";
    }

    public boolean addMeeting(Meeting met, MDate date) {
        if (met.getDate() == date) {
            return false;
        }
        myMeetings.add(met);
        return true;

    }

    public void removeMeeting(Meeting met) {
        myMeetings.remove(met);
    }

    public void organizeMeeting(Meeting organize) {
        iOrganize.add(organize);

    }

    public void cancelMeeting(Meeting organize) {
        iOrganize.remove(organize);
    }

    public void displayMyMeetings() {
        for (int i = 0; i < myMeetings.size(); i++) {
            System.out.println("Meeting's date is " + myMeetings.get(i).getDate() + " Host of the meeting is: " + myMeetings.get(i).getHost());
        }

    }

    public void displayMyOrganizations() {
        for (int i = 0; i < iOrganize.size(); i++) {
            System.out.println(iOrganize.get(i));
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", myMeetings=" + myMeetings.size() + ", iOrganize=" + iOrganize.size() + '}';
    }

}
