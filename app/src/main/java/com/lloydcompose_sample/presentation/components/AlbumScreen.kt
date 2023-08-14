package com.lloydcompose_sample.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lloydcompose_sample.presentation.album.AlbumViewModel

@Composable
fun AlbumScreen(
    viewModel: AlbumViewModel,
    onItemClick: (String) -> Unit
) {

    if (viewModel.albumList.isEmpty()) {
        Loader()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        items(items = viewModel.albumList) { item ->
            Items(
                title = item.title,
                thumbnail = item.thumbnailUrl,
                onItemClick = {
                    onItemClick(item.title)
                }
            )
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
private fun Loader() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Loading, please wait...", color = Color.Gray)
    }
}

@Composable
private fun Items(title: String, thumbnail: String, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick()
            },
        shape = Shapes().extraSmall,
        colors = CardDefaults.cardColors(),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = thumbnail,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Red,
                modifier = Modifier.weight(1f)
            )
        }
    }
}