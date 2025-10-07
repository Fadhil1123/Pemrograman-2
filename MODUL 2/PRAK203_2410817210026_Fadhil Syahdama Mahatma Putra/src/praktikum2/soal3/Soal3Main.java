package praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();
        //Pada baris ini terjadi error karena kurang titik koma (;)
        //p1.nama = "Roi"
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel";
        p1.setJabatan("Assasin");
        //Tidak ada kode ini menetapkan isi dari atribut umur
        p1.umur = 17;

        //Pada baris ini terjadi kesalahan penulisan awalnya "Nama Pegawai" seharusnya "Nama" saja
        //System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        System.out.println("Umur: " + p1.umur);
    }
}