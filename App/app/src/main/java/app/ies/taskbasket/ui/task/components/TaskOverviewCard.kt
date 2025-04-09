package app.ies.taskbasket.ui.task.components

import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

@Composable
fun TaskOverviewCard(
    task: Task
){
    Surface {
        Column {
            Text(
                text = task.title,
                style = MaterialTheme.typography.titleLarge
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskOverviewPreview(){
    TaskOverviewCard(
        Task(1,"Task name", "This is a very long task description", LocalDateTime.now(), true,Priority.High,false)
    )
}