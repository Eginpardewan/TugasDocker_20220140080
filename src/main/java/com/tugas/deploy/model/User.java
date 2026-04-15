package com.tugas.deploy.model;

public class User {
    private String nama;
    private String nim;
    private String kelas;
    private String prodi;
    private String jenisKelamin;

    // Constructor default
    public User() {}

    // Constructor dengan parameter (nama, nim)
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = "A";
        this.prodi = "Teknik Informatika";
        this.jenisKelamin = "Laki-laki";  // default
    }

    // Constructor dengan parameter (nama, nim, jenisKelamin)
    public User(String nama, String nim, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = "A";
        this.prodi = "Teknik Informatika";
        this.jenisKelamin = jenisKelamin;
    }

    // Constructor dengan parameter lengkap
    public User(String nama, String nim, String kelas, String prodi, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.prodi = prodi;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter dan Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getJenisKelamin() { return jenisKelamin; }  // ← TAMBAHKAN
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }  // ← TAMBAHKAN
}