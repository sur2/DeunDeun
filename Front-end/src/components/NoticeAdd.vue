<template>
    <section id="get-in-touch" class="hide-overflow">
        
        <v-layout accent white--text class="mt-12">
            <v-container fluid class="mt-12 mb-12">
                <center><h1>Add Notice</h1></center>
                
                <center>
                    <div class="mt-12">
                        <v-card class="mx-auto" max-width="400" outlined>
                            <v-form>
                                <v-text-field
                                v-model="title"
                                label="제목을 입력하세요"
                                single-line
                                full-width
                                hide-details
                                ></v-text-field>
                                <v-divider></v-divider>
                                
                                <v-textarea
                                v-model="contents"
                                label="내용을 입력하세요"
                                counter
                                maxlength="120"
                                full-width
                                single-line
                                ></v-textarea>
                            </v-form>
                            
                            <div class="text-center mb-6">
                                <v-btn rounded color="info" v-on:click="add">등록하기</v-btn>
                                &nbsp;
                                <v-btn rounded color="primary" v-on:click="cancle">취소하기</v-btn>
                            </div>
                        </v-card>
                    </div>
                </center>
                
            </v-container>
        </v-layout>
        
    </section>
</template>

<script>
import { mapState } from "vuex";
export default {
    data: () => ({
        title: '',
        contents: '',
    }),
    methods: {
        add: function(event) {
            if(this.title==='') {
                alert("제목을 입력하세요.")
            } else if(this.contents==='') {
                alert("내용을 입력하세요.")
            } else {
                alert("공지사항이 등록되었습니다.")
                this.insertNotice()
                window.location = "http://13.124.143.135:8080/Notice"
            }
        },
        insertNotice() {
            var notice={
                member_id:this.getMemberId,
                title:this.title,
                contents: this.contents
            }

            this.$http.post("http://13.124.143.1356:8888/notice/insert",notice)
            .then(res=>{
                console.log(res.data)
            })
            .catch(err=>{
                console.log(err)
            })
            console.log(notice)
        },
        cancle: function(event) {
            alert("공지사항 작성이 취소되었습니다.")
            window.location = "http://13.124.143.135:8080/Notice"
        },
    },
    computed: {
    ...mapState({
        getMemberId:state=>state.User.member_id,
        getEmail : state => state.User.email,
        getNickname : state => state.User.nickname,
        getGrade: state=> state.User.grade,
        getIsLogin: state=> state.isLogin
    })
    }    
}
</script>