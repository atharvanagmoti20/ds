import java.util.*;

public class Bully {
    int max_processes;
    int coord;
    boolean proccesses[];

    public Bully(int max){
        max_processes =  max;
        coord = max;
        proccesses = new boolean[max_processes];

        for(int i =0; i< max_processes; i++){
            proccesses[i] =  true;
            System.out.println("The Process" + (i+1) + "is Created.");
        }        
    }

    void displayprocesses(){
        for (int i =0; i< max_processes; i++){
            if(proccesses[i]){
                System.out.println("The process"+ (i+1) +" is up");
            }
            else{
                System.out.println("The process "+ (i+1) +" is down");
            }
        }
        System.out.println("The coordinator is "+ coord);
    }

    void upprocesses(int process_id){
        if(proccesses[process_id - 1]){
            System.out.println("The process is already up");
        }
        else{
            proccesses[process_id-1] = true;
            System.out.println("The process is now up");
        }
    }

    void downprocesses(int process_id){
        if(!proccesses[process_id - 1]){
            System.out.println("The process is already down");
        }
        else{
            proccesses[process_id-1] = false;
            System.out.println("The process is now down");
        }
    }

    void resultElection(int process_id){
        coord = process_id;
        boolean keepgoing = true;

        for(int i=process_id; i< max_processes && keepgoing; i++){
            System.out.println("The Election message sent from" + process_id + "to "+ (i+1));

            if(proccesses[i]){
                keepgoing = false;
                resultElection(i+1);
            }
        }
    }

    public static void main(String[] args) {
        Bully bully = null;
        int max_processes = 0;
        int choice = 0;
        int process_id = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Bully Algorithm");
            System.out.println("1. Create Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Up Process");
            System.out.println("4. Down Process");
            System.out.println("5. Election");
            System.out.println("6. Exit");
            choice = sc.nextInt();

            switch(choice){
                case 1: 
                System.out.println("Enter number of processes");
                max_processes = sc.nextInt();
                bully = new Bully(max_processes);
                break;

                case 2:
                bully.displayprocesses();
                break;
                
                case 3:
                System.out.println("enter process to be up");
                process_id = sc.nextInt();
                bully.upprocesses(process_id);
                break;

                case 4:
                System.out.println("enter process to be down");
                process_id = sc.nextInt();
                bully.downprocesses(process_id);
                break;

                case 5:
                System.out.println("Process to initiate teh election");
                process_id = sc.nextInt();
                bully.resultElection(process_id);
                break;

                case 6:
                System.exit(0);
                break;

                default:
                System.out.println("Error in choice. Please try again.");
                break;
            }
            
        }
        
    }
    
}
