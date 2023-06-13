import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task t) {
        int min = 1000;
        Server minserver = null;
        for(Server s:servers) {
            if (s.getWaitingPeriod().get() < min) {
                min=s.getWaitingPeriod().get();
                minserver=s;
            }
        }
        if(minserver!=null)
            minserver.addTask(t);
    }
}
