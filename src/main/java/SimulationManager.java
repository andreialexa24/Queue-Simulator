import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class SimulationManager implements Runnable{
    private int timeLimit =200;
    private int maxProcessingTime = 9;
    private int minProcessingTime = 3;
    private int numberOfServers = 20;
    private int numberOfClients = 1000;
    private int maxArrivalTime=100;
    private int minArrivalTime=10;
    private float average_waiting_time;
    private float average_service_time;
    private float peakhour;
    private FileWriter fileWriter;
    private SelectionPolicy  selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler;
    private SimulationFrame frame;
    private List<Task> generatedTasks;
    ArrayList<Thread> thread = new ArrayList<>();

    public SimulationManager() {
        try {
            fileWriter=new FileWriter("logs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConcreteStrategyTime time = new ConcreteStrategyTime();
        ConcreteStrategyQueue queue=new ConcreteStrategyQueue();
        this.scheduler = new Scheduler(numberOfServers, time,fileWriter);
        this.generatedTasks = new ArrayList<>();

    }

    private void generateNRandomTasks(){
        Random random=new Random();
        for(int i = 0; i < numberOfClients ; i++){
            Task task = new Task();
            task.setId(i+1);
            int randArrivalTime = random.nextInt(maxArrivalTime - minArrivalTime ) + minArrivalTime;
            task.setArrivalTime(randArrivalTime);
            int randProcessingTime = random.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
            task.setServiceTime(randProcessingTime);
            this.generatedTasks.add(task);
        }
        Collections.sort(generatedTasks);
        for(Task t:generatedTasks)
        {
            average_service_time+=t.getServiceTime();
            average_waiting_time+=t.getArrivalTime();
        }
        average_service_time/=generatedTasks.size();
        average_waiting_time/=generatedTasks.size();
    }

    @Override
    public void run() {
        int nr_tasks=0;
        generateNRandomTasks();
        int currentTime = 0;
        while (currentTime <= timeLimit){
            try {
                fileWriter.append("Time" + String.valueOf(currentTime)+"\n");
            } catch (IOException e) {
                e.printStackTrace();}
           System.out.println(currentTime);
            if(!generatedTasks.isEmpty()) {
                while (currentTime == generatedTasks.get(0).getArrivalTime()) {
                    Task t = generatedTasks.get(0);
                    generatedTasks.remove(0);
                    scheduler.dispatchTask(t);
                    if (generatedTasks.isEmpty())
                        break;}}
            try {
                fileWriter.append("Waiting clients" + generatedTasks.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();}
            System.out.println(generatedTasks.toString());
            if(nr_tasks<scheduler.nr_tasks_all())
                peakhour=currentTime;
            currentTime++;
            try {
                scheduler.start();
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();}}
        scheduler.stop();
        scheduler.start();
        System.out.println("Average Service Time " +average_service_time);
        System.out.println("Average Waiting Time " + average_waiting_time);
        System.out.println("Peak hour " + peakhour);
        try {
            fileWriter.append(average_service_time + "\n");
            fileWriter.append(average_waiting_time + "\n");
            fileWriter.append(peakhour + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();
    }


}
