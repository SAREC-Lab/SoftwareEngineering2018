package chatserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Joe Gregg
 */
public class Transcript {
    private List<String> transcript = Collections.synchronizedList(new ArrayList<String>());
    
    public Transcript() {
        
    }
    
    public void addComment(String comment) { transcript.add(comment); }
    public int getSize() { return transcript.size(); }
    public String getComment(int n) { return transcript.get(n); }
}
