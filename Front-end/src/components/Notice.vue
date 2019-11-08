<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout primary white--text class="pt-10">
        <v-container fluid class="mt-8">
          <center><h1>Notice</h1></center><br>
          <v-btn color="black" dark v-if="getGrade==='admin'" :to="{name: 'NoticeAdd'}" id="btn__add">등록</v-btn>
             <v-expansion-panels focusable multiple>
                <v-expansion-panel
                  v-for="(item,i) in items"
                  :key="i"
                >
                  <v-expansion-panel-header>{{item.title}}</v-expansion-panel-header>
                  <v-expansion-panel-content>
                    <br>
                    {{item.contents}}
                  </v-expansion-panel-content>
                  <v-btn color="sky blue" dark v-on:click="del(item.notice_id)" id="btn__del">삭제</v-btn>
                </v-expansion-panel>
              </v-expansion-panels>
        </v-container>
    </v-layout>
  </section>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
Vue.prototype.$http=axios
import { mapState } from "vuex";

export default {
  data: () => ({
    user: 'admin',
    items: []
  }),
  methods: {
    del: function(num) {
      var no = num
      
      axios({
        headers : {"Content-Type" : "application/json"},
        url:"http://13.124.143.135:8888/notice/delete",
        params:{
          notice_id: no
        },
        method:"delete",
      })
      alert('삭제되었습니다'+no)
      // window.location = "http://localhost:8080/Notice"
      router.push({name:'Notice'})
    },

    selectAll(){
      this.$http.get("http://13.124.143.135:8888/notice/all")
      .then(res=>{
        // console.log(res.data.length)
        for(var i=0;i<res.data.length;i++){
          this.items.push(res.data[i]) 
        }
        
        console.log("1",this.items)
      })
    },
    
  },
  mounted(){
    this.selectAll()
  },
  computed: {
    ...mapState({
      getMemberId:state=>state.User.member_id,
      getEmail : state => state.User.email,
      getNickname : state => state.User.nickname,
      getGrade: state=> state.User.grade,
      getIsLogin: state=> state.isLogin
    })
  }

}
</script>

<style>
@media screen and (min-width: 1520px) {
    #btn__add{
      margin-left: 1550px;
      margin-bottom: 20px;
    }
}
    
@media screen and (max-width: 600px) {
    #btn__add{
      margin-left: 286px;
      margin-bottom: 10px;
    }
}

@media screen and (min-width: 1520px) {
    #btn__del{
      margin-left: 1550px;
      margin-top: 3px;
      margin-bottom: 10px;
    }
}
    
@media screen and (max-width: 600px) {
    #btn__del{
      margin-left: 266px;
      margin-top: 3px;
      margin-bottom: 10px;
    }
}
</style>
