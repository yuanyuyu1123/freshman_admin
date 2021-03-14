<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="ruleForm"  status-icon :rules="rules" ref="ruleForm" label-width="100px" class="login-ruleForm">

				<el-form-item label="编号" prop="adminId" >
					<el-input v-model="ruleForm.adminId" placeholder="请输入管理员编号"></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="ruleForm.name" placeholder="请输入姓名"></el-input>
				</el-form-item>

				<el-form-item label="邮箱" prop="mail">
					<el-input v-model="ruleForm.mail" placeholder="请输入邮箱"></el-input>
				</el-form-item>

				<el-form-item label="性别" prop="sex">
					<el-radio-group v-model="ruleForm.sex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="密码" prop="password">
					<el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码(10-19位)"></el-input>
				</el-form-item>

				<el-form-item label="确认密码" prop="checkPassword">
					<el-input type="password" v-model="ruleForm.checkPassword" autocomplete="off" placeholder="请再次输入密码"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
					<el-button @click="resetForm('ruleForm')">重置</el-button>
					<el-button @click="goLogin">去登录</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>
<script>
  export default {
    data() {
      const validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        }else if(value.length<10||value.length>20) {
          callback(new Error('密码长度为10-19个字符'))
        }else {
          if (this.ruleForm.checkPassword !== '') {
            this.$refs.ruleForm.validateField('checkPassword')
          }
          callback()
        }
      }
      const validatePassword2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.ruleForm.password) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      const validateMail = (rule, value, callback)=>{
        let pattern = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
        if (value === '') {
          callback(new Error('请输入邮箱'))
        }else if(!pattern.test(value)) {
          console.log(pattern.test(value))
          callback(new Error('邮箱格式不正确'))
        }else {
          callback()
        }
      }
      return {
        ruleForm: {
          adminId:'',
          name:'',
	        mail:'',
          sex:'男',
          password: '',
          checkPassword: '',
        },
        rules: {
          adminId: [
            { required: true, message: '请输入编号', trigger: 'blur' },
            { min:8,max:8, message: '长度为8位数字', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '请正确输入姓名', trigger: 'blur' }
          ],
	        mail:[
            { required: true, message: '请输入邮箱', trigger: 'blur' },
            { validator: validateMail, message: '请正确输入邮箱', trigger: 'blur' }
	        ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          password: [
            {required:true,message:'请输入密码',trigger:'blur'},
            { validator: validatePassword, trigger: 'blur' }
          ],
          checkPassword: [
            {required:true,message:'请再次输入密码',trigger:'blur'},
            { validator: validatePassword2, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      goLogin(){
        this.$router.push('/admin/login')
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
		width: 450px;
		height: 450px;
		background-color: #fff;
		border-radius: 3px;
		position: absolute;
		left: 50%;
		top:50%;
		transform: translate(-50%,-50%);
	}

	.login-ruleForm{
		position: absolute;
		width: 100%;
		bottom: 0;
		padding-right: 80px;
		box-sizing: border-box;
	}

</style>
