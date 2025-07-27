import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueCounter 
{
    public static void main(String[] args) 
    {
        Queue<String> antrian = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Antrian Counter KELOMPOK 1 BINUS ===");
            System.out.println("\n~~~~~~~~~~~Menu: ~~~~~~~~~~~~");
            System.out.println("1. Tambah item ke antrian");
            System.out.println("2. Hitung jumlah item");
            System.out.println("3. Lihat antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            
            // Validasi input - hanya menerima angka
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Error: Masukkan hanya angka!");
                scanner.nextLine(); // Clear invalid input
                choice = -1; // Set invalid choice to trigger default case
            }

            switch (choice) 
            {
                case 1:
                    System.out.print("Masukkan item: ");
                    String item = scanner.nextLine();
                    antrian.add(item);
                    break;
                case 2:
                    System.out.println("Jumlah item dalam antrian: " + antrian.size());
                    break;
                case 3:
                    System.out.println("Isi antrian: ");
                    if ( antrian.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    }
                    else 
                    {
                        int index = 1;
                        for (String antrianItem : antrian) 
                        {
                            System.out.println(index + ". " + antrianItem);
                            index++;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Keluar.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 0-3.");
            }
        } while (choice != 0);
    }
}
