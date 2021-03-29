import java.util.*;


public class Dictionary {

	Map<String, List<String>> dictionary = new HashMap<>();


	public void commands() {
		System.out.println("List of Commands: KEYS, MEMBERS, ADD, REMOVE, REMOVEALL, CLEAR, KEYEXISTS, VALUEEXISTS, ALLMEMBERS, ITEMS, EXIT" + "\n");
	}
	
	
	public boolean isNullOrEmpty(String str) {
		
		return str == null && str.trim().isEmpty();
	
	}
	
	
    public void validateCommand(String[] input, int len){
    	 
        String command = input[0];
     
        boolean isvalid = true;
        	if ((input.length == len)) {
        		
        		
        		for (int i=1; i<input.length;i++) {
        			isvalid = isvalid && !isNullOrEmpty(input[i]);
        		}
        	} else {
        		isvalid = false;
        	}
        	if (!isvalid ) {
        		System.out.println("Error: Invalid input");
        		}
       
    }

    public void add(String key,String value){
        if(!dictionary.containsKey(key)){
            dictionary.put(key,new ArrayList<>());
        }
        
        if(dictionary.get(key).contains(value)){
            System.out.println("Value already exists");
            return;
        }
        dictionary.get(key).add(value);
        System.out.println("Success");
       
    }


    public void getKeys(){
      
    	
    	 boolean isemp = dictionary.isEmpty();   
         if (isemp) {
         	System.out.println("No Keys are present");	
         }
    	
        for(String s: dictionary.keySet()){
            System.out.println(s);
                     
        }
    }
    
    
    public void getMembers(String key){
      	  	
    		if(!dictionary.containsKey(key)){
            System.out.println("Key does not exist");
    		}
    		
    		if(dictionary.containsKey(key)) {
    			System.out.println(dictionary.get(key));
    			    }
        		}
    	

    public void remove(String key,String value){
        if(!dictionary.containsKey(key)){
            System.out.println("Key does not exist");
        }
        dictionary.get(key).remove(value);
        System.out.println("Success");
       
    }
    
    
    public void removeAll(String key){
        if(!dictionary.containsKey(key)){
            System.out.println("Key does not exist");
        }
        dictionary.remove(key);
        System.out.println("Success");
       
    }
    
    public void clear(){
        dictionary.clear();
        System.out.println("Success");
    }
    
    public void keyExists(String key) {
    	if(dictionary.containsKey(key)) {
    		System.out.println("true");
    	} else {
    		System.out.println("false");
    	}
    }
    
    public boolean valueExists(String key, String value) {
    		
    	List<String> memberValues = dictionary.get(key);
    	
    	return memberValues.contains(value);
    
    }
    
    public void allMembers() {
    	
    	for(String s: dictionary.keySet()){
            System.out.println(dictionary.get(s));
        }
    	
    }
    
    
public void items() {
    	
    	for(String s: dictionary.keySet()){
    		System.out.println("Key: " + s);
            System.out.println("Members: " + dictionary.get(s));
        }
    	
    }
     

    public static void main(String[] args) {
    	
    	System.out.println("\n" + "Welcome to Surya's Spreetail Work Sample" + "\n");
    	System.out.println("This is a tiny command line app that stores a multi-value dictionary in memory" + "\n");
    	System.out.println("List of Commands: KEYS, MEMBERS, ADD, REMOVE, REMOVEALL, CLEAR, KEYEXISTS, VALUEEXISTS, ALLMEMBERS, ITEMS, EXIT" + "\n");
    	
        Scanner in = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        while(true)
        {
        	
        	try {
        
        	
            System.out.print("\n" + "Enter a command : ");
            String s = in.nextLine( );

            if(s.equals("")|s.equals("pl exit"))
            {
            	System.out.println("Invalid command. Please enter a valid command");
                continue;
            }
            else
            {
                String[] commandValues = s.split(" ");
             //   dictionary.validateCommand(commandValues);
                switch (commandValues[0]){
                
                	case "COMMANDS": case "commands": 
                		dictionary.commands();
                		continue;
                    case "ADD": case "add": 
                    	dictionary.validateCommand(commandValues, 3);
                        dictionary.add(commandValues[1],commandValues[2]);
                        continue;
                    case "KEYS": case "keys": 
                    	dictionary.validateCommand(commandValues, 1);
                        dictionary.getKeys();
                        continue;
                    case "MEMBERS": case "members":
                    	dictionary.validateCommand(commandValues, 2);
                        dictionary.getMembers(commandValues[1]);
                        continue;
                    case "REMOVE": case "remove": 
                    	dictionary.validateCommand(commandValues, 3);
                        dictionary.remove(commandValues[1],commandValues[2]);
                        continue;
                    case "REMOVEALL": case "removeall": 
                    	dictionary.validateCommand(commandValues, 2);
                        dictionary.removeAll(commandValues[1]);
                        continue;
                    case "CLEAR": case "clear":
                    	dictionary.validateCommand(commandValues, 1);
                        dictionary.clear();
                        continue;    
                    case "KEYEXISTS": case "keyexists":
                    	dictionary.validateCommand(commandValues, 2);
                        dictionary.keyExists(commandValues[1]);
                        continue;
                    case "VALUEEXISTS": case "valueexists":
                    	dictionary.validateCommand(commandValues, 3);
                        dictionary.valueExists(commandValues[1], commandValues[2]);
                        continue;
                    case "ALLMEMBERS": case "allmembers":
                    	dictionary.validateCommand(commandValues, 1);
                        dictionary.allMembers();
                        continue;
                    case "ITEMS": case "items":
                    	dictionary.validateCommand(commandValues, 1);
                        dictionary.items();
                        continue;
                    case "EXIT": case "exit":
                    	System.out.println("Exited application. Thank you");
                    	return;
                    	
                    
                    default:
                        System.out.println("Invalid command. Please enter a valid command");
                }
            }
            
        }  catch (Exception e) {
        	System.out.println("");
        }
        }
    }
	
}
