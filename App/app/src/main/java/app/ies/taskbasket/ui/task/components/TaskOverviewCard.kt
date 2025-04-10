package app.ies.taskbasket.ui.task.components

import android.view.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.ui.common.ThemedFilterChip
import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

@Composable
fun TaskOverviewCard(
    task: Task,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(25),
        modifier = modifier.padding(vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)

            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    ThemedFilterChip(isSelected = true, item = task.priority) {}
                }


            }

            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                TaskProgress(value = 40)
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskOverviewPreview(){
    TaskOverviewCard(
        Task(
            1,
            "Task name",
            "This is a very long task description",
            LocalDateTime.now(),
            Priority.High,
            true,
            false,
        )
    )
}