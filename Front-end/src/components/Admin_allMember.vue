<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout primary white--text class="pt-10">
        <v-container fluid>
            <v-card>
                <v-card-title>
                All Member
                <v-spacer></v-spacer>
                    <v-text-field
                        v-model="search"
                        label="Search"
                        single-line
                        hide-details
                    ></v-text-field>
                    <v-btn class="ml-5" color="warning" @click="deleteStore">삭제</v-btn>
                </v-card-title>
                <v-data-table
                    v-model="selected"
                    show-select
                    item-key="member_id"
                    :headers="headers"
                    :items="members"
                    :search="search"
                ></v-data-table>
            </v-card>


           
        </v-container>
    </v-layout>
  </section>
</template>


<script>

    import axios from "axios";

    export default {
        data: function() {
        return {
            dialog: false,
            selected: [],
            search: '',
            headers: [
            {
                text: '이름',
                align: 'left',
                value: 'name',
            },
            { text: '닉네임', value: 'nickname' },
            { text: '이메일', value: 'email' },
            { text: '가입일자', value: 'create_at' },
            { text: '구분', value: 'grade' },
            ],
            members : [],
        };
    },
    mounted() {
        axios({
            url: "http://13.124.143.135:8888/members/all",
            method: "post",
            params: {
            }
        }).then(res => {
            this.members = res.data
            console.log(this.restaurant)
        });
    },
    methods:{
        deleteStore: function(){
            console.log(this.selected)
        }
    }
    };
    
</script>