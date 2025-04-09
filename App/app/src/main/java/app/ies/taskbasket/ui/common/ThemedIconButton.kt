package app.ies.taskbasket.ui.common


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThemedIconButton(
    icon: ImageVector,
    onClick: () -> Unit
){
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.padding(horizontal = 5.dp),
        onClick = onClick
    ) {
        Icon(imageVector = icon, contentDescription = "Add Task")
    }
}

@Preview(showBackground = true)
@Composable
fun ThemedIconButtonPreview(){
    ThemedIconButton(icon = Icons.Filled.Add){}
}