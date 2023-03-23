package id.ac.unpas.pencatatankeuangan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class PencatatanKeuangan(
    @PrimaryKey val id: String,
    val tanggal: String,
    val kategori: String,
    val jumlah: String,
    val keterangan: String
)
