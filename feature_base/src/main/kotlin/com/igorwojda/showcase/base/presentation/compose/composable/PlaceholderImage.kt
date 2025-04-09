package com.igorwojda.showcase.base.presentation.compose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.igorwojda.showcase.base.R

private val PLACEHOLDER_IMAGES = listOf(
    R.drawable.image_placeholder_1,
    R.drawable.image_placeholder_2,
    R.drawable.image_placeholder_3,
)

@Composable
fun PlaceholderImage(
    url: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier) {
        val randomPlaceHolder by rememberSaveable {
            mutableStateOf(PLACEHOLDER_IMAGES.random())
        }

        val model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build()

        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            placeholder = painterResource(randomPlaceHolder),
        )
    }
}

@Composable
fun SimilarCard(
    modifier: Modifier = Modifier,
    name: String = "",
)  {
    Surface(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.image_placeholder_2), contentDescription = name)
        Spacer(modifier = modifier)
        Text(text = name,
            textAlign = TextAlign.Center)
    }
}
