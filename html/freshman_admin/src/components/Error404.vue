<template>
  <div class="fullscreen bg-blue text-white text-center q-pa-md flex flex-center">
    <div>
      <div style="font-size: 30vh">
        404
      </div>

      <div class="text-h2" style="opacity:.4">
        糟糕，这里没有内容 <br><br>
        <el-button type="info" @click="goMain">回首页</el-button>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'Error404',
  methods:{
    goMain(){

    }
  }
}
</script>
