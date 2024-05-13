<template>
  <div>
    <ul>
      <li v-for="task in tasks" :key="task.id">
        {{ task.title }} - {{ task.dueDate }} <span v-if="task.done">Completed</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tasks: []
    };
  },
  mounted() {
    this.fetchTasks();
  },
  methods: {
    fetchTasks() {
      // Assuming you have an endpoint to fetch tasks
      fetch('http://localhost:8080/api/tasks')
          .then(response => response.json())
          .then(data => {
            this.tasks = data;
          })
          .catch(error => console.error('Error fetching tasks:', error));
    }
  }
}
</script>

<style>
/* Add any specific styles for your task list here */
</style>
