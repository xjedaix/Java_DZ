// Разработать программу, имитирующую поведение коллекции HashSet. В программе содать метод add добавляющий элемент, 
// метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
// *Реализовать все методы из семинара.
// Формат данных Integer.



import java.util.ArrayList;

public class CustomHashSet {
    private ArrayList<Integer> elements;

    public CustomHashSet() {
        elements = new ArrayList<>();
    }

    public void add(int element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public String toString() {
        return elements.toString();
    }

    public Integer getElementByIndex(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashSet set = new CustomHashSet();

        set.add(10);
        set.add(5);
        set.add(3);
        set.add(7);
        set.add(10); // Дублирующийся элемент, не будет добавлен

        System.out.println("Set: " + set.toString());

        Integer element = set.getElementByIndex(2);
        if (element != null) {
            System.out.println("Element at index 2: " + element);
        } else {
            System.out.println("Invalid index");
        }
    }
}
