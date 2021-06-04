package com.example.databaselokal.entity;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room. Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface DataDesaDAO {
    @Insert
    Long insertData(DataDesa dataDesa);

    @Query("Select * from desa_db")
    List<DataDesa> getData();

    @Update
    int updateData(DataDesa item);

    @Delete
    void deleteData(DataDesa item);
}