<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout accent white--text class="mt-12">
        <v-container fluid class="mt-12 mb-12">
          <center><h1>*{{name}}님 반갑습니다*</h1></center>

          <center>
            <div class="mt-12">
              <v-card class="mx-auto" max-width="400" outlined>
                <v-list-item three-line class="mt-8">
                  <v-list-item-content>
                    <!-- <div class="overline mb-4">오명현님 반갑습니다</div> -->
                    <v-text-field v-model="name" label="Name" v-bind:readonly="true" outlined></v-text-field>
                    <v-text-field v-model="email" label="Email" v-bind:readonly="true" outlined></v-text-field>
                    <v-text-field v-model="nickname" label="Nickname" outlined></v-text-field>
                    <v-text-field v-model="password" label="Password" type="password" outlined>></v-text-field>
                  </v-list-item-content>

                  <!-- <v-list-item-avatar tile size="80" color="grey"></v-list-item-avatar> -->
                </v-list-item>

                <!-- <v-card-actions> -->
                  <div class="text-center mb-6">
                    <v-btn rounded color="info" v-on:click="update">수정하기</v-btn>
                    &nbsp;
                    <v-btn rounded color="primary" v-on:click="end">탈퇴하기</v-btn>
                  </div>
                <!-- </v-card-actions> -->
              </v-card>
            </div>
          </center>

        </v-container>
    </v-layout>
  </section>
</template>

<script>
  import router from '../router.js'
  import axios from  'axios'
  import Vue from 'vue'
  Vue.prototype.$http=axios
  import { mapState , mapActions } from "vuex";
  export default {
    data: () => ({
      name: '',
      nickname:'',
      email: '',
      password: '',
    }),
    methods: {
      ...mapActions(["logout"]),
      end: function(event) {
        var pwdInput=prompt('탈퇴하려면 비밀번호를 입력하세요')
        this.password=pwdInput
        var checkResult=""
        var body={
          email:this.getEmail,
          password:pwdInput
        }
        this.$http.post("http://13.124.143.135:8888/members/check",body)
        .then(res=>{
          console.log(res.data)
          checkResult=res.data
          console.log("checkResult",checkResult)
          if(checkResult==="Success") {
            this.delete()
            alert("탈퇴되었습니다.")
            router.push({name:'Home'})
          } else {
            alert("비밀번호가 틀렸습니다")
          }
        })
        .catch(err=>{
          console.log(err)
        })
      },
      update(){
        console.log("update")
        var body={
          email:this.email,
          nickname:this.nickname,
          password:this.password
        }
        this.$http.put("http://13.124.143.135:8888/members/update",body)
        .then(res=>{
          console.log(res.data)
          alert("수정되었습니다")
          router.push({name:'Home'})
        })
        .catch(err=>{
          console.log(err)
        })
      },
      delete(){
        axios({
          url:"http://13.124.143.135:8888/members/delete",
          method:"delete",
          params:{
            member_id:this.getMemberId
          }
        })
        .then(res=>{
          console.log(res)
          this.logout()
        })
        .catch(err=>{
          console.log(err)
        })
      },
    },
    computed: {
      ...mapState({
        getMemberId:state=>state.User.member_id,
        getName:state=>state.User.name,
        getEmail : state => state.User.email,
        getNickname : state => state.User.nickname,
        getGrade: state=> state.User.grade,
        getIsLogin: state=> state.isLogin
      })
    },
    mounted(){
      this.name=this.getName
      this.nickname=this.getNickname
      this.email=this.getEmail
    }
  }
</script>

<style>

</style>
