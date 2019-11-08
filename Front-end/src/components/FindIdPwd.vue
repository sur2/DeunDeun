<template>
  <section
    id="get-in-touch"
    class="hide-overflow"
  >
    <v-layout primary white--text>
        <v-container fluid>
            <v-row>
                <v-col cols="12" md="6" xs="12">
                    <v-card class="elevation-12" id="findId__card">
                        <v-toolbar color="info" dark flat>
                            <v-toolbar-title>Find Id</v-toolbar-title>
                        </v-toolbar>
                        
                        <v-card-text>
                            <v-form>
                                <v-text-field
                                v-model="name"
                                label="Name"
                                name="name"
                                type="text"
                                ></v-text-field>
                                
                                <v-text-field
                                v-model="idtel"
                                label="Telephone Number"
                                name="tel"
                                type="text"
                                ></v-text-field>
                            </v-form>
                        </v-card-text>
                        
                        <div class="text-center mb-5">
                            <v-btn color="info" v-on:click="findid">Find Id</v-btn>
                        </div><br>
                        
                    </v-card>
                </v-col>

                <v-col cols="12" md="6" xs="12">
                    <v-card class="elevation-12" id="findPwd__card">
                        <v-toolbar color="info" dark flat>
                            <v-toolbar-title>Find Pwd</v-toolbar-title>
                        </v-toolbar>
                        
                        <v-card-text>
                            <v-form>
                                <v-text-field
                                v-model="email"
                                label="Email"
                                name="email"
                                type="text"
                                ></v-text-field>
                                
                                <v-text-field
                                v-model="pwdtel"
                                label="Telephone Number"
                                name="tel"
                                type="text"
                                ></v-text-field>
                            </v-form>
                        </v-card-text>
                        
                        <div class="text-center mb-5">
                            <v-btn color="info" v-on:click="findpwd">Find Pwd</v-btn>
                        </div><br>
                        
                    </v-card>
                </v-col>

            </v-row>
        </v-container>
    </v-layout>
  </section>
</template>

<script>
  export default {
    data: () => ({
      name: '',
      email: '',
      idtel: '',
      pwdtel: '',
    }),
    methods: {
      findid: function(event) {
        if(this.name==='asd' && this.idtel==='123') {
          alert("ID : abc")
        } else {
          alert("아이디와 전화번호를 확인해주세요")
        }
      },
      findpwd: function(event) {
        if(this.email==='asd' && this.pwdtel==='123') {
          alert("PWD : 12345")
        } else {
          alert("이메일과 전화번호를 확인해주세요")
        }
      } 
    }
  }
</script>

<style>
@media screen and (min-width: 1520px) {
    #findId__card{
        margin-top: 140px;
        margin-bottom: 130px;
        margin-left: 100px;
        width: 600px;
    }
}
    
@media screen and (max-width: 600px) {
    #findId__card{
        margin-top: 80px;
        margin-bottom: 30px;
    }
}

@media screen and (min-width: 1520px) {
    #findPwd__card{
        margin-top: 140px;
        margin-bottom: 130px;
        margin-right: 50px;
        width: 600px;
    }
}
    
@media screen and (max-width: 600px) {
    #findPwd__card{
        margin-top: 10px;
        margin-bottom: 50px;
    }
}
</style>