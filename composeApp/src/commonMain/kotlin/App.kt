import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            Modifier.fillMaxWidth().padding(8.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            val todoList = remember { mutableStateListOf<TodoItem>() }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var text by remember { mutableStateOf("") }

                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier.weight(1.0f),
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Todo") }
                )
                Button(modifier = Modifier.padding(8.dp),
                    onClick = {
                        if (text.isNotBlank()) {
                            todoList.add(TodoItem(text))
                        }
                        text = ""
                    }) {
                    Text("Add")
                }
            }

            LazyColumn(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                items(todoList) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = it.title,
                        style = MaterialTheme.typography.h4
                    )
                }
            }
        }
    }
}
