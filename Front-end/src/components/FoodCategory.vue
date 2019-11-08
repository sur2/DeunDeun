<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout class="light-blue darken-4 pt-12 pb-3" white--text>
        <v-container fluid>
             <v-card id="cards__small" @click="$router.push({name: 'FoodList', params: {category: 'all'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/AllFood.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>모든 음식</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__small" @click="$router.push({name: 'FoodList', params: {category: 'one'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/Alone.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>1인분 주문</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__rect" @click="$router.push({name: 'FoodList', params: {category: 'chicken'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/Chicken.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>치킨</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__rect" @click="$router.push({name: 'FoodList', params: {category: 'pizza'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/Pizza.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>피자</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__small" @click="$router.push({name: 'FoodList', params: {category: 'pig'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/PorkFeet.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>족발/보쌈</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__small" @click="$router.push({name: 'FoodList', params: {category: 'ddeok'}})">
                <v-img
                id="cards__image__rect"
                :src="require('@/assets/Category/SnackFood.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>분식</v-card-title>
                </v-img>
            </v-card>
            
            <v-card id="cards__rect_small" @click="$router.push({name: 'FoodList', params: {category: 'cafe'}})">
                <v-img
                id="cards__image__small"
                :src="require('@/assets/Category/Cafe.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>카페/디저트</v-card-title>
                </v-img>
            </v-card>
            
            <v-card id="cards__rect_small_under" @click="$router.push({name: 'FoodList', params: {category: 'franchise'}})">
                <v-img
                id="cards__image__small"
                :src="require('@/assets/Category/Franchise.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>프랜차이즈</v-card-title>
                </v-img>
            </v-card>
            
            <v-card  id="cards__rect__under" @click="$router.push({name: 'FoodList', params: {category: 'chinese'}})">
                <v-img
                id="cards__image__under"
                :src="require('@/assets/Category/Chinese.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>중국집</v-card-title>
                </v-img>
            </v-card>

            <v-card id="cards__large__under" @click="$router.push({name: 'FoodList', params: {category: 'korean'}})">
                <v-img
                id="cards__image__under"
                :src="require('@/assets/Category/KoreanFood.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>한식</v-card-title>
                </v-img>
            </v-card>

            <v-card  id="cards__rect__under" @click="$router.push({name: 'FoodList', params: {category: 'japanese'}})">
                <v-img
                id="cards__image__under"
                :src="require('@/assets/Category/JapaneseFood.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>일식</v-card-title>
                </v-img>
            </v-card>

            <v-card  id="cards__rect__under" @click="$router.push({name: 'FoodList', params: {category: 'night'}})">
                <v-img
                id="cards__image__under"
                :src="require('@/assets/Category/Ramen.jpg')"
                class="white--text align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                >
                <v-card-title>야식</v-card-title>
                </v-img>
            </v-card>
        </v-container>
    </v-layout>
  </section>
</template>

<style>
    @media screen and (min-width: 1520px) {
        #cards__large {
            width: 300px;
            height: 600px;
            margin: 0;
            float: left;
            margin-left: 100px;
        }
        
        #cards__rect{
            width: 300px;
            height: 300px;
            float: left;
            margin-left: 20px;
        }

        #cards__rect_small{
            width: 140px;
            height: 140px;
            float: left;
            margin-left: 20px;
        }
        
        #cards__rect_small_under{
            width: 140px;
            height: 140px;
            float: left;
            margin-left: 20px;
            margin-top: 20px;
        }

        #cards__small{
            width: 140px;
            height: 300px;
            float: left;
            margin-left: 20px;
        }

        #cards__large__under{
            width: 460px;
            height: 280px;
            float: left;
            margin-left: 20px;
            margin-top: 20px;
        }

        #cards__rect__under{
            width: 300px;
            height: 280px;
            float: left;
            margin-left: 20px;
            margin-top: 20px;
        }

        #cards__image__large{
            height: 600px;
        }


        #cards__image__rect{
            height: 300px;
            background-position: 40,20;
        }

        #cards__image__under{
            height: 280px;
        }

        #cards__image__small{
            height: 140px;
        }
    }

    @media screen and (max-width: 992px) {
        #cards__large, #cards__rect, #cards__small, #cards__large__under, #cards__rect__under, #cards__rect_small, #cards__rect_small_under  {
            width: 300px;
            height: 120px;
            margin-top: 20px;
            margin-left: 20px;
        }
        #cards__large, #cards__image__large, #cards__image__rect, #cards__image__under, #cards__image__small {
            height: 120px;
        }
    }

    @media screen and (max-width: 600px) {
        #cards__large, #cards__rect, #cards__small, #cards__large__under, #cards__rect__under, #cards__rect_small, #cards__rect_small_under  {
            width: 300px;
            height: 120px;
            margin-top: 20px;
            margin-left: 20px;
        }
        #cards__large, #cards__image__large, #cards__image__rect, #cards__image__under, #cards__image__small {
            height: 120px;
        }
    }
</style>
