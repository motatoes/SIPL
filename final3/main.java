import java_cup.runtime.*;
import java.io.FileInputStream;

public class main {

    public static void main(String args[]) throws Exception {

    	//check that a file arg was passed
    	if ( args.length != 1) {
    		System.out.println("<<Usage: main Filename>>");
    		System.exit(0);
    	}

    	FileInputStream file = null;
    	//make sure we can access the file
    	try {
	    	file = new FileInputStream(args[0]);
    	}
    	catch (Exception E) {
    		System.out.println("<<Error: Could not access the file>>");
    		System.exit(0);    		
    	}

    	try {
    		//try to parse
	        parser p = new parser(new Yylex(file));
	        p.parse();
	        Node x = p.getTree();//.GetLeftChild();
    		//x = x.GetLeftChild();


    		System.out.println(x.dump_program());
    	}
    	catch (Exception e) {
    		//not a valid language :-(
    		System.out.println("<<Not a valid SIPL language>>");
    	}
    }
} 
