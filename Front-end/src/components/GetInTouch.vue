<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout
      info
      white--text
    >
      <v-flex
        hidden-sm-and-down
        md6
      >
        <v-img
          :src="require('@/assets/contact.png')"
          height="100%"
        />
      </v-flex>
      <v-flex
        xs12
        md6
        pa-5
        secondary
        white--text
      >
        <base-bubble-1 />
        <base-heading class="mb-5">
          Contact Us
        </base-heading>

        <base-text>
          가게 추가를 원하는 사장님은 편하게 연락주세요
        </base-text>

        <v-sheet
          max-width="600"
          color="transparent"
        >
          <v-text-field
            color="info"
            label="성함"
            solo
            flat
          />
          <v-text-field
            color="info"
            label="연락가능한 휴대폰 번호"
            solo
            flat
          />
          <v-text-field
            color="info"
            label="지역"
            solo
            flat
          />
          <v-textarea
            color="info"
            label="가게 정보 및 상세 내용"
            solo
            flat
          />
          <base-btn>Send</base-btn>
        </v-sheet>
      </v-flex>
    </v-layout>
  </section>
</template>
