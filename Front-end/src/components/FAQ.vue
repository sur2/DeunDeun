<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout accent white--text>
        <v-container fluid class="mt-5">
            <v-label>
            </v-label>
            <v-expansion-panel focusable popout>
              <v-expansion-panel-content v-for="(item,i) in items" :key="i">
                <div slot="header">{{item.Header}}</div>
                <v-card>
                  <v-card-text>{{item.Content}}</v-card-text>
                </v-card>
              </v-expansion-panel-content>
            </v-expansion-panel>
        </v-container>
    </v-layout>
  </section>
</template>

<script>
export default {
  data: () => ({
    items: [
      {
        No: '1',
        Header: 'Question 1',
        Content: 'Answer 1'
      },
      {
        No: '2',
        Header: 'Question 2',
        Content: 'Answer 2'
      },
      {
        No: '3',
        Header: 'Question 3',
        Content: 'Answer 3'
      },
      {
        No: '4',
        Header: 'Question 4',
        Content: 'Answer 4'
      },
    ]
  })
}
</script>

<style>

  @media screen and (min-width: 1520px) {
    #login__card{
      margin-top: 150px;
      margin-bottom: 150px;
      margin-left: 440px;
       width: 600px;
    }
  }

   @media screen and (max-width: 600px) {
     #login__card{
       margin-top: 200px;
       margin-bottom: 200px;
     }
   }
  
</style>
