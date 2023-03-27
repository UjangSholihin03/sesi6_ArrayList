import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {

            // Mengimput terlebih dahulu(dibuat kategori untuk memisahkan jenis buku)
            System.out.print("Masukkan jumlah buku: ");
            int jumlahBuku = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("Buku ke-" + (i + 1));
                System.out.print("Judul: ");
                String judul = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Penerbit: ");
                String penerbit = scanner.nextLine();
                System.out.print("Kategori (1-Teknik, 2-Manajemen, 3-Fiksi, 4-Lainnya): ");
                int kategori = scanner.nextInt();
                System.out.print("Tahun: ");
                int tahun = scanner.nextInt();
                scanner.nextLine(); 
                daftarBuku.add(new Buku(judul, author, penerbit, kategori, tahun));
            }
        }

        // Tabel 
        System.out.println("=====================================================================================================");
        System.out.println("Daftar Buku Java yang Tersedia");
        System.out.println("=====================================================================================================");
        System.out.println(
                "No  Judul                                Pengarang               Penerbit           Ketegori  Tahun");
        System.out.println("=====================================================================================================");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            System.out.printf("%-4d%-40s%-22s%-20s%-7d%-8d\n", i + 1, buku.getJudul(), buku.getauthor(),
                    buku.getPenerbit(), buku.getTahun(), buku.getKategori());
        }

        // Untuk Menampilkan Kategori Buku
        int[] jumlahPerKategori = new int[4];
        int jumlahBukuLawas = 0;
        int jumlahBukuBaru = 0;
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            int kategori = buku.getKategori();
            if (kategori > 0 && kategori < jumlahPerKategori.length) {
                jumlahPerKategori[kategori = 1]++;
        }
        if (buku.getTahun() < 2010) {
            jumlahBukuLawas++;
        } else {
            jumlahBukuBaru++;
        }
    }
        System.out.println("=====================================================================================================");
        System.out.println("Jumlah buku yang tersedia: " + daftarBuku.size());
        System.out.println("Buku Teknik: " + jumlahPerKategori[0]);
        System.out.println("Buku Manajemen: " + jumlahPerKategori[1]);
        System.out.println("Buku Fiksi: " + jumlahPerKategori[2]);
        System.out.println("Buku Lainnya: " + jumlahPerKategori[3]);

    }
}

class Buku {
    public String judul;
    public String author;
    public String penerbit;
    public int tahun;
    public int kategori;

    public Buku(String judul, String author, String penerbit, int tahun, int kategori) {
        this.judul = judul;
        this.author = author;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String getauthor() {
        return author;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getTahun() {
        return tahun;
    }
    
    public int getKategori() {
    return kategori;
    }

    
}