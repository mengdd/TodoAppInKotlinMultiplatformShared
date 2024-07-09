import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class TodoListUiState(val items: List<TodoItem>)
class TodoListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TodoListUiState(items = emptyList()))
    val uiState: StateFlow<TodoListUiState> = _uiState.asStateFlow()

    fun addItem(title: String) {

        _uiState.update { currentState ->
            val newItem = TodoItem(title)
            val newList = currentState.items.toMutableList().apply {
                add(newItem)
            }
            currentState.copy(items = newList)
        }
    }
}
