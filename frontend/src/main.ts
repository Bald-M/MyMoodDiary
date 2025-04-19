// import './assets/main.css'
import './assets/init.css'
// Third-party imports
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// Font Awesome configuration
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'

// Axios HTTP client setup
import axios from 'axios'

// Application core files
import App from './App.vue'
import router from './router'

// Initialize Font Awesome library
library.add(fas, fab)

// Create Vue application instance
const app = createApp(App)

// Configure Axios base URL from environment variables
axios.defaults.baseURL = import.meta.env.VITE_APP_API_URL

// Register global components and plugins
app.component('font-awesome-icon', FontAwesomeIcon)
app.use(createPinia())
app.use(ElementPlus)
app.use(router)

// Inject axios instance for composition API
app.provide('$axios', axios)

// Mount the application to DOM
app.mount('#app')