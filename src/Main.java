import experiment.SortingExperiment;
import linkedlist.StudentLinkedList;
import model.Student;
import queue.StudentQueue;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import stack.CustomStack;
import statistics.ServiceStatistics;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentQueue waitingQueue = new StudentQueue(10);
        StudentLinkedList serviceRecords = new StudentLinkedList();
        int[] dailyServiceTimes = new int[0];

        while (scanner.hasNextLine()) {
            System.out.println("\n========================================");
            System.out.println("CAMPUS SERVICE CENTRE");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Student Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Service Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Estimated Service Time: ");
                    int time = Integer.parseInt(scanner.nextLine());
                    waitingQueue.enqueue(new Student(number, name, type, time));
                    break;
                case 2:
                    Student served = waitingQueue.dequeue();
                    if (served == null) {
                        System.out.println("No waiting students.");
                    } else {
                        System.out.println("Served: " + served);
                    }
                    break;
                case 3:
                    waitingQueue.displayQueue();
                    break;
                case 4:
                    System.out.print("Student Number: ");
                    String recordNumber = scanner.nextLine();
                    System.out.print("Student Name: ");
                    String recordName = scanner.nextLine();
                    System.out.print("Service Type: ");
                    String recordType = scanner.nextLine();
                    System.out.print("Estimated Service Time: ");
                    int recordTime = Integer.parseInt(scanner.nextLine());
                    serviceRecords.insertAtEnd(new Student(recordNumber, recordName, recordType, recordTime));
                    dailyServiceTimes = appendTime(dailyServiceTimes, recordTime);
                    break;
                case 5:
                    serviceRecords.displayStudents();
                    break;
                case 6:
                    System.out.print("Student Number to search: ");
                    String searchNumber = scanner.nextLine();
                    Student found = serviceRecords.searchStudent(searchNumber);
                    if (found == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println("Found: " + found);
                    }
                    break;
                case 7:
                    System.out.print("Student Number to remove: ");
                    String deleteNumber = scanner.nextLine();
                    boolean removed = serviceRecords.deleteStudent(deleteNumber);
                    System.out.println(removed ? "Student removed." : "Student not found.");
                    break;
                case 8:
                    if (dailyServiceTimes.length == 0) {
                        System.out.println("No service time records yet.");
                    } else {
                        ServiceStatistics stats = new ServiceStatistics(dailyServiceTimes);
                        stats.displayStatistics();
                    }
                    break;
                case 9:
                    if (dailyServiceTimes.length == 0) {
                        System.out.println("No service time records yet.");
                    } else {
                        System.out.println("Original service times: " + Arrays.toString(dailyServiceTimes));
                        int[] copy = copyArray(dailyServiceTimes);
                        SelectionSort.selectionSort(copy);
                        System.out.println("Sorted service times: " + Arrays.toString(copy));
                    }
                    break;
                case 10:
                    SortingExperiment.runExperiment();
                    break;
                case 11:
                    System.out.println("Exiting Campus Service Centre.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid menu item.");
            }
        }
    }

    private static int[] appendTime(int[] arr, int value) {
        int[] updated = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            updated[i] = arr[i];
        }
        updated[arr.length] = value;
        return updated;
    }

    private static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
