<template>
  <section
    id="welcome"
    class="hide-overflow"
  >
    <v-layout class="mt-7">
      <v-flex
        hidden-sm-and-down
        md6
      >
        <v-img
          :src="require('@/assets/Home.jpg')"
          height="100.5vh"
        />
      </v-flex>

      <v-flex
        xs12
        md6
        align-content-space-between
        layout
        :pa-5="$vuetify.breakpoint.smAndDown"
        wrap
      >
        <base-bubble-1
          style="transform: rotate(180deg) translateY(25%)"
        />

        <v-layout
          align-center
          justify-center
        >
          <v-flex
            xs10
            md6
          >
            <base-heading>Deun Deun</base-heading>
            <base-text>
              국밥은 한국 전통의 음식으로<br>
              과거부터 지금까지 사랑받고 있습니다<br>
              <br>
              아침밥같은 든든함으로
              <br>
              여러분의 식생활을 책임지겠습니다
            </base-text>
            <v-btn color="secondary" rounded class="mt-4" :to="{name:'FoodCategory'}">
              &nbsp;시작하기&nbsp;
            </v-btn>

            <v-btn v-if="this.getIsLogin===false"  color="secondary" rounded class="mt-4 ml-5" :to="{name:'Login'}">
              &nbsp;로그인&nbsp;
            </v-btn>
            
            <v-btn v-if="this.getIsLogin==true"  color="secondary" rounded class="mt-4 ml-5" @click="logout">
              &nbsp;로그아웃&nbsp;
            </v-btn>

            
          </v-flex>
        </v-layout>

        <base-bubble-2
          style="transform: rotate(180deg) translate(-200px, -15%)"
        />
      </v-flex>
    </v-layout>
  </section>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
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
}
</script>