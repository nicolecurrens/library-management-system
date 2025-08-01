package libraryManagementSystem;

import java.time.LocalDate;

public class Request {
    private User requester;
    private Materials material;
    private LocalDate date;

    public Request(User requester, Materials material, RequestManager rm) {
        this.requester = requester;
        this.material = material;
        this.date = LocalDate.now();
        
        // When creating a request object, add it to the request manager
        rm.addRequest(material);
    }

    public User getRequester() {
        return requester;
    }

    public Materials getMaterial() {
        return material;
    }
}

