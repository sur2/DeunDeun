<template>
<v-layout primary white--text class="pt-10">
  <v-card>
    <v-navigation-drawer
      expand-on-hover
      permanent
    >
      <template v-slot:prepend>
        <v-list>

          <v-list-item
            two-line
          >
            <v-list-item-content>
              <v-list-item-title class="title">관리자</v-list-item-title>
              <v-list-item-subtitle>{{getEmail}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </template>

      <v-divider></v-divider>

      <v-list
        nav
        dense
      >
        <v-list-item @click="$router.push({name: 'AllRestaurant'})">
          <v-list-item-icon>
            <v-icon>mdi-store</v-icon>
          </v-list-item-icon>
          <v-list-item-title>가게 관리</v-list-item-title>
        </v-list-item>
        
        <v-list-item @click="$router.push({name: 'AllMember'})">
          <v-list-item-icon>
            <v-icon>mdi-account-multiple</v-icon>
          </v-list-item-icon>
          <v-list-item-title>사용자 관리</v-list-item-title>
        </v-list-item>

        <v-list-item @click="$router.push({name: 'Notice'})">
          <v-list-item-icon>
            <v-icon>mdi-alert</v-icon>
          </v-list-item-icon>
          <v-list-item-title>공지사항 관리</v-list-item-title>
        </v-list-item>
        
        <v-list-item @click="$router.push({name: 'FAQ'})">
          <v-list-item-icon>
            <v-icon>mdi-help-circle-outline</v-icon>
          </v-list-item-icon>
          <v-list-item-title>FAQ 관리</v-list-item-title>
        </v-list-item>
       
        <v-list-item @click="$router.push({name: 'FoodCategory'})">
          <v-list-item-icon>
            <v-icon>mdi-store</v-icon>
          </v-list-item-icon>
          <v-list-item-title>사용자 화면</v-list-item-title>
        </v-list-item>

        <v-list-item @click="logout">
          <v-list-item-icon>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-icon>
          <v-list-item-title>로그아웃</v-list-item-title>
        </v-list-item>

      </v-list>

    </v-navigation-drawer>
  </v-card>

    <v-row>
        <v-col
        cols="6"
            md="2"
        >
   <v-card
   class="mt-10 ml-10"
    color="#26c6da"
    dark
  >
    <v-card-title class="text-center">전체 사용자 수</v-card-title>
    <v-card-text class="display-2 font-weight-bold text-center">
      {{Members}}
    </v-card-text>

  </v-card>

   <v-card
   class="mt-10 ml-10"
    color="#eea138"
    dark
  >
    <v-card-title class="text-center">전체 가게 수</v-card-title>
    <v-card-text class="display-2 font-weight-bold text-center">
      {{Stores}}
    </v-card-text>

  </v-card>

   <v-card
   class="mt-10 ml-10"
    color="#e06aae"
    dark
  >
    <v-card-title class="text-center">받은 메일 개수</v-card-title>
    <v-card-text class="display-2 font-weight-bold text-center">
        2
    </v-card-text>

  </v-card>
    </v-col>

    <v-col>
          <v-card
          class="mt-10"
            color="grey lighten-4"
            max-width="800"
        >
            <v-sparkline
                :value="value"
                :gradient="gradient"
                :smooth="radius || false"
                :padding="padding"
                :line-width="width"
                :stroke-linecap="lineCap"
                :gradient-direction="gradientDirection"
                :fill="fill"
                :type="type"
                :auto-line-width="autoLineWidth"
                auto-draw
                show-labels=""
            ></v-sparkline>
          </v-card>
    </v-col>
</v-row>


</v-layout>
</template>

<script>
import { mapState, mapActions } from "vuex";
import axios from "axios";
 const gradients = [
    ['#222'],
    ['#42b3f4'],
    ['red', 'orange', 'yellow'],
    ['purple', 'violet'],
    ['#00c6ff', '#F0F', '#FF0'],
    ['#f72047', '#ffd200', '#1feaea'],
  ]

export default {
 name: "about",
 data: function() {
   return {
       Stores:0,
       Members:0,

       width: 2,
      radius: 10,
      padding: 8,
      lineCap: 'round',
      gradient: gradients[5],
      value: [10, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
      gradientDirection: 'top',
      gradients,
      fill: false,
      type: 'trend',
      autoLineWidth: false,
       
   };
 },
 mounted() {
    axios.get("http://13.124.143.135:8888/restaurant/count").then(res =>{
    this.Stores = res.data;
    });
    
    axios.get("http://13.124.143.135:8888/members/count").then(res =>{
    this.Members = res.data;
    });
    
 },
  computed: {
    ...mapState({
        getEmail : state => state.User.email,
        getNickname : state => state.User.nickname,
        getGrade: state=> state.User.grade,
        getIsLogin: state=> state.isLogin
    })
  },
  methods:{
    ...mapActions(["logout"])
  },
};
</script>