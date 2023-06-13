public class Task implements Comparable<Task>{
    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Task() {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "( " + id + ", " + arrivalTime + ", " + serviceTime + ") ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Task o) {
        return this.getArrivalTime()-o.getArrivalTime();
    }

    public String task_interfata()
    {
        return "😀 ";
    }

}



