import mpi.*;
import java.util.*;

public class PracSum {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 4;
        int root = 0;
        int send_buffer[] =  null;

        send_buffer = new int[unitsize*size];
        int recieve_buffer[] = new int[unitsize];
        int new_recieve_buffer[] = new int[size];

        if(rank == root){
            int total_size = unitsize*size;
            System.out.println("Elements" + total_size);

            for(int i=0; i<total_size; i++){
                send_buffer[i] = i;
            }
            
        }

        MPI.COMM_WORLD.Scatter(send_buffer, 0, unitsize, MPI.INT, recieve_buffer, 0, unitsize, MPI.INT, root);

        for(int i=1; i<unitsize; i++){
            recieve_buffer[0] += recieve_buffer[i];
        }
        System.out.println("Intermediate sum is: "+ recieve_buffer[0]);

        MPI.COMM_WORLD.Gather(recieve_buffer, 0, 1, MPI.INT, new_recieve_buffer, 0, 1, MPI.INT, root);

        if(rank == root){
            int total_sum = 0;
            for(int i =0; i<size; i++){

                total_sum += new_recieve_buffer[i];
            }
            System.out.println("Total sum is: "+ total_sum);
        }

        MPI.Finalize();
    }

    
}
