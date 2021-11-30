/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudas.praktikum_pbo_12.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author STRIX
 */
public class Peminjaman {

    private int idPeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalPinjam;
    private String tanggalKembali;

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman() {

    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman,"
                + "p.tanggalpinjam AS tanggalpinjam,"
                + "p.tanggalkembali AS tanggalkembali,"
                + "a.idanggota AS idanggota,"
                + "a.nama AS nama,"
                + "a.alamat AS alamat,"
                + "a.telepon AS telepon,"
                + "b.idbuku AS idbuku,"
                + "b.judul AS judul,"
                + "b.penerbit AS penerbit,"
                + "b.penulis AS penulis"
                + " FROM peminjaman p "
                + "JOIN buku b ON p.idbuku = b.idbuku "
                + "JOIN anggota a ON p.idanggota = a.idanggota "
                + "WHERE p.idpeminjaman = '" + id + "'");
        try {
            while (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdBuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman,"
                + "p.tanggalpinjam AS tanggalpinjam,"
                + "p.tanggalkembali AS tanggalkembali,"
                + "a.idanggota AS idanggota,"
                + "a.nama AS nama,"
                + "a.alamat AS alamat,"
                + "a.telepon AS telepon,"
                + "b.idbuku AS idbuku,"
                + "b.judul AS judul,"
                + "b.penerbit AS penerbit,"
                + "b.penulis AS penulis"
                + " FROM peminjaman p "
                + "JOIN buku b ON p.idbuku = b.idbuku "
                + "JOIN anggota a ON p.idanggota = a.idanggota "
                + "ORDER BY p.idpeminjaman ASC");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdBuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));

                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPeminjaman;
    }

    public void save() {
        if (getById(idPeminjaman).getIdPeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idanggota,idbuku,tanggalpinjam,tanggalkembali) VALUES("
                    + "'" + this.getAnggota().getIdAnggota() + "',"
                    + "'" + this.getBuku().getIdBuku() + "',"
                    + "'" + this.getTanggalPinjam() + "',"
                    + "'" + this.getTanggalKembali() + "'"
                    + ")";
            this.idPeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + "idanggota = '" + this.getAnggota().getIdAnggota() + "',"
                    + "idbuku = '" + this.getBuku().getIdBuku() + "',"
                    + "tanggalpinjam = '" + this.getTanggalPinjam() + "',"
                    + "tanggalkembali = '" + this.getTanggalKembali() + "'"
                    + "WHERE idpeminjaman = '" + this.getIdPeminjaman() + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.getIdPeminjaman() + "'";
        DBHelper.executeQuery(SQL);
    }

}
