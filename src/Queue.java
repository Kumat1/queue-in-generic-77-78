import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by WILLY on 03/04/2017.
 */
public class Queue<T> {
    public T[] element;
    public int pointer=0;

    Queue(Class<?> namaClass, int size){
        element = (T[]) Array.newInstance(namaClass, size);
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>(Integer.class,5);

        int pil = 0;

        do{
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Pilihan : ");
            Scanner input = new Scanner(System.in);
            pil = input.nextInt();

            if(pil==1 || pil==2 || pil==3 || pil==4) {
                if (pil == 1) {
                    System.out.print("Masukkan Nilai : ");
                    int data = input.nextInt();

                    queue.enqueue(data);
                } else if (pil == 2) {
                    queue.dequeue();
                } else if (pil == 3) {
                    queue.display();
                }
            }
            else {
                System.out.println("\nPilihan Tidak Tersedia");
            }
        }while(pil!=4);
    }

    public void enqueue(T item){
        try {
            element[pointer] = item;
            pointer++;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nQueue sudah penuh");
        }
    }

    public T dequeue(){
        try {
            if (pointer == 0) {
                System.out.println("\nQueue Kosong");
            } else {
                int x = 0;
                System.out.println("\nElement yang keluar = " + element[x]);
                for (x = 0; x < pointer; x++) {
                    element[x] = element[x + 1];
                }
                pointer--;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            pointer--;
        }
        return null;
    }

    public void display(){
        int y;

        if(pointer==0){
            System.out.println("\nQueue Kosong");
        }
        else {
            System.out.println("");
            for (y = 0; y < pointer; y++) {
                System.out.print(element[y] + " ");
            }
            System.out.println("");
        }
    }
}

