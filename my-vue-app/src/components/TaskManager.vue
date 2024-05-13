<template>
  <div>
    <h1>Task Manager</h1>
    <ul>
      <li v-for="task in tasks" :key="task.id">
        <h3>{{ task.title }}</h3>
        <p>{{ task.description }}</p>
        <p>Status: <strong>{{ task.done ? 'Completed' : 'Pending' }}</strong></p>
        <p>Due Date: {{ task.dueDate.toLocaleDateString() }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'TaskManager',
  data() {
    return {
      tasks: [
        { id: 1, title: 'Task 1', description: 'Description of Task 1', done: false, dueDate: new Date(2024, 4, 15) },
        { id: 2, title: 'Task 2', description: 'Description of Task 2', done: true, dueDate: new Date(2024, 4, 18) }
      ]
    };
  }
}
</script>

<style scoped>
h1 {
  color: #2c3e50;
}
</style>
