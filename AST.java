//abstract syntax tree class adapted from : http://stackoverflow.com/questions/5323230/need-help-in-creating-ast-from-cup-in-java
import java.util.Stack;

public class AST {

    private Node root=null;
    private Stack<Node> stack=null;

    public AST(){
        root=null;
        stack=new Stack<Node>();
    }

    public Node GetRoot(){return root;}
    public void SetRoot(Node root){this.root=root;}

    public String GetExpression(){
        return root.EvaluateToString();
    }
}