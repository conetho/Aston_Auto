package lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phone) {
        book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public List<String> get(String surname) {
        return book.getOrDefault(surname, new ArrayList<>());
    }

    public void printPhoneBook() {
        for (String key : book.keySet()) {
            System.out.println(key + book.get(key));
        }
    }
}
