package statistics;

public class ServiceStatistics {
    private int[] serviceTimes;

    public ServiceStatistics(int[] serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public int getTotalStudentsServed() {
        return serviceTimes.length;
    }

    public int getTotalServiceTime() {
        int total = 0;
        for (int i = 0; i < serviceTimes.length; i++) {
            total += serviceTimes[i];
        }
        return total;
    }

    public double getAverageServiceTime() {
        if (serviceTimes.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int i = 0; i < serviceTimes.length; i++) {
            total += serviceTimes[i];
        }
        return (double) total / serviceTimes.length;
    }

    public int getHighestServiceTime() {
        if (serviceTimes.length == 0) {
            return 0;
        }
        int highest = serviceTimes[0];
        for (int i = 1; i < serviceTimes.length; i++) {
            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }
        }
        return highest;
    }

    public int getLowestServiceTime() {
        if (serviceTimes.length == 0) {
            return 0;
        }
        int lowest = serviceTimes[0];
        for (int i = 1; i < serviceTimes.length; i++) {
            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }
        }
        return lowest;
    }

    public int getLongerThanTenMinutesCount() {
        int count = 0;
        for (int i = 0; i < serviceTimes.length; i++) {
            if (serviceTimes[i] > 10) {
                count++;
            }
        }
        return count;
    }

    public void displayStatistics() {
        System.out.println("Total students served: " + getTotalStudentsServed());
        System.out.println("Total service time: " + getTotalServiceTime() + " minutes");
        System.out.println("Average service time: " + getAverageServiceTime() + " minutes");
        System.out.println("Highest service time: " + getHighestServiceTime() + " minutes");
        System.out.println("Lowest service time: " + getLowestServiceTime() + " minutes");
        System.out.println("Number of services longer than 10 minutes: " + getLongerThanTenMinutesCount());
    }
}
