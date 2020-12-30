<template>
              <div class="wrapper wrapper-content">
        <div class="row">
            
            <div class="col-lg-9 animated fadeInRight">
            <div class="mail-box-header">
                <h2>
                    글 쓰기
                </h2>
            </div>
                <div class="mail-box">
                <div class="mail-body">
                        
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">작성자</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id ="bwriter" required minlength="4" maxlength="20" gi-model="BoardVO.bwriter" >
                                </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">제목</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="btitle" v-model="BoardVO.btitle">
                                </div>
                        </div>

                </div>
                    <div class="mail-text h-200">
                        <div class="summernote" >
                            <textarea v-model="BoardVO.bcontent" id="bcontent" style="width:100%; height:500px;border: none;"></textarea>
                        </div>

                        </div>
                    <div class="mail-body text-right tooltip-demo">
                        <button v-on:click="BoardWritePost" class="btn btn-sm btn-primary" ><i class="fa fa-reply"></i> 쓰기</button>
                    </div>
                </div>
            </div>
        </div>
        </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'BoardWrite',
  data:()=>{
      return{
          BoardVO:{
              bnum:0,
              btitle:"",
              bcontent:"",
              bwriter:"",
              bdate:""
          }
      }
  },
  methods:{
      BoardWritePost(){
          var data={
              btitle:this.BoardVO.btitle,
              bcontent:this.BoardVO.bcontent,
              bwriter:this.BoardVO.bwriter
          }
          axios.post("http://127.0.0.1:5000/BoardWrite",data)
          .then(response=>{
            //   this.bwriter=response.data.bwriter;this.btitle=response.data.btitle;this.bcontent=response.data.bcontent
              console.log(response.data)
              console.log(data)
              this.$router.push({
                path:'/'
            })
          })
          .catch(error =>{
              console.log(error)
          })

      }
  }

}
</script>

<style>

</style>
