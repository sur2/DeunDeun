<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout primary white--text>
        <v-container fluid>
            <v-card class="elevation-12" id="login__card">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>Login</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    label="Email"
                    name="email"
                    type="text"
                    v-model="email"
                  ></v-text-field>

                  <v-text-field
                    id="password"
                    label="Password"
                    name="password"
                    type="password"
                    v-model="password"
                  ></v-text-field>

                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="info" :to="{name: 'FindIdPwd'}">Find ID/PWD</v-btn>
                <v-btn color="primary" :to="{name:'SignUp'}">SignUp</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="primary"
                @click="login({
                  email:email,
                  password:password
                })">Login</v-btn>
              </v-card-actions>
            </v-card>
        </v-container>

    </v-layout>
  </section>
</template>

<script>

import { mapState, mapActions } from "vuex";
import axios from  'axios'
import Vue from 'vue'
Vue.prototype.$http=axios

export default {
  name: 'Login',
  props: {
    msg: String
  },
  data:function(){
    return{
      email:'',
      password:'',
    }
  },
  methods:{
    ...mapActions(["login"])
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


<style>

  @media screen and (min-width: 1520px) {
    #login__card{
      margin-top: 150px;
      margin-bottom: 150px;
      margin-left: 440px;
       width: 600px;
    }
  }

   @media screen and (max-width: 600px) {
     #login__card{
       margin-top: 200px;
       margin-bottom: 200px;
     }
   }

</style>
