<template>
  <div>
    <welcome />
    <recent-projects />
    <services />
    <get-in-touch />
  </div>
</template>

<script>
export default {
  components: {
    Welcome: () => import('@/components/Welcome'),
    RecentProjects: () => import('@/components/RecentProjects'),
    Services: () => import('@/components/Services'),
    GetInTouch: () => import('@/components/GetInTouch')
  }
}
</script>
