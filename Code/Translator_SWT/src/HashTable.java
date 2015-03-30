import java.awt.List;
import java.util.ArrayList;


public class HashTable
{
    private Object[] entries;
    private int index = 0;
    
    public Object[] getEntries() { return entries; }

    public int size() { return index; }
    
    public HashTable()
    {
        entries = new Object[1];
    }

    private static Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(
                elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray; 
    }

    public boolean set(Object key, Object value)
    {
        // if it exists, return false. 
        if (exists(key))
            return false;

        entries = (Object[])resizeArray(entries, entries.length + 1);
        entries[index] = new Object[] { key, value };
        
        //((Object[])entries[index])[0] = key;
        //((Object[])entries[index])[1] = value;
        //entries[index] = { key, value };
        index++;

        return true;
    }

    public void overwrite(Object key, Object value)
    {
        // here, we don't care if it's already added. If it does exist, overwrite it.
        if (exists(key))
        {
            for (int i = 0; i < entries.length; i++)
            {
            	if (entries[i] != null)
            	{
            	Object[] tempEntry;
            	if (entries[i] instanceof ArrayList)
            	{
                	ArrayList tempList = (ArrayList)entries[i];
                    tempEntry = tempList.toArray();        		
            	}
            	else
                    tempEntry = (Object[])entries[i];
                
                if (tempEntry[0].equals(key))
                {
                    entries[i] = new Object[] { key, value };
                }
            	}
            }
        }
        else
        {
            this.set(key, value);
        }
    }

    public Object get(Object key)
    {
        for (int i = 0; i < entries.length; i++)
        {
        	if (entries[i] != null)
        	{
        		//Object[] tempEntry = (Object[])entries[i];
	            //if (tempEntry[0] == key)
	        	Object[] tempEntry;
	        	if (entries[i] instanceof ArrayList)
	        	{
	            	ArrayList tempList = (ArrayList)entries[i];
	                tempEntry = tempList.toArray();        		
	        	}
	        	else
	                tempEntry = (Object[])entries[i];
	        	
	            if (tempEntry[0].equals(key))
	            {
	                return tempEntry[1];
	            }
        	}
        }
        // didn't hit anything, so we can infer that it doesn't exist.
        return null;
    }

    public boolean exists(Object key)
    {
        if (index == 0)
            return false;

        for (int i = 0; i < entries.length - 1; i++)
        {
        	if (entries[i] != null)
        	{
        	Object[] tempEntry;
        	if (entries[i] instanceof ArrayList)
        	{
            	ArrayList tempList = (ArrayList)entries[i];
                tempEntry = tempList.toArray();        		
        	}
        	else
                tempEntry = (Object[])entries[i];
            
            if (tempEntry[0].equals(key))
            {
                return true;
            }
        	}
        }
        return false;
    }
    
    public String toString()
    {
        String output = "";
        for (int i = 0; i < entries.length - 1; i++)
        {
        	if (entries[i] != null)
        	{
        	Object[] tempEntry;
        	if (entries[i] instanceof ArrayList)
        	{
            	ArrayList tempList = (ArrayList)entries[i];
                tempEntry = tempList.toArray();        		
        	}
        	else
                tempEntry = (Object[])entries[i];
            
            output += "Key: \"" + tempEntry[0] + "\", Value: \"" + tempEntry[1] + "\" - ";
        	}
        }
        return output;
    }
    
}