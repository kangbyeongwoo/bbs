<template>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Vue.JS 게시판</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="#" class="dropdown-item">Config option 1</a>
                                </li>
                                <li><a href="#" class="dropdown-item">Config option 2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover dataTables-example" >
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="bList in BoardList" v-bind:key="bList.id" v-on:click="rowClick(bList)">
                        <th>{{bList.bnum}}</th>
                        <th>{{bList.btitle}}</th>
                        <th>{{bList.bwriter}}</th>
                        <th>{{bList.bdate}}</th>
                    </tr>
                    </tbody>
                    </table>
                        </div>

                    </div>
                    <a href="BoardWrite"><button type="button" class="btn btn-primary btn-lg">글쓰기</button></a>
                </div>
            </div>
            </div>
        </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'BoardList',
  data:()=>{
      return{
          BoardList:[]
      }
  },
  created(){
      axios.get("http://127.0.0.1:5000/BoardList")
      .then(response=> {
          console.log(response.data)
          this.BoardList=response.data
          console.log(this.BoardList)
          console.log(JSON.stringify(this.BoardList))
          /**정렬 원본을 정렬함 */
          this.BoardList.sort((a,b)=>{
              return b.bnum-a.bnum
          })
      })
  },
  methods:{
      rowClick(bList){
          // 클릭 했을 시 값이 넘어 오는지 확인
          console.log("bnum"+bList.bnum)
          console.log("btitle"+bList.btitle)
          console.log("bwriter"+bList.bwriter)
          console.log("bcontent"+bList.bcontent)
          console.log("bdate"+bList.bdate)
          this.$router.push({
              name:'BoardDetail',
              params:{
                  bList:bList,
                  bnum:bList.bnum
              }
          })
      }
  }
}
</script>

<style scoped>

</style>
