<template>
  <div>
    <div class="navigation">
      <el-container>
        <el-header>
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" style="background-color: #ffffff">
            <el-menu-item index="1" style="margin-left: 12%;" @click="toHomePage">首页</el-menu-item>
            <el-menu-item index="2" @click="toSchool">学校</el-menu-item>
            <el-menu-item index="3">班级</el-menu-item>
            <el-menu-item index="4" style="margin-left:5%">
              <el-input v-model="input" placeholder="请输入内容" style="width: 400px;">
                <el-button icon="el-icon-search" @click="edit" size="mini" slot="append"></el-button>
              </el-input>
            </el-menu-item>
            <el-menu-item index="5">
              <el-dropdown>
                <el-avatar :src="circleUrl" @error="errorHandler"></el-avatar>
                <el-dropdown-menu slot="dropdown" placement="bottom">
                  <el-dropdown-item><i class="el-icon-star-off"></i>我的主页</el-dropdown-item>
                  <el-dropdown-item><i class="el-icon-user"></i>个人信息</el-dropdown-item>
                  <router-link target="_blank" :to="{path:'/Login'}" style="text-decoration:none;outline: none;color: #000;">
                  <el-dropdown-item><i class="el-icon-message-solid"></i>我的消息<el-badge :value="messages" :max="99" class="item"></el-badge></el-dropdown-item>
                  </router-link>
                  <router-link target="_blank" :to="{path:'/follownews'}" style="text-decoration:none;outline: none;color: #000;">
                  <el-dropdown-item>
                    <i class="el-icon-s-promotion"></i>关注动态<el-badge :value="values" :max="99" class="item"></el-badge>
                  </el-dropdown-item>
                  </router-link>
                </el-dropdown-menu>
              </el-dropdown>
            </el-menu-item>
          </el-menu>
        </el-header>
        <el-main style="background-color: #f3f9f6">
          <div class="left_main_content">
            <el-tabs v-model="activeName" @tab-click="handleClick">
              <el-tab-pane label="全部" name="first">
                <div class="left_main_content_child" v-for="item in msgs">
                  <h1 style="font-size: 16px;margin-bottom: 3%;">{{item.title}}</h1>
<!--                  <div class="left_main_content_child_msg">-->
                    <span style="padding-right: 0"><el-avatar :src="circleUrl" @error="errorHandler" size="small" style="float: left"></el-avatar></span>
                    <span class="left_main_content_child_spanStyleTwo">{{item.username}}</span>
                    <span class="left_main_content_child_spanStyleThreeToSix">
                      <label>时间:</label>
                      <span> {{item.postdate}}</span>
                    </span>
                    <span class="left_main_content_child_spanStyleThreeToSix">
                      <label>学校:</label>
                      <span> 成都信息工程大学</span>
                    </span>
                    <span class="left_main_content_child_spanStyleThreeToSix">
                      <label>班级:</label>
                      <span> 计应174</span>
                    </span>
                    <span class="left_main_content_child_spanStyleThreeToSix">
                        <label>浏览:</label>
                        <span> {{item.views}}</span>
                      </span>
<!--                  </div>-->
                </div>
                <div>
                <el-pagination
                          background
                          layout="prev, pager, next"
                          :total="total"
                          style="color: #ffffff"
                          :page-size="10"
                          @current-change="page">
                  </el-pagination>
                </div>
              </el-tab-pane>
              <el-tab-pane label="热门" name="second">配置管理</el-tab-pane>
              <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
              <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
            </el-tabs>
          </div>
          <div class="right_main_content">
            <el-button type="primary" icon="el-icon-edit" size="medium" style="width: 100%;">发布帖子</el-button>
            <div class="right_main_content_child_one">
              <i class="el-icon-s-data" style="font-size: 14px"><b> 统计信息</b></i>
              <p>用户数:1555人</p>
              <p>帖子数:1000个</p>
              <p>回复数:1000条</p>
              <p>班级数:1000个</p>
              <p>学校数:1000个</p>
            </div>
          </div>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        total: null,
        activeIndex: '1',
        msgs:null,
        messages:1,
        values:1,
        input: '',
        activeName: 'first',
        // circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        circleUrl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
      };
    },
    methods: {
      page(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/main/findAll/'+currentPage+'/10').then(function (resp) {
          _this.msgs = resp.data;
        })
      },
      toSchool(){
        this.$router.push('/test');
      },
      toHomePage(){
        this.$router.push('/main');
      },
      edit() {
        alert(this.input)
      },
      errorHandler() {
        this.circleUrl = "https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"
        return true
      },
      search() {
        alert(this.state)
      },
      handleClick(tab, event) {
        console.log(tab, event);
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/main/findAll/1/10').then(function (resp) {
        _this.msgs = resp.data;
      })
      axios.get('http://localhost:8181/main/findAllPages').then(function (resp) {
        _this.total = resp.data;
      })
      alert(this.$route.query.username);
    }
  }
</script>

<style scoped>
  .navigation{
    width: 100%;
    position: absolute;
    top:0;
    left: 0;
  /*  top,left实现容器的铺满*/
  }
  .navigation>.el-container,.el-header{
    padding: 0;
    margin: 0;
    width: 100%;
  }
  /*去除每个元素的下划线*/
  .el-menu--horizontal > .el-menu-item {
    border-bottom: none;
    margin-right: 10px;
    font-size: 15px;
    color:rgba(0,0,0,.5) !important;
  }
  /*去除选中选中元素下划线*/
  .el-menu--horizontal > .el-menu-item.is-active {
    border-bottom: none;
    background-color: #ffffff !important;
    color: #409EFF !important;
  }
  /*去除鼠标悬停背景颜色的改变*/
  .el-menu--horizontal>.el-menu-item:hover{
    background-color: #ffffff !important;
    color: #409EFF !important;
  }
  .left_main_content{
    /*background-color:  #ffffff;*/
    width: 55%;
    position: relative;
    margin-left: 12%;
    margin-right: 0;
    float: left;
  }
  .left_main_content_child{
    margin-bottom: 15px;
    padding:2px 0 40px 15px;
    background-color:  #ffffff;
    border-radius: 3%;
  }
  /*.left_main_content_child >.left_main_content_child_msg{*/
  /*  margin-bottom: 10px;*/
  /*  !*border: 1px red solid;*!*/
  /*}*/
  .left_main_content_child >span{
    padding-right: 16px;
    font-size: 10px;
    font-weight: bold;
  }
  .left_main_content_child>.left_main_content_child_spanStyleTwo{
    margin-left: 1%;
    color:rgba(0,0,0,.5);
    cursor: pointer ;
  }
  .left_main_content_child>.left_main_content_child_spanStyleTwo:hover{
    color: #409EFF;
  }
  .left_main_content_child>.left_main_content_child_spanStyleThreeToSix{
    color:rgba(0,0,0,.5) ;
  }
  .right_main_content{
    margin-right: 11%;
    position: relative;
    width: 20%;
    float: right;
  }
  .right_main_content_child_one{
    /*border: 50px red solid;*/
    margin-top: 6%;
    padding: 3% 0 1% 3%;
    background-color: #ffffff;
  }
  .right_main_content_child_one>p{
    padding-left: 3%;
  }
</style>