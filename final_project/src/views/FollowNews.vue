<template>
  <div>
    <div class="navigation">
      <el-container>
        <el-header>
          <el-menu class="el-menu-demo" mode="horizontal" style="background-color: #ffffff">
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
                  <el-dropdown-item><i class="el-icon-message-solid"></i>我的消息<el-badge :value="messages" :max="99" class="item"></el-badge></el-dropdown-item>
                  <el-dropdown-item><i class="el-icon-s-promotion"></i><router-link target="_blank" :to="{path:'/Login'}" style="text-decoration:none;outline: none;color: #000;">关注动态</router-link><el-badge :value="values" :max="99" class="item"></el-badge></el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </el-menu-item>
          </el-menu>
        </el-header>
            <el-main style="background-color: #f3f9f6;">
              <div class="left_main_content">
                <div class="left_main_content_child">
                  <div class="left_main_content_child_one" v-for="item in msgs" style="margin-bottom: 1%;height: auto;padding-bottom: 2%">
                    <!--头像-->
                    <div style="margin-left:2%;padding-top: 3%;float: left;">
                      <el-avatar :src="circleUrl" @error="errorHandler" :size="45">
                      </el-avatar>
                    </div>
                    <!--用户名-->
                    <div style="margin:0 0 0 12%;padding-top:3px;width: 50%;">
                      <h4 style="margin-bottom: 0">Dongdong </h4>
                      <span style="font-size: 8px;color:rgba(0,0,0,.5);margin-right: 2%">成都信息工程大学</span>
                      <span style="font-size: 8px;color:rgba(0,0,0,.5);margin-right: 2%">计应174</span>
                      <span style="font-size: 8px;color:rgba(0,0,0,.5);">2020/1/20 14:50</span>
                    </div>
                    <!--内容-->
                    <div style="margin:2% 0 0 12%;font-size: 15px">
                      {{item.content}}
                    </div>
                    <el-divider></el-divider>
                    <!--点赞，评论，转发-->
                    <div>
                      <ul style="text-decoration: none;margin: 0;padding: 0">
                        <li style="display: inline-block;margin:0 10% 0 14%;width: 7%">
                          <div class="left_main_content_child_one_dpz">
                            <i id="dianzan" class="iconfont icondianzan1" @click="likes"> {{num}}</i>
                          </div>
                        </li>
                        <el-divider direction="vertical"></el-divider>
                        <li style="display: inline-block;margin:0 10% 0 14%;width: 7%">
                          <div class="left_main_content_child_one_dpz"><i class="el-icon-chat-round" @click="show"> 1</i></div>
                        </li>
                        <el-divider direction="vertical"></el-divider>
                        <li style="display: inline-block;margin:0 12%;width: 7%">
                          <!-- 转发前要有个空格-->
                          <div class="left_main_content_child_one_dpz"><i class="el-icon-share"> 1</i></div>
                        </li>
                      </ul>
                    </div>
                    <el-divider></el-divider>
                    <div style="height: auto">
                      <div style="margin-left:2%;padding-top: 3%;">
                        <el-avatar :src="circleUrl" @error="errorHandler" :size="45">
                        </el-avatar>
                      </div>
                      <div class="div2">
                      </div>
                    </div>
                  </div>
                  <!--文本编辑器 wangEditor-->
                  <div id="div1"></div>
                  <button @click="submit">提交</button>
                  <button @click="clearall">清空</button>
                </div>
              </div>
              <div class="right_main_content">
                <div class="right_main_content_child_one">
                  <div style="height: 60px">
                    <div style="margin-left:5%;padding-top: 5%;float: left;clear: both">
                      <el-avatar :src="circleUrl" @error="errorHandler" :size="55">
                      </el-avatar>
                    </div>
                    <div style="margin:0 0 0 30%;padding-top:2px;width: 50%;">
                      <h4>森林里的麋鹿</h4>
                    </div>
                </div>
                  <el-divider></el-divider>
                  <div style="height: 50px">
                    <ul style="text-decoration: none;padding-left: 0">
                      <li style="display: inline-block;margin:0 10% 0 8%">
                        <div style="color:rgba(0,0,0,.5)">动态</div>
                        <div style="padding-left:34%">2</div>
                      </li>
                      <li style="display: inline-block;margin:0 10% 0 10%">
                        <div style="color:rgba(0,0,0,.5)">关注</div>
                        <div style="padding-left:34%">2</div>
                      </li>
                      <li style="display: inline-block;margin:0 0 0 10%">
                        <div style="color:rgba(0,0,0,.5)">关注者</div>
                        <div style="padding-left:34%">2</div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
          </el-main>
          <el-footer>Footer</el-footer>
      </el-container>
    </div>
  </div>
