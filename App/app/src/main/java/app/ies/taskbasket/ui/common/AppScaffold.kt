package app.ies.taskbasket.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.ies.taskbasket.ui.theme.backgroundLight

@Composable
fun AppScaffold(topBar: @Composable () -> Unit, content: @Composable () -> Unit){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = topBar
    ) {
        paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(paddingValues).padding(20.dp),
            ){
                content()
            }
    }
}