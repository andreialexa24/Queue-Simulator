import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private final BlockingQueue<Task> tasks;
    private final AtomicInteger waitingPeriod;
    private int nr_task;
    private boolean run;
    private Task waiter;
    private FileWriter fileWriter;
    public Server(Task waiter,FileWriter fileWriter) {
        this.tasks = new ArrayBlockingQueue(100);
        this.waitingPeriod = new AtomicInteger(0);
        run = true;
        nr_task = 0;
        this.waiter = waiter;
        this.fileWriter=fileWriter;
    }

    public void addTask(Task newTask) {
        this.tasks.add(newTask);
        this.nr_task++;
        this.waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }


    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public Task getWaiter() {
        return waiter;
    }

    public int getNr_task() {
        return nr_task;
    }

    @Override
    public void run() {
        Task t = null;
        while (run) {
            if (t == null) {
                Task task = (Task) this.tasks.peek();
                if (task != null) {
                    try {
                        t = tasks.take();
                        fileWriter.append("Queue " + Thread.currentThread().getId() + ": serving " + t + "waiting " + tasks.toString() + "\n");
                        //System.out.print("Queue " + Thread.currentThread().getId() + ": serving " + t + "waiting " + tasks.toString() + "\n");
                        System.out.println(t.task_interfata()+" "+tasks_emoji());
                        //Thread.sleep(1000);
                        synchronized (waiter) {
                            waiter.wait();}
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();}}
            } else {
                t.setServiceTime(t.getServiceTime() - 1);
                waitingPeriod.decrementAndGet();
                if (t.getServiceTime() == 0) {
                    nr_task--;
                    t = null;
                    continue;}
                //System.out.print("Server " + Thread.currentThread().getId() + ": serving " + t + "waiting " + tasks.toString() + "\n");
                System.out.println(t.task_interfata()+" "+tasks_emoji());
                try {
                    fileWriter.append("Server " + Thread.currentThread().getId() + ": serving " + t + "waiting " + tasks.toString() + "\n");
                    Thread.sleep(1000);
                    synchronized (waiter) {
                        waiter.wait();}
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();}}}}


    public String tasks_emoji()
    {
        StringBuilder sb=new StringBuilder();
        for(Task t:tasks)
        {
            sb.append(t.task_interfata());
        }
        sb.append("\n");
        return sb.toString();
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }
}
