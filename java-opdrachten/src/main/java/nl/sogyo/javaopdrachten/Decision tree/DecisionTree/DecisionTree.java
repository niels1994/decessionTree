import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DecisionTree {

	public static void main(String[] args) throws IOException {

		String path = "./decision-tree-data.txt";
		
		HashMap<String,Node> NodesData = FileToNodes(path);
		
		// Manually set the first Node 
		boolean Loop = true;
		Node currentNode = NodesData.get("N1"); 
		while (Loop) {
			if (currentNode.getNoNode() == null && currentNode.getYesNode() == null) {
				System.out.println(currentNode.getQuestion());
				Loop = false; 
				break; }
			
			String temp = currentNode.getAnswer();
			
			if (temp.equals("yes")) {
				Node tempNode = currentNode.getYesNode();
				currentNode = tempNode; 
			}
			if (temp.equals("no")) {
				Node tempNode = currentNode.getNoNode();
				currentNode = tempNode; 
			}
		}
	}
		
	
		public static HashMap<String,Node> FileToNodes(String path) throws IOException{
			
			String line;
			ArrayList<String[]> fileData = new ArrayList<String[]>();
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					fileData.add(values);
				}	
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			// first make the Nodes 
			HashMap<String,Node> NodesData = new HashMap<String,Node>();
			for (String[] test : fileData) {
				if (test.length == 2) {
					NodesData.put(test[0],new Node(test[1].strip(),null,null));
				}
			}
			for (String[] test : fileData) {
				if (test.length == 3) {
	
					if (test[2].contains("Ja")) {
						NodesData.get(test[0].strip()).setYesNode(NodesData.get(test[1].strip()));
					}
					else if(test[2].contains("Nee")) {
						NodesData.get(test[0].strip()).setNoNode(NodesData.get(test[1].strip()));
	
					}
				}
			}
			return NodesData;
		}
		
	
		
		
}

	


