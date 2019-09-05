<template>
  <div>
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
</template>
<script>
  export default {
    data() {
      return {
        imagesbox: [{
          id: 1,
          src: 'static/assets/快来.png',
        }, {
          id: 2,
          src: 'static/assets/贱笑.jpg',
        }, {
          id: 3,
          src: 'static/assets/阴险.png',
        }],
      }
    },
  }
</script>
<style>
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
    text-indent: 1em;
    text-size: 15px;
    font-color:#475669;
  }
</style>
