<template>
  <div class="task-manager">
    <h1 class="title">Task Manager</h1>
    <div class="task-card" v-for="task in tasks" :key="task.id">
      <h3 class="task-title">{{ task.title }}</h3>
      <p class="task-description">{{ task.description }}</p>
      <p class="task-status">Status: <strong>{{ task.done ? 'Completed' : 'Pending' }}</strong></p>
      <p class="task-due-date">Due Date: {{ task.dueDate.toLocaleDateString() }}</p>
      <button class="task-button" @click="toggleTaskStatus(task)">Mark as {{ task.done ? 'Pending' : 'Completed' }}</button>
    </div>
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
  },
  methods: {
    toggleTaskStatus(task) {
      task.done = !task.done;
    }
  }
}
</script>

<style scoped>
.task-manager {
  width: 80%;
  margin: auto;
}

.title {
  text-align: center;
  color: #2c3e50;
}

.task-card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  margin-bottom: 20px;
}

.task-title {
  font-size: 1.5em;
  margin-bottom: 10px;
}

.task-button {
  background-color: #2c3e50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>