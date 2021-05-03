import java.util.ArrayList;
import java.util.List;

public class Queue {

    public List<Integer> elements = new ArrayList<Integer>();

    //fügt ein neues Element hinten in die Schlange ein
    public void enqueue(int newElement) {
        elements.add(newElement);
    }

    //gibt die Anzahl der Elemente in der Queue zurück
    public int size() {
        return elements.size();
    }

    //gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
    public int dequeue() {
        if (elements.size() <= 0) {
            throw new QueueTooSmallException();
        }
        int removedElement = elements.get(0);
        elements.remove(0);
        return removedElement;
    }

    //gibt die ersten n Elemente der Queue zurück und entfernt diese von der Queue
    public int[] dequeue(int n) {

        if (elements.size() <= 0) {
            throw new QueueTooSmallException();
        }
        //Elemente entfernen
        List<Integer> toRemove = new ArrayList<>();
        //Zählt von der Queue von vorne (i = Index) so viele runter, wie ich angebe (n)
        for (int i = 0; i < n; i++  ) {
            toRemove.add(dequeue());
        }

        //Elemente in neues Array speichern
        int[] returnArray = new int[toRemove.size()];
        //Speichert alle runtergezählten Elemente vom Stapel in ein neues Array
        for (int i = 0; i < toRemove.size(); i++) {
            returnArray[i] = toRemove.get(i);
        }
        return returnArray;
    }
}

