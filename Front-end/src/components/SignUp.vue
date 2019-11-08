<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout info white--text>
        <v-container fluid>
            <v-card class="elevation-12" id="login__card">
              <v-toolbar color="info" dark flat>
                <v-toolbar-title>Sign up</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form
                    ref="form"
                    v-model="valid"
                    lazy-validation
                  >
                    <v-text-field
                      v-model="members.email"
                      :rules="emailRules"
                      label="E-mail"
                      required
                    ></v-text-field>

                    <v-text-field
                      v-model="members.password"
                      :rules="passwordRules"
                      :type="show1 ? 'text' : 'password'"
                      label="Password"
                      hint="At least 8 characters"
                      :counter="20"
                    ></v-text-field>

                    <v-text-field
                      :rules="passwordRules"
                      :type="show1 ? 'text' : 'password'"
                      label="Repeat Password"
                      hint="At least 8 characters"
                      :counter="20"
                    ></v-text-field>


                    <v-text-field
                      v-model="members.name"
                      :counter="10"
                      :rules="nameRules"
                      label="Name"
                      required
                    ></v-text-field>

                    <v-text-field
                      v-model="members.nickname"
                      :rules="nicknameRules"
                      label="NickName"
                      required
                    ></v-text-field>

                    <v-text-field
                      v-model="members.tel"
                      :rules="nameRules"
                      hint="010-1234-5678"
                      label="Tel"
                      required
                    ></v-text-field>

                  </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="info" :to="{name: 'FindIdPwd'}">Find ID/PWD</v-btn>
                <v-btn color="primary" :to="{name:'Login'}">Back</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="primary" @click="register">SignUp</v-btn>
              </v-card-actions>
            </v-card>
        </v-container>
    </v-layout>
  </section>
</template>



<script>
import axios from "axios";
export default {
 name: "signUp",
 data: function() {
   return {
     members: {},
     passwordConfirm: "",
     valid: true,
      name: '',
      nameRules: [
        v => !!v || 'Tel is required',
      ],
      nicknameRules: [
        v => !!v || 'NickName is required',
      ],
      email: '',
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      checkbox: false,
      show1: false,
      passwordRules:[
        v => !!v || 'Password is required',
        v => (v && v.length >= 8) || 'At least 8 characters'
      ]
   };
 },
 methods: {
   register: function() {
     var body = {
       name: this.members.name,
       nickname: this.members.nickname,
       email: this.members.email,
       password: this.members.password,
       tel: this.members.tel,
       grade: "user",
       create_at: new Date()
     };
     axios({
       headers: { "Content-Type": "application/json" },
       url: "http://13.124.143.135:8888/members/register",
       method: "post",
       data: JSON.stringify(body)
     }).then(res => {
       console.log("member", res);
     });
     console.log("mem", body);
   }

 }
};
</script>
