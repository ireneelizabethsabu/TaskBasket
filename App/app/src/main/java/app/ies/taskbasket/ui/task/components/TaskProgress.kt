package app.ies.taskbasket.ui.task.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.ies.taskbasket.ui.theme.backgroundLight
import app.ies.taskbasket.ui.theme.purple

@Composable
fun TaskProgress(
    value: Int
){
    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = { value.toFloat()/100 },
            color = purple,
            trackColor = backgroundLight,
            gapSize = 0.dp,
            modifier = Modifier.size(64.dp)
        )
        Text(text = "$value %")
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskProgressPreview(){
    TaskProgress(50)
}