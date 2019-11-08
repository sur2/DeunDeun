<template>
  <section
    id="services"
    class="hide-overflow"
  >
    <v-layout info>
      <v-flex
        hidden-sm-and-down
        md6
      >
        <v-img
          :src="require('@/assets/services.png')"
          height="100%"
        />
      </v-flex>
      <v-flex
        xs12
        md6
        text-xs-center
        pa-5
        primary
        white--text
      >
        <v-layout
          align-center
          justify-center
          fill-height
          wrap
        >
          <v-flex xs12>
            <base-bubble-2
              style="transform: translateX(55%)"
            />
            <base-heading class="info--text">
              Services
            </base-heading>

            <base-text class="mb-5 white--text">
              대학가 주변 <br>
              <strong>가성비</strong> 좋은 음식점을 추천해드립니다
            </base-text>
          </v-flex>
          <v-flex
            v-for="(service, i) in services"
            :key="i"
            md6
            text-xs-center
            mb-3
          >
            <v-avatar
              class="elevation-6 mb-2"
              color="#69A1BB"
              size="64"
              tile
            >
              <v-icon
                dark
                size="52"
                v-text="service.icon"
              />
            </v-avatar>
            <base-text>
              <div
                class="mb-2"
                v-text="service.name"
              />
              <div v-html="service.blurb" />
            </base-text>
          </v-flex>
        </v-layout>
      </v-flex>
    </v-layout>
  </section>
</template>

<script>
export default {
  data: () => ({
    services: [
      {
        name: '가성비',
        icon: 'mdi-clipboard-text-outline',
        blurb: '<small>가성비 좋은 음식점을<br> 순서대로 제공합니다</small>'
      },
      {
        name: '無수수료',
        icon: 'mdi-numeric-0-box',
        blurb: '<small>다른 사이트와 다르게 <br> 수수료가 하나 없습니다</small>'
      },
      {
        name: '개발중',
        icon: 'mdi-settings-outline',
        blurb: '<small>계속해서 지역을 <br>확장할 계획입니다</small>'
      },
      {
        name: '지원',
        icon: 'mdi-account',
        blurb: '<small>사장님들의 관리를 <br>쉽게 도와드립니다</small>'
      }
    ]
  })
}
</script>
