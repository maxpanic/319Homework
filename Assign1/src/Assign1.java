import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Assign1 {

	public static void main(String[] args) throws IOException{
	
	// Error checking for the first argument. Must literally be ascending, random, or descending.
	// Use regex to find exact word. Use system to send an error message and exit the application.
	Pattern regex0 = Pattern.compile("\\b(?:ascending|random|descending)\\b");
    Matcher matcher0 = regex0.matcher(args[0]);
    if(!matcher0.find()){
    	System.out.println("First argument: '" + args[0] +"' not understood. Please type ascending, random, or descending.\nApplication ending.");
    	System.exit(1);
    }
    String Order = new String(args[0]); // Parse the valid string.
    
    // Check for non-integer inputs in the second argument. Use try/catch method to find words or integers <= 0.
    // Use system to send an error message, then exit the application upon invalid input.
    try {
    	int x = Integer.parseInt(args[1]);
    	if (x<=0)
    		throw new NumberFormatException();
    }
    catch(NumberFormatException nFE) {
    	System.out.println(nFE + " is not a valid input, please enter an integer.\nApplication ending.");
    	System.exit(1);
    } 
    int [] a = new int [Integer.parseInt(args[1])]; // Parse the valid integer.
    
	// Error checking for the third argument. Must literally be bubble, insertion, merge, or quick.
	// Use regex to find exact word. Use system to send an error message and exit the application.
	Pattern regex2 = Pattern.compile("\\b(?:bubble|insertion|merge|quick)\\b");
    Matcher matcher2 = regex2.matcher(args[2]);
    if(!matcher2.matches()){
    	System.out.println("Thrid argument: '" + args[2] + "' not understood. Please type bubble, insertion, merge, or quick.\nApplication ending.");
    	System.exit(1);
    }
    String Type = new String(args[2]); // Parse the valid string.
   
	// Error checking for the fourth argument. Files should not include special characters. The .txt extension is concatenated by the program.
	// Use regex to find special characters. Use system to send an error message and exit the application.
    Pattern regex3 = Pattern.compile("[$!%^*()~&+.,:;=?@#|]");
    Matcher matcher3 = regex3.matcher(args[3]);
    if (matcher3.find()){
    	System.out.println("Please do not add extensions or special characters.\n'" + args[3] + "' is not allowed. This program outputs .txt only\nApplicaton ending.");
    	System.exit(1);
    }
    String Name2 = new String(args[0]+args[1]+args[2]);
    //String Name = new String(args[3]); // Parse the valid string.
    File outFile = new File (Name2 + ".txt"); // Concatenate the .txt extension to the name.
    FileWriter fWriter = new FileWriter (outFile); // Get the file ready for printing
    PrintWriter pWriter = new PrintWriter (fWriter); // Get the file writer ready.
    
    // Generate desired array order; descending, random, or ascending.
    if(Order.intern()=="descending"){
	    for(int i = a.length-1; i>0; i-- ){
	        a[i]=(i);
	    }
    }
    if(Order.intern()=="random"){
	    for(int i = 0; i<a.length; i++ ){
	        a[i]=((int)(Math.random()*100));
	    }
    }
    if(Order.intern()=="ascending"){
	    for(int i = 0; i<a.length; i++ ){
	        a[i]=(i);
	    }
    }
    // End array generation types.
    
    // Use comparison of Type to determine the sorting method.
    // Start timing just before sort method call, and end timing when it returns.
    // Print time to system and file.
    if(Type.intern()=="bubble"){
    	double start = System.currentTimeMillis();
        Bubble.BubbleSort(a);
        double end= System.currentTimeMillis();
        pWriter.println(end-start);
        System.out.println(end-start);
    }
    if(Type.intern()=="insertion"){
    	double start = System.currentTimeMillis();
        Insertion.InsertionSort(a);
        double end= System.currentTimeMillis();
        pWriter.println(end-start);
        System.out.println(end-start);
    }
    if(Type.intern()=="merge"){
    	double start = System.currentTimeMillis();
        Merge.mergeSort(a);
        double end= System.currentTimeMillis();
        pWriter.println(end-start);
        System.out.println(end-start);
    }
    if(Type.intern()=="quick"){
    	double start = System.currentTimeMillis();
        Quick.quickSort(a);
        double end= System.currentTimeMillis();
        pWriter.println(end-start);
    	System.out.println(end-start);
    }

    // Print the sorted array to the file, one line per entry.
	//    for(int i = 0; i<a.length; i++ ){
	//       	pWriter.println(a[i]);
	//    }
    // For printing agument information in the file
    pWriter.println(args[0] + " " + args[1] + " " + args[2]);
    pWriter.close(); // Close the file.
	}
}

