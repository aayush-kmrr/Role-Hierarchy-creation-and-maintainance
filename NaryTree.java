import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NaryTree {
    public static class TreeNode{
        String val;
        List<TreeNode> children = new LinkedList<>();

        TreeNode(String data){
            val = data;
        }

        TreeNode(String data,List<TreeNode> child){
            val = data;
            children = child;
        }
    }

    private static void printNAryTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                System.out.print(node.val + " ");
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
        }
    }

    private static void Findnode(TreeNode root,String boss,String subRole){
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                for (TreeNode item : node.children) {
                    if(node.val.equalsIgnoreCase(boss)){
                        break;
                    }
                    queue.offer(item);
                }
                break;
            }
            
        }
        root.children.add(new TreeNode(subRole));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter root role name : ");
        String root_role = input.nextLine();
        TreeNode root = new TreeNode("CEO");
        for(;;){
            System.out.println(" ");
            System.out.println("Operations");
            System.out.println("1. Add Sub Role");
            System.out.println("2. Display Role");
            int operation = Integer.parseInt(input.nextLine());
            switch(operation){
                case 1:
                System.out.print("Enter sub role name : ");
                String sub_role = input.nextLine();
                System.out.print("Enter reporting role name : ");
                String reporting_role = input.nextLine();
                Findnode(root, reporting_role, sub_role);
                break;
                case 2:
                printNAryTree(root);
                break;
                default: continue;
            }
            
            
        }
        
    }
}
