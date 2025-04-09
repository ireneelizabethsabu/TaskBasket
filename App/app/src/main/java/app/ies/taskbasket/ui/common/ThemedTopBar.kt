package app.ies.taskbasket.ui.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemedTopBar(
    title: @Composable () -> Unit = {},
    actions:  @Composable() (RowScope.() -> Unit) = {},
    isBackButtonPresent: Boolean = false,
    onBackButtonClicked: () -> Unit = {}
){
    TopAppBar(
        title = title,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon =  {
            if(isBackButtonPresent)
                ThemedIconButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft, onClick = onBackButtonClicked)
        }
    )
}