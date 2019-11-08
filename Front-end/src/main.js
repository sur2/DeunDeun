import Vue from 'vue'
import vuetify from '@/plugins/vuetify'
import './plugins/base'
import App from './App.vue'
import store from './store'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.min.css'
import router from './router'

export const EventBus = new Vue()

Vue.config.productionTip = false

new Vue({
    vuetify,
    store,
    router,
    render: h => h(App),
    beforeCreate() {
        this.$store.dispatch("getUserInfo")
    },
}).$mount('#app')