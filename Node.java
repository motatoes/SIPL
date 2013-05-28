// class adapted from: http://stackoverflow.com/questions/5323230/need-help-in-creating-ast-from-cup-in-java

public class Node {
    private String value;
    private String type;
    private Boolean visited;
    private Node leftChild, rightChild;

    public Node(){
        value="";
        type="";
        visited=false;
    }

    public Node(String value, String type, Boolean visited, Node  leftChild, Node rightChild){
        this.value=value;
        this.type=type;
        this.visited=visited;
        this.leftChild=leftChild;
        this.rightChild=rightChild;
    }

    public Node(String value, String type, Boolean visited){
        this.value=value;
        this.type=type;
        this.visited=visited;
    }

    public Node(String value, String type,Boolean visited, Node leftChild){
        this.value=value;
        this.type=type;
        this.visited=visited;
        this.leftChild=leftChild;
        this.rightChild=null;
    }

    public Node(String value, String type, Node leftChild){
        this.value=value;
        this.type=type;
        this.visited=false;
        this.leftChild=leftChild;
        this.rightChild=null;
    }


    public void SetValue(String value){this.value=value;}
    public String GetValue(){ 
    		return (String)value; 
    }
    public void SetType(String type){this.type=type;}
    public String GetType(){return type;}
    public void SetVisited(Boolean visited){this.visited=visited;}
    public Boolean GetVisited(){return visited;}

    public Node GetLeftChild(){return leftChild;}
    public void SetLeftChild(Node leftChild){this.leftChild=leftChild;}
    public void SetRightChild(Node rightChild){this.rightChild=rightChild;}
    public Node GetRightChild(){return rightChild;}

    public String EvaluateToString(){
        String temp="";
        temp+=value + ":" + type + "- ";
        if(leftChild!=null)
            temp+= "\nLL  " + leftChild.EvaluateToString();
        if(rightChild!=null)
            temp+="\nRR  " + rightChild.EvaluateToString();
        return temp;
    }
    public String dump_program() {
    	return dump_program_dummy(0);
    }
    private String dump_program_dummy(int indent) {
	        String temp="";
	        

	        switch (value) {

	        	case "block":
	        		temp += getIndent(indent) + "begin\n" ;
		        	indent++;
	        	
			        if(leftChild!=null) {
			            	temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}
	        		indent--;
	        		temp += "\n" + getIndent(indent) + "end";
	        		break;

	        	case "declaration":
	        		temp += getIndent(indent) + "var ";

			        if(leftChild!=null) {
			            	temp += leftChild.dump_program_dummy(indent); 
			        }
		        	temp += " ;\n";
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}
	        		break;
	        	case "iden":
					temp += type;
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}
		        	break;
	        	case "num":
					temp += type;
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}
		        	break;
		        case "seq":
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " ;\n";

			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 

		        	}		        	
		        	break;
 
 		        case "input":
	 		        temp += getIndent(indent) + "input ";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            //temp += " ; \n";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            
		        	}		        	
		        	break;
 
 		        case "output":
	 		        temp += getIndent(indent) + "output ";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            //temp += " ; \n";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            
		        	}		        	
		        	break;
 		        
 		        case "assignment":
	 		        temp += getIndent(indent);
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " := ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            //temp += " ; \n";
		        	}		        	
		        	break;
 		        case "BRACETS":
			        if(leftChild!=null) {
			        	temp += "( ";
			            temp += leftChild.dump_program_dummy(indent); 
			        	temp += " )";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            //temp += " ; \n";
		        	}		        	
		        	break;		        	
 		        case "EPLUS":
	 		        temp += "";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " + ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            temp += "";
		        	}		        	
		        	break;
 		        
 		        case "EMINUS":
	 		        temp += "";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " - ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            temp += "";
		        	}		        	
		        	break;
 		        
 		        case "UNARYMINUS":
	 		        temp += "";
			        if(leftChild!=null) {	
			        	temp += " ( ";
			        	temp += " - ";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " ) ";
			            temp += "";
		        	}		        	
		        	break;
 		        
 		        case "ETIMES":
	 		        temp += "(";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " * ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}		  
		            temp += ")";
					break;
 		        case "EDIVIDE":
	 		        temp += "(";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " / ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}		  
		            temp += ")";
					break;

 		        case "if":
	 		        temp += getIndent(indent) + "if ";
			        if(leftChild!=null) {
			        	temp += "( ";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " ) then\n";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}	
		        	break;	

 		        case "ifbody":
	 		        //temp += getIndent(indent) + "begin\n";
	 		        indent ++;
			        if(leftChild!=null) {
			        	
			            temp += leftChild.dump_program_dummy(indent); 
			           
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}	
		        	indent--;
		            //temp += "\n";
		        	break;	

 		        case "elsebody":
	 		        temp += "\n" + getIndent(indent) + "else";
	 		        temp += "\n";
	 		        indent ++ ;
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 

			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}	
		        	indent --;
		            //temp += getIndent(indent) + "end\n";
		        	break;	

		        case "true":
	 		        temp += " TRUE ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += "";
		        	}	
		        	break;	

		        case "false":
	 		        temp += " FALSE ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += "";
		        	}	
		        	break;	

		        case "not":
	 		        temp += " ( ";
	 		        temp += " not ";
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}	
	 		        temp += " ) ";
		        	break;	

		        case "eqeq":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " == ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            temp += " )";
		        	}	
		        	break;	

		        case "noteq":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " != ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            temp += " )";
		        	}	
		        	break;	


		        case "lthan":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " < ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += " )";
		        	}	
		        	break;	


		        case "lthaneq":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " <= ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += " )";
		        	}	
		        	break;	


		        case "gthan":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " > ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += " )";
		        	}	
		        	break;	


		        case "gthaneq":
	 		        temp += "( ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " >= ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += " )";
		        	}	
		        	break;	


		        case "AND":
	 		        temp += " ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " AND ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += "";
		        	}	
		        	break;	

		        case "OR":
	 		        temp += " ";
			        if(leftChild!=null) {
			        	temp += "";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " OR ";
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		            temp += "";
		        	}	
		        	break;	








 		        case "while":
	 		        temp += getIndent(indent) + "while ";
			        if(leftChild!=null) {
			        	temp += "( ";
			            temp += leftChild.dump_program_dummy(indent); 
			            temp += " ) do\n";
						indent ++ ;
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
			            indent --;
		        	}	
		        	break;	

	


	       		default:
			        if(leftChild!=null) {
			            temp += leftChild.dump_program_dummy(indent); 
			        }
			        if(rightChild!=null) {	
			            temp += rightChild.dump_program_dummy(indent); 
		        	}
	        		break;

	        }

        return temp;   	
    }

    public String getIndent (int iden) {
    	String t="";

    	for (int i=0;i<iden;i++) {
    		t += "    ";
    	}

    	return t;
    }

}