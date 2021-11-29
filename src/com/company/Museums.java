package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Museums {
    private ArrayList<Museum> museums = new ArrayList<>();

    public ArrayList<Museum> getMuseums() {
        return museums;
    }

    // combineMuseumLists combines lists and clears the list that we added
    public void combineMuseumLists(Museums list) {
        museums.addAll(list.getMuseums());
    }

    // this method lets us add museums to Museums list
    public void addMuseum(Museum museum) {
        museums.add(museum);
    }

    // this method lets us find
    public void printerOfMuseum(int index) {
        System.out.println(museums.get(index));
    }

    // printing all the museums in list
    public void printerOfMuseums() {
        int i = 0;
        for (Museum museum : museums) {
            System.out.println("Index: " + i + " - " + museum.toString());
            i++;
        }
    }

    // delete a museum from a list
    public void removeMuseum(int index) {
        museums.remove(index);
    }

    // for sorting by purpose
    public void sortByPurpose() {
        Comparator<Museum> museumComparator = new Comparator<Museum>() {
            @Override
            public int compare(Museum o1, Museum o2) {
                if (o1.getPurpose().equals(o2.getPurpose())) {
                    if (o1.getName().equals(o2.getName())) {
                        return 0;
                    } else if (o1.getName().compareTo(o2.getName()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (o1.getPurpose().compareTo(o2.getPurpose()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(museums, museumComparator);
        //for (Museum m:museums) {System.out.println(m.toString());}
    }

    @Override
    public String toString() {
        return "Museums{" + "\n" +
                "museums=" + museums +
                '}' + "\n";
    }
}
