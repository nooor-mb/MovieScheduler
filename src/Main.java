import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Screening {
    String title, date, time, cinema;

    Screening(String title, String date, String time, String cinema) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.cinema = cinema;
    }

    public String toString() {
        return title + ", " + date + " " + time + ", " + cinema;
    }

    public String toCSV() {
        return title + "," + date + "," + time + "," + cinema;
    }
}

public class Main {
    static List<Screening> screenings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMovie Screening Schedule Manager");
            System.out.println("1. Add Screening");
            System.out.println("2. View Screenings");
            System.out.println("3. Update Screening");
            System.out.println("4. Delete Screening");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Import from CSV");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) break;
            else if (choice == 1) addScreening();
            else if (choice == 2) viewScreenings();
            else if (choice == 3) updateScreening();
            else if (choice == 4) deleteScreening();
            else if (choice == 5) saveToFile("screenings.txt");
            else if (choice == 6) loadFromFile("screenings.txt");
            else if (choice == 7) {
                System.out.print("Enter CSV filename: ");
                String file = scanner.nextLine();
                importFromCSV(file);
            }
        }
    }

    static void addScreening() {
        String title, date, time, cinema;

        while (true) {
            System.out.print("Movie title: ");
            title = scanner.nextLine();
            if (isEmpty(title)) System.out.println("Title cannot be empty.");
            else break;
        }

        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            date = scanner.nextLine();
            if (!isValidDate(date)) {
                System.out.println("Invalid date format.");
                continue;
            }
            try {
                String[] parts = date.split("-");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);
                if (month < 1 || month > 12 || day < 1 || day > 31) throw new Exception();
                if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) throw new Exception();
                if (month == 2) {
                    boolean leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                    if (day > (leap ? 29 : 28)) throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid date values.");
            }
        }

        while (true) {
            System.out.print("Time (HH:MM): ");
            time = scanner.nextLine();
            if (!isValidTime(time)) {
                System.out.println("Invalid time format.");
                continue;
            }
            try {
                String[] t = time.split(":");
                int hour = Integer.parseInt(t[0]);
                int minute = Integer.parseInt(t[1]);
                if (hour < 0 || hour > 23 || minute < 0 || minute > 59) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Invalid time values.");
            }
        }

        while (true) {
            System.out.print("Cinema: ");
            cinema = scanner.nextLine();
            if (isEmpty(cinema)) System.out.println("Cinema cannot be empty.");
            else break;
        }

        screenings.add(new Screening(title, date, time, cinema));
        System.out.println("Screening added.");
    }

    static void viewScreenings() {
        for (int i = 0; i < screenings.size(); i++) {
            System.out.println((i + 1) + ". " + screenings.get(i));
        }
    }

    static void updateScreening() {
        viewScreenings();
        System.out.print("Choose number to update: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < screenings.size()) {
            addScreening();
            screenings.remove(index);
        }
    }

    static void deleteScreening() {
        viewScreenings();
        System.out.print("Choose number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < screenings.size()) {
            screenings.remove(index);
            System.out.println("Screening deleted.");
        }
    }

    static void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Screening s : screenings) writer.println(s.toCSV());
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void loadFromFile(String filename) {
        screenings.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    screenings.add(new Screening(parts[0], parts[1], parts[2], parts[3]));
                }
            }
            System.out.println("Data loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void importFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    screenings.add(new Screening(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
            System.out.println("Data imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    static boolean isValidTime(String time) {
        return time.matches("\\d{2}:\\d{2}");
    }
}
