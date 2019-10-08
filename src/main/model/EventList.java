package model;

import java.io.*;
import java.util.*;


public class EventList extends ItemList {

    public EventList() {
        super();
    }

    //EFFECTS: Prints all events in this EventList
    @Override
    public void print() {
        ArrayList<Item> itemlist;
        Item item;
        int i = 0;
        int z = 1;

        itemlist = this.itemArrayList;

        System.out.println();
        if (itemlist.size() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING SCHEDULED EVENTS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY SCHEDULED EVENTS");
        }

        while (i < itemlist.size()) {
            item = itemlist.get(i);
            System.out.println("[" + z + "]" + item.returnItemDetails());
            i++;
            z++;
        }
    }

    @Override
    public void save() throws IOException {
        ArrayList<Item> itemlist;
        itemlist = this.itemArrayList;
        int i = 0;

        File file = new File("./data/saveEvents.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        while (i < itemlist.size()) {
            pw.println(itemlist.get(i).getDate());
            pw.println(itemlist.get(i).getIsEvent());
            pw.println(itemlist.get(i).getActivity());
            pw.println(itemlist.get(i).getTime());
            pw.println(itemlist.get(i).getDuration());
            pw.println(itemlist.get(i).getEnd());
            pw.println(itemlist.get(i).getWeatherSensitive());
            i++;
        }
        pw.println("007");
        pw.close();
    }

    @Override
    public void load() throws FileNotFoundException {
        File file = new File("./data/saveEvents.txt");
        Scanner scan = new Scanner(file);

        while (true) {
            Event event = new Event();

            String s = scan.next();
            if (s.equals("007")) {
                break;
            }

            event.setDate(s);
            event.setIsEvent(scan.nextBoolean());
            scan.nextLine();
            event.setActivity(scan.nextLine());
            event.setTime(scan.nextInt());
            event.setDuration(scan.nextInt());
            event.setEnd(scan.nextInt());
            event.setWeatherSensitive(scan.nextBoolean());
            this.addItem(event);
        }
    }
}
