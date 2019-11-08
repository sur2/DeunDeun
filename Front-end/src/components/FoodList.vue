<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout primary white--text class="pt-10">
        <v-container fluid>
            <!-- h1까지 지우고 하세요-->
            <v-row dense="">
                <v-col cols="12" md="12">
                    <div id="map"></div>
                </v-col>   
            </v-row>
                <v-flex>
                        <v-row dense>
                            <v-col v-for="(item, i) in restaurant" :key="i" cols="12" xs="4" sm="6" md="4">
                                <v-card class="cyan darken-1"   dark min-height="214"  @click="$router.push({name: 'StoreDetail', params: {storeNo: item.restaurant_id}})"> 
                                    <div class="d-flex flex-no-wrap justify-space-between">
                                        <div>
                                            <v-card-title class="headline" v-text="item.name"></v-card-title>
                                            <v-card-subtitle>대표메뉴 가격 {{item.price}} 원<br>영업시간  {{item.operation_hour}}분</v-card-subtitle>
                                            <v-card-subtitle>전화번호 {{item.tel}}</v-card-subtitle>
                                        </div>

                                        <v-avatar class="ma-3" size="135" tile>
                                            <v-img :src="item.src"></v-img>
                                        </v-avatar>
                                    </div>
                                </v-card>
                            </v-col>
                        </v-row>
                </v-flex>
        </v-container>
    </v-layout>
  </section>
</template>

<script>
import axios from "axios";
import gmapsInit from "../utils/gmaps.js";

export default {
  name: "HelloWorld",
  data: function() {
    return {
      now_x: "",
      now_y: "",
      restaurant: {}
    };
  },
  props: {
    msg: String
  },
  created() {},
  async mounted() {
    
    // url 파라미터별 가게정보
    var cate = this.$route.params.category;
    var cateNum = 0;

    if (cate == 'one') {
        cateNum = 1
    }else if(cate == 'franchise'){
        cateNum = 2
    }else if(cate == 'chicken'){
        cateNum = 3
    }else if(cate == 'pizza'){
        cateNum = 4
    }else if(cate == 'chinese'){
        cateNum = 5
    }else if(cate == 'korean'){
        cateNum = 6
    }else if(cate == 'japanese'){
        cateNum = 7
    }else if(cate == 'pig'){
        cateNum = 8
    }else if(cate == 'night'){
        cateNum = 9
    }else if(cate == 'ddeok'){
        cateNum = 10
    }else if(cate == 'cafe'){
        cateNum = 11
    }

    var urltest= ""
    
    if(cate != 'all'){
        urltest = "http://13.124.143.135:8888/category/"+cateNum+"/";
    }else {
        urltest = "http://13.124.143.135:8888/restaurant/here";
    }

    // 구글맵스 지도 객체 생성
    let map;
    let myMarker;
    try {
      const google = await gmapsInit();
      const geocoder = new google.maps.Geocoder();
      map = new google.maps.Map(document.getElementById("map"));
    } catch (error) {
      console.error(error);
    }

    // 현재 위치 가져오기
    axios({
      url: "https://www.googleapis.com/geolocation/v1/geolocate",
      method: "post",
      params: {
        key: "AIzaSyBjg8cR_tJB7iQCXQHpxzAZNERPK1sR5JQ"
      }
    }).then(res => {
      console.log("geolocation ", res);
      this.now_x = res.data.location.lng;
      this.now_y = res.data.location.lat;
      // 현재 위치를 저장할 객체 생성
      var myPlace = new google.maps.LatLng(
        // this.now_y, this.now_x
        36.3491011, 127.2983324
        );
      // 맵 설정
      map.setCenter(myPlace);
      map.setZoom(18);
      // 내 위치 마커
      var myMarker = new google.maps.Marker();
      myMarker.setPosition(myPlace);
      myMarker.setMap(map);
      // 내 위치 마커 이미지
      var markerImage = new google.maps.MarkerImage(
        "https://cdn1.iconfinder.com/data/icons/relief-photo-editor-glyph/32/account-people-avatar-circle-512.png",
        null,
        null,
        null,
        new google.maps.Size(38, 38)
      );
      // 내 위치 마커 설정
      myMarker.setIcon(markerImage);
      myMarker.setAnimation(google.maps.Animation.DROP);

      // 주변 상가 객체 가져오기
      axios({
        url: urltest,
        method: "get",
        params: {
          // lon: this.now_x,
          // lat: this.now_y,
          lon: 127.2983324,
          lat: 36.3491011,
          range: 800
        }
      }).then(res => {
        this.restaurant = res.data;  
        console.log("주변", this.now_x + ", " + this.now_y);
        console.log("주변 상가", res.data);
        res.data.forEach(restaurant => {
          // 주변 상가 객체
          var resPlace = new google.maps.LatLng(
            restaurant.location_y,
            restaurant.location_x
          );
          // 주변 상가 마커
          var resMarker = new google.maps.Marker();
          resMarker.setPosition(resPlace);
          resMarker.setMap(map);
          // 상가 마커 이미지
          var resImage = new google.maps.MarkerImage(
            "https://image.winudf.com/v2/image/Y29tLmhvYmlnLnR0dWtiYWVnaV9pY29uXzE1Mjk5Mjg0NjFfMDQ3/icon.png?w=170&fakeurl=1",
            null,
            null,
            null,
            new google.maps.Size(38, 38)
          );
          // 상가 마커 설정
          resMarker.setIcon(resImage);
          window.setTimeout(function() {
            resMarker.setAnimation(google.maps.Animation.DROP);
          }, restaurant.restaurant_id);
          // 마커의 정보 정의
          var contentString =
            '<div id = '+'restaurant'+restaurant.restaurant_id+'>' 
            +'<p>'
            +restaurant.name
            +'</p>'
            +'<p>'
            +'영업시간 : '
            +restaurant.operation_hour
            +'</p>'
            + "</div>";
          // 마커 객체에 정보 주입  
          var markerInfo = new google.maps.InfoWindow({
            content : contentString
          });
          // 마커 클릭 이벤트
          resMarker.addListener('click', function(){
            markerInfo.open(map, resMarker)
          })
        });
      });
    });
  }
};
</script>


<style>

#map {
  height: 300px;
}

p{color: black}
</style>