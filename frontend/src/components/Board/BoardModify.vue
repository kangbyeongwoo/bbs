<template>
            <div class="wrapper wrapper-content">
        <div class="row">
            
            <div class="col-lg-9 animated fadeInRight">
            <div class="mail-box-header">
                <h2>
                    수정페이지
                </h2>
            </div>
                <div class="mail-box">
                <div class="mail-body">
                    <form method="get">
                       
                        <div class="form-group row"><label class="col-sm-2 col-form-label">작성자</label>
                            <div class="col-sm-10" ><p>{{BoardVO.bwriter}}</p></div>
                        </div>
                        
                    
                        <div class="form-group row"><label class="col-sm-2 col-form-label">제목</label>
                            <div class="col-sm-10"> <input type="text" class="form-control" id="btitle" v-model="BoardVO.btitle"></div>
                        </div>
                        </form>

                </div>
              
                    <div class="mail-text h-200">
                        <div class="summernote" >
                            <textarea  id="bcontent" style="width:100%; height:500px;border: none; " v-model="BoardVO.bcontent"></textarea>
                        </div>

                        </div>
                    <div class="mail-body text-right tooltip-demo">
                       <button v-on:click="BoardModifyPost" class="btn btn-sm btn-primary" ><i class="fa fa-reply"></i> 쓰기</button>
                    </div>
                </div>
            </div>
        </div>
        </div>
</template>

<script>
import axios from 'axios'   
export default {
  name: 'BoardModify',
  data:()=>{
      return{          
          BoardVO:{
              bnum:"",
              btitle:"",
              bcontent:"",
              bwriter:"",
              bdate:""
          }
          
      }
  },
   created(){
      axios.get("http://127.0.0.1:5000/BoardModify/"+this.$route.params.bnum)
      .then(response=> {
          console.log(response.data)
          this.BoardVO=response.data
          console.log(this.BoardVO)
          console.log(JSON.stringify(this.BoardVO))

      })
  }, 
    methods:{
      BoardModifyPost(){
          var data={
              btitle:this.BoardVO.btitle,
              bcontent:this.BoardVO.bcontent,
              bwriter:this.BoardVO.bwriter,
              bnum:this.BoardVO.bnum
          }
        axios.post("http://127.0.0.1:5000/BoardModify/"+this.$route.params.bnum,data)
          .then(response=>{
              this.bwriter=response.data.bwriter;this.btitle=response.data.btitle;this.bcontent=response.data.bcontent
              console.log(response.data)
              console.log(data)
          })
          this.$router.push({
              path:'/'
            
          })
         alert('수정되었습니다.!')

          }

  }
}
</script>