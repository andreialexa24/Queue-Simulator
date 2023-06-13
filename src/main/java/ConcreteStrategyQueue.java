import java.util.List;

public class ConcreteStrategyQueue implements Strategy {
    public ConcreteStrategyQueue() {
    }

    @Override
    public void addTask(List<Server> servers, Task t) {
        int min = 1000;
        Server minserver = null;
        for(Server s:servers) {
            if (s.getNr_task() < min) {
                min=s.getNr_task();
                minserver=s;
            }
        }
        if(minserver!=null)
            minserver.addTask(t);
    }
}
