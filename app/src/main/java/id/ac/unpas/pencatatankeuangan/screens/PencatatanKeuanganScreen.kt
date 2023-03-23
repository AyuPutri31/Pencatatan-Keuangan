package id.ac.unpas.pencatatankeuangan.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.pencatatankeuangan.model.PencatatanKeuangan
import id.ac.unpas.pencatatankeuangan.persistences.AppDatabase

@Composable
fun PencatatanKeuanganScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "Pencatatan Keuangan"
    ).build()
    val pencatatanKeuanganDao = db.pencatatanKeuanganDao()
    val list : LiveData<List<PencatatanKeuangan>> = pencatatanKeuanganDao.loadAll()
    val items: List<PencatatanKeuangan> by list.observeAsState(initial = listOf())
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanKeuangan(pencatatanKeuanganDao)
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Kategori", fontSize = 14.sp)
                        Text(text = item.kategori, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Jumlah", fontSize = 14.sp)
                        Text(text = "${item.jumlah}", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Keterangan", fontSize = 14.sp)
                        Text(text = "${item.keterangan} ", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}