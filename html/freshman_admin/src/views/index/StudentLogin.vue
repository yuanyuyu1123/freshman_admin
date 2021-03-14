<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="StudentParam"  :rules="rules" ref="StudentParam" label-width="100px" class="login-ruleForm">

				<el-form-item label="学号" prop="stuId" >
					<el-input v-model="StudentParam.stuId" placeholder="请输入学号"></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="StudentParam.name" placeholder="请输入姓名"></el-input>
				</el-form-item>


				<el-form-item label="密码" prop="password">
					<el-input type="password" v-model="StudentParam.password" autocomplete="off" placeholder="请输入密码"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="submitForm('StudentParam')">登录</el-button>
					<el-button @click="resetForm('StudentParam')">重置</el-button>
					<el-button @click="goRegister">去注册</el-button>
					<el-button @click="forgetPassword" type="text">忘记密码</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>
<script>
  import axios from 'axios'

  export default {
    name:'studentLogin',
    data() {
      const validatorStuId=(rule, value, callback)=>{
        const pattern=/^(21)\d{6}$/;
        if(pattern.test(value)){
          callback()
        }else {
          callback(new Error('请正确输入学号'))
        }
      }
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
        StudentParam: {
          stuId:'',
          name:'',
          password: '',
        },
        rules: {
          stuId: [
            { required: true, message: '请输入学号', trigger: 'blur' },
            { validator:validatorStuId, trigger: 'blur' }
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
            axios.post('/student/login',{
              stuId:this.StudentParam.stuId,
              name:this.StudentParam.name,
              password:this.StudentParam.password
            }).then((res)=>{
              if(res.data.code==='200'){
                this.$router.push('/student/main')
                //全局存储token
                window.localStorage["token"] = JSON.stringify(res.data.data);
              }else {
                this.$message.error(res.data.msg);
              }
            })
              .catch(error=>{
                this.$message.error('数据出错了...')
                return false
              })

          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      goRegister(){
				this.$router.push('/student/register')
      },
      forgetPassword(){
        this.$alert('请联系管理员', '忘记密码', {
          confirmButtonText: '确定'
        });
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
