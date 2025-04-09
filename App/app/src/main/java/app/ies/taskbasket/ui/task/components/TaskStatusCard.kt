package app.ies.taskbasket.ui.task.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskStatusCard(
    icon: ImageVector,
    text: String,
    numberOfTasks: Int,
    modifier: Modifier = Modifier
){
    Card(
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.padding(vertical = 5.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = text, style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "$numberOfTasks ", style = MaterialTheme.typography.titleLarge)
                Text(text = "Tasks", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskStatusCardPreview(){
    TaskStatusCard(
        icon = Icons.Default.DateRange,
        text = "In Progress",
        numberOfTasks = 10,
    )
}