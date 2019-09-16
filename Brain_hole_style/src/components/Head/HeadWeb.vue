<template>
  <el-container>
    <el-header>
      <el-menu
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#4a4c4f"
        text-color="#FFD700"
        active-text-color="#ffd04b">
        <el-menu-item index="1" @click="error=success">门面</router-link>
        </el-menu-item>
        <el-submenu index="2">
          <template slot="title">脑洞</template>
          <el-submenu index="2-1">
            <template slot="title">世界观</template>
            <el-menu-item index="2-1-1" @click="error=!success">
              <router-link :to="{name:'World_Fantasy'}">奇幻玄幻</router-link>
            </el-menu-item>
            <el-menu-item index="2-1-2" @click="error=!success">
              <router-link :to="{name:'World_Kungfu'}">武侠仙侠</router-link>
            </el-menu-item>
            <el-menu-item index="2-1-3" @click="error=!success">
              <router-link :to="{name:'World_History'}">历史军事</router-link>
            </el-menu-item>
            <el-menu-item index="2-1-4" @click="error=!success">
              <router-link :to="{name:'World_Urban'}">都市娱乐</router-link>
            </el-menu-item>
            <el-menu-item index="2-1-5" @click="error=!success">
              <router-link :to="{name:'World_Science'}">科幻游戏</router-link>
            </el-menu-item>
          </el-submenu>

          <el-submenu index="2-2">
            <template slot="title">剧情</template>
            <el-menu-item index="2-2-1">奇幻玄幻</el-menu-item>
            <el-menu-item index="2-2-2">武侠仙侠</el-menu-item>
            <el-menu-item index="2-2-3">历史军事</el-menu-item>
            <el-menu-item index="2-2-4">都市娱乐</el-menu-item>
            <el-menu-item index="2-2-5">科幻游戏</el-menu-item>
          </el-submenu>
          <el-submenu index="2-3">
            <template slot="title">等级</template>
            <el-menu-item index="2-3-1">奇幻玄幻</el-menu-item>
            <el-menu-item index="2-3-2">武侠仙侠</el-menu-item>
            <el-menu-item index="2-3-3">历史军事</el-menu-item>
            <el-menu-item index="2-3-4">都市娱乐</el-menu-item>
            <el-menu-item index="2-3-5">科幻游戏</el-menu-item>
          </el-submenu>
          <el-menu-item index="2-4">
            <router-link :to="{name:''}">功法</router-link>
          </el-menu-item>
          <el-menu-item index="2-5">
            <router-link :to="{name:''}">副本</router-link>
          </el-menu-item>
          <el-menu-item index="2-6">
            <router-link :to="{name:''}">装备和道具</router-link>
          </el-menu-item>
          <el-submenu index="2-7">
            <template slot="title">宠物与坐骑</template>
            <el-menu-item index="2-7-1">山海经</el-menu-item>
            <el-menu-item index="2-7-2">变异</el-menu-item>
            <el-menu-item index="2-7-3">四不像(自主创作)</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3">
          <router-link :to="{name:''}">得罪人的榜单</router-link>
        </el-menu-item>
        <el-menu-item index="4">
          <router-link :to="{name:''}">酒馆</router-link>
        </el-menu-item>
        <el-menu-item index="5" v-show="error=!success">
          <router-link :to="{name:'Login'}">个人中心</router-link>
        </el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <div v-show="!error">
        <div>
          <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in imagesbox" :key="item.id">
              <img :src="item.src">
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="d1">
          <h1>脑点子</h1>
          <p><span>让作者不再以没有灵感而太监,欢迎各位书友前来填坑,创造出更好更有趣的书籍</span></p>
        </div>
      </div>
      <div v-show="error">
        <router-view></router-view>
      </div>
    </el-main>
  </el-container>
</template>
<script>
  export default {
    data() {
      return {
        imagesbox: [{
          id: 1,
          src: 'static/assets/快来啊.png',
        }, {
          id: 2,
          src: 'static/assets/贱笑.jpg',
        }, {
          id: 3,
          src: 'static/assets/阴险.png',
        }],
        error: false,
        success: false,
      }
    },
  }
</script>
<style>
  a {
    color: #FFD700;
    text-decoration: none;
  }

  a:hover {
    color: yellow;
  }

  a:active {
    color: red;
  }

  .el-header, .el-footer {
    background-color: #4a4c4f;
    color: #333;
    line-height: 100px;
  }

  .el-main {
    background: url("/static/assets/背景图片1.jpg") no-repeat;
    height: 581px;
    width: 100%;
    text-align: center;
    background-size: cover;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 50px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .d1 {
    color: #F0FFFF;
    /*text-indent: 1em;*/
    text-size: 15px;
    /*font-color:#475669;*/
  }
</style>
