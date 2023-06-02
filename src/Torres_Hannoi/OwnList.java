package Torres_Hannoi;

import java.util.ArrayList;

public interface OwnList <T> {
    public int size();
        
    public boolean isEmpty();
    
    public boolean contains(Disk tobjet);
    
    public ArrayList<Disk> toArray();
    
    public boolean add(Disk tObjet);
    
    public Disk peek();
    
    public void clear();
    
    public Disk get(int index);
    
    
}
