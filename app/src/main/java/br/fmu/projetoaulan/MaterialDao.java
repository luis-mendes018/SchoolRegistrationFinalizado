package br.fmu.projetoaulan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MaterialDao {

    @Query("SELECT * FROM Material")
    List<Material> getMaterial();

    @Query("SELECT * FROM Material where id=:idMaterial")
    Material buscarPorId(int idMaterial);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Material material);
    @Delete
    void delete(Material material);
    @Update
    void update(Material material);

}
