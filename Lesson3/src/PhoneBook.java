import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String fio, String phone) {

        ArrayList<String> phoneList = phoneBook.get(fio);
        if (phoneList == null) phoneList = new ArrayList<>();
        phoneList.add(phone);
        phoneBook.put(fio, phoneList);
    }

    public ArrayList<String> get(String fio) {
        return  phoneBook.get(fio);

    }

    public void info() {
        System.out.println(phoneBook);
    }
}
