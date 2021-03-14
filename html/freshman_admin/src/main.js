import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import './plugins/element.js'
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/global.css'
import axios from 'axios'
import 'default-passive-events'

axios.defaults.timeout = 8000;
axios.defaults.baseURL='http://192.168.2.246:8084'

// 添加请求拦截器，在请求头中加token
// http request 拦截器
axios.interceptors.request.use(
  config => {
    if (localStorage.token!==undefined) { //判断token是否存在
      config.headers.token = localStorage.token;  //将token设置成请求头
    }
    return config;
  },
  err => {
    return Promise.reject(err);
  }
);

// http response 拦截器
axios.interceptors.response.use(
  response => {
    if (response.data.code === '402') {
      router.replace('/').then(r => console.log(r));
      this.$alert(response.data.msg)
    }
    return response;
  },
  error => {
    return Promise.reject(error);
  }
);


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
