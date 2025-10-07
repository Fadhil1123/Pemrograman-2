package praktikum2.soal3;

//Pada baris ini terjadi error karena nama class berbeda dengan yang digunakan di file Soal3Main.java
//public class Employee {
public class Pegawai{
    public String nama;
    //memakai data tipe char tidak cocok untuk asal
    //public char asal;
    public String asal;
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    //Pada baris ini terjadi error karena method tidak memiliki parameter dan variabel 'j' tidak dikenal
    //public void setJabatan() {
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}