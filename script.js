function addTask() {
    let taskInput = document.getElementById('new-task');
    let taskValue = taskInput.value.trim();
    
    if (taskValue === "") return;

    let li = document.createElement('li');
    li.textContent = taskValue;

    let deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.onclick = function() {
        li.remove();
    };

    li.appendChild(deleteButton);
    li.onclick = function() {
        li.classList.toggle('completed');
    };

    document.getElementById('task-list').appendChild(li);
    taskInput.value = ""; // clear the input field
}
