<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="ruleForm"  :rules="rules" ref="ruleForm" label-width="100px" class="login-ruleForm">

				<el-form-item label="编号" prop="adminId" >
					<el-input v-model="ruleForm.adminId" placeholder="管理员编号" ></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="ruleForm.name" placeholder="请输入姓名"></el-input>
				</el-form-item>


				<el-form-item label="密码" prop="password">
					<el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码(10-19位)"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
					<el-button @click="resetForm('ruleForm')">重置</el-button>
					<el-button @click="goRegister">去注册</el-button>
					<el-button @click="forgetPassword" type="text">忘记密码</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>
<script>
  export default {
    name:'AdminLogin',
    data() {
      const validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        } else if(value.length<10||value.length>20){
          callback(new Error('密码长度为10-19个字符'))
        } else {
          callback()
        }
      }
      return {
        ruleForm: {
          adminId:'',
          name:'',
          password: '',
        },
        rules: {
          adminId: [
            { required: true, message: '请输入管理员编号', trigger: 'blur' },
            { min:8,max:8, message: '长度为8位数字', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '请正确输入姓名', trigger: 'blur' }
          ],
          password: [
            {required:true,message:'请输入密码',trigger:'blur'},
            { validator: validatePassword, trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push('/admin/main')
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      goRegister(){
        this.$router.push('/admin/register')
      },
      forgetPassword(){

      }
    }
  }
</script>

<style type="less" scoped>
	.login_container{
		background-color: #324057;
		height: 100%;
	}
	.login-box{
		width: 550px;
		height: 270px;
		background-color: #fff;
		border-radius: 3px;
		position: absolute;
		left: 50%;
		top:50%;
		transform: translate(-50%,-50%);
	}

	.login-ruleForm{
		position: absolute;
		top:20px;
		bottom: 20px;
		width: 100%;
		padding-right: 80px;
		box-sizing: border-box;
	}

</style>
