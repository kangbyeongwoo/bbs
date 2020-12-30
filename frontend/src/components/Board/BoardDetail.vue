<template>
        <div class="wrapper wrapper-content  animated fadeInRight article" >
            <div class="row justify-content-md-center">
                <div class="col-lg-10">
                    <div class="ibox">
                        <div class="ibox-content">
                            <div class="float-right">
                                <button class="btn btn-white btn-xs" type="button">{{BoardDetail.bwriter}}</button>
                            </div>
                            <div class="text-center article-title">
                            <span class="text-muted"><i class="fa fa-clock-o"></i>{{BoardDetail.bdate}}</span>
                                <h1>
                                   {{BoardDetail.btitle}}
                                </h1>
                            </div>
                                <p>{{BoardDetail.bcontent}}</p>  
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="small text-right">
                                      <button v-on:click="rowClick()" type="button" class="btn btn-primary btn-lg">수정</button>&nbsp;
                                      <button v-on:click="deleteBoard" type="button" class="btn btn-primary btn-lg">삭제</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>

import axios from 'axios'
export default {
  name: 'BoardDetail',
  data:()=>{
      return{          
          BoardDetail:{
              bnum:"",
              btitle:"",
              bcontent:"",
              bwriter:"",
              bdate:""
          }
          
      }
  },
  created(){
      axios.get("http://127.0.0.1:5000/BoardDetail/"+this.$route.params.bnum)
      .then(response=> {
          console.log(response.data)
          this.BoardDetail=response.data
          console.log(this.BoardDetail)
          console.log(JSON.stringify(this.BoardDetail))
      })
  },
  
    methods:{
      rowClick(){
          this.$router.push({
              name:"BoardModify",
              params:{      
                  bnum:this.$route.params.bnum,
                  BoardDetail:this.BoardDetail
              }
              
          })
      }, 
      deleteBoard(){
          axios.post("http://127.0.0.1:5000/BoardDetail/"+this.$route.params.bnum)
          .then(response=>{
              console.log(response.data)
              this.$router.push({
                  path:'/'
                })
          })
          .catch(error=>{
              console.log(error)
          })
          alert('삭제되었습니다.!')
      }
  },
}
</script>