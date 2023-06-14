package com.example.ex4.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.ex4.schemas.Chat;

import java.util.List;

@Dao
public interface ChatDao {
    @Query("SELECT * FROM chat")
    List<Chat> index();

    @Query("SELECT * FROM chat WHERE id = :id")
    Chat get(int id);

    @Insert
    void insert(Chat... Chats);

    @Update
    void update(Chat... Chats);

    @Delete
    void delete(Chat... Chats);

}