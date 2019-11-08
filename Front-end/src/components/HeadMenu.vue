<template>
  <div>
    <v-btn
      fab
      class="ma-2"
      small
      color="transparent"
      @click="$router.push({name: 'FAQ'})"
    >
     <v-icon>mdi-help-circle-outline</v-icon>
    </v-btn>

    <v-btn
      fab
      class="ma-2"
      small
      color="transparent"
      @click="$router.push({name: 'Notice'})"
    >
     <v-icon>mdi-alert-decagram</v-icon>
    </v-btn>
    
    <v-btn
      fab
      class="ma-2"
      small
      color="transparent"
      @click="$router.push({name: 'UserInfo'})"
      v-if="this.getIsLogin ===true"
    >
     <v-icon>mdi-account</v-icon>
    </v-btn>
  </div>
</template>

<script>

import { mapState } from "vuex";


export default {
  props: {
    large: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    ...mapState({
        getEmail : state => state.User.email,
        getNickname : state => state.User.nickname,
        getGrade: state=> state.User.grade,
        getIsLogin: state=> state.isLogin
    })
  },
}
</script>
