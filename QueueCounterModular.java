import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueCounterModular 
{

    static Queue<String> queue = new LinkedList<>();
    static LinkedList<String> linkedList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int choice;

        do {
            tampilkanMenu();
            choice = validationInput();

            switch (choice) 
            {
                case 1 -> tambahItem();
                case 2 -> hitungJumlahItem();
                case 3 -> showAntrian();
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid. Masukkan angka 0-3.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // Fungsi menampilkan menu
    public static void tampilkanMenu() 
    {
        System.out.println("\n=== Antrian Counter KELOMPOK 1 BINUS ===");
        System.out.println("\n~~~~~~~~~~~ Menu ~~~~~~~~~~~~");
        System.out.println("1. Tambah item ke antrian (Queue vs LinkedList)");
        System.out.println("2. Hitung jumlah item");
        System.out.println("3. Lihat antrian");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");
    }

    // Fungsi input angka dengan validasi
    public static int validationInput() 
    {
        try {
            int input = scanner.nextInt();
            scanner.nextLine(); // consume newline
            return input;
        } 
        catch (Exception e) 
        {
            System.out.println("Error: Masukkan hanya angka!");
            scanner.nextLine(); // clear invalid input
            return -1;
        }
    }

    // Fungsi menambah item ke queue dan linked list + hitung waktu untuk mengcompare
    public static void tambahItem() 
    {
        System.out.print("Masukkan item: ");
        String item = scanner.nextLine();

        long startQueue = System.nanoTime();
        queue.add(item); // Queue
        long endQueue = System.nanoTime();

        long startList = System.nanoTime();
        linkedList.addLast(item); // LinkedList
        long endList = System.nanoTime();

        System.out.println("Item :" + item + " berhasil ditambahkan ke kedua struktur data.");
        System.out.println("Waktu eksekusi Queue      : " + (endQueue - startQueue) + " ns");
        System.out.println("Waktu eksekusi LinkedList: " + (endList - startList) + " ns");
    }

    // Fungsi menghitung jumlah item
    public static void hitungJumlahItem() 
    {
        long startQueue = System.nanoTime();
        System.out.println("Jumlah item dalam antrian (Queue)     : " + queue.size());
        long endQueue = System.nanoTime();

        long startList = System.nanoTime();
        System.out.println("Jumlah item dalam antrian (LinkedList): " + linkedList.size());
        long endList = System.nanoTime();

        System.out.println("Waktu eksekusi Queue      : " + (endQueue - startQueue) + " ns");
        System.out.println("Waktu eksekusi LinkedList: " + (endList - startList) + " ns");
    }

    // Fungsi menampilkan isi dari queue dan linked list
    public static void showAntrian() 
    {
        long startQueue = System.nanoTime();

        System.out.println("Isi Antrian (Queue):");
        if (queue.isEmpty()) 
        {
            System.out.println("Queue kosong.");
        } 
        else 
        {
            int i = 1;
            for (String item : queue) 
            {
                System.out.println(i++ + ". " + item);
            }
        }
        long endQueue = System.nanoTime();

        long startList = System.nanoTime();
        System.out.println("\nIsi Antrian (LinkedList):");
        if (linkedList.isEmpty()) 
        {
            System.out.println("LinkedList kosong.");
        } 
        else 
        {
            int i = 1;
            for (String item : linkedList) 
            {
                System.out.println(i++ + ". " + item);
            }
        }
        long endList = System.nanoTime();

        System.out.println("Waktu eksekusi Queue      : " + (endQueue - startQueue) + " ns");
        System.out.println("Waktu eksekusi LinkedList: " + (endList - startList) + " ns");
    }
}
