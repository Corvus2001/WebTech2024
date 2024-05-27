// src/services/api.js
import axios from 'axios';

const API_URL = 'http://localhost:8080';

export function getTasks() {
    return axios.get(`${API_URL}/tasks`);
}