package com.example.databaselokal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "desa_db")
public class DataDesa {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "jumlah")
    private int penduduk;

    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress() {

        return address;
    }
        public void setAddress (String address) {

            this.address = address;

        }

        public int getPenduduk() {
            return penduduk;

        }

        public void setPenduduk(int penduduk) {
            this.penduduk = penduduk;

        }
}
