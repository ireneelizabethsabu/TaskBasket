package app.ies.taskbasket.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.ies.taskbasket.utils.model.Priority

@Composable
fun ThemedFilterChip(
    isSelected: Boolean,
    item: Priority,
    onClick: (Priority) -> Unit
){
    FilterChip(
        selected = isSelected,
        onClick = { onClick(item) },
        label = {
            Text(text = item.name, modifier = Modifier.padding(10.dp))
        },
        shape = CircleShape,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.primary,
            labelColor = MaterialTheme.colorScheme.onPrimary,
        ),
        border = FilterChipDefaults.filterChipBorder(enabled = true, selected = isSelected, borderColor = Color.Transparent)
    )
}