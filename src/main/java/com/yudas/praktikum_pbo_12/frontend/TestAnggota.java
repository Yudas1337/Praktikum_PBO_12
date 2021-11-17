/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudas.praktikum_pbo_12.frontend;

import com.yudas.praktikum_pbo_12.backend.Anggota;

/**
 *
 * @author STRIX
 */
public class TestAnggota {

    public static void main(String[] args) {
        Anggota kat1 = new Anggota("Yudas Malabi", "Kepanjen", "082257181297");
        Anggota kat2 = new Anggota("Arya Admaja", "Malang", "082257181296");
        Anggota kat3 = new Anggota("Ana Qonitah", "Malang", "082257181295");
        Anggota kat4 = new Anggota("Annisa Aulia", "Malang", "082257181294");

        // test insert
        kat1.save();
        kat2.save();
        kat3.save();
        kat4.save();

        // test update
        kat3.setAlamat("Politeknik Negeri Malang");
        kat3.save();

        // test delete
        kat4.delete();

        // test select all
        for (Anggota k : new Anggota().getAll()) {
            System.out.println("Nama: " + k.getNama() + ", Alamat: " + k.getAlamat() + ", Telepon: " + k.getTelepon());
        }

        // test search
        for (Anggota k : new Anggota().search("ilmiah")) {
            System.out.println("Nama: " + k.getNama() + ", Alamat: " + k.getAlamat() + ", Telepon: " + k.getTelepon());
        }
    }
}
