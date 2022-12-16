package StudentRecord;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentRecordList {
    public static void main(String[] args)
    {

        StudentRecordManagement rm = new StudentRecordManagement();

        Record record = new Record();

        record.setIdNumber(4546);
        record.setContactNumber(017);
        record.setName("Shanzida");

        rm.add(record);

        Scanner input = new Scanner(System.in);

        int option = 0;

        do {
            menu();
            option = input.nextInt();

            switch (option) {

                case 1:

                    System.out.print(
                            "What is the Student id Number ? ");

                    int idNumber = input.nextInt();

                    System.out.print(
                            "What is the Student contact Number ? ");

                    int contactNumber = input.nextInt();
                    input.nextLine();

                    System.out.print(
                            "What is the Student Name ? ");

                    String name = input.nextLine();

                    record = new Record(name, idNumber,contactNumber);

                    rm.add(record);

                    System.out.println(record.toString());

                    break;

                case 2:

                    System.out.print(
                            "What is the Student id number ? ");
                    int rId = input.nextInt();

                    rm.delete(rId);

                    break;

                case 3:

                    System.out.print(
                            "What is the Student id number? ");

                    int rIdNo = input.nextInt();
                    rm.update(rIdNo, input);

                    break;

                case 4:

                    System.out.print(
                            "What is the Student id ? ");
                    int bookId = input.nextInt();

                    if (!rm.find(bookId)) {
                        System.out.println(
                                "Student id does not exist\n");
                    }

                    break;

                case 5:
                    rm.display();
                    break;

                case 6:
                    System.exit(0);

                    break;

                default:

                    System.out.println("\nInvalid input\n");
                    break;
            }
        }

        while (option != 6);
    }

    public static void menu()
    {

        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Delete Student");
        System.out.println("3: Update Student");
        System.out.println("4: Search Student");
        System.out.println("5: Display Students");
        System.out.println("6: Exit program");
        System.out.print("Enter your selection : ");
    }
}

class StudentRecordManagement {

    LinkedList<Record> list;

    public StudentRecordManagement()
    {
        list = new LinkedList<>();
    }

    public void add(Record record)
    {

        if (!find(record.getIdNumber())) {
            list.add(record);
        }
        else {
            System.out.println("Record already exists in the Record list");
        }
    }

    public boolean find(int idNimber)
    {

        for (Record l : list) {

            if (l.getIdNumber() == idNimber) {

                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    public void delete(int recIdNumber)
    {
        Record recordDel = null;

        for (Record ll : list) {

            if (ll.getIdNumber() == recIdNumber) {
                recordDel = ll;
            }
        }

        if (recordDel == null) {

            System.out.println("Invalid record Id");
        }
        else {

            list.remove(recordDel);
            System.out.println("Successfully removed record from the list");
        }
    }

    public Record findRecord(int idNumber)
    {

        for (Record l : list) {

            if (l.getIdNumber() == idNumber) {
                return l;
            }
        }

        return null;
    }

    public void update(int id, Scanner input)
    {

        if (find(id)) {
            Record rec = findRecord(id);

            System.out.print(
                    "What is the new Student id Number ? ");
            int idNumber = input.nextInt();

            System.out.print(
                    "What is the new Student contact Number ");
            int contactNumber = input.nextInt();
            input.nextLine();

            System.out.print(
                    "What is the new Student Name ? ");
            String name = input.nextLine();

            rec.setIdNumber(idNumber);
            rec.setName(name);
            rec.setContactNumber(contactNumber);
            System.out.println(
                    "Record Updated Successfully");
        }
        else {

            System.out.println(
                    "Record Not Found in the Student list");
        }
    }

    public void display()
    {

        if (list.isEmpty()) {

            System.out.println("The list has no records\n");
        }

        for (Record record : list) {

            System.out.println(record.toString());
        }
    }
}

class Record {

    private String name;
    private int idNumber;
    private int contactNumber;

    public Record() {}

    public Record(String name, int idNumber,int contactNumber)
    {

        this.name = name;
        this.idNumber = idNumber;
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() { return contactNumber; }

    public void setContactNumber(int contactNumber)
    {

        this.contactNumber = contactNumber;
    }

    public int getIdNumber() { return idNumber; }

    public void setIdNumber(int idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override public String toString()
    {

        return "Records --> Name = " + name + ", ID Number = " + idNumber+ ", Contact Number = " + contactNumber;
    }
}
