import java.util.Scanner;
import java.io.IOException; 

class Node {

	String Question;
	Node yesNode;
	Node noNode;
	
	public Node(String d, Node nY, Node nN ) {
		Question = d;
		yesNode = nY;
		noNode = nN;
	}
	
	
	public String getAnswer() throws IOException {
		// get the input from the user 
		Scanner scanner = new Scanner(System.in);
		System.out.println(this.getQuestion()); 
		
		while (!scanner.hasNext	()) {
			scanner.nextLine();
			System.out.println(this.getQuestion());
		}
		
		String answer = scanner.next();
		if (!answer.equals("yes")&& !answer.equals("no")) {
			System.out.println("Please give yes or no");
			this.getAnswer();
		}
		return answer;
		
	}
	
	

	public String getQuestion() {
		return Question;
	}
	
	public void setQuestion(String Text) {
		Question  = Text;
	}
	public Node getYesNode() {
		return this.yesNode;
	}
	
	public Node getNoNode() {
		return this.noNode;
	}
	public void setYesNode(Node nY) {
		this.yesNode = nY;
	}
	public void setNoNode(Node nN) {
		this.noNode = nN;
	}
}