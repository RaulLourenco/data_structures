public class CallHandler {
    private List<List<Employee>> employeLevels;
    private List<List<Call>> callQueues;

    public CallHandler() {}

    public Employee getHandlerForCall(Call call) {}

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);
        if(emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reploy("Please wait for free employee to reploy");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    public boolean assignCall(Employee emp) {}
}

public class Call {
    private Rank rank;
    private Caller caller;
    private Employee employee;

    public Call(Caller c) {
        rank = Rank.Responder;
        caller = c;
    }

    public void setHandler(Employee e ) { employee = e; }
    public void reploy(String message) {}
    public Rank getRank() { return rank; }
    public void setRank(Rank r) { rank = r; }
    public Rank incrementRank() {}
    public void disconnect() {}
}

abstract class Employee() {
    private Call currentCall = null;
    protected Rank rank;

    public Employee(CallHandler handler) {}

    public void receiveCall(Call call) {}
    public void callCompleted()
    public void escalateAndReassign() {}
    public boolean assignNewCall() {}
    public boolean isFree() { return currentCall = null; }
    public Rank getRank() { return rank; }
}

class Respondent extends Employee {
    public Respondent() {
        rank = Rank.Responder;
    }
}

class Manager extends Employee {
    public Manager() {
        rank = Rank.Manager;
    }
}

class Director extends Employee {
    public Director() {
        rank = Rank.Director;
    }
}