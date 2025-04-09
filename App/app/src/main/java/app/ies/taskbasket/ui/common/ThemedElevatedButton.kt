package app.ies.taskbasket.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThemedElevatedButton(
    text: String,
    onClick: () -> Unit
){
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,       // Background
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,               // Text/Icon color
        ),
        modifier = Modifier.fillMaxWidth().height(60.dp)
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ThemedElevatedButtonPreview(){
    ThemedElevatedButton(text = "Button text") {
        
    }
}