</template>

<script>
  import E from 'wangeditor';
  const editor1 = new E('#div1');
  const editor2 = new E('.div2');
  editor1.config.height = 300;
  editor1.config.focus = false;
  editor1.config.uploadImgServer = '/upload-img';  //图片接口地址
  editor1.config.uploadVideoServer = '/api/upload-video';
  editor1.config.showLinkImgAlt = false;
  editor1.config.showLinkImgHref = false;
  editor1.config.showFullScreen = false;  //配置全屏
  editor1.config.showMenuTooltips = true; //隐藏菜单栏提示
  editor1.config.showLinkImg = false;  //隐藏插入网络图片
  editor1.config.showLinkVideo = false;  //隐藏插入网络视频
  editor1.config.menus = [
    'emoticon',
    'image',
    'video',
    'link'
  ];
  editor2.config.height = 100;
  editor2.config.focus = false;
  editor2.config.uploadImgServer = '/upload-img';  //图片接口地址
  editor2.config.uploadVideoServer = '/api/upload-video';
  editor2.config.showLinkImgAlt = false;
  editor2.config.showLinkImgHref = false;
  editor2.config.showFullScreen = false;  //配置全屏
  editor2.config.showMenuTooltips = true; //隐藏菜单栏提示
  editor2.config.showLinkImg = false;  //隐藏插入网络图片
  editor2.config.showLinkVideo = false;  //隐藏插入网络视频
  editor2.config.menus = [
    'emoticon',
    'image',
    'video',
    'link'
  ];
  export default {
    data() {
      return {
        msgs:[{content:'测试踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩；戳中你的痛楚了么'},{content:'春节申请了加班。反正也不回家，不如赚点钱买ps5'}],
        dialogImageUrl: '',
        dialogVisible: false,
        activeIndex: '1',
        num: 1,
        input: '',
        messages:1,
        values:1,
        flag:0,
        circleUrl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        form:{
          desc:''
        }
      }
    },
    methods: {
      show(){
        editor2.create();
      },
      clearall(){
        editor1.txt.clear();
      },
      submit(){
        alert(editor1.txt.text());
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      onSubmit() {
        console.log('submit!');
      },
      likes(){
        let dianzan = document.getElementById('dianzan');
        if(this.flag == 0){
          this.num++;
          dianzan.style.color = '#409EFF';
          this.flag = 1;
        }else {
          this.num--;
          dianzan.style.color = '';
          this.flag = 0;
        }
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
      // handleSelect(key, keyPath) {
      //     console.log(key, keyPath);
      // },

    },
    mounted() {
      editor1.create();
      // editor2.create();
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
    width: 45%;
    position: relative;
    margin-left: 20%;
    margin-right: 0;
    float: left;
  }
  .left_main_content_child{
    /*border: 1px red solid;*/
    /*background-color:#ffffff ;*/
    margin-bottom: 15px;
    border-radius: 3%;

  }
  .left_main_content_child_one{
   height: 200px;
   background-color: #ffffff;
  }
  .right_main_content{
    margin-right: 16%;
    position: relative;
    width: 18%;
    float: right;
    /*border: 1px red solid;*/
  }
  .right_main_content_child_one{
    background-color: #ffffff;
    /*margin-top: 6%;*/
    /*padding: 3% 0 1% 3%;*/
  }
  .iconfont{
    /*color: #409EFF;*/
  }
  .iconfont:hover{
    color: #409EFF;
  }
  /*虚线  */
  .el-divider--horizontal{
    margin:14px 0;
    padding: 0;
    border-top: 1px dashed #e1e3e5;
    background: 0 0;
  }
  .left_main_content_child_one_dpz{
    font-size: 14px;
    cursor: pointer;
    color:rgba(0,0,0,.5);
  }
  .left_main_content_child_one_dpz:hover{
    color: #409EFF;
  }
</style>