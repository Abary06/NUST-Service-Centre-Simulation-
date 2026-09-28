package linkedlist;

import model.Student;

public class StudentLinkedList {
    private StudentNode head;
    private int size;

    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtBeginning(Student student) {
        StudentNode newNode = new StudentNode(student);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void insertAtEnd(Student student) {
        StudentNode newNode = new StudentNode(student);
        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        StudentNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;
    }

    public void insertAtPosition(int position, Student student) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position.");
        }

        if (position == 0) {
            insertAtBeginning(student);
            return;
        }

        StudentNode newNode = new StudentNode(student);
        StudentNode current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public Student searchStudent(String studentNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.getStudent().getStudentNumber().equals(studentNumber)) {
                return current.getStudent();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean deleteStudent(String studentNumber) {
        if (isEmpty()) {
            return false;
        }

        if (head.getStudent().getStudentNumber().equals(studentNumber)) {
            head = head.getNext();
            size--;
            return true;
        }

        StudentNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getStudent().getStudentNumber().equals(studentNumber)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("Student service records are empty.");
            return;
        }

        System.out.println("Student service records:");
        StudentNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.getStudent());
            current = current.getNext();
            index++;
        }
    }
}
