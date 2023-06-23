// Задание

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.putIfAbsent(name, new ArrayList<>());
        contacts.get(name).add(phoneNumber);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        Collections.sort(sortedContacts, (a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers.size() + " phone number(s)");
            for (String phoneNumber : phoneNumbers) {
                System.out.println("- " + phoneNumber);
            }
        }
    }
}

public class PhoneBookManagement {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("John Doe", "+123456789");
        phoneBook.addContact("Jane Smith", "+987654321");
        phoneBook.addContact("John Doe", "+111222333");
        phoneBook.addContact("Alice Johnson", "+555555555");

        phoneBook.printPhoneBook();
    }
}
