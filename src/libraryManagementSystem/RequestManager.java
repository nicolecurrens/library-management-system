package libraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class RequestManager {
    private ArrayList<Materials> materialsWithRequests;

    // TODO should this be a singleton, only one request manager per program
    public RequestManager() {
    	materialsWithRequests = new ArrayList<Materials>();
    }

    public void addRequest(Materials m) { 
        materialsWithRequests.add(m);
    }

    public void removeRequest(Materials m) {
        for (int i = 0; i < materialsWithRequests.size(); i++) {
        	if( materialsWithRequests.get(i).equals(m)) {
        		materialsWithRequests.remove(i);
        	}
        }
    }
    
    public boolean requestExists(Materials m) {
        for (int i = 0; i < materialsWithRequests.size(); i++) {
        	if( materialsWithRequests.get(i).equals(m)) {
        		return true;
        	}
        }
        
        return false;
    }

}