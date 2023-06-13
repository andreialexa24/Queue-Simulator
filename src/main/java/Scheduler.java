import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private Strategy strategy;
    private Task waiter;

    public Scheduler(int numberOfServerss, Strategy strategy, FileWriter fileWriter) {
        waiter=new Task();
        this.servers = new ArrayList<Server>(10);
        this.strategy = strategy;
       for(int i = 0; i < numberOfServerss; i++)
       {
           Server task = new Server(waiter,fileWriter);
           this.servers.add(task);
           Thread thread = new Thread(task);
           thread.start();
       }

    }

    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            this.strategy = new ConcreteStrategyTime();
        }

        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            this.strategy = new ConcreteStrategyQueue();
        }

    }

    public void dispatchTask(Task t) {
        this.strategy.addTask(this.servers, t);
    }

    public List<Server> getServers() {
        return this.servers;
    }
    public void start()
    {
        synchronized (waiter){
        waiter.notifyAll();}
    }

    public int nr_tasks_all()
    {
        int n=0;
        for (Server s: servers)
            n+=s.getNr_task();
        return n;
    }

    public void stop()
    {
        for(Server s:servers) {
            s.setRun(false);
        }
    }
}
