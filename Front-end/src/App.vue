<template>
  <v-app>
    <core-toolbar />
    <router-view />
    <core-footer />
  </v-app>
</template>

<script>
export default {
  name: 'App',
  components: {
    CoreFooter: () => import('@/components/core/Footer'),
    CoreToolbar: () => import('@/components/core/Toolbar')
  }
}
</script>
