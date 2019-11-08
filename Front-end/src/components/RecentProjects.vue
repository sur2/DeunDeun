<template>
  <section
    id="recent-projects"
    class="hide-overflow"
  >
    <v-layout>
      <v-flex
        xs12
        md6
        secondary
        text-xs-center
        pa-5
        white--text
      >
        <base-bubble-1
          style="transform: rotate(180deg) translateX(25%)"
        />
        <base-heading>
          Our Site
        </base-heading>

        <base-text class="mb-5 white--text" >
          배달음식에 많은 돈을 쓰지마세요<br>
          1GB = ￦6,000<br>
          가성비 좋은 음식을 찾아드립니다
        </base-text>

        <v-card color="secondary" >
          <v-container
            grid-list-md
            pa-2
            hidden-sm-and-down
          >
            <v-layout wrap>
              <v-flex
                v-for="project in projects"
                :key="project"
                xs12
                md6
              >
                <a>
                  <v-img
                    :src="require(`@/assets/Home/${project}.jpg`)"
                    max-height="300"
                  />
                </a>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card>
      </v-flex>
      <v-flex
        hidden-sm-and-down
        md6
      >
        <v-img
          :src="require('@/assets/Home/Phone.jpg')"
          height="100%"
        />
      </v-flex>
    </v-layout>
  </section>
</template>

<script>
export default {
  data: () => ({
    projects: [
      'Delivery',
      'Location',
      'Wallet',
      'Food'
    ]
  })
}
</script>
