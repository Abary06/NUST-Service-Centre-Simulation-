package model;

public class Student {
    private String studentNumber;
    private String studentName;
    private String serviceType;
    private int estimatedServiceTime;

    public Student(String studentNumber, String studentName, String serviceType, int estimatedServiceTime) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.serviceType = serviceType;
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(int estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    @Override
    public String toString() {
        return studentNumber + " — " + studentName + " — " + serviceType + " — " + estimatedServiceTime + " minutes";
    }
}
