/*Nama: Muhammad Faisal Muzhaffar
  NIM : 20230040125 
  Kelas:TI23C
*/

import java.util.Stack;
import java.util.Scanner;

public class TugasStack {
    static int HitungBukuTeknik = 0;
    static int HitungBukuManajemen = 0;
    static int HitungBukuFiksi = 0;
    static int HitungBukuLainnya = 0;
    static Stack<String> dataBuku = new Stack<>();
    static Stack<String> dataBukupengarang = new Stack<>();
    static Stack<String> dataBukupenerbit = new Stack<>();
    static Stack<Integer> dataBukukategori = new Stack<>();
    static Stack<Integer> dataBukutahun = new Stack<>();

    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        int menu;

        do {
            showMenu();
            System.out.print("Masukkan menu: ");
            menu = inputan.nextInt();

            if (menu == 1) {
                tambahDataBuku();
            } else if (menu == 2) {
                tampilkanDataBuku();
            }

        } while (menu != 3);

        inputan.close();
    }

    public static void tambahDataBuku() {
        try (Scanner inputan = new Scanner(System.in)) {
            System.out.print("Masukkan judul: ");
            String Judul = inputan.next();

            System.out.print("Masukkan pengarang: ");
            String pengarang = inputan.next();

            System.out.print("Masukkan penerbit: ");
            String penerbit = inputan.next();

            Kategori();
            System.out.print("Masukkan kategori: ");
            int kategori = inputan.nextInt();
            HitungKategori(kategori);

            System.out.print("Masukkan tahun: ");
            int tahun = inputan.nextInt();

            dataBuku.push(Judul);
            dataBukupengarang.push(pengarang);
            dataBukupenerbit.push(penerbit);
            dataBukukategori.push(kategori);
            dataBukutahun.push(tahun);

            if (tahun <= 2000) {
                System.out.println("Buku lawas.");
            } else {
                System.out.println("Buku baru.");
            }
        }

        System.out.println("Data buku berhasil ditambahkan!");
    }

    public static void tampilkanDataBuku() {
        int No = 0;
        int BukuKe = 0;

        System.out.println("========================================================================================================");
        System.out.println("No\t\tJudul\t\tPengarang\t\tPenerbit\t\tTahun\t\tKategori");
        System.out.println("========================================================================================================");

        for (int indeks : dataBukukategori) {
            String index = KategoriBuku(indeks);
            System.out.println(++No + "\t\t" + dataBuku.get(BukuKe) + "\t\t" + dataBukupengarang.get(BukuKe) +
                    "\t\t\t" + dataBukupenerbit.get(BukuKe) + "\t\t\t" + dataBukutahun.get(BukuKe) + "\t\t" + index);
            BukuKe++;
        }

        System.out.println("========================================================================================================");
        System.out.println("Jumlah buku: " + No);
        System.out.println("Buku Teknik: " + HitungBukuTeknik);
        System.out.println("Buku Manajemen: " + HitungBukuManajemen);
        System.out.println("Buku Fiksi: " + HitungBukuFiksi);
        System.out.println("Buku Lainnya: " + HitungBukuLainnya);
        System.out.println("========================================================================================================");
    }

    public static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Tampilkan Data Buku");
        System.out.println("3. Exit");
    }

    public static void Kategori() {
        System.out.println("=== Pilih Kategori ===");
        System.out.println("1. Teknik");
        System.out.println("2. Manajemen");
        System.out.println("3. Fiksi");
        System.out.println("4. Lainnya");
    }

    public static String KategoriBuku(int Kategori) {
        String index;
        if (Kategori == 1) {
            index = "Teknik";
        } else if (Kategori == 2) {
            index = "Manajemen";
        } else if (Kategori == 3) {
            index = "Fiksi";
        } else {
            index = "Lainnya";
        }
        return index;
    }

    public static void HitungKategori(int kategori) {
        switch (kategori) {
            case 1:
                HitungBukuTeknik++;
                break;
            case 2:
                HitungBukuManajemen++;
                break;
            case 3:
                HitungBukuFiksi++;
                break;
            default:
                HitungBukuLainnya++;
                break;
        }
    }
}
