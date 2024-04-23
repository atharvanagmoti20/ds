import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the ring");
        int n = sc.nextInt();

        System.out.println("The ring looks like this");
        for(int i=0; i<n; i++){
            System.out.print(i + " ");
        }
        System.out.println("0");

        int choice = 0;
        do {
            System.out.println("Enter the sender");
            int sender = sc.nextInt();

            System.out.println("enter the reciever");
            int reciever = sc.nextInt();

            System.out.println("Enter the data");
            int data = sc.nextInt();

            int token = 0;

            System.out.println("Token passing");

            for (int i=token; i<sender; i++){
                System.out.println(" " + i + "->");
            }
            System.out.println("The sender is: "+ sender);
            System.out.println("Data to be sent: "+ data);

            for(int i=sender; ; i = (i+1)%n){
                System.out.println("Data " + data + " forwarded by " + i);
                if(i == reciever) {
                    break; // Break out of the loop once the data reaches the receiver
                }
            }
            
            System.out.println("Reciever is : "+ reciever);
            System.out.println("Data recieved"+data);

            token = sender;

            System.out.println("If you want to run code again press 1, else press0 to exit.");
            choice = sc.nextInt();

        } while (choice == 1);

    }
}
