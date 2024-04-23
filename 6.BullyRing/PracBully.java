import java.util.*;

public class PracBully {
    
    int max_processes;
    int coord;
    boolean processes[];

    public PracBully(int max){
        max_processes = max;
        coord = max;
        processes = new boolean[max_processes];

        System.out.println("Creating Processes");
        for (int i=0; i< max_processes; i++){
            processes[i] = true;
            System.out.println("Process: "+ (i+1)+ "  is created");
        }
    }

    void displayprocesses(){
        for (int i=0; i<max_processes; i++){
            if(processes[i]){
                System.out.println("Process " + (i+1)+ "  is up");
            }
            else{
                System.out.println("Process "+(i+1)+ "  is down");
            }
        }
        System.out.println("The coordinator is " + coord);
    }

    void upprocesses(int process_id){
        if(processes[process_id - 1]){
            System.out.println("The process is already up");
        }
        else{
            processes[process_id - 1] = true;
            System.out.println("The process is now up.");
        }
    }

    void downprocesses(int process_id){
        if(!processes[process_id - 1]){
            System.out.println("The process is already down");
        }
        else{
            processes[process_id - 1] = false;
            System.out.println("The process is now down.");
        }
    }

    void resultElection(int process_id){
        coord = process_id;
        boolean keepgoing = true;

        for(int i=process_id; i<max_processes && keepgoing; i++){
            System.out.println("Election message is passed from "+ process_id+ "to "+ (i+1));

            if(processes[i]){
                keepgoing = false;
                resultElection(i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        PracBully bully = null;
        int max_processes = 0;
        int process_id = 0;
        int choice = 0;

        while (true){
            System.out.println("Bully Algorithm");
            System.out.println("1. Create Process");
            System.out.println("2. Display Process");
            System.out.println("3. UP Process");
            System.out.println("4. Down Process");
            System.out.println("5. Result Election");
            System.out.println("6. Exit");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                System.out.println("Enter the total number of processes. ");
                max_processes =  sc.nextInt();
                bully = new PracBully(max_processes);
                break;

                case 2: 
                bully.displayprocesses();
                break;

                case 3:
                System.out.println("Enter the process id to be up");
                process_id = sc.nextInt();
                bully.upprocesses(process_id);
                break;

                case 4:
                System.out.println("Enter the process id to be down");
                process_id = sc.nextInt();
                bully.downprocesses(process_id);
                break;

                case 5:
                System.out.println("Enter the process id that will send election message");
                process_id = sc.nextInt();
                bully.resultElection(process_id);
                break;

                case 6:
                System.exit(0);
                break;

                default:
                System.out.println("Enter valid choice");
                break;
            }


        }
        
    }
    
}
