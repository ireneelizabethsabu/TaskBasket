package app.ies.taskbasket.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThemedTextField(
    value: String,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit,

){
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(50/maxLines),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.onPrimary,
                backgroundColor = MaterialTheme.colorScheme.background,
            )
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .height(30.dp * maxLines)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ThemedTextFieldPreview(){
    ThemedTextField(
        maxLines = 4,
        value = "This is a really long long long chunk of text being written on this line to see") {
        
    }
}