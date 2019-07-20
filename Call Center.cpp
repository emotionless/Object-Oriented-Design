#include <bits/stdc++.h>
using namespace std;

class Call {
    int rank = 0; // minimal rank of employee who can handle this call

    public void reply(string message) {
        // play recorded message to the customer
    }

    public void disconnect() {
        reply("Thank you for calling");
    }
};

class Employee {
    CallHandler callHandler;
    int rank;
    /*
        0 - Fresher
        1 - technical lead (TL)
        2 - Product Manager (PM)
    */
    bool free;

    public Employee(int rank) {
        this.rank = rank
    }

    void receiveCall(Call call) {
        this.free = false;
    }

    void callHandled(Call call) {
        call.disconnect();
        free = true;
        callHandler.getNextCall(this);
    }

    void cannotHandle(Call call) {
        call.rank = rank + 1;
        callHandler.dispatchCall(call);
        free = true;
        callHandler.getNextCall(this);
    }

};

class Fresher : Employee {
    public Fresher() {
        Employee(0);
    };
};

class TechLead : Employee {
    public TechLead() {
        Employee(1);
    };
};

class ProductManager : Employee {
    public ProductManager() {
        Employee(2);
    };
};

public class CallHandler {
    const int LEVELS = 3;
    const int NUM_FRESHERS = 5; // say we have 5 freshers

    vector<Employee> employeeLevels[LEVELS];
    vector<Call> callQueues[NUM_FRESHERS];

    public CallHandler() {
        // for freshers
        for(int i = 0; i < NUMS_FRESHERS; i++) {
            employeeLevels[0].push_back(new Fresher());
        }
        // for TL
        employeeLevels[1].push_back(new TechLead());
        employeeLevels[2].push_back(new ProductManager());
    }

    Employee getCallHandler(Call call) {
        for(int level = call.rank; level < LEVELS; level++) {
            for(Employee employee : employeeLevels[level]) {
                if(employee.free == true) {
                    return employee;
                }
            }
        }
        return NULL;    // Not anyone free
    }

    void dispatchCall(Call call) {
        Employee = emp = getCallHandler(call);
        if(emp != NULL) {
            emp.receiveCall(call);
        } else {
            // place the call into corresponding queue to it's rank
            call.reply("Please wait for free employee to reply")
            callQueues[call.rank].push_back(call);
        }
    }

    void getNextCall(Employee emp) {
        for(int rank = employee.rank; rank >= 0; rank--) {
            for(Call call : callQueues[rank]) {
                // remove this call from queue
                callQueues[rank].pop_front();
                // receive call
                emp.receiveCall(call);
                return;
            }
        }
    }
};
