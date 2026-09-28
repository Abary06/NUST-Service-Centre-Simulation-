package queue;

import model.Student;

public class StudentQueue {
    private Student[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public StudentQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new Student[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (isFull()) {
            expandQueue();
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = student;
        size++;
    }

    private void expandQueue() {
        Student[] newArray = new Student[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[(front + i) % capacity];
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
        capacity = capacity * 2;
    }

    public Student dequeue() {
        if (isEmpty()) {
            return null;
        }
        Student removed = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    public Student peek() {
        if (isEmpty()) {
            return null;
        }
        return queueArray[front];
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Waiting queue:");
        for (int i = 0; i < size; i++) {
            Student student = queueArray[(front + i) % capacity];
            System.out.println((i + 1) + ". " + student);
        }
    }

    public int getSize() {
        return size;
    }
}
