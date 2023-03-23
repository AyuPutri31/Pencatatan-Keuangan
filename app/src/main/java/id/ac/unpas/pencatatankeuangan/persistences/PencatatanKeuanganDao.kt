package id.ac.unpas.pencatatankeuangan.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.pencatatankeuangan.model.PencatatanKeuangan

@Dao
interface PencatatanKeuanganDao {
    @Query("SELECT * FROM PencatatanKeuangan")
    fun loadAll(): LiveData<List<PencatatanKeuangan>>
    @Query("SELECT * FROM PencatatanKeuangan WHERE id = :id")
    fun find(id: String): PencatatanKeuangan?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: PencatatanKeuangan)
    @Delete
    fun delete(item: PencatatanKeuangan)
}