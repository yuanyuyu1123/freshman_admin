<template>
	<el-container class="home-container">
		<el-header>
			<div>
				<i class="el-icon-user-solid"></i>
				<span>新生管理系统</span>
			</div>
			<el-button type="text" @click="goAdminLogin">{{id}}</el-button>
		</el-header>
		<el-main class="main-container">
			<keep-alive>
				<router-view></router-view>
			</keep-alive>
		</el-main>
	</el-container>
</template>

<script>
  export default {
    name: 'Index',
	  data () {
      return {
        id: '我是管理员'
      }
    },
	  methods:{
      goAdminLogin(){
        if(this.id==='我是管理员'){
          this.id='我是学生'
          this.$router.push('/admin/login')
        }else {
          this.id='我是管理员'
          this.$router.push('/student/login')
        }
      }
	  }
  }
</script>

<style type="less" scoped>
	.home-container{
		height: 100%;
	}

	.el-header{
		background-color: #373d41;
		display: flex;
		justify-content: space-between;
		padding-left: 0;
		align-items: center;
		color: #fff;
		font-size: 20px;
		>div{
			display: flex;
			align-items: center;
			span{
				margin-left: 15px;
			}
		}
	}

	.main-container{
		margin: 0;
		padding: 0;
	}

</style>