package bg.tu_varna.sit;
import java.util.*;

class PersonalCalendar {
    private Map<Date, String> events;

    public PersonalCalendar() {
        events = new HashMap<>();
    }

    public void book(Date date, String event) {
        events.put(date, event);
    }

    public void unbook(Date date) {
        events.remove(date);
    }

    public void changeDate(Date oldDate, Date newDate) {
        String event = events.get(oldDate);
        events.remove(oldDate);
        events.put(newDate, event);
    }

    public void displayCalendar() {
        for (Map.Entry<Date, String> entry : events.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PersonalCalendar calendar = new PersonalCalendar();

        Date date1 = new Date(2023, 3, 20); // Year, Month (Jan=0, Feb=1, Mar=2, etc.), Day
        String event1 = "Среща с приятел";
        calendar.book(date1, event1);

        Date date2 = new Date(2023, 3, 21);
        calendar.book(date2, "Кино");
        calendar.unbook(date2);

        Date oldDate = new Date(2023, 3, 22);
        Date newDate = new Date(2023, 3, 23);
        String event2 = "Зъболекар";
        calendar.book(oldDate, event2);
        calendar.changeDate(oldDate, newDate);

        System.out.println("Моят личен календар:");
        System.out.println("---------------------");
        calendar.displayCalendar();
    }
}

