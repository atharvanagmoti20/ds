import java.util.*;

public class PracTring {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        System.out.println("Enter number of nodes in ring");
        int n = sc.nextInt();

        System.out.println("The ring looks like below ");
        for (int i=0; i<n; i++){
            System.out.println(" "+ i+ " ");
        }
        System.out.println("0");

        int choice = 0;
        do {
            System.out.println("Select sender");
            int sender = sc.nextInt();

            System.out.println("Select reciever");
            int reciever = sc.nextInt();

            System.out.println("Select data to be sent");
            int data = sc.nextInt();

            int token = 0;

            for (int i=token; i<sender; i++){
                System.out.println(" "+ i + " ->");
            }
            System.out.println("Sender is : "+ sender);
            System.out.println("Data to be sent is : " + data);

            for (int i=sender; ;i = (i+1)%n){
                System.out.println("Data"+ data+ "forwarded by" + i);
                if(i == reciever){
                    break;
                }
            }
            System.out.println("Reciever is " + reciever);
            System.out.println("Data Recieved is: "+ data);

            token = sender;

            System.out.println("If you want to run the code press 1, else press 0.");
            choice = sc.nextInt();
        } while (choice == 1);
    }
    
}
