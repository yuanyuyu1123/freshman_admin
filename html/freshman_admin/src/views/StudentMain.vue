<template>
	<el-container  class="home-container">

			<el-header>
				<div>
					<i class="el-icon-user-solid"></i>
					<span>新生管理系统</span>
				</div>
				<el-button type="text" @click="logout">退出登录</el-button>
		</el-header>

		<el-container>
			<el-aside :width="isCollapse ? '64px':'120px'" class="el-aside">
				<div class="toggle-button" @click="toggleCollapse">|||</div>
				<el-menu background-color="#545c64" text-color="#fff" active-text-color="#409EFF" :collapse="isCollapse" :collapse-transition="false">
					<el-menu-item index="1" @click="goHomePage">
						<i class="el-icon-user-solid"></i>
						<span slot="title">首页</span>
					</el-menu-item>
					<el-menu-item index="2" @click="goDorm">
						<i class="el-icon-s-home"></i>
						<span slot="title">宿舍</span>
					</el-menu-item>
					<el-menu-item index="3" @click="goPayment">
						<i class="el-icon-coin"></i>
						<span slot="title">缴费</span>
					</el-menu-item>
					<el-menu-item index="4" @click="goStudentInfo">
						<i class="el-icon-info"></i>
						<span slot="title">我的</span>
					</el-menu-item>
				</el-menu>
			</el-aside>

			<el-main>
				<keep-alive>
					<router-view></router-view>
				</keep-alive>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
  export default {
    name: 'StuMain',
	  data(){
      return{
        isCollapse:false
      }
	  },
    methods: {
      goHomePage(){
        this.$router.push('/student/main/homePage')
      },
      goDorm(){
        this.$router.push('/student/main/dorm')
      },
      goPayment(){
        this.$router.push('/student/main/payment')
      },
      goStudentInfo(){
        this.$router.push('/student/main/studentInfo')
      },
			logout(){
        localStorage.clear()
				this.$router.replace('/student/login')
			},
      toggleCollapse(){
        this.isCollapse=!this.isCollapse
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
		padding-left: 10px;
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

	.el-aside {
		background-color: #545c64;
		color: #333;
		text-align: left;
		line-height: 200px;
		.el-menu{
			border-right: none;
		}
	}

	.el-main {
		background-color: #E9EEF3;
		color: #333;
		text-align: center;
		line-height: 160px;
	}

	.main-container{
		padding: 0;
	}

	.toggle-button{
		background-color: #4A5064;
		font-size: 10px;
		line-height: 24px;
		color: #fff;
		text-align: center;
		letter-spacing: 0.2em;
		cursor:pointer;
	}

</style>