<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout info white--text class="pt-10">
        <v-container fluid>
             <v-row>
                <v-col
                    cols="12"
                    md="4"
                >
                    <v-card
                    class="pa-2"
                    max-width="374"
                    outlined
                    tile
                    >
                        <v-img
                            height="250"
                            src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
                            ></v-img>

                            <v-card-title>{{store.name}} 
                                <v-btn text icon id="like_none_Btn" @click="like" v-if="this.getIsLogin === true">
                                  <v-icon>mdi-heart</v-icon>
                                </v-btn>

                                <v-btn text icon color="pink" class="d-none" id="like_Btn" @click="dislike" v-if="this.getIsLogin === true"> 
                                  <v-icon>mdi-heart</v-icon>
                                </v-btn>
                            </v-card-title>

                            <v-card-text>
                            <v-row
                                align="center"
                                class="mx-0"
                            >
                            </v-row>

                            <div>전화 번호 : {{store.tel}}<br> 영업시간 : {{store.operation_hour}}</div>
                            </v-card-text>

                            <v-divider class="mx-4"></v-divider>

                            <v-card-title>장바구니</v-card-title>
                            
                            <v-card-text>
                              1국밥 = 7,000원  
                            </v-card-text>
                            <v-card-text>
                              현재 금액 : {{totalCalculate}} 원<br>
                              국밥 개수 : {{CalcuGB}} 개
                            </v-card-text>
                            <v-card-text>
                            <v-chip-group
                                  v-model="selection"
                                  column
                              >   
                                  <v-chip v-for="(selected, i) in selected" :key="i">{{selected.name}}</v-chip>
                              </v-chip-group>
                            </v-card-text>


                    </v-card>
                </v-col>

                <!--Table-->
            <v-col
                cols="12"
                md="8"
                xs="12"
            >
                <v-card
                class="pa-2"
                outlined
                tile
                >
                    <v-data-table
                        v-model="selected"
                        show-select
                        :headers="headers"
                        :items="foods"
                        item-key="name"
                        group-by="국밥개수"
                        class="elevation-1"
                        sort-by="price"
                        sort-desc=""
                    ></v-data-table>
                </v-card>
            </v-col>
            </v-row>
        </v-container>
    </v-layout>
  </section>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";
export default {
 name: "about",
 data: function() {
   return {
      total_price : 0,
      selection: 1,
      selected: [],
      headers: [
        {
          text: 'Menu',
            align: 'left',
            value: 'name'
          },
          { text: 'Price', value:'price'},
          { text: '국밥', value: '국밥개수'},
        ],
     foods : [],
     store:[],
     GB : 0,
     favorite_id: 0
   };
 },
 mounted() {
   
   var store = this.$route.params.storeNo;
     axios.get("http://13.124.143.135:8888/food/"+store).then(res => {
       this.foods = res.data

      var step = 0;
      res.data.forEach(food => {
        var temp = 0;
        temp = food.price / 7000;
        res.data[step].국밥개수 = parseInt(temp);
        step++;
      });

    });

    axios.get("http://13.124.143.135:8888/restaurant/"+store).then(res =>{
      this.store = res.data;
    });

    var store = this.$route.params.storeNo;
    var member = this.getMemberId;
  
    axios.get("http://13.124.143.135:8888/favorite/member/"+member+"/restaurant/"+store).then(res =>{
      this.favorite_id = res.data.favorite_id;
      if(res.data == ""){
          document.getElementById("like_none_Btn").classList.remove("d-none");
          document.getElementById("like_Btn").classList.add("d-none");
      }else{
          document.getElementById("like_none_Btn").classList.add("d-none");
          document.getElementById("like_Btn").classList.remove("d-none");
      }
    });

 },
 computed : {
      totalCalculate : function() {
        this.total_price = 0
        this.selected.forEach(item => {
          this.total_price += item.price
        });
        return this.total_price;
      },

      CalcuGB : function(){
        var total_price = this.total_price;
        this.GB = total_price/7000;
        return parseInt(this.GB);
      },

       ...mapState({
        getMemberId : state => state.User.member_id,
        getEmail : state => state.User.email,
        getNickname : state => state.User.nickname,
        getGrade: state=> state.User.grade,
        getIsLogin: state=> state.isLogin
    })
  },
  methods:{

    like :function(){
      var store = this.$route.params.storeNo;
      var member = this.getMemberId;

      var body ={
        member_id : member,
        restaurant_id : store
      }
      axios({
       headers: { "Content-Type": "application/json" },
       url: "http://13.124.143.135:8888/favorite/insert",
       method: "post",
       data: JSON.stringify(body)
      })
      document.getElementById("like_none_Btn").classList.add("d-none");
      document.getElementById("like_Btn").classList.remove("d-none");
    },

    dislike: function(){
      var favorite_id  = this.favorite_id;
      axios({
        headers: { "Content-Type": "application/json" },
        url: "http://13.124.143.135:8888/favorite/delete",
        method: "delete",
        params: {favorite_id: favorite_id}
      })
      document.getElementById("like_Btn").classList.add("d-none");
      document.getElementById("like_none_Btn").classList.remove("d-none");
    }

    
  }
};
</script>