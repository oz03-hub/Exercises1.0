import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class BirthdayPortal {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<BirthdayObject> bdList = new ArrayList<>();
        HashMap<String, BirthdayObject> bdHash = new HashMap<>();
        extracted(bdList, bdHash);

        System.out.println();
        System.out.println("Commands:");
        System.out.println("l, to list");
        System.out.println("g, to get desired birthday");
        System.out.println("n, nearest birthday to current date");
        System.out.println("q, to quit");
        System.out.println("I want to: ");
        Scanner scanner = new Scanner(System.in);
        String userIn = scanner.nextLine();

        while (!userIn.equals("q")) {
            switch (userIn) {
                case "l":
                    list(bdList);
                    break;
                case "g":
                    //Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Fullname: ");
                    String fullName = scanner.nextLine();
                    getDesired(bdHash, fullName);
                    break;
                case "n":
                    LocalDate date = LocalDate.now();
                    String currentDate = date.toString().substring(5, 10);
                    findNearestBirthday(currentDate, bdList);
                    break;
            }
            System.out.println("I want to: ");
            userIn = scanner.nextLine();
        }

        System.exit(0);
    }

    private static void findNearestBirthday(String currentDate, ArrayList<BirthdayObject> bdList) {
        sortArray(bdList);

        for (int i = 0; i < bdList.size(); i++) {
            if (currentDate.compareTo(bdList.get(i).getBirthday()) <= 0) {
                System.out.println("Nearest birthday: " + bdList.get(i));
                break;
            }
        }
    }

    private static void sortArray(ArrayList<BirthdayObject> bdList) {
        Collections.sort(bdList);
    }

    private static void getDesired(HashMap<String, BirthdayObject> bdHash, String fullName) {
        System.out.println("========");
        System.out.println(bdHash.get(fullName));
        System.out.println("========");
    }

    private static void list(ArrayList<BirthdayObject> bdList) {
        System.out.println("========");
        for (int i = 0; i < bdList.size(); i++) {
            System.out.println(bdList.get(i));
        }
        System.out.println("========");
    }


    private static void extracted(ArrayList<BirthdayObject> bdList, HashMap<String, BirthdayObject> bdHash) throws FileNotFoundException {
        File file = new File("birthdays.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            BirthdayObject object = BirthdayObject.createFromString(line);
            bdList.add(object);
            bdHash.put(object.getFullName(), object);
        }
        scanner.close();
    }
}


