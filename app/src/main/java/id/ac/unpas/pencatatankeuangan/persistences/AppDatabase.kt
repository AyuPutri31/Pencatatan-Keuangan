package id.ac.unpas.pencatatankeuangan.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.pencatatankeuangan.model.PencatatanKeuangan

@Database(entities = [PencatatanKeuangan::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pencatatanKeuanganDao(): PencatatanKeuanganDao
}