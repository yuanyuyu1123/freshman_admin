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
			<el-aside :width="isCollapse ? '64px':'150px'" class="el-aside">
				<div class="toggle-button" @click="toggleCollapse">|||</div>
				<el-menu background-color="#545c64" text-color="#fff" active-text-color="#409EFF" :collapse="isCollapse" :collapse-transition="false">

					<el-submenu index="1">
						<template slot="title">
							<i class="el-icon-s-custom"></i>
							<span>学生管理</span>
						</template>
						<el-menu-item index="1-1" @click="goStudentCheckIn">
							<template slot="title">
								<i class="el-icon-s-flag"></i>
								<span>学生报到</span>
							</template>
						</el-menu-item>

						<el-menu-item index="1-2" @click="goStudentPayment">
							<template slot="title">
								<i class="el-icon-coin"></i>
								<span>缴费情况</span>
							</template>
						</el-menu-item>

						<el-menu-item index="1-3" @click="goStudentDorm">
							<template slot="title">
								<i class="el-icon-school"></i>
								<span>住宿情况</span>
							</template>
						</el-menu-item>

						<el-menu-item index="1-4" @click="goStudentAccount">
							<template slot="title">
								<i class="el-icon-user"></i>
								<span>学生账号</span>
							</template>
						</el-menu-item>

						</el-submenu>

						<el-menu-item index="2" @click="goAdmin">
							<i class="el-icon-user-solid"></i>
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
    name: 'AdminMain',
    data(){
      return{
        isCollapse:false
      }
    },
    methods: {
			logout(){
			  window.sessionStorage.clear()
				this.$router.replace('/admin/login')
			},
      toggleCollapse(){
        this.isCollapse=!this.isCollapse
      },
      goStudentCheckIn(){
			  this.$router.push('/admin/main/StudentCheckIn')
      },
      goStudentPayment(){
        this.$router.push('/admin/main/StudentPayment')
      },
      goStudentDorm(){
        this.$router.push('/admin/main/StudentDorm')
      },
      goStudentAccount(){
        this.$router.push('/admin/main/StudentAccount')
      },
      goAdmin(){
        this.$router.push('/admin/main/Admin')
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