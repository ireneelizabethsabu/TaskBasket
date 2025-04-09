package app.ies.taskbasket.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleAvatarWithBackground(imageUrl: String) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp), // Background color
        contentAlignment = Alignment.Center
    ) {

    }
}

@Preview
@Composable
fun CircleAvatarWithBackgroundPreview(){
    CircleAvatarWithBackground(imageUrl = "")
}